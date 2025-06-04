# distinct : 조회 결과에서 중복 제거

# 91 ROWS
SELECT Country
FROM Customers;

SELECT DISTINCT Country
FROM Customers
ORDER BY Country;

SELECT DISTINCT Country, City
FROM Customers
ORDER BY Country, City;

# 연습 : 공급자(SUPPLIERS)가 있는 국가들 중복없이 abc 순으로 조회
SELECT distinct Country
FROM Suppliers
order by 1;
# 고객이 있는 도시들을 중복없이 abc 순으로 조회
SELECT DISTINCT City
FROM  Customers
ORDER BY 1;