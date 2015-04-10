package com.hongkailiu.test.testjenkins.listener;

import akka.actor.ActorRef;
import com.hongkailiu.test.testjenkins.MyAkkaPluginApi;
import com.hongkailiu.test.testjenkins.MyMessage;
import hudson.Extension;
import hudson.model.Item;
import hudson.model.listeners.ItemListener;
import lombok.extern.log4j.Log4j2;

/**
 * Created by ehongka on 4/9/15.
 */
@Extension
@Log4j2 public class AkkaItemListener extends ItemListener {

    @Override
    public void onCreated(Item item) {
        super.onCreated(item);
        log.info("AkkaItemListener: ============onCreated===========");
        ActorRef actorRef = MyAkkaPluginApi.getInstance().getItemListenerActorRef();
        actorRef.tell(MyMessage.ITEM_ON_CREATED, MyAkkaPluginApi.getInstance().getMyAkkaPluginActorRef());
    }

    @Override
    public void onDeleted(Item item) {
        super.onDeleted(item);
        ActorRef actorRef = MyAkkaPluginApi.getInstance().getItemListenerActorRef();
        actorRef.tell(MyMessage.ITEM_ON_DELETED, MyAkkaPluginApi.getInstance().getMyAkkaPluginActorRef());
    }

    @Override
    public void onRenamed(Item item, String oldName, String newName) {
        super.onRenamed(item, oldName, newName);
        ActorRef actorRef = MyAkkaPluginApi.getInstance().getItemListenerActorRef();
        actorRef.tell(MyMessage.ITEM_ON_RENAMED, MyAkkaPluginApi.getInstance().getMyAkkaPluginActorRef());
    }

    @Override
    public void onCopied(Item src, Item item) {
        super.onCopied(src, item);
        ActorRef actorRef = MyAkkaPluginApi.getInstance().getItemListenerActorRef();
        actorRef.tell(MyMessage.ITEM_ON_COPIED, MyAkkaPluginApi.getInstance().getMyAkkaPluginActorRef());
    }
}
