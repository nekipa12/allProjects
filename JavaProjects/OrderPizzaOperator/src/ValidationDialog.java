import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JDialog;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;


public class ValidationDialog extends JDialog {
	private JLabel lbAbout;
	private String pos;
	private ArrayList<String> al;
	
	public ValidationDialog(String position){
		pos = position;
		al = new ArrayList<>();
	}
	public void start() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 703, 300);
		Gson g = new Gson();
		java.lang.reflect.Type type = new TypeToken<ArrayList<String>>(){}.getType();
		al = g.fromJson(pos, type);
		lbAbout = new JLabel(pos);
		JButton btnValidation = new JButton("Validation");
		btnValidation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SendMassage sm = new SendMassage(al.get(4).toString());
				Thread t = new Thread(sm);
				t.start();
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(btnValidation))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lbAbout, GroupLayout.DEFAULT_SIZE, 667, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addComponent(lbAbout, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
					.addComponent(btnValidation)
					.addGap(65))
		);
		getContentPane().setLayout(groupLayout);
	}
}
