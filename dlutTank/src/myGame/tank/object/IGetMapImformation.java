/**
* @Title: MapImformation.java
* @Package myGame.tank.object
* @Description: TODO(��ͼ��ͼ��������Ҫʵ�ֵĽӿ�)
* @author С����
* @date 2015��7��6��
* @version V1.0
*/
package myGame.tank.object;

import java.awt.Point;
import java.util.List;

/**
 * @ClassName: MapImformation
 * @Description: TODO(��ͼ��Ϣ)
 * @author С����
 * @date 2015��7��6��
 *
 */
public interface IGetMapImformation {
	
	/**
	* @Title: getMap
	* @Description: TODO(��ȡ��ͼ)
	* @param     ����
	* @return int[][]    ��������
	* @throws
	*/
	abstract public int[][] getMap();
	
	/**
	* @Title: getLocations
	* @Description: TODO(��ȡ̹�˳�ʼ����)
	* @param     ����
	* @return List<Point>    ��������
	* @throws
	*/
	abstract public List<Point> getLocations();
	

}
