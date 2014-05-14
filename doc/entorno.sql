/*==============================================================*/
/* DBMS name:      Sybase SQL Anywhere 10                       */
/* Created on:     13/05/2014 18:37:02                          */
/*==============================================================*/

/*==============================================================*/
/* Table: ASISTENCIA                                            */
/*==============================================================*/
create table ASISTENCIA 
(
   FECHA_CLASE          date                           null,
   HORA                 time                           null,
   ID_ASISTENCIA        integer                        not null AUTO_INCREMENT,
   ID_USUARIO           integer                        null,
   ID_CLASE             integer                        null,
   constraint PK_ASISTENCIA primary key (ID_ASISTENCIA)
);

/*==============================================================*/
/* Table: CLASE                                                 */
/*==============================================================*/
create table CLASE 
(
   TEMA                 varchar(100)                   not null,
   SEMANA               varchar(1024)                  not null,
   BIMESTRE             varchar(12)                    not null,
   FECHA_CLASE          date                           null,
   COMPETENCIAS         varchar(1024)                  null,
   ACTIVIDAD            varchar(1024)                  null,
   CONTENIDO            varchar(1024)                  null,
   RECURSO              varchar(1024)                  null,
   ID_CLASE             integer                        not null AUTO_INCREMENT,
   ID_COMPONENTE        integer                        null,
   constraint PK_CLASE primary key (ID_CLASE)
);

/*==============================================================*/
/* Table: COMPONENTE                                            */
/*==============================================================*/
create table COMPONENTE 
(
   ID_COMPONENTE        integer                        not null AUTO_INCREMENT,
   NOMBRE               varchar(50)                    not null,
   HORARIO              time                           not null,
   PERIODO              varchar(20)                    not null, 
   docente           integer                        null,
   constraint PK_COMPONENTE primary key (ID_COMPONENTE)
);

/*==============================================================*/
/* Table: EVALUACION                                            */
/*==============================================================*/
create table EVALUACION 
(
   ID_EVALUACION        integer                        not null AUTO_INCREMENT,
   CLASE                varchar(1024)                  not null,
   EXPLICACION          varchar(1024)                  not null,
   MATERIAL             varchar(1024)                  not null,
   DIFICULTAD           varchar(1024)                  not null,
   INTERES              varchar(1024)                  not null,
   TAREA                varchar(1024)                  not null,
   
   ID_CLASE        integer                        null,
   constraint PK_EVALUACION primary key (ID_EVALUACION)
);

/*==============================================================*/
/* Table: LOGIN                                               */
/*==============================================================*/
create table LOGIN 
(
   ID_LOGIN             integer                        not null AUTO_INCREMENT,
   USUARIO_LOGIN              varchar(15)                    not null,
   CONTRASENIA_LOGIN          varchar(15)                    not null,
   ID_USUARIO           integer                        null ,
   constraint PK_LOGIN primary key (ID_LOGIN)
);

/*==============================================================*/
/* Table: PARTICIPACION                                         */
/*==============================================================*/
create table PARTICIPACION 
(
   ID_PARTICIPACION     integer                        not null AUTO_INCREMENT,
   ID_CLASE        integer                        null, 
   HORA                 time                           null,
   FECHA_CLASE          date                           null,
   constraint PK_PARTICIPACION primary key (ID_PARTICIPACION)
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO 
(
   ID_USUARIO           integer                        not null AUTO_INCREMENT,
   NOMBRE               varchar(50)                    not null,
   APELLIDO             varchar(50)                    not null,
   CORREO               varchar(50)                    not null,
   ROL                  varchar(10)                    not null,
   constraint PK_USUARIO primary key (ID_USUARIO)
);

/*==============================================================*/
/* Table: estudiante_componente                                               */
/*==============================================================*/
create table estudiante_componente 
(
   id_estcomp           integer                        not null AUTO_INCREMENT,
   id_usuario               integer                        not null,
   constraint PK_estudiante_com primary key (id_estcomp)
);

alter table ASISTENCIA
   add constraint FK_ASISTENC_RELATIONS_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
      on update restrict
      on delete restrict;

alter table ASISTENCIA
   add constraint FK_ASISTENC_RELATIONS_CLASE foreign key (ID_CLASE)
      references CLASE (ID_CLASE)
      on update restrict
      on delete restrict;

alter table CLASE
   add constraint FK_CLASE_RELATIONS_COMPONEN foreign key (ID_COMPONENTE)
      references COMPONENTE (ID_COMPONENTE)
      on update restrict
      on delete restrict;

alter table COMPONENTE
   add constraint FK_COMPONEN_RELATIONS_USUARIO foreign key (docente)
      references USUARIO (ID_USUARIO)
      on update restrict
      on delete restrict;

alter table EVALUACION
   add constraint FK_EVALUACI_RELATIONS_COMPONEN foreign key (ID_CLASE)
      references CLASE (ID_CLASE)
      on update restrict
      on delete restrict;

alter table LOGIN
   add constraint FK_LOGIN_RELATIONS_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
      on update restrict
      on delete restrict;

alter table PARTICIPACION
   add constraint FK_PARTICIP_RELATIONS_COMPONEN foreign key (ID_CLASE)
      references CLASE (ID_CLASE)
      on update restrict
      on delete restrict;
