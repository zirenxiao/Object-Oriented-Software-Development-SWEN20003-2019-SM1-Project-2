import org.newdawn.slick.Graphics;

/** A text displayer can show messages on the screen
 *
 */
public class TextDisplayer {
	
	private static TextDisplayer td = null;
	
	private String selectOption = null;
	
	private static final int LEFT_DISPLAY_POSITION = 32;
	private static final int SELECT_OPTION_Y = 100;
	
	private static final int CHEAT_OPTION_Y = 650;
	
	private static final int CARRY_Y = 700;
	
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
				LEFT_DISPLAY_POSITION, LEFT_DISPLAY_POSITION);
		g.drawString("Max Carry Mine: "
				+ World.getInstance().getMaxCarry(),
				LEFT_DISPLAY_POSITION, CARRY_Y);
		g.drawString("Cheat Option: 0. Get 99 Metal "
				+ "9. Increase 99 Max Carry",
				LEFT_DISPLAY_POSITION, CHEAT_OPTION_Y);
		if (selectOption != null) {
			g.drawString(selectOption, 
					LEFT_DISPLAY_POSITION, SELECT_OPTION_Y);
		}
	}

	public void setSelectOption(String selectOption) {
		this.selectOption = selectOption;
	}
	
	

}
