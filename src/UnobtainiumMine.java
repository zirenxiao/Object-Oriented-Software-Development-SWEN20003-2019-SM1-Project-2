import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class UnobtainiumMine extends Resources {
	
	private static final String PATH = "assets/resources/unobtainium_mine.png";


	public UnobtainiumMine(double x, double y) throws SlickException {
		super(PATH, x, y);
		// TODO Auto-generated constructor stub
		this.setCurrentAmount(50);
	}

	@Override
	public void update(Input input, int delta) {
		// TODO Auto-generated method stub
		
	}

}
