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
  }
}
