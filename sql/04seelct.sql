# SELECT : 조회할 열(columns) 지정
# FROM : 테이블명 지정
# WHERE : 행(records)를 필터링

# * : 모든 컬럼
SELECT *FROM Customers;

# 지정된 열
SELECT CustomerName
FROM Customers;

SELECT CustomerName, City, Country
FROM Customers;

SELECT Country, City, CustomerName
FROM Customers;

# 미국에 사는 고객들 이름 조회
SELECT CustomerName
FROM Customers
WHERE Country = 'USA';

# 미국에 사는 고객들 이름, 국가, 도시 조회
SELECT CustomerName, Country, City
FROM Customers
WHERE Country = 'USA';

# 연습 : 멕시코와 미국에 사는 고객들의 이름과 국가, 도시, 주소(ADDRESS)조회
SELECT CustomerName, Country, City, Address
FROM Customers
WHERE Country BETWEEN 'USA' AND 'MAXICO';
# 60 년대 태어난 직원들 이름(lastName, firstName) 조회
SELECT LastName, FirstName
FROM Employees
WHERE BirthDate BETWEEN '1960-01-01' AND '1960-12-31';
# 가격이 10(포함)~20(미포함)사잉인 상품의 가격, 상품명, 카테고리번호 조회
SELECT Price, ProductName, CategoryID
FROM Products
WHERE Price >= 10
  AND PRICE < 20;


