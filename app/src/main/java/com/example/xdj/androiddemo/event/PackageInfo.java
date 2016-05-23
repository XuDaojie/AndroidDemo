package com.example.xdj.androiddemo.event;

/**
 * Created by xdj on 16/3/31.
 * 事件的分发与上传
 */
public class PackageInfo {
    private static PackageInfo ourInstance = new PackageInfo();

    public static PackageInfo getInstance() {
        return ourInstance;
    }

    private PackageInfo() {
    }
}
