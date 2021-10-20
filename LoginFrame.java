package miniproject1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;



public class LoginFrame extends JFrame {
   private Image img, img2;
   private JLabel idL, pwdL;
   private JTextField idT;
   private JPasswordField pwdT;
   private RoundedButton loginBtn, writeBtn, idpwdsearchBtn;
  // private WriteFrame writepanel;
   int stamp;
 
   public LoginFrame() {
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

      img = Toolkit.getDefaultToolkit().getImage("Image/아마스빈로고.png");
      img2 = Toolkit.getDefaultToolkit().getImage("Image/아마스빈캐릭터.png");

      idL = new JLabel("아이디");
      idL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
      pwdL = new JLabel("비밀번호");
      pwdL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));


      idT = new JTextField();
      idT.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
      pwdT = new JPasswordField();
      //pwdT.setFont(new Font("안동엄마까투리", Font.BOLD, 16));

      loginBtn = new RoundedButton("로그인");
      loginBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
      writeBtn = new RoundedButton("회원가입");
      writeBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 15));
      idpwdsearchBtn = new RoundedButton("아이디/비밀번호 찾기");
      idpwdsearchBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 15));
      
      background.add(idL);
      background.add(idT);
      background.add(pwdL);
      background.add(pwdT);
      
      background.add(loginBtn);
      background.add(writeBtn);
      background.add(idpwdsearchBtn);
      background.setLayout(null);
      
      idL.setBounds(175, 300, 80, 40);
      idT.setBounds(230, 300, 170, 40);
      
      pwdL.setBounds(165, 350, 80, 40);
      pwdT.setBounds(230, 350, 170, 40);
      
      loginBtn.setBounds(420, 300, 100, 90);
      writeBtn.setBounds(170, 420, 160, 30);
      idpwdsearchBtn.setBounds(340, 420, 170, 30);
      
//      loginBtn.setBackground(new Color(220,244,248));
//      writeBtn.setBackground(new Color(220,244,248));
//      idpwdsearchBtn.setBackground(new Color(220,244,248));

      loginBtn.setBackground(new Color(255, 255, 204));
      writeBtn.setBackground(new Color(255, 255, 204));
      idpwdsearchBtn.setBackground(new Color(255, 255, 204));
      
      
      scrollPane = new JScrollPane(background);
      setContentPane(scrollPane);

      setTitle("아마스빈 사이렌 오더 프로그램");
      setBounds(300, 100, 700, 700);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      // 이벤트
      writeBtn.addActionListener(new ActionListener() {
      
         @Override
         public void actionPerformed(ActionEvent e) {
            dispose();
            new WriteFrame();
            setVisible(false);
         }
      });
      
      loginBtn.addActionListener(new ActionListener() {
          
          @Override
          public void actionPerformed(ActionEvent e) {
              String id = idT.getText();
              String pwd =pwdT.getText();

              // DB
              
              AmasvinDAO dao = AmasvinDAO.getInstance(); //싱글톤으로 바꿈
              String name = dao.loginMember(id, pwd);

              if (name == null) {
                 JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 맞지 않습니다"); 
              } else {
              
                 JOptionPane.showMessageDialog(null, name + "님 로그인"); 
                   dispose();
                     new HomeFrame(id, pwd);
                     setVisible(false);
              }
          }
       });
      
      idpwdsearchBtn.addActionListener(new ActionListener() {
          
          @Override
          public void actionPerformed(ActionEvent e) {
             dispose();
             new SearchFrame();
             setVisible(false);
              }
          
       });
   }

public void paint(Graphics g) {
      super.paint(g);
      
      g.drawImage(img2, 20, 400, 680, 350, this);
   }

}