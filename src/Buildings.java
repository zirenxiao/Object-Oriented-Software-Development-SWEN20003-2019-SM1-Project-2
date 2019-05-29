
import org.newdawn.slick.SlickException;

public abstract class Buildings extends Selectable {
	
	private static final String SELECT_PATH = "assets/highlight.png";

	public Buildings(String path, double x, double y) throws SlickException {
		super(path, x, y);
		// TODO Auto-generated constructor stub
		this.setSelectActiveImagePath(SELECT_PATH);
	}

}
