import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectOutputStream;
import java.awt.Font;
import java.util.Vector;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.*;
import java.sql.*;

public class ViewKeys extends JFrame {

	public static DefaultTableModel dt1 = null;
	private JScrollPane js1 = null;
	private static JTable jTable1 = null;
	private JButton jButton1;
	public String uname = "";

	public ViewKeys() {

	}

	public void Design(String name) {
		setTitle("View Keys");
		uname = name;
		dt1 = new DefaultTableModel();
		jTable1 = new JTable(dt1);
		js1 = new JScrollPane(jTable1);

		dt1.addColumn("USERNAME");
		dt1.addColumn("METER NO");
		dt1.addColumn("KEY VALUE");

		setLayout(null);
		js1.setBounds(30, 50, 900, 150);

		jButton1 = new JButton("Generate Key");

		jButton1.setBounds(100, 400, 220, 33);

		// add(jButton1);

		add(js1);
		setSize(1000, 550);
		setVisible(true);

		try {
			Connection con = databasecon.getconnection();
			Statement st = con.createStatement();
			String a = "no";
			String qry = "select * from keyvalue where uname='" + uname + "'";
			ResultSet rs = st.executeQuery(qry);
			while (rs.next()) {
				Vector vc = new Vector();
				vc.add(rs.getString(1));
				vc.add(rs.getString(2));
				vc.add(rs.getString(3));
				dt1.addRow(vc);

			}
		} catch (Exception e1) {
			System.out.println(e1);
		}

	}

}
