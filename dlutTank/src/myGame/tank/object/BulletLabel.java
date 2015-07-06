package myGame.tank.object;

import java.awt.Dimension;
import javax.swing.JLabel;

/**
 * 子弹类
 * 定义子弹属性
 * @author 小明君
 */

public class BulletLabel extends JLabel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7619663012185103149L;

	private int x;
	
	private int y;
	
	private int id;
	
	private TankDir dir;
	
	protected Dimension dim;
	
	protected TankType type;
	
	private int speed = 3;
	
	private boolean flying = true;

	public BulletLabel(TankLabel tank,int id)
	{
		this.dir =tank.getDir();
		switch(dir)
		{
		case UP: this.x = tank.getX()+8;this.y = tank.getY()-16;break;
		case DOWN:this.x = tank.getX()+8;this.y = tank.getY()+tank.getDim().height;break;
		case LEFT:this.x = tank.getX()-16;this.y = tank.getY()+8;break;
		case RIGHT:this.x = tank.getX()+tank.getDim().width;this.y = tank.getY()+8;break;
		
		}
		this.type = tank.getTankType();	
		this.dim = new Dimension(tank.getimgs().getBullet(dir).getIconWidth(),tank.getimgs().getBullet(dir).getIconHeight());
		
		setSize(this.getDim());
		setIcon(tank.getimgs().getBullet(dir));
		setLocation(x, y);
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
	public TankDir getDir()
	{
		return dir;
	}
	public void setDir(TankDir dir)
	{
		this.dir = dir;
	}
	public Dimension getDim() {
		return dim;
	}
	public int getSpeed()
	{
		return speed;
	}
	public int getId()
	{
		return id;
	}
	public boolean isFlying()
	{
		return flying;
	}
	public void setNotFlying()
	{
		flying = false;
	}
	public TankType getTankType()
	{
		return type;
	}
}
