import org.newdawn.slick.Input;

/** A factory can train trucks
 *
 */
public class Factory extends Buildings {
	
	private static final String PATH = "assets/buildings/factory.png";
	
	private static final int KEY_1_BUILD_COST = 150;
	

	public Factory(double x, double y) {
		super(PATH, x, y);
		this.setSelectOption("1- Create Truck");
	}

	@Override
	public void update(Input input, int delta) {
		// TODO Auto-generated method stub
		TrainHandler th = super.getTrainHandler();
		if (this.isSelected()) {
			th.handle(input, Input.KEY_1, new Truck(getX(), getY()), 
					KEY_1_BUILD_COST, ResourcesType.METAL);
		}
		super.update(input, delta);
	}

}
