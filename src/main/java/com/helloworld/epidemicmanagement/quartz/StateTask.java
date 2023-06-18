package com.helloworld.epidemicmanagement.quartz;

import com.helloworld.epidemicmanagement.service.AccessService;
import com.helloworld.epidemicmanagement.service.OutService;
import com.helloworld.epidemicmanagement.utils.constans.Constants;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author fsyj
 */
@Component
public class StateTask extends QuartzJobBean {

    @Resource
    private AccessService accessServiceImpl;

    @Resource
    private OutService outServiceImpl;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        Object access = dataMap.get(Constants.ACCESS_STATE_ID);
        Object out = dataMap.get(Constants.OUT_STATE_ID);
        if (access == null && out != null) {
            outServiceImpl.outSchoolById((Long) out);
        } else if (access != null && out == null) {
            accessServiceImpl.returnSchoolById((Long) access);
        }
    }
}
