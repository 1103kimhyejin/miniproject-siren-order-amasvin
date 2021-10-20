package miniproject1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class WriteFrame extends JFrame {
   private JLabel nameL, idL, pwdL, pwdcheckL, emailL, emailcheckL, phoneL;
   private JTextField nameT, idT, emailT, emailcheckT, phoneT;
   private JPasswordField pwdT, pwdcheckT;
   private RoundedButton checkBtn, pwdcheckBtn, emailcheckBtn, okBtn, writeBtn, resetBtn, loginBtn;
   static int num = (int) ((Math.random() * 8999) + 1000);
   boolean idok, pwdok, emailok = false;

   // static int count=0;
   public WriteFrame() {
      JFrame jf = new JFrame();
      setLayout(null);

      // Label
      JPanel p = new JPanel();
      p.setLayout(null);

      nameL = new JLabel("이름");
      nameL.setBounds(133, 50, 70, 50);
      p.add(nameL);

      idL = new JLabel("아이디");
      idL.setBounds(115, 120, 70, 50);
      p.add(idL);

      pwdL = new JLabel("비밀번호");
      pwdL.setBounds(98, 190, 70, 50);
      p.add(pwdL);

      pwdcheckL = new JLabel("비밀번호 재입력");
      pwdcheckL.setBounds(48, 260, 130, 50);
      p.add(pwdcheckL);

      emailL = new JLabel("이메일");
      emailL.setBounds(113, 330, 100, 50);
      p.add(emailL);

      emailcheckL = new JLabel("인증번호 입력");
      emailcheckL.setBounds(70, 400, 100, 50);
      p.add(emailcheckL);

      phoneL = new JLabel("휴대폰 번호");
      phoneL.setBounds(90, 470, 100, 50);
      p.add(phoneL);

      // TextField
      nameT = new JTextField();
      nameT.setBounds(200, 50, 250, 50);
      p.add(nameT);

      idT = new JTextField();
      idT.setBounds(200, 120, 250, 50);
      p.add(idT);

      pwdT = new JPasswordField();
      pwdT.setBounds(200, 190, 250, 50);
      p.add(pwdT);

      pwdcheckT = new JPasswordField();
      pwdcheckT.setBounds(200, 260, 250, 50);
      p.add(pwdcheckT);

      emailT = new JTextField();
      emailT.setBounds(200, 330, 250, 50);
      p.add(emailT);

      emailcheckT = new JTextField();
      emailcheckT.setBounds(200, 400, 250, 50);
      p.add(emailcheckT);

      phoneT = new JTextField();
      phoneT.setBounds(200, 470, 250, 50);
      p.add(phoneT);

      // Font
      Font labelF = new Font("안동엄마까투리", Font.BOLD, 18);
      Font textF = new Font("안동엄마까투리", Font.PLAIN, 18);
      Font ButtonF = new Font("안동엄마까투리", Font.BOLD, 17);

      nameL.setFont(labelF);
      nameT.setFont(textF);
      idL.setFont(labelF);
      idT.setFont(textF);
      pwdL.setFont(labelF);
     // pwdT.setFont(textF);
      pwdcheckL.setFont(labelF);
     // pwdcheckT.setFont(textF);
      emailL.setFont(labelF);
      emailT.setFont(textF);
      emailcheckL.setFont(labelF);
      emailcheckT.setFont(textF);
      phoneL.setFont(labelF);
      phoneT.setFont(textF);

      // Button
      writeBtn = new RoundedButton("등록");
      resetBtn = new RoundedButton("다시 작성");
      checkBtn = new RoundedButton("중복체크");
      loginBtn = new RoundedButton("로그인창");

      checkBtn.setBounds(480, 120, 125, 50);
      checkBtn.setBackground(new Color(255, 255, 204));
      p.add(checkBtn);
      pwdcheckBtn = new RoundedButton("일치 확인");
      pwdcheckBtn.setBounds(480, 260, 125, 50);
      pwdcheckBtn.setBackground(new Color(255, 255, 204));
      p.add(pwdcheckBtn);
      emailcheckBtn = new RoundedButton("인증번호 발송");
      emailcheckBtn.setBounds(480, 330, 125, 50);
      emailcheckBtn.setBackground(new Color(255, 255, 204));
      p.add(emailcheckBtn);
      okBtn = new RoundedButton("확인");
      okBtn.setBounds(480, 400, 125, 50);
      okBtn.setBackground(new Color(255, 255, 204));
      p.add(okBtn);

      writeBtn.setFont(ButtonF);
      resetBtn.setFont(ButtonF);
      checkBtn.setFont(ButtonF);
      pwdcheckBtn.setFont(ButtonF);
      emailcheckBtn.setFont(ButtonF);
      okBtn.setFont(ButtonF);
      loginBtn.setFont(ButtonF);

      writeBtn.setBounds(80, 560, 150, 60);
      resetBtn.setBounds(270, 560, 150, 60);
      loginBtn.setBounds(460, 560, 150, 60);

      JPanel p2 = new JPanel();
      p2.setBackground(new Color(195, 219, 242));
      p2.add(writeBtn);
      writeBtn.setBackground(new Color(255, 255, 204));

      p2.add(resetBtn);
      resetBtn.setBackground(new Color(255, 255, 204));
      loginBtn.setBackground(new Color(255, 255, 204));

      Container c = getContentPane();
      
      c.setBackground(new Color(197, 238, 245));
      c.add("North", p);
      c.add("South", p2);

      c.add(nameL);
      c.add(nameT);
      c.add(idL);
      c.add(idT);
      c.add(checkBtn);
      c.add(pwdL);
      c.add(pwdT);
      c.add(pwdcheckL);
      c.add(pwdcheckT);
      c.add(pwdcheckBtn);
      c.add(emailL);
      c.add(emailT);
      c.add(emailcheckBtn);
      c.add(emailcheckL);
      c.add(emailcheckT);
      c.add(okBtn);
      c.add(phoneL);
      c.add(phoneT);
      c.add(writeBtn);
      c.add(resetBtn);
      c.add(loginBtn);

      setTitle("아마스빈 사이렌 오더 프로그램");
      setBounds(300, 100, 700, 700);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      writeBtn.addActionListener(new ActionListener() { // ---> db에 다 not null추가필요!!한가???
         @Override
         public void actionPerformed(ActionEvent e) {

            if (nameT.getText().isEmpty() || idT.getText().isEmpty() || pwdT.getText().isEmpty()
                  || emailT.getText().isEmpty() || phoneT.getText().isEmpty() || emailcheckT.getText().isEmpty()
                  || pwdcheckT.getText().isEmpty()) {
               JOptionPane.showMessageDialog(null, "모두 작성해주세요");
               return;
            } else if (idok == false) {
               JOptionPane.showMessageDialog(null, "아이디 중복 확인 하세요");
               return;
            } else if (pwdok == false) {
               JOptionPane.showMessageDialog(null, "비밀번호 확인 하세요");
               return;
            } else if (emailok == false) {
               JOptionPane.showMessageDialog(null, "이메일 인증하세요");
               return;
            } else
               JOptionPane.showMessageDialog(null, "회원가입 되었습니다");

            // 데이터
            String name = nameT.getText();
            String id = idT.getText();
            String pwd = pwdT.getText();
            String email = emailT.getText();
            String phone = phoneT.getText();

            AmasvinDTO dto = new AmasvinDTO();
            dto.setName(name);
            dto.setId(id);
            dto.setPwd(pwd);
            dto.setEmail(email);
            dto.setPhone(phone);

            // DB
            AmasvinDAO dao = new AmasvinDAO();
            int su = dao.insertMember(dto);
            dispose();
            new LoginFrame();
            setVisible(false);
         }
      });

      resetBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            nameT.setText("");
            idT.setText("");
            pwdT.setText("");
            emailT.setText("");
            phoneT.setText("");
            emailcheckT.setText("");
            pwdcheckT.setText("");
         }
      });

      checkBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {

            if (idT.getText().isEmpty()) {
               JOptionPane.showMessageDialog(null, "아이디를 입력 해주세요");
               return;
            } else {
               AmasvinDAO dao = AmasvinDAO.getInstance(); // 계속 new 할 수 없으니 싱글톤필요
               String id = idT.getText();
               String idc = dao.idcheck(id);
               if (idc == null) {
                  idok = true;
                  JOptionPane.showMessageDialog(null, "사용 가능한 아이디입니다");
               } else {
                  idok = false;
                  JOptionPane.showMessageDialog(null, "이미 사용 중인 아이디입니다");
                  idT.setText("");

               }
            }
         }
      });

      emailcheckBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (emailT.getText().isEmpty()) {
               JOptionPane.showMessageDialog(null, "이메일을 입력 해주세요");
               return;
            }

            String user_email = emailT.getText();

            EmailCheck ec = new EmailCheck(user_email, num);

            JOptionPane.showMessageDialog(null, "인증번호가 발송되었습니다" + num);
         }
      });

      pwdcheckBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (pwdcheckT.getText().isEmpty()) {
               JOptionPane.showMessageDialog(null, "비밀번호를 입력 해주세요");
               return;
            } else {
               if (pwdT.getText().equals(pwdcheckT.getText())) {
                  pwdok = true;
                  JOptionPane.showMessageDialog(null, "비밀번호가 일치합니다");
               } else {
                  pwdok = false;
                  JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다." + "\n" + "다시 입력하세요.");
                  pwdcheckT.setText("");
                  // writeBtn.setEnabled(false);
               }
            }
         }
      });

      okBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (emailcheckT.getText().isEmpty()) {
               JOptionPane.showMessageDialog(null, "인증번호를 입력해주세요");
            } else {
               if (num == Integer.parseInt(emailcheckT.getText())) {
                  emailok = true;

                  JOptionPane.showMessageDialog(null, "이메일 인증 성공");

               } else {
                  emailok = false;
                  JOptionPane.showMessageDialog(null, "인증번호가 일치하지 않습니다." + "\n" + "다시 입력하세요.");
                  emailcheckT.setText("");
                  // writeBtn.setEnabled(false);
               }
            }
         }
      });
      loginBtn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            dispose();
            new LoginFrame();
            setVisible(false);

         }
      });
   }
}
