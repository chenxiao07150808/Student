import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class message extends JFrame implements ActionListener{
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
	JLabel jl, jl2, jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13,jl14;
	JTextField jt1, jt2;
	JButton jb1, jb2;
	String tel="",birth="",address="",clid="",gender="";
	String st_name="",st_id="",newclid="";
	public message(String name,String id,String clid) {
		// TODO Auto-generated constructor stub
		st_name=name;
		st_id=id;
		newclid=clid;
		this.setTitle("学生信息管理--欢迎"+name+"同学");
		jmb = new JMenuBar();
		jm = new JMenu("主页");
		Open1 = new JMenuItem("个人基本信息");
		Open1.addActionListener(this);
		Close1 = new JMenuItem("备份");
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
		jl=new JLabel("姓名 :");
		jl2=new JLabel("学号 :");
		jl3=new JLabel(name);
		jl4=new JLabel(id);
		
		jl.setBounds(30, 30, 60, 25);
		jl3.setBounds(95, 30, 170, 30);
		jl2.setBounds(30,70, 80, 30);
		jl4.setBounds(75, 70, 170, 25);
		
		jp2.add(jl);
		jp2.add(jl2);
		jp2.add(jl3);
		jp2.add(jl4);

		jl5=new JLabel("生日 :");
		jl6=new JLabel("性别 :");
		jl7=new JLabel();
		jl8=new JLabel();
		jl5.setBounds(200, 30, 80, 25);
        jl7.setBounds(250, 30, 170, 30);
        jl6.setBounds(200, 70, 80, 30);
        jl8.setBounds(250, 70, 170, 30);
        
        jp2.add(jl5);
        jp2.add(jl6);
        jp2.add(jl7);
        jp2.add(jl8);
        
        jl9=new JLabel("联系电话 :");
        jl10=new JLabel("家庭地址 :");
        jl13=new JLabel("系号 :");
        jl11=new JLabel();
        jl12=new JLabel();
        jl14=new JLabel();
        
        jl9.setBounds(30, 135, 80, 30);
		jl11.setBounds(95, 135, 170, 30);
		jl10.setBounds(30, 170, 80, 30);
		jl12.setBounds(95, 170, 170, 25);
		jl13.setBounds(30, 205, 80, 30);
		jl14.setBounds(95,205 , 170, 25);
        
		jp2.add(jl9);
		jp2.add(jl10);
		jp2.add(jl11);
		jp2.add(jl12);
		jp2.add(jl13);
		jp2.add(jl14);
        
		jp2.setLayout(null);
		jp2.setVisible(true);
		this.getContentPane().add(jp2);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 450);
		
		
		Connection conn=SQLUR.open();
		if(conn!=null){
			
			try {
				String sql ="select * from student where st_id='" + id+"'";
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while (rs.next()) {
					 tel = rs.getString("st_tel");
					 birth =rs.getString("st_birth");
					 address =rs.getString("st_address");
					 clid=rs.getString("st_clid");
					 gender=rs.getString("st_gender");
						}
				jl7.setText(gender);
				jl8.setText(birth);
				jl11.setText(tel);
				jl12.setText(address);
				jl14.setText(clid);
		}catch (Exception e) {
			// TODO: handle exception
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
			  new message(st_name,st_id,newclid);
		} else if (e.getSource().equals(Open2)) {
			new teacher(newclid,st_name,st_id);
		} else if (e.getSource().equals(close2)) {
			new MyClass(newclid);

		} else if (e.getSource().equals(Open3)) {

		} else if (e.getSource().equals(close3)) {
			
		} else if (e.getSource().equals(Open4)) {

		}else if(e.getSource().equals(close4)){
			new course(newclid,st_name,st_id);

		}else if(e.getSource().equals(Open5)){
			new score(st_id,st_name,newclid);
		}else if(e.getSource().equals(Close1)){
			new schedule(newclid,st_name,st_id);
		}

	}

}
