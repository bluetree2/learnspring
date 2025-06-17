package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.EmployeeDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main14")
public class Controller14 {
    @GetMapping("sub1")
    public String sub1(String keyword, Model model) throws Exception {
        // 직원설명에 특정 keyword가 있는 직원들 조회
        String sql = """
                SELECT *
                FROM Employees
                WHERE Notes LIKE ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + keyword + "%");

        List<EmployeeDto> list = new ArrayList<>();
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setId(rs.getInt("EmployeeId"));
            employeeDto.setLastName(rs.getString("LastName"));
            employeeDto.setFirstName(rs.getString("FirstName"));
            employeeDto.setBirthDate(rs.getDate("BirthDate").toLocalDate());
            employeeDto.setPhoto(rs.getString("Photo"));
            employeeDto.setNotes(rs.getString("Notes"));
            list.add(employeeDto);
        }
        model.addAttribute("employeeList", list);


        return "main14/sub1";
    }

    // 연습 : request handler method, html
    // get /main14/sub2
    // 고객명 조회하는 코드 완성
    // sql :
    // SELECT * FROM Customers
    // WHERE CustomerName LIKE '%keyword%'
    //    OR ContactName LIKE '%keyword%'
    //
    @GetMapping("sub2")
    public String sub2(String keyword, Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Customers
                WHERE CustomerName LIKE ?
                   OR ContactName LIKE ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "%" + keyword + "%");
        statement.setString(2, "%" + keyword + "%");
        List<CustomerDto> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(resultSet.getInt("CustomerId"));
            customerDto.setName(resultSet.getString("CustomerName"));
            customerDto.setContactName(resultSet.getString("ContactName"));
            customerDto.setAddress(resultSet.getString("Address"));
            customerDto.setCity(resultSet.getString("City"));
            customerDto.setPostalCode(resultSet.getString("PostalCode"));
            customerDto.setCountry(resultSet.getString("Country"));

            list.add(customerDto);
        }
        model.addAttribute("customerList", list);

        return "main14/sub2";
    }
}
