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

public class schedule extends JFrame implements ActionListener{
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
	String newclid="";
	String st_name="";
	String st_id="";
	public schedule(String clid,String name2,String id) {
		// TODO Auto-generated constructor stub
		newclid=clid;
		st_name=name2;
		st_id=id;
		this.setTitle("课程信息管理--欢迎查阅");
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
		jl=new JLabel("课程编号 :");
		jl2=new JLabel("教师编号 :");
		jl3=new JLabel();
		jl4=new JLabel();
		
		jl.setBounds(30, 30, 60, 25);
		jl3.setBounds(95, 30, 170, 30);
		jl2.setBounds(30,70, 80, 30);
		jl4.setBounds(90, 75, 170, 25);
		
		jp2.add(jl);
		jp2.add(jl2);
		jp2.add(jl3);
		jp2.add(jl4);

		jl5=new JLabel("状态 :");
		jl6=new JLabel("课程名称 :");
		jl7=new JLabel();
		jl8=new JLabel();
		jl5.setBounds(200, 30, 80, 25);
        jl7.setBounds(250, 30, 170, 30);
        jl6.setBounds(200, 70, 80, 30);
        jl8.setBounds(270, 70, 170, 30);
        
        jp2.add(jl5);
        jp2.add(jl6);
        jp2.add(jl7);
        jp2.add(jl8);
        
        jl9=new JLabel("授课时长 :");
        jl10=new JLabel("授课地点 :");
        jl13=new JLabel("所属系号 :");
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
			String room="",time="",thid="",crid="",name="";
			try {
				String sql ="select * from schedule where sh_clid='" + clid+"'";
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while (rs.next()) {
					 room = rs.getString("sh_room");
					 time =rs.getString("sh_time");
					 thid =rs.getString("sh_thid");
					 crid=rs.getString("sh_crid");
					 name=rs.getString("sh_name");
						}
				jl7.setText("Hot");
				jl8.setText(name);
				jl11.setText(time);
				jl12.setText(room);
				jl14.setText(clid);
				jl3.setText(crid);
				jl4.setText(thid);
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
			  new message(st_name, st_id, newclid);
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
