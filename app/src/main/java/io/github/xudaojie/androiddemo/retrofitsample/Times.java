package io.github.xudaojie.androiddemo.retrofitsample;


import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by admin on 2015/6/26.
 */
public class Times {
    public static String getTime(){
        String time="";
        SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmm");
        time = format.format(new Date());

        return time;
    }
    public static String md5(String string) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(string.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) hex.append("0");
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }

    public static String getMd5(String... values) {
        String[] params = new String[values.length];
        int index = 0;
        for (String value : values) {
            params[index] = value;
            index++;
        }
        String str = "";
        Arrays.sort(params);
        for (int i = 0; i < params.length; i++) {
            str += params[i];
        }
        Log.d("md5_str", str);
        return Times.md5(str);
    }
}
