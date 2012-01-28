package fi.ringofsnake.gamestates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import fi.ringofsnake.entities.Map;
import fi.ringofsnake.io.ResourceManager;

public class PlayGameState extends BasicGameState {

	private int stateID = -1;
	
	private Image snakeUpper;
	private Image snakeBody;
	private Image snakeLower;
	
	private Map current_map = null;
	
	public PlayGameState(int stateID) {
		this.stateID = stateID;
	}
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		snakeUpper = ResourceManager.fetchImage("SNAKE_BODY_UPPER");
		snakeBody  = ResourceManager.fetchImage("SNAKE_BODY");
		snakeLower = ResourceManager.fetchImage("SNAKE_BODY_LOWER");
		
		current_map = new Map();
	}
	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		int x = 50;
		int y = 50;
		g.drawImage(snakeUpper, x, y);
		g.drawImage(snakeBody, x, y + snakeUpper.getHeight());
		g.drawImage(snakeLower, x, y + snakeUpper.getHeight() + snakeBody.getHeight());
		
		Image tile = current_map.getTile(0, 0).getImage();
		g.drawImage(tile, x + 100, y);
	}
	
	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return stateID;
	}

}
