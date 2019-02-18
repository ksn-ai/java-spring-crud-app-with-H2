create table users (uid bigint generated by default as identity, name varchar(255), primary key (uid));
create table user_details (uid bigint generated by default as identity, address varchar(555), email varchar(255), primary key (uid));
alter table user_details add constraint FKcaf6ht0hfw93lwc13ny0sdmvo foreign key (uid) references users(uid);