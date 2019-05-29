
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Scout extends Movable{
	private static final String SCOUT_PATH = "assets/units/scout.png";
	private static final double SPEED = 0.3;
	
	
	public Scout() throws SlickException {
		super(SCOUT_PATH, 812, 684);
//		Camera.getInstance().followSprite(this);
	}
	
	public void update(Input input, int delta) {	
		// If the mouse button is being clicked, set the target to the cursor location
//		if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
//			this.setTargetX(Camera.getInstance().screenXToGlobalX(input.getMouseX()));
//			this.setTargetY(Camera.getInstance().screenYToGlobalY(input.getMouseY()));
//		}
		
		// If we're close to our target, reset to our current position
		move(delta, SPEED);
	}
	
	
	
	
}
