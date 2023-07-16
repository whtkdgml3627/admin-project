CREATE TABLE tbl_board_image (
	uuid varchar(50) PRIMARY KEY,
	file_name varchar(200) not null,
	bno int not null,
	ord int default 0,
	FOREIGN KEY (bno) REFERENCES tbl_board(bno) ON DELETE CASCADE
)
;

select * from tbl_board_image;