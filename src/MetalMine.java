import org.newdawn.slick.Input;

public class MetalMine extends Resources {
	
	private static final String PATH = "assets/resources/metal_mine.png";
	private static final int AMOUNT = 500;

	public MetalMine(double x, double y) {
		super(PATH, x, y);
		this.setCurrentAmount(AMOUNT);
	}

	@Override
	public void update(Input input, int delta) {
		
	}

}
