package com.tdl.river.util.models;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomEmail {
	private String host = null;
	private String port = null;
	private String mailFrom = null;
	private String password = null;
	private String attachFiles[] = null;
	private String mailToAddress[] = null;
	private String subject = null;
	private String bodyOfMail = null;
	private String mailCCAddress[] = null;
	private String mailBCCAddress[] = null;
	private String companyID;
	 Logger logger = LoggerFactory.getLogger(CustomEmail.class);


	/*
	 * public CustomEmail(String host,String port,String mailFrom,String password){
	 * setHost(host); setPort(port==null?"587":port); setMailFrom(mailFrom);
	 * setPassword(password);
	 * 
	 * }
	 */
	public boolean sendEmail() throws AddressException, MessagingException{
		boolean retvalue = false;
    	// sets SMTP server properties
    	Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        logger.info("host1"+host);
        properties.put("mail.smtp.port", port);
        logger.info("host2"+host,"port"+port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        logger.info("host3"+host,"port"+port);
        if(companyID!=null && companyID.equals("115")) {
        	  properties.put("mail.user", "noreply");}
        else if(companyID!=null && companyID.equals("128")) {
	        properties.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        properties.setProperty("mail.smtp.socketFactory.fallback", "false");
	        properties.setProperty("mail.smtp.socketFactory.port", "465");
	        properties.put("mail.smtp.ssl.trust", "smtp.zoho.com");
	        properties.put("mail.smtp.startssl.enable", "true");
        }
        else
        	properties.put("mail.user", mailFrom);
        properties.put("mail.password", password);
       /*if(companyID!=null && companyID.equals("112"))
        	properties.put("mail.smtp.ssl.trust", "outlook.office365.com");
       else if(companyID!=null && companyID.equals("115"))*/
    	   properties.put("mail.smtp.ssl.trust", host);
			/*
			 * else properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			 */
    	   try {
           	InetAddress addr = InetAddress.getLocalHost();
   			String ip = addr.getHostAddress();
   			 if(ip.startsWith("192.168.")){
   				 	mailToAddress = new String[]{"venu@thedecisionlabs.com"};
   					mailCCAddress = new String[]{"ragini@thedecisionlabs.com"};
   					properties.put("mail.smtp.host", "smtp.gmail.com");//"smtp.gmail.com","587","reports@cempia.com","reportsTDL1007"
   			        properties.put("mail.smtp.port", "587");
   			        properties.put("mail.user", "reports@cempia.com");
   			        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
   			        properties.put("mail.password", "reportsTDL1007"); 
   			        mailFrom = "reports@cempia.com";
   			        password="reportsTDL1007";
   			        host="smtp.gmail.com";
   			        port="587";
   			}   
   			
   			
   		} catch (UnknownHostException e) {
   			e.printStackTrace();
   		}

        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication((companyID!=null && companyID.equals("115"))?"noreply":mailFrom, password);
            }
        };
        
        if(companyID!=null && companyID.equals("115")) {
        properties.setProperty("mail.pop3.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
				  properties.setProperty("mail.smtp.socketFactory.class",
				 "javax.net.ssl.SSLSocketFactory");
				  properties.setProperty("mail.smtp.socketFactory.fallback", "false");
				  properties.setProperty("mail.smtp.socketFactory.port", "465");
        }
		
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(mailFrom));
        
       
        //For Production enable the boolean flag which is true 
        // For UAT disable the boolean flag which is false 
        boolean production=false;
        if(!production) {
		   // mailCCAddress = new String[]{"ragini@thedecisionlabs.com"}; //change this email id to Your's
		    if(companyID!=null && companyID.equals("133")) { 
		    	mailToAddress= new String[]{"anupam.c@thedecisionlabs.com","abhay@thedecisionlabs.com","ved@thedecisionlabs.com","venu@thedecisionlabs.com","hariom@thedecisionlabs.com","ragini@thedecisionlabs.com","support@thedecisionlabs.com","dae@cempia.com","danica@cempia.com","joseph@cempia.com","supportmph@thedecisionlabs.com"};
 		    }
		    else
		    	//mailToAddress = new String[]{"anupam.c@thedecisionlabs.com","abhay@cempia.com","ved@thedecisionlabs.com","shailja@thedecisionlabs.com","maria@cempia.com","venu@thedecisionlabs.com","hariom@thedecisionlabs.com","gyanendra@thedecisionlabs.com","support@thedecisionlabs.com"};
		    	mailToAddress = new String[]{"gyanendra@thedecisionlabs.com"};
		    	logger.info("Mail To Address length ==============: "+mailToAddress.length);
        }	
          
        InternetAddress[] toAddresses = new InternetAddress[mailToAddress.length];
        for (int i = 0; i < mailToAddress.length; i++) {
        	try {
				toAddresses[i]= new InternetAddress(mailToAddress[i]);
				logger.info("Sending Email To : ======="+mailToAddress[i]);
			} catch (Exception e) {	logger.debug("Incorrect Email id : "+mailToAddress[i]);		}
		}
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        if(Integer.parseInt(companyID)==120)
        mailCCAddress = null; 
       if(mailCCAddress!=null) {
        InternetAddress[] ccAddresses = new InternetAddress[mailCCAddress.length];
        for (int i = 0; i < mailCCAddress.length; i++) {
        	try {
        		ccAddresses[i]= new InternetAddress(mailCCAddress[i]);
        		logger.debug("CC List : "+mailCCAddress[i]);
			} catch (Exception e) {	logger.debug("Incorrect Email id : "+mailCCAddress[i]);		}
		}
        msg.setRecipients(Message.RecipientType.CC, ccAddresses);
        msg.setSentDate(new Date());
       }
       
       if(mailBCCAddress!=null) {
           InternetAddress[] bccAddresses = new InternetAddress[mailBCCAddress.length];
           for (int i = 0; i < mailBCCAddress.length; i++) {
           	try {
           		bccAddresses[i]= new InternetAddress(mailBCCAddress[i]);
           		logger.debug("BCC List : "+mailBCCAddress[i]);
    			} catch (Exception e) {		logger.debug("Incorrect bcc Email id : "+mailBCCAddress[i]);	}
    		}
           msg.setRecipients(Message.RecipientType.BCC, bccAddresses);
         }
       
       msg.setSubject(this.subject);
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(bodyOfMail, "text/html; charset=utf-8");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
        if (attachFiles != null && attachFiles.length > 0) {
        	for (String filePath : attachFiles) {
	        	MimeBodyPart attachPart = new MimeBodyPart();
                try {
                    attachPart.attachFile(filePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(attachPart);
            }
        }
 
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
 
        // sends the e-mail
       Transport.send(msg);
        retvalue=true;
        return retvalue;
	}
	
	public static void main(String[] args) throws AddressException, MessagingException {
		sendEmailHira();
	}
	
	public static void sendEmailHira() throws AddressException, MessagingException{
		   // Mention the Recipient's email address
        String to = "support@thedecisionlabs.com";
        // Mention the Sender's email address
        String from = "noreply";
        // Mention the SMTP server address. Below Gmail's SMTP server is being used to send email
        String host = "mail.hiranandanihospital.org";
        // Get system properties
    	boolean retvalue = false;
        Properties properties = new Properties();
        try {
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port", "465");
			properties.put("mail.smtp.auth","true");
//        properties.put("mail.smtp.auth","true");
			properties.put("mail.smtp.starttls.enable", "true");
			properties.put("mail.user", from);
			properties.put("mail.password", "c3Mp!@2o21");
			properties.put("mail.smtp.ssl.trust", host);
			properties.put("mail.smtp.ssl.enable", "true");
			
			Session session = null;
			Authenticator auth = new Authenticator() {
			    public PasswordAuthentication getPasswordAuthentication() {
			        return new PasswordAuthentication(from, "c3Mp!@2o21");
			    }
			};
			
			properties.setProperty("mail.pop3.socketFactory.class",
					"javax.net.ssl.SSLSocketFactory");
					  properties.setProperty("mail.smtp.socketFactory.class",
					 "javax.net.ssl.SSLSocketFactory");
					  properties.setProperty("mail.smtp.socketFactory.fallback", "false");
					  properties.setProperty("mail.smtp.socketFactory.port", "465");
			session = Session.getInstance(properties, auth);
			    
			
				/*
				 * properties.setProperty("mail.pop3.socketFactory.class",
				 * "javax.net.ssl.SSLSocketFactory");
				 * properties.setProperty("mail.smtp.socketFactory.class",
				 * "javax.net.ssl.SSLSocketFactory");
				 * properties.setProperty("mail.smtp.socketFactory.fallback", "false");
				 * properties.setProperty("mail.smtp.socketFactory.port", "465");
				 * properties.put("mail.smtp.startssl.enable", "true"); Transport trans =
				 * session.getTransport("smtp"); trans.connect(host, 465, from, "c3Mp!@2o21");
				 */

				

			// creates a new session with an authenticator
  
  

			// creates a new e-mail message
			Message msg = new MimeMessage(session);

			msg.setFrom(new InternetAddress("noreply@hiranandanihospital.org"));
			
			String[] mailToAddress = {"swathi.tdl@gmail.com","support@thedecisionlabs.com"};
			InternetAddress[] toAddresses = new InternetAddress[mailToAddress.length];
			for (int i = 0; i < mailToAddress.length; i++) {
				try {
					toAddresses[i]= new InternetAddress(mailToAddress[i]);
					System.out.println("Mail to ..."+toAddresses[i]);
				} catch (Exception e) {	System.out.println("incorrect");	}
			}
			msg.setRecipients(Message.RecipientType.TO, toAddresses);
			
			

			msg.setSentDate(new Date());
			
 
  
			msg.setSubject("Hiranandi Test Body");
			// creates message part
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("Hiranandani Test", "text/html; charset=utf-8");

			// creates multi-part
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);

			// adds attachments
  
			// sets the multi-part as e-mail's content
			msg.setContent(multipart);

			// sends the e-mail
  Transport.send(msg);
			retvalue=true;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private String[] getCcArry(String[] mailCCAddress2) {

		StringTokenizer refNophComments = new StringTokenizer(mailCCAddress2[0], ",");
		String[] ccArray = new String[refNophComments.countTokens()];
		int index = 0;
		for (int i = 0; refNophComments.hasMoreTokens(); i++) {
			ccArray[i] = refNophComments.nextToken();
		}
		return ccArray;
	}
	public boolean sendEmailWithCC() throws AddressException, MessagingException{
    	boolean retvalue = false;
    	// sets SMTP server properties
    	Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", mailFrom);
        properties.put("mail.password", password);
        if(companyID!=null && companyID.equals("51"))
        properties.put("mail.smtp.ssl.trust", "outlook.office365.com");
        else
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        try {
           	InetAddress addr = InetAddress.getLocalHost();
   			String ip = addr.getHostAddress();
   			 if(ip.startsWith("192.168.")){
   					mailToAddress = new String[]{"venug.tdl@gmail.com"};
   					mailCCAddress = new String[]{"ragini@thedecisionlabs.com"};
   					properties.put("mail.smtp.host", "smtp.gmail.com");
   			        properties.put("mail.smtp.port", "587");
   			        properties.put("mail.user", "reports@cempia.com");
   			        properties.put("mail.password", "reportsTDL1007");
   			        mailFrom = "reports@cempia.com";
   			        password="reportsTDL1007";
   			        host="smtp.gmail.com";
   			        port="587";
   			}   
   			
   			
   		} catch (UnknownHostException e) {
   			e.printStackTrace();
   		}
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(mailFrom, password);
            }
        };
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        msg.setFrom(new InternetAddress(mailFrom));
        
        InternetAddress[] toAddresses = new InternetAddress[mailToAddress.length];
        for (int i = 0; i < mailToAddress.length; i++) {
        	try {
				toAddresses[i]= new InternetAddress(mailToAddress[i]);
			} catch (Exception e) {		}
		}
       /* if(companyID==null || Integer.parseInt(companyID)==101)
              mailCCAddress = new String[]{"anupam@cempia.com","abhay@cempia.com"}; */
        InternetAddress[] ccAddresses = new InternetAddress[mailCCAddress.length];
        for (int i = 0; i < mailCCAddress.length; i++) {
        	try {
        		ccAddresses[i]= new InternetAddress(mailCCAddress[i]);
			} catch (Exception e) {			}
		}
        InternetAddress[] bccAddresses = new InternetAddress[mailBCCAddress.length];
        for (int i = 0; i < mailBCCAddress.length; i++) {
        	try {
        		bccAddresses[i]= new InternetAddress(mailBCCAddress[i]);
			} catch (Exception e) {		}
		}
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setRecipients(Message.RecipientType.CC, ccAddresses);
        msg.setRecipients(Message.RecipientType.BCC, bccAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(bodyOfMail, "text/html");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
        if (attachFiles != null && attachFiles.length > 0) {
        	for (String filePath : attachFiles) {
	        	MimeBodyPart attachPart = new MimeBodyPart();
                try {
                    attachPart.attachFile(filePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(attachPart);
            }
        }
 
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
 
        // sends the e-mail
        Transport.send(msg);
        retvalue=true;
        return retvalue;
	}

	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getMailFrom() {
		return mailFrom;
	}
	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String[] getAttachFiles() {
		return attachFiles;
	}
	public void setAttachFiles(String[] attachFiles) {
		this.attachFiles = attachFiles;
	}
	public String[] getMailToAddress() {
		return mailToAddress;
	}
	public void setMailToAddress(String[] mailToAddress) {
		this.mailToAddress = mailToAddress;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBodyOfMail() {
		return bodyOfMail;
	}
	public void setBodyOfMail(String bodyOfMail) {
		this.bodyOfMail = bodyOfMail;
	}
	public String[] getMailCCAddress() {
		return mailCCAddress;
	}
	public void setMailCCAddress(String[] mailCCAddress) {
		this.mailCCAddress = mailCCAddress;
	}
	public String getCompanyID() {
		return companyID;
	}
	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}
	public String[] getMailBCCAddress() {
		return mailBCCAddress;
	}
	public void setMailBCCAddress(String[] mailBCCAddress) {
		this.mailBCCAddress = mailBCCAddress;
	}
}
