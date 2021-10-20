package miniproject1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PayFrame extends JFrame {
   private JLabel nameL, cardL, cardnumL, phoneL, emailL, totalL,couponL2,couponL3,couponL4,couponL5;
   private JLabel usernameL, userphoneL, useremailL;
   private RoundedButton okBtn, exitBtn, usecoupon;
   private JComboBox<String> combo;
   
   public PayFrame(String id, String pwd, int totalprint, int totalsuprint) {
      AmasvinDAO dao = AmasvinDAO.getInstance(); //싱글톤으로 바꿈
      String name = dao.loginMember(id, pwd);
      String email = dao.UserEmail(id, pwd);
      String phone = dao.UserPhone(id, pwd);
      
      nameL = new JLabel("     결제자 성명");
      cardL = new JLabel("     카드사를 선택해주세요");
      cardnumL = new JLabel("     카드 번호를 입력해주세요");
      phoneL = new JLabel("     연락처");
      emailL = new JLabel("     이메일");
      totalL = new JLabel("     총 결제금액");
      
      couponL2 = new JLabel("음료 1잔 무료 쿠폰 ");
      couponL3 = new JLabel("총");
       int cnum = dao.couponnum(id, pwd);
      couponL4 = new JLabel(String.valueOf(cnum));
      couponL5 = new JLabel("장 보유");
      usecoupon= new RoundedButton("사용하기");
      
      
      JPanel p1 = new JPanel(new GridLayout(1,2));
      JPanel p2 = new JPanel(new GridLayout(1,2));
      JPanel p3 = new JPanel(new GridLayout(1,2));
      JPanel p4 = new JPanel(new GridLayout(1,2));
      JPanel p5 = new JPanel(new GridLayout(1,2));
      JPanel p6 = new JPanel(new GridLayout(1,2));
      p1.setBackground(new Color(255,255,255));
      p2.setBackground(new Color(255,255,255));
      p3.setBackground(new Color(255,255,255));
      p4.setBackground(new Color(255,255,255));
      p5.setBackground(new Color(255,255,255));
      p6.setBackground(new Color(255,255,255));
      p1.add(nameL);
      p2.add(cardL);
      p3.add(cardnumL);
      p4.add(phoneL);
      p5.add(emailL);
      p6.add(totalL);
      
      String[] card = {"국민","비씨","신한","롯데","우리","하나","하나(구)외환","농협","기업"};
      JPanel cardnumcoupon = new JPanel(new GridLayout(2,1));
      cardnumcoupon.setBackground(new Color(255,255,255));
      JLabel hyphen1 = new JLabel("-");
      JLabel hyphen2 = new JLabel("-");
      JLabel hyphen3 = new JLabel("-");
      JTextField cn1 = new JTextField(4);
      JTextField cn2 = new JTextField(4);
      JTextField cn3 = new JTextField(4);
      JTextField cn4 = new JTextField(4);
      JPanel c1 = new JPanel();
      c1.setBackground(new Color(255,255,255));
      JPanel c2 = new JPanel();
      c2.setBackground(new Color(255,255,255));
      c1.add(cn1);
      c1.add(hyphen1);
      c1.add(cn2);
      c1.add(hyphen2);
      c1.add(cn3);
      c1.add(hyphen3);
      c1.add(cn4);
   
      c2.add(couponL2);
      c2.add(couponL3);
      c2.add(couponL4);
      c2.add(couponL5);
      c2.add(usecoupon);
      cardnumcoupon.add(c1);
      cardnumcoupon.add(c2);
      
      
      combo = new JComboBox<String>(card);
      usernameL = new JLabel(name);
      useremailL = new JLabel(email);
      userphoneL = new JLabel(phone);
      String total ="5000원";
      JLabel l = new JLabel(String.valueOf(totalprint)+"원");
      p1.add(usernameL);
      p2.add(combo);
      p3.add(cardnumcoupon);
      p4.add(userphoneL);
      p5.add(useremailL);
      p6.add(l);
      JPanel p7 = new JPanel(new GridLayout(6,1));
      p7.setBackground(new Color(255,255,255));
      p7.add(p1);
      p7.add(p2);
      p7.add(p3);
      p7.add(p4);
      p7.add(p5);
      p7.add(p6);
      
      
      Container c = getContentPane();
      
      
      c.setBackground(new Color(255,255,255));
      c.add(p7, "Center");
      
      JPanel btn = new JPanel();
      btn.setBackground(new Color(255,255,255));
      okBtn = new RoundedButton("결제요청");
      exitBtn = new RoundedButton("닫기");
      btn.add(okBtn);
      btn.add(exitBtn);
      
      c.add(btn,"South");
      
      nameL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
      cardL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
      cardnumL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
      phoneL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
      emailL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
      totalL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
      couponL2.setFont(new Font("안동엄마까투리", Font.BOLD, 12));
      couponL3.setFont(new Font("안동엄마까투리", Font.BOLD, 12));
      couponL4.setFont(new Font("안동엄마까투리", Font.BOLD, 12));
      couponL5.setFont(new Font("안동엄마까투리", Font.BOLD, 12));
      //usernameL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
      //userphoneL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
      //useremailL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
      //cardnumT.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
      okBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
      exitBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
      usecoupon.setFont(new Font("안동엄마까투리", Font.BOLD, 12));
      
      setVisible(true);
      setBounds(400, 200, 500, 600);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               if (cn1.getText().isEmpty() || cn2.getText().isEmpty() || cn3.getText().isEmpty()
                     || cn4.getText().isEmpty()) {
                  JOptionPane.showMessageDialog(null, "카드번호를 입력해주세요");
                  return;
               } else {
                  JOptionPane.showMessageDialog(null, "결제가 완료되었습니다. 감사합니다");
                  AmasvinDAO dao = AmasvinDAO.getInstance();
                  for (int i = 1; i <= totalsuprint; i++) {
                     dao.addstamp(id, pwd);
                  }
                  dispose();

                  try {
                     new HomeTimer(id, pwd);
                  } catch (InterruptedException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                  }

                  setVisible(false);
               }
            }
         });
      
      usecoupon.addActionListener(new ActionListener() {@Override
         public void actionPerformed(ActionEvent e) { 
         if(cnum!=0) {
         JOptionPane.showMessageDialog(null, "쿠폰 사용으로 결제 완료되었습니다."+"\n"+ "감사합니다.");
         AmasvinDAO dao = AmasvinDAO.getInstance();
         dao.resetcoupon(id, pwd);
         dispose();
         new HomeFrame(id,pwd);
         setVisible(false);
         }else {
            JOptionPane.showMessageDialog(null, "쿠폰이 존재하지 않습니다");
            return;
         }
         
         
      }});
      exitBtn.addActionListener(new ActionListener() {@Override
         public void actionPerformed(ActionEvent e) { 
         
         dispose();
            new HomeFrame(id, pwd);
            setVisible(false);
         
         
      }});
      
   }
   
   
}