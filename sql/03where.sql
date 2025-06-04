#or
SELECT * FROM Customers
WHERE City = 'Barcelona'
   OR City = 'Bern'
   OR CITY = 'Lisboa';

# IN

SELECT *
FROM Customers
WHERE City IN ('Barcelona','Bern','Lisboa');

#연습
# 미국, 영국, 스웨덴에 있는 고객들 조회
SELECT *
FROM Customers
WHERE Country IN ('USA', 'UK', 'sweden');
# 1,2,5 카테고리ID인 상품들 조회
SELECT *
FROM Products
WHERE CategoryID IN (1, 2, 5);
# 일본, 독일에 있는 공급자 조회(SUPPLIERS)
SELECT *
FROM Suppliers
WHERE Country IN ('Japen', 'Germany');

# AND
SELECT * FROM Products
WHERE Price >= 50.00
  AND Price <= 59.99;

# BETWEEN AND
SELECT *
FROM Products
WHERE Price BETWEEN  50.00 AND 59.99; # 두 값 모두 포함

# 연습 : 1950대 태어난 직원들 조회
SELECT *
FROM Employees
where BirthDate  between '1950-01-01' AND '1950-12-12';
#       1997년 7월에 주문한 주문 데이터 조회(ORDERS)
SELECT *
FROM Orders
WHERE OrderDate between '1997-07-01' AND '1997-07-31';



