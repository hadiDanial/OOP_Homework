package mines;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class AudioManager 
{
    private String mineSFXFile = "src\\mines\\Sound Effects\\mineCell.wav";
    private String flagSFXFile = "src\\mines\\Sound Effects\\flagCell.wav";
    private String safeSFXFile = "src\\mines\\Sound Effects\\safeCell.wav";
    private String  winSFXFile = "src\\mines\\Sound Effects\\Win.wav";
    private String loseSFXFile = "src\\mines\\Sound Effects\\Lose.wav";
    
	private MediaPlayer mineSFX;
    private MediaPlayer flagSFX;
    private MediaPlayer safeSFX;
    private MediaPlayer  winSFX;
    private MediaPlayer loseSFX;
        
    public AudioManager()
    {
    	mineSFX = setupMediaPlayer(mineSFXFile);
    	flagSFX = setupMediaPlayer(flagSFXFile);
    	safeSFX = setupMediaPlayer(safeSFXFile);
    	winSFX = setupMediaPlayer(winSFXFile);
    	loseSFX = setupMediaPlayer(loseSFXFile);
    }

	private MediaPlayer setupMediaPlayer(String file) 
	{
		Media media = new Media(new File(file).toURI().toString());
		MediaPlayer player = new MediaPlayer(media);
		player.setVolume(0.2);
		return player;
	}
	
	public void playSFX(AudioType type)
	{
		MediaPlayer player = null;
		switch (type) 
		{
		case Mine:
			player = mineSFX;
			break;
		case Flag:
			player = flagSFX;
			break;
		case Safe:
			player = safeSFX;
			break;
		case Win:
			player = winSFX;
			break;
		case Lose:
			player = loseSFX;
			break;
		default:
			break;
		}
		if(player != null)
		{
			player.seek(Duration.ZERO);
			player.play();
		}
	}
	
	public enum AudioType
	{
		Mine, Flag, Safe, Win, Lose
	}
}
