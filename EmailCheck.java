package miniproject1;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.AddressException;


public class EmailCheck {
//	private String user_email;
//	private int num;
//	
public EmailCheck(String user_email, int num) {
//	this.num = num;
//	this.user_email =user_email;
    String user = "1103kimhyejin@gmail.com"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
    String password = "Gurumi@12";   // 패스워드
 
    // SMTP 서버 정보를 설정한다.
    Properties prop = new Properties();
  
    prop.put("mail.smtp.host", "smtp.gmail.com"); 
    prop.put("mail.smtp.port", 465); 
    prop.put("mail.smtp.auth", "true"); 
    prop.put("mail.smtp.ssl.enable","true"); 
    prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
    prop.put("mail.smtp.starttls.required", "true");
    prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

    Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password);
        }
    });

    try {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(user));

        //수신자메일주소
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(user_email)); 

        // Subject
        message.setSubject("아마스빈 사이렌 오더 회원가입을 위한 인증번호 발송"); //메일 제목을 입력

        // Text
        message.setText("아래에 인증번호를 회원가입창의 인증번호란에 입력해주세요"+"\n"+"인증번호 : "+num);    //메일 내용을 입력

        // send the message
        Transport.send(message); ////전송
        System.out.println("message sent successfully...");
    } catch (AddressException e) {
        e.printStackTrace();
    } catch (MessagingException e) {
        e.printStackTrace();
    }
}


}
/*
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


                       public static  String FROM =  "znzl9dnjwnj@naver.com";
                       public static   String FROMNAME = "Crazy Acade 가입 인증번호메일";
                       public static  String TO = "email";
   public static final  String SMTP_USERNAME = "아이디"
   public static final  String SMTP_PASSWORD = "비번"
    
    static final String HOST = "smtp.naver.com";
    static final int PORT = 587;
                           static final String SUBJECT = "메일 제목";

            
    
    public EmailCheck(GameJoin gameJoin, String num) {
       try {
          TO = gameJoin.emailcheckT.getText().trim();
          Properties props = System.getProperties();
          props.put("mail.transport.protocol", "smtp");
          props.put("mail.smtp.port", PORT); 
          props.put("mail.smtp.starttls.enable", "true");
          props.put("mail.smtp.auth", "true");
          Session session = Session.getDefaultInstance(props);
         
          MimeMessage msg = new MimeMessage(session);
          msg.setFrom(new InternetAddress(FROM, FROMNAME));
          //받는사람 설정 
          msg.setRecipient(Message.RecipientType.TO, new InternetAddress(TO));
          msg.setSubject(SUBJECT);
          msg.setContent(String.join(
                  System.getProperty("line.separator"),
                  "<h1>가입 인증 비밀번호</h1>",
                  "<p>"+
                  num +                 "</p>"
                  ), "text/html;charset=euc-kr");
          
          Transport transport = session.getTransport();
          try {
             System.out.println("Sending...");
             
             transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
             transport.sendMessage(msg, msg.getAllRecipients());
             System.out.println("Email sent!");
          } catch (Exception ex) {
             ex.printStackTrace();
          }finally {
             transport.close();
          }
       }catch(Exception e) {
          e.printStackTrace();
       }
    }
}*/