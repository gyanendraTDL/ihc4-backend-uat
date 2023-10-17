package com.tdl.river.util.models;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tdl.river.Repository.CompanyDAO;
import com.tdl.river.Repository.FactorNameDao;
import com.tdl.river.Repository.TicketDAO;
import com.tdl.river.Repository.TicketEscalationDAO;
import com.tdl.river.Repository.TicketHistoryDAO;
import com.tdl.river.Repository.UserDao;
import com.tdl.river.models.Company;
import com.tdl.river.models.FactorName;
import com.tdl.river.models.Feedback;
import com.tdl.river.models.Ticket;
import com.tdl.river.models.TicketEscalation;
import com.tdl.river.models.TicketHistory;
import com.tdl.river.models.UserMap;
import com.tdl.river.models.Users;
import com.tdl.river.oauth.AESencrp;

@Component
public class CreateTicket  extends Thread {

	@Autowired
	TicketDAO ticketDao;
	@Autowired
	TicketHistoryDAO ticketHistoty;
	@Autowired
	CompanyDAO companyDao;
	/*
	 * @Autowired CustomEmail email;
	 */
	@Autowired
	UserDao userdao;
	@Autowired
	FactorNameDao factorDao;
	@Autowired
	TicketEscalationDAO escalationDao;
	
	private Map<String, UserMap> escalationData;
	private Feedback fb;
	public Map<String, UserMap> getEscalationData() {
		return escalationData;
	}
	public void setEscalationData(Map<String, UserMap> escalationData) {
		this.escalationData = escalationData;
	}
	public Feedback getFb() {
		return fb;
	}
	public void setFb(Feedback fb) {
		this.fb = fb;
	}
	
