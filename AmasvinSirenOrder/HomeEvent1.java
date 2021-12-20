package miniproject1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

public class HomeEvent1 extends Panel {
	private Image eventImg1;

	@Override
	public void paint(Graphics g) {
		Toolkit t = Toolkit.getDefaultToolkit();
		Image eventImg1 = t.getImage("Image/아마스빈프로모션1.png");
		g.drawImage(eventImg1, 0, 0, this.getWidth(), this.getHeight(), this);

	}
}
