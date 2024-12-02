create table tbl_member(
    id bigint unsigned auto_increment primary key,
    member_email varchar(255) not null,
    member_password varchar(255) not null,
    member_name varchar(255) not null
);

select * from tbl_member;
