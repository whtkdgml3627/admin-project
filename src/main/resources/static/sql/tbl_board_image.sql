CREATE TABLE tbl_board_image (
	uuid varchar(50) PRIMARY KEY,
	file_name varchar(200) not null,
	bno int not null,
	ord int default 0,
	FOREIGN KEY (bno) REFERENCES tbl_board(bno) ON DELETE CASCADE
)
;

select * from tbl_board_image;

delete from tbl_board_image where bno = 720915;

insert into tbl_board_image (uuid, file_name, bno, ord)
values ('1', 'aa.jpg', 720909, 0);