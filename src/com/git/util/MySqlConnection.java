package com.git.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {

	public static Connection ConnectMysql() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager
					.getConnection("jdbc:mysql://172.17.22.96/htmis_dev", "root", "111111");
			if (!conn.isClosed()) {
				System.out.println("Succeeded connecting to the Database!");
			} else {
				System.out.println("Falled connecting to the Database!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return conn;
	}
	
	public static void main(String[] args) {
		MySqlConnection.ConnectMysql();
	}
	
}
