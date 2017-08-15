package com.laoge.apromise.service.thread;

import java.util.concurrent.locks.StampedLock;

/**
 * 写锁的获得
 * Created by yuhou on 2017/8/15.
 */
public class StampedLockTest {

    private double x, y;

    private final StampedLock stampedLock = new StampedLock();

    /**
     * 写锁的获得
     *
     * @param delx
     * @param dely
     */
    public void move(double delx, double dely) {
        long stamp = stampedLock.writeLock();

        try {
            x += delx;
            y += dely;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    /**
     * 乐观读锁
     *
     * @return
     */
    public double distanceFromOrign() {
        //获取乐观读锁
        long stamp = stampedLock.tryOptimisticRead();

        double a = x, b = y;

        //检测是否有写锁
        if (!stampedLock.validate(stamp)) {
            //没有写锁的发送获取悲观锁
            stamp = stampedLock.readLock();

            try {
                a = x;
                b = y;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }
        return x * y;
    }

    /**
     * 悲观锁测试
     *
     * @param x1
     * @param y1
     */
    public void moveIfAtorigin(double x1, double y1) {
        long stamp = stampedLock.readLock();

        try {
            while (x == 0.0 && y == 0.0) {
                long ws = stampedLock.tryConvertToWriteLock(stamp);
                if (ws != 0l) {//转换填写锁成功那么惊险数据变更
                    stamp = ws;
                    x = x1;
                    y = y1;
                    break;
                } else {//如果没有转换成功那么说明 1.可能有现在持有的写锁,2、获取失败。那么直接阻塞获取写锁
                    stampedLock.unlockRead(stamp);
                    stamp = stampedLock.writeLock();
                }
            }

        } finally {
            stampedLock.unlock(stamp);
        }
    }
}
