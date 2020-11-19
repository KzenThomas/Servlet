package testMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.sqlite.SQLiteConfig.Pragma;

public class MySqlCopy implements DBqueryInterface {
	Connection dbconnection;
	public MySqlCopy() {
		try {
			dbconnection = DriverManager.getConnection("jdbc:mysql://localhost:8111/Transferdatabase", "root", null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> GetArtist() {
		try {
			PreparedStatement prepareStatement = dbconnection.prepareStatement("Select * from Artist");
			prepareStatement.execute();
			ResultSet resultSet = prepareStatement.getResultSet();
			List<String> artists = new ArrayList<String>();

			while (resultSet.next()) {
				String text = resultSet.getString(resultSet.findColumn("title"));
				artists.add(text);
			}

			return artists;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<String>();
	}

	@Override
	public void writeArtists(List<String> artists) {
		PreparedStatement preparestatement;
		try {
			for (String artist : artists) {
				preparestatement = dbconnection.prepareStatement("insert into artist(title) values(?)");
				preparestatement.setString(1, artist);
				preparestatement.execute();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void writeAlbum(List<Album> albums) {
		// TODO Auto-generated method stub
		PreparedStatement preparestatement;
		try {
			for (Album album : albums) {
				preparestatement = dbconnection.prepareStatement("insert into albums(albumtitle, artist) values(?,?)");
				preparestatement.setString(1, album.name);
				preparestatement.setInt(2, album.artistid);
				preparestatement.execute();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Album> GetAlbum() {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public List<Track> GetTrack() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeTrack(List<Track> Track) {
		// TODO Auto-generated method stub
		PreparedStatement preparestatement;
		try {
			for (Track track : Track) {
				preparestatement = dbconnection.prepareStatement("insert into track(name, album) values(?,?)");
				preparestatement.setString(1, track.title);
				preparestatement.setInt(2, track.albumid);
				preparestatement.execute();				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
