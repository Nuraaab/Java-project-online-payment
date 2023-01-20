package demo;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import api.APIClient;
import api.UserAPI;
import entity.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFrameTest extends JFrame {

	private JPanel contentPane;
	private JTable tableUser;
	private JTextField textFieldIdEmail;
	private JTextField textFieldPassword;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldGender;
	private JTextField textFieldStatus;
	private JTextField textFieldInsertTime;
	private JTextField textFieldLastUpdate;
	private JTextField textFieldId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameTest frame = new JFrameTest();
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
	public JFrameTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 726);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 11, 629, 102);
		contentPane.add(scrollPane);
		
		tableUser = new JTable();
		tableUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		tableUser.setForeground(new Color(64, 0, 64));
		tableUser.setBackground(new Color(0, 128, 64));
		scrollPane.setViewportView(tableUser);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "User information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(111, 147, 560, 529);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel Jl_id = new JLabel("Id");
		Jl_id.setBounds(21, 31, 79, 14);
		panel.add(Jl_id);
		
		textFieldIdEmail = new JTextField();
		textFieldIdEmail.setBounds(152, 68, 231, 20);
		panel.add(textFieldIdEmail);
		textFieldIdEmail.setColumns(10);
		
		JLabel Jl_Email = new JLabel("Email");
		Jl_Email.setBounds(21, 71, 79, 14);
		panel.add(Jl_Email);
		
		JLabel Jl_Password = new JLabel("Password");
		Jl_Password.setBounds(21, 106, 79, 14);
		panel.add(Jl_Password);
		
		JLabel Jl_FirstName = new JLabel("First Name");
		Jl_FirstName.setBounds(21, 143, 79, 20);
		panel.add(Jl_FirstName);
		
		JLabel Jl_LastName = new JLabel("Last Name");
		Jl_LastName.setBounds(21, 189, 79, 14);
		panel.add(Jl_LastName);
		
		JLabel Jl_Gender = new JLabel("Gender");
		Jl_Gender.setBounds(21, 229, 46, 14);
		panel.add(Jl_Gender);
		
		JLabel Jl_InsertTime = new JLabel("Insert Time");
		Jl_InsertTime.setBounds(21, 310, 79, 14);
		panel.add(Jl_InsertTime);
		
		JLabel Jl_status = new JLabel("Status");
		Jl_status.setBounds(21, 260, 46, 14);
		panel.add(Jl_status);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setColumns(10);
		textFieldPassword.setBounds(152, 103, 231, 20);
		panel.add(textFieldPassword);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setColumns(10);
		textFieldFirstName.setBounds(152, 143, 231, 20);
		panel.add(textFieldFirstName);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(152, 186, 231, 20);
		panel.add(textFieldLastName);
		
		textFieldGender = new JTextField();
		textFieldGender.setColumns(10);
		textFieldGender.setBounds(152, 226, 231, 20);
		panel.add(textFieldGender);
		
		textFieldStatus = new JTextField();
		textFieldStatus.setColumns(10);
		textFieldStatus.setBounds(152, 257, 231, 20);
		panel.add(textFieldStatus);
		
		textFieldInsertTime = new JTextField();
		textFieldInsertTime.setColumns(10);
		textFieldInsertTime.setBounds(152, 307, 231, 20);
		panel.add(textFieldInsertTime);
		
		textFieldLastUpdate = new JTextField();
		textFieldLastUpdate.setColumns(10);
		textFieldLastUpdate.setBounds(152, 345, 231, 20);
		panel.add(textFieldLastUpdate);
		
		textFieldId = new JTextField();
		textFieldId.setColumns(10);
		textFieldId.setBounds(152, 28, 231, 20);
		panel.add(textFieldId);
		
		JLabel Jl_LastUpdate = new JLabel("Last Update ");
		Jl_LastUpdate.setBounds(21, 348, 79, 14);
		panel.add(Jl_LastUpdate);
		
		JButton btn_Create = new JButton("Create");
		btn_Create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					User user = new User();
					user.setId(textFieldId.getText());
					user.setEmail(textFieldIdEmail.getText());
					user.setPassword(textFieldPassword.getText());
					user.setFirst_name(textFieldFirstName.getText());
					user.setLast_name(textFieldLastName.getText());
					user.setGender(textFieldGender.getText());
					user.setStatus(textFieldStatus.getText());
					user.setInsert_time(textFieldInsertTime.getText());
					user.setLast_update(textFieldLastUpdate.getText());
					UserAPI userAPI = APIClient.getClient().create(UserAPI.class);
					userAPI.create(user).enqueue(new Callback<Void>() {

						public void onFailure(Call<Void> arg0, Throwable t) {
							JOptionPane.showMessageDialog(null, t.getMessage());
							
						}

						public void onResponse(Call<Void> call, Response<Void> response) {
						if(response.isSuccessful()) {
							loadData();
						}
							
						}
						
					});
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		btn_Create.setBounds(52, 405, 89, 23);
		panel.add(btn_Create);
		
		JButton btn_Update = new JButton("Update");
		btn_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		try {
			User user =new User();
			user.setId(textFieldId.getText());
			user.setEmail(textFieldIdEmail.getText());
			user.setPassword(textFieldPassword.getText());
			user.setFirst_name(textFieldFirstName.getText());
			user.setLast_name(textFieldLastName.getText());
			user.setGender(textFieldGender.getText());
			user.setStatus(textFieldStatus.getText());
			user.setInsert_time(textFieldInsertTime.getText());
			user.setLast_update(textFieldLastUpdate.getText());
			UserAPI userAPI = APIClient.getClient().create(UserAPI.class);
			userAPI.update(user).enqueue(new Callback<Void> () {
				User user =new User();
			
				public void onFailure(Call<Void> arg0, Throwable t) {
					JOptionPane.showMessageDialog(null, t.getMessage());
					
				}

				public void onResponse(Call<Void> call, Response<Void> response) {
				if(response.isSuccessful()) {
				
					loadData();
				}
					
				}
				
			});
		}catch(Exception e4) {
		JOptionPane.showMessageDialog(null, e4.getMessage());	
			}
			}
		});
		btn_Update.setBounds(187, 405, 89, 23);
		panel.add(btn_Update);
		
		JButton btn_Delete = new JButton("Delete");
		btn_Delete.setBounds(334, 405, 89, 23);
		panel.add(btn_Delete);
		loadData();
	}
	
