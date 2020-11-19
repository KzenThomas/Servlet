package mp3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;;

public class mp3player {
	
	public static void main(String[] args) {
		try {
		FileInputStream f = new FileInputStream("a.mp3");
		Player player = new Player(f);
		player.play();
		System.out.println("song is playing");
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(JavaLayerException e) {
			e.printStackTrace();
		}
	}

}
