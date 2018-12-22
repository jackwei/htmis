/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2013/4/24 13:41:54                           */
/*==============================================================*/


drop table if exists Sys_Code;

drop table if exists Sys_Dict_Entry;

drop table if exists Sys_Dict_Type;

drop table if exists Sys_Sequence;

drop table if exists Sys_User_Log;

/*==============================================================*/
/* Table: Sys_Code                                              */
/*==============================================================*/
create table Sys_Code
(
   CodeId               varchar(50) not null,
   CodeName             varchar(100),
   CodeValue            varchar(1024),
   Property             char(1),
   Backup               varchar(200),
   primary key (CodeId)
);

alter table Sys_Code comment '���ô����';

/*==============================================================*/
/* Table: Sys_Dict_Entry                                        */
/*==============================================================*/
drop table if exists Sys_Dict_Entry;

/*==============================================================*/
/* Table: Sys_Dict_Entry                                        */
/*==============================================================*/
create table Sys_Dict_Entry
(
   DictId               varchar(50) not null,
   DictName             varchar(100),
   DictTypeId           varchar(50) not null,
   Status               char(1) comment '数据状态：1：生效；2：失效',
   ParentDictId         varchar(50),
   SortNo               int,
   BackUp2              varchar(200),
   BackUp1              varchar(200),
   primary key (DictId, DictTypeId)
);

alter table Sys_Dict_Entry comment '数据字典明细信息';

/*==============================================================*/
/* Table: Sys_Dict_Type                                         */
/*==============================================================*/
create table Sys_Dict_Type
(
   DictTypeId           varchar(50) not null,
   DictTypeName         varchar(100),
   ParentDictTypeId     varchar(50),
   SortNo               int,
   BackUp1              varchar(200),
   primary key (DictTypeId)
);

alter table Sys_Dict_Type comment '����ֵ��ܱ���Ϣ';

/*==============================================================*/
/* Table: Sys_Sequence                                          */
/*==============================================================*/
create table Sys_Sequence
(
   Seq_Name             varchar(20) not null,
   Prefix               varchar(10),
   Suffix               varchar(10),
   Seq_No               bigint,
   primary key (Seq_Name)
);

alter table Sys_Sequence comment '��ݿ����б�';

/*==============================================================*/
/* Table: Sys_User_Log                                          */
/*==============================================================*/
create table Sys_User_Log
(
   Log_Id               bigint not null,
   User_Id              bigint not null,
   Login_Time           datetime,
   Login_Out_Time       datetime,
   IP_Address           varchar(100),
   primary key (Log_Id)
);

alter table Sys_User_Log comment '��¼�û���¼��ע����־';

alter table Sys_Dict_Entry add constraint FK_Relationship_1 foreign key (DictTypeId)
      references Sys_Dict_Type (DictTypeId) on delete restrict on update restrict;

