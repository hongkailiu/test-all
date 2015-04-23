package com.hongkailiu.test.app.thread;

import com.hongkailiu.test.app.util.MathUtil;

import java.util.List;

public class Producer implements Runnable {

    private String name;
    private List<Integer> queue;
    private int size;

    public Producer(String name, List<Integer> queue, int size) {
        super();
        this.name = name;
        this.queue = queue;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getQueue() {
        return queue;
    }

    public void setQueue(List<Integer> queue) {
        this.queue = queue;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override public void run() {
        try {
            while (true) {
                Thread.sleep(MathUtil.random(100));
                synchronized (queue) {
                    while (queue.size() == size) {
                        queue.wait();
                    }
                    Integer e = new Integer(MathUtil.random(Integer.MAX_VALUE));
                    queue.add(e);
                    System.out.println("producer " + name + ": " + e);
                    queue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
