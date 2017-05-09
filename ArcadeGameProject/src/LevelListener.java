import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LevelListener implements KeyListener {

	private GameWorldComponent comp;
	
	public LevelListener( GameWorldComponent gameWorldComponent){
		
		this.comp = gameWorldComponent;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_U) {
			this.comp.levelUp();
			}
		
		if (e.getKeyCode() == KeyEvent.VK_D) {
			this.comp.levelDown();
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
