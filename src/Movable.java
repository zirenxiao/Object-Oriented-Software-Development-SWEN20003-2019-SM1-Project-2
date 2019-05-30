/** Movable objects can move through the map
 *
 */
public abstract class Movable extends Selectable {
	
	private double targetX;
	private double targetY;
	private static final String SELECT_PATH = "assets/highlight.png";
	

	public Movable(String path, double x, double y) {
		super(path, x, y);
		this.targetX = this.getX();
		this.targetY = this.getY();
		this.setSelectActiveImagePath(SELECT_PATH);
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
	
	/** Reset the target position into current position
	 * 
	 */
	public void resetTarget() {
		targetX = this.getX();
		targetY = this.getY();		
	}
	
	/** Calculate distance between 2 points
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public double distance(double x1, double y1, double x2, double y2) {
		return (double)Math.sqrt((x2 - x1)*(x2 - x1)+(y2 - y1)*(y2 - y1));
	}

	/** Move to the target
	 * @param delta
	 * @param speed
	 */
	public void move(int delta, double speed) {
		if (this.closeToObject(speed)) {
			resetTarget();
		} else {
			// Calculate the appropriate x and y distances
			double theta = Math.atan2(this.getTargetY() - this.getY(), 
										this.getTargetX() - this.getX());
			double dx = (double)Math.cos(theta) * delta * speed;
			double dy = (double)Math.sin(theta) * delta * speed;
			// Check the tile is free before moving; otherwise, we stop moving
			if (World.getInstance().getMap().isPositionFree(this.getX() + dx, 
										this.getY() + dy)) {
				this.setX(this.getX() + dx);
				this.setY(this.getY() + dy);
			} else {
				resetTarget();
			}
		}
	}
	
	/** If current position is close enough to the target
	 * @param speed
	 * @return
	 */
	public boolean closeToObject(double speed) {
		return distance(this.getX(), this.getY(), 
						this.getTargetX(), this.getTargetY()) <= speed;
	}
	
	/** If current position is close enough to a point
	 * @param speed
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean closeToObject(double speed, double x, double y) {
		return distance(this.getX(), this.getY(), x, y) <= speed;
	}
	

}
