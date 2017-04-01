package cc.chaoyangliu.rmiprac.service;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class GradeManager extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5548075107565345023L;
	private JPanel contentPane;
	public DataService ds; 
	private JTextField TableNameTextField;
	private JTextField SIDTextField;
	private JTextField SnameTextField;
	private JLabel lblTables2;
	private JLabel lblStudentId2;
	private JButton btnQueryIt;
	private JSeparator QuerySeparator;
	private JButton btnAddIt;
	private JSeparator AddSeparator;
	private JLabel lblStudentId;
	private JLabel lblStudentName;
	private JLabel lblTables;
	private JSeparator CreateTableSeparator;
	private JButton CreateTableButton;
	private JLabel TableNameLabel;
	private JTextField SIDTextField2;
	private JComboBox<String> TablescomboBox;
	private JComboBox<String> TablescomboBox2;
	private ArrayList<String> Tables;
	private JButton btnFresh;
	private JTextField GradeTextField;
	private JLabel lblGrade;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GradeManager frame = new GradeManager();
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
	public GradeManager() {
		Tables = new ArrayList<String>();
		setResizable(false);
		setTitle("Grade Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		TableNameLabel = new JLabel("Table Name:");
		TableNameLabel.setBounds(115, 32, 72, 24);
		contentPane.add(TableNameLabel);
		
		TableNameTextField = new JTextField();
		TableNameTextField.setBounds(203, 34, 112, 21);
		contentPane.add(TableNameTextField);
		TableNameTextField.setColumns(10);
		
		CreateTableButton = new JButton("Create Table");
		CreateTableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String TableName = TableNameTextField.getText();
				Boolean isRepeated = false;
				ArrayList<String> ts = null;
				try {
					ts = ds.showTables();
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				for (int i = 0; i < ts.size(); i++) {
					if (TableName.equals(ts.get(i)))
						isRepeated = true;
				}
				if (TableName.equals("")) {
					JOptionPane.showMessageDialog(null, "Table name can't be null!");
				} else if (isRepeated) {
					JOptionPane.showMessageDialog(null, "Table '" + TableName + "' already exists!");
				} else {
					try {
						if(ds.createTable(TableName)) {
							JOptionPane.showMessageDialog(null, "Table Creation Success");
						}
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}					
			}
		});
		CreateTableButton.setBounds(149, 88, 136, 23);
		contentPane.add(CreateTableButton);
		
		CreateTableSeparator = new JSeparator();
		CreateTableSeparator.setBounds(10, 10, 414, 122);
		contentPane.add(CreateTableSeparator);
		
		lblTables = new JLabel("Tables:");
		lblTables.setBounds(133, 172, 54, 24);
		contentPane.add(lblTables);
		
		lblStudentId = new JLabel("Student ID:");
		lblStudentId.setBounds(115, 227, 72, 24);
		contentPane.add(lblStudentId);
		
		btnAddIt = new JButton("Add It!");
		btnAddIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tn = (String)TablescomboBox.getSelectedItem();
				String sid = SIDTextField.getText();
				String sn = SnameTextField.getText();
				String tg = GradeTextField.getText();
				
				if (sid.equals("")) {
					JOptionPane.showMessageDialog(null, "Student ID can't be null!");
				} else if (sn.equals("")) {
					JOptionPane.showMessageDialog(null, "Student name can't be null!");
				} else if (tg.equals("")) {
					JOptionPane.showMessageDialog(null, "Grade can't be null!");
				} else {
					int g = Integer.parseInt(tg);
					try {
						if(ds.addGrade(tn, sn, sid, g)) {
							JOptionPane.showMessageDialog(null, "Grade Add Success");
						}
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}	
			}
		});
		btnAddIt.setBounds(149, 387, 136, 23);
		contentPane.add(btnAddIt);
		
		AddSeparator = new JSeparator();
		AddSeparator.setBounds(10, 142, 414, 275);
		contentPane.add(AddSeparator);
		
		SIDTextField = new JTextField();
		SIDTextField.setBounds(203, 229, 112, 21);
		contentPane.add(SIDTextField);
		SIDTextField.setColumns(10);
		
		lblStudentName = new JLabel("Student Name:");
		lblStudentName.setBounds(94, 286, 93, 24);
		contentPane.add(lblStudentName);
		
		SnameTextField = new JTextField();
		SnameTextField.setBounds(203, 289, 112, 21);
		contentPane.add(SnameTextField);
		SnameTextField.setColumns(10);
		
		lblTables2 = new JLabel("Tables:");
		lblTables2.setBounds(133, 435, 54, 21);
		contentPane.add(lblTables2);
		
		lblStudentId2 = new JLabel("Student ID:");
		lblStudentId2.setBounds(115, 486, 72, 24);
		contentPane.add(lblStudentId2);
		
		btnQueryIt = new JButton("Query It!");
		btnQueryIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tn = (String)TablescomboBox2.getSelectedItem();
				String id = SIDTextField2.getText();
				if (id.equals("")) {
					JOptionPane.showMessageDialog(null, "Student ID can't be null!");
				} else {
					try {
						int g = ds.queryGrade(tn, id);
						if (g != 0) {
							JOptionPane.showMessageDialog(null, "The Grade is " + g + "!");
						} else {
							JOptionPane.showMessageDialog(null, "No This Student!");
						}		
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnQueryIt.setBounds(149, 553, 136, 23);
		contentPane.add(btnQueryIt);
		
		QuerySeparator = new JSeparator();
		QuerySeparator.setBounds(10, 420, 414, 171);
		contentPane.add(QuerySeparator);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Exit();
			}
		});
		btnExit.setBounds(38, 611, 93, 23);
		contentPane.add(btnExit);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Are you pig?");
			}
		});
		btnHelp.setBounds(300, 611, 93, 23);
		contentPane.add(btnHelp);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 601, 414, 42);
		contentPane.add(separator_1);
		
		SIDTextField2 = new JTextField();
		SIDTextField2.setBounds(207, 488, 108, 21);
		contentPane.add(SIDTextField2);
		SIDTextField2.setColumns(10);
		//String [] tempTables = null;
		//tempTables = (Tables.toArray(new String[Tables.size()]));
		TablescomboBox = new JComboBox<String>();
		TablescomboBox.setBounds(204, 174, 112, 21);
		contentPane.add(TablescomboBox);
		
		TablescomboBox2 = new JComboBox<String>();
		TablescomboBox2.setBounds(207, 435, 108, 21);
		contentPane.add(TablescomboBox2);
		
		btnFresh = new JButton("Fresh");
		btnFresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateComboxes();
			}
		});
		
		btnFresh.setBounds(169, 611, 93, 23);
		contentPane.add(btnFresh);
		
		lblGrade = new JLabel("Grade:");
		lblGrade.setBounds(141, 341, 44, 24);
		contentPane.add(lblGrade);
		
		GradeTextField = new JTextField();
		GradeTextField.setBounds(203, 343, 112, 21);
		contentPane.add(GradeTextField);
		GradeTextField.setColumns(10);
	}
	
	public void setDs(String u, String p, String d) {
		
		try {
			ds = (DataService) Naming.lookup("//localhost:1235/ds");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ds.connDataBase(u, p, d);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		updateComboxes();
	}
	public void updateComboxes() {
		ArrayList<String> ts = new ArrayList<String>();
		try {
			ts = ds.showTables();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TablescomboBox.removeAllItems();
		TablescomboBox2.removeAllItems();
		for (int i = 0; i < ts.size(); i++) {
			TablescomboBox.addItem(ts.get(i));
			TablescomboBox2.addItem(ts.get(i));
		}
	}
	public void Exit() {
		this.setVisible(false);
		this.dispose();
	}
}
