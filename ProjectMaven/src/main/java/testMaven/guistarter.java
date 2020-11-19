package testMaven;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class guistarter {
	
	DBqueryInterface db = new MySqlCopy();
	
	static JTextArea jta = new JTextArea(5, 20);

	public static void main(String[] args) {
		guistarter s = new guistarter();
		guistarter gui = new guistarter();
		JFrame frame = new JFrame();
		frame.setSize(1075, 800);
		frame.setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		panel2.add(jta);
		panel.setLayout(new BorderLayout());
		JLabel textlabel = new JLabel("databaseGegevens");
		panel.add(textlabel);


		JList jlist = new JList(gui.db.GetArtist().toArray());
		panel.add(jlist);
		jlist.setBounds(10, 120, 500, 500);
		frame.add(panel);

//		JList jlist2 = new JList(gui.db.GetAlbum().toArray());
//		panel3.add(jlist);
//		jlist2.setBounds(10, 120, 500, 500);
//		frame.add(panel3);
		
		JScrollPane scrl1 = new JScrollPane(jlist);
		scrl1.setSize(250, 250);
		panel.add(scrl1, BorderLayout.WEST);
//		JScrollPane scrl2 = new JScrollPane(jlist2);
//		scrl2.setSize(250, 250);
//		panel.add(scrl2, BorderLayout.CENTER);
		JTabbedPane tp = new JTabbedPane();
		tp.add("artist", panel);
		tp.add("add artists", panel2);
		frame.add(tp);
		frame.setVisible(true);
		
	}
}
