package com.tdl.river.services;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.tdl.river.Repository.AutoRountingDAO;
import com.tdl.river.Repository.BranchDAO;
import com.tdl.river.Repository.CompanyDAO;
import com.tdl.river.Repository.FactorNameDao;
import com.tdl.river.Repository.FeedbackCommentsDAO;
import com.tdl.river.Repository.FeedbackDao;
import com.tdl.river.Repository.TicketDAO;
import com.tdl.river.Repository.TicketEscalationDAO;
import com.tdl.river.Repository.TicketHistoryDAO;
import com.tdl.river.Repository.UserDao;
import com.tdl.river.Repository.UserMapDAO;
import com.tdl.river.models.AutoRoutingCriteria;
import com.tdl.river.models.Branch;
import com.tdl.river.models.Company;
import com.tdl.river.models.FactorName;
import com.tdl.river.models.Feedback;
import com.tdl.river.models.FeedbackComments;
import com.tdl.river.models.Ticket;
import com.tdl.river.models.TicketEscalation;
import com.tdl.river.models.TicketHistory;
import com.tdl.river.models.UserMap;
import com.tdl.river.models.Users;
import com.tdl.river.models.Utility;
import com.tdl.river.oauth.AESencrp;
import com.tdl.river.util.models.CustomEmail;
import com.tdl.river.util.models.EmailTemplate;
import com.tdl.river.util.services.SMSService;

@Service
public class FeedbackService {

	@Autowired
	BranchDAO branchDao;
	@Autowired
	FeedbackDao feedbackDao;
	@Autowired
	@Qualifier("taskExceutor")
	private Executor executor;

	HashMap<String, Object> response = new HashMap<>();

