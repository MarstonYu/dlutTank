/**
* @Title: Scene.java
* @Package myGame.tank.object
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author С����
* @date 2015��7��6��
* @version V1.0
*/
package myGame.tank.object;

import java.util.List;

/**
 * @ClassName: Scene
 * @Description: TODO(ÿһ�صĳ���)
 * @author С����
 * @date 2015��7��6��
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
	

	/* (�� Javadoc)
	* <p>Title: run</p>
	* <p>Description: </p>
	* @see java.lang.Runnable#run()
	*/
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		
	}
	
	
	
}
