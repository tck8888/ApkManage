package com.tck.android.plugin

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

//https://square.github.io/okhttp/recipes/#posting-a-file-kt-java
class UploadApkToServerTask extends DefaultTask {

    UploadApkToServerTask() {
        group = 'yaoyanshe'
        description = 'update the release info'
    }
    /**
     * 执行于gradle执行阶段的代码
     */
    @TaskAction
    void doAction() {
        println "****************************************************************"
        println "****************************************************************"
        println "                                                                "
        println "                                                                "
        println "                欢迎使用apk上传到服务器的编译插件                    "
        println "                                                                "
        println "                                                                "
        println "****************************************************************"
        println "****************************************************************"
        println "****************************************************************"

        uploadApk()
    }

    /**
     * 上传apk地址
     */
    void uploadApk() {
        def client = new OkHttpClient()
        def serverUrl = project.extensions.uploadApkInfoExtension.serverUrl
        def apkPath = project.extensions.uploadApkInfoExtension.apkPath

        def file = new File(apkPath)


        println "上传文件地址：" + file.getAbsolutePath()
        println "上传文件大小：" + file.size()
        println "服务器地址：${serverUrl}"

        def multipartBody = new MultipartBody.Builder()
                .setType(MediaType.parse("multipart/form-data"))
                .addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("application/octet-stream"), file))
                .build()
        def request = new Request.Builder()
                .post(multipartBody)
                .url(serverUrl)
                .build()

        def response = client.newCall(request).execute()
        if (!response.isSuccessful()) {
            println "****************************上传失败${response.code()}"
        }
        println "****************************" + response.body().string()


    }
}
