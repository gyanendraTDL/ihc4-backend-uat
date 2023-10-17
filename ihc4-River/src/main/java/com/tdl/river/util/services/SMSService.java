package com.tdl.river.util.services;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SMSService 
{
	Logger logger = LoggerFactory.getLogger(SMSService.class);
	
	public static void main(String[] args) 
	{
		String smsMessage = "Dear Sharath, the following ticket No 80 is for your kind action. Please click on the link for additional details and resolution. https://cempia.com/aoi/ Citizens Hospitals - a Unit of ARTMED HEALTHCARE PRIVATE LIMITED";
						   //Dear {#var#}, the following ticket No {#var#} is for your kind action. Please click on the link for additional details and resolution. https://cempia.com/{#var#} Citizens Hospitals - a Unit of ARTMED HEALTHCARE PRIVATE LIMITED
		int id = 22633;
		int branchID = 10;
		int companyID = 121;
		String name = "Mrs. Nazneen Jafer";
		
		String hospital = "CANCER TREATMENT SERVICES HYDERABAD PRIVATE LIMITED";
		if(branchID == 10)
			hospital = "Citizens Hospitals - a Unit of ARTMED HEALTHCARE PRIVATE LIMITED";
		
		//String aoiMessage = "Dear "+name+", Thank you for giving us an opportunity to serve you. We are eager to know about your experience. Use the link below to give your feedback. "+hospital+" https://cempia.com/aoi-uat/eSmsAoi?id="+id;
		
		//new SMSService().sendSMS("8921456498", aoiMessage,companyID, branchID);
		
		new SMSService().sendSMS("9093040282", smsMessage,companyID, branchID,null);
	}
	
	public void sendSMS(String destinationNumber,String smsMessage,int companyID,int branchID,String templateID)
	{
		if(destinationNumber==null ||destinationNumber.trim().length()==0)
			return;
		
		//this is to check and make sure SMS is sent only when it is in production. 
		try 
		{
			InetAddress addr = InetAddress.getLocalHost();
			
			String ip = addr.getHostAddress();
			if(ip.startsWith("192.168."))
			{
			destinationNumber="9840527713";
			} 
	        logger.debug("Ip: " + ip);
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		}

		
//		destinationNumber="8050005797";
		
		
		String smsURL="";
		if(companyID==112) 
		{
				smsURL="https://www.isms.com.my/isms_send_all_id.php?un=tangcl&pwd=tangcl&dstno=60122550086,60139928666&msg="+smsMessage+"&type=1&sendid=ASX&agreedterm=YES";
		}
		else if(companyID==115) 
		{
		//		smsURL="http://103.16.101.52:8080/bulksms/bulksms?username=LH48-apicempia&password=$t@rtC3m&type=0&dlr=1&destination="+destinationNumber+"&source=HIRAFB&message="+smsMessage+"&entityid=1101607950000011468&tempid=1107162064719624312";
				smsURL="http://103.16.101.52:8080/bulksms/bulksms?username=LH48-apicempia&password=$t@rtC3m&type=0&dlr=1&destination="+destinationNumber+"&source=HIRAFB&message="+smsMessage+"&entityid=1101607950000011468&tempid="+templateID;
		}
		else if(companyID==116) 
		{
				smsURL="https://api.msg91.com/api/v2/sendsms?message="+smsMessage+"&authkey=347201AltWMOZWab5fb23fdbP1&mobiles="+destinationNumber+"&route=4&sender=SPSHOS&country=91&templateID=1007161709332557877";
		}
		else if(companyID==117) 
		{
				smsURL="https://api.smsu.in/smpp/?username=ssnmchospital&password=PSuLL3k6p&from=SPRSHO&to="+destinationNumber+"&text="+smsMessage+"&templateID=1607100000000111064";
		}
		else if(companyID==118 || companyID==123) 
		{
				smsURL="http://www.smscountry.com/SMSCwebservice_Bulk.aspx?user=RUBYHALL&passwd=kyoceraprt1&mobilenumber="+destinationNumber+"&message="+smsMessage;
		}
		else if(companyID==119) 
		{
				smsURL="http://alerts.kaleyra.com/api/v4/?method=sms&api_key=Ab64849a1ed0548386e5959a330b9af88&message="+smsMessage+"&sender=BBHCEM&to="+destinationNumber+"&entity_id=1201159220111150106&template_id=1007009310546616908";
		}
		else if(companyID==120) 
		{
				smsURL="http://164.52.205.46:6005/api/v2/SendSMS?SenderId=BVHOSP&Is_Unicode=false&Is_Flash=false&Message="+smsMessage+"&MobileNumbers="+destinationNumber+"&ApiKey=zzVN/PNEYGu3cKlGe2KjoI+z88kHg/cEpn7+nF9Q5MA=&ClientId=f195738b-fdf3-4430-86a5-641ee4f29cd7";
		}
		else if(companyID==121) 
		{
			/*if(branchID==10) 
				 smsURL="http://boancomm.net/boansms/boansmsinterface.aspx?mobileno="+destinationNumber+"&smsmsg="+smsMessage+"&uname=citizen&pwd=citizen12sms&pid=229&templateID=1007985310457200000";
			else
				 smsURL="http://boancomm.net/boansms/boansmsinterface.aspx?mobileno="+destinationNumber+"&smsmsg="+smsMessage+"&uname=citizen&pwd=citizen12sms&pid=213&templateID=1007459426981075162"; 
	*/
				if(branchID==10) 
					 smsURL="http://boancomm.net/boansms/boansmsinterface.aspx?mobileno="+destinationNumber+"&smsmsg="+smsMessage+"&uname=citizen&pwd=citizen12sms&pid=229&templateID="+templateID;
				else
					 smsURL="http://boancomm.net/boansms/boansmsinterface.aspx?mobileno="+destinationNumber+"&smsmsg="+smsMessage+"&uname=citizen&pwd=citizen12sms&pid=213&templateID="+templateID; 
		}
		else if(companyID==124) 
		{
			//smsURL="http://smslogin.mobi/spanelv2/api.php?username=fernandez&password=fh@12345&from=FERNAN"+"&to="+destinationNumber+"&message="+smsMessage;
			smsURL="https://api.textlocal.in/send/?username=elroy@fernandezhospital.foundation&password=Fernandez@2019&numbers="+destinationNumber+"&sender=FERNAN&message="+smsMessage; 
		}
		sendSMS(destinationNumber, smsURL);
	}
	
/*	public void sendSMS(String destinationNumber,String smsMessage,int companyID,int branchID,String to)
	{
		if(destinationNumber==null ||destinationNumber.trim().length()==0)
			return;
	//	destinationNumber="9787309828";
		/************************to patient**************************/
	/*	String smsURL="";
		if(companyID==121) 
		{
				if(branchID==10) 
					 smsURL="http://boancomm.net/boansms/boansmsinterface.aspx?mobileno="+destinationNumber+"&smsmsg="+smsMessage+"&uname=citizen&pwd=citizen12sms&pid=229&templateID=1007057010818530097"; //patient tested working
				else
					 smsURL="http://boancomm.net/boansms/boansmsinterface.aspx?mobileno="+destinationNumber+"&smsmsg="+smsMessage+"&uname=citizen&pwd=citizen12sms&pid=213&templateID=1007030521852810464"; //patient tested working
		}
		
		sendSMS(destinationNumber, smsURL);
	}*/
	
	/*public void sendSMS(int branchID,String destinationNumber,String smsMessage,int companyID)
	{
		if(destinationNumber==null ||destinationNumber.trim().length()==0)
			return;
	//	destinationNumber = "9093040282";
		try 
		{
			InetAddress addr = InetAddress.getLocalHost();
			
			String ip = addr.getHostAddress();
			if(ip.startsWith("192.168."))
			{
				destinationNumber = "9093040282";
			} 
	        logger.debug("Ip: " + ip);
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		}
		if(companyID==115) 
		{
			String sms="http://103.16.101.52:8080/bulksms/bulksms?username=LH48-apicempia&password=$t@rtC3m&type=0&dlr=1&destination="+destinationNumber+"&source=HIRAFB&message="+smsMessage+"&tempid=1107162504669856688";
			sendSMS(destinationNumber, sms);
		}
	}*/
	
	private boolean sendSMS(String destinationNumber,String smsURL)
	{
		try
		{
			smsURL = smsURL.replaceAll(" ", "%20");
			
			System.out.println(smsURL);
			logger.debug("smsURL"+smsURL);
			
			CloseableHttpClient client = HttpClients.createDefault();
			HttpGet httpget = new HttpGet(smsURL);
			httpget.addHeader("User-Agent", "Mozilla/5.0");
		    CloseableHttpResponse response = client.execute(httpget);
			int responseCode  = response.getStatusLine().getStatusCode();
			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			
			logger.debug("sms sent to "+destinationNumber+". responseCode="+responseCode +" \t responseText="+result.toString());
			System.out.println("sms sent to "+destinationNumber+". responseCode="+responseCode +" \t responseText="+result.toString());
			
			client.close();
		} 
		catch (MalformedURLException ex) 
		{
			 ex.printStackTrace();
		}
		catch (IOException ex) 
		{
			 ex.printStackTrace();
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
		return true;
	}
}

