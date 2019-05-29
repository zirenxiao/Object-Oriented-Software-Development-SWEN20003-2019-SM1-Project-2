import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class Buildable extends Movable {

	private TrainHandler th;
	private boolean isBuilding = false;
	private double speed;
	
	public Buildable(String path, double x, double y, int buildTime, double speed) {
		super(path, x, y);
		th = new TrainHandler(buildTime);
		this.speed = speed;
	}

	@Override
	public void update(Input input, int delta) {
		th.timePass(delta);
		if (th.getTrainNumber() == 0) {
			isBuilding = false;
		}else {
			isBuilding = true;
		}
		if (!isBuilding) {
			move(delta, speed);
		}
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		if (th.getTrainRemainTime() != TrainHandler.NOT_TRAINING) {
			this.drawString(g, "Time:"+String.valueOf(th.getTrainRemainTime()));
		}
	}

	public TrainHandler getTrainHandler() {
		return th;
	}

	public boolean isBuilding() {
		return isBuilding;
	}
	
	

}
