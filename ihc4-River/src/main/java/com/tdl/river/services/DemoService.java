package com.tdl.river.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tdl.river.Repository.BranchDAO;
import com.tdl.river.Repository.TicketDAO;
import com.tdl.river.Repository.TicketEscalationDAO;
import com.tdl.river.Repository.TicketHistoryDAO;
import com.tdl.river.Repository.UserDao;
import com.tdl.river.models.Ticket;
import com.tdl.river.models.TicketHistory;
import com.tdl.river.models.Users;
import com.tdl.river.oauth.AESencrp;

@Service
public class DemoService {

	@Autowired
	UserDao userDao;

	@Autowired
	TicketDAO ticketDao;

	@Autowired
	TicketHistoryDAO ticketHistory;

	@Autowired
	BranchDAO branchDao;

	@Autowired
	TicketEscalationDAO ticketescaDao;

	HashMap<String, Object> response = new HashMap<>();

	public ResponseEntity<HashMap<String, Object>> getUserDetail(String email, String pass, int userId) {
		response.clear();
		Optional<Users> user = userDao.findById(userId);
		if (user.isPresent() && user.get().getEmail().contentEquals(email)
				&& user.get().getPCIPHERPASSWORD().equalsIgnoreCase(AESencrp.encrypt(pass))) {
			response.put("status", HttpStatus.OK.value());
			response.put("msg", "User login Succesfully !!");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.put("status", HttpStatus.NOT_FOUND.value());
			response.put("msg", "User Not Found");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<HashMap<String, Object>> getTicketDetails(int companyId, int ticketId, int userId) {
		response.clear();
		List<String[]> tktData = ticketDao.ticketResolutionDataVal(Integer.toString(companyId),
				Integer.toString(ticketId), Integer.toString(userId));
		for (int i = 0; i < tktData.get(0).length; i++) {
			if (i == 4)
				tktData.get(0)[i] = AESencrp.decrypt(tktData.get(0)[i]);

			if (tktData.get(0)[i] == null || tktData.get(0)[i].equals("null"))
				tktData.get(0)[i] = "";
		}
		response.put("status", HttpStatus.OK.value());
		response.put("tkdata", tktData.get(0));
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public ResponseEntity<HashMap<String, Object>> saveTktRsln(int companyId, int ticketId, int userId, int countryId,
			int status, String deptNote) {
		response.clear();
		try {
		Ticket t = new Ticket();
		Optional<Ticket> tkt = ticketDao.findById(ticketId);
		if (tkt.isPresent())
			t = tkt.get();
		int countryID = branchDao.findCountryID(t.getBranchID());
		t.setUpdated_date(getLocalTime(countryID, companyId));
		t.setStatus(status);
		t.setUpdated_by(userId);
		if (status == 3) {
			t.setClosedBy(userId);
			t.setClosedByDate(getLocalTime(countryID, companyId));
		}
		ticketDao.save(t);
		if (deptNote != null) {/// if dept note have some value;
			ticketescaDao.updatedepNoteTktRsn(getLocalTime(countryID, companyId), userId, deptNote, t.getId(),
					t.getCompanyID());
		}
		TicketHistory h = new TicketHistory();
		h.setTicketID(t.getId());
		h.setStatus(t.getStatus());
		h.setFollowup_note(deptNote);
		h.setUpdate_by(userId);
		h.setUpdate_date(getLocalTime(countryID,companyId));
		h.setCompanyID(t.getCompanyID());
		ticketHistory.save(h);
		response.put("status", HttpStatus.OK.value());
		response.put("msg", "Ticket Data Updated Successfully!!!");
		return new ResponseEntity<>(response, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			response.put("status", HttpStatus.EXPECTATION_FAILED.value());
			response.put("msg", "Ticket Data Updation Failed!!!");
			return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
		}
	}

	private LocalDateTime getLocalTime(int countryID, int companyID) {
		LocalDateTime ldt = null;
		if (companyID == 122 || companyID == 137) {
			ZoneId zoneId = ZoneId.of("Asia/Kuala_Lumpur");
			ldt = ldt.now(zoneId);
			// ldt = ldt.plusHours(8);
		} else {
			ldt = LocalDateTime.now().plusHours(5);
			ldt = ldt.plusMinutes(30);// Local date time
			String timeZone = "Asia/Calcutta";
			if (countryID == 2 || (companyID == 133 && countryID == 8))
				timeZone = "Asia/Kuala_Lumpur";// malaysia
			else if (countryID == 3)
				timeZone = "Asia/Ho_Chi_Minh";// vitename
			else if (countryID == 4)
				timeZone = "Asia/Jakarta";// indonesiya
			ZoneId zoneId = ZoneId.of(timeZone);
			ldt = ldt.now(zoneId);
		}
		return ldt;
	}
}
