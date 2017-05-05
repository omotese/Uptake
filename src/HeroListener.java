import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HeroListener implements KeyListener {
	private GameWorldComponent component;
	private Hero myHero;

	
	public HeroListener(Hero hero, GameWorldComponent comp) {
		this.myHero = hero;
		this.component = comp;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			myHero.moveUp();
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			myHero.moveLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			myHero.moveRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_S) {
			myHero.moveDown();
		}
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub.

	}

}
