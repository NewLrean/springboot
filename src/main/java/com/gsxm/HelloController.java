package com.gsxm;

import com.gsxm.pojo.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by 蒋志鹏 on 2018/7/18.
 */

@Controller
public class HelloController {

    @Value("${name}")
    private String name;

    @Value("${age}")
    private int age;

    @Value("${content}")
    private String content;

    @Autowired
    private StudentProperties studentProperties;

    @Autowired
    private Environment environment;

    @Value("${url}")
    private String url;

    @RequestMapping("/hello")
    @ResponseBody
    private String hello(){
        return "Hello Spring Boot"+"\n姓名："+name+"\n年龄："+age ;
    }


    @RequestMapping("/content")
    @ResponseBody
    private String content(){
        return content+environment.getProperty("url") ;
    }

    @RequestMapping("/student")
    @ResponseBody
    private String student(){
        return "姓名："+studentProperties.getName()+"\n年龄："+studentProperties.getAge()+url;
    }

    @RequestMapping("/now")
    private String now(Model model){
        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "index";
    }

    @RequestMapping("/{page}")
    private String page(@PathVariable String page){
        return page;
    }



}
