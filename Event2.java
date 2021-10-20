package miniproject1;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

public class Event2 extends Panel {
	@Override
	public void paint(Graphics g) {

		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("Image/event2.png");
		g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);

	}
}
