# Shop4u
Shop4u
Cong nghe ds Spring MVC - Spring Security

create schema BAN_HANH;
ALTER TABLE `ban_hanh`.`product` ADD COLUMN `detail` VARCHAR(4000) NULL AFTER `img`;
CREATE TABLE Users(
    id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    favourites VARCHAR(255),
    email VARCHAR (50) NOT NULL UNIQUE, 
    gender VARCHAR(255) ,
	about VARCHAR(255)
);
CREATE TABLE Language(
    id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    lan VARCHAR(2) NOT NULL,
    keyword VARCHAR(255),
    content VARCHAR(255)
);
CREATE TABLE Bill(
    id_Bill INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT ,
    id_User INT(11) NOT NULL ,
    lan VARCHAR(2) NOT NULL,
    total double,
    dateCreate datetime,
    FOREIGN KEY (id_User) REFERENCES users(id)
);
 
drop table Bill;
alter TABLE bill add FOREIGN KEY (id) REFERENCES category(id);


use BAN_HANH;
Drop Table Language;
insert into Language(lan,keyword,content) value ("vi","logout","Đăng Nhập");
insert into Language(lan,keyword,content) value ("vi","logout","Đăng Xuất");
insert into Language(lan,keyword,content) value ("vi","vi","Tiếng Việt");
insert into Language(lan,keyword,content) value ("vi","update","cập nhật");
insert into Language(lan,keyword,content) value ("vi","add","thêm");
insert into Language(lan,keyword,content) value ("vi","delete","xóa");
insert into Language(lan,keyword,content) value ("vi","detail","chi tiết");
insert into Language(lan,keyword,content) value ("vi","submit","Tiếng Anh");
insert into Language(lan,keyword,content) value ("en","logout","logout");
insert into Language(lan,keyword,content) value ("en","vi","VietNamese");
insert into Language(lan,keyword,content) value ("en","update","update");
insert into Language(lan,keyword,content) value ("en","add","add");
insert into Language(lan,keyword,content) value ("en","delete","delete");
insert into Language(lan,keyword,content) value ("en","detail","detail");
insert into Language(lan,keyword,content) value ("en","submit","submit");

DELETE FROM Language WHERE lan = "vi";
select * from Language;
select * from users;
delete from users where id = 18;
DROP Table users;
insert into Users (username,password,favourites,email,gender,about) value("Admin1997","12345","abc","admin@gmail.com","BOY","NO info");


use ban_hanh;
select users.id,users.username,bill.total,bill.dateCreate from users,bill where users.id=bill.id_Users ;
select * from users; 
select * from bill; 

SELECT field1, field2
FROM table_name
WHERE ...
ORDER BY column_name, order_type
LIMIT start, limit

-- Sử dụng AS (Alias) trong MySQL
-- 1.Sử dụng AS (Alias) cho column
select users.id as id,users.username,bill.total,bill.dateCreate 
from users,bill
where id=bill.id_User ;

-- 2.Sử dụng AS (Alias) cho table
select A.id,A.username,B.total 
from users as A ,bill as B 
where A.id = B.id_User limit 0,10 ;


-- Nếu bạn cần viết hai câu truy vấn SELECT khác nhau nhưng bạn muốn nó trả về một danh sách kết quả duy nhất thì bạn phải sử dụng toán tử UNION. 
-- Toán tử này cũng ít khi sử dụng khi bạn viết ứng dụng
-- Web nhưng cũng nên tìm hiểu vì biết đâu sau này cần.

-- Toán tử UNION cho phép bạn nối kết quả của hai hoặc nhiều câu truy vấn lại 
-- với nhau để trở thành một danh sách kết quả duy nhất. Cú pháp của MySQL UNION như sau:

SELECT column1, column2
UNION [DISTINCT (loai no ket qu trung nhau) | ALL (ko loai bo)]
SELECT column1, column2
UNION [DISTINCT | ALL]

-- nguyen tac
-- 1.Số lượng colums trong tất cả các lệnh SELECT phải bằng nhau
-- 2.Mỗi column tương ứng vị trí phải có cùng kiểu dữ liệu và độ dài



-- BETWEEN
-- Select trong khoảng với BETWEEN trong MySQL
select * from bill where total BETWEEN 1500 AND 5000;
-- Select ngoài khoảng với BETWEEN trong MySQL
select * from bill where total NOT BETWEEN 1500 AND 5000;


-- BETWEEN thường sử dụng với dữ liệu kiểu INT, tuy nhiên bạn vẫn sử dụng được với các kiểu dữ liệu khác như:

