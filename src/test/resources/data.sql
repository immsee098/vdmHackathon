CREATE SCHEMA IF NOT EXISTS chatmetlife;

DROP TABLE IF EXISTS chatmetlife.chat_code;

CREATE TABLE chatmetlife.chat_code
(
    code_num      INT AUTO_INCREMENT PRIMARY KEY,
    menu_level    INT,
    code_name     VARCHAR(50),
    chat_response VARCHAR(300),
    created_at    DATETIME DEFAULT CURRENT_TIMESTAMP,
    modify_at     DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    dlt_yn        VARCHAR(2),
    PARENT_CODE_NUM  INT
);


INSERT INTO chatmetlife.chat_code (menu_level, code_name, created_at, modify_at, dlt_yn) VALUES (1, '보상', '2024-03-23 20:47:19', '2024-03-23 20:47:19', 'N');
INSERT INTO chatmetlife.chat_code (menu_level, code_name, created_at, modify_at, dlt_yn) VALUES (1, '보험', '2024-03-23 20:47:44', '2024-03-23 20:47:44', 'N');
INSERT INTO chatmetlife.chat_code (menu_level, code_name, created_at, modify_at, dlt_yn) VALUES (1, '대출', '2024-03-23 20:48:06', '2024-03-23 20:48:06', 'N');
INSERT INTO chatmetlife.chat_code (menu_level, code_name, created_at, modify_at, dlt_yn) VALUES (1, '홈페이지', '2024-03-23 20:48:39', '2024-03-23 20:48:39', 'N');
INSERT INTO chatmetlife.chat_code (menu_level, code_name, created_at, modify_at, dlt_yn) VALUES (1, '기타', '2024-03-23 20:48:51', '2024-03-23 20:48:51', 'N');
