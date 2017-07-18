import javax.swing.JDialog;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.google.gson.Gson;

import javax.swing.JButton;


public class Basket extends JDialog {
	private JList list;
	private DefaultListModel dlm;
	private JLabel lblTotal;
	private JLabel lbTotalBill;
	private int count;
	private ArrayList<String[]> arr;
	private int iterator;
	private JButton btnBuy;
	private ArrayList<String> info;
	private Socket s;
	public JList getList() {
		return list;
	}
	public ArrayList<String[]> getArr() {
		return arr;
	}
	public Basket(ArrayList<String> g){
		arr = new ArrayList<>();
		info = new ArrayList<>();
		this.info = g;
		btnBuy = new JButton("Buy");
		
	}
	public void addArray(String[] values){
		arr.add(values);
	}
	public void addIn(){
		count = 0;
		dlm.clear();
		for(String [] a : arr){
			dlm.addElement(a[0]);
			count += Integer.parseInt(a[1]);
		}
		if(iterator > 0){
			lbTotalBill.setText(Integer.toString(count));
		}
		iterator++;
		if(!arr.isEmpty()){
			btnBuy.setEnabled(true);
		}
	}
	public void basket(Socket s2) {
		this.s = s2;
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 300);
		dlm = new DefaultListModel();
		list = new JList(dlm);
		addIn();
		JButton btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int c = list.getSelectedIndex();
				dlm.remove(c);
				arr.remove(c);
				count = 0;
				for(String [] a : arr){
					count += Integer.parseInt(a[1]);
				}
				if(arr.isEmpty()){
					btnBuy.setEnabled(false);
				}
				lbTotalBill.setText(Integer.toString(count));
			}
		});
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(list.getSelectedIndex() >= 0){
					btnDelete.setEnabled(true);
				}else{
					btnDelete.setEnabled(false);
				}
			}
		});
		lblTotal = new JLabel("Total");
		lbTotalBill = new JLabel("");
		lbTotalBill.setText(Integer.toString(count));
		
		btnBuy.setEnabled(false);
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> arr2 = new ArrayList<>();
				for(String [] f: arr){
					arr2.add(f[0]);
				}
				SendToServer sts = new SendToServer(info, arr2, s);
				Thread t = new Thread(sts);
				t.start();
				arr.clear();
				btnBuy.setEnabled(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDelete))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblTotal)
							.addGap(23)
							.addComponent(lbTotalBill))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnBuy)))
					.addContainerGap(180, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBuy, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblTotal)
									.addComponent(lbTotalBill)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDelete)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
	}
}
