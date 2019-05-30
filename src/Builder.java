import org.newdawn.slick.Input;

/** A Builder can build a factory
 */
public class Builder extends Buildable {
	private static final String PATH = "assets/units/builder.png";
	private static final double SPEED = 0.1;
	private static final int CONSTRUCT_TIME = 10000;
	private static final int KEY_1_BUILD_COST = 100;
	
	
	public Builder(double x, double y) {
		super(PATH, x, y, CONSTRUCT_TIME, SPEED);
		// TODO Auto-generated constructor stub
		this.setSelectOption("1- Create Factory");
	}

	@Override
	public void update(Input input, int delta) {
		if (this.isSelected() && !super.isBuilding()) {
			super.getTrainHandler().handle(input, Input.KEY_1, 
					new Factory(getX(), getY()), KEY_1_BUILD_COST, 
					ResourcesType.METAL);
		}
		super.update(input, delta);
	}

}
