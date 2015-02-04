package com.hongkailiu.test.app.thread;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreadTest {
	
	private final static int PRODUCER_NO = 3;
	private final static int CONSUMER_NO = 2;
	
	private final static int SIZE = 10;
	private final static List<Integer> queue = new ArrayList<Integer>();
			
	private final static Set<Thread> threads = new HashSet<Thread>(PRODUCER_NO+CONSUMER_NO);

	public static void main(String[] args) {
		System.out.println("main");
		Thread t = null;
		for (int i=0;i<PRODUCER_NO;i++){
			t=new Thread(new Producer(""+i, queue, SIZE));
			threads.add(t);
		}
		for (int i=0;i<CONSUMER_NO;i++){
			t=new Thread(new Consumer(""+i, queue));
			threads.add(t);
		}
		for (Thread thread : threads){
			thread.start();
		}
	}

}
