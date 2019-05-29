
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
	
	public void drawImage(int x, int y) {
		int screenX = (int)Camera.getInstance().globalXToScreenX(x);
		int screenY = (int)Camera.getInstance().globalYToScreenY(y);
		this.image.drawCentered(screenX, screenY);
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
	
	public abstract void update(Input input, int delta, Map map);
	
}
