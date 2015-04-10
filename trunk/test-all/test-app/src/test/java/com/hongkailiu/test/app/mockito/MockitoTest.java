package com.hongkailiu.test.app.mockito;


import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

/**
 * Created by hongkailiu on 2015-04-08.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    private MockitoPerson p;

    private List mockedList;

    private final static String NAME = "hongkai";

    private A a;
    private A spy;

    @Before
    public void setUp() throws Exception {
        //mock creation
        mockedList = mock(List.class);

        //MockitoAnnotations.initMocks(MockitoTest.class);
        when(p.getName()).thenReturn(NAME);


        a = new A();
        spy = spy(a);
        p.setA(spy);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test1() {

        assertNotNull(mockedList);

        //using mock object
        mockedList.add("one");
        mockedList.clear();

        //verification
        verify(mockedList).add("one");
        verify(mockedList).clear();


        verify(mockedList, never()).add("two");
    }

    @Test
    public void test2() {

        assertNotNull(p);

        assertEquals(NAME, p.getName());
    }

    @Test
    @Ignore
    public void testSpy() {
        // not working
        p.onReceive(null);
        //verify(spy).tell();
    }

}
