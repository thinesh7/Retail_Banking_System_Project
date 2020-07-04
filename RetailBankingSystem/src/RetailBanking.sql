create table Bankemployees(username varchar2(20) not null,password varchar2(20) not null);


drop table Bankemployees

insert into Bankemployees values('manager','manager');
insert into Bankemployees values('cashier','cashier');

select * from BANKEMPLOYEES

delete from BANKEMPLOYEES

create table Userstore (username varchar2(20) not null,password varchar2(20) not null,login_timestamp timestamp);

select * from userstore

drop table userstore


drop table customer_retail


create table customer_retail (customerid varchar2(10) not null,customerssnid varchar2(20) not null,customername varchar2(20) not null,
age number(3) not null,addressline1 varchar2(20) not null,addressline2 varchar2(20) not null,state varchar2(15) not null,city varchar2(20) not null );

delete from customer_retail where customerid='CUST_5'
select customerid from customer_retail

alter table customer_retail add primary key (customerid)

create sequence customer_retail_seq START WITH 1 INCREMENT BY  1

drop sequence customer_retail_seq

select * from customer_retail
where customerid='CUST_2'


select * from customer_retail where customerssnid='123456789'

select * from customer_retail where customerssnid like '123456789'  or customername like '123456789'

<---ACOUNT TABLE--->
create table account (accountid varchar2(20) unique,customerid varchar2(20) not null,accounttype varchar2(20) not null,deposit number not null);
ALTER TABLE account ADD FOREIGN KEY (customerid) REFERENCES customer_retail(customerid);

drop table account
select * from account 
where accounttype='currentaccount'

create sequence account_seq START WITH 1100223300 INCREMENT BY  1

drop sequence account_seq

select * from account where customerid='CUST_6' and accounttype='Savings Account'

select * from customer_retail c inner join account a on c.customerid=a.customerid where a.accountid like '159648210' or c.customerid like '159648210' or c.customerssnid like '159648210'

<---CUSTOMER STATUS TABLE---->


create table customer_status (customerssnid varchar2(20) not null,customerid varchar2(20) not null,
status varchar2(10) not null,message varchar2(100) not null,last_updated timestamp)

alter table customer_status add foreign key (customerid) references customer_retail(customerid);

drop table customer_status

select * from customer_status

select * from customer_status where customerssnid like'159648210'


<-----ACCOUNT STATUS TABLE----->

create table account_status (customerid varchar2(20) not null,accountid varchar2(20) not null,accounttype varchar2(20) not null,
status varchar2(10) not null,message varchar2(100) not null,last_updated timestamp)

drop table account_status

select * from account_status

alter table account_status add foreign key (accountid) references account(accountid);
alter table account_status add foreign key (customerid) references customer_retail(customerid);


<-----TRANSACTION TABLE----->


create table transaction_table (transactionid varchar2(20) primary key,accountid varchar2(20) not null,message varchar2(50) not null,amount number ,last_updated timestamp)

select * from transaction_table
select * from customer_retail c inner join account a on c.customerid=a.customerid where accountid='1100223302'


create sequence transaction_seq START WITH 874125000 INCREMENT BY  1

drop sequence transaction_seq

