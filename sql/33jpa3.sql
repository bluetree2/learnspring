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
    , ('b',10000)
