import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Selectable extends Sprite {
	
	private boolean selected = false;
	private Image selectActive;
	private String selectOption = null;

	public Selectable(String path, double x, double y) {
		super(path, x, y);
	}
	
	public void setSelectActiveImagePath(String path) {
		try {
			selectActive = new Image(path);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public void setSelect() {
		Camera.getInstance().followSprite(this);
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
		if (selectOption != null && selected) {
			TextDisplayer.getInstance().setSelectOption(selectOption);
		}else if (!selected) {
			TextDisplayer.getInstance().setSelectOption(null);
		}
	}
	
	public void setSelectOption(String selectOption) {
		this.selectOption = selectOption;
	}

	public void render(Graphics g) {
		if (selected) {
			this.drawImage(selectActive);
		}
		super.render(g);
	}
	
	
}
