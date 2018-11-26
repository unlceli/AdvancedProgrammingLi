package com.example.li.lll.advancedprogrammingli.ProdcucerandConsumer37;

import java.security.PublicKey;

public class ProdcucerandConsumer {
    public static void main(String[] args) {
        Message message = new Message();
        new Thread(new Producer(message)).start();
        ;
        new Thread(new Consumner(message)).start();
        ;

    }
}

class Producer implements Runnable {
    private Message msg;

    public Producer(Message message) {
        this.msg = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                this.msg.set("li", "wudi");

            } else {

                this.msg.set("张", "buwudi");
            }
        }
    }
}

class Consumner implements Runnable {
    private Message msg;

    public Consumner(Message message) {
        this.msg = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            System.out.println(this.msg.get());

        }
    }
}

class Message {
    private String tiitle;
    private String content;
//flag  true表示可以生产，但是不能消费取走
//flag false 表示生产完毕，可以让消费者取走

    private boolean flag =true;  //初始化为可以生产

    public synchronized void set(String tiitle, String content) {

        if (flag== false){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.tiitle = tiitle;
        this.content = content;

        this.flag =false;
        super.notify();  //生产完毕，唤醒沉睡的线程。
    }

    public synchronized String get() {
        if (flag ==true){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {

            return this.tiitle + "-----" + this.content;
        }finally {   //不管咋样，都要执行
            this.flag =true;
            try {
                super.notify();//唤醒生产县城。
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}