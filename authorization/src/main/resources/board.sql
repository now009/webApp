-- Board

create table Board (
 BRD_IDX int(20) not null,
 USER_ID  varchar(20) NOT NULL,
 USER_NAME varchar(50),
 USER_EMAIL VARCHAR(100),
 SUBJECT VARCHAR(200) not NULL,
 CONTENT VARCHAR(2000) not NULL,
 DEL_YN CHAR(1),
 CREATE_DT DATETIME,
 CREATE_USER varchar(20) ,
 MODIFY_DT DATETIME,
 MODIF_USER varchar(20) ,
 PRIMARY KEY (BRD_IDX)
);

insert into Board VALUES(1,'T001','TNAME001','T001@saffron.com','SUB_001','CONTNET001','N',current_timestamp(),'ADM',current_timestamp(),'ADM');
insert into Board VALUES(2,'T002','TNAME002','T002@saffron.com','SUB_002','CONTNET002','N',current_timestamp(),'ADM',current_timestamp(),'ADM');
insert into Board VALUES(3,'T003','TNAME003','T003@saffron.com','SUB_003','CONTNET003','N',current_timestamp(),'ADM',current_timestamp(),'ADM');
insert into Board VALUES(4,'T004','TNAME004','T004@saffron.com','SUB_004','CONTNET004','N',current_timestamp(),'ADM',current_timestamp(),'ADM');
insert into Board VALUES(5,'T005','TNAME005','T005@saffron.com','SUB_005','CONTNET005','N',current_timestamp(),'ADM',current_timestamp(),'ADM');

select * from board;

delete  from board;

select current_date(),current_time(),current_timestamp() from dual;  

select 
 BRD_IDX ,USER_ID ,USER_NAME ,USER_EMAIL ,SUBJECT ,CONTENT ,DEL_YN
 ,TO_CHAR(CREATE_DT,'YYYYMMDDHH24MISS') as CREATE_DT
 ,CREATE_USER 
 ,TO_CHAR(MODIFY_DT,'YYYYMMDDHH24MISS') as MODIFY_DT
 ,MODIF_USER
from Board
where DEL_YN = 'N';

