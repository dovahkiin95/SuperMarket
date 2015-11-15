import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;

import java.sql.*;

public class CustomerWindow extends MainActivity implements ActionListener {
	JFrame cFrame;
	JPanel buttonPanel,catPanel,mainPanel;
	String category;
	JComboBox c1;
	GridBagConstraints constraint;
	 JScrollPane pane;

	
	CustomerWindow() {
		cFrame=new JFrame("MANDARIN SUPER MARKET");
		cFrame.setSize(1000,1000);
		cFrame.setVisible(true);
		
		
		    buttonPanel = new JPanel();
		    mainPanel=new JPanel();
		    mainPanel.setLayout(new FlowLayout());
		    mainPanel.setSize(700,700);
		    //mainPanel.setLocation(100,23);
		    mainPanel.setBackground(Color.BLUE);
		    buttonPanel.setLayout(new GridBagLayout());
		    buttonPanel.setSize(400,300);// whatever
		    buttonPanel.setBackground(Color.ORANGE);
		    

		    // the scrollpane
		
		    
		    
		    
		    
		    
		     pane = new JScrollPane();
		    pane.setSize(new Dimension(150,400));// whatever
		    pane.setBackground(Color.red);
		    //pane.setLocation(150,60);
		    // GridBagConstraint for button
		    constraint = new GridBagConstraints();
		    constraint.anchor = GridBagConstraints.CENTER;
		    constraint.fill = GridBagConstraints.NONE;
		    constraint.gridx = 0;
		    constraint.gridy = GridBagConstraints.RELATIVE;
		    constraint.weightx = 1.0f;
		    constraint.weighty = 1.0f;
		    
		  
		    

		    
		    
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
	            c1.setBackground(Color.yellow);
		           mainPanel.add(c1);
		           cFrame.add(mainPanel);
		         //  cFrame.setVisible(true);
	            
	            c1.addActionListener(
	                    new ActionListener(){
	                       

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								buttonPanel.removeAll();
								mainPanel.revalidate();
								mainPanel.repaint();
								buttonPanel.revalidate();
								buttonPanel.repaint();
								pane.revalidate();
								pane.repaint();
			                            JComboBox combo = (JComboBox)e.getSource();
			                            String dep=(String)combo.getSelectedItem();
			                            PreparedStatement populate;
										try {
											populate = con.prepareStatement("SELECT Item from Products where D_num in (select D_no from Category where Department=?)");
										    populate.setString(1,dep);
										    ResultSet r =populate.executeQuery();
										  
										    while (r.next()) {
								                String product= r.getString(1);
								                System.out.println(product);
								                JButton button = new JButton();

										        button.setText(product);

										        // other attributes you will set

										        buttonPanel.add(button, constraint);
										       
								                
								                System.out.println("making button "+product);
								            }
										   pane.setViewportView(buttonPanel);
									        mainPanel.add(pane);
										    cFrame.add(mainPanel); // or other panel etc.
										    
										    
										
										  //  pane.updateUI();
										    //cFrame.repaint();
										    //catPanel.updateUI();
										   //catPanel.repaint();
										    cFrame.setVisible(true); 
										    
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}        
			                        }
							}
	                    );     
	            
	            
	           	          //  c1.setBounds(150, 110, 150, 20);
	            c1.setBounds(60, 60, 60, 50);
	          //  catPanel.add(c1);
	          // cFrame.add(catPanel);
	          
	           //cFrame.add(c1);
	          
	            st.close();
	            rs.close();
	        } catch (Exception e) {
	        	e.printStackTrace();

		    }
		   
		/*    int sizeOfButtons = 50;   // just for testing purpose. Get all products
		    for(int i = 0; i < sizeOfButtons; i++) {
		        JButton button = new JButton();

		        button.setText("Button #" + i);

		        // other attributes you will set

		        buttonPanel.add(button, constraint);
		    }

	        pane.setViewportView(buttonPanel);
	        mainPanel.add(pane);
		    cFrame.add(mainPanel); // or other panel etc.
		    
		    
		
		  //  pane.updateUI();
		    cFrame.repaint();
		    //catPanel.updateUI();
		   //catPanel.repaint();
		    cFrame.setVisible(true); */
	}
   

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}
	
//	public static void main(String args[]) {
	//	new CustomerWindow();
	//}
	
	
}
