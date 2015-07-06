/**
* @Title: MapImformation.java
* @Package myGame.tank.object
* @Description: TODO(地图地图生成器需要实现的接口)
* @author 小明君
* @date 2015年7月6日
* @version V1.0
*/
package myGame.tank.object;

import java.awt.Point;
import java.util.List;

/**
 * @ClassName: MapImformation
 * @Description: TODO(地图信息)
 * @author 小明君
 * @date 2015年7月6日
 *
 */
public interface IGetMapImformation {
	
	/**
	* @Title: getMap
	* @Description: TODO(获取地图)
	* @param     参数
	* @return int[][]    返回类型
	* @throws
	*/
	abstract public int[][] getMap();
	
	/**
	* @Title: getLocations
	* @Description: TODO(获取坦克初始坐标)
	* @param     参数
	* @return List<Point>    返回类型
	* @throws
	*/
	abstract public List<Point> getLocations();
	

}
