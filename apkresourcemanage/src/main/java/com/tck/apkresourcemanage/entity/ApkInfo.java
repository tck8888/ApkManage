package com.tck.apkresourcemanage.entity;

/**
 * description:</br>
 * created on: 2019/10/16 14:37</br>
 *
 * @author tck
 * @version 1.0
 */
public class ApkInfo {
    /**
     * outputType : {"type":"APK"}
     * apkData : {"type":"MAIN","splits":[],"versionCode":121,"versionName":"1.21","enabled":true,"outputFile":"trialfield_2019-10-15_1.21_dia_debug.apk","fullName":"diaDebug","baseName":"dia-debug"}
     * path : trialfield_2019-10-15_1.21_dia_debug.apk
     * properties : {}
     */

    public OutputTypeBean outputType;
    public ApkDataBean apkData;
    public String path;
    public PropertiesBean properties;

    public static class OutputTypeBean {
        /**
         * type : APK
         */

        public String type;
    }

    public static class ApkDataBean {
        /**
         * type : MAIN
         * splits : []
         * versionCode : 121
         * versionName : 1.21
         * enabled : true
         * outputFile : trialfield_2019-10-15_1.21_dia_debug.apk
         * fullName : diaDebug
         * baseName : dia-debug
         */

        public String type;
        public int versionCode;
        public String versionName;
        public boolean enabled;
        public String outputFile;
        public String fullName;
    }

    public static class PropertiesBean {
    }

}
