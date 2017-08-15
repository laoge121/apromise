package com.laoge.apromise.service.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yuhou on 2017/8/15.
 */
public class ReentrantLockTest {

    public void test1() {
        ReentrantLock reentrantLock = new ReentrantLock();

        reentrantLock.lock();
        try {


            System.out.print(">>>>>.test");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            reentrantLock.unlock();

        }
    }

    public static void main(String[] args) {
        new ReentrantLockTest().test1();
    }
}
