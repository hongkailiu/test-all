package com.hongkailiu.test.testjenkins.listener;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import com.hongkailiu.test.testjenkins.MyMessage;
import com.hongkailiu.test.testjenkins.actor.ItemListenerActor;
import com.hongkailiu.test.testjenkins.actor.MyAkkaPluginActor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ehongka on 4/9/15.
 */

public class AkkaItemListenerTest {

   // @Rule
   // public TemporaryFolder tmpFolder = new TemporaryFolder();


    TestActorRef<ItemListenerActor> ref1;

    TestActorRef<MyAkkaPluginActor> ref2;

    // spy not working
    TestActorRef<ItemListenerActor> spy;

    //rule1: never mock the class you want to do testing on
    //rule2: only mock the dependencies of the class you want to test
    private AkkaItemListener unitUnderTest;

    @Test
    public void testOnCreated() throws Exception {

    }

    @Test
    public void testOnDeleted() throws Exception {

        assertNotNull(unitUnderTest);
        assertNotNull(unitUnderTest.getItemListenerActorRef());
        assertNotNull(unitUnderTest.getMyAkkaPluginActorRef());

        //doNothing().when(ref1).tell(MyMessage.ITEM_ON_DELETED, ref2);


        unitUnderTest.onDeleted(null);

        assertEquals(MyMessage.ITEM_ON_DELETED, ref1.underlyingActor().getLastMsg());
        //Mockito.verify(spy, Mockito.times(1)).tell(MyMessage.ITEM_ON_DELETED, ref2);
        //verify(spy, times(1)).tell(MyMessage.ITEM_ON_DELETED, ref2);

        //ref1.receive(MyMessage.ITEM_ON_DELETED);
        //ref2.receive(MyMessage.ITEM_ON_DELETED);
    }

    @Test
    public void testOnRenamed() throws Exception {

    }

    @Test
    public void testOnCopied() throws Exception {

    }

    @Before
    public void setUp() throws Exception {

        ActorSystem system = ActorSystem.apply();
        Props props1 = Props.create(ItemListenerActor.class);
        ref1 = TestActorRef.create(system, props1, "testA");

        Props props2 = Props.create(MyAkkaPluginActor.class);
        ref2 = TestActorRef.create(system, props2, "testB");

        unitUnderTest = new AkkaItemListener();
        unitUnderTest.setItemListenerActorRef(ref1);
        unitUnderTest.setMyAkkaPluginActorRef(ref2);

    }

    @After
    public void tearDown() throws Exception {
    }
}