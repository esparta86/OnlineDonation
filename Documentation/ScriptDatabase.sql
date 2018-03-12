use donation;

drop table if exists COUNTRY;

drop table if exists DEPARTMENT;

drop table if exists DONATION;

drop table if exists INSTITUTION;

drop table if exists PERSON;

drop table if exists USUARIO;

create table COUNTRY
(
   ID_COUNTRY           bigint not null,
   NAME_COUNTRY         varchar(100) not null,
   primary key (ID_COUNTRY)
);


create table DEPARTMENT
(
   ID_DEPARTMENT        bigint not null,
   ID_COUNTRY           bigint not null,
   NAME_DEPARTMENT      varchar(100),
   primary key (ID_DEPARTMENT)
);

create table DONATION
(
   IDDONATION           bigint not null,
   IDUSUARIO            bigint not null,
   ID_INSTITUTION       bigint not null,
   AMOUNT               numeric(10,2) not null,
   CREDITCARD           varchar(20),
   TYPE_CREDIT_CARD     char(1),
   DONATION_DATE        datetime,
   primary key (IDDONATION)
);

create table INSTITUTION
(
   ID_INSTITUTION       bigint not null,
   ID_DEPARTMENT        bigint not null,
   NAME_INSTITUTION     varchar(100),
   REGISTRATION_DATE    date,
   primary key (ID_INSTITUTION)
);

create table PERSON
(
   DNI                  varchar(50) not null,
   IDUSUARIO            bigint not null,
   FIRSTNAME            varchar(100),
   LASTNAME             varchar(100),
   BIRTHDATE            date,
   primary key (DNI)
);

create table USUARIO
(
   IDUSUARIO            bigint not null,
   USERNAME             varchar(50) not null,
   PASSWORD             varchar(200) not null,
   REGISTRATIONDATE     date not null,
   primary key (IDUSUARIO)
);


alter table DEPARTMENT add constraint FK_HAS foreign key (ID_COUNTRY)
      references COUNTRY (ID_COUNTRY) on delete restrict on update restrict;

alter table DONATION add constraint FK_MAKE foreign key (IDUSUARIO)
      references USUARIO (IDUSUARIO) on delete restrict on update restrict;

alter table DONATION add constraint FK_RECEIVES foreign key (ID_INSTITUTION)
      references INSTITUTION (ID_INSTITUTION) on delete restrict on update restrict;

alter table INSTITUTION add constraint FK_CAN_HAVE foreign key (ID_DEPARTMENT)
      references DEPARTMENT (ID_DEPARTMENT) on delete restrict on update restrict;

alter table PERSON add constraint FK_ASSIGNED2 foreign key (IDUSUARIO)
      references USUARIO (IDUSUARIO) on delete restrict on update restrict;
      
      



