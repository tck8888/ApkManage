package com.tck.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class UploadApkToServerTask extends DefaultTask {


    @TaskAction
    def upload() {
        println "上传文件"
    }


}
