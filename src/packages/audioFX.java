package packages;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

// Abstact =============================================================
// a Number of methods for player a auidio file
// =====================================================================


public class audioFX {
	
	public static void clickAudio() {
		
		//local
		String path = "src/audio/click1.wav";

		Media media = new Media(new File(path).toURI().toString());
		
		// get MediaPlayer
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		
		// play media file
		mediaPlayer.play();
		
	}



	public static void movePon() {
		
		//local
		String path = "src/audio/move2.wav";

		Media media = new Media(new File(path).toURI().toString());
		
		// get MediaPlayer
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		
		// play media file
		mediaPlayer.play();
		
	}



	public static void startAudio() {
		
		//local
		String path = "src/audio/UIsound.wav";

		Media media = new Media(new File(path).toURI().toString());
		
		// get MediaPlayer
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		
		// play media file
		mediaPlayer.play();
		
	}



	public static void diceAudio() {
		
		//local
		String path = "src/audio/dice1.mp3";

		Media media = new Media(new File(path).toURI().toString());
		
		// get MediaPlayer
		MediaPlayer mediaPlayer = new MediaPlayer(media);
		
		// play media file
		mediaPlayer.play();
		
	}	
	
	
	
	
	
	
}