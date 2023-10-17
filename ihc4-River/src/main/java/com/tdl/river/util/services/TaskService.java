package com.tdl.river.util.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import com.tdl.river.Repository.CompanyDAO;
import com.tdl.river.Repository.FactorNameDao;
import com.tdl.river.Repository.FeedbackDao;
import com.tdl.river.models.Company;
import com.tdl.river.models.FactorName;
import com.tdl.river.models.Feedback;
import com.tdl.river.util.models.ScoreCard;

@Service
public class TaskService {
	
	@Autowired
	FactorNameDao factorDao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	CompanyDAO companyDao;
	
	@Autowired
	FeedbackDao feedbackDao;

	public int getcreatedBy(int branch) {
		int createdBy = 0;
		switch (branch) {
		case 1:
			createdBy = 1093;
			break;
		case 2:
			createdBy = 1094;
			break;
		case 3:
			createdBy = 1095;
			break;
		case 4:
			createdBy = 1096;
			break;
		case 5:
			createdBy = 1097;
			break;
		case 6:
			createdBy = 1098;
			break;
		case 7:
			createdBy = 1099;
			break;
		case 8:
			createdBy = 1100;
			break;
		case 9:
			createdBy = 1101;
			break;
		case 10:
			createdBy = 1102;
			break;
		case 11:
			createdBy = 1103;
			break;
		case 12:
			createdBy = 1104;
			break;
		case 13:
			createdBy = 1105;
			break;
		case 14:
			createdBy = 1106;
			break;
		case 15:
			createdBy = 1107;
			break;
		case 16:
			createdBy = 1108;
			break;
		case 17:
			createdBy = 1109;
			break;
		case 18:
			createdBy = 1110;
			break;
		case 19:
			createdBy = 1111;
			break;
		case 20:
			createdBy = 1112;
			break;
		case 21:
			createdBy = 1113;
			break;
		case 22:
			createdBy = 1114;
			break;
		case 23:
			createdBy = 1115;
			break;
		case 24:
			createdBy = 1116;
			break;
		case 25:
			createdBy = 1117;
			break;
		case 26:
			createdBy = 1118;
			break;
		case 27:
			createdBy = 1119;
			break;
		case 28:
			createdBy = 1120;
			break;
		case 29:
			createdBy = 1121;
			break;
		case 30:
			createdBy = 1122;
			break;
		case 31:
			createdBy = 1092;
			break;
		default:
			createdBy = 0;
			break;
		}
		return createdBy;

	}
	
