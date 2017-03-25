
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class index extends JFrame implements ActionListener {
	JMenuBar jmb;
	JMenu jm;
	JMenuItem Open1;
	JMenuItem Close1;
	JMenu jm2;
	JMenuItem Open2;
	JMenuItem close2;
	JMenu jm3;
	JMenuItem Open3;
	JMenuItem close3;
	JMenuItem Open4,Open5;
	JMenuItem close4;
	JPanel jp1, jp2, jp3,jp4;
	JLabel jl, jl2, jl3,jl4,jl5;
	JTextField jt1, jt2;
	JButton jb1, jb2;
	String clid="";
	
	index(String name,String id) {
		this.setTitle("学生信息管理--欢迎"+name+"同学");
		jmb = new JMenuBar();
		jm = new JMenu("主页");
		Open1 = new JMenuItem("个人基本信息");
		Open1.addActionListener(this);
		Close1 = new JMenuItem("课程介绍");
		Close1.addActionListener(this);

		jm2 = new JMenu("教务信息");
		Open2 = new JMenuItem("教师信息");
		Open2.addActionListener(this);
		close2 = new JMenuItem("班级信息");
		close2.addActionListener(this);
		Open4 = new JMenuItem("学校信息");
		Open4.addActionListener(this);
		Open5=new JMenuItem("成绩查看");
		Open5.addActionListener(this);

		jm3 = new JMenu("更新操作");
		Open3 = new JMenuItem("个人信息修改");
		Open3.addActionListener(this);
		close3 = new JMenuItem("学生信息添加");
		close3.addActionListener(this);
		close4=new JMenuItem("学生信息注册");
		close4.addActionListener(this);

		jmb.add(jm);
		jm.add(Open1);
		jm.add(Close1);
		jmb.add(jm2);
		jm2.add(Open2);
		jm2.add(close2);
		jm2.add(Open4);
		jm2.add(Open5);
		jmb.add(jm3);
		jm3.add(Open3);
		jm3.add(close3);
		jm3.add(close4);
		this.setJMenuBar(jmb);

	
		
		
				
		jp2=new JPanel();
		jl=new JLabel("姓名");
		jl2=new JLabel("学号");
		jl3=new JLabel(name);
		jl4=new JLabel(id);
		jl.setBounds(100, 108, 80, 25);
		jl3.setBounds(150, 110, 170, 30);
		jl2.setBounds(100, 150, 80, 25);
		jl4.setBounds(150, 150, 170, 30);
		jp2.add(jl);
		jp2.add(jl2);
		jp2.add(jl3);
		jp2.add(jl4);

		jp2.setBackground(Color.gray);
		jp2.setLayout(null);
		jp2.setVisible(true);
		this.getContentPane().add(jp2);
		

		
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 450);
		
		
		Connection conn=SQLUR.open();
		if(conn!=null){
			
		
			try {
				String sql ="select * from student where st_id='" + jl4.getText()+"'";
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while (rs.next()) {
					clid=rs.getString("clid");
				}
				
		}catch(Exception e){
			
		}
			SQLUR.close(conn);
		}
			
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(Open1)) {
			  new message(jl3.getText()+"",jl4.getText()+"",clid);
		} else if (e.getSource().equals(Open2)) {
			new teacher(clid,jl3.getText()+"",jl4.getText()+"");
		} else if (e.getSource().equals(close2)) {
			new MyClass(clid);

		} else if (e.getSource().equals(Open3)) {

		} else if (e.getSource().equals(close3)) {
			
		} else if (e.getSource().equals(Open4)) {

		}else if(e.getSource().equals(close4)){
			new course(clid,jl3.getText()+"",jl4.getText()+"");

		}else if(e.getSource().equals(Open5)){
			new score(jl4.getText()+"",jl3.getText()+"",clid);
		}else if(e.getSource().equals(Close1)){
			new schedule(clid,jl3.getText()+"",jl4.getText()+"");
		}
	}

}
