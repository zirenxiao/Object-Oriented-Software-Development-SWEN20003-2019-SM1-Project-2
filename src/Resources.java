import org.newdawn.slick.Graphics;

public abstract class Resources extends Sprite {
	
	private int currentAmount;

	public Resources(String path, double x, double y) {
		super(path, x, y);
	}

	public int getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}
	
	public void render(Graphics g) {
		super.render(g);
		super.drawString(g, String.valueOf(currentAmount));
	}
	
}
