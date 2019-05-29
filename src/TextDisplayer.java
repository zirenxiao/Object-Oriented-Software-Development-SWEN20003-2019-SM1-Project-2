import org.newdawn.slick.Graphics;

public class TextDisplayer {
	
	private static TextDisplayer td = null;
	
	private String selectOption = null;
	
	private TextDisplayer() {

	}
	
	public static TextDisplayer getInstance() {
		if (td == null) {
			td = new TextDisplayer();
		}
		return td;
	}
	
	public void render(Graphics g) {
		g.drawString("Metal: "+World.getInstance().getCurrentCarryMetal()+"\nUnobtainium: "+World.getInstance().getCurrentCarryUnobtainium(), 32, 32);
		if (selectOption != null) {
			g.drawString(selectOption, 32, 100);
		}
	}

	public void setSelectOption(String selectOption) {
		this.selectOption = selectOption;
	}
	
	

}
