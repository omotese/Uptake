import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LevelListener implements KeyListener {

	private GameWorld world;
	
	public LevelListener( GameWorld gameWorld){
		
		this.world = gameWorld;
	}
	

	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_U) {
			this.world.levelUp();
			}
		
		if (e.getKeyCode() == KeyEvent.VK_D) {
			this.world.levelDown();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_P) {
			this.world.togglePause();
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub.
		
	}

}
