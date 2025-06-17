USE mydatabase;

CREATE TABLE table38
(
    id INT
);
INSERT INTO table38
    (id)
VALUES (9),
       (8),
       (7);

SELECT *
FROM table34;
SELECT *
FROM table35;
SELECT *
FROM table38;

SELECT *
FROM table34 t34
         JOIN table35 t35
         JOIN table38 t38;

SELECT *
FROM w3schools.Products p
         JOIN w3schools.Categories c
         JOIN w3schools.Suppliers s
WHERE p.CategoryID = c.CategoryID
  AND p.SupplierID = s.SupplierID;

SELECT *
FROM w3schools.Products p
         JOIN w3schools.Categories c
              ON p.CategoryID = c.CategoryID
         JOIN w3schools.Suppliers s
              ON p.SupplierID = s.SupplierID;

# 카테고리별 공급자 정보
SELECT c.CategoryName, s.SupplierName
FROM w3schools.Products p
         JOIN w3schools.Categories c
              ON p.CategoryID = c.CategoryID
         JOIN w3schools.Suppliers s
              ON p.SupplierID = s.SupplierID
ORDER BY c.CategoryName;

# 공급자별 공급하는 상품 카테고리
SELECT DISTINCT s.SupplierName, c.CategoryName
FROM w3schools.Products p
         JOIN w3schools.Categories c
              ON p.CategoryID = c.CategoryID
         JOIN w3schools.Suppliers s
              ON p.SupplierID = s.SupplierID
ORDER BY s.SupplierName;

SELECT DISTINCT s.ShipperName, c.CustomerName
FROM w3schools.Orders o
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
         JOIN w3schools.Shippers s
              ON o.ShipperID = s.ShipperID
ORDER BY s.ShipperName, c.CustomerName;

# 연습
# 1996-07-05 에 주문된 상품명 목록
# Orders, OrderDetails, Products
SELECT o.OrderDate, p.ProductName
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
WHERE OrderDate = '1996-07-05'
ORDER BY p.ProductName;

# 연습
# Tofu 상품을 어떤 고객이 언제 주문했는지 조회
# Orders, Products, Customers, OrderDetails
SELECT p.ProductName, c.CustomerName, o.OrderDate
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
# WHERE ProductName = 'Tofu'
WHERE p.ProductID = 14 # 조건에 사용된는 컬럼들은 PK 사용할 수록 성능이 좋음
ORDER BY c.CustomerName, o.OrderDate;

# 우수고객 선정 조회
# 고객별 주문 금액
# Orders, OrderDetails, Products, Customers
SELECT c.CustomerName, SUM(od.Quantity * p.Price) 합
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON p.ProductID = od.ProductID
         JOIN w3schools.Customers c
              ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
ORDER BY 합 DESC;

# 연습
# 1997-09 월에 가장 많은 주문(가격 기준)을 처리한 직원 조회
# Employees, Orders, OrderDetails, Products
SELECT e.FirstName, e.LastName, SUM(p.Price * od.Quantity) 합
FROM w3schools.Employees e
         JOIN w3schools.Orders o on e.EmployeeID = o.EmployeeID
         JOIN w3schools.OrderDetails od on o.OrderID = od.OrderID
         JOIN w3schools.Products p on od.ProductID = p.ProductID
WHERE OrderDate BETWEEN '1997-09-01' AND '1997-09-30'
GROUP BY e.EmployeeID
ORDER BY 합 DESC;



