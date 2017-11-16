package me.wenkang.wee.biz.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Base64Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by wenkang
 * on 2017/11/15.
 */
@Slf4j
public class MD5Util {

    public static String encrypt(String str) {

        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            str = Base64Utils.encodeToString(digest.digest(str.getBytes()));
            return str;
        } catch (NoSuchAlgorithmException e) {
            log.error("MD5Util 异常：", e);
            return "";
        }
    }
}
