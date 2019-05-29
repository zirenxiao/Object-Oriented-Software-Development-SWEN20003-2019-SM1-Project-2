/**
 * This class should be used to restrict the game's view to a subset of the entire world.
 * 
 * You are free to make ANY modifications you see fit.
 * These classes are provided simply as a starting point. You are not strictly required to use them.
 */
public class Camera {
	private double x = 300;
	private double y = 300;
	private Selectable target = null;
	private static Camera camera = null;
	
	private Camera() {
		
	}
	
	public static Camera getInstance() {
		if (camera == null) {
			camera = new Camera();
		}
		return camera;
	}
	
	public void followSprite(Selectable target) {
		if (this.target!=null) {
			this.target.setSelected(false);
		}
		target.setSelected(true);
		this.target = target;
	}
	
	public double globalXToScreenX(double x) {
		return x - this.x;
	}
	public double globalYToScreenY(double y) {
		return y - this.y;
	}

	public double screenXToGlobalX(double x) {
		return x + this.x;
	}
	public double screenYToGlobalY(double y) {
		return y + this.y;
	}
	
	public void update() {
		if (target == null) {
			return;
		}
		double targetX = target.getX() - App.WINDOW_WIDTH / 2;
		double targetY = target.getY() - App.WINDOW_HEIGHT / 2;
		
		x = Math.min(targetX, World.getInstance().getMap().getMapWidth() - App.WINDOW_WIDTH);
		x = Math.max(x, 0);
		y = Math.min(targetY, World.getInstance().getMap().getMapHeight() - App.WINDOW_HEIGHT);
		y = Math.max(y, 0);
	}
}
