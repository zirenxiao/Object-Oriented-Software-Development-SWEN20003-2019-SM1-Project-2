import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class MetalMine extends Resources {
	
	private static final String PATH = "assets/resources/metal_mine.png";

	public MetalMine(double x, double y) throws SlickException {
		super(PATH, x, y);
		this.setCurrentAmount(500);
	}


	@Override
	public void update(Input input, int delta) {
		// TODO Auto-generated method stub
		
	}

}
