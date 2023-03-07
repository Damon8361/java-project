package com.example.web_admin.controller;


import com.example.web_admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {
    @GetMapping("/basic_table.html")
    public String basic_table() {
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table.html")
    public String dynamic_table(Model model) {
        //表哥内容的遍历
/*        List<User> users = Arrays.asList(new User("zhangsan", "123456")
       *//*         new User("lisi", "654321")*//*
           *//*    new User("wang", "123123"),
               new User("zhang","000000")*//*);
        model.addAttribute("users",users);*/

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table.html")
    public String responsive_table() {
        return "table/responsive_table";
    }

    @GetMapping("/editable_table.html")
    public String editable_table() {
        return "table/editable_table";
    }
}
