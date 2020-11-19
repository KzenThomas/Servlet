package testMaven;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GuiCopy {
	
	DBqueryInterface db = new MySqlCopy();

	
	public static void main(String[] args) {
		
		GuiCopy gui = new GuiCopy();
		
		JFrame frame1 = new JFrame("Database Search Result");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setSize(800, 800);
		frame1.setLayout(new BorderLayout());
		JScrollPane scroll = new JScrollPane();
		
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		JPanel panel = new JPanel();
		JList jlist = new JList(gui.db.GetArtist().toArray());
		panel.add(jlist);
		panel.add(scroll);
		frame1.add(panel);
		
		frame1.setVisible(true);
		
		
	}
}
