

import java.sql.*;

public class SQLUR {

	public static Connection open() {

		String url = "jdbc:sqlserver://localhost:1433;DatabaseName=company";
		Connection con = null;

		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(url, "sa", "123456");
			System.out.println("���ݿ����ӳɹ�");
		} catch (ClassNotFoundException e) {
			System.out.println("û�и�����");
		} catch (SQLException e) {
			System.out.println("���ݿ�����ʧ��");
		}

		return con;

	}

	public static void close(Connection con) {
		try {
			con.close();
			System.out.println("�رճɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ر�ʧ��");
		}
	}

	public static void main(String[] args) {
		
		
		
	}

}
