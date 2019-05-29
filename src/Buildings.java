import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

/** Buildings can train some sprites
 */
public abstract class Buildings extends Selectable {
	
	private static final String SELECT_PATH = "assets/highlight_large.png";
	private static final int CONSTRUCT_TIME = 5000;
	
	private TrainHandler th;

	public Buildings(String path, double x, double y) {
		super(path, x, y);
		// TODO Auto-generated constructor stub
		this.setSelectActiveImagePath(SELECT_PATH);
		th = new TrainHandler(CONSTRUCT_TIME);
	}
	
	@Override
	public void update(Input input, int delta) {
		th.timePass(delta);
	}
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		if (th.getTrainRemainTime() != TrainHandler.NOT_TRAINING) {
			this.drawString(g, "Time:"+String.valueOf(th.getTrainRemainTime())+"\nTotal:"+String.valueOf(th.getTrainNumber()));
		}
	}

	public TrainHandler getTrainHandler() {
		return th;
	}
	
	

}
