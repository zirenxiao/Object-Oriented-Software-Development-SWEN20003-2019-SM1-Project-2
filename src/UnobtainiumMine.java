import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class UnobtainiumMine extends Resources {
	
	private static final String PATH = "assets/resources/unobtainium_mine.png";


	public UnobtainiumMine(double x, double y) throws SlickException {
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