# sub query : 쿼리 안의 쿼리
USE mydatabase;

# 한 번도 주문된 적 없는 상품 목록
SELECT p.ProductID, p.ProductName
FROM w3schools.OrderDetails od
         RIGHT JOIN w3schools.Products p on od.ProductID = p.ProductID
WHERE od.OrderDetailID IS NULL
ORDER BY p.ProductID;

# 1. 주문된 적 있는 상품 ID
SELECT ProductID
FROM w3schools.OrderDetails;

# 2. 위 쿼리결과 에 없는 상품 ID 들
SELECT ProductID, ProductName
FROM w3schools.Products
WHERE ProductID NOT IN (SELECT ProductID
                        FROM w3schools.OrderDetails);

# 상품과 카테고리 정보 조회
SELECT Products.ProductID, ProductName, CategoryName
FROM w3schools.Products
         JOIN w3schools.Categories c on Products.CategoryID = c.CategoryID;

SELECT ProductID,
       ProductName,
       (SELECT CategoryName
        FROM w3schools.Categories c
        WHERE c.CategoryID = p.CategoryID) CategoryName
FROM w3schools.Products p;

# 연습
# 1996-08-01 에 주문 처리한 직원명 조회
# JOIN, Sub Query
SELECT o.OrderDate, e.FirstName, e.LastName
FROM w3schools.Orders o
         JOIN w3schools.Employees e
              ON o.EmployeeID = e.EmployeeID
WHERE OrderDate = '1996-08-01';
SELECT OrderDate,
       (SELECT e.FirstName
        FROM w3schools.Employees e
        WHERE e.EmployeeID = o.EmployeeID)
FROM w3schools.Orders o
WHERE OrderDate = '1996-08-01';

# 연습
# 상품의 평균가격보다 높은 상품들 조회
# sub query
SELECT AVG(Price)
FROM w3schools.Products;

SELECT *
FROM w3schools.Products
WHERE Price > 28.866364;

SELECT *
FROM w3schools.Products
WHERE Price > (SELECT AVG(Price)
               FROM w3schools.Products);

# 상품의 평균가격이 50 이상인 카테고리 번호
SELECT CategoryID, AVG(Price)
FROM w3schools.Products
GROUP BY CategoryID
HAVING AVG(Price) >= 50;

SELECT *
FROM (SELECT CategoryID, AVG(Price) avg
      FROM w3schools.Products
      GROUP BY CategoryID) p
WHERE avg >= 50;

# 연습
# 1996-09 월 평균 처리 금액 보다 높은 금액을 처리한 직원 목록
# 1. 총 처리 금액
# 2. 직원 수 나누고
# 3. 직원별 처리 금액
# 4. 평균금액보다 높은 직원 조회

SELECT SUM(od.Quantity * p.Price)
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30';

SELECT COUNT(DISTINCT EmployeeID)
FROM w3schools.Orders o
WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30';

SELECT (SELECT SUM(od.Quantity * p.Price)
        FROM w3schools.Orders o
                 JOIN w3schools.OrderDetails od
                      ON o.OrderID = od.OrderID
                 JOIN w3schools.Products p
                      ON od.ProductID = p.ProductID
        WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30') /
       (SELECT COUNT(DISTINCT EmployeeID)
        FROM w3schools.Orders o
        WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30');

SELECT e.EmployeeID, e.LastName, e.FirstName, SUM(od.Quantity * p.Price) sum
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od
              ON o.OrderID = od.OrderID
         JOIN w3schools.Products p
              ON od.ProductID = p.ProductID
         JOIN w3schools.Employees e ON
    e.EmployeeID = o.EmployeeID
WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30'
GROUP BY e.EmployeeID
HAVING sum > (SELECT (SELECT SUM(od.Quantity * p.Price)
                      FROM w3schools.Orders o
                               JOIN w3schools.OrderDetails od
                                    ON o.OrderID = od.OrderID
                               JOIN w3schools.Products p
                                    ON od.ProductID = p.ProductID
                      WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30') /
                     (SELECT COUNT(DISTINCT EmployeeID)
                      FROM w3schools.Orders o
                      WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30'))
ORDER BY EmployeeID;







