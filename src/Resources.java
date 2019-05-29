import org.newdawn.slick.Graphics;

/** Resources can be mined by an engineer
 *
 */
public abstract class Resources extends Sprite {
	
	// current amount of the resource
	private int currentAmount;

	public Resources(String path, double x, double y) {
		super(path, x, y);
	}

	/** Return current amount of the resource
	 * @return
	 */
	public int getCurrentAmount() {
		return currentAmount;
	}

	/** Set current amount of the resource
	 * @param currentAmount
	 */
	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}
	
	public void render(Graphics g) {
		super.render(g);
		super.drawString(g, String.valueOf(currentAmount));
	}
	
}
