package com.udid.sign.rest;

import org.dom4j.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Iterator;

/**
 * @author mokwing
 * @date 2019-9-29 15:16
 */
@RestController
public class SignController {

    @RequestMapping("/udidsign")
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, DocumentException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        //获取HTTP请求的输入流
        InputStream is = request.getInputStream();
        //已HTTP请求输入流建立一个BufferedReader对象
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
        StringBuilder sb = new StringBuilder();

        // 读取HTTP请求内容
        String buffer = null;
        while ((buffer = br.readLine()) != null) {
            sb.append(buffer);
        }
        String content = sb.toString().substring(sb.toString().indexOf("<?xml"), sb.toString().indexOf("</plist>")+8);
        // content就是接收到的xml字符串
        System.out.println("获取到的content内容：" + content);
        // xml解析
        Document document = DocumentHelper.parseText(content);
        // 通过document对象获取根节点car
        Element car = document.getRootElement();
        // 通过element对象的elmentIterator方法获取迭代器
        Iterator it = car.elementIterator();

        int i = 0;
        String udid = null;
        // 遍历迭代器，获取根节点中的信息
        while (it.hasNext()) {
            Element value1 = (Element)it.next();
            // 解析子节点的信息
            Iterator itt = value1.elementIterator();

            while (itt.hasNext()) {
                Element carChild = (Element) itt.next();
                if (i == 7){
                    udid = carChild.getStringValue();
                }
                i++;
            }
        }

        response.setStatus(301); //301之后iOS设备会自动打开safari浏览器
        response.setHeader("Location", "http://39.108.218.10:8088/sign?UDID=" + udid);
    }

}
