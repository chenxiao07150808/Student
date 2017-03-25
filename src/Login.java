
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Login implements ActionListener {
	JFrame jf = new JFrame("教务系统");
	JPanel panel = new JPanel();
	Button btok = new Button("登陆");
	Button btok2 = new Button("重置");
	ButtonGroup group = new ButtonGroup();
	JTextField text = new JTextField(20);
	JTextField text2 = new JTextField(20);
	JTextField text3 = new JTextField(20);
	Image img;
	JLabel jl1 = new JLabel("用户名");
	JLabel jl2 = new JLabel("学号");
   
	Login() {
		jl1.setBounds(100, 108, 80, 25);
		text2.setBounds(150, 110, 170, 30);
		jl2.setBounds(100, 150, 80, 25);
		text3.setBounds(150, 150, 170, 30);
		btok.setBounds(100, 190, 100, 30);
		btok2.setBounds(220, 190, 100, 30);
		panel.setLocation(0, 0);
		panel.setSize(800, 800);

		jf.add(panel);
		JLabel l = new JLabel();
		l.setLayout(null);
		l.setLocation(0, 0);
		l.setSize(500, 500);
		Icon icon = new ImageIcon("book.jpg"); // 在此直接创建对象
		l.setIcon(icon);
		panel.add(l);
		l.add(jl1);
		l.add(text);
		l.add(text2);
		l.add(jl2);
		l.add(text3);
		l.add(btok);
		l.add(btok2);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(400, 400);
		jf.setLayout(null);
		panel.setLayout(null);
		jf.setVisible(true);
		jf.setResizable(false);
		text.setVisible(false);
		btok.addActionListener(this);
		btok2.addActionListener(this);
	}

	public static void main(String[] args) {
		Login t = new Login();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btok)) {
			Connection conn = SQLUR.open();

			if (conn != null) {
				System.out.println(text3.getText());
				String id = text3.getText();
				String name = "";
				try {
					String sql = "select st_name from student where st_id=" + id;
					Statement s = conn.createStatement();
					ResultSet rs = s.executeQuery(sql);
					while (rs.next()) {
						name = rs.getString("st_name");
					}
					if (text2.getText().equals(name)) {
						new index(text2.getText()+"",text3.getText()+"");
					} else {
						text.setText("不"
								+ "存在该学生");
					}

				} catch (SQLException e1) {

				}
				SQLUR.close(conn);
			}
		} else if (e.getSource().equals(btok2)) {
         text2.setText("");
         text3.setText("");
		}
	}

}
