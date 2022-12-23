package assignment1RoomReservation;

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