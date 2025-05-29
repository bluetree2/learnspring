package com.example.spring.controller;

import com.example.spring.dto.MyBean051;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("main5")
public class Controller05 {
    @RequestMapping("sub1")
    public String sub1(Model model) {

        model.addAttribute("name","son");

        // atribyte 가 javaBeans(dto)
        MyBean051 m = new MyBean051();
        model.addAttribute("obj",m);

        //forward to /templates/main5/sub1.html
        return "main5/sub1";
    }
}
