package myGame.tank.ui;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import myGame.tank.image.GameImage;

/**
 * 地图画板
 * 拥有地图绘制方法
 * @author 小明君
 */

public class MapPanel extends JPanel{

	private static final long serialVersionUID = -3873526261044826371L;

	private int[][] map;

	private Image bg;
	private Image wall;
	private Image stell;
	private Image edage;
	
	private int WIDTH;				//背景图片大小，墙和它是一样的
	private int HEIGHT;
	


	public MapPanel(int[][] map,GameImage imgs)
	{
		bg = imgs.getBgIcon().getImage();
		wall = imgs.getWallIcon().getImage();
		stell = imgs.getSteelIcon().getImage();
		edage = imgs.getEdgeIcon().getImage();
		WIDTH = bg.getWidth(this);
		HEIGHT = bg.getHeight(this);
		
		this.map =map;
	}
	
	public void paintComponent(Graphics g) {
		for(int i = 0;i<map.length;i++)
		{
			for(int j = 0;j<map[i].length;j++)
			{
				if(map[i][j] == 0)
					g.drawImage(edage, j*HEIGHT,i*WIDTH,WIDTH,HEIGHT,null);
				else if(map[i][j] == 1)
					g.drawImage(bg,j*HEIGHT,i*WIDTH,WIDTH,HEIGHT,null);
				else if(map[i][j] == 2)
					g.drawImage(wall,j*HEIGHT,i*WIDTH,WIDTH,HEIGHT,null);
				else if(map[i][j] == 3)
					g.drawImage(stell,j*HEIGHT,i*WIDTH,WIDTH,HEIGHT,null);
			}
		}
				
	}
	
	public int getWidth()
	{
		return (map[0].length)*(HEIGHT);
	}
	
	public int getHeight()
	{
		return (map.length)*(WIDTH);
	}
	
	public MapPanel()
	{
		System.out.print("bgW"+bg.getWidth(this));
		System.out.print("bgH"+bg.getHeight(this));
		System.out.print("bgW"+wall.getWidth(this));
		System.out.print("bgH"+wall.getHeight(this));
	}
	
	
}
