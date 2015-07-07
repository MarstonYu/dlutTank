package myGame.tank.ui;

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
	
	public Maps()
	{
		
	}
	
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
		
		Random rdm=new Random();
		
		for(int i=0;i<map.length;i++)
			for(int j=0;j<map[i].length;j++)
			{
				map[i][j]=Math.abs(rdm.nextInt())%3+1;
			}
			
		for(int i=0;i<map.length;i++)
		{
			map[i][0]=0;
			map[i][map.length-1]=0;
		}
		for(int j=0;j<map[0].length;j++)
		{
			map[0][j]=0;
			map[map[0].length-1][j]=0;
	}
		
		
		for(int j=1;j<map.length-2;j=j+2)
		  {
			int i=1;
			setMap(i, j, Math.abs(rdm.nextInt())%3+1);
			setMap(i, j+1, getMap(i, j));
		  }
		for(int i=2;i<map.length-2;i=i+2)
			for(int j=1;j<map[i].length-2;j=j+2)
			{
				if((getMap(i-1, j-1)==0)||(getMap(i-1, j-1)==3)
					&&(getMap(i-1, j)==0)||(getMap(i-1, j)==3)
						&&(getMap(i-1, j+1)==1)||(getMap(i-1, j+1)==2))
					setMap(i, j, 3);
				else
					setMap(i, j,Math.abs(rdm.nextInt())%2+1);
				setMap(i, j+1, getMap(i, j));
			}
		
/*/
 * 
 */
//		int	m;
//		int n;
//		int time = 1;
//		   for(int p=0;p<tankNums;p++)
//		   {
//		      do{	
//		    	  m = Math.abs(rdm.nextInt())%(map.length - 5)+3;
//		    	  n = Math.abs(rdm.nextInt())%(map[0].length-5)+3;
//		      	
//		  	for(int q=0;q<p;q++)
//		  	{
//		  		time = 0;
//		  		if((map[m][n] == 1 || map[m][n] == 2)&&(m>tankPoints[q].x+1)||(n>tankPoints[q].y+1))    //保证不会与其他坦克重叠
//		  			time++;	
//		  	
//		      }
//		      }
//		      while(time == p+1);
//		      tankPoints[p].x = m;
//		      tankPoints[p].y = n;
//		      setMap(m,n,1);
//		      setMap(m+1,n,1);
//		      setMap(m,n+1,1);
//		      setMap(m+1,n+1,1);
//		      }
//		   
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
	
	private void setMap(int x,int y,int p)
	{
		map[x][y]=p;
	}
	
	private int getMap(int x,int y)
	{
		return map[x][y];
	}


}
