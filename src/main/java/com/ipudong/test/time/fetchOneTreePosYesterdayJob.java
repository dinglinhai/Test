package com.ipudong.test.time;


import com.ipudong.test.service.OneTreePosImportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.TimeZone;

@Component
public class fetchOneTreePosYesterdayJob {
    protected static transient Logger logger = LoggerFactory.getLogger(fetchOneTreePosYesterdayJob.class);


    @Autowired
    private OneTreePosImportService oneTreePosImportService;

    @Scheduled(cron = "50 22 14 * * ?") //每天凌晨1点开始同步
    public void synchronousPos(){
        /*long current = System.currentTimeMillis();//当前时间毫秒数
        long today = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset()+1000 * 3600 * 24;//今天零点零分零秒的毫秒数
        long yesterday = today - 24 * 60 * 60 * 1000;//昨天零点零分零秒的毫秒数*/
        /*Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Long today = cal.getTimeInMillis(); //今天零点零分零秒的毫秒数
        Long yesterday = today - 24*60*60*1000;//昨天零点零分零秒的毫秒数*/
        Long yesterday = 1529337600000L;
        Long today = 1529424000000L;

        logger.info("开始导入一树前一天POS数据...，startTime为{},endTime为{}", yesterday, today);
        oneTreePosImportService.fetchPosFromOperations(yesterday, today);
        logger.info("[ScheduleOneTreePosYesterdayJob->execute]导入前两日pos数据任务结束...");
    }
}
