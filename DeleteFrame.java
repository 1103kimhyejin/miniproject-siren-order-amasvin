package miniproject1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DeleteFrame extends JFrame {
	private JLabel idL;
	private JTextField idT;
	private RoundedButton cancelBtn, pwdcheckBtn, writeBtn, resetBtn;
	boolean idok, pwdok, emailok = false;
	private Image img2;

	public DeleteFrame(String id, String pwd) {
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

		img2 = Toolkit.getDefaultToolkit().getImage("Image/아마스빈캐릭터.png");

		AmasvinDAO dao = AmasvinDAO.getInstance();
		String name = dao.loginMember(id, pwd);
		setTitle("반갑습니다, " + name + "님 아마스빈입니다.");

		JFrame jf = new JFrame();
		setLayout(null);

		// Label
		JPanel p = new JPanel();
		p.setLayout(null);

		idL = new JLabel("탈퇴할 아이디를 입력하세요.");
		idL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		idL.setBounds(240, 300, 200, 30);
		p.add(idL);

		idT = new JTextField();
		idT.setBounds(180, 350, 200, 30);
		idT.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		p.add(idT);

		// Button
		writeBtn = new RoundedButton("탈퇴");
		writeBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		resetBtn = new RoundedButton("다시 작성");
		resetBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		cancelBtn = new RoundedButton("취소");
		cancelBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		pwdcheckBtn = new RoundedButton("아이디 확인");
		pwdcheckBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		pwdcheckBtn.setBounds(400, 350, 115, 30);
		pwdcheckBtn.setBackground(new Color(255, 255, 204));
		p.add(pwdcheckBtn);
		writeBtn.setBounds(170, 400, 100, 50);
		resetBtn.setBounds(290, 400, 100, 50);
		cancelBtn.setBounds(410, 400, 100, 50);

		JPanel p2 = new JPanel();
		p2.setBackground(new Color(195, 219, 242));
		p2.add(writeBtn);
		writeBtn.setBackground(new Color(255, 255, 204));
		p2.add(resetBtn);
		resetBtn.setBackground(new Color(255, 255, 204));
		p2.add(cancelBtn);
		cancelBtn.setBackground(new Color(255, 255, 204));

		background.add(idL);
		background.add(idT);
		background.add(writeBtn);
		background.add(resetBtn);
		background.add(cancelBtn);
		background.add(pwdcheckBtn);
		background.setLayout(null);

		scrollPane = new JScrollPane(background);
		setContentPane(scrollPane);

		setBounds(300, 100, 700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		writeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (idT.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
					return;
				} else if (idok == true) {
					JOptionPane.showMessageDialog(null, "아이디 확인 하세요.");
					return;
				} else {
					String id = idT.getText();

					// DB
					AmasvinDAO dao = AmasvinDAO.getInstance();
					dao.DeleteMember(id);

					JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다.");
					dispose();
					new LoginFrame();
					setVisible(false);
				}
			}
		});

		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new HomeFrame(id, pwd);
				setVisible(false);
			}
		});

		resetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				idT.setText("");
			}
		});

		pwdcheckBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AmasvinDAO dao = AmasvinDAO.getInstance(); // 계속 new 할 수 없으니 싱글톤필요
				String id = idT.getText();
				String idc = dao.idcheck(id);
				if (idT.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디를 입력해주세요.");
					return;
				} else if (idc == null) {
					idok = true;
					JOptionPane.showMessageDialog(null, "아이디를 다시 입력하세요.");
					idT.setText("");
					return;
				} else {
					idok = false;
					JOptionPane.showMessageDialog(null, "탈퇴하시면 1주간 가입이 불가능합니다.");
					return;
				}
			}
		});
	}

	public void paint(Graphics g) {
		super.paint(g);
	}
}