
import org.newdawn.slick.Input;

public class Scout extends Movable{
	private static final String SCOUT_PATH = "assets/units/scout.png";
	private static final double SPEED = 0.3;
	
	
	public Scout(double x, double y) {
		super(SCOUT_PATH, x, y);
//		Camera.getInstance().followSprite(this);
	}
	
	public void update(Input input, int delta) {	
		move(delta, SPEED);
	}
	
	
	
	
}
