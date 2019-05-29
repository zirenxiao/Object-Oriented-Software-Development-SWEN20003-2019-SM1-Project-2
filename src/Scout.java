
import org.newdawn.slick.Input;

/** A scout can only move through the map
 *
 */
public class Scout extends Movable{
	private static final String SCOUT_PATH = "assets/units/scout.png";
	private static final double SPEED = 0.3;
	
	
	public Scout(double x, double y) {
		super(SCOUT_PATH, x, y);
	}
	
	public void update(Input input, int delta) {	
		move(delta, SPEED);
	}
	
	
	
	
}
