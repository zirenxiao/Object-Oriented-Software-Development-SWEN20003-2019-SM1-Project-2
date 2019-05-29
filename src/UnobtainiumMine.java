import org.newdawn.slick.Input;

public class UnobtainiumMine extends Resources {
	
	private static final String PATH = "assets/resources/unobtainium_mine.png";
	private static final int AMOUNT = 50;


	public UnobtainiumMine(double x, double y) {
		super(PATH, x, y);
		this.setCurrentAmount(AMOUNT);
	}

	@Override
	public void update(Input input, int delta) {
		
	}

}
