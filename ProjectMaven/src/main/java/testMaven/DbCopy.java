package testMaven;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class DbCopy {
	
	public static void main(String[] args) {
		
		
		
		DBqueryInterface copyinterfacesqlite = new SqliteCopy();
		
		DBqueryInterface copyinterfacemysql = new MySqlCopy();
		
		
		
		List<String> artists = copyinterfacesqlite.GetArtist();
		copyinterfacemysql.writeArtists(artists);
		List<Album> albums = copyinterfacesqlite.GetAlbum();
		copyinterfacemysql.writeAlbum(albums);
		List<Track> track = copyinterfacesqlite.GetTrack();
		copyinterfacemysql.writeTrack(track);
	}
 
}
