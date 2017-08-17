package com.laoge.apromise.service.thread;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 完成任务等待处理
 * Created by yuhou on 2017/8/16.
 */
public class ExecutorCompletionServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(ExecutorCompletionServiceTest.class);


    /**
     * 将生产新的异步任务与使用已完成任务的结果分离开来的服务。生产者 submit 执行的任务。
     * 使用者 take 已完成的任务，并按照完成这些任务的顺序处理它们的结果。
     * 例如，CompletionService 可以用来管理异步 IO ，执行读操作的任务作为程序或系统的一部分提交，然后，当完成读操作时，会在程序的不同部分执行其他操作，执行操作的顺序可能与所请求的顺序不同。

     通常，CompletionService 依赖于一个单独的 Executor 来实际执行任务，在这种情况下，CompletionService 只管理一个内部完成队列。ExecutorCompletionService 类提供了此方法的一个实现。

     内存一致性效果：线程中向 CompletionService 提交任务之前的操作 happen-before 该任务执行的操作，后者依次 happen-before 紧跟在从对应 take() 成功返回的操作。

     */

    /**
     *Future<V>	poll()
     获取并移除表示下一个已完成任务的 Future，如果不存在这样的任务，则返回 null。

     Future<V>	poll(long timeout, TimeUnit unit)
     获取并移除表示下一个已完成任务的 Future，如果目前不存在这样的任务，则将等待指定的时间（如果有必要）。

     Future<V>	submit(Callable<V> task)
     提交要执行的值返回任务，并返回表示挂起的任务结果的 Future。

     Future<V>	submit(Runnable task, V result)
     提交要执行的 Runnable 任务，并返回一个表示任务完成的 Future，可以提取或轮询此任务。

     Future<V>	take()
     获取并移除表示下一个已完成任务的 Future，如果目前不存在这样的任务，则等待。
     */

    /**
     * 测试执行
     */
    private static final ExecutorService executorService = Executors.newFixedThreadPool(2 * Runtime.getRuntime().availableProcessors(), new ApromiseThreadFactory("haha-test"));

    public void executeList(List<String> list) {

        ExecutorCompletionService<Map<String, Object>> executorCompletionService = new ExecutorCompletionService<Map<String, Object>>(executorService);

        List<Callable<Map<String, Object>>> paramList = Lists.newArrayList();

        for (String str : list) {
            executorCompletionService.submit(new Callable<Map<String, Object>>() {
                @Override
                public Map<String, Object> call() throws Exception {

                    Map<String, Object> retMap = Maps.newHashMap();
                    retMap.put(str, str);
                    logger.info(">>>>>>>>>>><<<<<<<<<<<<<<<.{}", retMap);
                    return retMap;
                }
            });
        }

        for (int i = 0; i < list.size(); i++) {
            try {
                Map<String, Object> map = executorCompletionService.take().get();
                logger.info(">>>>>>>>>>>result<<<<<<<<<<<<<<<.{}", map);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        List<String> list = Lists.newArrayList();
        list.add("bb");
        list.add("aa");
        list.add("cc");
        list.add("dd");
        list.add("ee");


        ExecutorCompletionServiceTest executorCompletionServiceTest = new ExecutorCompletionServiceTest();
        executorCompletionServiceTest.executeList(list);

    }
}
