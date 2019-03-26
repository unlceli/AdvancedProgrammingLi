package com.example.li.lll.advancedprogrammingli.okhttpdemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程控制
 */
public class ThreadPoolManager {

    private static ThreadPoolManager threadPoolManager = new ThreadPoolManager();

    public static ThreadPoolManager getInstance() {
        return threadPoolManager;
    }

    // 这种队列按找FiFO 先进先出的排序元素
    //x 新原色插入时候自动到队列尾部。
    private LinkedBlockingDeque<Runnable> mQueue = new LinkedBlockingDeque<>();

    //将异步任务添加到队列尾部

    public void addTask(Runnable runnable) {
        if (runnable != null) {
            mQueue.add(runnable);
        }
    }

    //创建线程池，
    private ThreadPoolExecutor mThreadPoolExecutor;

    private ThreadPoolManager() {
        mThreadPoolExecutor = new ThreadPoolExecutor(3, 10, 15, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(4), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                //如果该线程执行异常，进行添加到线程进行执行。
                addTask(r);
            }
        });

        //在线程池中直接执行 核心线程。
        mThreadPoolExecutor.execute(coreThread);
    }

    //创建核心线程

    //不停的回去列队中的请求。
    public Runnable coreThread = new Runnable() {

        Runnable runn = null;

        @Override
        public void run() {
            while (true) {
                try {
                    //队列中取
                    runn = mQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mThreadPoolExecutor.execute(runn);
            }
        }
    };

}
