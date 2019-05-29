import org.newdawn.slick.Input;

public class CommandCentre extends Buildings {
	
	private static final String PATH = "assets/buildings/command_centre.png";

	public CommandCentre(double x, double y) {
		super(PATH, x, y);
		this.setSelectOption("1- Create Scout\n2- Create Builder\n3- Create Engineer\n");
	}

	@Override
	public void update(Input input, int delta) {
		// TODO Auto-generated method stub
		TrainHandler th = super.getTrainHandler();
		if (this.isSelected()) {
			th.handle(input, Input.KEY_1, new Scout(getX(), getY()), 5, ResourcesType.METAL);
			th.handle(input, Input.KEY_2, new Builder(getX(), getY()), 10, ResourcesType.METAL);
			th.handle(input, Input.KEY_3, new Engineer(getX(), getY()), 20, ResourcesType.METAL);
		}
		super.update(input, delta);
	}
}