	public ResponseEntity<HashMap<String, Object>> saveFeedback(Feedback fb) {
	Integer fbId=feedbackDao.checkDuplicate(fb.getCreated_date(),fb.getChannelID(),fb.getFeedback(),fb.getRating(),fb.getName(),fb.getRefNo(),fb.getType(),fb.getCompanyID(),fb.getContactNo()); 
		response.clear();
		long diff = 0;
		int feedbackID=0;
		if(fbId==null || fbId==0) {
			LocalDateTime time = feedbackDao.checkDifference(fb.getChannelID(),fb.getFeedback(),fb.getRating(),fb.getName(),fb.getRefNo(),fb.getType(),fb.getCompanyID(),fb.getContactNo());
			if(time!=null) {		
				LocalDateTime currTime = Utility.getLocalTime(fb.getCountryID(),fb.getCompanyID());
				if(fb.getCompanyID() == 133 && fb.getChannelID()==3)
					diff = ChronoUnit.DAYS.between(time, currTime);
				else
					diff = ChronoUnit.MINUTES.between(time, currTime);
			}else
				diff=-1;
		}else {
			
		}
		if(diff>30 || diff==-1) {
			feedbackID = feedbackDao.save(fb).getId();
		}
		 CompletableFuture.runAsync(() -> createTicket(12,fb), executor)
		 .exceptionally(e -> {
			 //log.error(e.getMessage(), e);
			 return null;
		 });
	
		response.put("status", HttpStatus.OK.value());
		response.put("feedbackId", feedbackID);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}



	
	@Autowired
	FactorNameDao factorNameDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;
//	public void calculatePsi(Feedback fb) {
//		try {
//			List<FactorName> factorList = factorNameDao.getFactorQue(fb.getType(), fb.getCompanyID());
//			//jdbcTemplate.queryForList(query);
//			String query=" select ";
//			for(int i=0;i<factorList.size();i++) {
//				FactorName fName = factorList.get(i);
//				query+="_"+fName.getColQue();
//				if(i!=factorList.size()-1)
//					query+=",";
//			}
//			query+=" from ifb_feedback fb where fb.id="+fb.getId();
//			List<List<Integer>>  ListOfitems=jdbcTemplate.query(query , new RowMapper<List<Integer>>() {
//				@Override
//				public List<Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {
//					List<Integer> l = new ArrayList<>();
//					for (int i = 0; i < factorList.size(); i++) {
//					FactorName fName =factorList.get(i);
//						String key = "_"+fName.getColQue();
//						l.add(rs.getInt(key));
//					}
//					return l;
//				}
//			} );
//			
//			Map<FactorName, int[]> facMap = new LinkedHashMap<>();
//			int i=0;
//			for (List<Integer> list : ListOfitems) {
//				for (FactorName fName : factorList) {
//					int[] arr = new int[6];
//					int val = list.get(i);
//					arr[val]++;
//					facMap.put(fName, arr);
//					i++;
//				}
//			}
//		
//		ModelMap map = new ModelMap();	
//		int psiRating=-1;
//		String psi="-1";
//		if(facMap!=null && facMap.size()!=0) {
//		 scoreService.preparePsiVal(facMap, fb.getCompanyID(), map);
//		 psi = (String) map.getAttribute("psi");
//		 Company company = companyDao.getHisData(fb.getCompanyID());
//		 if(Double.valueOf(psi)>=company.getHighPsi())
//			 psiRating=2;
//		 else if(Double.valueOf(psi)>=company.getMediumPsi() && Double.valueOf(psi)<company.getHighPsi())
//				 psiRating=1;
//		 else if(Double.valueOf(psi)<=company.getLowPsi() && Double.valueOf(psi)>0)
//			 psiRating=0;
//		}
//		 
//		 feedback.updateFbpsi(fb.getId(),psiRating,psi);
//			
//		} catch (DataAccessException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	@Autowired
	UserMapDAO userMap;
	public void createTicket(int feedbackID, Feedback fb) {
		
		List<UserMap> userMapData = userMap.findByFormTypeAndBranchIDAndLevelAndCompanyID(fb.getType(),fb.getBranchID(),1,fb.getCompanyID());
		
		Map<Integer, UserMap> hMap =userMapData.stream()
					.collect(Collectors.toMap(UserMap::getDrilldownID, u->u, (old, nw) -> nw));
			createTicket1(fb,hMap); 
		
	}
	
	@Autowired
	FactorNameDao factorDao;
	
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
	
