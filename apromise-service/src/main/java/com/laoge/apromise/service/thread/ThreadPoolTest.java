package com.laoge.apromise.service.thread;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 注意用于thread的测试
 * Created by yuhou on 2017/8/16.
 */
public class ThreadPoolTest {

    /**
     * boolean	awaitTermination(long timeout, TimeUnit unit)
     * 请求关闭、发生超时或者当前线程中断，无论哪一个首先发生之后，都将导致阻塞，直到所有任务完成执行。
     * <p>
     * <T> List<Future<T>>	invokeAll(Collection<? extends Callable<T>> tasks)
     * 执行给定的任务，当所有任务完成时，返回保持任务状态和结果的 Future 列表。
     * <p>
     * <T> List<Future<T>>	invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
     * 执行给定的任务，当所有任务完成或超时期满时（无论哪个首先发生），返回保持任务状态和结果的 Future 列表。
     * <p>
     * <T> T	invokeAny(Collection<? extends Callable<T>> tasks)
     * 执行给定的任务，如果某个任务已成功完成（也就是未抛出异常），则返回其结果。
     * <p>
     * <T> T	invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
     * 执行给定的任务，如果在给定的超时期满前某个任务已成功完成（也就是未抛出异常），则返回其结果。
     * <p>
     * boolean	isShutdown()
     * 如果此执行程序已关闭，则返回 true。
     * <p>
     * boolean	isTerminated()
     * 如果关闭后所有任务都已完成，则返回 true。
     * <p>
     * void	shutdown()
     * 启动一次顺序关闭，执行以前提交的任务，但不接受新任务。
     * <p>
     * List<Runnable>	shutdownNow()
     * 试图停止所有正在执行的活动任务，暂停处理正在等待的任务，并返回等待执行的任务列表。
     * <p>
     * <T> Future<T>	submit(Callable<T> task)
     * 提交一个返回值的任务用于执行，返回一个表示任务的未决结果的 Future。
     * <p>
     * Future<?>	submit(Runnable task)
     * 提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future。
     * <p>
     * <T> Future<T>	submit(Runnable task, T result)
     * 提交一个 Runnable 任务用于执行，并返回一个表示该任务的 Future。
     */

    private static final Logger logger = LoggerFactory.getLogger(ThreadPoolTest.class);

    //创建一个固定大小的线程池
    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2 * Runtime.getRuntime().availableProcessors(), 2 * Runtime.getRuntime().availableProcessors(),
            0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), new ApromiseThreadFactory("threadPool-test"));

    //如上线程创建备注可以支持
    //private static final ExecutorService threadService = Executors.newFixedThreadPool(2 * Runtime.getRuntime().availableProcessors(), new ApromiseThreadFactory("threadPool-test"));

    /**
     * 执行列表数据
     *
     * @param list
     */
    public void executeAllList(List<String> list) {

        List<Callable<Map<String, Object>>> paramList = Lists.newArrayList();

        for (String str : list) {
            paramList.add(new Callable<Map<String, Object>>() {
                @Override
                public Map<String, Object> call() throws Exception {
                    Thread.sleep(500);
                    //进行具体的业务处理
                    logger.error(">>>>>>>>>>>>>>>>>>>。{}", str);
                    Map<String, Object> retMap = Maps.newHashMap();
                    retMap.put(str, str);

                    return retMap;
                }
            });
        }

        try {
            List<Future<Map<String, Object>>> retList = threadPoolExecutor.invokeAll(paramList, 5000l, TimeUnit.MILLISECONDS);

            for (Future<Map<String, Object>> future : retList) {
                Map<String, Object> map = future.get(500L, TimeUnit.MILLISECONDS);
                logger.info(">>>.data >>>>{}", map);
            }
        } catch (InterruptedException e) {
            logger.error("<<<<<<<<<<<<<<InterruptedException>>>>>>>>>>>>>>>。{}", e);
        } catch (ExecutionException e) {
            logger.error("<<<<<<<<<<<<<<ExecutionException>>>>>>>>>>>>>。{}", e);
        } catch (TimeoutException e) {
            logger.error("<<<<<<<<<<<<<<TimeoutException>>>>>>>>>>>>>。{}", e);

        }

    }

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("bb");
        list.add("aa");
        list.add("cc");
        list.add("dd");
        list.add("ee");

        new ThreadPoolTest().executeAllList(list);
    }

}
