package myGame.tank.object;


import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JLabel;

import myGame.tank.image.GameImage;

/**
 * 坦克类
 * 定义坦克属性
 * @author 小明君
 */
public class TankLabel extends JLabel{
	
	private static final long serialVersionUID = -5514909418420057640L;

	protected int id;	//id
	
	public final static int MIN_ID=1000;
	
	protected TankDir dir;		//坦克反向：上下左右：1234
	
	protected int x;			//横坐标
	
	protected int y;			//纵坐标
	
	protected Dimension dim;	//坦克大小
	
	protected int hp;		//血
	
	protected TankType type;	//坦克类型
	
	protected Rectangle rectangle;
	
	protected  int speed = 1000;	//坦克速度，越小越快,不能为负
	
	protected GameImage imgs;		//图片库
	
	private static int RUNINGNUMS = 0;	//游戏运行中的坦克数量
	
	
	public TankLabel(int x,int y,int speed,int hp,TankDir dir,TankType type,GameImage imgs)
	{

			this.x = x;
			this.y = y;
			this.dir = dir;
			this.type = type;
			this.hp = hp;
			this.imgs = imgs;
			this.speed = speed;
			this.dim = new Dimension(imgs.getUserTankIcon(dir).getIconWidth(),imgs.getUserTankIcon(dir).getIconHeight());
			this.id = MIN_ID+this.getRUNINGNUMS();
			this.setRUNINGNUMS(this.getRUNINGNUMS() + 1); 
			
			setSize(this.getDim());
			if(type.equals(TankType.HOSTER_TANK) )
				setIcon(imgs.getUserTankIcon(dir));
			else if(type.equals(TankType.GUEET_TANK))
				setIcon(imgs.getGueetTankIcon(dir));
			else if(type.equals(TankType.AI_TANK))
				setIcon(imgs.getAiTankIcon(dir));
			
			setLocation(x, y);
	}
	
	public TankDir getDir()
	{
		return dir;
	}
	public void setDir(TankDir dir)
	{
		this.dir = dir;
	}
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x = x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y = y;
	}
	public int getHP()
	{
		return hp;
	}
	public void setHP(int hp)
	{
		this.hp = hp;
	}
	public void delHP()
	{
		this.hp--;
	}
	public TankType getTankType()
	{
		return type;
	}
	
	public int getSpeed()
	{
		return speed;
	}
	
	public int getId()
	{
		return  id;
	}
	public GameImage getimgs()
	{
		return  imgs;
	}

	public Dimension getDim() {
		return dim;
	}

	public static int getRUNINGNUMS() {
		return RUNINGNUMS;
	}

	public static void setRUNINGNUMS(int rUNINGNUMS) {
		RUNINGNUMS = rUNINGNUMS;
	}

	
}
