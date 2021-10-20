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

public class CorrectFrame extends JFrame {

	private JLabel nameL, idL, pwdL, pwdcheckL, emailL, phoneL;
	private JPasswordField pwdT, pwdcheckT;
	private JTextField nameT, idT,emailT, phoneT;
	private RoundedButton cancelBtn, pwdcheckBtn, writeBtn, resetBtn;
	boolean idok, pwdok, emailok = false;

	public CorrectFrame(String id, String pwd) {
		AmasvinDAO dao = AmasvinDAO.getInstance();
		String name = dao.loginMember(id, pwd);
		setTitle("반갑습니다, " + name + "님 아마스빈입니다");

		JFrame jf = new JFrame();
		setLayout(null);

		// Label
		JPanel p = new JPanel();
		p.setLayout(null);
		
		nameL = new JLabel("이름");
		nameL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		nameL.setBounds(133, 80, 70, 50);
		p.add(nameL);

		idL = new JLabel("아이디");
		idL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		idL.setBounds(115, 150, 70, 50);
		p.add(idL);

		pwdL = new JLabel("비밀번호");
		pwdL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		pwdL.setBounds(98, 220, 70, 50);
		p.add(pwdL);

		pwdcheckL = new JLabel("비밀번호 재입력");
		pwdcheckL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		pwdcheckL.setBounds(48, 290, 130, 50);
		p.add(pwdcheckL);

		emailL = new JLabel("이메일");
		emailL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		emailL.setBounds(113, 360, 100, 50);
		p.add(emailL);

		phoneL = new JLabel("휴대폰 번호");
		phoneL.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		phoneL.setBounds(90, 430, 100, 50);
		p.add(phoneL);

		// TextField
		nameT = new JTextField();
		nameT.setBounds(200, 80, 250, 50);
		p.add(nameT);

		idT = new JTextField();
		idT.setBounds(200, 150, 250, 50);
		p.add(idT);

		pwdT = new JPasswordField();
		pwdT.setBounds(200, 220, 250, 50);
		p.add(pwdT);

		pwdcheckT = new JPasswordField();
		pwdcheckT.setBounds(200, 290, 250, 50);
		p.add(pwdcheckT);

		emailT = new JTextField();
		emailT.setBounds(200, 360, 250, 50);
		p.add(emailT);

		phoneT = new JTextField();
		phoneT.setBounds(200, 430, 250, 50);
		p.add(phoneT);

		
		nameT.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		idT.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		emailT.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		phoneT.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		
		
		// Button
		writeBtn = new RoundedButton("수정");
		writeBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		resetBtn = new RoundedButton("다시 작성");
		resetBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		pwdcheckBtn = new RoundedButton("일치 확인");
		pwdcheckBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		cancelBtn = new RoundedButton("취소");
		cancelBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
		pwdcheckBtn.setBounds(470, 290, 130, 50);
		pwdcheckBtn.setBackground(new Color(255, 255, 204));
		p.add(pwdcheckBtn);
		writeBtn.setBounds(120, 530, 130, 60);
		resetBtn.setBounds(280, 530, 130, 60);
		cancelBtn.setBounds(440, 530, 130, 60);

		JPanel p2 = new JPanel();
		p2.setBackground(new Color(197, 238, 245));
		p2.add(writeBtn);
		writeBtn.setBackground(new Color(255, 255, 204));

		p2.add(resetBtn);
		resetBtn.setBackground(new Color(255, 255, 204));

		p2.add(cancelBtn);
		resetBtn.setBackground(new Color(255, 255, 204));

		Container c = getContentPane();
		c.setBackground(new Color(197, 238, 245));
		c.add("North", p);
		c.add("South", p2);

		c.add(idL);
		c.add(nameL);
		c.add(nameT);
		c.add(idL);
		c.add(idT);
		c.add(pwdL);
		c.add(pwdT);
		c.add(pwdcheckL);
		c.add(pwdcheckT);
		c.add(pwdcheckBtn);
		c.add(emailL);
		c.add(emailT);
		c.add(phoneL);
		c.add(phoneT);
		c.add(writeBtn);
		c.add(resetBtn);
		c.add(cancelBtn);

		setBounds(300, 100, 700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		writeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (nameT.getText().isEmpty() || idT.getText().isEmpty() || pwdT.getText().isEmpty()
						|| emailT.getText().isEmpty() || phoneT.getText().isEmpty() || pwdcheckT.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "모두 작성해주세요");
					return;
				} else if (pwdok == false) {
					JOptionPane.showMessageDialog(null, "비밀번호 확인 하세요");
					return;
				} else {
					String name = nameT.getText();
					String id = idT.getText();
					String pwd = pwdT.getText();
					String email = emailT.getText();
					String phone = phoneT.getText();

					// DB
					AmasvinDAO dao = AmasvinDAO.getInstance();
					dao.UpdateMember(name, pwd, email, phone, id);
	
					JOptionPane.showMessageDialog(null, "수정 되었습니다");

					dispose();
					new HomeFrame(id, pwd);
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
				nameT.setText("");
				idT.setText("");
				pwdT.setText("");
				emailT.setText("");
				phoneT.setText("");
				pwdcheckT.setText("");
			}
		});

		pwdcheckBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
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
		});

	}
}
