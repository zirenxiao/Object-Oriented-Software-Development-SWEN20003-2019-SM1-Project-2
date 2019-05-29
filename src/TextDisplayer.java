import org.newdawn.slick.Graphics;

public class TextDisplayer {
	
	private static TextDisplayer td = null;
	private double playerX;
	private double playerY;
	private int amountMetal;
	private int amountUnobtainium;
	
	private TextDisplayer() {
		amountMetal = 0;
		amountUnobtainium = 0;
	}
	
	public static TextDisplayer getInstance() {
		if (td == null) {
			td = new TextDisplayer();
		}
		return td;
	}
	
	public void render(Graphics g) {
		g.drawString("Metal: "+World.getInstance().getCurrentCarryMetal()+"\nUnobtainium: "+World.getInstance().getCurrentCarryUnobtainium(), 32, 32);
		g.drawString("Your Position "+Math.round(playerX)+", "+Math.round(playerY), 32, 700);
	}
	
	public void setPlayerX(double x) {
		this.playerX = x;
	}
	
	public void setPlayerY(double y) {
		this.playerY = y;
	}

}
