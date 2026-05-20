package com.oddno.lovelive.gamedata;

import java.sql.Connection;
import java.sql.DriverManager;

public class ServerdataReader {

	private static Connection con;

	public final static String DATABASE = "serverdata.db";

	public static Connection getConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:" + DATABASE);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
		return con;
	}
}