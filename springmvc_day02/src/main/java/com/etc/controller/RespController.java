package com.etc.controller;

import com.etc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/resp")
public class RespController {

    @RequestMapping("/testAjax")
    @ResponseBody //将一个Java对象转成json字符串输出
    public  User testAjax(@RequestBody User user){ //怎么样将一个json字符串转成java对象
        System.out.println(user+"----------");
        user.setUname("lisi");
        user.setUpwd("456");
        return user;
    }

    @RequestMapping("/testAttr")
    public String testAttr( @ModelAttribute("a") User user){
        System.out.println(user);
        return "success";
    }
    @ModelAttribute
    public void initForm(Map<String,User> map){
        User user = new User();
        user.setUpwd("789");
        user.setUname("帝释天");
        map.put("a",user);
//        return user;
    }

}
