package testMaven
;

import java.util.List;

public interface DBqueryInterface {
	
	List<String> GetArtist();
	List<Album> GetAlbum();
	List<Track> GetTrack();

	void writeArtists(List<String> artists);
	
	void writeAlbum(List<Album> albums);
	
	void writeTrack(List<Track> Track);

	

}
