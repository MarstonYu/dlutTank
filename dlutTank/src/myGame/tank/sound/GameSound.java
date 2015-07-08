package myGame.tank.sound;



import java.io.FileInputStream;
import java.io.IOException;

/**
 * ����������
 * 
 * @author С����
 */

import sun.audio.*;

public class GameSound {

	 private AudioStream bg;
	 private ContinuousAudioDataStream biu;
	 private ContinuousAudioDataStream duang;

	public GameSound()
	{
		try {
			bg = new AudioStream(new FileInputStream("../dlutTank/src/myGame/tank/sound/bg.wav"));
			biu = new ContinuousAudioDataStream(new AudioStream(new FileInputStream("../dlutTank/src/myGame/tank/sound/biu.wav")).getData());
			duang = new ContinuousAudioDataStream(new AudioStream(new FileInputStream("../dlutTank/src/myGame/tank/sound/duang.wav")).getData());
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	public void playBgm()
	{
		AudioPlayer.player.start(bg);
	}
	public void playDuang()
	{
		AudioPlayer.player.start(duang);
	}
	public void playBiu()
	{
		AudioPlayer.player.start(biu);
	}
	public void stopBgm()
	{
		AudioPlayer.player.stop(bg);
	}
	public void stopBiu()
	{
		AudioPlayer.player.stop(biu);
	}
	public void stopDuang()
	{
		AudioPlayer.player.stop(duang);
	}
}