package com.wenmq.thread.production.impl;

import com.wenmq.thread.production.inter.AbstractConsumer;
import com.wenmq.thread.production.inter.AbstractProducer;
import com.wenmq.thread.production.inter.Consumer;
import com.wenmq.thread.production.inter.Model;
import com.wenmq.thread.production.inter.Producer;
import com.wenmq.thread.production.inter.Task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueModel implements Model {

    private final BlockingQueue<Task> queue;
    private final AtomicInteger increTaskNo = new AtomicInteger(0);

    public BlockingQueueModel(int cap) {
        // LinkedBlockingQueue 的队列不 init，入队时检查容量；ArrayBlockingQueue 在创建时 init
        this.queue = new LinkedBlockingDeque<>(cap);
    }

    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }

    @Override
    public Runnable newRunnableProducer() {
        return new ProduceImpl();
    }

    private class ConsumerImpl extends AbstractConsumer implements Consumer, Runnable {

        @Override
        public void consume() throws InterruptedException {
            Task task = queue.take();
            // 固定时间范围的消费，模拟相对稳定的服务器处理过程
            Thread.sleep(500 + (long) (Math.random() * 500));
            System.out.println("consume :" + task.no);
        }
    }


    private class ProduceImpl extends AbstractProducer implements Producer, Runnable {

        @Override
        public void produce() throws InterruptedException {
            // 不定期生产，模拟随机的用户请求
            Thread.sleep((long) (Math.random() * 1000));
            Task task = new Task(increTaskNo.getAndIncrement());
            System.out.println("produce :" + task.no);
            queue.put(task);
        }
    }


    public static void main(String[] args) {
        Model model = new BlockingQueueModel(3);
        for (int i = 0; i < 2; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
}
