
create database db_oauth2;

create table IF NOT EXISTS oauth_client_details (
    client_id VARCHAR(256) PRIMARY KEY,
    resource_ids VARCHAR(256),
    client_secret VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256)
);

insert into oauth_client_details(client_id, resource_ids,client_secret,scope,authorized_grant_types,web_server_redirect_uri,authorities,access_token_validity,refresh_token_validity,additional_information,autoapprove)
values('foo',null,'{bcrypt}$2a$10$wPb4BM6c/IqweuscNtQqgu0npxBn0i1qKbx3hGwJ26C3Wi5fHonuy','read,write','authorization_code,password,client_credentials,implicit,refresh_token','http://localhost:8080/test/auth','ROLE_USER',36000,50000,null,null);

insert into oauth_client_details(client_id, resource_ids,client_secret,scope,authorized_grant_types,web_server_redirect_uri,authorities,access_token_validity,refresh_token_validity,additional_information,autoapprove)
values('saffron',null,'{bcrypt}$2a$10$z2k2A4vIQPQC5A33Xtr4Cuvmm7zOsGbqHcIRIx1OFmxdfUyuKjIv6','read,write,profile,email','authorization_code,password,client_credentials,implicit,refresh_token'
       ,'http://localhost:8080/login/oauth2/code/local','ROLE_USER',36000,50000,null,null);
   
CREATE TABLE tbl_user (
    msrl BIGINT(20) NOT NULL,
    name VARCHAR(100) NOT NULL,
    password VARCHAR(100) NULL DEFAULT NULL,
    provider VARCHAR(100) NULL DEFAULT NULL,
    uid VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    PRIMARY KEY (msrl),
    UNIQUE INDEX UK_tbl_user_uid (uid)
);

drop table user_roles;

CREATE TABLE `user_roles` (
    `user_msrl` BIGINT(20) NOT NULL,
    `roles` VARCHAR(255) NULL DEFAULT NULL,
    INDEX `FK7ie1lfmnysdogxy1g91ernbkv` (`user_msrl`),
    CONSTRAINT `FK_tbl_user_msrl` FOREIGN KEY (`user_msrl`) REFERENCES `tbl_user` (`msrl`)
);

insert into tbl_user 
values('1000','now09','{bcrypt}$2a$10$iqlbfAvENGDyuDkWdl48Ru0MGo7yHj2rwUAwKTxL7JGJV2df2GfEq','','now09','now09@email.com');

insert into user_roles 
values('1000','ROLE_USER');

-- pass : 1111
insert into tbl_user 
values('1001','now009','{bcrypt}$2a$10$ZvZi0zadD7R0s9wOBzE6Eu6SxlmU3EtUbkz57h8uIylit0.rPv1MK','','now009','now009@email.com');

insert into user_roles 
values('1001','ROLE_USER');

create table IF NOT EXISTS oauth_client_token (
    token_id VARCHAR(256),
    token BLOB,
    authentication_id VARCHAR(256) PRIMARY KEY,
    user_name VARCHAR(256),
    client_id VARCHAR(256)
);

create table IF NOT EXISTS oauth_access_token (
    token_id VARCHAR(256),
    token BLOB,
    authentication_id VARCHAR(256) PRIMARY KEY,
    user_name VARCHAR(256),
    client_id VARCHAR(256),
    authentication BLOB,
    refresh_token VARCHAR(256)
);

create table IF NOT EXISTS oauth_refresh_token (
    token_id VARCHAR(256),
    token BLOB,
    authentication BLOB
);

create table IF NOT EXISTS oauth_code (
    code VARCHAR(256), authentication BLOB
);

create table IF NOT EXISTS oauth_approvals (
    userId VARCHAR(256),
    clientId VARCHAR(256),
    scope VARCHAR(256),
    status VARCHAR(10),
    expiresAt TIMESTAMP,
    lastModifiedAt TIMESTAMP
);
