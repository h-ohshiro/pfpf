/* ユーザーマスタ */
/*
INSERT IGNORE INTO m_user(
user_id
,password
,user_name
,birthday
,age
,gender
,department_id
,role
) VALUES
('test@co.jp', '$2a$10$vTZO7UYAeQPKyCEiFFj2keOJcZsTrDA.htVYZEmHtcsr7kbaUnZP6', 'システム管理者', '2000-01-01', 21, 1, 1, 'ROLE_ADMIN')
,('hoge@co.jp', '$2a$10$vTZO7UYAeQPKyCEiFFj2keOJcZsTrDA.htVYZEmHtcsr7kbaUnZP6', 'ユーザー1','2000-01-01', 21, 2, 2, 'ROLE_GENERAL') ;
*/
INSERT IGNORE INTO m_user(
user_id
,password
,user_name
,birthday
,age
,gender
,department_id
,role
) VALUES
('testtest@co.jp', '$2a$10$vTZO7UYAeQPKyCEiFFj2keOJcZsTrDA.htVYZEmHtcsr7kbaUnZP6', 'システム管理者', '2000-01-01', 21, 1, 1, 'ROLE_ADMIN')
,('hogehoge@co.jp', '$2a$10$vTZO7UYAeQPKyCEiFFj2keOJcZsTrDA.htVYZEmHtcsr7kbaUnZP6', 'ユーザー1','2000-01-01', 21, 2, 2, 'ROLE_GENERAL') ;
/* 部署マスタ */
INSERT IGNORE INTO m_department(
department_id
,department_name
)VALUES
(1, 'システム管理部')
,(2, '営業部')
;

/* 給料テーブル */
INSERT IGNORE INTO t_salary(
user_id
,year_month
,salary
)VALUES
('test@co.jp', '2020/11', 280000)
,('hoge@co.jp', '2020/12', 290000)
,('user@co.jp', '2021/01', 300000)
;