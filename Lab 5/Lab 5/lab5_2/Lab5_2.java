package lab5_2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Lab5_2 extends JFrame {

	private JPanel contentPane;
	private JTextField textInput;
	private JTextField textOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab5_2 frame = new Lab5_2();
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
	public Lab5_2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCount = new JButton("Count Letters");
		btnCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String textVal = textInput.getText();
				int count = textVal.length();
				textOutput.setText(""+count);
			}
		});
		btnCount.setBounds(24, 83, 152, 23);
		contentPane.add(btnCount);
		
		JButton btnReverseLetters = new JButton("Reverse Letters");
		btnReverseLetters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String toReverse = textInput.getText();
				String reversed = "";
				for(int i = toReverse.length()-1; i>=0 ; i--) {
					reversed += toReverse.charAt(i);
				}
				textOutput.setText(reversed);
			}
		});
		btnReverseLetters.setBounds(24, 133, 152, 23);
		contentPane.add(btnReverseLetters);
		
		JButton btnRemoveDuplicates = new JButton("Remove Duplicates");
		btnRemoveDuplicates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String input = textInput.getText();
				char[] charArr = input.toCharArray();
				int count = 0;
				char[] newCharArray = new char[charArr.length];
				for(int i = 0 ; i < charArr.length ; i++) {
					boolean isDuplicate = false;
					for(int j = 0 ; j < newCharArray.length ; j++) {
						if(charArr[i]==newCharArray[j]) {
							isDuplicate = true;
							break;
						}
					}
					if(!isDuplicate) {
						newCharArray[count] = charArr[i];
						count++;
					}
				}
				String noDuplicates = new String(newCharArray);
				textOutput.setText(noDuplicates);
			}
		});
		btnRemoveDuplicates.setBounds(24, 182, 152, 23);
		contentPane.add(btnRemoveDuplicates);
		
		textInput = new JTextField();
		textInput.setBounds(245, 108, 86, 20);
		contentPane.add(textInput);
		textInput.setColumns(10);
		
		textOutput = new JTextField();
		textOutput.setBounds(245, 161, 86, 20);
		contentPane.add(textOutput);
		textOutput.setColumns(10);
		
		JLabel lblInput = new JLabel("Input");
		lblInput.setBounds(245, 87, 46, 14);
		contentPane.add(lblInput);
		
		JLabel lblOutput = new JLabel("Output");
		lblOutput.setBounds(245, 142, 46, 14);
		contentPane.add(lblOutput);
	}
}
