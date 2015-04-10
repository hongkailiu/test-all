package com.hongkailiu.test.testjenkins.actor;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import com.hongkailiu.test.testjenkins.MyMessage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

import static org.junit.Assert.*;

/**
 * Created by hongkailiu on 2015-04-09.
 */
public class RunListenerActorTest {

    static ActorSystem system;

    @BeforeClass
    public static void setUpBC() throws Exception {
        system = ActorSystem.create();
    }

    @AfterClass
    public static void tearDownAC() throws Exception {
        system.shutdown();
        system = null;
    }

    @Test
    public void testOnReceive() throws Exception {

        final Props props = Props.create(RunListenerActor.class);
        final TestActorRef<RunListenerActor> ref = TestActorRef.create(system, props, "testB");
        final Future<Object> future = akka.pattern.Patterns.ask(ref, MyMessage.RUN_ON_DELETED, 3000);
        assertTrue(future.isCompleted());
        assertEquals(MyMessage.DONE, Await.result(future, Duration.Zero()));

        final Future<Object> future1 = akka.pattern.Patterns.ask(ref, MyMessage.RUN_ON_DELETED, 3000);
        assertTrue(future1.isCompleted());
        assertNotEquals(MyMessage.START, Await.result(future, Duration.Zero()));
    }
}