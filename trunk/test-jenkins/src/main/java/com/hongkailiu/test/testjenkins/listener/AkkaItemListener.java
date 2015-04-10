package com.hongkailiu.test.testjenkins.listener;

import akka.actor.ActorRef;
import com.hongkailiu.test.testjenkins.MyAkkaPluginApi;
import com.hongkailiu.test.testjenkins.MyMessage;
import hudson.Extension;
import hudson.model.Item;
import hudson.model.listeners.ItemListener;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

/**
 * Created by ehongka on 4/9/15.
 */
@Extension
@Log4j2 public class AkkaItemListener extends ItemListener {

    @Getter
    @Setter
    private ActorRef itemListenerActorRef = MyAkkaPluginApi.getInstance().getItemListenerActorRef();

    @Getter
    @Setter
    private ActorRef myAkkaPluginActorRef = MyAkkaPluginApi.getInstance().getMyAkkaPluginActorRef();

    @Override
    public void onCreated(Item item) {
        super.onCreated(item);
        //log.info("AkkaItemListener: ============onCreated===========");
        itemListenerActorRef.tell(MyMessage.ITEM_ON_CREATED, myAkkaPluginActorRef);
    }

    @Override
    public void onDeleted(Item item) {
        super.onDeleted(item);
        itemListenerActorRef.tell(MyMessage.ITEM_ON_DELETED, myAkkaPluginActorRef);
    }

    @Override
    public void onRenamed(Item item, String oldName, String newName) {
        super.onRenamed(item, oldName, newName);
        itemListenerActorRef.tell(MyMessage.ITEM_ON_RENAMED, myAkkaPluginActorRef);
    }

    @Override
    public void onCopied(Item src, Item item) {
        super.onCopied(src, item);
        itemListenerActorRef.tell(MyMessage.ITEM_ON_COPIED, myAkkaPluginActorRef);
    }
}
