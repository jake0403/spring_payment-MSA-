package com.teamfive.payment.service;

import java.util.Date;
import java.util.Properties;

import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamfive.payment.web.dto.PaymentSaveRequestDto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
@Getter
public class EmailSend {
	
	private String product;
	private String buyerEmail;
	
	@Transactional
	public void sendEmail(PaymentSaveRequestDto requestDto) {
		this.buyerEmail = requestDto.getBuyerEmail();
		this.product = requestDto.getProduct();
		if (product == "data") {
			product = "Hunch 데이터";
		}else {
			product = "Hunch 데이터분석 결과";
		}
		
		// 인코딩 형식 UTF-8
		final String bodyEncoding = "UTF-8";
		
		String subject = "Hunch 서비스를 이용해주셔서 감사합니다.";
		String fromEmail = "jake940403@gmail.com";
		String fromUsername = "HUNCH MANAGER";
		String toEmail = buyerEmail; /// 결제 후 입력된 이메일 값
		
		// 첨부파일 주소
		//------------------------------------------------------
		String filename = "E:/hunch_rawdata.csv";
		//------------------------------------------------------
		
		final String username = "jake940403@gmail.com";
		final String password = "ixmzwvmdzlvjqtzb";
		
		// 메일에 출력할 텍스트
		StringBuffer sb = new StringBuffer();
		sb.append("<h3> 결제해주셔서 감사합니다.</h3>");
		sb.append("<h4> 결제 내용:</h4>");
		sb.append(product);
		String html = sb.toString();
		
		// 메일 옵션 설정
		Properties props = new Properties(); 		//메일 환경 변수 설정
		props.put("mail.transport.protocol", "smtp");	//메일 프로토콜 = gmail이기 때문에 smpt 사용
		props.put("mail.smtp.host", "smtp.gmail.com");	//메일 호스트 주소 설정
	    props.put("mail.smtp.port", "465");		// port는 465
	    props.put("mail.smtp.auth", "true");	// ID Password 설정 필요
	    
	    //SSL 사용할 경우 설정
	    props.put("mail.smtp.quitwait", "false");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.socketFactory.fallback", "false");
	    

	    
	    try {
	        // 메일 서버  인증 계정 설정
	        Authenticator auth = new Authenticator() {
	          protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	          }
	        };
	        
	        // 메일 세션 생성
	        Session session = Session.getInstance(props, auth);
	        
	        // 메일 송/수신 옵션 설정
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(fromEmail, fromUsername));
	        message.setRecipients(RecipientType.TO, InternetAddress.parse(toEmail, false));
	        message.setSubject(subject);
	        message.setSentDate(new Date());
	        
	        // 메일 콘텐츠 설정
	        Multipart mParts = new MimeMultipart();
	        
	        //----------------------------------------------
	        
	        //----------------------------------------------
	        
	        MimeBodyPart mTextPart = new MimeBodyPart();
	        MimeBodyPart mFilePart = new MimeBodyPart();
	        
	        
	   
	        // 메일 콘텐츠 - 내용
	        mTextPart.setText(html, bodyEncoding, "html");
	        mParts.addBodyPart(mTextPart);
	        // 첨부파일-  내용
	        DataSource source = new FileDataSource(filename);
	        mFilePart.setDataHandler(new DataHandler(source));
	        mFilePart.setFileName("Hunch DATA");
	        mParts.addBodyPart(mFilePart);
	              
	        // 메일 콘텐츠 설정
	        message.setContent(mParts);
	        
	        // MIME 타입 설정
	        MailcapCommandMap MailcapCmdMap = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
	        MailcapCmdMap.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
	        MailcapCmdMap.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
	        MailcapCmdMap.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
	        MailcapCmdMap.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
	        MailcapCmdMap.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
	        CommandMap.setDefaultCommandMap(MailcapCmdMap);
	   
	        // 메일 발송
	        Transport.send( message );
	        
	      } catch ( Exception e ) {
	        e.printStackTrace();
	      }
	    }
	
	

	}


