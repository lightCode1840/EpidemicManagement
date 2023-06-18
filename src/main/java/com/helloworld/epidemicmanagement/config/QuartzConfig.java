package com.helloworld.epidemicmanagement.config;

import com.helloworld.epidemicmanagement.quartz.StateTask;
import com.helloworld.epidemicmanagement.utils.DateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

import java.util.Date;

/**
 * @author fsyj
 */
@Slf4j
public class QuartzConfig {


    private static JobDetail jobDetail(String key, Long value, String identity) {
        //指定任务描述具体的实现类
        return JobBuilder.newJob(StateTask.class)
                // 指定任务的名称
                .withIdentity(identity)
                // 任务描述
                .withDescription("修改状态至失效")
                .usingJobData(key, value)
                .build();
    }


    /**
     * 创建定时任务 定时任务创建之后默认启动状态
     *
     * @param scheduler 调度器
     * @throws Exception
     */
    public static void createScheduleJob(Scheduler scheduler, String key, Long value, String identity) {
        try {
            JobDetail jobDetail = jobDetail(key, value, identity);
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("Trigger" + identity)
                    .startAt(DateBuilder.futureDate(2, DateBuilder.IntervalUnit.DAY)).build();
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            System.out.println("创建定时任务出错：" + e.getMessage());
        } finally {
            try {
                Date time = scheduler.getTrigger(TriggerKey.triggerKey("Trigger" + identity)).getNextFireTime();
                log.info("任务《" + identity + "》将在" + DateTimeUtil.get19StrTime(time) + "执行");
            } catch (SchedulerException e) {
                log.error("未找到Trigger：" + ("Trigger" + identity));
            }
        }
    }
}
