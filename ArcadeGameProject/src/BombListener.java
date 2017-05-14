import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BombListener implements KeyListener {
	private GameWorldComponent comp;
	private Bomb myBomb;
	
	public BombListener(GameWorldComponent comp, Bomb bomb){
		this.comp= comp;
		this.myBomb= bomb;
	}
		
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub.
		if(e.getKeyCode()==KeyEvent.VK_E){
			
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
