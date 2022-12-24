package room_booking_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPage implements ActionListener {

    private static String adminName = "admin123";

    private static JLabel label;
    private static JTextField admText;
    private static JButton adm_button;
    private static JButton usr_button;
    public static JFrame frame;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JPanel panel = new JPanel();


        frame = new JFrame();
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        panel.setLayout(null);

        label = new JLabel("admin_name");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        admText = new JTextField(20);
        admText.setBounds(100, 20, 165, 25);
        panel.add(admText);

        adm_button = new JButton("Admin Login");
        adm_button.setBounds(10, 80, 130, 25);
        adm_button.addActionListener(new LoginPage());
        panel.add(adm_button);

        usr_button = new JButton("User Direct Login");
        usr_button.setBounds(10, 120, 150, 25);
        usr_button.addActionListener(new LoginPage());
        panel.add(usr_button);
        frame.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adm_button) {
            String admintyped = admText.getText();
            if (admintyped.equals(adminName)) {
                RoomReservationSystem admin_entered = new RoomReservationSystem(0);
                frame.dispose();
                try {
                    admin_entered.main(null);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            } else {
                System.out.println("Incorrect Admin name!!!");
            }

        } else if (e.getSource() == usr_button) {
            frame.dispose();
            RoomReservationSystem user_entered = new RoomReservationSystem(1);
            String[] arguments = new String[]{"123"};
            frame.dispose();
            try {
                user_entered.main(null);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }


    }
}
