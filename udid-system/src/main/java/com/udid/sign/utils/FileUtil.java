package com.udid.sign.utils;

import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author mokwing
 * @date 2019-9-29 13:04
 */
public class FileUtil {

    /**
     * 下载项目根目录下doc下的文件
     *
     * @param response response
     * @param fileName 文件名
     * @return 返回结果 成功或者文件不存在
     */

    public static String downloadFile(HttpServletResponse response, String fileName) throws FileNotFoundException {
        // 获取当前系统类型
         String osType = GetOSUtil.getOSname().toString();

        if (fileName != null) {
            File file = null;
            //设置文件路径
            if (osType.equals("Windows")){
                file  = new File(ResourceUtils.getURL("src/main/webapp/WEB-INF/downfile/").getPath() + fileName);
                System.out.println("获取到的文件file：" + file);
            }else if (osType.equals("Linux")){
                file  = new File(ResourceUtils.getURL("webapp/WEB-INF/downfile/").getPath() + fileName);
                System.out.println("获取到的文件file：" + file);
            }else {
                System.out.println("当前系统暂不支持！");
            }

            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return "下载成功";
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "下载失败";
    }
}
