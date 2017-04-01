/**
 * 
 */
package cc.chaoyangliu.rmiprac.service;

/**
 * @author bird
 *
 */
public class LoadConfigTest {

	/**
	 * 
	 */
	public LoadConfigTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Config cfg = new Config("config.properties");
		System.out.println(cfg.getProperty("url"));
	}

}
