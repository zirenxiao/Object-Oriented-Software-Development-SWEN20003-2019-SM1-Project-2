import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class MetalMine extends Resources {
	
	private static final String PATH = "assets/resources/metal_mine.png";
	private double x;
	private double y;

	public MetalMine(double x, double y) throws SlickException {
		super(PATH, x, y);

	}

	@Override
	void render(Graphics g) {
		// TODO Auto-generated method stub
		this.drawImage((int)x, (int)y);
	}

	@Override
	void update(Input input, int delta, Map map) {
		// TODO Auto-generated method stub
		
	}

}
