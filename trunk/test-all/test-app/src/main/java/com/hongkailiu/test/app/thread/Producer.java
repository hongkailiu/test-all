package com.hongkailiu.test.app.thread;

import com.hongkailiu.test.app.util.MathUtil;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j public class Producer implements Runnable {

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
                    while (queue.size()==size) {
                        queue.wait();
                    }
                    Integer e = new Integer(MathUtil.random(Integer.MAX_VALUE));
                    queue.add(e);
                    log.info("producer " + name + ": " + e);
                    queue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            log.error(e);
        }

    }

}
