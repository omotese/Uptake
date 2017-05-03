import java.awt.Color;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;


public class GameWorld implements Temporal, Relocatable, GameEnvironment, Drawable {
	private static final long UPDATE_INTERVAL_MS = 10;
	private final int width;
	private final int height;
	private final Color color;
	private final ArrayList<Character> characterList = new ArrayList<Character>();
	private final ArrayList<Block> blockList = new ArrayList<Block>();
	private final List<Character> charatersToAdd = new ArrayList<Character>();
	private final List<Character> characterToRemove = new ArrayList<Character>();
	private final List<Block> blocksToAdd = new ArrayList<Block>();
	private final List<Block> blocksToRemove = new ArrayList<Block>();
	private final Shape background;
	private boolean isPaused = false;

	public GameWorld(int width, int height, Color color){
		this.width=width;
		this.height= height;
		this.color= color;
		this.background = new Rectangle2D.Double(0, 0, this.width, this.height);
		
		Runnable tickTock = new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						Thread.sleep(UPDATE_INTERVAL_MS);
						timePassed();
					}
				} catch (InterruptedException exception) {
					// Stop when interrupted
				}
			}
		};
		new Thread(tickTock).start();
		
	}
	
	
	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public Shape getShape() {
		// TODO Auto-generated method stub.
		return this.background;
	}

	@Override
	public void addCharacter(Character character) {
		this.charatersToAdd.add(character);
		

	}

	@Override
	public void removeCharacter(Character character) {
		this.characterToRemove.add(character);

	}

	@Override
	public Character nearestCharacter(Point2D point) {
		// TODO Auto-generated method stub.
		return null;
	}
	
	

	@Override
	public boolean isInsideWorldX(Point2D point) {
		// TODO Auto-generated method stub.
		return false;
	}

	@Override
	public boolean isInsideWorldY(Point2D point) {
		// TODO Auto-generated method stub.
		return false;
	}

	@Override
	public boolean isInsideWorld(Point2D point) {
		// TODO Auto-generated method stub.
		return false;
	}

	@Override
	public Dimension getSize() {
		return new Dimension(this.width, this.height);
	}

	@Override
	public List<Drawable> getDrawableParts() {
		return new ArrayList<Drawable>(this.characterList);
	}

	@Override
	public void moveTo(Point2D point) {
		// TODO Auto-generated method stub.

	}

	@Override
	public Point2D getCenterPoint() {
		// TODO Auto-generated method stub.
		return null;
	}

	@Override
	public void timePassed() {
		// TODO Auto-generated method stub.

	}

	@Override
	public void die() {
		// TODO Auto-generated method stub.

	}

	@Override
	public void setIsPaused(boolean isPaused) {
		// TODO Auto-generated method stub.

	}

	@Override
	public boolean getIsPaused() {
		// TODO Auto-generated method stub.
		return false;
	}


}
