package com.example.spring.controller;

import com.example.spring.dto.Entity36Dto;
import com.example.spring.dto.Entity39Dto;
import com.example.spring.dto.ProductInfo;
import com.example.spring.entity.Entity34;
import com.example.spring.entity.Entity36;
import com.example.spring.entity.Entity39;
import com.example.spring.service.Service8;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("main26")
public class Controller26 {

    private final Service8 service8;

    @RequestMapping("sub1")
    public String sub1(Model model) {
        service8.action1();

        return "main26/sub1";
    }

    @RequestMapping("sub2")
    public String sub2(Model model) {
        // 두명의 학생
        // 두개의 강의
        // 각 학생이 하나의 강의 수강 (2개의 수강정보)
        service8.action2();

        return "main26/sub2";
    }

    @RequestMapping("sub3")
    public String sub3(Model model) {
        service8.action3();

        return "main26/sub3";
    }

    @RequestMapping("sub4")
    public String sub4(Model model) {
        service8.action4();

        return "main26/sub4";
    }

    @RequestMapping("sub5")
    public String sub5(Model model) {
        service8.action5();

        return "main26/sub5";
    }

    @RequestMapping("sub6")
    public String sub6(Model model) {
        service8.action6();

        return "main26/sub6";
    }

    @RequestMapping("sub7")
    public String sub7(Model model) {
        service8.action7();

        return "main26/sub7";
    }

    @RequestMapping("sub8")
    public String sub8(Model model) {
        Entity36 l1 = service8.action8();

        System.out.println(l1.getRegisteredAt());

        Entity34 s1 = l1.getStudent();
        // 아직 select 안일어남

        // LAZY 일 경우 이 떄 select 쿼리 실행
        // session 이 닫혀서 exception 발생
        // 문제 발생
        String name = s1.getName();
        System.out.println("name: " + name);

        return "main26/sub8";
    }

    @RequestMapping("sub9")
    public String sub9(Model model) {
        Entity36Dto l1 = service8.action9();

        System.out.println(l1.getRegisteredAt());
        System.out.println("name: " + l1.getStudentName());

        return "main26/sub9";
    }

    @RequestMapping("sub10")
    public String sub10(Model model) {
        List<Entity39Dto> list = service8.action10();

        //model 에 넣고
        // forward


        return "main26/sub10";
    }

    @RequestMapping("sub11")
    public String sub11(Model model) {
        List<ProductInfo> result  = service8.action11();

        for (ProductInfo productInfo : result) {
            System.out.println("productInfo.getId() = " + productInfo.getId());
            System.out.println("productInfo.getproductName() = " + productInfo.getproductName());
            System.out.println("productInfo.getPrice() = " + productInfo.getPrice());
            System.out.println("productInfo.getCategoryName() = " + productInfo.getCategoryName());
        }

        //model 에 넣고
        // forward


        return "main26/sub11";
    }
}
