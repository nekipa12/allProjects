import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;

public class Registrator extends JDialog implements ActionListener {
	private JTextField tfName;
	private JTextField tfLastName;
	private JTextField tfPhoneNumber;
	private JTextField tfCity;
	private JTextField tfEmail;
	private String name;
	private String lastName;
	private String phoneNumber;
	private String city;
	private String email;
	private JButton btnOk;

	
	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public String getEmail() {
		return email;
	}

	public Registrator() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("Name");
		
		JLabel lblNewLabel_1 = new JLabel("Last name");
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		
		JLabel lblCity = new JLabel("City");
		
		JLabel lblEmail = new JLabel("email");
		
		tfName = new JTextField();
		tfName.setColumns(10);
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		
		tfPhoneNumber = new JTextField();
		tfPhoneNumber.setColumns(10);
		
		tfCity = new JTextField();
		tfCity.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblPhoneNumber)
						.addComponent(lblCity)
						.addComponent(lblEmail))
					.addGap(17)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(tfPhoneNumber, Alignment.LEADING)
						.addComponent(tfName, Alignment.LEADING)
						.addComponent(tfLastName, Alignment.LEADING)
						.addComponent(tfCity, Alignment.LEADING)
						.addComponent(tfEmail, Alignment.LEADING)
						.addComponent(btnOk, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap(252, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(tfName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(tfLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhoneNumber)
						.addComponent(tfPhoneNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCity)
						.addComponent(tfCity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(tfEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addComponent(btnOk)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String [] conditions = new String [5];
		conditions[0] = tfCity.getText();
		conditions[1] = tfEmail.getText();
		conditions[2] = tfLastName.getText();
		conditions[3] = tfName.getText();
		conditions[4] = tfPhoneNumber.getText();
		for(int i = 0; i < conditions.length; i++){
			if(conditions[i].equals("") || conditions[i] == null){
				JOptionPane.showMessageDialog(null, "all conditions must be filed in");
				return;
			}
		}
		if(e.getSource().equals(btnOk)){
			name = tfName.getText();
			lastName = tfLastName.getText();
			phoneNumber = tfPhoneNumber.getText();
			city = tfCity.getText();
			email = tfEmail.getText();
			this.setVisible(false);
		}
		
	}
}
