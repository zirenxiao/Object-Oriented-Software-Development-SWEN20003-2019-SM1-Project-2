import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

/**
 * This class should be used to contain all the different objects in your game world, and schedule their interactions.
 * 
 * You are free to make ANY modifications you see fit.
 * These classes are provided simply as a starting point. You are not strictly required to use them.
 */
public class World {

	private Map map;
	
	private Camera camera;
	private TextDisplayer textDisplay;
	private static World world = null;
	
	private int currentCarryMetal;
	private int currentCarryUnobtainium;
	
	private World() {
		try {
			map = new Map();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		camera = Camera.getInstance();
		textDisplay = TextDisplayer.getInstance();
		currentCarryMetal = 0;
		currentCarryUnobtainium = 0;
	}
	
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

	public int getCurrentCarryMetal() {
		return currentCarryMetal;
	}

	public void setCurrentCarryMetal(int currentCarryMetal) {
		this.currentCarryMetal = currentCarryMetal;
	}

	public int getCurrentCarryUnobtainium() {
		return currentCarryUnobtainium;
	}

	public void setCurrentCarryUnobtainium(int currentCarryUnobtainium) {
		this.currentCarryUnobtainium = currentCarryUnobtainium;
	}
	
	
	
	
}