private void loadData() {
	try {
		UserAPI userAPI =APIClient.getClient().create(UserAPI.class);
		userAPI.findAll().enqueue(new Callback<List<User>> () {

			public void onFailure(Call<List<User>> arg0, Throwable t) {
				JOptionPane.showConfirmDialog(null, t.getMessage());
				
			}

			public void onResponse(Call<List<User>> call, Response<List<User>> response) {
				if(response.isSuccessful()) {
					DefaultTableModel defaultTableModel = new DefaultTableModel();
					defaultTableModel.addColumn("Id");
					defaultTableModel.addColumn("Email");
					defaultTableModel.addColumn("Password");
					defaultTableModel.addColumn("First Name");
					defaultTableModel.addColumn("Last Name");
					defaultTableModel.addColumn("Gender");
					defaultTableModel.addColumn("Status");
					defaultTableModel.addColumn("Insert Time");
					defaultTableModel.addColumn("Last Update");
					for(User user:response.body()) {
						defaultTableModel.addRow(new Object[] {
					    user.getId(),
						user.getEmail(),
						user.getPassword(),user.getFirst_name(),
						user.getLast_name(),user.getGender(),
						user.getStatus(),user.getInsert_time(),
						user.getLast_update()
						});
					}
					tableUser.setModel(defaultTableModel);
				
				}
				
			}
			
		});
	}catch(Exception e) {
		JOptionPane.showConfirmDialog(null, e.getMessage());
	}
	
	
	
}

}


