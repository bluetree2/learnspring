package com.example.spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.StandardServletAsyncWebRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

@Controller
public class Controller02 {

    // /main2/sub1?name
    // 파라미터
    @RequestMapping(value = "/main2/sub1", params = "name")
    public void sub1(WebRequest request) {
        //header 정보
        request.getHeader("User-Agent");


        System.out.println("Controller02.sub1");
    }

    // 파라미터
    // /main2/sub2?name&address
    // ? : query string
    // query string : name1=value1&name2=value2
    // request parameter
    @RequestMapping(value = "/main2/sub2", params = {"name", "address"})
    public void sub2(WebRequest request) {


        System.out.println("Controller02.sub2");
    }

    // /main2/sub3?name=donald
    @RequestMapping(value = "main2/sub3", params = "name")
    public void sub3(WebRequest request) {
        String name = request.getParameter("name");
        System.out.println("name = " + name);
        System.out.println("Controller02.sub3");
    }

    // /main2/sub3?address=seoul
    @RequestMapping(value = "main2/sub3", params = "address")
    public void sub4(WebRequest request) {
        // address request parameter를 얻어서 출력하는 코드
        String address = request.getParameter("address");
        System.out.println("address = " + address);
        System.out.println("Controller02.sub4");
    }

    // @RequestParam : 해당 이름의 request parameter를 method parameter 에 binding 해줌
    @RequestMapping(value = "/main2/sub5", params = "email")
    public void sub5(@RequestParam("email") String email) {
        System.out.println("email = " + email);

    }

    @RequestMapping(value = "/main2/sub6", params = {"email", "age"})
    public void sub6(@RequestParam("email") String email,
                     @RequestParam("age") String age) {
        System.out.println("email = " + email);
        System.out.println("age = " + age);
    }

    @RequestMapping("/main2/sub7")
    public void sub7(@RequestParam("email") String email,
                     @RequestParam("age") String age) {
        System.out.println("email = " + email);
        System.out.println("age = " + age);
    }

    //연습: 아래 Url을 사용한 요청을 적절히 처리하는 메소드 작성하기
    // /main2/sub7?address=jeju&country=korea&city=gangnam
    @RequestMapping("/main2/sub8")
    public void sub8(@RequestParam("address") String address,
                     @RequestParam("country") String country,
                     @RequestParam("city") String city) {
        System.out.println("address = " + address);
        System.out.println("country = " + country);
        System.out.println("city = " + city);

    }

    @RequestMapping("/main2/sub9")
    public void sub9(@RequestParam("city") String city,
                     @RequestParam("age") String age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
        int i = Integer.parseInt(age);
        System.out.println("i = " + i);

    }

    @RequestMapping("/main2/sub10")
    public void sub10(@RequestParam("city") String city,
                      @RequestParam("age") int age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }

    // request parameter의 이름이 method parameter와 같으면
    // @Requestpram의 value 속성을 생략 해도 됨
    // /main2/sub11?city=seoul&age=44
    @RequestMapping("/main2/sub11")
    public void sub11(@RequestParam("city") String city,
                      @RequestParam("age") int age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }

    // request parameter의 이름이 method parameter와 같으면
    // @Requestpram의 value 속성을 생략 해도 됨
    // /main2/sub12?city=seoul&age=44
    @RequestMapping("/main2/sub12")
    public void sub12(String city, int age) {
        System.out.println("city = " + city);
        System.out.println("age = " + age);
    }

    // /main2/sub13?email=gmail&score=88.8&married=true
    // /main2/sub13?score=88.8&married=true // work
    @RequestMapping("/main2/sub13")
    public void sub13(String email, double score, boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    // /main2/sub14?email=gmail&score=88.8&married=true
    // /main2/sub14?score=88.8&married=true // dont work
    @RequestMapping("/main2/sub14")
    public void sub14(@RequestParam(required = false) String email,
                      @RequestParam(required = false) Double score, Boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    @RequestMapping("/main2/sub15")
    public void sub15(@RequestParam(defaultValue = "") String email,
                      @RequestParam(defaultValue = "0.0") Double score,
                      @RequestParam(defaultValue = "false") Boolean married) {
        System.out.println("email = " + email);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }

    // 연습 :
    // /main2/sub17?city=seoul&home=jeju&age=33
    // /main2/sub17?city=seoul&home=jeju
    // /main2/sub17?city=seoul&age=33
    // /main2/sub17?&home=jeju&age=33

    // city 기본값 ""
    // home 기본값 ""
    // age 기본값 ""

    @RequestMapping("/main2/sub17")
    public void sub17(@RequestParam(defaultValue = "") String city,
                      @RequestParam(defaultValue = "") String home,
                      @RequestParam(defaultValue = "") Integer age) {
        System.out.println("city = " + city);
        System.out.println("home = " + home);
        System.out.println("age = " + age);
    }

    // 하나의 request parameter(요청 파라미터, 요청 변수)가 여러 값일 때
    // /main2/sub18?city=seoul&city=jeju&city=busan
    // /main2/sub18?city=seoul&city=jeju
    // /main2/sub18?city=seoul
    // /main2/sub18?
    @RequestMapping("/main2/sub18")
    public void sub18(String[] city) {
        System.out.println("Arrays.toString(city) = " + Arrays.toString(city));
    }

    @RequestMapping("main2/sub19")
    public void sub19(@RequestParam(value = "city", defaultValue = "") ArrayList<String> city) {
        System.out.println("city = " + city);
    }


    // /main2/sub20?country=korea&score=90&score=80&score=70
    @RequestMapping("/main2/sub20")
    public void sub20(String country, Integer[] score) {
        System.out.println("country = " + country);
        System.out.println("Arrays.toString(score) = " + Arrays.toString(score));
    }


    // /main2/sub21?city=서울&email=gmail&address=신촌&age=88&score=98.0&married=true
    @RequestMapping("/main2/sub21")
    public void sub21(String city, String email, Integer age, Double score, Boolean married) {
        System.out.println("city = " + city);
        System.out.println("email = " + email);
        System.out.println("age = " + age);
        System.out.println("score = " + score);
        System.out.println("married = " + married);
    }


    // /main2/sub22?city=서울&email=gmail&address=신촌&age=88&score=98.0&married=true
    @RequestMapping("/main2/sub22")
    public void sub22(@RequestParam Map<String, Objects> params) {
        for (var entry : params.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // /main2/sub23?city=서울&email=gmail&address=신촌&age=88&score=98&score=77&score=98&married=true
    @RequestMapping("/main2/sub23")
    public void sub23(@RequestParam MultiValueMap<String, Objects> params) {
        for (var entry : params.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    @RequestMapping("/main2/sub24")
    public void sub24(WebRequest request) {
        Class<? extends WebRequest> a = request.getClass();
        if (request instanceof StandardServletAsyncWebRequest b) {
            Object c = b.getNativeRequest();
            System.out.println("c.getClass() = " + c.getClass());
            if (c instanceof HttpServletRequest d) {
                String method = d.getMethod();
                String servletPath = d.getServletPath();
                System.out.println("method = " + method);
                System.out.println("servletPath = " + servletPath);
            }
        }
        System.out.println("a = " + a);
    }

}
