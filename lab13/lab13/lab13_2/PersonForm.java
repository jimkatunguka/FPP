package prog13_2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PersonForm extends JFrame {

	private JPanel contentPane;
	private JTextField idForm;
	private JTextField fnForm;
	private JTextField lnForm;
	private JTextField ssnForm;
	private JTextField streetForm;
	private JTextField cityFrom;
	private JTextField stateForm;
	private JTextField zipForm;
	private JTable table;

	public static Connection getDatabaseConnection() {
		Connection dbcon = null;
		try {
			String USERNAME = "root";
			String PASSWORD = "601563";
			String DRIVER = "com.mysql.jdbc.Driver";
			String URL = "jdbc:mysql://localhost:3306/JavaDB";
			Class.forName(DRIVER);
			dbcon = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Database Can't connect");
		}
		return dbcon;
	}

	public List<Person> findAll() {
		List<Person> list = new ArrayList<>();
		try {
			Connection dbcon = getDatabaseConnection();
			String query = "SELECT * FROM PERSON";
			PreparedStatement preparedStatement = dbcon.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Person person = new Person();
				person.setId(resultSet.getString(1));
				person.setFirstName(resultSet.getString(2));
				person.setLastName(resultSet.getString(3));
				person.setSsn(resultSet.getString(4));
				person.setStreet(resultSet.getString(5));
				person.setCity(resultSet.getString(6));
				person.setState(resultSet.getString(7));
				person.setZip(resultSet.getString(8));
				list.add(person);
			}
			resultSet.close();
			preparedStatement.close();
			dbcon.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Person Info Not Found");
		}
		return list;
	}

	public Person findById(String id) {
		Person person = null;
		try {
			Connection dbcon = getDatabaseConnection();
			String query = "SELECT * FROM PERSON WHERE ID=?";
			PreparedStatement preparedStatement = con.prepareStatement(query);
			if (id.equals(""))
				id = "EMPTY";
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				person = new Person();
				person.setId(resultSet.getString(1));
				person.setFirstName(resultSet.getString(2));
				person.setLastName(resultSet.getString(3));
				person.setSsn(resultSet.getString(4));
				person.setStreet(resultSet.getString(5));
				person.setCity(resultSet.getString(6));
				person.setState(resultSet.getString(7));
				person.setZip(resultSet.getString(8));
			}
			resultSet.close();
			preparedStatement.close();
			dbcon.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Fetch Person Information Error");
		}
		return person;
	}

	public void clearData() {
		idForm.setText("");
		fnForm.setText("");
		lnForm.setText("");
		ssnForm.setText("");
		streetForm.setText("");
		cityFrom.setText("");
		stateForm.setText("");
		zipForm.setText("");
	}

	/**
	 * Launching
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonForm frame = new PersonForm();
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width / 2 - frame.getSize().width / 2,
							dim.height / 2 - frame.getSize().height / 2);
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
	public PersonForm() {
		setBackground(Color.GRAY);
		setTitle("Address From");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("ID");
		lblId.setBounds(32, 63, 46, 14);
		contentPane.add(lblId);

		idForm = new JTextField();
		idForm.setBounds(32, 77, 86, 30);
		contentPane.add(idForm);
		idForm.setColumns(10);

		JLabel lblFirstname = new JLabel("First Name");
		lblFirstname.setBounds(131, 63, 86, 14);
		contentPane.add(lblFirstname);

		fnForm = new JTextField();
		fnForm.setColumns(10);
		fnForm.setBounds(128, 77, 175, 30);
		contentPane.add(fnForm);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(313, 63, 86, 14);
		contentPane.add(lblLastName);

		lnForm = new JTextField();
		lnForm.setColumns(10);
		lnForm.setBounds(313, 77, 183, 30);
		contentPane.add(lnForm);

		ssnForm = new JTextField();
		ssnForm.setColumns(10);
		ssnForm.setBounds(506, 77, 183, 30);
		contentPane.add(ssnForm);

		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setBounds(506, 63, 86, 14);
		contentPane.add(lblSsn);

		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(35, 118, 86, 14);
		contentPane.add(lblStreet);

		streetForm = new JTextField();
		streetForm.setColumns(10);
		streetForm.setBounds(32, 132, 175, 30);
		contentPane.add(streetForm);

		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(217, 118, 86, 14);
		contentPane.add(lblCity);

		cityFrom = new JTextField();
		cityFrom.setColumns(10);
		cityFrom.setBounds(217, 132, 183, 30);
		contentPane.add(cityFrom);

		JLabel lblState = new JLabel("State");
		lblState.setBounds(410, 118, 86, 14);
		contentPane.add(lblState);

		stateForm = new JTextField();
		stateForm.setColumns(10);
		stateForm.setBounds(410, 132, 183, 30);
		contentPane.add(stateForm);

		zipForm = new JTextField();
		zipForm.setColumns(10);
		zipForm.setBounds(603, 132, 86, 30);
		contentPane.add(zipForm);

		JLabel lblZip = new JLabel("ZIP");
		lblZip.setBounds(603, 118, 46, 14);
		contentPane.add(lblZip);

		JLabel message = new JLabel("");
		message.setFont(new Font("Tahoma", Font.PLAIN, 13));
		message.setForeground(Color.RED);
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setBounds(32, 173, 657, 30);
		contentPane.add(message);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String id = idForm.getText();
				Person person = findById(id);
				if (person == null) {
					clearData();
					idForm.setText(id);
					message.setText("You are using an invalid or not existing ID " + id);
				} else {
					idForm.setText(person.getId());
					fnForm.setText(person.getFirstName());
					lnForm.setText(person.getLastName());
					ssnForm.setText(person.getSsn());
					streetForm.setText(person.getStreet());
					cityFrom.setText(person.getCity());
					stateForm.setText(person.getState());
					zipForm.setText(person.getZip());
					message.setText("Person found and displayed with ID " + id);
				}
			}
		});
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(143, 208, 137, 35);
		contentPane.add(btnSearch);

		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.WHITE);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idForm.getText();
				String fn = fnForm.getText();
				String ln = lnForm.getText();
				String ssn = ssnForm.getText();
				String street = streetForm.getText();
				String city = cityFrom.getText();
				String state = stateForm.getText();
				String zip = zipForm.getText();
				try {
					if (canSave()) {
						Connection dbcon = getDatabaseConnection();
						String query = "INSERT INTO PERSON (ID, FIRST_NAME, LAST_NAME, SSN, STREET, CITY, STATE, ZIP) VALUES (?,?,?,?,?,?,?,?)";
						PreparedStatement preparedStatement = dbcon.prepareStatement(query);
						preparedStatement.setString(1, id);
						preparedStatement.setString(2, fn);
						preparedStatement.setString(3, ln);
						preparedStatement.setString(4, ssn);
						preparedStatement.setString(5, street);
						preparedStatement.setString(6, city);
						preparedStatement.setString(7, state);
						preparedStatement.setString(8, zip);

						preparedStatement.executeUpdate();
						preparedStatement.close();
						dbcon.close();
						message.setText("DataBase has been updated successful");
					}
				} catch (SQLException ex) {
					message.setText("DataBase update Failure");
				}
			}

			private boolean canSave() {
				boolean valid = false;
				String id = idForm.getText();
				String fn = fnForm.getText();
				String ln = lnForm.getText();
				String ssn = ssnForm.getText();
				String street = streetForm.getText();
				String city = cityFrom.getText();
				String state = stateForm.getText();
				String zip = zipForm.getText();
				if (id.trim().equals(""))
					id = "EMPTY";
				Person object = findById(id);
				if (object != null) {
					valid = false;
					message.setText("ID Already Exist");
				}
				if (id.trim().equals("") && fn.trim().equals("") && ln.trim().equals("") && ssn.trim().equals("")
						&& street.trim().equals("") && city.trim().equals("") && state.trim().equals("")
						&& zip.trim().equals("")) {
					valid = true;
					message.setText("All fields must be filled with data");
				}
				return valid;
			}
		});
		btnSave.setBounds(290, 208, 137, 35);
		contentPane.add(btnSave);

		JButton btnClose = new JButton("Clear");
		btnClose.setBackground(Color.WHITE);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idForm.setText("");
				fnForm.setText("");
				lnForm.setText("");
				ssnForm.setText("");
				streetForm.setText("");
				cityFrom.setText("");
				stateForm.setText("");
				zipForm.setText("");
				message.setText("");
			}
		});
		btnClose.setBounds(437, 208, 137, 35);
		contentPane.add(btnClose);

		JLabel lblPersonInformationManagement = new JLabel("PERSON INFORMATION MANAGEMENT INFORMATION SYSTEM");
		lblPersonInformationManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonInformationManagement.setForeground(Color.BLACK);
		lblPersonInformationManagement.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPersonInformationManagement.setBounds(32, 22, 657, 30);
		contentPane.add(lblPersonInformationManagement);

		table = new JTable();
		table.setBounds(32, 308, 653, 189);
		contentPane.add(table);

		JLabel lblListOfPerson = new JLabel("LIST OF PERSON FROM DATABASE");
		lblListOfPerson.setHorizontalAlignment(SwingConstants.CENTER);
		lblListOfPerson.setForeground(Color.BLACK);
		lblListOfPerson.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblListOfPerson.setBounds(32, 273, 657, 30);
		contentPane.add(lblListOfPerson);

	}
}
