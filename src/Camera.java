public class Camera {
	private double x = 300;
	private double y = 300;
	private Selectable target = null;
	private static Camera camera = null; // singleton
	
	private Camera() {
		
	}
	
	/** Get instance of the camera
	 * @return
	 */
	public static Camera getInstance() {
		if (camera == null) {
			camera = new Camera();
		}
		return camera;
	}
	
	/** Follow a sprite
	 * @param target
	 */
	public void followSprite(Selectable target) {
		if (this.target!=null) {
			this.target.setSelected(false);
		}
		if (target == null) {
			return;
		}
		target.setSelected(true);
		this.target = target;
	}
	
	/** Change global x to screen x
	 * @param x
	 * @return
	 */
	public double globalXToScreenX(double x) {
		return x - this.x;
	}
	
	/** Change global y to screen y
	 * @param y
	 * @return
	 */
	public double globalYToScreenY(double y) {
		return y - this.y;
	}

	/** Change screen x to global x
	 * @param x
	 * @return
	 */
	public double screenXToGlobalX(double x) {
		return x + this.x;
	}
	
	/** Change screen y to global y
	 * @param y
	 * @return
	 */
	public double screenYToGlobalY(double y) {
		return y + this.y;
	}
	
	/** Update the camera position
	 * 
	 */
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
