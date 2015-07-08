package myGame.tank.object;

import java.awt.Point;
import java.util.Random;

/**
 * 地图储存区类
 * @author 小明君
 */

/**
* @ClassName: Maps
* @Description: TODO(这里用一句话描述这个类的作用)
* @author 小明君
* @date 2015年7月6日
*
*/
public class Maps {
	
	public final static int Map1[][] = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,3,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			};
	
	public final static int Map2[][] ={
		{0,0,0,0,0,0,0,0,0},
		{0,0,1,1,1,1,1,1,0},
		{0,1,1,0,1,1,1,1,0},
		{0,1,1,1,1,1,1,1,0},
		{0,1,1,1,1,1,1,1,0},
		{0,0,0,0,0,0,0,0,0}
	};
	
	private int[][] map;
	private Point[] tankPoints;
	private int tankNums;
	private boolean isUsing = false;
	
	public Maps(int tanknums,int mapWidth,int mapLength)
	{
		
		setTankNums(tanknums);
		setMap(new int[mapWidth][mapLength]);
		setTankPoints(new Point[tanknums]);
		
		createMap();
		  System.out.print("ssssss");

	}

	/**
	* @Title: createMap
	* @Description: TODO(创建出随机地图)
	* @param     参数
	* @return void    返回类型
	* @throws
	*/
	private void createMap()
	{
		
		int[] reation = new int[tankNums];
		int num = tankNums;
		Point[] currentPoint = new Point[tankNums];
		for(int i = 0;i<currentPoint.length;i++ )
			currentPoint[i] = new Point();
		Point p;
		int halfMap[][] = new int[map.length/2][map[0].length/2];
		
		for(int i=0;i<halfMap.length;i++)
			for(int j=0;j<halfMap[i].length;j++)
			{
				halfMap[i][j]=(int)(Math.random()*3+1);
			}
			
		for(int i=0;i<halfMap.length;i++)
		{
			halfMap[i][0]=0;
			halfMap[i][halfMap.length-1]=0;
		}
		for(int j=0;j<halfMap[0].length;j++)
		{
			halfMap[0][j]=0;
			halfMap[halfMap[0].length-1][j]=0;
		}
		
		for(int i =0;i<reation.length;i++)		//连通关系
			{
				reation[i] = i+10;
				currentPoint[i].x = (int)(Math.random()*((halfMap[0].length/currentPoint.length-2)))+halfMap[0].length/currentPoint.length+1;
				currentPoint[i].y =  (int)(Math.random()*(halfMap.length-2))+1;
				 tankPoints[i].x = currentPoint[i].x;
				 tankPoints[i].y = currentPoint[i].y;
				halfMap[currentPoint[i].x][currentPoint[i].y] = 1;
				System.out.println(currentPoint[i].x+" "+currentPoint[i].y);
			}
		
		/*
		 * 一直拓展到连通子图个数为1
		 */
		while(num>1)
		{
			for(int i=0;i<reation.length;i++)
				if(reation[i]!=0)
				{
					p = getRandomDir(halfMap,reation[i],currentPoint[i].x,currentPoint[i].y);

					if(halfMap[p.x][p.y] == reation[i])
					{
						currentPoint[i].x = p.x;
						currentPoint[i].y = p.y;
						halfMap[p.x][p.y] = reation[i]; 
					}
					else if(halfMap[p.x][p.y] > reation[i])
					{
						reation[i] = 0;
						num--;
					}
					else if(halfMap[p.x][p.y] < reation[i] && halfMap[p.x][p.y] >=10)
					{
						if( reation[ halfMap[p.x][p.y] -10]!=0)
						{
							reation[ halfMap[p.x][p.y] -10] = 0;					
							num--;
						}
						currentPoint[i].x = p.x;
						currentPoint[i].y = p.y;
					}
					else
					{
						halfMap[p.x][p.y] = reation[i];
						currentPoint[i].x = p.x;
						currentPoint[i].y = p.y;
					}
				}
		}
		
		for(int i=0; i<map.length;i++)
			for(int j=0;j<map[i].length;j++)
				{
					if(halfMap[i/2][j/2] >6) map[i][j] = 1;
					else	map[i][j] =halfMap[i/2][j/2];
				}
		/*
		 * fram里坐标是反的
		 */
		for(int i=0;i<currentPoint.length;i++)
			tankPoints[i].setLocation(tankPoints[i].y*32, tankPoints[i].x*32);
		
	   
}
	
	
	/**
	* @Title: getRandomDir
	* @Description: TODO(获取生成子图的扩展步骤)
	* @param @param halfMap
	* @param @param id
	* @param @param x
	* @param @param y
	* @param @return    参数
	* @return Point    返回类型
	* @throws
	*/
	private Point getRandomDir(int[][]halfMap, int id,int x,int y)
	{
		int i,j;
		int c;
		System.out.println("int"+x+" "+y);
//		if(		(halfMap[x+1][y] == 0||halfMap[x+1][y]==id) &&
//				(halfMap[x][y+1] == 0||halfMap[x][y+1]==id) &&
//				(halfMap[x-1][y] == 0||halfMap[x-1][y]==id)	&&
//				(halfMap[x][y-1] == 0||halfMap[x][y-1]==id) )
//		{
//			while(true)
//			{
//				c = (int)(Math.random()*4);
//			if(c == 0 && halfMap[x+1][y+1] !=0)
//				{
//					i=x+1;
//					j=y+1;
//				}
//			else if(c == 1 && halfMap[x+1][y-1] !=0)
//			{
//					i=x+1;
//					j=y-1;
//			}
//			else if(c == 1 && halfMap[x+1][y-1] !=0)
//			{
//				
//			}
//			else if(c == 1 && halfMap[x+1][y-1] !=0)
//			
//			return new Point(i,j);
//			}
//		}
		while(true)
		{
			c = (int)(Math.random()*4);
			System.out.println(c+" "+x+" "+y+" "+":"+halfMap[x+1][y]+":"+halfMap[x][y+1]+":"+halfMap[x-1][y]+":"+halfMap[x][y-1]+":"+halfMap[x][y]);
			if(c == 0)
			{
				if(halfMap[x+1][y]!=0)
				{
					i = x+1;
					j=y;
					break;		
				}
			}
			else if(c == 1)
			{
				if(halfMap[x][y+1]!=0)
				{
					i = x;
					j=y+1;
					break;		
				}
			}else if(c == 2)
			{
				if(halfMap[x-1][y]!=0)
				{
					i = x-1;
					j=y;
					break;		
				}
			}else if(c == 3)
			{
				if(halfMap[x][y-1]!=0)
				{
					i = x;
					j=y-1;
					break;		
				}
			}
			
		}
		return  new Point(i,j);
	}
	
	/**
	* @return map
	*/
	public int[][] getGameMap() {
		return map;
	}

	/**
	* @param map the map to set
	*/
	private void setMap(int[][] map) {
		this.map = map;
	}

	/**
	* @return tankPoints
	*/
	public Point[] getTankPoints() {
		return tankPoints;
	}

	/**
	* @param tankPoints the tankPoints to set
	*/
	public void setTankPoints(Point[] tankPoints) {
		this.tankPoints = tankPoints;
		for(int i=0;i<this.tankPoints.length;i++)
			this.tankPoints[i] = new Point();
	}

	/**
	* @return tankNums
	*/
	public int getTankNums() {
		return tankNums;
	}

	/**
	* @param tankNums the tankNums to set
	*/
	public void setTankNums(int tankNums) {
		this.tankNums = tankNums;
	}

	/**
	* @return isUsing
	*/
	public boolean isUsing() {
		return isUsing;
	}

	/**
	* @param isUsing the isUsing to set
	*/
	public void setUsing(boolean isUsing) {
		this.isUsing = isUsing;
	}
	

	

}
