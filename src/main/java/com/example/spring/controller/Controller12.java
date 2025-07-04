package com.example.spring.controller;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.servlet.http.HttpSession;
import org.springframework.aop.config.AopConfigUtils;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("main12")
public class Controller12 {

    @GetMapping("sub1")
    public String sub1(Model model) {

        model.addAttribute("address", "seoul");

        // view로 forward
        return "main12/sub1";
    }

    @GetMapping("sub2")
    public String sub2(Model model,
        // redirect 시나리오에서 model에 값을 전달해주는 역할
                       RedirectAttributes rttr) {


        System.out.println("Controller12.sub2");

        model.addAttribute("country", "korea");
        rttr.addFlashAttribute("city", "seoul");


        // redirection : 다른 곳으로 요청하라는 응답
        return "redirect:/main12/sub3";
    }

    @GetMapping("sub3")
    public String sub3(Model model) {
        System.out.println("Controller12.sub3");

        model.addAttribute("email", "yahoo");

        return "main12/sub3";
    }

    // 연습
    //get /main12/sub4 로 요청오면
    //    : /main12/sub5 로 redirection
    @GetMapping("sub4")
    public String sub4(Model model,RedirectAttributes rttr) {

    //      Redirectattributes 에 name : donald를 넣고
        rttr.addFlashAttribute("name", "donald");


        return "redirect:/main12/sub5";
    }

    // get /main12/sub5 에서
    //    : main12/sub5.html 로 forward
    @GetMapping("sub5")
    public String sub5(Model model) {

    // view에서 name Model attribute를 꺼내서 출력하기
        System.out.println(
        model.getAttribute("name")
        );

        return "main12/sub5";
    }


    @GetMapping("sub6")
    public String sub6(RedirectAttributes rttr) {


        // 다음 요청 model 에 옮겨 담음
        rttr.addFlashAttribute("nickName", "trump");

        // query string 에 붙음
        // ? address =jeju
        rttr.addFlashAttribute("address", "jeju");

        return "redirect:/main12/sub7";
    }

    @GetMapping("sub7")
    public String sub7(Model model) {

        return "main12/sub7";
    }
    
    // dustmq: 
    // get /main12.sub8 요청오면
    @GetMapping("sub8")
    public String sub8(RedirectAttributes rttr) {
    // : model(reedirectAttribute 에 item : car
        rttr.addFlashAttribute("item", "car");
    // 쿼리스트링에 company : tesla 를 붙이기
        rttr.addAttribute("company", "tesla");
        return "redirect:/main12/sub9";
    }

    // get /main12/sub9 fh 리디렉션 하고
    @GetMapping("sub9")
    public String sub9(Model model) {
    //    item (model attribute)
    //    company(request param)을 출력



    // : main12/sub9 view로 포워드 하고
        return "main12/sub9";
    }
    

    @GetMapping("sub10")
    public String sub10() {

        return "main12/sub10";
    }

    // login page
    @GetMapping("sub11")
    public String sub11(Model model) {

        return "main12/sub11";
    }

    // login 처리
    @PostMapping("sub11")
    public String sub11(String id, RedirectAttributes rttr) {
        System.out.println(id + "로그인 처리");

        rttr.addFlashAttribute("message",id+"님이 로그인 되었습니다");

        return "redirect:/main12/sub10";
    }
    
    // 연습 : 로그인 예제
    // 메소드 3개
    // main, login, login 처리
    // html 2개
    // main, login 페이지

    @GetMapping("sub12")
    public String sub12() {

        return "main12/sub12";
        
    }
    

    @GetMapping("sub13")
    public String sub13() {

        return "main12/sub13";
    }

    @PostMapping("sub13")
    public String sub13(String id, RedirectAttributes rttr, HttpSession session) {


        session.setAttribute("userid", id);
        rttr.addFlashAttribute("message",id+"님이 로그인 하셨습니다");

        return "redirect:/main12/sub12";
    }

    @RequestMapping("sub11/logout")
    public String sub11Logout(HttpSession session,RedirectAttributes rttr) {

        // sesstion attribute 만 지우기
//        session.removeAttribute("userid");
        // session 객체 지우기
        session.invalidate();

        rttr.addFlashAttribute("message", "로그아웃 되었습니다.");

        return "redirect:/main12/sub12";
    }




}
