import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Engineer extends Movable {
	private static final String PATH = "assets/units/engineer.png";
	private static final double SPEED = 0.1;
	
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
		// TODO Auto-generated constructor stub
		maxCarry = 2;
		currentCarryMetal = 0;
		currentCarryUnobtainium = 0;
//		this.setSelectOption("1- Create Scout\n2- Create Builder\n3- Create Engineer\n");
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
	
	private boolean readyToMine(int delta) {
		if (timer >= 2000) {
			timer = 0;
			return true;
		}
		timer = timer + delta;
		return false;
	}
	
	private void doMine(Resources r) {
		if (r instanceof MetalMine) {
			currentCarryMetal++;
		}else if (r instanceof UnobtainiumMine){
			currentCarryUnobtainium++;
		}
		
		r.setCurrentAmount(r.getCurrentAmount() - 1);
	}
	
	private void submitResources() {
		World world = World.getInstance();
		world.addCurrentCarryMetal(currentCarryMetal);
		world.addCurrentCarryUnobtainium(currentCarryUnobtainium);
		currentCarryMetal = 0;
		currentCarryUnobtainium = 0;
	}
	
	private void doGoBack(int delta) {
		findNearestCommandCentre();
		goToSubmit = true;
	}
	
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
	
	
	
	private boolean reachMaxCarry() {
		return currentCarryMetal + currentCarryUnobtainium >= maxCarry;
	}

}
