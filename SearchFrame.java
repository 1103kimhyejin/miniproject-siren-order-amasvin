package miniproject1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SearchFrame extends JFrame{
	private RoundedButton idsearchBtn, pwdsearchBtn, cancelBtn;
	private Image img2;

	public SearchFrame() {
		 JScrollPane scrollPane;
	       ImageIcon icon;
	   
	          icon = new ImageIcon("Image/아마스빈배경.jpg");
	       
	           //배경 Panel 생성후 컨텐츠페인으로 지정      
	           JPanel background = new JPanel() {
	               public void paintComponent(Graphics g) {
	             
	                  g.drawImage(icon.getImage(),0,0, this.getWidth(), this.getHeight(),null);
	                 
	                   setOpaque(false); //그림을 표시하게 설정,투명하게 조절
	                   super.paintComponent(g);
	               }
	           };

		//setLayout(null);
	    img2 = Toolkit.getDefaultToolkit().getImage("Image/아마스빈캐릭터.png");
	           
		idsearchBtn = new RoundedButton("아이디 찾기");
		pwdsearchBtn = new RoundedButton("비밀번호 찾기");
		cancelBtn = new RoundedButton("취소");
		idsearchBtn.setBounds(180, 350, 100, 50);
		idsearchBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		pwdsearchBtn.setBounds(297, 350, 100, 50);
		pwdsearchBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		cancelBtn.setBounds(410, 350, 100, 50);
		cancelBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
	     background.add(idsearchBtn);
	     background.add(pwdsearchBtn);
	     background.add(cancelBtn);
	     background.setLayout(null);
	     
	     scrollPane = new JScrollPane(background);
	      setContentPane(scrollPane);

	      
	    setTitle("아마스빈 사이렌 오더 프로그램");
	    setBounds(300, 100, 700, 700);
	    setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
	    idsearchBtn.addActionListener(new ActionListener() {
	        
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            dispose();
	            new IdSearchFrame();
	            setVisible(false);
	         }
	      });
	    
	    pwdsearchBtn.addActionListener(new ActionListener() {
	        
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            dispose();
	            new PwdSearchFrame();
	            setVisible(false);
	         }
	      });
	    
	    cancelBtn.addActionListener(new ActionListener() {
	        
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            dispose();
	            new LoginFrame();
	            setVisible(false);
	         }
	      });
	}
	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(img2, 20, 400, 680, 350, this);
}
}
