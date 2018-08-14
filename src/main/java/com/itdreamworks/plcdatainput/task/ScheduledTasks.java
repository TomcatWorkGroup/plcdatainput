package com.itdreamworks.plcdatainput.task;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itdreamworks.plcdatainput.client.TemplateClient;
import com.itdreamworks.plcdatainput.service.DataInputService;
import com.itdreamworks.plcdatainput.utils.DataSet;
import com.itdreamworks.plcdatainput.utils.DataSetUtil;
import feign.Feign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

//@Component
public class ScheduledTasks {

    private Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Value("${com.itdreamworks.plcdatainput.baseurl}")
    private String baseUrl;

    private DataInputService dataInputService;
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(cron = "${spring.scheduling.cron}")
    public void reportCurrentTime() {
        logger.info("。。。。。。。。。。。。。。。。。定时任务开启，开始时间：" + dateFormat.format(new Date()) + "。。。。。。。。。。。。。。。。。。。。");
        getDeviceArrayInfo();
    }

    /**
     * 调用设备服务获得设备信息
     */
    public void getDeviceArrayInfo() {

        TemplateClient client = Feign.builder().target(TemplateClient.class, String.format("%s%s", baseUrl, "/device/plc"));
        String jsonStr = client.get();
        JSONArray jsonArray = JSONArray.parseArray(jsonStr);
        DataSetUtil util = DataSetUtil.getInstance();
        util.putCache(jsonArray);
    }
}
