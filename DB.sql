DROP DATABASE IF EXISTS `24_08_p1`;
CREATE DATABASE `24_08_p1`;
USE `24_08_p1`;

CREATE TABLE `charac`(
      id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
      regDate DATETIME NOT NULL,
      updateDate DATETIME NOT NULL,
      memberId INT(10),
      `name` CHAR(100) NOT NULL,
      `type` TEXT NOT NULL  COMMENT '캐릭터 속성',
      
      lr INT(10) NOT NULL DEFAULT 650,
      ud INT(10) NOT NULL DEFAULT 850,
      `level` INT(10) NOT NULL DEFAULT 1,
      money INT(10) NOT NULL DEFAULT 0,
      hp INT(10) NOT NULL DEFAULT 550,
      `exp` INT(10) NOT NULL DEFAULT 0,
      location TEXT NOT NULL DEFAULT "village" COMMENT '캐릭터 위치'
);

CREATE TABLE `member`(
      id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
      regDate DATETIME NOT NULL,
      updateDate DATETIME NOT NULL,
      loginId CHAR(30) NOT NULL,
      loginPw CHAR(100) NOT NULL,
      `authLevel` SMALLINT(2) UNSIGNED DEFAULT 3 COMMENT '권한 레벨 (3=일반, 7=관리자)',
      `name` CHAR(20) NOT NULL,
      nickname CHAR(20) NOT NULL,
      cellphoneNum CHAR(20) NOT NULL,
      email CHAR(50) NOT NULL,
      delStatus TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '탈퇴 여부 (0=탈퇴 전, 1=탈퇴 후)',
      delDate DATETIME COMMENT '탈퇴 날짜'
);

CREATE TABLE img (
       `key` INT(10) UNSIGNED NOT NULL,
       `level` INT(10) UNSIGNED NOT NULL,
       `name` CHAR(20) NOT NULL,
       url TEXT NOT NULL
);

## 테스트 회원 생성
INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'asd',
loginPw = 'asd',
`authLevel` = 7,
`name` = '관리자',
nickname = '관리자',
cellphoneNum = '01012341234',
email = 'abc@gmail.com';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'qwe',
loginPw = 'qwe',
`name` = '회원1_이름',
nickname = '회원1_닉네임',
cellphoneNum = '01043214321',
email = 'abcd@gmail.com';

INSERT INTO `member`
SET regDate = NOW(),
updateDate = NOW(),
loginId = 'zxc',
loginPw = 'zxc',
`name` = '회원2_이름',
nickname = '회원2_닉네임',
cellphoneNum = '01056785678',
email = 'abcde@gmail.com';

SELECT *
FROM `charac`
WHERE `memberId` = 1;

SELECT *
FROM `charac`;

SELECT *
FROM `member`;


INSERT INTO `charac` SET regDate = NOW(), updateDate = NOW(), memberId = 1, `name` = "qwe",  `type` = "https://github.com/user-attachments/assets/d445c3ce-bb6a-4728-a1a1-45ac148b0058";
UPDATE `charac` SET lr = 350, ud = 350, hp = 250, money = 99999999 WHERE id = 1;
INSERT INTO `charac` SET regDate = NOW(), updateDate = NOW(), memberId = 1, `name` = "asd",  `type` = "https://github.com/user-attachments/assets/2f795830-7be7-469c-919d-eca8397df66c";
INSERT INTO `charac` SET regDate = NOW(), updateDate = NOW(), memberId = 1, `name` = "zxc",  `type` = "https://github.com/user-attachments/assets/70c3151e-406a-4b57-a315-bedc694e0642";

INSERT INTO img SET `key` = 1, `level` = 1, `name` = "불타입 1단계", url = "https://github.com/user-attachments/assets/fdf48c2f-3cbe-43fc-98a7-30221b7e76ba";
INSERT INTO img SET `key` = 1, `level` = 2, `name` = "불타입 2단계", url = "https://github.com/user-attachments/assets/fda0a7c0-8e36-4c1b-83b0-6f46568cf8a5"; 
INSERT INTO img SET `key` = 1, `level` = 3, `name` = "불타입 3단계", url = "https://github.com/user-attachments/assets/d445c3ce-bb6a-4728-a1a1-45ac148b0058";

INSERT INTO img SET `key` = 2, `level` = 1, `name` = "물타입 1단계", url = "https://github.com/user-attachments/assets/ddc0532f-8541-4839-9a01-e0e5ca75e64c";
INSERT INTO img SET `key` = 2, `level` = 2, `name` = "물타입 2단계", url = "https://github.com/user-attachments/assets/22066737-7373-486d-8aa8-f3c2554e23d4";
INSERT INTO img SET `key` = 2, `level` = 3, `name` = "물타입 3단계", url = "https://github.com/user-attachments/assets/2f795830-7be7-469c-919d-eca8397df66c";

INSERT INTO img SET `key` = 3, `level` = 1, `name` = "풀타입 1단계", url = "https://github.com/user-attachments/assets/df177da2-b93b-4acf-9f13-ef680da07ea3";
INSERT INTO img SET `key` = 3, `level` = 2, `name` = "풀타입 2단계", url = "https://github.com/user-attachments/assets/895d4d6b-8eaa-425b-8503-21b0815b3245";
INSERT INTO img SET `key` = 3, `level` = 3, `name` = "풀타입 3단계", url = "https://github.com/user-attachments/assets/70c3151e-406a-4b57-a315-bedc694e0642";