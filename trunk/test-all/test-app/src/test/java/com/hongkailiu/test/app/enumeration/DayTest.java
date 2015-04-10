package com.hongkailiu.test.app.enumeration;

import com.hongkailiu.test.app.gson.TestGson;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DayTest {
	
	static Logger logger = Logger.getLogger(TestGson.class);
	
	Day day;
	
	@Before
	public void setup(){
		day =  Day.MONDAY;
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		
		assertEquals(day, Day.MONDAY);
		tellItLikeItIs();
		
		day = Day.valueOf("FRIDAY");
		tellItLikeItIs();
	}
	
	public void tellItLikeItIs() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;
                    
            case FRIDAY:
                System.out.println("Fridays are better.");
                break;
                         
            case SATURDAY: case SUNDAY:
                System.out.println("Weekends are best.");
                break;
                        
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }

    @Test
    public void testToString() {
       System.out.print("aaa: " + Day.FRIDAY);
    }

}
