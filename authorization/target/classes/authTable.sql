create table oauth_client_details (
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

insert into oauth_client_details(
   client_id
   ,resource_ids
   ,client_secret
   ,scope
   ,authorized_grant_types
   ,web_server_redirect_uri
   ,authorities
   ,access_token_validity
   ,refresh_token_validity
   ,additional_information
   ,autoapprove)
values('authClientId'
       ,null
       ,'{bcrypt}$2a$10$uWqrUi9oi1T2EslgfVxpfuxgk6PeNqg7YluVPONdlPiEp/lisL5ua'
       ,'read,write,profile,email'
       ,'authorization_code,password,client_credentials,implicit,refresh_token'
       ,'http://localhost:8080/login/oauth2/code/local'
       ,'ROLE_USER'
       ,36000
       ,50000
       ,null
       ,null);


create table oauth_client_token (
  token_id VARCHAR(256),
  token TEXT,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

create table oauth_access_token (
  token_id VARCHAR(256),
  token TEXT,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication TEXT,
  refresh_token VARCHAR(256)
);

create table oauth_refresh_token (
  token_id VARCHAR(256),
  token TEXT,
  authentication TEXT
);

create table oauth_code (
  code VARCHAR(256), 
  authentication TEXT
);

create table oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);


-- customized oauth_client_details table
create table ClientDetails (
  appId VARCHAR(256) PRIMARY KEY,
  resourceIds VARCHAR(256),
  appSecret VARCHAR(256),
  scope VARCHAR(256),
  grantTypes VARCHAR(256),
  redirectUrl VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation VARCHAR(4096),
  autoApproveScopes VARCHAR(256)
);


CREATE TABLE `user` (
  `msrl` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `provider` varchar(100) DEFAULT NULL,
  `uid` varchar(50) NOT NULL,
  PRIMARY KEY (`msrl`),
  UNIQUE KEY `UK_a7hlm8sj8kmijx6ucp7wfyt31` (`uid`)
) 

CREATE TABLE `user_roles` (
  `user_msrl` bigint(20) NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  KEY `FKel3d4qj41g0sy1mtp4sh055g7` (`user_msrl`),
  CONSTRAINT `FKel3d4qj41g0sy1mtp4sh055g7` FOREIGN KEY (`user_msrl`) REFERENCES `user` (`msrl`)
) ;