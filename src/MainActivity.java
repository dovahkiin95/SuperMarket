// Author : dovahkiin
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainActivity{
	Connection con=null;
	String URL="jdbc:mysql://localhost:3306/";
	String dbName="MandarinSuperMarket";
	String driver = "com.mysql.jdbc.Driver";
	String userName = "aqeel";
	String password = "ozil";
	String q;
	String c1,c2;
	
	private JButton bCustomer,bAdmin;
    private JLabel lWelcome;
	private JLabel status;
	private JFrame frame;
	private JPanel controlPanel;
	
	MainActivity() {
		prepareGUI();
		//DBconnect();
		
		
		
	}
	
	private void DBconnect() {
		try {
			Class.forName(driver).newInstance();
			con=DriverManager.getConnection(URL+dbName,userName,password);
			System.out.println("Connected to the database");
			/*q="SELECT * FROM Category";
			Statement stmt=con.createStatement();
			ResultSet rs = stmt.executeQuery(q);
			while (rs.next())
			{
			c1 = rs.getString(1);
			c2 = rs.getString(2);
			System.out.print(c1+" ");
			System.out.println(c2);
			} 
			con.close(); */
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void prepareGUI() {
		//DBconnect();
		frame=new JFrame("MANDARIN SUPERMARKET");
		//FlowLayout fl=new FlowLayout();
		//setLayout(fl);
		//setSize(400,400);
		//setBackground(Color.WHITE);
		frame.setSize(400,400);
	    frame.setLayout(new GridLayout(3, 3));
		lWelcome=new JLabel("Welcome To MANDARIN SUPERMARKET");
		status=new JLabel("wassup");
		//add(lWelcome);
		
		//add(bAdmin);
		//setVisible(true);
		
		controlPanel = new JPanel();
	    controlPanel.setLayout(new FlowLayout());
		frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
             {
                System.exit(0);
             }});
		controlPanel.add(lWelcome);
	    controlPanel.add(status);
		//frame.add(controlPanel);
		//frame.setVisible(true);
	    // DBconnect();
	  
	
	}
	
	private void welcomePage() {
		DBconnect();
		bCustomer=new JButton("Customer Purchase");
		bCustomer.addActionListener(new ButtonClickListener());
		//add(bCustomer);
		bAdmin=new JButton("Administrator Login");
		bAdmin.addActionListener(new ButtonClickListener());
		bCustomer.setActionCommand("Customer");
		bAdmin.setActionCommand("admin");
		//frame.add(bCustomer);
		//frame.add(bAdmin);
		controlPanel.add(bCustomer);
		controlPanel.add(bAdmin);
		frame.setContentPane(controlPanel);
		frame.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainActivity ma=new MainActivity();
		ma.welcomePage();
		
	}
	public class ButtonClickListener extends MainActivity implements ActionListener {
		String action;

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			CustomerWindow cw;
			action=e.getActionCommand();
			if(action == "Customer") {
				status.setText("Welcome Customer");
				cw=new CustomerWindow();
				
			}
			else
				status.setText("Welcome Admin");

			//frame.repaint();
		}

	}

	


}
