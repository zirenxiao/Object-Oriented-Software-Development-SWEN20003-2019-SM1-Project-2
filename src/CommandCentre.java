import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class CommandCentre extends Buildings {
	
	private static final String PATH = "assets/buildings/command_centre.png";

	public CommandCentre(double x, double y) throws SlickException {
		super(PATH, x, y);
		// TODO Auto-generated constructor stub
		setX(x);
		setY(y);
	}
	@Override
	public void update(Input input, int delta, Map map) {
		// TODO Auto-generated method stub

	}

}