-- CHARACTER: Tuân theo thứ tự trong bảng mã ASCII
-- DATE: Bạn nên sử dụng thêm hàm CASE chuyển dữ liệu sang dạng DATE để có kết quả chính xác nhất.
select * from Users where username between 'c' AND 'D';

select * from bill 
where dateCreate 
between cast('2020-07-27 00:00:00' as date) AND cast('2020-09-28 00:00:00' as date);

select * from users; 
UPDATE users SET favourites = CONCAT('', 'minh chi la user') WHERE role = 'ROLE_USER';

select * from users join bill on users.id = bill.id_User;

-- Hãy liệt kê danh sách sinh viên, thông tin lớp và khoa mà sinh viên đó đang học.


-- /////////////////////////////////////////////////
-- Left join
use ban_hanh;
select * from users ;
select * from bill;
-- Left join trong MySQL cũng giống như Inner Join, có một điểu khác là nó sẽ lấy kết quả ở bên trái 
-- trong trường hợp bên phải không có dữ liệu phù hợp.
select * from users left join bill on users.id = bill.id_User;

-- Right Join trong MySQL
select * from users right join bill on users.id = bill.id_User;
select * from bill right join users on users.id = bill.id_User;


-- Group By trong MySQL

-- Mệnh đề GROUP BY sẽ gom nhóm dữ liệu và chỉ trả về một record cho một
-- nhóm duy nhất, vì vậy nó giúp giảm bớt dữ liệu không cần thiết trong kết quả trả về.

-- Lệnh này thường kết hợp với các hàm như: SUM, AVG, MAX, MIN và COUNT 
-- để đếm hoặc lấy thông tin cần thiết trả về cho từng nhóm.

-- xem tong so tien ma moi nguoi dung da thanh toan va so lan thanh toan
select id_User,count(id_User),sum(total) from bill group by id_User ;
select * from bill 

-- Bạn có thể thêm điều kiện lọc ở lệnh Group By bằng cách sử 
-- dụng mệnh đề Having. Lúc này thứ tự chạy sẽ như sau:
-- From -> Where -> Select -> Group By -> Having -> Order By -> Limit


select id_User,count(id_User) as SoLanGiaoDich,sum(total) as TongTien 
from bill 
group by id_User 
having TongTien >=5000  ;

-- thu dat where

select id_User,count(id_User) as SoLanGiaoDich,sum(total) as TongTien 
from bill 
where TongTien >=5000
group by id_User ;

-- truong hop tren say ra loi ko th tim thay cot 'TongTien'


-- Truy vấn con (Sub Query) trong MySQL
select * from users join (
	select * from bill 
	where id_User=40
)as class_mtp on id= class_mtp.id_User;


-- tao view
create view ThongKeGiaoDich
as
	select id_User,count(id_User) as SoLanGiaoDich,sum(total) as TongTien 
    from bill 
	group by id_User ;
    
-- lay view
select * from ThongKeGiaoDichMoi
DROP VIEW IF EXISTS ThongKeGiaoDichMoi;
RENAME TABLE ThongKeGiaoDich TO ThongKeGiaoDichMoi;

SHOW CREATE VIEW ThongKeGiaoDichMoi;
-- ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

-- Dòng đầu tiên DELIMITER $$dùng để phân cách bộ nhớ lưu trữ thủ tục Cache 
-- và mở ra một ô lưu trữ mới. Đây là cú pháp nên bắt buộc bạn phải nhập như vậy
-- Dòng CREATE PROCEDURE procedureName() dùng để khai báo tạo một
--  Procedure mới, trong đó procedureName chính là tên thủ tục còn hai từ đầu là từ khóa.
--  BEGINvà END; $$dùng để khai báo bắt đầu của Procedure và kết thúc Procedure
--  Cuối cùng là đóng lại ô lưu trữ DELIMITER ;
use ban_hanh;
DELIMITER $$
Create procedure getAllPament()
begin
	select id_User,count(id_User) as SoLanGiaoDich,sum(total) as TongTien 
    from bill 
	group by id_User ;
end$$
DELIMITER;

DELIMITER $$
DROP PROCEDURE IF EXISTS `getAllPament`$$
call getAllPament();

-- Khai bao va su dung bien trong MYSQL

DELIMITER $$
create procedure getInfoUser(in id int)
begin
		declare ID_USER int default 0; -- khai bao bien
        set ID_USER = id;
        select * from Users where id = ID_USER; 
end $$
DELIMITER ;
call getInfoUser(40);
show procedure status;

