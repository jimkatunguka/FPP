package lab5_1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lab5_1 extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textStreet;
	private JTextField textCity;
	private JTextField textState;
	private JTextField textZIP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab5_1 frame = new Lab5_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Lab5_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textName = new JTextField();
		textName.setBounds(10, 36, 129, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		textStreet = new JTextField();
		textStreet.setColumns(10);
		textStreet.setBounds(149, 36, 125, 20);
		contentPane.add(textStreet);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(149, 11, 46, 14);
		contentPane.add(lblStreet);
		
		textCity = new JTextField();
		textCity.setColumns(10);
		textCity.setBounds(284, 36, 117, 20);
		contentPane.add(textCity);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(284, 11, 46, 14);
		contentPane.add(lblCity);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(77, 80, 46, 14);
		contentPane.add(lblState);
		
		textState = new JTextField();
		textState.setColumns(10);
		textState.setBounds(77, 105, 129, 20);
		contentPane.add(textState);
		
		JLabel lblZip = new JLabel("ZIP");
		lblZip.setBounds(216, 80, 46, 14);
		contentPane.add(lblZip);
		
		textZIP = new JTextField();
		textZIP.setColumns(10);
		textZIP.setBounds(216, 105, 129, 20);
		contentPane.add(textZIP);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String details = textName.getText() + "\n" +
								textStreet.getText()+"\n"+
								textCity.getText() + ", " + textState.getText() + " " +
								textZIP.getText();
				System.out.println(details);
			}
		});
		btnSubmit.setBounds(166, 162, 89, 23);
		contentPane.add(btnSubmit);
	}
}
