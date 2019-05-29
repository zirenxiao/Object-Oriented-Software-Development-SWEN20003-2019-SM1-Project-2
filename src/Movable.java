import org.newdawn.slick.SlickException;

public abstract class Movable extends Sprite {
	
	private double targetX;
	private double targetY;
	private boolean selected = false;

	public Movable(String path, double x, double y) throws SlickException {
		super(path, x, y);
		this.targetX = this.getX();
		this.targetY = this.getY();
	}

	public double getTargetX() {
		return targetX;
	}

	public void setTargetX(double targetX) {
		this.targetX = targetX;
	}

	public double getTargetY() {
		return targetY;
	}

	public void setTargetY(double targetY) {
		this.targetY = targetY;
	}
	
	public void resetTarget() {
		targetX = this.getX();
		targetY = this.getY();		
	}
	
	public double distance(double x1, double y1, double x2, double y2) {
		return (double)Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
	
	public void setSelect() {
		Camera.getInstance().followSprite(this);
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public void move(int delta, double speed) {
		if (this.closeToObject(speed)) {
			resetTarget();
		} else {
			// Calculate the appropriate x and y distances
			double theta = Math.atan2(this.getTargetY() - this.getY(), this.getTargetX() - this.getX());
			double dx = (double)Math.cos(theta) * delta * speed;
			double dy = (double)Math.sin(theta) * delta * speed;
			// Check the tile is free before moving; otherwise, we stop moving
			if (World.getInstance().getMap().isPositionFree(this.getX() + dx, this.getY() + dy)) {
				this.setX(this.getX() + dx);
				this.setY(this.getY() + dy);
			} else {
				resetTarget();
			}
		}
	}
	
	public boolean closeToObject(double speed) {
		return distance(this.getX(), this.getY(), this.getTargetX(), this.getTargetY()) <= speed;
	}
	

}
