import org.newdawn.slick.Input;

/** A truck can build a command center, but it will be
 * destroyed after building completed.
 *
 */
public class Truck extends Buildable {
	
	private static final String PATH = "assets/units/truck.png";
	private static final double SPEED = 0.25;
	private static final int CONSTRUCT_TIME = 15000;
	
	private boolean used = false;

	public Truck(double x, double y) {
		super(PATH, x, y, CONSTRUCT_TIME, SPEED);
		this.setSelectOption("1- Create Command Centre");
	}

	@Override
	public void update(Input input, int delta) {
		if (this.isSelected() && !super.isBuilding()) {
			super.getTrainHandler().handle(input, Input.KEY_1, 
					new CommandCentre(getX(), getY()), 
					0, 
					ResourcesType.METAL);
		}
		if (super.isBuilding()) {
			used = true;
		}
		if (!super.isBuilding() && used) {
			World.getInstance().getMap().removeUnit(this);
			Camera.getInstance().followSprite(null);
		}
		super.update(input, delta);
	}

}
