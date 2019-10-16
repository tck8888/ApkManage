package com.tck.apkresourcemanage.controller;


import com.tck.apkresourcemanage.utils.YJSONResult;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class UploadController {

    @RequestMapping(path = "/download/android/apk/{version}/{env}")
    @ResponseBody
    public YJSONResult downloadApk(@PathVariable("version") String version,
                                   @PathVariable("env") String env
    ) {
        return YJSONResult.ok("http://192.168.19.150:9001/shiyantian/debug/v1.21/trialfield_2019-10-15_1.21_dia_debug.apk");
    }


    @RequestMapping(path = "/android/apk")
    @ResponseBody
    public YJSONResult uploadApk(@RequestPart("file") MultipartFile srcFile) {
        try {
            File rootPath = new File(ResourceUtils.getURL("classpath:").getPath());
            //最重要的一步，将源文件写入目标地址
            Path path = Paths.get(rootPath.getParentFile().getParent() + File.separator + "apk" + File.separator + srcFile.getOriginalFilename());
            Files.write(path, srcFile.getBytes());
            return YJSONResult.ok("上传成功");
        } catch (IOException e) {
            return YJSONResult.ok(e.getMessage());
        }
    }


    @GetMapping("/checkUpdate")
    public YJSONResult checkUpdate() {

        return YJSONResult.ok();
    }
}