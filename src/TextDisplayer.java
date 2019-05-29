import org.newdawn.slick.Graphics;

/** A text displayer can show messages on the screen
 *
 */
public class TextDisplayer {
	
	private static TextDisplayer td = null;
	
	private String selectOption = null;
	
	private static final int RESOURCES_POSITION = 32;
	private static final int SELECT_OPTION_Y = 100;
	
	private TextDisplayer() {

	}
	
	public static TextDisplayer getInstance() {
		if (td == null) {
			td = new TextDisplayer();
		}
		return td;
	}
	
	public void render(Graphics g) {
		g.drawString("Metal: "
				+ World.getInstance().getMetal()
				+ "\nUnobtainium: "
				+ World.getInstance().getUnobtainium(),
				RESOURCES_POSITION, RESOURCES_POSITION);
		if (selectOption != null) {
			g.drawString(selectOption, RESOURCES_POSITION, SELECT_OPTION_Y);
		}
	}

	public void setSelectOption(String selectOption) {
		this.selectOption = selectOption;
	}
	
	

}
