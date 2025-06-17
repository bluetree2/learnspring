USE mydatabase;

# 게시물
# 제목, 본문, 작성일시, 회원ID
CREATE TABLE table43
(
    id               INT PRIMARY KEY AUTO_INCREMENT,
    title            VARCHAR(255),
    content          VARCHAR(10000),
    create_at        DATETIME,
    table44_username VARCHAR(20),
    FOREIGN KEY (table44_username) REFERENCES table44 (username)
);
DROP TABLE table43;
DESC table43;

# 회원
# ID, PW, 자기소개
CREATE TABLE table44
(
    username VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20),
    notes    VARCHAR(5000)

);

# 1대N, N대1

# 1대1 (잘 보이진 않음)
# 직원정보
CREATE TABLE table45
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(20),
    hire_date DATE,
    school    VARCHAR(20)
);

#직원연봉
CREATE TABLE table46
(
    id     INT PRIMARY KEY,
    salary INT,
    FOREIGN KEY (id) REFERENCES table45 (id)
);

DROP TABLE table47;
DROP TABLE table48;
# N대N
# 학생
CREATE TABLE table48
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    info VARCHAR(20)
);
# 수업
CREATE TABLE table47
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(20),
    schedule VARCHAR(20),
    info     VARCHAR(20)

);
# 학생수업 (연결,조인,중간 테이블)
CREATE TABLE table49
(
    table48_id INT,
    table47_id INT,

    PRIMARY KEY (table48_id, table47_id),
    FOREIGN KEY (table48_id) REFERENCES table46 (id),
    FOREIGN KEY (table47_id) REFERENCES table47 (id)
);

# 연습
# 다대다 테이블 만들어 보기
# 50,51,52
# 영화, 배우, 영화-배우
CREATE TABLE table50
(
    id     INT AUTO_INCREMENT PRIMARY KEY,
    title  VARCHAR(30),
    length VARCHAR(50),
    info   VARCHAR(50)
);
CREATE TABLE table51
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(30),
    birth_date DATE,
    info       VARCHAR(50)
);

CREATE TABLE table52
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    table50_id INT,
    table51_id INT,
    money      INT,
    info       VARCHAR(30),
#     PRIMARY KEY (table50_id, table51_id),
    FOREIGN KEY (table50_id) REFERENCES table50 (id),
    FOREIGN KEY (table51_id) REFERENCES table51 (id)
);







