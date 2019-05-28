import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Pylon extends Buildings {

	private static final String PATH = "assets/buildings/pylon.png";
	
	public Pylon(double x, double y) throws SlickException {
		super(PATH, x, y);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	void render(Graphics g) {
		// TODO Auto-generated method stub
		this.drawImage((int)this.getX(), (int)this.getY());

	}

	@Override
	void update(Input input, int delta, Map map) {
		// TODO Auto-generated method stub

	}

}
