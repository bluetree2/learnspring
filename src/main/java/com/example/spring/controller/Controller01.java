package com.example.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class Controller01 {

    // path에 해당하는 메소드 호출
    @RequestMapping(path = "/main1/sub1")
    public void method1() {
        System.out.println("Controller01.method1");
    }


    @RequestMapping("/main1/sub2")
    public void some2() {
        System.out.println("Controller01.some2");
    }

    @RequestMapping("/main1/sub3")
    public void some3() {
        System.out.println("Controller01.some3");
    }

    // /main1/sub4 요청이 올 경우
    // 실행되는 method4를 작성하세요
    @RequestMapping({"/main1/sub4", "/main1/sub5"})
    public void some4() {
        System.out.println("Controller01.some4");
    }

    // WebRequest : 요청 정보가 감기는 객체
    @RequestMapping("/main1/sub6")
    public void some6(WebRequest webRequest) {
        String s = webRequest.getParameter("User-Agent");
        String t = webRequest.getParameter("Accept");
        System.out.println(s);
        System.out.println(t);
        System.out.println("Controller01.some6");
    }

}
