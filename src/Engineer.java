import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Engineer extends Movable {
	private static final String PATH = "assets/units/engineer.png";
	private static final double SPEED = 0.1;
	
	public Engineer(double x, double y) throws SlickException {
		super(PATH, x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Input input, int delta, Map map) {
		// TODO Auto-generated method stub
		move(map, delta, SPEED);
	}

}
