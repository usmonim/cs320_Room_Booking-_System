package assignment1RoomReservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {
	
        private static String profEmail = "hasan@ozu.edu.tr";
	private static String profEmail2 = "reyhan@ozu.edu.tr";
	private static String profEmail3 = "furkan@ozu.edu.tr";
	private static String profEmail4 = "ismail@ozu.edu.tr";
  
  private static JLabel label;
	private static JTextField admText;
	private static JButton adm_button;
	private static JButton usr_button;
	public static JFrame frame;
  
  public static void main(String[] args) {
    JPanel panel = new JPanel();
		

		frame = new JFrame();
		frame.setSize(500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		label = new JLabel("prof_name");
		label.setBounds(10, 20, 80, 25);
		panel.add(label);
		
		admText = new JTextField(20);
		admText.setBounds(100, 20, 165, 25);
		panel.add(admText);
	  
	  	adm_button = new JButton("Prof Login");
		adm_button.setBounds(10, 80, 130, 25);
		adm_button.addActionListener(new LoginPage());
		panel.add(adm_button);
	  
	  	usr_button = new JButton("User Direct Login");
		usr_button.setBounds(10, 120, 150, 25);
		usr_button.addActionListener(new LoginPage());
		panel.add(usr_button);
		frame.setVisible(true);
  }
}
