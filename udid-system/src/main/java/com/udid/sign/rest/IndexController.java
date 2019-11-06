package com.udid.sign.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author mokwing
 * @date 2019-9-29 10:43
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping(value = "/sign")
    public String sign(Model model, @RequestParam("UDID") String udid) {
        System.out.println("查看controller："+udid);
        model.addAttribute("UDID", udid);
        return "sign";
    }
}
