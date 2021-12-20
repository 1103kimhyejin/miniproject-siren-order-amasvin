package miniproject1;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class HomeFrame extends JFrame implements ActionListener {
   private RoundedButton homeBtn, menuBtn, stampBtn, myBtn, logoutBtn, backBtn1, nextBtn1, backBtn2, nextBtn2;
   private CardLayout card;
   private JPanel topP, middleP, lowP;
   private Image eventImg1, eventImg2, bestImg1;
   private JLabel txtL, txtL2, txtL3, txtL4;
   private String id, pwd;

   public HomeFrame(String id, String pwd) {
      this.id = id;
      this.pwd = pwd;
      AmasvinDAO dao = AmasvinDAO.getInstance(); // 싱글톤으로 바꿈
      String name = dao.loginMember(id, pwd);
      setTitle("반갑습니다, 아마스빈입니다");

      JLabel txtL = new JLabel(name + "님, 반갑습니다!");
      txtL.setFont(new Font("안동엄마까투리", Font.BOLD, 18));
      txtL.setHorizontalAlignment(SwingConstants.CENTER);
      txtL.setBounds(100, 50, 180, 30);

      JLabel txtL2 = new JLabel("오랫동안 사랑하고,");
      txtL2.setFont(new Font("안동엄마까투리", Font.PLAIN, 12));
      txtL2.setHorizontalAlignment(SwingConstants.CENTER);
      txtL2.setBounds(250, 50, 245, 30);

      JLabel txtL3 = new JLabel("사랑받고 싶습니다...");
      txtL3.setFont(new Font("안동엄마까투리", Font.PLAIN, 12));
      txtL3.setHorizontalAlignment(SwingConstants.CENTER);
      txtL3.setBounds(280, 70, 245, 30);

      JLabel txtL4 = new JLabel("\t");
      homeBtn = new RoundedButton("HOME");
      menuBtn = new RoundedButton("MENU");
      stampBtn = new RoundedButton("STAMP");
      myBtn = new RoundedButton("MY PAGE");
      logoutBtn = new RoundedButton("LOGOUT");
      nextBtn1 = new RoundedButton("Next");
      backBtn1 = new RoundedButton("Back");
      
      homeBtn.setFont(new Font("안동엄마까투리", Font.PLAIN, 24));
      menuBtn.setFont(new Font("안동엄마까투리", Font.PLAIN, 24));
      stampBtn .setFont(new Font("안동엄마까투리", Font.PLAIN, 24));
      myBtn.setFont(new Font("안동엄마까투리", Font.PLAIN, 24));
      logoutBtn.setFont(new Font("안동엄마까투리", Font.PLAIN, 24));
      nextBtn1.setFont(new Font("안동엄마까투리", Font.PLAIN, 12));
      backBtn1.setFont(new Font("안동엄마까투리", Font.PLAIN, 12));


      // 버튼(하단부) - 5개
      JPanel p = new JPanel(); // FlowLayout
      p.setBackground(new Color(255,255,255));
      p.setLayout(new GridLayout(5,1));
      p.add(homeBtn);
      p.add(menuBtn);
      p.add(stampBtn);
      p.add(myBtn);
      p.add(logoutBtn);
      
//      homeBtn.setBounds(0, 0, 30, 30);
//      menuBtn.setBounds(500, 500, 30, 30);
//      stampBtn.setBounds(500, 500, 30, 30);
//      myBtn.setBounds(500, 80, 500, 30);
//      logoutBtn.setBounds(500, 500, 30, 30);

      topP = new JPanel();
      topP.setLayout(null);
      topP.setBackground(new Color(255, 255, 255));
      topP.add(txtL);
      topP.add(txtL2);
      topP.add(txtL3);

      card = new CardLayout();
      middleP = new JPanel();
      middleP.setLayout(card);
      middleP.add(new HomeEvent1(), "HomeEvent1");
      middleP.add(new HomeEvent2(), "HomeEvent2");
//      middleP.add(backBtn1);
//      middleP.add(nextBtn1);
      setBackground(new Color(255, 255, 255));
      lowP = new JPanel() {
         @Override
         public void paint(Graphics g) {

            Toolkit t = Toolkit.getDefaultToolkit();
            Image bestImg1 = t.getImage("Image/추천메뉴1.png");
            g.drawImage(bestImg1, 0, 0, this.getWidth(), this.getHeight(), this);
         }
      };



      JPanel bn = new JPanel(new GridLayout(1,3));
      bn.add(backBtn1);
      bn.add(nextBtn1);
      bn.add(txtL4);
      bn.setBackground(new Color(255,247,242));
//      backBtn1.setBounds(20, 10, 30, 30);
//      nextBtn1.setBounds(480, 600, 30, 30);

      JPanel wp = new JPanel();
      wp.setLayout(null);
      wp.add(topP);
      wp.add(middleP);
      wp.add(lowP);
      topP.setBounds(0, 0, 520, 150);
      lowP.setBounds(0, 115, 520, 200);
      middleP.setBounds(0, 315, 520, 350);
      wp.setBackground(new Color(255, 255, 255));
      Container c = this.getContentPane();
     p.setPreferredSize(new Dimension(180, 700));
     //lowP.setPreferredSize(new Dimension(600, 200));
      c.add(p,"East");
      c.add("Center", wp);
      c.add(bn,"South");
     // c.add("West", backBtn1);
      c.setBackground(new Color(197, 238, 245));

      setBounds(300, 100, 700, 700);
      setVisible(true);
      setBackground(new Color(197, 238, 245));
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      // 이벤트
      nextBtn1.addActionListener(this);
      backBtn1.addActionListener(this);
      homeBtn.addActionListener(this);
      menuBtn.addActionListener(this);
      stampBtn.addActionListener(this);
      myBtn.addActionListener(this);
      logoutBtn.addActionListener(this);
   }

   // 버튼 이벤트
   @Override
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == backBtn1) {
         card.show(middleP, "HomeEvent1");
      } else if (e.getSource() == nextBtn1) {
         card.show(middleP, "HomeEvent2");
      }

      homeBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            dispose();
            new HomeFrame(id, pwd);
            setVisible(false);
         }
      });

      menuBtn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            dispose();
            new Menu(id, pwd);
            setVisible(false);
         }
      });

      stampBtn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            dispose();
            new StampFrame(id, pwd);
            setVisible(false);
         }
      });

      myBtn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            dispose();
            new InfoFrame(id, pwd);
            setVisible(false);
         }
      });

      logoutBtn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
        	 JOptionPane.showMessageDialog(null, "로그아웃되었습니다.");
            dispose();
            new LoginFrame();
            setVisible(false);
         }
      });
   }

//   public static void main(String[] args) {
//      new HomeFrame();
//   }
}