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
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			myHero.moveUp();
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			myHero.moveLeft();
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			myHero.moveRight();
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			myHero.moveDown();
		}
		if(e.getKeyCode() == KeyEvent.VK_B) {
			myHero.setBomb();
			
		}
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
		myHero.stopHero();
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub.

	}

}
