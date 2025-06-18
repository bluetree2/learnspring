package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.entity.Entity19;
import com.example.spring.repository.Entity16Repository;
import com.example.spring.repository.Entity19Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Service4 {
    private final Entity16Repository entity16Repository;
    private final PageableHandlerMethodArgumentResolver pageableResolver;
    private final Entity19Repository entity19Repository;

    public void action1(){
        System.out.println("111111111111111111111111111");
        // paging
        Page<Entity16> list = entity16Repository.findAll(PageRequest.of(1 - 1, 10));
        List<Entity16> data1 = list.getContent();
        for (Entity16 entity16 : data1) {
            System.out.println(entity16);
        }

        List<Entity16> list2  = entity16Repository.findAll(PageRequest.of(2 - 1, 10)).getContent();
        for (Entity16 entity16 : list2 ) {
            System.out.println(entity16);
        }

    }

    public void action2() {

        List<Entity16> list1  = entity16Repository.findAll(PageRequest.of(1 - 1, 10)).getContent();
        for (Entity16 entity16 : list1 ) {
            System.out.println(entity16);
        }

        List<Entity16> list2  = entity16Repository.findAll(PageRequest.of(2 - 1, 10)).getContent();
        for (Entity16 entity16 : list2 ) {
            System.out.println(entity16);
        }
    }

    public void action3() {

        System.out.println();
        List<Entity19> list1 = entity19Repository.findAll(PageRequest.of(1 - 1, 7, Sort.by("productName"))).getContent();
        for (Entity19 entity19 : list1){
            System.out.println(entity19);
        }
    }

    public void action4() {
        // 계약명 기중으로 1페이지 출력하기 (1페이지에 10개 데이터
        List<Entity16> list1 = entity16Repository
                .findAll(PageRequest.of(1 - 1, 10, Sort.by("contactName").descending()))
                .getContent();
        for (Entity16 entity16 : list1){
            System.out.println(entity16);
        }
    }

    public void action5() {
        // 가격 역순으로 10개씩 1페이지 상품 내용 보기
        List<Entity19> list1 = entity19Repository
                .findAll(PageRequest.of(1 - 1, 10, Sort.by("price").descending()))
                .getContent();
        for (Entity19 entity19 : list1){
            System.out.println(entity19);
        }
    }

    public void action6(Integer page) {
        // 91 레코드
        // 1~10 페이지
        System.out.println("##########"+page+" page ############");
        Page<Entity16> page1 = entity16Repository
                .findAll(PageRequest.of(1 - 1, 10, Sort.by("id").descending()));

        List<Entity16> content1 = page1.getContent();
        int totalPages = page1.getTotalPages(); // 10
        long totalElements = page1.getTotalElements(); // 91

        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);

    }

    public void action7(Integer page) {
        Page<Entity19> page1 = entity19Repository.findAll(PageRequest.of(page - 1, 10, Sort.by("price").ascending()));
        List<Entity19> content1 = page1.getContent();
        int totalPages = page1.getTotalPages();
        long totalElements = page1.getTotalElements();
        boolean next = page1.hasNext();

        System.out.println("content1 = "+content1);
        System.out.println("next = " + next);
        System.out.println("totalPages = " + totalPages);
        System.out.println("totalElements = " + totalElements);
        content1.forEach(entity19 -> System.out.println(entity19));  


    }
}
