# Authenticate using JPA in spring security

### Spring JPA based authentication
* Spring out of the box doesn't provide an implementation for JPA based authentication
* Instead, we would leverage UserDetailsService implementation to have custom authentication using JPA
* UserDetailsService doesn't need to necessarily use JPA and can just read credentials from a file or have them hardcoded
 
##### Scripts to create users & authorities in PostgreSQL
```
CREATE TABLE USERS (
	USERNAME VARCHAR(36) NOT NULL,
	PASSWORD VARCHAR(36) NOT NULL,
	ENABLED BOOLEAN not null,
	constraint unique_uk_1 unique(USERNAME));

CREATE TABLE authorities (
	USERNAME VARCHAR(36) NOT NULL,
	authority VARCHAR(36) NOT NULL,
	constraint unique_uk_2 unique(USERNAME),
constraint foreign_fk_1 foreign key(USERNAME)references USERS(USERNAME));

SELECT * FROM USERS;
SELECT * FROM AUTHORITIES;

INSERT INTO USERS(USERNAME, PASSWORD, ENABLED) VALUES('user','user',true);
INSERT INTO USERS(USERNAME, PASSWORD, ENABLED) VALUES('manager','manager',true);
INSERT INTO USERS(USERNAME, PASSWORD, ENABLED) VALUES('admin','admin',true);

INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) VALUES('user','ROLE_USER');
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) VALUES('manager','ROLE_MANAGER,ROLE_USER');
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY) VALUES('admin','ROLE_ADMIN,ROLE_USER');
```