import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class ViewRecord extends JFrame implements ActionListener {

        JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
        JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
        JTextField p1, p2;
        JButton b1, b2, b3;
        JComboBox cb1;
        String u = null;
        int u2 = 0, u1 = 0;
        int mn = 0;

        public void Design(String meterno, String uname) {

                Container con = getContentPane();
                con.setLayout(null);
                con.setBackground(Color.white);

                l1 = new JLabel("ID");
                l1.setBounds(100, 20, 100, 25);
                l1.setForeground(Color.blue);

                l2 = new JLabel("Meter Number");
                l2.setBounds(100, 50, 100, 25);
                l2.setForeground(Color.blue);

                l3 = new JLabel("User Name");
                l3.setBounds(100, 80, 100, 25);
                l3.setForeground(Color.blue);

                l4 = new JLabel("Address");
                l4.setBounds(100, 110, 100, 25);
                l4.setForeground(Color.blue);

                l5 = new JLabel("Reading Date");
                l5.setBounds(100, 140, 100, 25);
                l5.setForeground(Color.blue);

                l6 = new JLabel("Reading");
                l6.setBounds(100, 170, 100, 25);
                l6.setForeground(Color.blue);

                l7 = new JLabel("Unit");
                l7.setBounds(100, 200, 100, 25);
                l7.setForeground(Color.blue);

                l8 = new JLabel("Unit Amount");
                l8.setBounds(100, 230, 100, 25);
                l8.setForeground(Color.blue);

                l9 = new JLabel("Fine");
                l9.setBounds(100, 260, 100, 25);
                l9.setForeground(Color.blue);

                l10 = new JLabel("Total Cost");
                l10.setBounds(100, 290, 100, 25);
                l10.setForeground(Color.blue);

                l11 = new JLabel("Paid Date");
                l11.setBounds(100, 320, 100, 25);
                l11.setForeground(Color.blue);

                l12 = new JLabel("Recipt No");
                l12.setBounds(100, 350, 100, 25);
                l12.setForeground(Color.blue);

                t1 = new JTextField(10);
                t1.setBounds(250, 20, 100, 25);
                t1.setForeground(Color.blue);
                t1.setEditable(false);

                t2 = new JTextField(10);
                t2.setBounds(250, 50, 100, 25);
                t2.setForeground(Color.blue);

                t3 = new JTextField(10);
                t3.setBounds(250, 80, 100, 25);
                t3.setForeground(Color.blue);

                t4 = new JTextField(10);
                t4.setBounds(250, 110, 100, 30);
                t4.setForeground(Color.blue);
                t4.setBackground(new Color(204, 204, 255));

                t5 = new JTextField(10);
                t5.setBounds(250, 140, 100, 25);
                t5.setForeground(Color.blue);

                t6 = new JTextField(20);
                t6.setBounds(250, 170, 100, 25);
                t6.setForeground(Color.blue);

                t7 = new JTextField(20);
                t7.setBounds(250, 210, 100, 25);
                t7.setForeground(Color.blue);
                t7.setEditable(false);

                t8 = new JTextField(20);
                t8.setBounds(250, 240, 100, 25);
                t8.setForeground(Color.blue);
                t8.setEditable(false);

                t9 = new JTextField(20);
                t9.setBounds(250, 270, 100, 25);
                t9.setForeground(Color.blue);
                t9.setEditable(false);

                t10 = new JTextField(20);
                t10.setBounds(250, 310, 100, 25);
                t10.setForeground(Color.blue);
                t10.setEditable(false);

                t11 = new JTextField(20);
                t11.setBounds(250, 340, 100, 25);
                t11.setForeground(Color.blue);
                t11.setEditable(false);

                t12 = new JTextField(20);
                t12.setBounds(250, 370, 100, 25);
                t12.setForeground(Color.blue);
                t12.setEditable(false);

                b1 = new JButton("Decrypt");
                b1.setBounds(300, 450, 80, 25);
                b1.setForeground(Color.blue);
                b1.addActionListener(this);

                con.add(l1);
                con.add(l2);
                con.add(l3);
                con.add(l4);
                con.add(l5);
                con.add(l6);
                con.add(l7);
                con.add(l8);
                con.add(l9);
                con.add(l10);
                con.add(l11);
                con.add(l12);

                con.add(t1);
                con.add(t2);
                con.add(t3);
                con.add(t4);
                con.add(t5);
                con.add(t6);
                con.add(t7);
                con.add(t8);
                con.add(t9);
                con.add(t10);
                con.add(t11);
                con.add(t12);

                con.add(b1);

                setTitle("Record");
                setLocation(475, 174);
                setSize(500, 650);
                setVisible(true);
                try {
                        Connection con1 = databasecon.getconnection();
                        PreparedStatement ps = con1.prepareStatement("select * from record where id='" + meterno + "'");
                        ResultSet rs = ps.executeQuery();
                        while (rs.next()) {
                                t1.setText(rs.getString(1));
                                t2.setText(rs.getString(2));
                                t3.setText(rs.getString(3));
                                t4.setText(rs.getString(4));
                                t5.setText(rs.getString(5));
                                t6.setText(rs.getString(6));
                                t7.setText(rs.getString(7));
                                t8.setText(rs.getString(8));
                                t9.setText(rs.getString(9));
                                t10.setText(rs.getString(10));
                                t11.setText(rs.getString(11));
                                t12.setText(rs.getString(12));
                        }

                } catch (Exception ex) {
                        System.out.println(ex);
                }

        }

        public void actionPerformed(ActionEvent ae) {

                if (ae.getSource() == b1) {
                        String a = t1.getText();
                        String b = t2.getText();
                        String c = t3.getText();
                        String d = t4.getText();
                        String e = t5.getText();
                        String f = t6.getText();
                        String g = t7.getText();
                        String h = t8.getText();
                        String i = t9.getText();
                        String j = t10.getText();
                        String k = t11.getText();
                        String l = t12.getText();
                        mn = mn + 1;
                        try {

                                d = EncryptString.decrypt(t4.getText());
                                e = EncryptString.decrypt(t5.getText());
                                f = EncryptString.decrypt(t6.getText());
                                g = EncryptString.decrypt(t7.getText());
                                h = EncryptString.decrypt(t8.getText());
                                i = EncryptString.decrypt(t9.getText());
                                j = EncryptString.decrypt(t10.getText());
                                k = EncryptString.decrypt(t11.getText());
                                l = EncryptString.decrypt(t12.getText());

                                t1.setText(a);
                                t2.setText(b);
                                t3.setText(c);
                                t4.setText(d);
                                t5.setText(e);
                                t6.setText(f);
                                t7.setText(g);
                                t8.setText(h);
                                t9.setText(i);
                                t10.setText(j);
                                t11.setText(k);
                                t12.setText(l);
                                if (mn == 1) {
                                        b2.setText("ReDecrypt");
                                }
                                if (mn == 2) {
                                        b1.setVisible(false);
                                }

                        } catch (Exception e1) {

                                System.out.println(e1);

                        }
                }
        }

}
