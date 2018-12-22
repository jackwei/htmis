insert into `sys_menu` (`Menu_Id`, `Menu_Name`, `Parent_Id`, `Is_Leaf`, `Url`, `Menu_Status`, `Extend1`, `Extend2`, `Extend3`) values('1','书目管理','0','0',NULL,'1',NULL,NULL,NULL);
insert into `sys_menu` (`Menu_Id`, `Menu_Name`, `Parent_Id`, `Is_Leaf`, `Url`, `Menu_Status`, `Extend1`, `Extend2`, `Extend3`) values('2','书目目录','1','1','/management/book','1',NULL,NULL,NULL);
insert into `sys_menu` (`Menu_Id`, `Menu_Name`, `Parent_Id`, `Is_Leaf`, `Url`, `Menu_Status`, `Extend1`, `Extend2`, `Extend3`) values('3','测试报表','1','1','/ShowReport.wx?PAGEID=listpage1','1','true',NULL,NULL);
insert into `sys_menu` (`Menu_Id`, `Menu_Name`, `Parent_Id`, `Is_Leaf`, `Url`, `Menu_Status`, `Extend1`, `Extend2`, `Extend3`) values('4','案件管理','0','0',NULL,'1',NULL,NULL,NULL);
insert into `sys_menu` (`Menu_Id`, `Menu_Name`, `Parent_Id`, `Is_Leaf`, `Url`, `Menu_Status`, `Extend1`, `Extend2`, `Extend3`) values('5','统计查询','0','0',NULL,'1',NULL,NULL,NULL);
insert into `sys_menu` (`Menu_Id`, `Menu_Name`, `Parent_Id`, `Is_Leaf`, `Url`, `Menu_Status`, `Extend1`, `Extend2`, `Extend3`) values('6','案件登记','4','1','/case','1',NULL,NULL,NULL);
insert into `sys_menu` (`Menu_Id`, `Menu_Name`, `Parent_Id`, `Is_Leaf`, `Url`, `Menu_Status`, `Extend1`, `Extend2`, `Extend3`) values('7','报表1','5','1','/report','1',NULL,NULL,NULL);

insert into `sys_role` (`Role_Id`, `Role_Name`, `Role_Status`, `Extend1`, `Extend2`, `Extend3`) values('1','管理员','1',NULL,NULL,NULL);

insert into `sys_role_menu` (`Role_Id`, `Menu_Id`, `Operator_Id`) values('1','2','1');
insert into `sys_role_menu` (`Role_Id`, `Menu_Id`, `Operator_Id`) values('1','3','1');
insert into `sys_role_menu` (`Role_Id`, `Menu_Id`, `Operator_Id`) values('1','6','1');
insert into `sys_role_menu` (`Role_Id`, `Menu_Id`, `Operator_Id`) values('1','7','1');

insert into `sys_user` (`User_Id`, `User_No`, `User_Code`, `User_Pwd`, `Name`, `Gender`, `Email`, `Phone`, `Org_Id`, `Order_By`, `User_Status`, `Create_Time`, `Modify_Operator_Id`, `Modify_Time`, `Operator_Id`, `Extend1`, `Extend2`, `Extend3`) values('1','admin','admin','670B14728AD9902AECBA32E22FA4F6BD','管理员','0',NULL,NULL,NULL,NULL,'1',NULL,NULL,NULL,NULL,NULL,NULL,NULL);

insert into `sys_user_role` (`User_Id`, `Role_Id`, `Operator_Id`) values('1','1','1');