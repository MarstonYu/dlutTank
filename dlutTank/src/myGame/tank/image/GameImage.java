package myGame.tank.image;

import javax.swing.ImageIcon;
import myGame.tank.object.TankDir;

/**
 * 
 * Í¼Æ¬ËØ²ÄÀà
 * 
 * @author Ð¡Ã÷¾ý
 */

public class GameImage{
	
	private ImageIcon aiTank;
	private ImageIcon aiTank_d;
	private ImageIcon aiTank_l;
	private ImageIcon aiTank_r;
	
	private ImageIcon guTank;
	private ImageIcon guTank_d;
	private ImageIcon guTank_l;
	private ImageIcon guTank_r;
	
	private ImageIcon myTank;
	private ImageIcon myTank_d;
	private ImageIcon myTank_l;
	private ImageIcon myTank_r;
	
	private ImageIcon bullet;
	private ImageIcon bullet_d;
	private ImageIcon bullet_l;
	private ImageIcon bullet_r;
	
	private ImageIcon edg;
	private ImageIcon bg;
	private ImageIcon wall;
	private ImageIcon steel;
	
	public GameImage()
	{
		aiTank = new ImageIcon("../dlutTank/src/myGame/tank/image/aiTank.png");
		aiTank_d = new ImageIcon("../dlutTank/src/myGame/tank/image/aiTank_d.png");
		aiTank_l = new ImageIcon("../dlutTank/src/myGame/tank/image/aiTank_l.png");
		aiTank_r = new ImageIcon("../dlutTank/src/myGame/tank/image/aiTank_r.png");
		
		myTank = new ImageIcon("../dlutTank/src/myGame/tank/image/myTank.png");
		myTank_d = new ImageIcon("../dlutTank/src/myGame/tank/image/myTank_d.png");
		myTank_l = new ImageIcon("../dlutTank/src/myGame/tank/image/myTank_l.png");
		myTank_r = new ImageIcon("../dlutTank/src/myGame/tank/image/myTank_r.png");
		
		guTank = new ImageIcon("../dlutTank/src/myGame/tank/image/guTank.png");
		guTank_d = new ImageIcon("../dlutTank/src/myGame/tank/image/guTank_d.png");
		guTank_l = new ImageIcon("../dlutTank/src/myGame/tank/image/guTank_l.png");
		guTank_r = new ImageIcon("../dlutTank/src/myGame/tank/image/guTank_r.png");
		
		bullet = new ImageIcon("../dlutTank/src/myGame/tank/image/bullet.png");
		bullet_d = new ImageIcon("../dlutTank/src/myGame/tank/image/bullet_d.png");
		bullet_l = new ImageIcon("../dlutTank/src/myGame/tank/image/bullet_l.png");
		bullet_r = new ImageIcon("../dlutTank/src/myGame/tank/image/bullet_r.png");
		
		edg = new ImageIcon("../dlutTank/src/myGame/tank/image/edge.png");
		bg = new ImageIcon("../dlutTank/src/myGame/tank/image/bg.png");
		wall = new ImageIcon("../dlutTank/src/myGame/tank/image/wall.png");
		steel = new ImageIcon("../dlutTank/src/myGame/tank/image/steel.png");
	}
	
	public ImageIcon getAiTankIcon(TankDir dir)
	{
		ImageIcon ico = null;
		switch(dir)
		{
			case UP:ico = aiTank;break;
			case DOWN:ico = aiTank_d;break;
			case LEFT:ico = aiTank_l;break;
			case RIGHT:ico = aiTank_r;break;
		}
		return ico;
	}
	
	public ImageIcon getGueetTankIcon(TankDir dir)
	{
		ImageIcon ico = null;
		switch(dir)
		{
			case UP:ico = guTank;break;
			case DOWN:ico = guTank_d;break;
			case LEFT:ico = guTank_l;break;
			case RIGHT:ico = guTank_r;break;
		}
		return ico;
	}
	public ImageIcon getUserTankIcon(TankDir dir)
	{
		ImageIcon ico = null;
		switch(dir)
		{
			case UP:ico = myTank;break;
			case DOWN:ico = myTank_d;break;
			case LEFT:ico = myTank_l;break;
			case RIGHT:ico = myTank_r;break;
		}
		return ico;
	}
	public ImageIcon getBullet(TankDir dir)
	{
		ImageIcon ico = null;
		switch(dir)
		{
			case UP:ico = bullet;break;
			case DOWN:ico = bullet_d;break;
			case LEFT:ico = bullet_l;break;
			case RIGHT:ico = bullet_r;break;
		}
		return ico;
	}
	public ImageIcon getEdgeIcon()
	{
		return edg;
	}
	public ImageIcon getBgIcon()
	{
		return bg;
	}
	public ImageIcon getWallIcon()
	{
		return wall;
	}
	public ImageIcon getSteelIcon()
	{
		return steel;
	}

}
