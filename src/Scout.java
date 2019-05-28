import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Scout extends Sprite{
	private static final String SCOUT_PATH = "assets/scout.png";
	private static final double SPEED = 0.25;
	
	// Initially, we don't need to move at all
	private double targetX;
	private double targetY;
	
	public Scout() throws SlickException {
		super(SCOUT_PATH, 812, 684);
		this.targetX = this.getX();
		this.targetY = this.getY();
		Camera.getInstance().followSprite(this);
	}
	
	public void update(Input input, int delta, Map map) {	
		// If the mouse button is being clicked, set the target to the cursor location
		if (input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)) {
			targetX = Camera.getInstance().screenXToGlobalX(input.getMouseX());
			targetY = Camera.getInstance().screenYToGlobalY(input.getMouseY());
		}
		
		// If we're close to our target, reset to our current position
		if (distance(this.getX(), this.getY(), targetX, targetY) <= SPEED) {
			resetTarget();
		} else {
			// Calculate the appropriate x and y distances
			double theta = Math.atan2(targetY - this.getY(), targetX - this.getX());
			double dx = (double)Math.cos(theta) * delta * SPEED;
			double dy = (double)Math.sin(theta) * delta * SPEED;
			// Check the tile is free before moving; otherwise, we stop moving
			if (map.isPositionFree(this.getX() + dx, this.getY() + dy)) {
				this.setX(this.getX() + dx);
				this.setY(this.getY() + dy);
			} else {
				resetTarget();
			}
		}
		TextDisplayer.getInstance().setPlayerX(getX());
		TextDisplayer.getInstance().setPlayerY(getY());
	}
	
	private void resetTarget() {
		targetX = this.getX();
		targetY = this.getY();		
	}
	
	public void render(Graphics g) {
		this.drawImage((int)this.getX(), (int)this.getY());
	}
	
	public double distance(double x1, double y1, double x2, double y2) {
		return (double)Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
}
