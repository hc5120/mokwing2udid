package com.udid.sign.rest;

import com.udid.aop.log.Log;
import com.udid.sign.utils.FileUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

/**
 * @author mokwing
 * @date 2019-9-29 11:19
 */
@RestController
public class FileController {


    @Log("下载描述文件")
    @RequestMapping("download")
    @ResponseBody
    public void Download(HttpServletResponse response) {
        String fileName = "udid.mobileconfig";
        String result = null;
        try {
            result = FileUtil.downloadFile(response, fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(result);
    }

}
