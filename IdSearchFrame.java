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
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class IdSearchFrame extends JFrame{
	private JLabel nameL, emailL, emailcheckL;
	private JTextField nameT, emailT, emailcheckT;
	private RoundedButton sendBtn, checkBtn, okBtn, cancelBtn;
	static int num = (int)((Math.random()*8999)+1000);
	boolean idok, emailok = false;
	private Image img2;
	
	public IdSearchFrame() {
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

	       
		nameL = new JLabel("이름");
		emailL = new JLabel("이메일 입력");
		emailcheckL = new JLabel("인증번호 입력");
		
		nameT = new JTextField();
		emailT = new JTextField();
		emailcheckT = new JTextField();
		
		sendBtn = new RoundedButton("발송");
		checkBtn = new RoundedButton("인증");
		okBtn = new RoundedButton("확인");
		cancelBtn = new RoundedButton("취소");
		
		nameL.setFont(new Font("안동엄마까투리", Font.BOLD, 17));
		emailL.setFont(new Font("안동엄마까투리", Font.BOLD, 17));
		emailcheckL.setFont(new Font("안동엄마까투리", Font.BOLD, 17));
		nameT.setFont(new Font("안동엄마까투리", Font.BOLD, 17));
		emailT.setFont(new Font("안동엄마까투리", Font.BOLD, 17));
		emailcheckT.setFont(new Font("안동엄마까투리", Font.BOLD, 17));
	
		
		nameL.setBounds(210, 290, 80, 40);
	    nameT.setBounds(260, 290, 170, 40);

	    emailL.setBounds(160, 350, 80, 40);
	    emailT.setBounds(260, 350, 170, 40);
	    
	    emailcheckL.setBounds(150, 410, 120, 40);
	    emailcheckT.setBounds(260, 410, 170, 40);
	    
	    sendBtn.setBounds(450, 350, 70, 40);
	    checkBtn.setBounds(450, 410, 70, 40);
	    okBtn.setBounds(270, 460, 70, 40);
	    cancelBtn.setBounds(355, 460, 70, 40);
	     
	    sendBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
	    checkBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
	    okBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16)); 
	    cancelBtn.setFont(new Font("안동엄마까투리", Font.BOLD, 16));
	    background.add(nameL);
	      background.add(nameT);
	      background.add(emailL);
	      background.add(emailT);
	      background.add(emailcheckL);
	      background.add(emailcheckT);
	      
	      background.add(sendBtn);
	      background.add(checkBtn);
	      background.add(okBtn);
	      background.add(cancelBtn);
	     background.setLayout(null);
	     
	     scrollPane = new JScrollPane(background);
	      setContentPane(scrollPane);
	      
	      setTitle("아마스빈 사이렌 오더 프로그램");
	      setBounds(300, 100, 700, 700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 이벤트
	      okBtn.addActionListener(new ActionListener() {
	         @Override
	         public void actionPerformed(ActionEvent e) {
	        	 if (nameT.getText().isEmpty() || emailT.getText().isEmpty() 
	        				|| emailcheckT.getText().isEmpty()) {
	        			JOptionPane.showMessageDialog(null, "모두 작성해주세요");
	        			return;
	        				} else if(emailok == false) {
	        			JOptionPane.showMessageDialog(null, "이메일 인증하세요");
	        			return;
	        		}else {
	        			String name = nameT.getText();
	        			String email = emailT.getText();
	             
	        			// DB
	        			AmasvinDAO dao = AmasvinDAO.getInstance(); //싱글톤으로 바꿈
	        			String idc = dao.idSearchMember(name, email);

	        			if (idc == null) {
	        				JOptionPane.showMessageDialog(null, "정확한 정보를 입력하세요"); 
	        			} else {
	        				JOptionPane.showMessageDialog(null, name + "님 아이디는 "+ idc + "입니다");
	        				 dispose();
	       		          new LoginFrame();
	       		          setVisible(false);
	        			}
	        		}
	         	}
	      });
	      
	   // 이벤트
	      cancelBtn.addActionListener(new ActionListener() {
	      
	         @Override
	         public void actionPerformed(ActionEvent e) {
	            dispose();
	            new LoginFrame();
	            setVisible(false);
	         }
	      });
	      
	      sendBtn.addActionListener(new ActionListener() {
		      
		         @Override
		         public void actionPerformed(ActionEvent e) {
		        	 String user_email = emailT.getText();
		             
		             EmailCheck ec = new EmailCheck(user_email,num);
		            
		             JOptionPane.showMessageDialog(null, "인증번호가 발송되었습니다"+num);
		         }
		      });
	      
	      checkBtn.addActionListener(new ActionListener() {
	          @Override
	          public void actionPerformed(ActionEvent e) { 
	           if(num == Integer.parseInt(emailcheckT.getText())) {
	        	   emailok=true;
	              JOptionPane.showMessageDialog(null, "이메일 인증 성공");
	           }else {
	        	  emailok=false;
	              JOptionPane.showMessageDialog(null, "인증번호가 일치하지 않습니다."+"\n"+ "다시 입력하세요.");
	              emailcheckT.setText("");
	              //writeBtn.setEnabled(false);
	           }           
	          }
	       });    
	}

}
