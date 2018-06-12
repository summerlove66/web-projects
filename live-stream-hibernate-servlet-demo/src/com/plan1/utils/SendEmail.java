package com.plan1.utils;

import java.util.Date;  
import java.util.Properties;  
  
import javax.mail.Authenticator;  
import javax.mail.Message;  
import javax.mail.MessagingException;  
import javax.mail.PasswordAuthentication;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  
  
  
/** 
 * 
 * @author Qixuan.Chen 
 */  
public class SendEmail {  
  
    public static final String HOST = "smtp.163.com";  
//    public static final String PROTOCOL = "smtp";    
//    public static final int PORT = 25;  
  
    public static final String FROM = "xxxx@163.com";//发件人的email  
    public static final String PWD = "xxxx";//发件人密码  
 
  
    /** 
     * 获取Session 
     * @return 
     */  
    private static Session getSession() {  
        Properties props = new Properties();  
        props.put("mail.smtp.host", HOST);//设置服务器地址  
//        props.put("mail.store.protocol" , PROTOCOL);//设置协议  
//        props.put("mail.smtp.port", PORT);//设置端口  
        props.put("mail.smtp.auth" , "true");  
  
        Authenticator authenticator = new Authenticator() {  
  
            @Override  
            protected PasswordAuthentication getPasswordAuthentication() {  
                return new PasswordAuthentication(FROM, PWD);  
            }  
  
        };  
        Session session = Session.getDefaultInstance(props , authenticator);  
  
        return session;  
    }  
  
    public static void  activateCode(String toEmail , String code) {  
        Session session = getSession();  
        try {  
          //  System.out.println("--send--"+content);  
            // Instantiate a message  
            Message msg = new MimeMessage(session);  
  
            //Set message attributes  
            msg.setFrom(new InternetAddress(FROM));  
            InternetAddress[] address = {new InternetAddress(toEmail)};  
            msg.setRecipients(Message.RecipientType.TO, address);  
            msg.setSubject("账号激活邮件");  
            msg.setSentDate(new Date());  
            String link = "http://localhost:8080/Plan1/activate?code="+code +"email="+toEmail;
            msg.setContent( "<h1>官方激活邮件!点下面链接完成激活操作!</h1><h3><a href='"+ link +"'>"+link +"</h1>", "text/html;charset=utf-8");  
            
  
            //Send the message  
            Transport.send(msg);  
        }  
        catch (MessagingException mex) {  
            mex.printStackTrace();  
        }  
    }  
    public static void ChangePass(String toEmail , String code ) {  
        Session session = getSession();  
        try {  
          //  System.out.println("--send--"+content);  
            // Instantiate a message  
            Message msg = new MimeMessage(session);  
  
            //Set message attributes  
            msg.setFrom(new InternetAddress(FROM));  
            InternetAddress[] address = {new InternetAddress(toEmail)};  
            msg.setRecipients(Message.RecipientType.TO, address);  
            msg.setSubject("密码更换");  
            msg.setSentDate(new Date());  
            String link = "http://localhost:8080/Plan1/changepass?code="+code +"email="+toEmail;
            msg.setContent( "<h1>更换密码点下面链接完成激活操作!</h1><h3><a href='"+ link +"'>"+link +"</h1>", "text/html;charset=utf-8");  
            
  
            //Send the message  
            Transport.send(msg);  
        }  
        catch (MessagingException mex) {  
            mex.printStackTrace();  
        }  
    
    
    
    }
    
  
}  