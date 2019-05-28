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
	
	
	private Scout player;
	private Map map;
	
	private Camera camera;
	private TextDisplayer textDisplay;
	
	public World() throws SlickException {
		map = new Map();
		player = new Scout();
		camera = Camera.getInstance();
		textDisplay = TextDisplayer.getInstance();
	}
	
	public void update(Input input, int delta) {
		camera.update(map);
		player.update(input, delta, map);
		map.update(input, delta);
	}
	
	public void render(Graphics g) {
		int screenX = (int)camera.globalXToScreenX(0);
		int screenY = (int)camera.globalYToScreenY(0);
		map.render(g, screenX, screenY);
		player.render(g);
		textDisplay.render(g);
	}
	
	
}
