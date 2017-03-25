
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class score extends JFrame implements ActionListener {
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
	JPanel jp1, jp2, jp3;
	JLabel jl, jl2, jl3,jl4,jl5,jl6,jl7,jl8,jl9,jl10,jl11,jl12,jl13,jl14;
	JTextField jt1, jt2;
	JButton jb1, jb2;
  String st_id="",st_name="",newclid="";
	score(String id ,String name,String clid) {
		st_id=id;
		st_name=name;
		newclid=clid;
		this.setTitle("学生成绩查看管理-欢迎"+name+"同学");
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

		jp1 = new JPanel();
		jl=new JLabel("学号 :");
		jl2=new JLabel("科目编号 :  ");
		jl3=new JLabel("成绩 :");
		jl4=new JLabel("");
		jl5=new JLabel("");
		jl6=new JLabel("");
		jl.setFont(new java.awt.Font("Dialog", 150, 15));
		jl2.setFont(new java.awt.Font("Dialog", 150, 15));
		jl3.setFont(new java.awt.Font("Dialog", 150, 15));
		jl4.setFont(new java.awt.Font("Dialog", 150, 15));
		jl5.setFont(new java.awt.Font("Dialog", 150, 15));
		jl6.setFont(new java.awt.Font("Dialog", 150, 15));
		jl.setBounds(100, 58, 80, 25);
		jl4.setBounds(150, 58, 170, 30);
		
		jl2.setBounds(30, 115, 80, 30);
		jl5.setBounds(95, 115, 170, 30);
		jl3.setBounds(30, 150, 80, 30);
		jl6.setBounds(75, 150, 170, 25);
		
		jl7=new JLabel("科目编号");
		jl8=new JLabel("成绩");
		jl9=new JLabel();
		jl10=new JLabel();
		jl7.setFont(new java.awt.Font("Dialog", 150, 15));
		jl8.setFont(new java.awt.Font("Dialog", 150, 15));
		jl9.setFont(new java.awt.Font("Dialog", 150, 15));
		jl10.setFont(new java.awt.Font("Dialog", 150, 15));
		jl7.setBounds(150, 115, 80, 30);
		jl9.setBounds(220, 115, 170, 30);
		jl8.setBounds(150, 150, 80, 30);
		jl10.setBounds(200, 150, 170, 25);
		
		
		jl11=new JLabel("科目编号");
		jl12=new JLabel("成绩");
		jl13=new JLabel();
		jl14=new JLabel();
		jl11.setFont(new java.awt.Font("Dialog", 150, 15));
		jl12.setFont(new java.awt.Font("Dialog", 150, 15));
		jl13.setFont(new java.awt.Font("Dialog", 150, 15));
		jl14.setFont(new java.awt.Font("Dialog", 150, 15));
		jl11.setBounds(270, 115, 80, 25);
        jl13.setBounds(340, 115, 170, 30);
        jl12.setBounds(270, 150, 80, 30);
        jl14.setBounds(320, 150, 170, 30);
		
		jp1.add(jl);
		jp1.add(jl4);
		jp1.add(jl2);
		jp1.add(jl5);
		jp1.add(jl3);
		jp1.add(jl6);
		
		jp1.add(jl7);
		jp1.add(jl8);
		jp1.add(jl9);
		jp1.add(jl10);
		
		jp1.add(jl11);
		jp1.add(jl12);
		jp1.add(jl13);
		jp1.add(jl14);
		
		jp1.setVisible(true);
		jp1.setLayout(null);
		this.getContentPane().add(jp1);
		
		
		Connection conn=SQLUR.open();
		if(conn!=null){
			String crid="",stid="",grade="";
			try {
				String sql = "select * from score where sc_stid='"+ id+"'";
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while (rs.next()) {
					 stid= rs.getString("sc_stid");
					 crid=rs.getString("sc_crid");
					 grade=rs.getString("sc_grade");
					 newStudent b=new newStudent(crid, grade,id);
					 a.add(b);
				}
		newStudent c=(newStudent)a.get(0);
		jl4.setText(c.getId()+"");
		jl5.setText(c.getCrid()+"");
		jl6.setText(c.getGrade()+"");
		newStudent d=(newStudent)a.get(1);
		jl9.setText(d.getCrid()+"");
		jl10.setText(d.getGrade());
        newStudent f=(newStudent)a.get(2);
        jl13.setText(f.getCrid()+"");
        jl14.setText(f.getGrade());
				
				}catch (Exception e) {
					// TODO: handle exception
				}
			SQLUR.close(conn);
		}

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 450);
		
	}
	ArrayList a=new ArrayList();
  
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
