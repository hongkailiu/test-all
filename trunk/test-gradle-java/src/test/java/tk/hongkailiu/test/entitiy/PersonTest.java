package tk.hongkailiu.test.entitiy;

import org.junit.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by ehongka on 4/6/16.
 */
public class PersonTest {

    private Person unitUnderTest;

    @Before public void setup(){
        unitUnderTest = new Person();
    }

    @Test public void testGetFirstname() throws Exception {
        unitUnderTest.print();
    }

    @Test
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        Assert.assertEquals(1, 1);
    }
}
