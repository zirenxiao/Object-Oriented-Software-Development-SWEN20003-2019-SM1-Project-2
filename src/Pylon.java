
import org.newdawn.slick.Input;

public class Pylon extends Buildings {

	private static final String PATH = 
								"assets/buildings/pylon.png";
	
	private static final String ACTIVE_PATH = 
								"assets/buildings/pylon_active.png";
	
	private static final int INCREASE_CARRY = 1;
	
	private boolean active = false;
	
	public Pylon(double x, double y) {
		super(PATH, x, y);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public void update(Input input, int delta) {
		// TODO Auto-generated method stub
		
	}
	
	/** Set to active pylon
	 * 
	 */
	public void becomeActive() {
		// change image
		this.setImage(ACTIVE_PATH);
		// set max carry + 1
		World.getInstance().addMaxCarry(INCREASE_CARRY);
		active = true;
	}

	/** Is the pylon activated or not
	 * @return
	 */
	public boolean isActive() {
		return active;
	}
	
	

}
