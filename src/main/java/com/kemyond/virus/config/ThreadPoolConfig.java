package com.kemyond.virus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author zdl
 * @Date 2021/1/5 16:22
 * @Version 1.0
 */
@Configuration
public class ThreadPoolConfig {

    // 核心线程池大小
    private int corePoolSize = 30;

    // 最大可创建的线程数
    private int maxPoolSize = 100;

    // 队列最大长度
    private int queueCapacity = 500;

    // 线程池维护线程所允许的空闲时间
    private int keepAliveSeconds = 60;

    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setMaxPoolSize(maxPoolSize);
        executor.setCorePoolSize(corePoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        /**
         * 设置线程的名称前缀
         */
        executor.setThreadNamePrefix("kysoc-task");
        // 线程池对拒绝任务(无线程可用)的处理策略
        /**
         * rejectedExectutionHandler参数字段用于配置绝策略，常用拒绝策略如下
         *
         * AbortPolicy：用于被拒绝任务的处理程序，它将抛出RejectedExecutionException
         *
         * CallerRunsPolicy：用于被拒绝任务的处理程序，它直接在execute方法的调用线程中运行被拒绝的任务。
         *
         * DiscardOldestPolicy：用于被拒绝任务的处理程序，它放弃最旧的未处理请求，然后重试execute。
         *
         * DiscardPolicy：用于被拒绝任务的处理程序，默认情况下它将丢弃被拒绝的任务
         */
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }

    /**
     * 执行周期性或定时任务
     */
    @Bean(name = "scheduledExecutorService")
    protected ScheduledExecutorService scheduledExecutorService() {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(20);
        return scheduledExecutorService;
    }
}
