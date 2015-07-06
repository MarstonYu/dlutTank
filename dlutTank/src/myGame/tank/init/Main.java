package myGame.tank.init;

import java.awt.EventQueue;

import javax.swing.JFrame;

import myGame.tank.ui.MapPanel;
import myGame.tank.ui.TankFrame;

public class Main {

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame game = new TankFrame();
				game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				game.setTitle("是男人就打一百层");
				game.setVisible(true);
			}
		});
		
	}

	}

