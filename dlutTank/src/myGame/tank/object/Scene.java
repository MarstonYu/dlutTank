/**
* @Title: Scene.java
* @Package myGame.tank.object
* @Description: TODO(用一句话描述该文件做什么)
* @author 小明君
* @date 2015年7月6日
* @version V1.0
*/
package myGame.tank.object;

import java.util.List;

/**
 * @ClassName: Scene
 * @Description: TODO(每一关的场景)
 * @author 小明君
 * @date 2015年7月6日
 *
 */
public class Scene implements Runnable{

	private int runningNums;
	
	private int tankNums;

	private int[][] currentmap;
	
	private List<TankLabel> tans;
	
	public Scene(int tankNums,int[][] map,List<TankLabel> tans)
	{
		
	}
	

	/* (非 Javadoc)
	* <p>Title: run</p>
	* <p>Description: </p>
	* @see java.lang.Runnable#run()
	*/
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		
	}
	
	
	
}
