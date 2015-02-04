package com.hongkailiu.test.app.collection;

import org.junit.Test;

public class MyListElemTest {

	@Test
	public void testRemoveAll() {
		
		MyListElem elem = null;
		System.out.println("elem: " + elem);
		elem = new MyListElem(3);
		elem.next = new MyListElem(2);
		elem.next.next = new MyListElem(3);
		elem.next.next.next = new MyListElem(1);
		elem.next.next.next.next = new MyListElem(3);
		
		System.out.println("elem: " + elem);
		elem = MyListElem.removeAll(elem, 3);
		System.out.println("elem: " + elem);
	}

}
