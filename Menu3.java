package miniproject1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu3 extends JFrame {
	private String menu[];
	private int price[];
	private JButton bt[] = new JButton[6];
	private RoundedButton ok[] = new RoundedButton[6];
	private JTextField su[] = new JTextField[6];
	private RoundedButton minus[] = new RoundedButton[6];
	private RoundedButton plus[] = new RoundedButton[6];
	private JLabel l[] = new JLabel[6];

	private ImageIcon icon1, icon2, icon3, icon4, icon5, icon6;
	private RoundedButton back, order, home, reset, next;
	int total[] = new int[6];
	int count = 0;
	private String show = "";
	int totalprint;
	int totalsuprint;
	int totalsu[] = new int[6];

	public Menu3(String id, String pwd) {
		AmasvinDAO dao = AmasvinDAO.getInstance();
		String name = dao.loginMember(id, pwd);
		setTitle("반갑습니다, " + name + "님 아마스빈입니다");

		String menu[] = { "    딸기버블티  ", "파인애플버블티", "    키위버블티  ", "       사하라     ", "       오렌지     ",
				"     오키베리    " };
		int price[] = { 4500, 4500, 4500, 5500, 4500, 5000 };

		JPanel p1 = new JPanel(new GridLayout(1, 3));
		bt[0] = new JButton(menu[0]);// 버튼 이름 설정
		bt[1] = new JButton(menu[1]);
		bt[2] = new JButton(menu[2]);
		bt[0].setFont(new Font("안동엄마까투리", Font.BOLD, 14));
		bt[1].setFont(new Font("안동엄마까투리", Font.BOLD, 14));
		bt[2].setFont(new Font("안동엄마까투리", Font.BOLD, 14));
		bt[0].setFocusPainted(false);
		icon1 = new ImageIcon("image/13.png");
		icon2 = new ImageIcon("image/14.png");
		icon3 = new ImageIcon("image/15.png");
		p1.add(bt[0]);
		p1.add(bt[1]);
		p1.add(bt[2]);
		bt[0].setIcon(icon1);
		bt[1].setIcon(icon2);
		bt[2].setIcon(icon3);

		JPanel p3 = new JPanel();
		minus[0] = new RoundedButton("-");
		su[0] = new JTextField(5);
		plus[0] = new RoundedButton("+");
		p3.add(minus[0]);
		p3.add(su[0]);
		p3.add(plus[0]);
		JPanel p2 = new JPanel(new GridLayout(3, 1));
		l[0] = new JLabel("                        " + price[0] + "원\n");
		ok[0] = new RoundedButton("확인");
		p2.add(l[0]);
		p2.add(p3);
		p2.add(ok[0]);

		JPanel p4 = new JPanel();
		minus[1] = new RoundedButton("-");
		su[1] = new JTextField(5);
		plus[1] = new RoundedButton("+");
		p4.add(minus[1]);
		p4.add(su[1]);
		p4.add(plus[1]);
		JPanel p5 = new JPanel(new GridLayout(3, 1));
		l[1] = new JLabel("                        "  + price[1] + "원\n");
		ok[1] = new RoundedButton("확인");
		p5.add(l[1]);
		p5.add(p4);
		p5.add(ok[1]);

		JPanel p6 = new JPanel();
		minus[2] = new RoundedButton("-");
		su[2] = new JTextField(5);
		plus[2] = new RoundedButton("+");
		p6.add(minus[2]);
		p6.add(su[2]);
		p6.add(plus[2]);
		JPanel p7 = new JPanel(new GridLayout(3, 1));
		l[2] = new JLabel("                        " + price[2] + "원\n");
		ok[2] = new RoundedButton("확인");
		p7.add(l[2]);
		p7.add(p6);
		p7.add(ok[2]);

		JPanel p8 = new JPanel(new GridLayout(1, 3));
		p8.add(p2);
		p8.add(p5);
		p8.add(p7);

		JPanel p9 = new JPanel(new GridLayout(2, 1));

		Container c = getContentPane();
		p9.add(p1);
		p9.add(p8);

		JPanel p10 = new JPanel(new GridLayout(1, 3));
		bt[3] = new JButton(menu[3]);
		bt[4] = new JButton(menu[4]);
		bt[5] = new JButton(menu[5]);
		bt[3].setFont(new Font("안동엄마까투리", Font.BOLD, 14));
		bt[4].setFont(new Font("안동엄마까투리", Font.BOLD, 14));
		bt[5].setFont(new Font("안동엄마까투리", Font.BOLD, 14));
		
		icon4 = new ImageIcon("image/16.png");
		icon5 = new ImageIcon("image/17.png");
		icon6 = new ImageIcon("image/18.png");
		p10.add(bt[3]);
		p10.add(bt[4]);
		p10.add(bt[5]);
		bt[3].setIcon(icon4);
		bt[4].setIcon(icon5);
		bt[5].setIcon(icon6);

		JPanel p12 = new JPanel();
		minus[3] = new RoundedButton("-");
		su[3] = new JTextField(5);
		plus[3] = new RoundedButton("+");
		p12.add(minus[3]);
		p12.add(su[3]);
		p12.add(plus[3]);
		JPanel p11 = new JPanel(new GridLayout(3, 1));
		l[3] = new JLabel("                        "  + price[3] + "원\n");
		ok[3] = new RoundedButton("확인");
		p11.add(l[3]);
		p11.add(p12);
		p11.add(ok[3]);

		JPanel p13 = new JPanel();
		minus[4] = new RoundedButton("-");
		su[4] = new JTextField(5);
		plus[4] = new RoundedButton("+");
		p13.add(minus[4]);
		p13.add(su[4]);
		p13.add(plus[4]);
		JPanel p14 = new JPanel(new GridLayout(3, 1));
		l[4] = new JLabel("                        " + price[4] + "원\n");
		ok[4] = new RoundedButton("확인");

		p14.add(l[4]);
		p14.add(p13);
		p14.add(ok[4]);

		JPanel p15 = new JPanel();
		minus[5] = new RoundedButton("-");
		su[5] = new JTextField(5);
		plus[5] = new RoundedButton("+");
		p15.add(minus[5]);
		p15.add(su[5]);
		p15.add(plus[5]);
		JPanel p16 = new JPanel(new GridLayout(3, 1));
		l[5] = new JLabel("                        " + price[5] + "원\n ");
		ok[5] = new RoundedButton("확인");
		p16.add(l[5]);
		p16.add(p15);
		p16.add(ok[5]);

		JPanel p17 = new JPanel(new GridLayout(1, 3));
		p17.add(p11);
		p17.add(p14);
		p17.add(p16);
		JPanel p18 = new JPanel(new GridLayout(2, 1));
		p18.add(p10);
		p18.add(p17);

		JPanel p19 = new JPanel(new GridLayout(2, 1));
		p19.add(p9);
		p19.add(p18);
		p19.setPreferredSize(new Dimension(500, 500));
		c.add(p19, "North");

		TextArea ta = new TextArea("       상품명            단가      수량        합계\n", 0, 0,
				TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta.setFont(new Font("안동엄마까투리", Font.BOLD, 16));

		// ta.setText("상품명\t단가\t수량\t합계\n\n");
		ta.setBackground(Color.white);
		ta.setEditable(false);
		ta.setPreferredSize(new Dimension(500, 120));
		c.add(ta, BorderLayout.CENTER);

		JPanel p20 = new JPanel(new GridLayout(1, 5));
		RoundedButton back = new RoundedButton("뒤");
		back.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		RoundedButton order = new RoundedButton("주문");
		order.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		RoundedButton home = new RoundedButton("홈");
		home.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		RoundedButton reset = new RoundedButton("초기화");
		reset.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		RoundedButton next = new RoundedButton("다음");
		next.setFont(new Font("안동엄마까투리", Font.BOLD, 16));

		p20.add(back);
		p20.add(order);
		p20.add(home);
		p20.add(reset);
		p20.add(next);
		p20.setPreferredSize(new Dimension(500, 30));
		c.add(p20, "South");
		
		for(int i=0; i<6; i++) {
			bt[i].setBackground(Color.WHITE);
			l[i].setFont(new Font("안동엄마까투리", Font.BOLD, 16));
			ok[i].setFont(new Font("안동엄마까투리", Font.BOLD, 13));
			su[i].setFont(new Font("안동엄마까투리", Font.BOLD, 13));
			minus[i].setFont(new Font("안동엄마까투리", Font.BOLD, 13));
			plus[i].setFont(new Font("안동엄마까투리", Font.BOLD, 13));
			ok[i].setEnabled(false); //맨처음 메뉴 클릭 전 나머지 버튼 비활성화
			minus[i].setEnabled(false);
			plus[i].setEnabled(false);
		}
		
		setBounds(300, 100, 700, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

		// 버블티 버튼 이벤트
		for (int i = 0; i < 6; i++) {
			int j = i;
			bt[i].addActionListener(new ActionListener() { // 버블티 버튼
				@Override
				public void actionPerformed(ActionEvent e) {
					minus[j].setEnabled(true);
					plus[j].setEnabled(true);
					bt[j].setEnabled(false);
					ok[j].setEnabled(true);
					count = 0;
				}
			});
			// "-" 버튼 이벤트
			minus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (count > 0) {
						count = count - 1;
						su[j].setText(count + "");
						ok[j].setEnabled(true);// 활성화
					} else {
						minus[j].setEnabled(false); // 비활성화
					}
				}
			});

			// "+" 버튼 이벤트
			plus[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					count = count + 1;
					su[j].setText(count + "");
					ok[j].setEnabled(true);
					if (count > 0) {
						minus[j].setEnabled(true);
					}
				}
			});

			// 확인 버튼 이벤트
			ok[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					show = bt[j].getActionCommand(); // 버튼에 담긴 값 반환
					total[j] = price[j] * count;
					totalsu[j] = count;
					ta.append(show + "       " + price[j] + "        " + count + "         " + total[j] + "원" + "\n");
					ok[j].setEnabled(false);
				}
			});
		}

		// 뒤 이벤트
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Menu2(id, pwd);
				setVisible(false);
			}
		});

		// 주문 이벤트
		order.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < total.length; i++) {
					totalprint += total[i];
					totalsuprint += totalsu[i];
				}
				JOptionPane.showMessageDialog(null,
						ta.getText() + "\n" + "총 선택 수량: " + totalsuprint + "개" + "\n" + "총 합계: " + totalprint + "원");

				for (int i = 0; i < 6; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					su[i].setText("0");
					ta.setText("상품명\t단가\t수량\t합계\n\n");

				}
				dispose();
				new PayFrame(id, pwd, totalprint, totalsuprint);
				setVisible(false);
			}
		});
		// 초기화 버튼
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 6; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					su[i].setText("0");
					ta.setText("       상품명            단가      수량        합계\n");

				}
			}
		});

		// 홈버튼
		home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new HomeFrame(id, pwd);
				setVisible(false);
			}
		});

		// 다음 버튼
		next.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "마지막 페이지입니다.");
			}
		});
	}

}