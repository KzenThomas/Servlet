package testMaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

public class SqliteCopy implements DBqueryInterface {
	Connection dbconnection;
	static JTextArea jta = new JTextArea();

	
	public SqliteCopy() {
		try {
			dbconnection = DriverManager.getConnection("jdbc:sqlite:C:\\\\Users\\\\tbaselmans\\\\AppData\\\\Roaming\\\\DBeaverData\\\\workspace6\\\\.metadata\\\\sample-database-sqlite-1\\\\Chinook.db");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
	
	@Override
	public List<String> GetArtist() {
		PreparedStatement preparestatement;
		try {
			preparestatement = dbconnection.prepareStatement("select * from Artist");
			preparestatement.execute();
			ResultSet resultSet = preparestatement.getResultSet();
			List<String> artistList = new ArrayList();
			while(resultSet.next()) {
				String text = resultSet.getString(resultSet.findColumn("Name"));
				artistList.add(text);
			}
			jta.setText(artistList.toString());
			return artistList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void writeArtists(List<String> artists) {
		
	}


	@Override
	public void writeAlbum(List<Album> albums) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Album> GetAlbum() {
		// TODO Auto-generated method stub
		
		PreparedStatement preparestatement;
		try {
			preparestatement = dbconnection.prepareStatement("select * from Album");
			preparestatement.execute();
			ResultSet resultSet = preparestatement.getResultSet();
			List<Album> albumList = new ArrayList();
			while(resultSet.next()) {
				String text = resultSet.getString(resultSet.findColumn("Title"));
				int artistid = resultSet.getInt(resultSet.findColumn("ArtistId"));
				albumList.add(new Album(text, artistid));
			}
			jta.setText(albumList.toString());
			return albumList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	
	}
	@Override
	public List<Track> GetTrack() {
		// TODO Auto-generated method stub
		
		PreparedStatement preparestatement;
		try {
			preparestatement = dbconnection.prepareStatement("select * from Track");
			preparestatement.execute();
			ResultSet resultSet = preparestatement.getResultSet();
			List<Track> TrackList = new ArrayList<Track>();
			while(resultSet.next()) {
				String name = resultSet.getString(resultSet.findColumn("name"));
				int albumid = resultSet.getInt(resultSet.findColumn("AlbumId"));
				TrackList.add(new Track(name, albumid));
			}
			jta.setText(TrackList.toString());
			return TrackList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	
	}
	@Override
	public void writeTrack(List<Track> Track) { 
		// TODO Auto-generated method stub
		
	}

}
