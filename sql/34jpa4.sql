USE jpa;

CREATE TABLE my_table31
(
    id      INT AUTO_INCREMENT PRIMARY KEY ,
    name    VARCHAR(30),
    country VARCHAR(30)
);

CREATE TABLE my_table32
(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    order_date DATE,
    info VARCHAR(30),
    customer_id INT NOT NULL ,
    employee_id INT NOT NULL ,
    FOREIGN KEY  (customer_id) REFERENCES my_table31 (id),
    FOREIGN KEY  (employee_id) REFERENCES my_table33 (id)
);
DROP TABLE  my_table32;


#직원
CREATE TABLE my_table33
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30),
    last_name  VARCHAR(30),
    birth_date  DATE,
    info        VARCHAR(50)
);


CREATE TABLE my_table34(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    birth_date DATE,
    info VARCHAR(30)
);

#강의
CREATE TABLE my_table35(
    id              INT AUTO_INCREMENT PRIMARY KEY ,
    lecture_title   VARCHAR(30),
    info            VARCHAR(50),
    place           VARCHAR(50)
);

# 학생-강의(수강)
CREATE TABLE my_table36
(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    registered_at DATE,
    enabled VARCHAR(1),
    money   VARCHAR(1),
    student_id INT NOT NULL ,
    lecture_id INT NOT NULL ,
    FOREIGN KEY (student_id) REFERENCES my_table34 (id),
    FOREIGN KEY (lecture_id) REFERENCES my_table35 (id)
);

# 연습
# 34 35 36 entity 만들기
# 1. intellij 도움으로 만들기
# 2. 지우고 직접 만들기

create table my_table37
(
    email varchar(30) primary key ,
    password varchar(30) not null,
    info varchar(30) not null ,
    inserted_at datetime not null  default now()
);

create table my_table38
(
    id int auto_increment primary key ,
    title varchar(30) not null ,
    content varchar(50) not null ,
    auther varchar(30) not null ,
    inserted_at datetime not null  default now(),
    FOREIGN KEY (auther) references my_table37 (email)
);

create table my_table39
(
    id int primary key auto_increment,
    name varchar(30),
    unit varchar(30),
    price int,
    category_id int,
    foreign key (category_id) references my_table40 (id)
);

# 카테고리 테이블
 create table my_table40
 (
     id int primary key auto_increment,
     name varchar(40),
     description varchar(50)
 )

 select p.id, p.name product_name, p.price, c.name category_name
 from my_table39 p
 join my_table40 c on p.category_id = c.id;

select * from  my_table39;
select * from my_table40;

INSERT INTO  my_table40
    (name, description)
select categoryname, SUBSTR(Description, 1,10)
from w3schools.Categories;
INSERT INTO  my_table39
(name, unit, price, category_id)
select ProductID, Unit, ROUND(Price, 0), CategoryID+1
from w3schools.Products
Limit 5;

# 연습
# projection
#  OrderInfo interface * 1
# Entity41 * 1
# Entity41Repository * 1
# Entity41Repository.query1() * 1
# service.action() * 1
# controller.sub() * 1

CREATE TABLE my_table41 (
    id          int primary key auto_increment,
    order_date date ,
    product_id  int,
    quantity    int,
    FOREIGN KEY (product_id) references my_table39 (id)
);

INSERT INTO my_table41
(order_date, product_id, quantity)
VALUES ('1998-01-01', 2, 12),
       ('1999-02-02', 2, 2),
       ('2000-03-03', 4, 34),
       ('2001-04-04', 5, 42),
       ('2002-05-05', 3, 5),
       ('2003-06-06', 3, 6);


select o.order_date, p.name product_name, p.price, o.quantity, c.name category_name
from my_table39 p
    join my_table40 c
        on p.category_id = c.id
    join my_table41 o
        on o.product_id = o.id

