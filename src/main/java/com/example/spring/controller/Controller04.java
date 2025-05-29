package com.example.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("main4")
public class Controller04 {
    @RequestMapping("sub1")
    @ResponseBody
    public String sub1() {
        // 1. 요청 분석/
        // 2. 요청 처리(business logic)

        // 3.결과(html) 응답

        String htmlCode = """
                <!doctype html>
                <html lang="en">
                <head>
                <meta charset="UTF-8">
                <title>Title</title>
                </head>
                <body>
                <h1>서버가 응답하는 html 코드</h1>
                <p>이렇게 html을 작성하는 것은 너무 힘들다</p>
                </body>
                </html>
                """;

        return htmlCode;
    }

    @RequestMapping("sub2")
    @ResponseBody
    public String sub2(String keyword) {
        String weather = switch (keyword) {
            case "서울" -> "날씨 맑음";
            case "울릉도" -> "바람 많이 붊";
            default -> "알 수 없음";
        };

        String htmlcode = """
                <!doctype html>
                <html lang="en">
                <head>
                <meta charset="UTF-8">
                <title>Title</title>
                </head>
                <body>
                <h1>검색한 지역의 날씨</h1>
                <h3>""" + weather + """
                </h3>
                </body>
                </html>
                """;

        return htmlcode;
    }

    @RequestMapping("sub3")
    public String sub3() {

        //3. html 코드 응답

        // thymeleaf html 파일 위치
        // src/main/resources/templates/main4/sub3.html

        // view로 forward함
        return "main4/sub3";
    }

    // /main4/sub4 로 요청 올 때
    // 아래 html이 최종 응답 되도록 request handler method를 작성해보세요

    //src/main/resources/templates/main4/sub4.html
    @RequestMapping("sub4")
    public String sub4() {
        return "main4/sub4";
    }

    @RequestMapping("sub5")
    public String sub5(Model model) {
        // 1. 요청 분석/가공
        // 2. 요청 처리(business logic)

        // 3. 결과를 model에 담기
        model.addAttribute("name1", "결과 값1");
        model.addAttribute("name2", "또 다른 결과 값2");

        // 4. view로 forwarding
        return "main4/sub5";
    }

    // 연습 :
    // /main4/sub6으로 요청 와면
    // templates/main3/sub6.html 이 응답 되도록

    // request handler method 작성
    @RequestMapping("sub6")
    public String sub6(Model model) {

        // model에 넣은 값(객체) : model attribute
        model.addAttribute("name","dionysus");
        model.addAttribute("address","LA");
        model.addAttribute("email","gmail");

        return "main4/sub6";
    }

    // request handler method 작성
    @RequestMapping("sub7")
    public String sub7(Model model) {
        model.addAttribute("age",55);
        model.addAttribute("score",97.54);
        model.addAttribute("school","서울대");
        model.addAttribute("city","신림동");

        return "main4/sub7";
    }

    @RequestMapping("sub8")
    public String sub8(Model model) {
        model.addAttribute("number",123456789);
        return "main4/sub8";
    }
}
