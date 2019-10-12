package com.yaoyanshe.android.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project


class UploadApkPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        //创建扩展属性
        project.extensions.create('uploadApkInfoExtension',
                UploadApkInfoExtension)
        //创建Task

        project.tasks.create('uploadApkToServerTask', UploadApkToServerTask)
    }
}
