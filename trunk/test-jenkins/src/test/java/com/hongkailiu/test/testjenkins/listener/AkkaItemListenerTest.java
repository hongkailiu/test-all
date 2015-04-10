package com.hongkailiu.test.testjenkins.listener;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import com.hongkailiu.test.testjenkins.MyAkkaPluginApi;
import hudson.model.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created by ehongka on 4/9/15.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(MyAkkaPluginApi.class)
public class AkkaItemListenerTest {

    private static ActorSystem system;

    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Mock
    private Item item;

    @Mock
    private ActorRef ref;

    @Mock
    private MyAkkaPluginApi api;

    @Test
    public void testOnCreated() throws Exception {

    }

    @Test
    public void testOnDeleted() throws Exception {
        mockStatic(MyAkkaPluginApi.class);
        when(MyAkkaPluginApi.getInstance()).thenReturn(api);
        when(api.getItemListenerActorRef()).thenReturn(ref);
        //doNothing().when(ref).tell(any(Object.class), any(ActorRef.class));

        AkkaItemListener listener = new AkkaItemListener();
        listener.onDeleted(item);

        //verify(ref).tell(any(Object.class), any(ActorRef.class));

    }

    @Test
    public void testOnRenamed() throws Exception {

    }

    @Test
    public void testOnCopied() throws Exception {

    }

    @Before
    public void setUp() throws Exception {
//        system = ActorSystem.apply();
//        Props props = Props.create(ItemListenerActor.class);
//        ref = TestActorRef.create(system, props, "ItemListenerActor");
    }

    @After
    public void tearDown() throws Exception {
    }
}