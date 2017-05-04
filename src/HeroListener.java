import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HeroListener implements KeyListener {
	private GameWorldComponent component;
	private Hero myHero;

	
	public HeroListener(Hero hero, GameWorldComponent comp) {
		this.myHero = hero;
		this.component = comp;
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub.
		if (e.getKeyCode() == KeyEvent.VK_KP_DOWN) {
			myHero.moveDown();
		}
		if (e.getKeyCode() == KeyEvent.VK_KP_LEFT) {
			myHero.moveLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_KP_RIGHT) {
			myHero.moveRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_KP_UP) {
			myHero.moveUp();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub.
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub.

	}

}
