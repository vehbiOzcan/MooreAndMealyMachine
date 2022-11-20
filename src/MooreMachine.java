import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class MooreMachine extends JFrame {

	private JPanel contentPane;
	private JTextField fld_state;
	private JTextField fld_alphabet;
	private JTextField fld_outAlp;
	private JTable table;
	private DefaultTableModel tabModel = null; 
	private Object[] colName;
	private int colCount = 0;
	private int rowCount = 0;
	private String[] alpSplit;
	private String[] stateSplit;
	private String[] outSplit;
	private JTextField fld_output;
	private JTextField fld_input;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MooreMachine frame = new MooreMachine();
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
	public MooreMachine() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scp_table = new JScrollPane();
		scp_table.setBounds(39, 179, 737, 314);
		contentPane.add(scp_table);
		
		table = new JTable();
		scp_table.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u2192");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 185, 29, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Q :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(39, 37, 29, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u2211 :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(39, 76, 29, 24);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u0393 :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(39, 117, 29, 24);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("{");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(78, 37, 29, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("}");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(318, 37, 29, 24);
		contentPane.add(lblNewLabel_2_1);
		
		fld_state = new JTextField();
		fld_state.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fld_state.setBounds(88, 37, 228, 29);
		contentPane.add(fld_state);
		fld_state.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("}");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(318, 76, 29, 24);
		contentPane.add(lblNewLabel_2_1_1);
		
		fld_alphabet = new JTextField();
		fld_alphabet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fld_alphabet.setColumns(10);
		fld_alphabet.setBounds(88, 76, 228, 29);
		contentPane.add(fld_alphabet);
		
		JLabel lblNewLabel_2_2 = new JLabel("{");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(78, 76, 29, 24);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("}");
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1_2.setBounds(318, 117, 29, 24);
		contentPane.add(lblNewLabel_2_1_2);
		
		fld_outAlp = new JTextField();
		fld_outAlp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fld_outAlp.setColumns(10);
		fld_outAlp.setBounds(88, 117, 228, 29);
		contentPane.add(fld_outAlp);
		
		JLabel lblNewLabel_2_3 = new JLabel("{");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_3.setBounds(78, 117, 29, 24);
		contentPane.add(lblNewLabel_2_3);
		
		JButton btnGetTable = new JButton("Tablo Olu\u015Ftur");
		btnGetTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tabModel == null) {
					tabModel = new DefaultTableModel();
				}
				
				alpSplit = fld_alphabet.getText().split(",");
				stateSplit = fld_state.getText().split(",");
				outSplit = fld_outAlp.getText().split(",");
				colCount = alpSplit.length + 2;
				rowCount = stateSplit.length;
				tableAddColumn(alpSplit,fld_outAlp.getText());
				tableAddRow(stateSplit,rowCount);
			}
		});
		btnGetTable.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGetTable.setBounds(359, 37, 149, 21);
		contentPane.add(btnGetTable);
		
		JButton btnRun = new JButton("\u00C7\u0131kt\u0131y\u0131 G\u00F6ster");
		btnRun.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Map<String,String[]> stateTable = initStateTable();
				String input = fld_input.getText().toString();
				String output = generateOutput(stateTable, input);
				fld_output.setText(output);
			}
			
		});
		btnRun.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRun.setBounds(359, 76, 149, 21);
		contentPane.add(btnRun);
		
		fld_output = new JTextField();
		fld_output.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fld_output.setEditable(false);
		fld_output.setColumns(10);
		fld_output.setBounds(548, 112, 228, 29);
		contentPane.add(fld_output);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("\u00C7\u0131kt\u0131 (Output) :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(548, 85, 228, 24);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("`Q \u2211 \u0393 de\u011Ferlerini girdikten sonra State ge\u00E7i\u015Flerini tabloda doldurunuz.Tablo Olu\u015Ftur butona bas\u0131n\u0131z `");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(39, 151, 722, 24);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Girdi (\u0130nput) :");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2.setBounds(548, 20, 228, 24);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		fld_input = new JTextField();
		fld_input.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fld_input.setColumns(10);
		fld_input.setBounds(548, 46, 228, 29);
		contentPane.add(fld_input);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Moore Makinesi");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2_1.setBounds(10, 3, 228, 24);
		contentPane.add(lblNewLabel_1_1_1_2_1);
	}
	
	public Map<String,String[]> initStateTable() {
		 Map<String,String[]> stateTable = new HashMap<>();
		 String state = "";
		 String s1 = "";
		 String s2 = "";
		 String s3 = "";
		
		 for(int i = 0; i < rowCount; i++) {
			 state = table.getValueAt(i, 0).toString();
			 s1 = table.getValueAt(i, 1).toString();
			 s2 = table.getValueAt(i, 2).toString();
			 s3 = table.getValueAt(i, 3).toString();
			 stateTable.put(state,createStringArr(s1, s2, s3));
		 }
		
		 return stateTable;
	}
	
	public String generateOutput(Map<String,String[]> stateTable, String input) {
		
		char[] inputChar = input.toCharArray();
		String nextState = "";
		String currentState = table.getValueAt(0, 0).toString();
		String[] currStateValues = new String[5];
		String output = stateTable.get(currentState)[2];
		
		for(char ch : inputChar) {
			currStateValues = stateTable.get(currentState);
			if(ch == alpSplit[0].toCharArray()[0]) {
				nextState = currStateValues[0];
			}else if(ch == alpSplit[1].toCharArray()[0]){
				nextState = currStateValues[1];
			}
			
			output += stateTable.get(nextState)[2];
			currentState = nextState;
		}
		
		return output;
	}
	
	public void tableAddRow(String[] state, int row) { //Satýrlarý ekler
		Object[] rowData = new Object[4]; 
		tabModel.setRowCount(0);
		for(int i = 0; i < row; i++) {
			rowData[0] = state[i]; 
			rowData[1] = null; 
			rowData[2] = null; 
			rowData[3] = null; 
			tabModel.addRow(rowData);
		}
	}
	public void tableAddColumn(String[] alf,String out) { //Baþlýklarý Ekler
		colName = new Object[4];
		colName[0] = "Old State";
		colName[1] = "After Ýnput " + alf[0];
		colName[2] = "After Ýnput " + alf[1];		
		colName[3] = "Character Printed (" +out+")";
		System.out.println(colName[0]);

		this.tabModel.setColumnIdentifiers(colName);
		table.setModel(tabModel);
	}
	public String[] createStringArr(String s1,String s2,String s3) {
		String[] arr = {s1,s2,s3};
		return arr;
	}
}
