package com.xlx.user.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class UserRepositoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserRepositoryApplication.class);
    }

    private static final ScheduledExecutorService cancelSchedule = Executors.newSingleThreadScheduledExecutor();

    /**
     * 正确的处理定时取消线程的方式, 异常应该重新抛出给其调用者,并由调用者依据其取消策略进行处理
     * @param r
     * @param timeout
     * @param unit
     * @throws Exception
     */
    public  static void timedRun(final Runnable r, long timeout, TimeUnit unit) throws Exception {
        class ReThrowableTask implements Runnable{

            private volatile Throwable t;
            @Override
            public void run() {
                try {
                    r.run();
                }catch (Throwable t){
                    this.t = t;
                }
            }

            public void reThrow() throws Exception {
                if (t!=null){
                    throw new Exception(t);
                }
            }
        }

        ReThrowableTask task = new ReThrowableTask();
        Thread timeRun  = new Thread(task);
        timeRun.start();
        timeRun.join(unit.toMillis(timeout));
        task.reThrow();
    }
}
