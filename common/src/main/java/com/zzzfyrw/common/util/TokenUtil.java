package com.zzzfyrw.common.util;

import java.util.UUID;

public class TokenUtil {


    public static String getToken(){
        String uuid = UUID.randomUUID() + String.valueOf(UUID.randomUUID());
        uuid = uuid.replaceAll("-","").toUpperCase().substring(0,45);
        return uuid;
    }

}
