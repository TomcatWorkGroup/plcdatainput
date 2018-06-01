package com.itdreamworks.plcdatainput.service;

import com.itdreamworks.plcdatainput.utils.DataSetUtil;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class DataInputService {

    /**
     * 验证设备编号
     * @param deviceNo
     */
    public boolean validateDeviceNo(String deviceNo){
        HashSet set  = DataSetUtil.getSet();
        try {
            if(set.contains(deviceNo)){
                return true;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
}
