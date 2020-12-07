package com.zsl.blog.utils;

import java.util.UUID;

/**
 * @Author: 张世林
 * @Date: 2020/12/5 15:09
 * @Description: UUID
 * @Version 1.0
 */
public class UUIDUtils {

    public static String getId(){

        return UUID.randomUUID().toString();
    }
}
