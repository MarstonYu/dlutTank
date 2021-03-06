package myGame.tank.ui;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.*;

import myGame.tank.image.GameImage;
import myGame.tank.object.BulletLabel;
import myGame.tank.object.Maps;
import myGame.tank.object.TankDir;
import myGame.tank.object.TankLabel;
import myGame.tank.object.TankType;
import myGame.tank.sound.GameSound;

/**
 * Frame绘制管理
 * 内部有Ai，子弹的线程
 * @author 小明君
 */

public class TankFrame extends JFrame {
	
	/**
	 * 坐标横是x，竖是y
	 */
	private static final long serialVersionUID = -6247145989699531711L;
	
	MapPanel mapPanel;				//背景地图
	GameImage imgs;					//游戏图片集
	private int[][] map;			//用到的地图
	private  int[][] currentMap;	//当前地图可行域
	List<TankLabel> tanksLabel;				//坦克的列表（数组）
	TankLabel	hosterTank;
	TankLabel	gueetTank;
	private volatile boolean[] keyPress;    //按键的重复按下判断；
	private ExecutorService pool;			//线程池
	private GameSound sounds;				//游戏声音素材
	private Maps gamemap;					//地图对象
	private int runningNums;				//运行中的坦克数

	/**
	* 创建一个新的实例 TankFrame.
	*
	*/
	public TankFrame() {
		
		/*初始化变量*/
		imgs = new GameImage();
		gamemap = new Maps((int)(Math.random()*5)+3,40,40);
		map = gamemap.getGameMap();
		currentMap = new int[map[0].length*imgs.getBgIcon().getIconHeight()][map.length*imgs.getBgIcon().getIconWidth()];
		keyPress = new boolean[10];
		pool = Executors.newCachedThreadPool();
		tanksLabel = Collections.synchronizedList(new ArrayList<TankLabel>(7));
		sounds = new GameSound();
		mapPanel = new  MapPanel(map,imgs);
		
		setLocation(250, 50);
		setLayout(null);
		/*按键判断标准初始化*/
		for(int i=0;i<keyPress.length;i++)
				keyPress[i]=false;
			
		tanksLabel.add(new TankLabel(0,0, 0, 1,1,TankDir.DOWN, TankType.HOSTER_TANK, imgs));//添加主坦克
		hosterTank = tanksLabel.get(0);
		tanksLabel.add(new TankLabel(1,0, 0, 1,1,TankDir.DOWN, TankType.GUEST_TANK, imgs));	//添加副坦克
		gueetTank = tanksLabel.get(1);
		for(int i = 2;i<7;i++)
			tanksLabel.add(new TankLabel(i,0, 0,3,1,TankDir.DOWN, TankType.AI_TANK, imgs));
		
		this.addKeyListener(new KeyAction(hosterTank,gueetTank));
		setSize(mapPanel.getWidth()+18,mapPanel.getHeight()+40);
		
		gamemap.setUsing(false);
		/*关卡初始化*/
		pool.submit(new Thread()
		{
			public void run ()
			{
				while(true)
				{
					if(gamemap.isUsing())
					{
						System.out.println("playing");
						try {
							sleep(1000);
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
					else if(!gamemap.isUsing())
					{
						System.out.println("not playing");
					sounds.playBgm();
					gamemap = new Maps((int)(Math.random()*5)+3,40,40);
					map = gamemap.getGameMap();
					mapPanel.setMap(map);
					/*可行域初始化*/
					for(int i=0;i<currentMap.length;i++)
						for(int j=0;j<currentMap[i].length;j++)
							if(map[j/16][i/16] == 0)
								currentMap[i][j] = 0;
							else if(map[j/16][i/16] == 1)
								currentMap[i][j] = 1;
							else 	currentMap[i][j] = 2;
					for(int i=0;i<gamemap.getTankNums();i++)
						{
							tanksLabel.get(i).setHP(1);
							tanksLabel.get(i).setSpeed(1+(int)(Math.random()*5D));
							tanksLabel.get(i).setTankLocation(gamemap.getTankPoints()[i]);
							tanksLabel.get(i).setTankIcon();
							setTankcurrent(tanksLabel.get(i),false);
							mapPanel.add(tanksLabel.get(i));
							if(i>1)
								pool.submit(new AiThread(tanksLabel.get(i)));
						}
					add(mapPanel);
					runningNums = gamemap.getTankNums();
					repaint();
					gamemap.setUsing(true);
					}
				
				}
			}
		});
		/*关卡结束判定*/
		pool.submit(new Thread()
		{
			public void run ()
			{
				JOptionPane option = new JOptionPane();
				try {
					sleep(3000);
				} catch (InterruptedException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				while(true){			
				while((gueetTank.getHP()>0||hosterTank.getHP()>0)&&runningNums>2)
				{
					if(hosterTank.getHP() <= 0)
					{
					mapPanel.remove(hosterTank);
					setTankcurrent(hosterTank,true);
					repaint();
					}
					else if(gueetTank.getHP() <= 0)
					{
						mapPanel.remove(gueetTank);
						setTankcurrent(gueetTank,true);
						repaint();
					}
					try {
						sleep(100);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
				if(hosterTank.getHP() <= 0&&gueetTank.getHP() <= 0)
				{
					mapPanel.remove(hosterTank);
					mapPanel.remove(gueetTank);
					repaint();
					option.setMessage("LOSER!!!!!");
					option.createDialog("SB").setVisible(true);

				}
				else{
					option.setMessage("YOU WIN!!!!!!!!!!");
					option.createDialog("SB").setVisible(true);
					mapPanel.remove(hosterTank);
					mapPanel.remove(gueetTank);
					repaint();
				}	
				for(int i =0;i<gamemap.getTankNums();i++)
					tanksLabel.get(i).setHP(0);
				sounds.stopBgm();
				gamemap.setUsing(false);
				try {
					sleep(2000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			}

		});
	}
	
	

	/**
	* @ClassName: AiThread
	* @Description: TODO(ai坦克线程)
	* @author 小明君
	* @date 2015年7月7日
	*
	*/
	class AiThread extends Thread
	{
		private TankLabel tank;
		private BulletLabel bull;
		public AiThread(TankLabel tank)
		{
			this.tank = tank;
		}
		public void run()
		{
			while(tank.getHP()>0)
			{
				double x = Math.random()*4;
				if(x<1)						//向上走
				{
					tank.setDir(TankDir.UP);	//反向设置向上
					tank.setIcon(imgs.getAiTankIcon(TankDir.UP));	//修改图片
					for(int i=0;i<30;i++)			//这里的循环次数定义了坦克在这个方向走的次数
					{
						if(Math.random()<0.01)		//是否发射子弹判定
							{
							bull = new BulletLabel(tank, tank.getId());
							mapPanel.add(bull) ;
							pool.submit(new BullentThread(bull));
							}
						tankAction(tank);			//坦克行走
						try {
							sleep(tank.getSpeed());	//利用线程休眠调控坦克速度
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
				}else if(x<2)
				{
					tank.setDir(TankDir.DOWN);
					tank.setIcon(imgs.getAiTankIcon(TankDir.DOWN));
					for(int i=0;i<30;i++)
					{
						if(Math.random()<0.01)
						{
							bull = new BulletLabel(tank, tank.getId());
							mapPanel.add(bull) ;
							pool.submit(new BullentThread(bull));
						}
						tankAction(tank);
						try {
							sleep(tank.getSpeed());
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
				}
				else if(x<3)
				{
					tank.setDir(TankDir.LEFT);
					tank.setIcon(imgs.getAiTankIcon(TankDir.LEFT));
					for(int i=0;i<30;i++)
					{
						if(Math.random()<0.01)
						{
						bull = new BulletLabel(tank, tank.getId());
						mapPanel.add(bull) ;
						pool.submit(new BullentThread(bull));
						}
						tankAction(tank);
						try {
							sleep(tank.getSpeed());
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
				}
				else if(x<4)
				{
					tank.setDir(TankDir.RIGHT);
					tank.setIcon(imgs.getAiTankIcon(TankDir.RIGHT));
					for(int i=0;i<30;i++)
					{
						if(Math.random()<0.01)
						{
						bull = new BulletLabel(tank, tank.getId());
						mapPanel.add(bull) ;
						pool.submit(new BullentThread(bull));
						}
						tankAction(tank);
						try {
							sleep(tank.getSpeed());
						} catch (InterruptedException e) {
							// TODO 自动生成的 catch 块
							e.printStackTrace();
						}
					}
				}
				
					
			}
			mapPanel.remove(tank);
			setTankcurrent(tank,true);
			runningNums--;
			repaint();
			sounds.playDuang();
			try {
				sleep(200);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			sounds.stopDuang();
			
		}
	}

	/**
	* @ClassName: BullentThread
	* @Description: TODO(子弹线程)
	* @author 小明君
	* @date 2015年7月7日
	*
	*/
	class BullentThread extends Thread
	{
		private BulletLabel bullet;
		public BullentThread(BulletLabel bullet)
		{
			this.bullet = bullet;
		}
		public void run()
		{

			while(bullet.isFlying())
			{
			bullentAction(bullet);
			try {
				sleep(bullet.getSpeed());
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			}
			mapPanel.remove(bullet);
			mapPanel.repaint();
		}
	}
	

	/**
	* @ClassName: KeyAction
	* @Description: TODO(按键触发事件)
	* @author 小明君
	* @date 2015年7月7日
	*
	*/
	class KeyAction extends  KeyAdapter
	{
		TankLabel  hoster;
		TankLabel  gueet;
		
		public KeyAction(TankLabel hoster,TankLabel gueet)
		{
			this.hoster = hoster;
			this.gueet = gueet;
		}
		
		public void keyPressed(KeyEvent e)
		{
			if(e.getKeyCode() == KeyEvent.VK_W && hoster.getHP()>0)
			{
				if(!keyPress[0])			
				{
					for(int i =0;i<4;i++)
						keyPress[i] = false;
					keyPress[0] = true;	
					System.out.println("up");
					hoster.setDir(TankDir.UP);
					hoster.setIcon(imgs.getUserTankIcon(TankDir.UP));
					pool.submit(new Thread() {
						public void run() {
							// TODO 自动生成的方法存根
							while(keyPress[0])
							{
								tankAction(hoster);
								try {
									sleep(hoster.getSpeed());
								} catch (InterruptedException e) {
									// TODO 自动生成的 catch 块
									e.printStackTrace();
								}
							}
						}
					});

				}
			}
			else if(e.getKeyCode() == KeyEvent.VK_S&& hoster.getHP()>0)
			{
				if(!keyPress[1])			
				{
					for(int i =0;i<4;i++)
						keyPress[i] = false;
					System.out.println("down");
					hoster.setDir(TankDir.DOWN);
					hoster.setIcon(imgs.getUserTankIcon(TankDir.DOWN));
					keyPress[1] = true;		
					pool.submit(new Thread() {
						
						@Override
						public void run() {
							// TODO 自动生成的方法存根
							while(keyPress[1])
							{
								tankAction(hoster);
								try {
									sleep(hoster.getSpeed());
								} catch (InterruptedException e) {
									// TODO 自动生成的 catch 块
									e.printStackTrace();
								}
							}
						}
					});

				}
			}else if(e.getKeyCode() == KeyEvent.VK_A&& hoster.getHP()>0)
			{
				if(!keyPress[2])			
				{
					for(int i =0;i<4;i++)
						keyPress[i] = false;
					keyPress[2] = true;	
					System.out.println("left");
					hoster.setDir(TankDir.LEFT);
					hoster.setIcon(imgs.getUserTankIcon(TankDir.LEFT));
					pool.submit(new Thread() {
						
						@Override
						public void run() {
							// TODO 自动生成的方法存根
							while(keyPress[2])
							{
								tankAction(hoster);
								try {
									sleep(hoster.getSpeed());
								} catch (InterruptedException e) {
									// TODO 自动生成的 catch 块
									e.printStackTrace();
								}
							}
						}
					});

				}
			}else if(e.getKeyCode() == KeyEvent.VK_D&& hoster.getHP()>0)
			{

				if(!keyPress[3])			
				{
					for(int i =0;i<4;i++)
						keyPress[i] = false;
					keyPress[3] = true;	
					System.out.println("right");
					hoster.setDir(TankDir.RIGHT);
					hoster.setIcon(imgs.getUserTankIcon(TankDir.RIGHT));
					pool.submit(new Thread() {
						
						@Override
						public void run() {
							// TODO 自动生成的方法存根
							while(keyPress[3])
							{
								tankAction(hoster);
								try {
									sleep(hoster.getSpeed());
								} catch (InterruptedException e) {
									// TODO 自动生成的 catch 块
									e.printStackTrace();
								}
							}
						}
					});

				}
			}
			if(e.getKeyCode() == KeyEvent.VK_SPACE&& hoster.getHP()>0)
			{

				if(!keyPress[4])
				{
					keyPress[4] = true;
					System.out.println("biu");
					final BulletLabel bull = new BulletLabel(hoster,hoster.getId());
					mapPanel.add(bull);
					pool.submit(new Thread()
					{
						public void run()
						{
							sounds.stopBiu();
							sounds.playBiu();
							try {
								sleep(100);
							} catch (InterruptedException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
							sounds.stopBiu();
						}
					});
					pool.submit(new Thread()
					{
						public void run()
						{
							while(bull.isFlying())
							{
							bullentAction(bull);
							try {
								sleep(bull.getSpeed());
							} catch (InterruptedException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
							}
							mapPanel.remove(bull);
							mapPanel.repaint();
						}
					});
				}
			}
			if(e.getKeyCode() == KeyEvent.VK_I && gueet.getHP()>0)
			{
				if(!keyPress[5])			
				{
					for(int i =5;i<9;i++)
						keyPress[i] = false;
					keyPress[5] = true;	
					System.out.println("up2");
					gueet.setDir(TankDir.UP);
					gueet.setIcon(imgs.getGueetTankIcon(TankDir.UP));
					pool.submit(new Thread() {
						public void run() {
							// TODO 自动生成的方法存根
							while(keyPress[5])
							{
								tankAction(gueet);
								try {
									sleep(gueet.getSpeed());
								} catch (InterruptedException e) {
									// TODO 自动生成的 catch 块
									e.printStackTrace();
								}
							}
						}
					});

				}
			}
			else if(e.getKeyCode() == KeyEvent.VK_K&& gueet.getHP()>0)
			{
				if(!keyPress[6])			
				{
					for(int i =5;i<9;i++)
						keyPress[i] = false;
					System.out.println("down");
					gueet.setDir(TankDir.DOWN);
					gueet.setIcon(imgs.getGueetTankIcon(TankDir.DOWN));
					keyPress[6] = true;		
					pool.submit(new Thread() {
						
						@Override
						public void run() {
							// TODO 自动生成的方法存根
							while(keyPress[6])
							{
								tankAction(gueet);
								try {
									sleep(gueet.getSpeed());
								} catch (InterruptedException e) {
									// TODO 自动生成的 catch 块
									e.printStackTrace();
								}
							}
						}
					});

				}
			}else if(e.getKeyCode() == KeyEvent.VK_J&& gueet.getHP()>0)
			{
				if(!keyPress[7])			
				{
					for(int i =6;i<9;i++)
						keyPress[i] = false;
					keyPress[7] = true;	
					System.out.println("left");
					gueet.setDir(TankDir.LEFT);
					gueet.setIcon(imgs.getGueetTankIcon(TankDir.LEFT));
					pool.submit(new Thread() {
						
						@Override
						public void run() {
							// TODO 自动生成的方法存根
							while(keyPress[7])
							{
								tankAction(gueet);
								try {
									sleep(gueet.getSpeed());
								} catch (InterruptedException e) {
									// TODO 自动生成的 catch 块
									e.printStackTrace();
								}
							}
						}
					});

				}
			}else if(e.getKeyCode() == KeyEvent.VK_L&& gueet.getHP()>0)
			{

				if(!keyPress[8])			
				{
					for(int i =5;i<9;i++)
						keyPress[i] = false;
					keyPress[8] = true;	
					System.out.println("right");
					gueet.setDir(TankDir.RIGHT);
					gueet.setIcon(imgs.getGueetTankIcon(TankDir.RIGHT));
					pool.submit(new Thread() {
						
						@Override
						public void run() {
							// TODO 自动生成的方法存根
							while(keyPress[8])
							{
								tankAction(gueet);
								try {
									sleep(gueet.getSpeed());
								} catch (InterruptedException e) {
									// TODO 自动生成的 catch 块
									e.printStackTrace();
								}
							}
						}
					});

				}
			}
			if(e.getKeyCode() == KeyEvent.VK_ENTER&& gueet.getHP()>0)
			{

				if(!keyPress[9])
				{
					keyPress[9] = true;
					System.out.println("biu");
					final BulletLabel bull = new BulletLabel(gueet,gueet.getId());
					mapPanel.add(bull);
					pool.submit(new Thread()
					{
						public void run()
						{
							sounds.playDuang();
							
							try {
								sleep(100);
							} catch (InterruptedException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
							sounds.stopDuang();
						}
					});
					pool.submit(new Thread()
					{
						public void run()
						{
							while(bull.isFlying())
							{
							bullentAction(bull);
							try {
								sleep(bull.getSpeed());
							} catch (InterruptedException e) {
								// TODO 自动生成的 catch 块
								e.printStackTrace();
							}
							}
							mapPanel.remove(bull);
							mapPanel.repaint();
						}
					});
				}
			}
			
		}

		public void keyReleased(KeyEvent e) 
		{
			if(e.getKeyCode() == KeyEvent.VK_W)
			{
				keyPress[0] = false;
			}
			if(e.getKeyCode() == KeyEvent.VK_S)
			{
				keyPress[1] = false;
			}
			if(e.getKeyCode() == KeyEvent.VK_A)
			{
				keyPress[2] = false;
			}
			if(e.getKeyCode() == KeyEvent.VK_D)
			{
				keyPress[3] = false;
			}
			if(e.getKeyCode() == KeyEvent.VK_SPACE)
			{
				keyPress[4] = false;
			}
			if(e.getKeyCode() == KeyEvent.VK_I)
			{
				keyPress[5] = false;
			}
			if(e.getKeyCode() == KeyEvent.VK_K)
			{
				keyPress[6] = false;
			}
			if(e.getKeyCode() == KeyEvent.VK_J)
			{
				keyPress[7] = false;
			}
			if(e.getKeyCode() == KeyEvent.VK_L)
			{
				keyPress[8] = false;
			}
			if(e.getKeyCode() == KeyEvent.VK_ENTER)
			{
				keyPress[9] = false;
			}
		}

	}
	
	/*
	 * 坦克行动处理，包括移动，以及可行域的设置
	 * 
	 */
	/**
	* @Title: tankAction
	* @Description: TODO(坦克行为)
	* @param @param tankPanel    参数
	* @return void    返回类型
	* @throws
	*/
	private synchronized void tankAction(TankLabel tankPanel)
	{
			int x,y;
			x=tankPanel.getX();
			y=tankPanel.getY();
			switch(tankPanel.getDir())
			{
			case UP:
			if(currentMap[x+4][y-1] == 1 && currentMap[x+16][y-1]==1 && currentMap[x+28][y-1]==1)
			{
				tankPanel.setY(--y);
				tankPanel.setLocation(x, y);
				for(int i=x;i<x+tankPanel.getDim().width;i++)
				{
					currentMap[i][y]=tankPanel.getId();
					currentMap[i][y+tankPanel.getDim().height-1]=tankPanel.getId();
					currentMap[i][y+tankPanel.getDim().height]=1;
				}
			}
			break;
			case DOWN:
				if(currentMap[x+4][y+tankPanel.getDim().height+1] == 1&&currentMap[x+16][y+tankPanel.getDim().height+1] == 1&&currentMap[x+28][y+tankPanel.getDim().height+1] == 1)
				{
					tankPanel.setY(++y);
					tankPanel.setLocation(x, y);
					for(int i=x;i<x+tankPanel.getDim().width;i++)
					{
						currentMap[i][y]=tankPanel.getId();
						currentMap[i][y+tankPanel.getDim().height-1]=tankPanel.getId();
						currentMap[i][y-1]=1;
					}
				}
				break;
			case LEFT:
				if(currentMap[x-1][y+4] == 1&&currentMap[x-1][y+28] == 1&&currentMap[x-1][y+16] == 1)
				{
					tankPanel.setX(--x);
					tankPanel.setLocation(x, y);
					for(int j=y;j<y+tankPanel.getDim().height;j++)
					{
						currentMap[x][j]=tankPanel.getId();
						currentMap[x+tankPanel.getDim().width-1][j]=tankPanel.getId();
						currentMap[x+tankPanel.getDim().width][j]=1;
					}
				}
				break;
			case RIGHT:
				if(currentMap[x+tankPanel.getDim().width+1][y+4] == 1&&currentMap[x+tankPanel.getDim().width+1][y+16] == 1&&currentMap[x+tankPanel.getDim().width+1][y+28] == 1)
				{
					tankPanel.setX(++x);
					tankPanel.setLocation(x, y);
					for(int j=y;j<y+tankPanel.getDim().height;j++)
					{
						currentMap[x][j]=tankPanel.getId();
						currentMap[x+tankPanel.getDim().width-1][j]=tankPanel.getId();
						currentMap[x-1][j]=1;
					}
				}
				break;
			}
	}
	

	/**
	* @Title: bullentAction
	* @Description: TODO(子弹行为)
	* @param @param bulllaLabel    参数
	* @return void    返回类型
	* @throws
	*/
	private synchronized void bullentAction(BulletLabel bulllaLabel)
	{
		int x = bulllaLabel.getX();
		int y = bulllaLabel.getY();
		switch (bulllaLabel.getDir())
		{
			case UP:
				if(currentMap[x+2][y-1] == 1 && currentMap[x+8][y-1]==1 && currentMap[x+14][y-1]==1)
				{
					bulllaLabel.setY(--y);
					bulllaLabel.setLocation(x, y);
				}else 
				{
					if((currentMap[x+8][y-1]>=TankLabel.MIN_ID))
					{
						if(tanksLabel.get(currentMap[x+8][y-1]-TankLabel.MIN_ID).getTankType() != bulllaLabel.getTankType())
						{
							tanksLabel.get(currentMap[x+8][y-1]-TankLabel.MIN_ID).delHP();
							System.out.println("00"+currentMap[x+8][y-1]);
						}
					}

					bulllaLabel.setNotFlying();
				}
				break;
			case DOWN:
				if(currentMap[x+2][y+bulllaLabel.getDim().height+1] == 1&&currentMap[x+8][y+bulllaLabel.getDim().height+1] == 1&&currentMap[x+14][y+bulllaLabel.getDim().height+1] == 1)
				{
					bulllaLabel.setY(++y);
					bulllaLabel.setLocation(x, y);
				}else 
				{
					if(currentMap[x+8][y+bulllaLabel.getDim().height+1]>=TankLabel.MIN_ID)
					{
						if(tanksLabel.get(currentMap[x+8][y+bulllaLabel.getDim().height+1]-TankLabel.MIN_ID).getTankType() != bulllaLabel.getTankType())
							tanksLabel.get(currentMap[x+8][y+bulllaLabel.getDim().height+1]-TankLabel.MIN_ID).delHP();
					}

					bulllaLabel.setNotFlying();
				}
				break;
			case LEFT:
				if(currentMap[x-1][y+2] == 1&&currentMap[x-1][y+14] == 1&&currentMap[x-1][y+8] == 1)
				{
					bulllaLabel.setX(--x);
					bulllaLabel.setLocation(x, y);
				}else 
				{
					if(currentMap[x-1][y+8]>=TankLabel.MIN_ID)
					{
						if(tanksLabel.get(currentMap[x-1][y+8]-TankLabel.MIN_ID).getTankType() != bulllaLabel.getTankType())
							tanksLabel.get(currentMap[x-1][y+8]-TankLabel.MIN_ID).delHP();
					}

					bulllaLabel.setNotFlying();
				}
				break;
			case RIGHT:
				if(currentMap[x+bulllaLabel.getDim().width+1][y+2] == 1&&currentMap[x+bulllaLabel.getDim().width+1][y+14] == 1&&currentMap[x+bulllaLabel.getDim().width+1][y+8] == 1)
				{
					bulllaLabel.setX(++x);
					bulllaLabel.setLocation(x, y);
				}else 
				{
					if(currentMap[x+bulllaLabel.getDim().width+1][y+8]>=TankLabel.MIN_ID)
					{
						if(tanksLabel.get(currentMap[x+bulllaLabel.getDim().width+1][y+8]-TankLabel.MIN_ID).getTankType() != bulllaLabel.getTankType())
						{
							tanksLabel.get(currentMap[x+bulllaLabel.getDim().width+1][y+8]-TankLabel.MIN_ID).delHP();
						}
					}

					bulllaLabel.setNotFlying();
				}
				break;
				
		
		}
		
		
		
	}
	
	/**
	* @Title: setTankcurrent
	* @Description: TODO(设置坦克作用域,isRemove true 代表坦克移除设置，false代表坦克加入设置 )
	* @param @param tank   isRemove 参数
	* @return void    返回类型
	* @throws
	*/
	private synchronized void setTankcurrent(TankLabel tank,boolean isRemove)
	{
		if(!isRemove)
		{
			for(int i=0;i<tank.getDim().width;i++)
				for(int j=0;j<tank.getDim().height;j++)
					currentMap[tank.getX()+i][tank.getY()+j] = tank.getId();
		}
		else
		{
			for(int i=0;i<tank.getDim().width;i++)
				for(int j=0;j<tank.getDim().height;j++)
					currentMap[tank.getX()+i][tank.getY()+j] = 1;
		}
		
	}




}