	private void generateSubserviceTicket(FactorName factorTicket, UserMapDAO userMap, Feedback fb, Map<Integer, UserMap> escalationData, List<Ticket> ticketList) {
		String mainFactor;
		int mainFactorNumber;
		String subFactorName;
		int subFactorNumber;
		try {
			mainFactorNumber  = factorTicket.getParentID();
			subFactorNumber = factorTicket.getId();
			mainFactor = factorDao.getFactorName(mainFactorNumber);//header
			subFactorName = factorTicket.getFactor_name(); //subfactor
			UserMap umap = null;
		   if(subFactorName!=null && factorTicket.getWardTicket()==1)
				umap = userMap.findEscalationByWard(fb.getCompanyID(),fb.getBranchID(),(fb.getWardNo()==null)?"":fb.getWardNo(),subFactorNumber,fb.getType());
			else
				umap = escalationData.get(subFactorNumber);
			if(subFactorName.equalsIgnoreCase("OVERALL_EXPERIENCE")) {
					//log.info(fb.toString()+"=="+"OVERALL_EXPERIENCE from generateSubserviceTicket"+"== Rating:"+fb.getRating()+"== :"+fb.getFeedback());
			}
			//createTicket(fb.getId(),(umap!=null)?umap.getUserID():0,mainFactorNumber,fb.getType(),fb.getCompanyID(),fb.getBranchID(),mainFactor,"(Poor rating is for "+mainFactor+"-"+subFactorName+")",fb.getCountryID(),fb,umap,subFactorName,ticketList,subFactorNumber,factorTicket);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Autowired
	AutoRountingDAO autoRouting;
	private void createTicket1(Feedback fb, Map<Integer, UserMap> escalationData) {
		try {
			List<FactorName> factorQues = factorDao.getFactorList(fb.getType(),fb.getCompanyID());
				
			
			List<Ticket> ticketList = new ArrayList<>();
					try {	
	 					for (int i = 0; i < factorQues.size()-1; i++) {
							int index =i+1;
							int val = getFieldValue(fb, "_"+index);
							FactorName factorTicket =null;
							factorTicket =factorQues.get(i);
							if(val!=0 && val<=factorTicket.getTicketRating()) {
								String subfactorName="";
								int factorNumber=0;
								String factorName="";
								int ticketUnique=0;// based on this id (ie  factor primary key) escaltion is fetched instead of factorname
								if(factorTicket.getIsHeader()==1 && factorTicket.getSubTicket()==1) { 
									//if sub service level ticket , skip the service  
									// no inheritance in ihc3
								}else if(factorTicket.getIsHeader()!=1 && factorTicket.getSubTicket()==1) {
//									if(fb.getCompanyID()==125)
//									generateSubserviceTicket1(factorTicket,userMap,fb,escalationData,ticketList,fbcmts);
//									else
									generateSubserviceTicket(factorTicket,userMap,fb,escalationData,ticketList);
								}else {
									if(factorTicket.getIsHeader()==1 ) {
										String[] subQues = factorDao.getSubQues(factorTicket.getId());
										factorNumber = factorTicket.getId();
										ticketUnique = factorTicket.getId();
										factorName = factorTicket.getFactor_name();
											for (int j = 0; j < subQues.length; j++) {
												i++;
												index = i + 1;
												FactorName subfactorTicket = factorQues.get(i);
												int subfactorVal = getFieldValue(fb, "_" + index);
												if (subfactorVal <=subfactorTicket.getTicketRating() && subfactorVal!=0 ) {
													if(fb.getCompanyID()!=1 || (fb.getCompanyID()==1 && fb.getChannelID()!=6)) {
														subfactorName += subfactorTicket.getFactor_name() + ",";
												}
												}
											}
									}
									else {
										try {
											factorNumber  = factorTicket.getParentID();
											FactorName parentFactor = factorDao.getFactorById(factorNumber);
											ticketUnique = parentFactor.getId();
											factorName = parentFactor.getFactor_name();
											String[] subQues = factorDao.getSubQues(factorNumber);
											for (int j = factorTicket.getFormSequence()-1; j < subQues.length; j++) {
												index =i+1;
												FactorName subFactors =null;
												 subFactors = factorQues.get(i);
												int subfactorVal=0;
												if(i==32 && fb.getCompanyID()==130)
													subfactorVal = getFieldValue(fb, "_"+35);
												else
												 subfactorVal = getFieldValue(fb, "_"+index);
												if(subfactorVal<=subFactors.getTicketRating() && subfactorVal!=0)
													subfactorName += subQues[j]+",";
												if(j != subQues.length-1) // for last val dont increment
													i++;
											}
										}catch(Exception e) {
											e.printStackTrace();
										}
									}
									String subVal=null;
									if(subfactorName!=null && subfactorName.trim().length()!=0) {
										subfactorName = subfactorName.substring(0, subfactorName.length() - 1);  
										subVal = subfactorName;
										subfactorName = "- "+subfactorName;
									}
									UserMap umap = null;
									if(factorName!=null && factorTicket.getWardTicket()==1)
										umap = userMap.findEscalationByWard(fb.getCompanyID(),fb.getBranchID(),(fb.getWardNo()==null)?"":fb.getWardNo(),ticketUnique,fb.getType());
									else
										umap = escalationData.get(ticketUnique);
									
									String serviceCmt = "";
//									try {
//										if(!factorTicket.getCommpanyid().equalsIgnoreCase("130") && !factorTicket.getCommpanyid().equalsIgnoreCase("125")&& !factorTicket.getCommpanyid().equalsIgnoreCase("122")&& !factorTicket.getCommpanyid().equalsIgnoreCase("137"))
//											serviceCmt = getServiceCmt(fbcmts,factorTicket.getFormSequence());
//									} catch (Exception e) {
//										// TODO Auto-generated catch block
//										e.printStackTrace();
//									}
									if(serviceCmt == null || serviceCmt == "" )
										serviceCmt = "";
									else
										serviceCmt = " - " + serviceCmt;
									String fbCmts = "(Poor rating is for "+factorName+" "+subfactorName+")"+serviceCmt;
									if(!factorName.equalsIgnoreCase("OVERALL_EXPERIENCE"))
										createTicket(fb.getId(),(umap!=null)?umap.getUserID():0,factorNumber,fb.getType(),fb.getCompanyID(),fb.getBranchID(),factorName,fbCmts,fb.getCountryID(),fb,umap,subVal,ticketList,0,factorTicket);
								}
							}
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
			/* Rating and feedback Ticket */
					FactorName factorTicket = factorQues.get(factorQues.size()-1);
					try {
						if((fb.getRating()<=factorTicket.getTicketRating() && fb.getRating()!=-1) || (fb.getFeedback()==0 && fb.getFeedback()!=-1)) {
							//log.info(fb.toString()+"=="+"OVERALL_EXPERIENCE from create Ticket - 2.2"+"== Rating:"+fb.getRating()+"== :"+fb.getFeedback());
							
							//UserMap umap = escalationData.get("OVERALL_EXPERIENCE");
							UserMap umap = userMap.getOverallExp(fb.getType(),fb.getBranchID(),1,fb.getCompanyID());
							createTicket(fb.getId(),(umap!=null)?umap.getUserID():0,factorTicket.getId(),fb.getType(),fb.getCompanyID(),fb.getBranchID(),"OVERALL_EXPERIENCE","(Overall Rating is Poor)",fb.getCountryID(),fb, umap,null,ticketList,0,null);
							
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					/* Word Based Escalation */
					Optional<Company> c = companyDao.findById(fb.getCompanyID());
					if(c.isPresent() && c.get().getAutoRouting()==1 && fb.getComments()!=null) {
						
						List<AutoRoutingCriteria> autoWords =  autoRouting.findByCompanyIDAndBranchID(fb.getCompanyID(),fb.getBranchID());
						autoWords.forEach(word->{
							if(fb.getComments().toUpperCase().contains(word.getWord().toUpperCase())) {
								createTicket(fb.getId(),(word!=null)?word.getEscalationID():0,0,fb.getType(),fb.getCompanyID(),fb.getBranchID(),"Word_Based","(Word_Based - "+word.getWord().toUpperCase()+")",fb.getCountryID(),fb, null,word.getWord().toUpperCase(),ticketList,0,null);
							}
							
						});
						
					}
					
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
	@Autowired
	TicketDAO ticketDao;
	
	@Autowired
	TicketHistoryDAO tickethistoryDao;
	
	Integer  createTicket(int feedbackID,int escalationID, int factorNumber, String type, int companyID, int branchID, String FactorName,String fbcomments,int countryID, Feedback fb,UserMap umap, String subFactorName, List<Ticket> ticketList, int subFactorNumber,FactorName factorTicket) {
		
		Integer ticketNumber = 0;
		Integer ticketID=0;
		String comments="";
		int iCQ=0;
		try {
			ticketNumber = ticketDao.getMaxTicketNo(companyID,branchID);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(ticketNumber==0)
			ticketNumber=1;
		if(companyID==125) {
			List<String[]> cData = ticketDao.findFeedbackCommentsIP(feedbackID);
			if(subFactorNumber==0){ //this block is for service level ticket
				if(type.equalsIgnoreCase("OP")) {
					String colQuo=ticketDao.findColumnQuestion(factorNumber,type,companyID);
				    iCQ= Integer.parseInt(colQuo);
				    comments=cData.get(0)[iCQ-1];
				}else {// for columbiasia IP-multiple comments are given on sub service level
					List<String> colQueList=ticketDao.findSubColumnQuestion(factorNumber,type,companyID);
					for (Iterator<String> iterator = colQueList.iterator(); iterator.hasNext();) {
						String rowCQ = (String) iterator.next();
						iCQ= Integer.parseInt(rowCQ);
						if(cData.get(0)[iCQ-1]!=null)
							comments+=cData.get(0)[iCQ-1]+", ";
					}
				}
			}else { //this block is for sub service level ticket
				if(type.equalsIgnoreCase("OP")) {// for columbiasia op comments are given on service level
					String colQuo=ticketDao.findColumnQuestion(factorNumber,type,companyID);
				    iCQ= Integer.parseInt(colQuo);
				    comments=cData.get(0)[iCQ-1];
				}else { // for columbiasia ip comments are given on sub service level
					String colQuo=ticketDao.findColumnQuestion(subFactorNumber,type,companyID);
					iCQ= Integer.parseInt(colQuo);
					comments=cData.get(0)[iCQ-1];
				}
			}
			
			
		}
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
		t.setCreatedDate(getLocalTime(countryID,companyID));
		t.setSubFactorName(subFactorName);
		//t.setCreated_date(Utility.getLocalTime());
		t.setTicketNumber(ticketNumber);
		t.setNote("");
		t.setSubFactorNumber(subFactorNumber);
		t.setAudioComments(comments);
		if(subFactorNumber>0)
			t.setIsSubTicket(1);
		
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
		history.setUpdate_date(getLocalTime(countryID,companyID));
		tickethistoryDao.save(history);
		if(escalationID!=0)
			createdEscalation(ticketID,escalationID,fb, umap,ticketList,factorTicket);
		else if(fb.getCompanyID()==115 ||fb.getCompanyID()==121)
				ticketList.add(t);
	}catch(Exception e) {
		e.printStackTrace();
		return ticketID;
	}
	return ticketID;

	}
	
	private LocalDateTime getLocalTime(int countryID,int companyID) {
		LocalDateTime ldt = null;
		if(companyID==122 || companyID==137) 
		{
			ZoneId zoneId = ZoneId.of("Asia/Kuala_Lumpur");
			ldt = ldt.now(zoneId);
		//	ldt = ldt.plusHours(8);
		
		}
		
	else {	 
	  ldt = LocalDateTime.now().plusHours(5);
	  ldt = ldt.plusMinutes(30);//Local date time
	  String timeZone = "Asia/Calcutta";
		if(countryID==2 || (companyID==133 && countryID==8))
			timeZone = "Asia/Kuala_Lumpur";//malaysia
		else if(countryID==3)
			timeZone = "Asia/Ho_Chi_Minh";//vitename
		else if(countryID==4)
			timeZone = "Asia/Jakarta";//indonesiya
		else if(countryID==8 && companyID!=133)
			timeZone = "Asia/Muscat"; //Oman
		else if(countryID==9)
			timeZone = "Asia/Bahrain"; //Baharin
		ZoneId zoneId = ZoneId.of(timeZone);
		ldt = ldt.now(zoneId);
		}
		 return ldt;
	}
	@Autowired
	TicketEscalationDAO  ticketEscalationDAO;
	
	@Autowired
	CompanyDAO companyDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	FeedbackCommentsDAO feedCommentsDAO;
	
	@Autowired
	SMSService smsService;
	
	@SuppressWarnings({ "unused", "null" })
	private void createdEscalation(int ticketID, int escalationID, Feedback fb, UserMap umap, List<Ticket> ticketList, FactorName factorTicket) {
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
		
		/* Adding ticketData to list */
				ticketList.add(t);
		/*
		 * Updating Ticket Escalation
		 */
		try {
		TicketEscalation tEscalation = new TicketEscalation();
		tEscalation.setTicketID(ticketID);
		tEscalation.setEscalationID(escalationID);
		tEscalation.setLevel(1);
		tEscalation.setCreated_by(fb.getCreated_by());
		tEscalation.setCreated_date(getLocalTime(fb.getCountryID(),fb.getCompanyID()));
		tEscalation.setCompanyID(fb.getCompanyID());
		ticketEscalationDAO.save(tEscalation);
		}catch (Exception e) {
		e.printStackTrace();
		}
		String[] ccEmailList = null;
		String[] ccNumList = null;
		
		if(umap!=null) {	
			List<Users> ccList = umap.getCcListId();
			Integer[] ccListNum = userMap.findByccListNum(umap.getId());
			


			  if(fb.getCompanyID()==120)
				  ccList = null; 
			/*Checking CC List */
			try {
			if(!ccList.isEmpty()) {
				ccEmailList = new String[ccList.size()];
				int i =0;
				for (Iterator iterator = ccList.iterator(); iterator.hasNext();) {
					Users users = (Users) iterator.next();
					ccEmailList[i]= users.getEmail();
					try {
						TicketEscalation tEscalation = new TicketEscalation();
						tEscalation.setTicketID(ticketID);
						tEscalation.setEscalationID(users.getId());
						tEscalation.setLevel(1);
						tEscalation.setCreated_by(fb.getCreated_by());
						tEscalation.setCreated_date(getLocalTime(fb.getCountryID(),fb.getCompanyID()));
						tEscalation.setCompanyID(fb.getCompanyID());
						ticketEscalationDAO.save(tEscalation);
						}catch (Exception e) {
						e.printStackTrace();
						}
					i++;
				}
			}}catch (Exception e) {
				
			}
			
			if(ccListNum.length != 0) {
				ccNumList = new String[ccListNum.length];
				for (int i=0; i < ccListNum.length; i++ ) {
					ccNumList[i] = userDao.getConNo(ccListNum[i]);
				}
			}
			
		
		}	
		/* 
		 * Sending email to officer 
		 * */
		CustomEmail email = new CustomEmail();
		Optional<Company> domain = companyDao.findById(fb.getCompanyID());
		Company emailDomain = null;
		Branch branchEmailDomain=null;
		if(domain.isPresent())
			emailDomain= domain.get();
		if(t.getCompanyID()==133) {
			Optional<Branch> branchDomain = branchDao.findById((long)t.getBranchID());
			if(branchDomain!=null && branchDomain.isPresent())
				branchEmailDomain= branchDomain.get();
			email.setHost(branchEmailDomain.getDomain_name());
			email.setPort(Integer.toString(branchEmailDomain.getSMTP_port()));
			email.setMailFrom(branchEmailDomain.getSMTP_email());
			email.setPassword(branchEmailDomain.getSMTP_password());
			email.setCompanyID(branchEmailDomain.getCompanyID());
		}else {
			email.setHost(emailDomain.getDomain_name());
			email.setPort(Integer.toString(emailDomain.getSMTP_port()));
			email.setMailFrom(emailDomain.getSMTP_email());
			email.setPassword(emailDomain.getSMTP_password());
			email.setCompanyID( Integer.toString(emailDomain.getId()));
		}
			email.setSubject("CEMPIA Ticket Escalated to you for "+AESencrp.decrypt(fb.getName()));
		
		/*/
		 * 
		 * Get escalation officer data
		 */
		
		Optional<Users> userData = userDao.findById(escalationID);
		Users user = null;
		if(userData.isPresent())
			user= userData.get();
		
		FeedbackComments comments = feedCommentsDAO.findByFeedbackID(fb.getId());

				email.setMailToAddress(new String[]{"shailja@thedecisionlabs.com","support@thedecisionlabs.com","ved@thedecisionlabs.com","anupam.c@thedecisionlabs.com","abhay@thedecisionlabs.com","maria@cempia.com"});
				email.setMailCCAddress(new String[]{"ragini@thedecisionlabs.com"});
			EmailTemplate et=new EmailTemplate();
			email.setBodyOfMail(et.ticketBody(fb,t,user,ccEmailList,emailDomain,comments,factorTicket));
			try {
				email.sendEmail();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		
		//http://localhost:8888/tktRsln?_1=112-2-13-222
			/* send SMS */
			//smsService
		if(emailDomain.getSendmsg()==1) {
			String smsLink="";
			String template = null;
			String ChannelName = "";
			if(fb.getCompanyID()==116) {
			//	smsLink=" Dear "+user.getUsername() +" the following ticket No "+t.getTicketNumber()+" is for your kind action. Please click on the SPS hospital link for additional details and resolution status (Issue Active). is for your kind action. https://cempia.com/"+emailDomain.getPathName()+"/tktRsln?_1="+emailDomain.getId()+"_"+fb.getBranchID()+"_"+t.getEscalationID()+"_"+t.getId()+" SPS hospital.";
		        smsLink="Dear "+user.getUsername() +", the following ticket No "+t.getTicketNumber()+" is for your kind action. Please click on the SPS hospital link for additional details and resolution status (Issue Active). https://cempia.com/"+emailDomain.getPathName()+"/tktRsln?_1="+emailDomain.getId()+"_"+fb.getBranchID()+"_"+t.getEscalationID()+"_"+t.getId()+"  SPS hospital";
			}else if(fb.getCompanyID()==115) {
				smsLink=" Dear"+user.getUsername() +", the following ticket no "+t.getTicketNumber()+" is for your kind action. Please click on the link for additional details and resolution. https://cempia.com/"+emailDomain.getPathName()+"/tktRsln?_1="+emailDomain.getId()+"-"+fb.getBranchID()+"-"+t.getEscalationID()+"-"+t.getId()+"  Dr.L H Hiranandani hospital";
				template="1107162064719624312";
			}
			else if(fb.getCompanyID()==117) {
				smsLink=" Dear"+user.getUsername() +", the following ticket no "+t.getTicketNumber()+" is for your kind action. Please click on the link for additional details and resolution. https://cempia.com/"+emailDomain.getPathName()+"/tktRsln?_1="+emailDomain.getId()+"-"+fb.getBranchID()+"-"+t.getEscalationID()+"-"+t.getId()+"  Sparsh hospital";
			}else if(fb.getCompanyID()==119) {
				smsLink=" Dear "+user.getUsername() +", the following ticket no "+t.getTicketNumber()+" is for your kind action. Please click on the link for additional details and resolution. https://cempia.com/"+emailDomain.getPathName()+"/tktRsln?_1="+emailDomain.getId()+"-"+fb.getBranchID()+"-"+t.getEscalationID()+"-"+t.getId()+" Bangalore Baptist Hospital";
			}else if(fb.getCompanyID()==118 || fb.getCompanyID()==123) {
				smsLink="Dear "+user.getUsername() +", the following ticket No "+t.getTicketNumber()+" is for your kind action. Please click on the link for additional details and resolution.  https://cempia.com/"+emailDomain.getPathName()+"/tktRsln?a1="+emailDomain.getId()+"-"+fb.getBranchID()+"-"+t.getEscalationID()+"-"+t.getId()+" RUBYHALL Team.";
			}else if(fb.getCompanyID()==120) {
				smsLink="Dear "+user.getUsername()+", the following ticket No "+t.getTicketNumber()+" is for your kind action. Please click on the link for additional details and resolution. https://cempia.com/"+emailDomain.getPathName()+"/tktRsln?_1="+emailDomain.getId()+"-"+fb.getBranchID()+"-"+t.getEscalationID()+"-"+t.getId()+" BhaktiVedanta Hospital";
			}else if(fb.getCompanyID()==121) 
			{
				if(fb.getBranchID()==10) {
					smsLink="Dear "+user.getUsername()+", the following ticket No "+t.getTicketNumber()+" is for your kind action. Please click on the link for additional details and resolution. https://cempia.com/"+emailDomain.getPathName()+"/tktRsln?_1="+emailDomain.getId()+"_"+fb.getBranchID()+"_"+t.getEscalationID()+"_"+t.getId()+"  Citizens Hospitals  - a Unit of ARTMED HEALTHCARE PRIVATE LIMITED";
					template="1007457837906410000";
				}
				else {
					smsLink="Dear "+user.getUsername()+", the following ticket No "+t.getTicketNumber()+" is for your kind action. Please click on the link for additional details and resolution. https://cempia.com/"+emailDomain.getPathName()+"/tktRsln?_1="+emailDomain.getId()+"_"+fb.getBranchID()+"_"+t.getEscalationID()+"_"+t.getId()+"  CANCER TREATMENT SERVICES HYDERABAD PRIVATE LIMITED";
					template="1007459426981075162";
				}
			}
			else if(fb.getCompanyID()==124) {
				if(fb.getChannelID() == 2)
					ChannelName = "SMS Feedback";
				else if(fb.getChannelID() == 3)
					ChannelName = "QR Feedback";
				else if(fb.getChannelID() == 1)
					ChannelName = "TAB Feedback";
				else if(fb.getChannelID() == 4)
					ChannelName = "DESKTOP Feedback";
				 smsLink=" Dear "+user.getUsername()+", The following ticket on "+t.getFactorName()+" is for your kind action(generated from "+ChannelName+"). Please click on the link for additional details and resolution https://cempia.com/"+emailDomain.getPathName()+"/tktRsln?_1="+emailDomain.getId()+"_"+fb.getBranchID()+"_"+t.getEscalationID()+"_"+t.getId()+" - Fernandez Hospital";

			}else if(fb.getCompanyID()==126) {
				smsLink=" Dear"+user.getUsername() +",CEMPIA Ticket No("+t.getTicketNumber()+") has been assigned to you for "+t.getFeedbackComments()+"from Patient - "+AESencrp.decrypt(fb.getName())+ "("+AESencrp.decrypt(fb.getContactNo())+") to take action click on https://cempia.com/"+emailDomain.getPathName()+"/tktRsln?_1="+emailDomain.getId()+"-"+fb.getBranchID()+"-"+t.getEscalationID()+"-"+t.getId();
			}
			else
		 smsLink=" Dear "+user.getUsername() +" the following ticket on "+t.getFactorName()+" is for your kind action. Please click on the link for additional details and resolution https://cempia.com/"+emailDomain.getPathName()+"/tktRsln?_1="+emailDomain.getId()+"_"+fb.getBranchID()+"_"+t.getEscalationID()+"_"+t.getId();
		try {
			smsService.sendSMS(user.getContactNo(), smsLink, fb.getCompanyID(), fb.getBranchID(),template);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			if(fb.getCompanyID()==124) {
				if(ccNumList != null) {
					for(int i= 0; i < ccNumList.length; i++) {
						 smsLink=" Dear "+user.getUsername()+", The following ticket on "+t.getFactorName()+" is for your kind action(generated from "+ChannelName+"). Please click on the link for additional details and resolution https://cempia.com/"+emailDomain.getPathName()+"/tktRsln?_1="+emailDomain.getId()+"_"+fb.getBranchID()+"_"+t.getEscalationID()+"_"+t.getId()+" - Fernandez Hospital";
						smsService.sendSMS(ccNumList[i], smsLink, fb.getCompanyID(), fb.getBranchID(),template);
						System.out.println(ccNumList[i]);
					}
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	}

}
