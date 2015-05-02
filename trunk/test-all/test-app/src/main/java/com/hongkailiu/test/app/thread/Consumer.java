package com.hongkailiu.test.app.thread;

import com.hongkailiu.test.app.util.MathUtil;
import lombok.extern.log4j.Log4j;

import java.util.List;

@Log4j public class Consumer implements Runnable {

    private String name;
    private List<Integer> queue;

    public Consumer(String name, List<Integer> queue) {
        super();
        this.name = name;
        this.queue = queue;
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

    @Override public void run() {
        try {
            while (true) {
                Thread.sleep(MathUtil.random(100));
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        queue.wait();
                    }
                    Integer e = queue.remove(0);
                    System.out.println("consumer " + name + ": " + e);
                    queue.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            log.error(e);
        }
    }

}
