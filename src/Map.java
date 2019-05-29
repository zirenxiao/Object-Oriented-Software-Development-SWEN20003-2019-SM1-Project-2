import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Map {
	private static final String MAP_PATH = "assets/main.tmx";
	private static final String RESOURCES_PATH = "assets/objects.csv";
	private static final String SOLID_PROPERTY = "solid";
	private static final String COMMA_DELIMITER = ",";
	private TiledMap map;
	private ArrayList<Sprite> units;
	
	
	public Map() throws SlickException {
		// construct background
		map = new TiledMap(MAP_PATH);
		// construct units
		units = new ArrayList<Sprite>();
		readFromCSV();
	}
	
	private void readFromCSV() {
		try (BufferedReader br = new BufferedReader(new FileReader(RESOURCES_PATH))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(COMMA_DELIMITER);
		        String name = values[0];
		        String x = values[1];
		        String y = values[2];
		        int intx = Integer.parseInt(x);
		        int inty = Integer.parseInt(y);
		        if (name.equals("metal_mine")) {
		        	units.add(new MetalMine(intx, inty));
		        }else if(name.equals("unobtainium_mine")){
		        	units.add(new UnobtainiumMine(intx, inty));
		        }else if(name.equals("command_centre")){
		        	units.add(new CommandCentre(intx, inty));
		        }else if(name.equals("factory")){
		        	units.add(new Factory(intx, inty));
		        }else if(name.equals("pylon")){
		        	units.add(new Pylon(intx, inty));
		        }else if(name.equals("engineer")){
		        	units.add(new Engineer(intx, inty));
		        }
		    }
		    units.add(new Scout());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isPositionFree(double x, double y) {
		int tileId = map.getTileId(worldXToTileX(x), worldYToTileY(y), 0);
		return !Boolean.parseBoolean(map.getTileProperty(tileId, SOLID_PROPERTY, "false"));
	}
	
	public double getMapWidth() {
		return map.getWidth() * map.getTileWidth();
	}
	
	public double getMapHeight() {
		return map.getHeight() * map.getTileHeight();
	}
	
	private int worldXToTileX(double x) {
		return (int)(x / map.getTileWidth());
	}
	
	private int worldYToTileY(double y) {
		return (int)(y / map.getTileHeight());
	}
	
	public void render(Graphics g, int screenX, int screenY) {
		map.render(screenX, screenY);
		for (Sprite s:units) {
			s.render(g);
		}
	}
	
	private boolean selectObject(double mouseX, double mouseY) {
		for (Sprite s:units) {
			if (!(s instanceof Selectable)) {
				continue;
			}
			if (withInDistance(mouseX, s.getX(), mouseY, s.getY(), 32)) {
				((Selectable) s).setSelect();
				return true;
			}
		}
		return false;
	}
	
	public void update(Input input, int delta) {
		boolean pressed = input.isMousePressed(Input.MOUSE_LEFT_BUTTON);
		double globalX = Camera.getInstance().screenXToGlobalX(input.getMouseX());
		double globalY = Camera.getInstance().screenYToGlobalY(input.getMouseY());
		boolean newSelect = false;
		
		// check if there is any object in the selection distance
		if (pressed) {
			newSelect = selectObject(globalX, globalY);
		}
		
		for (int i=0; i<units.size(); i++) {
			Sprite s = units.get(i);

			// select and move
			if (pressed && (s instanceof Movable)) {
				if (((Movable) s).isSelected() && !newSelect) {
					((Movable) s).setTargetX(globalX);
					((Movable) s).setTargetY(globalY);
				}
			}
			
			// mine resources && submit resources
			for (Sprite other:units) {
				if ((other instanceof Resources) && (s instanceof Engineer)) {
					if (withInDistance(other.getX(), s.getX(), other.getY(), s.getY(), 32)) {
						((Engineer) s).mine((Resources) other, delta);
					}
				}
				if ((other instanceof CommandCentre) && (s instanceof Engineer)) {
					
				}
			}
		
			
			// remove resources if empty
			if (s instanceof Resources) {
				if (((Resources) s).getCurrentAmount() <= 0) {
					units.remove(i);
				}
			}
			
			
			
			s.update(input, delta);
		}
	}
	
	private boolean withInDistance(double x1, double x2, double y1, double y2, int d) {
		return (Math.abs(x1 - x2) <= d) && (Math.abs(y1 - y2) <=d);
	}

	public ArrayList<Sprite> getUnits() {
		return units;
	}
	
	
}
