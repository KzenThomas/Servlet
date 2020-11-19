package mp3player;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Player {
	
	MediaPlayer mediaPlayer;
	
	public Player() {
		com.sun.javafx.application.PlatformImpl.startup(()->{});
	}
	
	public void play(String file) {
		
		Media hit = new Media(file);
		mediaPlayer = new MediaPlayer(hit);
		mediaPlayer.play();
	}

}
