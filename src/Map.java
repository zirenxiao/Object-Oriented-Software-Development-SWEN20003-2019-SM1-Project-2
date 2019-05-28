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
		        	units.add(new UnobtainiumMine(intx, inty));
		        }
		    }
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
	
	public void update(Input input, int delta) {
		for (Sprite s:units) {
			s.update(input, delta, this);
		}
	}
}