	@Override
	public void  run() {
		try {
		List<FactorName>	factorQues = factorDao.findByTypeAndCommpanyidOrderBySequence(fb.getType(),Integer.toString(fb.getCompanyID()));	
		/* logic to get the filedName */
	//	String[] filedName = new String[factorQues.size()];
				try {	
					for (int i = 0; i < factorQues.size(); i++) {
						int index =i+1;
						int val = getFieldValue(fb, "_"+index);
						/* service question Ticket */
						if(val==1 || val==2) {
							String subfactorName="";
							int factorNumber=0;
							String factorName="";
							FactorName factorTicket = factorQues.get(i);
						
							
							if(factorTicket.getIsHeader()==1) {
								String[] subQues = factorDao.getSubQues(factorTicket.getId());
								factorNumber = factorTicket.getId();
								factorName = factorTicket.getFactor_name();
								for (int j = 0; j < subQues.length; j++) {
									i++;
									index =i+1;
									int subfactorVal = getFieldValue(fb, "_"+index);
									if(subfactorVal==1 || subfactorVal==2)
										subfactorName += subQues[j]+",";
								}
								
							}
							else {
								try {
								factorNumber  = factorTicket.getParentID();
								factorName = factorDao.getFactorName(factorNumber);
								String[] subQues = factorDao.getSubQues(factorNumber);
								
								for (int j = factorTicket.getFormSequence()-1; j < subQues.length; j++) {
									index =i+1;
									int subfactorVal = getFieldValue(fb, "_"+index);
									if(subfactorVal==1 || subfactorVal==2)
										subfactorName += subQues[j]+",";
									if(j != subQues.length-1) // for last val dont increment
										i++;
								}
								}catch(Exception e) {
									e.printStackTrace();
								}
								
							}
							
							if(subfactorName!=null && subfactorName.trim().length()!=0) {
								subfactorName = subfactorName.substring(0, subfactorName.length() - 1);  
								subfactorName = "- "+subfactorName;
							}
							UserMap umap = escalationData.get(factorName);
							createTicket(fb.getId(),(umap!=null)?umap.getUserID():0,factorNumber,fb.getType(),fb.getCompanyID(),fb.getBranchID(),factorName,"(Poor rating is for "+factorName+" "+subfactorName+")",fb.getCountryID());
							
							
						}
						
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
		/* Rating and feedback Ticket */
				try {
					if(fb.getRating()<7) {
						FactorName factorTicket = factorQues.get(factorQues.size()-2);
						UserMap umap = escalationData.get("OVERALL_EXPERIENCE");
						createTicket(fb.getId(),(umap!=null)?umap.getUserID():0,factorTicket.getId(),fb.getType(),fb.getCompanyID(),fb.getBranchID(),factorTicket.getFactor_name(),"(Overall Rating is Poor)",fb.getCountryID());
						
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
					
				try {
					  if(fb.getFeedback()==0) { 
						  FactorName factorTicket = factorQues.get(factorQues.size()-1);
						  UserMap umap = escalationData.get("RECOMMENDATION");
						  createTicket(fb.getId(),(umap!=null)?umap.getUserID():0,factorTicket.getId(),fb.getType(),fb.getCompanyID(),fb.getBranchID(),factorTicket.getFactor_name(),"(Will Not Recommend)",fb.getCountryID());
							
					  
					  }
				}catch (Exception e) {
					e.printStackTrace();
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
	}
	public int getFieldValue(Object clazz ,String filedName) {
		try {
		Field field = clazz.getClass().getField(filedName);
	    Class clazzType = field.getType();
	      return field.getInt(clazz);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	 void  createTicket(int feedbackID,int escalationID, int factorNumber, String type, int companyID, int branchID, String FactorName,String fbcomments,int countryID) {
		
		Integer ticketNumber = 0;
		try {
			ticketNumber = ticketDao.getMaxTicketNo(companyID,branchID);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(ticketNumber==0)
			ticketNumber=1;
		/* updating ticket table */
	try {	
		Ticket t = new Ticket();
		t.setFeedbackID(feedbackID);
		t.setFeedbackComments(fbcomments);
		t.setFactorName(FactorName);
		t.setFactorNumber(factorNumber);
		t.setCompanyID(companyID);
		t.setBranchID(branchID);
		t.setType(type);
		t.setStatus(1);//open
		t.setCreatedDate(getLocalTime(countryID));
		//t.setCreated_date(Utility.getLocalTime());
		t.setTicketNumber(ticketNumber);
		t.setNote("");
		int ticketID=0;
		try {
			ticketID=ticketDao.save(t).getId();
		}catch(Exception e) {
			e.printStackTrace();
		}
		/* updating ticket history table table */
		TicketHistory history = new TicketHistory();
		history.setCompanyID(companyID);
		history.setTicketID(ticketID);
		history.setStatus(1);
		history.setEscalationID(escalationID);
		history.setUpdate_by(fb.getCreated_by());
		history.setUpdate_date(getLocalTime(countryID));
		ticketHistoty.save(history);
		if(escalationID!=0)
			createdEscalation(ticketID,escalationID);
	}catch(Exception e) {
		e.printStackTrace();
	}

	}


	private void createdEscalation(int ticketID, int escalationID) {
		/*
		 * //Updating escalation id to ticket table
		 */	
		Ticket t=null;
		try {
		Optional<Ticket> tdata = ticketDao.findById(ticketID);
		if(tdata.isPresent())
			t = tdata.get();
		t.setEscalationID(escalationID);
		ticketDao.save(t);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * Updating Ticket Escalation
		 */
		try {
		TicketEscalation tEscalation = new TicketEscalation();
		tEscalation.setTicketID(ticketID);
		tEscalation.setEscalationID(escalationID);
		tEscalation.setLevel(1);
		tEscalation.setCreated_by(fb.getCreated_by());
		tEscalation.setCreated_date(getLocalTime(fb.getCountryID()));
		tEscalation.setCompanyID(fb.getCompanyID());
		escalationDao.save(tEscalation);
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		/* 
		 * Sending email to officer 
		 * */
		Optional<Company> domain = companyDao.findById(fb.getCompanyID());
		Company emailDomain = null;
		if(domain.isPresent())
			emailDomain= domain.get();
		    CustomEmail email = new CustomEmail();
			email.setHost(emailDomain.getDomain_name());
			email.setPort(Integer.toString(emailDomain.getSMTP_port()));
			email.setMailFrom(emailDomain.getSMTP_email());
			email.setPassword(emailDomain.getSMTP_password());
			email.setCompanyID( Integer.toString(emailDomain.getId()));
		email.setSubject("CEMPIA Ticket Escalated to you for "+AESencrp.decrypt(fb.getRefNo()));
		
		/*/
		 * 
		 * Get escalation officer data
		 */
		
		Optional<Users> userData = userdao.findById(escalationID);
		Users user = null;
		if(userData.isPresent())
			user= userData.get();
		email.setMailToAddress(new String[]{user.getEmail()});EmailTemplate et=new EmailTemplate();
		EmailTemplate et1=new EmailTemplate();
		email.setBodyOfMail(et1.ticketBody(fb,t,user,null,emailDomain,null,null));
		try {
			email.sendEmail();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	private LocalDateTime getLocalTime(int countryID) {
		 LocalDateTime ldt = LocalDateTime.now().plusHours(5);
		 ldt = ldt.plusMinutes(30);//Local date time
		 String timeZone = "Asia/Calcutta";
			if(countryID==2)
				timeZone = "Asia/Kuala_Lumpur";//malaysia
			else if(countryID==3)
				timeZone = "Asia/Ho_Chi_Minh";//vitename
			else if(countryID==4)
				timeZone = "Asia/Jakarta";//indonesiya
			ZoneId zoneId = ZoneId.of(timeZone);
			ldt = ldt.now(zoneId);
		 return ldt;
	}

}
