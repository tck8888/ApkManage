package com.tck.plugin;


import org.gradle.api.Project
import org.gradle.api.Plugin

class UploadApkPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        println '开始执行插件'
        project.tasks.create('uploadApkToServerTask', UploadApkToServerTask)
    }
}
