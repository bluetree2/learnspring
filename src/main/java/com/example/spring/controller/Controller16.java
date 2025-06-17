package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.dto.SupplierDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("main16")
public class Controller16 {

    @GetMapping("sub1")
    public String form1(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Customers
                ORDER BY CustomerId DESC
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<CustomerDto> customerDtoList = new ArrayList<>();
        while (resultSet.next()) {
            CustomerDto customerDto = new CustomerDto();
            customerDto.setId(resultSet.getInt("CustomerId"));
            customerDto.setName(resultSet.getString("CustomerName"));
            customerDto.setAddress(resultSet.getString("Address"));
            customerDto.setCity(resultSet.getString("City"));
            customerDto.setContactName(resultSet.getString("ContactName"));
            customerDto.setCountry(resultSet.getString("Country"));
            customerDto.setPostalCode(resultSet.getString("PostalCode"));
            customerDtoList.add(customerDto);
        }
        model.addAttribute("customerList", customerDtoList);

        return "main16/sub1";
    }

    @PostMapping("sub1")
    public String process(CustomerDto customer) throws Exception {
//        System.out.println(customer);
        String sql = """
                INSERT INTO Customers
                (CustomerName, ContactName, Address, City, PostalCode, Country)
                VALUES (?, ?, ?, ?, ?, ?)
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, customer.getName());
        statement.setString(2, customer.getContactName());
        statement.setString(3, customer.getAddress());
        statement.setString(4, customer.getCity());
        statement.setString(5, customer.getPostalCode());
        statement.setString(6, customer.getCountry());

//        statement.executeQuery(); // select
        statement.executeUpdate(); // insert, delete, update

        return "redirect:/main16/sub1";
    }

    // 연습:
    // 새 공급자 등록 로직 작성
    // handler method * 2 (get, post)
    // html * 1
    @GetMapping("sub2")
    public String form2(Model model) throws Exception {
        String sql = """
                SELECT *
                FROM Suppliers
                ORDER BY SupplierId DESC
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<SupplierDto> supplierDtoList = new ArrayList<>();
        while (resultSet.next()) {
            SupplierDto supplierDto = new SupplierDto();
            supplierDto.setId(resultSet.getInt("SupplierId"));
            supplierDto.setName(resultSet.getString("SupplierName"));
            supplierDto.setAddress(resultSet.getString("Address"));
            supplierDto.setCity(resultSet.getString("City"));
            supplierDto.setCountry(resultSet.getString("Country"));
            supplierDto.setPostalCode(resultSet.getString("PostalCode"));
            supplierDto.setPhone(resultSet.getString("Phone"));
            supplierDto.setContact(resultSet.getString("ContactName"));
            supplierDtoList.add(supplierDto);
        }
        model.addAttribute("supplierList", supplierDtoList);

        return "main16/sub2";
    }

