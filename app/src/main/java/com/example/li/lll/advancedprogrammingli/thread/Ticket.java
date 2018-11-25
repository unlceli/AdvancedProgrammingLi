package com.example.li.lll.advancedprogrammingli.thread;

/**
 *
 */
public class Ticket {


    private static MyThread myThread;

    public static void main(String [] args){
        myThread = new MyThread();
        new Thread(myThread).start();
        new Thread(myThread).start();
        new Thread(myThread).start();
    }
}


class MyThread  implements Runnable{
    private int ticket= 10;

    public synchronized boolean sale(){
        if (this.ticket >0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +"买票 ，ticket ="+ticket --);
            return true;
        }else {
            System.out.println("票已经卖完");
            return  false;
        }
    }

    @Override
    public void run() {

            while (this.sale()){

            }

    }
}