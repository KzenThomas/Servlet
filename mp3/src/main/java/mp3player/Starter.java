package mp3player;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSlider;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Starter {

	Connection dbconnection;
	Player player = new Player();

	public static void main(String[] args) {

		Starter s = new Starter();
		try {
			s.dbconnection = DriverManager.getConnection("jdbc:mysql://localhost:8111/mp3", "root", null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DefaultListModel<Track> trackmodel = new DefaultListModel<Track>();
		trackmodel.addAll(s.retrievetrack());
		JList<Track> lijst = new JList<Track>(trackmodel);
		
		// TODO Auto-generated constructor stub

		String bip = "src/main/resources/Pete_Luck_-_de_ruimte__in__t_nederlands_gezongen_.mp3";
	    String file = new File(s.retrievetrack().get(0).filelocation).toURI().toString();
		s.player.play(file);

		JFrame frame = new JFrame();
		frame.setSize(800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JPanel panel2 = new JPanel();
		JSlider jslider = new JSlider();
		frame.add(jslider);
		panel2.add(lijst);
		frame.add(panel);
		frame.add(panel2);
		JButton b=new JButton("volgende song");
		panel.add(b);
		frame.add(panel);
		frame.setVisible(true);
	}

	public List<Track> retrievetrack() {
		PreparedStatement preparestatement;
		try {
			preparestatement = dbconnection.prepareStatement("select * from tracks");
			preparestatement.execute();
			ResultSet resultSet = preparestatement.getResultSet();
			List<Track> tracks = new ArrayList<>();
			while (resultSet.next()) {
				Track t = new Track();
				t.name = resultSet.getString(resultSet.findColumn("name"));
				t.artist = resultSet.getString(resultSet.findColumn("artist"));
				t.filelocation = resultSet.getString(resultSet.findColumn("filelocation"));
				tracks.add(t);
				
			}
			return tracks;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}