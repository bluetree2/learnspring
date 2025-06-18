USE jpa;

SELECT *
FROM customer;

INSERT INTO customer
(customer_name, contact_name, address, city, postal_code, country)
SELECT customer_name, contact_name,address,city,postal_code,country
FROM customer;


SELECT COUNT(*)
FROM customer
WHERE country = 'mexico';


CREATE TABLE my_table20
(
    name VARCHAR(30),
    money INT,
    PRIMARY KEY (name)
);
INSERT INTO my_table20
(name, money)
value ('a',10000)
    , ('b',10000);

Create table my_table21
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    address VARCHAR(20),
    inserted_at DATETIME NOT NULL DEFAULT NOW()
);

INSERT INTO my_table21
(name, address)
VALUES ('lee','seoul');

INSERT INTO my_table21
(name, address)
VALUES ('kim','busan');

SELECT *
FROM my_table21;

create table my_table22
(
    name varchar(20),
    address varchar(20),
    coiuntry varchar(20),
    primary key  (name)
);

INSERT INTO  my_table22
    (name, address, coiuntry)
values ('kim','seoul','korea');

INSERT INTO my_table22
(address, coiuntry)
VALUES ('jeju', 'usa');

CREATE TABLE my_table23
(
    name VARCHAR(30),
    address VARCHAR(30),
    country VARCHAR(30),
    info VARCHAR(30),
    PRIMARY KEY (name,address)
);

CREATE TABLE my_table24
(
    email    VARCHAR(100) NULL,
    password VARCHAR(50) NULL,
    score    INT         NULL,
    name     VARCHAR(20) NOT NULL,
    address  VARCHAR(200) NOT NULL,
    CONSTRAINT pk_my_table24 PRIMARY KEY (name, address)
);

# 복합키가 있는 my_table 테이블 만들고 entity 만들어보기
CREATE TABLE my_table25
(
    name VARCHAR(30),
    address VARCHAR(100),
    city    VARCHAR(30),
    country VARCHAR(30),
    primary key (name,address)

);

# 복합키가 있는 Entity26만들고 my_table26 만들어보기
CREATE TABLE my_table26
(
    city    VARCHAR(255) NULL,
    age     INT          NOT NULL,
    name    INT          NOT NULL,
    address INT          NOT NULL,
    CONSTRAINT pk_entity26 PRIMARY KEY (name, address)
);

#foreign key (외래키, 참조키, FK)
CREATE TABLE my_table27
(
    id              INT PRIMARY KEY  AUTO_INCREMENT,
    categoryname    VARCHAR(30),
    info            VARCHAR(30)
);

CREATE TABLE my_table28
(
    id              INT PRIMARY KEY AUTO_INCREMENT,
    product_name    VARCHAR(30),
    price           INT,
    unit            VARCHAR(30),
    category_id     INT NOT NULL ,
    FOREIGN KEY (category_id) REFERENCES my_table27 (id)
);

CREATE TABLE my_table29
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(10),
    last_name VARCHAR(10),
    birth_date DATE
);

CREATE TABLE my_table30
(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    order_date DATE,
    info VARCHAR(20),
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES my_table29(id)
)

# 연습 : 29,30 엔티티 만들기
# repository * 2 만들기
# insert 만들기
# select 해보기

# request handler method *4
# service method *4