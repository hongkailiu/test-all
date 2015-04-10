package com.hongkailiu.test.testjenkins.actor;

import akka.actor.UntypedActor;
import akka.cluster.Cluster;
import akka.cluster.ClusterEvent;
import akka.cluster.ClusterEvent.MemberEvent;
import akka.cluster.ClusterEvent.MemberRemoved;
import akka.cluster.ClusterEvent.MemberUp;
import akka.cluster.ClusterEvent.UnreachableMember;
import akka.cluster.Member;
import com.hongkailiu.test.testjenkins.message.ForwardedMessage;
import lombok.extern.log4j.Log4j2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ehongka on 4/10/15.
 */
@Log4j2 public class SimpleClusterListener extends UntypedActor {

    //LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    Cluster cluster = Cluster.get(getContext().system());

    private static final String CLUSTER_ACTOR_PATH = "/user/clusterListener";

    private List<Member> members = new ArrayList<Member>();

    //subscribe to cluster changes
    @Override
    public void preStart() {
        //#subscribe
        cluster.subscribe(getSelf(), ClusterEvent.initialStateAsEvents(),
                MemberEvent.class, UnreachableMember.class);
        //#subscribe
    }

    //re-subscribe when restart
    @Override
    public void postStop() {
        cluster.unsubscribe(getSelf());
    }

    @Override
    public void onReceive(Object message) throws IOException, ClassNotFoundException {
        if (message instanceof MemberUp) {
            MemberUp mUp = (MemberUp) message;
            log.info("Member is Up: {}", mUp.member());
            members.add(mUp.member());
        } else if (message instanceof UnreachableMember) {
            UnreachableMember mUnreachable = (UnreachableMember) message;
            log.info("Member detected as unreachable: {}", mUnreachable.member());

        } else if (message instanceof MemberRemoved) {
            MemberRemoved mRemoved = (MemberRemoved) message;
            log.info("Member is Removed: {}", mRemoved.member());
            members.remove(mRemoved.member());
        } else if (message instanceof MemberEvent) {
            // ignore

        } else if (message instanceof ForwardedMessage) {
            sendMessage((ForwardedMessage) message);
        } else if (message instanceof byte[]) {
            //log.debug(Messages.cluster_listener_on_received_bytes_message());
            processMessage((byte[]) message);
        } else {
            unhandled(message);
        }

    }

    /**
     * Messages are <b>only</b> sent from the leader. Member to member sending is not allowed.
     *
     * @param message the forwarded message that carry the message to be sent
     * @throws java.io.IOException if failed to write the message object into bytes array
     */
    private void sendMessage(ForwardedMessage message) throws IOException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = new ObjectOutputStream(bos);
        out.writeObject(message.getMessageContent());
        byte[] msgBytes = bos.toByteArray();

        for (Member member : members) {
            if (allowForward(member, message.getDestAddress())) {
//                log.debug(Messages.cluster_listener_on_received_forward_message_to_member(message,
//                        member.address()));
                getContext().actorSelection(member.address() + CLUSTER_ACTOR_PATH)
                        .tell(msgBytes, getSender());
            }
        }
    }

    private boolean allowForward(Member member, String destAddress) {
        if (destAddress == null) {
            return true;
        } else if (destAddress.equals(member.address().toString())) {
            return true;
        }
        return false;
    }

    /**
     * Messages are processed <b>only</b> by non-leader member.
     *
     * @param message the message object as bytes array
     * @throws java.io.IOException    if failed to read the message object from bytes array
     * @throws ClassNotFoundException if failed to cast the stream object to HajpMessage
     */
    private void processMessage(byte[] message) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bis = new ByteArrayInputStream(message);
        ObjectInput in = new ObjectInputStream(bis);
        String s = (String) in.readObject();
        log.info("==================", s);

    }
}
