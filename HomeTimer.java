package miniproject1;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class HomeTimer extends JFrame implements Runnable {
   private JLabel timer;
   private Image img2;
   int count = 3;
   String id, pwd;

   @Override
   public void run() {
      while (true) {      
         String time = String.format("%02d : %02d", 00 , count);
         timer.setText(time);
         count--;

         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }

         if (count == 0) {
            JOptionPane.showMessageDialog(null, "음료가 완성되었습니다. 픽업해주세요.");
            dispose();
            new HomeFrame(id, pwd);
            HomeTimer.this.setVisible(false);
         }

      }
   }

   public HomeTimer(String id, String pwd) throws InterruptedException {
      JScrollPane scrollPane;
      ImageIcon icon;
      
      icon = new ImageIcon("Image/아마스빈배경.jpg");

      // 배경 Panel 생성후 컨텐츠페인으로 지정
      JPanel background = new JPanel() {
         public void paintComponent(Graphics g) {

            g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);

            setOpaque(false); // 그림을 표시하게 설정,투명하게 조절
            super.paintComponent(g);
         }
      };

      // setLayout(null);
      img2 = Toolkit.getDefaultToolkit().getImage("Image/아마스빈캐릭터.png");
      
      this.id = id;
      this.pwd = pwd;
//      Container c = this.getContentPane();
      timer = new JLabel();
      timer.setFont(new Font("안동엄마까투리", Font.BOLD, 55));
      timer.setBounds(250, 330, 200, 100);
      background.add(timer);
      background.setLayout(null);

      Thread t;
      t = new Thread(HomeTimer.this);
      t.start();
//      Timer timer = new Timer();
//      TimerTask timerTask = new TimerTask( )
//      @Override
//      public void run() {
//         JOptionPane.showMessageDialog(null, "음료 제조가 완료되었습니다.");
//         dispose();
//             new HomeFrame(id, pwd);
//             setVisible(false);
//      }
//      
//      };
//      timer.schedule(timerTask,1000,1000);

      AmasvinDAO dao = AmasvinDAO.getInstance();
      // String name = dao.loginMember(id, pwd);
      // setTitle("반갑습니다, "+ name+"님 아마스빈입니다");

      scrollPane = new JScrollPane(background);
      setContentPane(scrollPane);
      
      setBounds(300, 100, 700, 700);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
//
//      homeBtn.setEnabled(false);
//      menuBtn.setEnabled(false);
//      stampBtn.setEnabled(false);
//      myBtn.setEnabled(false);
//      logoutBtn.setEnabled(false);
//
//      // 버튼 이벤트
//      homeBtn.addActionListener(new ActionListener() {
//         @Override
//         public void actionPerformed(ActionEvent e) {
//            dispose();
//            new HomeFrame(id, pwd);
//            setVisible(false);
//         }
//      });
//
//      menuBtn.addActionListener(new ActionListener() {
//
//         @Override
//         public void actionPerformed(ActionEvent e) {
//            dispose();
//            new Menu(id, pwd);
//            setVisible(false);
//         }
//      });
//
//      stampBtn.addActionListener(new ActionListener() {
//
//         @Override
//         public void actionPerformed(ActionEvent e) {
//            dispose();
//            new StampFrame(id, pwd);
//            setVisible(false);
//         }
//      });
//
//      myBtn.addActionListener(new ActionListener() {
//
//         @Override
//         public void actionPerformed(ActionEvent e) {
//            dispose();
//            // new (id, pwd);
//            setVisible(false);
//         }
//      });
//
//      logoutBtn.addActionListener(new ActionListener() {
//
//         @Override
//         public void actionPerformed(ActionEvent e) {
//            dispose();
//            // new (id, pwd);
//            setVisible(false);
//         }
//      });
//
//   }
//   public static void main(String[] args) throws InterruptedException {
//      new HomeTimer();
//   }
}
   public void paint(Graphics g) {
      super.paint(g);

      g.drawImage(img2, 20, 400, 680, 350, this);
   }
}