	@SuppressWarnings("unchecked")
	public void calculatePsi(Feedback fb) {
		try {
			List<FactorName> factorList = factorDao.getFactorQue(fb.getType(), fb.getCompanyID());
			String query=" select ";
			for(int i=0;i<factorList.size();i++) {
				FactorName fName = factorList.get(i);
				query+="_"+fName.getColQue();
				if(i!=factorList.size()-1)
					query+=",";
			}
			query+=" from ifb_feedback fb where fb.id="+fb.getId();
			List<List<Integer>>  ListOfitems=jdbcTemplate.query(query , new RowMapper<List<Integer>>() {
				@Override
				public List<Integer> mapRow(ResultSet rs, int rowNum) throws SQLException {
					List<Integer> l = new ArrayList<>();
					for (int i = 0; i < factorList.size(); i++) {
					FactorName fName =factorList.get(i);
						String key = "_"+fName.getColQue();
						l.add(rs.getInt(key));
					}
					return l;
				}
			} );
			
			Map<FactorName, int[]> facMap = new LinkedHashMap<>();
			int i=0;
			for (List<Integer> list : ListOfitems) {
				for (FactorName fName : factorList) {
					int[] arr = new int[6];
					int val = list.get(i);
					arr[val]++;
					facMap.put(fName, arr);
					i++;
				}
			}
		
		ModelMap map = new ModelMap();	
		int psiRating=-1;
		String psi="-1";
		if(facMap!=null && facMap.size()!=0) {
			preparePsiVal(facMap, fb.getCompanyID(), map);
		 psi = (String) map.getAttribute("psi");
		 Company company = companyDao.getHisData(fb.getCompanyID());
		 if(Double.valueOf(psi)>=company.getHighPsi())
			 psiRating=2;
		 else if(Double.valueOf(psi)>=company.getMediumPsi() && Double.valueOf(psi)<company.getHighPsi())
				 psiRating=1;
		 else if(Double.valueOf(psi)<=company.getLowPsi() && Double.valueOf(psi)>0)
			 psiRating=0;
		}
		 
		feedbackDao.updateFbpsi(fb.getId(),psiRating,psi);
			
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		
	}

	 public void preparePsiVal(Map<FactorName, int[]> facMap, Integer companyID, ModelMap map) {
		List<ScoreCard> scoreCard = new LinkedList<>();
		List<ScoreCard> subCard = new LinkedList<>();
		DecimalFormat df1 = new DecimalFormat("###.#");
		DecimalFormat df2 = new DecimalFormat("###.##");
		FactorName headerFactor = null;
		double psiVal = 0;
		int psiCounter = 0;
		double subVal = 0;
		int subCounter = 0;
		for (Map.Entry<FactorName, int[]> entry : facMap.entrySet()) {
			FactorName factor = entry.getKey();
			if (factor.getIsHeader() == 1) {
				double score = 0;
				if (subCard != null && subCard.size() != 0) {
					/*
					 * sub service and service value are mapped to scorcard clearing subcard to fill
					 * next set of sub service
					 * 
					 */
					score = mapData(subVal, subCounter, scoreCard, df1, headerFactor, subCard);
					psiVal = psiVal + score;
					if (score > 0)
						psiCounter++;
					subCard = new ArrayList<>();
					subVal = 0;
					subCounter = 0;

				}
				if (factor.getHaveSubQue() == 1)
					headerFactor = factor;
				else {
					score = fillMapPsi(factor, entry.getValue(), scoreCard, 0); // CurrentFactor,fbValue,scorecard
																				// list,headerformSequence

					/*
					 * Calculating PSI based on weighted average
					 * 
					 */
					psiVal = psiVal + score;
					if (score > 0)
						psiCounter++;
				}

			} else {
				double score = fillMapPsi(factor, entry.getValue(), subCard,
						(headerFactor == null) ? 0 : headerFactor.getFormSequence());// CurrentFactor,fbValue,subservice
																						// list,headerformSequence
				subVal = subVal + score;
				if (score != 0)
					subCounter++;
			}

		}
		if (subCard != null && subCard.size() != 0) {
			/*
			 * last value
			 * 
			 */
			double score = mapData(subVal, subCounter, scoreCard, df1, headerFactor, subCard);
			psiVal = psiVal + score;
			if (score > 0)
				psiCounter++;
		}
		if (psiCounter > 0) {
			map.addAttribute("psi", df2.format(psiVal / psiCounter));
		} else
			map.addAttribute("psi", df2.format(psiVal));
		map.addAttribute("scoredData", scoreCard);

	}
	
	 private double mapData(double subVal, int subCounter, List<ScoreCard> scoreCard, DecimalFormat df1,
				FactorName headerFactor, List<ScoreCard> subCard) {
			ScoreCard sc = new ScoreCard();
			sc.setHasSubQue(headerFactor.getHaveSubQue());
			sc.setIsHeader(1);
			sc.setId(headerFactor.getId());
			sc.setFactorName(headerFactor.getFactor_name());
			double score = 0;
			if (subCounter != 0)
				score = subVal / subCounter;
			else
				score = subVal;
			if (score >= 70)
				sc.setColor("green");
			else if (score >= 50 && score < 70)
				sc.setColor("orange");
			else if (score < 50 && score != 0)
				sc.setColor("red");
			else
				sc.setColor("black");
			if (score == 0)
				sc.setServiceScore("NA");
			else
				sc.setServiceScore(df1.format(score));
			sc.setIndex(headerFactor.getFormSequence() + "");
			scoreCard.add(sc);// header
			for (ScoreCard subService : subCard) {
				scoreCard.add(subService);// subservice
			}

			return score;
		}
	 private double fillMapPsi(FactorName factor, int[] ar, List<ScoreCard> scoreCard, int headerIndex) {
			ScoreCard subCard = new ScoreCard();
			double scoreVal = 0;
			DecimalFormat df1 = new DecimalFormat("###.#");
			DecimalFormat df2 = new DecimalFormat("###.##");
			double total = ar[1] + ar[2] + ar[3] + ar[4] + ar[5];
			subCard.setFactorName(factor.getFactor_name());
			subCard.setPoor(ar[1]);
			subCard.setAvg(ar[2]);
			subCard.setNeutral(ar[3]);
			subCard.setGood(ar[4]);
			subCard.setExcellent(ar[5]);
			subCard.setIsHeader(factor.getIsHeader());
			subCard.setId(factor.getId());
			if (factor.getIsHeader() == 1)
				subCard.setIndex(factor.getFormSequence() + "");
			else
				subCard.setIndex(headerIndex + "." + factor.getFormSequence());
			if (total != 0) {
				subCard.setExcellentPer(df1.format((subCard.getExcellent() / total) * 100));
				subCard.setGoodPer(df1.format((subCard.getGood() / total) * 100));
				subCard.setNeutralPer(df1.format((subCard.getNeutral() / total) * 100));
				subCard.setAvgPer(df1.format((subCard.getAvg() / total) * 100));
				subCard.setPoorPer(df1.format((subCard.getPoor() / total) * 100));
				double score = 0;
				if (factor.getCommpanyid().equals("1") && factor.getPointers() == 3) {
					score = (double) (ar[1] * 1 + ar[2] * 2 + ar[3] * 3) / (total * 3);
					score = score * 100;

				} else if (factor.getCommpanyid().equals("127") && factor.getPointers() == 3) {
					score = (double) (ar[1] * 1 + ar[3] * 2 + ar[5] * 3) / (total * 3);
					score = score * 100;
				} else if (factor.getCommpanyid().equals("126") || factor.getCommpanyid().equals("123")) {
					score = (double) (ar[1] * 1 + ar[2] * 2 + ar[3] * 3) / (total * 3);
					score = score * 100;
				} else if (factor.getPointers() == 5 || factor.getPointers() == 3) {
					score = (double) (ar[1] * 1 + ar[2] * 2 + ar[3] * 3 + ar[4] * 4 + ar[5] * 5) / total;
					score = score * 20;
				} else if (factor.getPointers() == 4) {
					score = (double) (ar[1] * 1 + ar[2] * 2 + ar[3] * 3 + ar[4] * 4) / total;
					score = score * 100 / 4;
				}

				if (factor.getIsHeader() == 1)
					subCard.setServiceScore(df1.format(score));
				else
					subCard.setSubServiceScore(df1.format(score));// sub serv

				scoreVal = score;// for psi cal
				if (score >= 70)
					subCard.setColor("green");
				else if (score >= 50 && score < 70)
					subCard.setColor("orange");
				else if (score < 50)
					subCard.setColor("red");
				else
					subCard.setColor("black");

			} else {
				if (factor.getIsHeader() == 1)
					subCard.setServiceScore("NA");
				else
					subCard.setSubServiceScore("NA");// sub serv
			}
			scoreCard.add(subCard);
			return scoreVal;
		}

}