    @PostMapping("sub2")
    public String process2(SupplierDto supplier) throws Exception {
        String sql = """
                INSERT INTO Suppliers
                (SupplierName, ContactName, Address, City, PostalCode, Country, Phone)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, supplier.getName());
        statement.setString(2, supplier.getContact());
        statement.setString(3, supplier.getAddress());
        statement.setString(4, supplier.getCity());
        statement.setString(5, supplier.getPostalCode());
        statement.setString(6, supplier.getCountry());
        statement.setString(7, supplier.getPhone());
        statement.executeUpdate();

        return "redirect:/main16/sub2";
    }

    @GetMapping("sub3")
    public String form3(Integer id, Model model) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Customers
                    WHERE CustomerId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

//        statement.executeUpdate(); // insert, update, delete
            ResultSet resultSet = statement.executeQuery(); // select
            if (resultSet.next()) {
                //조회 결과가 있을 때만
                CustomerDto customerDto = new CustomerDto();
                customerDto.setId(resultSet.getInt("CustomerId"));
                customerDto.setName(resultSet.getString("CustomerName"));
                customerDto.setAddress(resultSet.getString("Address"));
                customerDto.setCity(resultSet.getString("City"));
                customerDto.setContactName(resultSet.getString("ContactName"));
                customerDto.setCountry(resultSet.getString("Country"));
                customerDto.setPostalCode(resultSet.getString("PostalCode"));

                model.addAttribute("customer", customerDto);
            }
        }

        return "main16/sub3";
    }

    @PostMapping("sub3")
    public String process3(Integer id, RedirectAttributes rttr) throws Exception {
        String sql = """
                DELETE
                FROM Customers
                WHERE CustomerId = ?
                """;

        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate(); // delete, update, insert

        rttr.addAttribute("id", id); // query string에 붙임

        return "redirect:/main16/sub3";
    }

    // 연습:
    // 공급자 조회 후 삭제 로직 완성
    // request handler method * 2, html * 1
    @GetMapping("sub4")
    public String get(Integer id, Model model) throws Exception {
        if (id != null) {
            // 조회 후 모델에 추가
            String sql = """
                    SELECT *
                    FROM Suppliers
                    WHERE SupplierId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                SupplierDto supplierDto = new SupplierDto();
                supplierDto.setId(resultSet.getInt("SupplierId"));
                supplierDto.setName(resultSet.getString("SupplierName"));
                supplierDto.setContact(resultSet.getString("ContactName"));
                supplierDto.setAddress(resultSet.getString("Address"));
                supplierDto.setCity(resultSet.getString("City"));
                supplierDto.setCountry(resultSet.getString("Country"));
                supplierDto.setPostalCode(resultSet.getString("PostalCode"));
                supplierDto.setPhone(resultSet.getString("Phone"));
                model.addAttribute("supplier", supplierDto);
            }
        }

        return "main16/sub4";
    }

    @PostMapping("sub4")
    public String delete(Integer id, RedirectAttributes rttr) throws Exception {
        String sql = """
                DELETE
                FROM Suppliers
                WHERE SupplierId = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.executeUpdate();
        rttr.addAttribute("id", id);

        return "redirect:/main16/sub4";
    }

    // update
    // get
    @GetMapping("sub5")
    public String select1(Integer id, Model model) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Customers
                    WHERE CustomerId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                CustomerDto customerDto = new CustomerDto();
                customerDto.setId(resultSet.getInt("CustomerId"));
                customerDto.setName(resultSet.getString("CustomerName"));
                customerDto.setContactName(resultSet.getString("ContactName"));
                customerDto.setAddress(resultSet.getString("Address"));
                customerDto.setCity(resultSet.getString("City"));
                customerDto.setCountry(resultSet.getString("Country"));
                customerDto.setPostalCode(resultSet.getString("PostalCode"));
                model.addAttribute("customer", customerDto);
            }
        }

        return "main16/sub5";
    }

    // post
    @PostMapping("sub5")
    public String update1(CustomerDto customer, RedirectAttributes rttr) throws Exception {
//        System.out.println("customer = " + customer);
        String sql = """
                UPDATE Customers
                SET CustomerName = ?,
                    ContactName = ?,
                    Address = ?,
                    City = ?,
                    PostalCode = ?,
                    Country = ?
                WHERE CustomerId = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, customer.getName());
        statement.setString(2, customer.getContactName());
        statement.setString(3, customer.getAddress());
        statement.setString(4, customer.getCity());
        statement.setString(5, customer.getPostalCode());
        statement.setString(6, customer.getCountry());
        statement.setInt(7, customer.getId());
        statement.executeUpdate(); // update

        rttr.addAttribute("id", customer.getId());

        return "redirect:/main16/sub5";
    }


    //연습 :
    // 공급자 정보 조회/수정
    // request handler method * 2, html * 1
    @GetMapping("sub6")
    public String select2(Integer id, Model model) throws Exception {
        if (id != null) {
            String sql = """
                    SELECT *
                    FROM Suppliers
                    WHERE SupplierId = ?
                    """;
            String url = "jdbc:mysql://localhost:3306/w3schools";
            String username = "root";
            String password = "1234";
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                SupplierDto supplierDto = new SupplierDto();
                supplierDto.setId(resultSet.getInt("SupplierId"));
                supplierDto.setName(resultSet.getString("SupplierName"));
                supplierDto.setContact(resultSet.getString("ContactName"));
                supplierDto.setAddress(resultSet.getString("Address"));
                supplierDto.setCity(resultSet.getString("City"));
                supplierDto.setCountry(resultSet.getString("Country"));
                supplierDto.setPostalCode(resultSet.getString("PostalCode"));
                supplierDto.setPhone(resultSet.getString("Phone"));

                model.addAttribute("supplier", supplierDto);

            }
        }
        return "main16/sub6";
    }

    @PostMapping("sub6")
    public String update2(SupplierDto supplierDto, RedirectAttributes rttr) throws Exception {
        String sql = """
                UPDATE Suppliers
                SET SupplierName = ?,
                    ContactName = ?,
                    Address = ?,
                    City = ?,
                    PostalCode = ?,
                    Country = ?,
                    Phone = ?
                WHERE SupplierId = ?
                """;
        String url = "jdbc:mysql://localhost:3306/w3schools";
        String username = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, supplierDto.getName());
        statement.setString(2, supplierDto.getContact());
        statement.setString(3, supplierDto.getAddress());
        statement.setString(4, supplierDto.getCity());
        statement.setString(5, supplierDto.getPostalCode());
        statement.setString(6, supplierDto.getCountry());
        statement.setString(7, supplierDto.getPhone());
        statement.setInt(8, supplierDto.getId());
        statement.executeUpdate();

        rttr.addAttribute("id", supplierDto.getId());

        return "redirect:/main16/sub6";
    }

}
