import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Builder extends Movable {
	private static final String PATH = "assets/units/builder.png";
	private static final double SPEED = 0.1;
	private static final int CONSTRUCT_TIME = 10000;
	
	private TrainHandler th;
	
	private boolean isBuilding = false;
	
	public Builder(double x, double y) {
		super(PATH, x, y);
		// TODO Auto-generated constructor stub
		this.setSelectOption("1- Create Factory");
		th = new TrainHandler(CONSTRUCT_TIME);
	}

	@Override
	public void update(Input input, int delta) {
		// TODO Auto-generated method stub
		if (this.isSelected() && !isBuilding) {
			th.handle(input, Input.KEY_1, new Factory(getX(), getY()), 100, ResourcesType.METAL);
		}
		th.timePass(delta);
		if (th.getTrainNumber() == 0) {
			isBuilding = false;
		}else {
			isBuilding = true;
		}
		if (!isBuilding) {
			move(delta, SPEED);
		}
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		if (th.getTrainRemainTime() != TrainHandler.NOT_TRAINING) {
			this.drawString(g, "Time:"+String.valueOf(th.getTrainRemainTime()));
		}
	}

}
