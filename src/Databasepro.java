import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Databasepro extends JFrame {

	private JPanel contentPane;
	Connection conn= null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	private JTable loadtable;
	private JScrollPane scrollPane;
	private JPanel panel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Databasepro frame = new Databasepro();
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
	public Databasepro() {
		setBackground(new Color(0, 0, 139));
		design();
		conn = SQLConnection.ConnecrDB();
	}
	private void loadtable() {
		try {
			String quary="select *from user";
			 pst =conn.prepareStatement(quary);
			 rs= pst.executeQuery();
			loadtable.setModel(DbUtils.resultSetToTableModel(rs));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void design()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnClick = new JButton("Click to show table");
		btnClick.setBackground(new Color(205, 133, 63));
		btnClick.setBounds(81, 380, 555, 53);
		btnClick.setFont(new Font("Myriad Pro", Font.BOLD, 33));
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null,"hello world");
				loadtable();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnClick);
		
		panel = new JPanel();
		panel.setForeground(new Color(240, 248, 255));
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(65, 105, 225), new Color(100, 149, 237), new Color(95, 158, 160), new Color(154, 205, 50)));
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(12, 34, 714, 299);
		contentPane.add(panel);
		panel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 714, 299);
		panel.add(scrollPane);
		
		loadtable = new JTable();
		scrollPane.setViewportView(loadtable);
		loadtable.setFont(new Font("Tahoma", Font.PLAIN, 15));
	}
}
