

import java.sql.*;

public class SQLUR {

	public static Connection open() {

		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=company";
		Connection con = null;

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url, "sa", "123456");
			System.out.println("数据库连接成功");
		} catch (ClassNotFoundException e) {
			System.out.println("没有该驱动");
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
		}

		return con;

	}

	public static void close(Connection con) {
		try {
			con.close();
			System.out.println("关闭成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("关闭失败");
		}
	}

	public static void main(String[] args) {
		
		
		
	}

}
