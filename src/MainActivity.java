import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MainActivity{
	JButton bCustomer,bAdmin;
    private JLabel lWelcome;
	private JLabel status;
	JFrame frame;
	JPanel controlPanel;
	
	MainActivity() {
		prepareGUI();
		
	}
	
	private void prepareGUI() {
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
	
	}
	
	private void welcomePage() {
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
			action=e.getActionCommand();
			if(action == "Customer")
				status.setText("Welcome Customer");
			else
				status.setText("Welcome Admin");

			//frame.repaint();
		}

	}

	


}
