import org.newdawn.slick.Input;

/** A command centre can train 3 types of sprite
 */
public class CommandCentre extends Buildings {
	
	private static final String PATH = "assets/buildings/command_centre.png";
	
	private static final int KEY_1_BUILD_COST = 5;
	private static final int KEY_2_BUILD_COST = 10;
	private static final int KEY_3_BUILD_COST = 20;

	public CommandCentre(double x, double y) {
		super(PATH, x, y);
		this.setSelectOption("1- Create Scout\n"
				+ "2- Create Builder\n"
				+ "3- Create Engineer\n");
	}

	/** Key 1 - Scout
	 * Key 2 - Builder
	 * Key 3 - Engineer
	 *
	 */
	@Override
	public void update(Input input, int delta) {
		// TODO Auto-generated method stub
		TrainHandler th = super.getTrainHandler();
		if (this.isSelected()) {
			th.handle(input, Input.KEY_1, new Scout(getX(), getY()), 
					KEY_1_BUILD_COST, ResourcesType.METAL);
			th.handle(input, Input.KEY_2, new Builder(getX(), getY()),
					KEY_2_BUILD_COST, ResourcesType.METAL);
			th.handle(input, Input.KEY_3, new Engineer(getX(), getY()), 
					KEY_3_BUILD_COST, ResourcesType.METAL);
		}
		super.update(input, delta);
	}
}
