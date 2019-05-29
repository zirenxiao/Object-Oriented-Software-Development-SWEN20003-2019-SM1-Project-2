import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class CommandCentre extends Buildings {
	
	private static final String PATH = "assets/buildings/command_centre.png";
	private static final String SELECT_PATH = "assets/highlight_large.png";

	public CommandCentre(double x, double y) throws SlickException {
		super(PATH, x, y);
		// TODO Auto-generated constructor stub
		setX(x);
		setY(y);
		this.setSelectActiveImagePath(SELECT_PATH);
	}
	@Override
	public void update(Input input, int delta) {
		// TODO Auto-generated method stub

	}

}
