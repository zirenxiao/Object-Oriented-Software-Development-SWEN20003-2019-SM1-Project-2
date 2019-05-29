import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/** An engineer can mine metals
 */
public class Engineer extends Movable {
	private static final String PATH = "assets/units/engineer.png";
	private static final double SPEED = 0.1;
	private static final int MINE_TIME = 2000;
	
	private double mineX;
	private double mineY;
	
	private int maxCarry;
	private int currentCarryMetal;
	private int currentCarryUnobtainium;
	
	private int timer;
	
	private boolean goToSubmit = false;
	
	private CommandCentre c = null;
	
	public Engineer(double x, double y) {
		super(PATH, x, y);
		maxCarry = 2;
		currentCarryMetal = 0;
		currentCarryUnobtainium = 0;
	}

	@Override
	public void update(Input input, int delta) {
		// TODO Auto-generated method stub
		move(delta, SPEED);
		if (goToSubmit && closeToObject(SPEED)) {
			if (closeToObject(SPEED, c.getX(), c.getY())) {
				// this is the case that is close to
				// the real target, instead of reset
				// target
				submitResources();
				goToSubmit = false;
				this.setTargetX(mineX);
				this.setTargetY(mineY);
			}else {
				// stun action
			}
		}
	}
	
	/** Mine resources
	 * @param r
	 * @param delta
	 */
	public void mine(Resources r, int delta) {
		if (reachMaxCarry()) {
			doGoBack(delta);
		}else {
			mineX = r.getX();
			mineY = r.getY();
			if (readyToMine(delta)) {
				doMine(r);
			}
		}
	}
	
	public void render(Graphics g) {
		super.render(g);
		super.drawString(g, currentCarryMetal+"/"+currentCarryUnobtainium);
	}
	
	/** After a certain time, the resources can be
	 * taken. Return if the action is ready
	 * @param delta
	 * @return
	 */
	private boolean readyToMine(int delta) {
		if (timer >= MINE_TIME) {
			timer = 0;
			return true;
		}
		timer = timer + delta;
		return false;
	}
	
	/** Mine the metal
	 * @param r
	 */
	private void doMine(Resources r) {
		if (r instanceof MetalMine) {
			currentCarryMetal++;
		}else if (r instanceof UnobtainiumMine){
			currentCarryUnobtainium++;
		}
		
		r.setCurrentAmount(r.getCurrentAmount() - 1);
	}
	
	/** Put the resource back into total number
	 * when the engineer is back to a command
	 * center
	 * 
	 */
	private void submitResources() {
		World world = World.getInstance();
		world.addMetal(currentCarryMetal);
		world.addUnobtainium(currentCarryUnobtainium);
		currentCarryMetal = 0;
		currentCarryUnobtainium = 0;
	}
	
	/** Go back to a command center
	 * @param delta
	 */
	private void doGoBack(int delta) {
		findNearestCommandCentre();
		goToSubmit = true;
	}
	
	/** Find the nearest command center and
	 * set the position as the target
	 * 
	 */
	private void findNearestCommandCentre() {
		double smallestDist = Integer.MAX_VALUE;
		for (Sprite s:World.getInstance().getMap().getUnits()) {
			if (s instanceof CommandCentre) {
				double d = this.distance(getX(), getY(), s.getX(), s.getY());
				if (d < smallestDist) {
					c = (CommandCentre) s;
				}
			}
		}
		this.setTargetX(c.getX());
		this.setTargetY(c.getY());
	}
	
	
	
	/** If current carry more than the maximum
	 * @return
	 */
	private boolean reachMaxCarry() {
		return currentCarryMetal + currentCarryUnobtainium >= maxCarry;
	}

}
