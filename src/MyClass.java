import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyClass extends JFrame implements ActionListener {
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

 public MyClass(String clid) {
	// TODO Auto-generated constructor stub
	 this.setTitle("ѧ������");
		jmb = new JMenuBar();
		jm = new JMenu("��ҳ");
		Open1 = new JMenuItem("���˻�����Ϣ");
		Open1.addActionListener(this);
		Close1 = new JMenuItem("����");
		Close1.addActionListener(this);

		jm2 = new JMenu("������Ϣ");
		Open2 = new JMenuItem("��ʦ��Ϣ");
		Open2.addActionListener(this);
		close2 = new JMenuItem("�༶��Ϣ");
		close2.addActionListener(this);
		Open4 = new JMenuItem("ѧУ��Ϣ");
		Open4.addActionListener(this);
		Open5=new JMenuItem("�ɼ��鿴");
		Open5.addActionListener(this);

		jm3 = new JMenu("���²���");
		Open3 = new JMenuItem("������Ϣ�޸�");
		Open3.addActionListener(this);
		close3 = new JMenuItem("ѧ����Ϣ���");
		close3.addActionListener(this);
		close4=new JMenuItem("ѧ����Ϣע��");
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
		jl=new JLabel("����ϵ��:");
		jl2=new JLabel("�༶���� :  ");
		jl3=new JLabel("�༶����:");
		jl4=new JLabel("");
		jl5=new JLabel("");
		jl6=new JLabel("");
		
		jl.setBounds(100, 58, 80, 25);
		jl4.setBounds(180, 58, 170, 30);
		
		jl2.setBounds(30, 115, 80, 30);
		jl5.setBounds(95, 115, 170, 30);
		jl3.setBounds(30, 150, 80, 30);
		jl6.setBounds(85, 155, 170, 25);
		
		jl7=new JLabel("�༶���� :");
		jl8=new JLabel("�༶���� :");
		jl9=new JLabel();
		jl10=new JLabel();
		jl7.setBounds(150, 115, 80, 30);
		jl9.setBounds(210, 115, 170, 30);
		jl8.setBounds(150, 150, 80, 30);
		jl10.setBounds(210, 155, 170, 25);
		
		
		jl11=new JLabel("�༶���� :");
		jl12=new JLabel("�༶����:");
		jl13=new JLabel();
		jl14=new JLabel();
		
		jl11.setBounds(280, 115, 80, 25);
     jl13.setBounds(340, 115, 170, 30);
     jl12.setBounds(280, 145, 80, 30);
     jl14.setBounds(335, 150, 170, 30);
		
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
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(450, 450);
		
		ArrayList a=new ArrayList();
		
		Connection conn=SQLUR.open();
		if(conn!=null){
			String name="",address="";
			try {
				String sql = "select * from class where cl_dtid='"+ clid+"'";
				System.out.println(sql);
				Statement s = conn.createStatement();
				ResultSet rs = s.executeQuery(sql);
				while (rs.next()) {
					 name= rs.getString("cl_name");
					 address=rs.getString("cl_room");
					newclass b=new newclass(address, name);
					a.add(b);
				}
				newclass c=(newclass)a.get(0);	
				jl4.setText(clid+"");
				jl5.setText(c.getName()+"");
				jl6.setText(c.getAddress()+"");
				newclass d=(newclass)a.get(1);	
				jl9.setText(d.getName()+"");
				jl10.setText(d.getAddress()+"");
				newclass f=(newclass)a.get(2);	
				 jl13.setText(f.getName()+"");
			     jl14.setText(f.getAddress()+"");



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
		
	}

}
