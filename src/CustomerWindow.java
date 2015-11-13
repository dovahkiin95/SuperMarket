import java.awt.*;
import java.util.Vector;
import javax.swing.*;
import java.sql.*;

public class CustomerWindow extends MainActivity {
	JFrame cFrame;
	JPanel buttonPanel,catPanel;
	String category;
	JComboBox c1;

	
	CustomerWindow() {
		cFrame=new JFrame("MANDARIN SUPER MARKET");
		cFrame.setSize(600,600);
		cFrame.setVisible(true);
		
		
		    buttonPanel = new JPanel();
		    catPanel=new JPanel();
		    catPanel.setLayout(new GridBagLayout());
		    buttonPanel.setLayout(new GridBagLayout());
		    buttonPanel.setSize(0,0);// whatever

		    // the scrollpane
		    JScrollPane pane = new JScrollPane();
		    pane.setSize(new Dimension(150,400)); // whatever

		    // GridBagConstraint for button
		    GridBagConstraints constraint = new GridBagConstraints();
		    constraint.anchor = GridBagConstraints.CENTER;
		    constraint.fill = GridBagConstraints.NONE;
		    constraint.gridx = 0;
		    constraint.gridy = GridBagConstraints.RELATIVE;
		    constraint.weightx = 1.0f;
		    constraint.weighty = 1.0f;

		    int sizeOfButtons = 50;   //ust for testing purpose. Get all productshere.
		    for(int i = 0; i < sizeOfButtons; i++) {
		        JButton button = new JButton();

		        button.setText("Button #" + i);

		        // other attributes you will set

		        buttonPanel.add(button, constraint);
		    }

	        pane.setViewportView(buttonPanel);
		    cFrame.add(pane); // or other panel etc.
		
		    pane.updateUI();
		    
		    try {
		    	Class.forName(driver).newInstance();
				con=DriverManager.getConnection(URL+dbName,userName,password);
				System.out.println("Connected to the database");
		    	Statement st=(Statement) con.createStatement();
		    	//ResultSet rs = st.executeQuery(q);
		    	st = con.createStatement();
	           ResultSet rs = st.executeQuery("select Department from Category");
	            Vector v = new Vector();
	            while (rs.next()) {
	                category= rs.getString(1);
	                System.out.println(category);
	                v.add(category);
	            }
	            c1 = new JComboBox(v);
	            c1.setBounds(150, 110, 150, 20);
	            catPanel.add(c1);
	            cFrame.add(catPanel);
	 
	           // cFrame.add(c1);
	            st.close();
	            rs.close();
	        } catch (Exception e) {
	        	e.printStackTrace();

		    }
		   
	}
	
//	public static void main(String args[]) {
	//	new CustomerWindow();
	//}
	
	
}
