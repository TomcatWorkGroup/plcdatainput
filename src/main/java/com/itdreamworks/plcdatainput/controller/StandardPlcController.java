package com.itdreamworks.plcdatainput.controller;

import com.itdreamworks.plcdatainput.sender.Sender;
import com.itdreamworks.plcdatainput.service.DataInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

/**
 * 标准PLC设备数据输入
 */
@RestController
@RequestMapping(value = "/plc")
public class StandardPlcController {
    @Autowired
    private Sender sender;

    //@Autowired
    //private DataInputService dataInputService;

    @PostMapping("/input")
    public void inputData(@RequestBody(required = true) byte[] byteArray) {
        String deviceNo = String.format("%1$010d", new BigInteger(new byte[]{byteArray[5], byteArray[6], byteArray[7], byteArray[8]}).intValue());
        //if (dataInputService.validateDeviceNo(deviceNo)) {
            sender.send("BytePlcMsg",byteArray);
        //}
    }

    @GetMapping(value = "/hello")
    public String getHello() {
        return "hello world!";
    }
}
