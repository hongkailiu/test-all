package com.hongkailiu.test.testjenkins.listener;

import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import com.hongkailiu.test.testjenkins.MyAkkaPluginApi;
import com.hongkailiu.test.testjenkins.actor.ItemListenerActor;
import com.hongkailiu.test.testjenkins.actor.MyAkkaPluginActor;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by ehongka on 4/9/15.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(MyAkkaPluginApi.class)
@PowerMockIgnore( {"javax.management.*"})
public class AkkaItemListenerTest {

    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Mock
    MyAkkaPluginApi api;

    TestActorRef<ItemListenerActor> ref1;
    TestActorRef<MyAkkaPluginActor> ref2;

    @Test
    public void testOnCreated() throws Exception {

    }

    @Test
    public void testOnDeleted() throws Exception {

        mockStatic(MyAkkaPluginApi.class);
        when(MyAkkaPluginApi.getInstance()).thenReturn(api);
        when(api.getItemListenerActorRef()).thenReturn(ref1);
        when(api.getMyAkkaPluginActorRef()).thenReturn(ref2);

        AkkaItemListener listener = new AkkaItemListener();
        listener.onDeleted(null);

        verify(api,times(1)).getItemListenerActorRef();
        verify(api).getMyAkkaPluginActorRef();
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

    }

    @After
    public void tearDown() throws Exception {
    }
}