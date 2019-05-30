import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class World {
	
	private static final int INIT_MAX_CARRY = 2;

	private Map map;
	
	private Camera camera;
	private TextDisplayer textDisplay;
	private static World world = null;
	
	private int collectedMetal;
	private int collectedUnobtainium;
	private int maxCarry;
	
	private World() {
		try {
			map = new Map();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		camera = Camera.getInstance();
		textDisplay = TextDisplayer.getInstance();
		collectedMetal = 0;
		collectedUnobtainium = 0;
		maxCarry = INIT_MAX_CARRY;
	}
	
	/** Get carry max number of resources
	 * @return
	 */
	public int getMaxCarry() {
		return maxCarry;
	}

	/** Set carry max number of resources
	 * @return
	 */
	public void addMaxCarry(int add) {
		this.maxCarry = maxCarry + add;
	}



	/** Get world's instance
	 * @return
	 */
	public static World getInstance() {
		if (world == null) {
			world = new World();
		}
		return world;
	}
	
	public void update(Input input, int delta) {
		camera.update();
		map.update(input, delta);
	}
	
	public void render(Graphics g) {
		int screenX = (int)camera.globalXToScreenX(0);
		int screenY = (int)camera.globalYToScreenY(0);
		map.render(g, screenX, screenY);
		textDisplay.render(g);
	}
	
	public Map getMap() {
		return map;
	}

	/** Get total collected number of metal
	 * @return
	 */
	public int getMetal() {
		return collectedMetal;
	}

	/** Consume metal mine
	 * @param cost
	 * @return
	 */
	public boolean costMetal(int cost) {
		if (collectedMetal - cost >= 0) {
			collectedMetal = collectedMetal - cost;
			return true;
		}else {
			return false;
		}
		
	}
	 
	/** Consume unobtainium mine
	 * @param cost
	 * @return
	 */
	public boolean costUnobtainium(int cost) {
		if (collectedUnobtainium - cost  >= 0) {
			collectedUnobtainium = collectedUnobtainium - cost;
			return true;
		}else {
			return false;
		}
	}
	
	/** Add metal mine
	 * @param add
	 */
	public void addMetal(int add) {
		collectedMetal = collectedMetal + add;
	}
	
	/** Add unobtainium mine
	 * @param add
	 */
	public void addUnobtainium(int add) {
		collectedUnobtainium = collectedUnobtainium + add;
	}

	public int getUnobtainium() {
		return collectedUnobtainium;
	}

	
	
	
	
	
}
