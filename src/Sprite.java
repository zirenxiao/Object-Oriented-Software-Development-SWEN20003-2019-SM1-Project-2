
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public abstract class Sprite {
	private Image image;
	private double x;
	private double y;

	
	public Sprite(String path, double x, double y) throws SlickException {
		super();
		image = new Image(path);
		this.x = x;
		this.y = y;
	}
	
	/** Draw self image at the point X, Y
	 * @param x
	 * @param y
	 */
	public void drawImage(int x, int y) {
		drawImage(x, y, this.image);
	}
	
	/** Draw an image on the same X, Y
	 * @param image
	 */
	public void drawImage(Image image) {
		drawImage((int) this.getX(), (int) this.getY(), image);
	}
	
	/** Draw an image at point x, y
	 * @param x
	 * @param y
	 * @param image
	 */
	public void drawImage(double x, double y, Image image) {
		int screenX = (int)Camera.getInstance().globalXToScreenX(x);
		int screenY = (int)Camera.getInstance().globalYToScreenY(y);
		image.drawCentered(screenX, screenY);
	}
	
	public void drawString(Graphics g, String s) {
		int screenX = (int)Camera.getInstance().globalXToScreenX(x);
		int screenY = (int)Camera.getInstance().globalYToScreenY(y);
		g.drawString(s, screenX, screenY);
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public void render(Graphics g) {
		this.drawImage((int)this.getX(), (int)this.getY());
	}
	
	public abstract void update(Input input, int delta);
	
}
