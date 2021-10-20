package miniproject1;

import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StampFrame extends JFrame{
	Image image;
	  private RoundedButton couponBtn ,exitBtn;
	//Image[] image= new Image(("images/¾Æ¸¶½ººó·Î°í.png") );
	
public StampFrame(String id, String pwd) {
	//ArrayList<Image> image_Array = new ArrayList<>();
    // img2 = Toolkit.getDefaultToolkit().getImage("Image/¾Æ¸¶½ººóÄ³¸¯ÅÍ.png");
   // image_Array.add(image);
	AmasvinDAO dao = AmasvinDAO.getInstance(); //½Ì±ÛÅæÀ¸·Î ¹Ù²Þ
	int stamp = dao.stampnum(id, pwd);
	setVisible(true);
	setBounds(300, 100,600, 350);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	if (stamp == 0)
		image = Toolkit.getDefaultToolkit().getImage("Image/¾Æ¸¶½ººó½ºÅÆÇÁ0.png");
	else if (stamp ==1)
		image = Toolkit.getDefaultToolkit().getImage("Image/¾Æ¸¶½ººó½ºÅÆÇÁ1.png");
	else if (stamp ==2)
		image = Toolkit.getDefaultToolkit().getImage("Image/¾Æ¸¶½ººó½ºÅÆÇÁ2.png");
	else if (stamp ==3)
		image = Toolkit.getDefaultToolkit().getImage("Image/¾Æ¸¶½ººó½ºÅÆÇÁ3.png");
	else if (stamp ==4)
		image = Toolkit.getDefaultToolkit().getImage("Image/¾Æ¸¶½ººó½ºÅÆÇÁ4.png");
	else if (stamp ==5)
		image = Toolkit.getDefaultToolkit().getImage("Image/¾Æ¸¶½ººó½ºÅÆÇÁ5.png");
	else if (stamp ==6)
		image = Toolkit.getDefaultToolkit().getImage("Image/¾Æ¸¶½ººó½ºÅÆÇÁ6.png");
	else if (stamp ==7)
		image = Toolkit.getDefaultToolkit().getImage("Image/¾Æ¸¶½ººó½ºÅÆÇÁ7.png");
	else if (stamp >=8)
		image = Toolkit.getDefaultToolkit().getImage("Image/¾Æ¸¶½ººó½ºÅÆÇÁ8.png");
	
	couponBtn = new RoundedButton("ÄíÆù¹ßÇà");
	if (stamp>=8) couponBtn.setEnabled(true);
	else couponBtn.setEnabled(false);
	couponBtn.setFont(new Font("¾Èµ¿¾ö¸¶±îÅõ¸®", Font.PLAIN, 15));
	Container c = getContentPane();
	exitBtn= new RoundedButton ("´Ý±â");
	exitBtn.setFont(new Font("¾Èµ¿¾ö¸¶±îÅõ¸®", Font.PLAIN, 15));
	JPanel p = new JPanel(new GridLayout(2,1));
	p.add(couponBtn);
	p.add(exitBtn);
	c.add(p, "South");
	exitBtn.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        	dispose();
            new HomeFrame(id, pwd);
            setVisible(false);
        }
     });
	couponBtn.addActionListener(new ActionListener() {
        
        @Override
        public void actionPerformed(ActionEvent e) {
        	AmasvinDAO dao = AmasvinDAO.getInstance(); //½Ì±ÛÅæÀ¸·Î ¹Ù²Þ
        	dao.resetstamp(id, pwd);
        	dao.addcoupon(id, pwd);
        	JOptionPane.showMessageDialog(null, "À½·á 1ÀÜ ÄíÆùÀÌ ¹ßÇàµÇ¾ú½À´Ï´Ù."); 
        	dispose();
	          new HomeFrame(id, pwd);
	          setVisible(false);
        }
     });
	
}
public void paint(Graphics g) {
    super.paint(g);
    
    g.drawImage(image, 0, 0, this.getSize().width, this.getSize().height, this);
    //g.drawImage(img2, 10, 330, 500, 350, this);
 }
//public static void main(String[] args) {
//	new StampFrame(id, pwd, stamp);
//}
}

