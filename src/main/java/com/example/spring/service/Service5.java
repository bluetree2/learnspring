package com.example.spring.service;

import com.example.spring.entity.Entity16;
import com.example.spring.entity.Entity20;
import com.example.spring.repository.Entity16Repository;
import com.example.spring.repository.Entity18Repository;
import com.example.spring.repository.Entity20Repository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Service5 {
    private final Entity16Repository entity16Repository;
    private final Entity20Repository entity20Repository;
    private final Entity18Repository entity18Repository;
    public void action1(Integer page) {
        // repository 사용
        Page<Entity16> pageContent = entity16Repository
                .findAll(PageRequest.of(page-1, 10, Sort.by("id").descending()));

        List<Entity16> content = pageContent.getContent();
        content.forEach(System.out::println);

    }

    public void action2(String country) {
        List<Entity16> list = entity16Repository
                .findByCountry(country);
        list.forEach(System.out::println);
    }

    public void action3(String country, Integer page) {
        List<Entity16> list = entity16Repository
                .findByCountry(country, PageRequest.of(page - 1, 10, Sort.by("id").descending()));
    }

    public void action4(String keyword, Integer page) {
        List<Entity16> list = entity16Repository
                .findbycustomerNamecontainNameOrContactNameContaining("%"+keyword+"%", 
                        PageRequest.of(page-1,10, Sort.by("id")
                        .descending()));
    }

    public void action5(Integer id) {
        entity16Repository.deleteById(id);
    }

    public void action6(String country) {
        entity16Repository.deleteByCountry(country);

    }

    public void action7() {
        Entity20 a =  entity20Repository.findById("a").get();
        Entity20 b = entity20Repository.findById("b").get();
        a.setMoney(a.getMoney() - 500);
        entity20Repository.save(a);

        if (true){
            throw new RuntimeException("네트워크 오류");
        }

        b.setMoney(a.getMoney() + 500);
        entity20Repository.save(b);


    }

    @Transactional
    public void action8() {
        // 보통 service 의 하나의 메소드가 하나의 transaction 임
        // -> @Transactional 어노테이션을 service의 모든 메소드에 뭍여야 함
        Entity20 a =  entity20Repository.findById("a").get();
        Entity20 b = entity20Repository.findById("b").get();
        a.setMoney(a.getMoney() - 500);
        entity20Repository.save(a);

        if (true){
            throw new RuntimeException("네트워크 오류");
        }

        b.setMoney(a.getMoney() + 500);
        entity20Repository.save(b);
    }

    @Transactional
    public void action9(String country) {
        entity18Repository.deleteByCountry(country);
    }

    @Transactional
    public void action10(String country) {
        // select 후 하나씩 지움 : 성능 이슈 있음
//        entity16Repository.deleteByCountry(country);
        // jpql이나 sql 로 직접 작성해서 지워야함
        entity18Repository.blukDeleteByCountry(country);
    }
}
