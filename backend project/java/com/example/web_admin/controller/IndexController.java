package com.example.web_admin.controller;

import com.example.web_admin.bean.User;
import jakarta.servlet.http.HttpSession;
import jdk.jfr.Frequency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IndexController {
    /**
     * 登入页
     *
     * @return
     */
    @GetMapping(value = {"/", "login"})
    public String loginPage() {

        return "login";
    }

    @PostMapping("/login")
    public String main(User user,User userName, User passWord, HttpSession session, Model model) {
        if(org.springframework.util.StringUtils.hasLength(user.getUserName())&& "123456".equals(user.getPassWord())){

            //将登入成功的用户保存起来
            session.setAttribute("loginUser", user);
                return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            //返回登入页
            return "login";
        }


        //登入成功重新定向到main.html; 重定防止表单重复提交
//        return "redirect:main.html";
   }


    /**
     * 去main页面
     * @return
     */
   @GetMapping("/main.html")
    public String mainPage(HttpSession session){
      log.info("当前方式为{}","mainPage");

   /*     Object loginUser = session.getAttribute("loginUser");
       if (loginUser!= null){
           return "main";
       }else {
           //返回登入页
           return "login";
       }*/
       //是否登入。  拦截器，过滤器
        return "main";
   }

}
