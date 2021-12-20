package miniproject1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

public class HomeEvent2 extends Panel {
	private Image eventImg2;

	@Override
	public void paint(Graphics g) {
		Toolkit t = Toolkit.getDefaultToolkit();
		Image eventImg2 = t.getImage("Image/아마스빈프로모션2.png");
		g.drawImage(eventImg2, 0, 0, this.getWidth(), this.getHeight(), this);
	}
}