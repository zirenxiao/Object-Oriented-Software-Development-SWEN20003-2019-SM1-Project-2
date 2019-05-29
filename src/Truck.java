import org.newdawn.slick.Input;

public class Truck extends Movable {
	
	private static final String PATH = "assets/units/truck.png";
	private static final double SPEED = 0.25;

	public Truck(double x, double y) {
		super(PATH, x, y);
	}

	@Override
	public void update(Input input, int delta) {
		move(delta, SPEED);
	}

}
