package com.tdl.river.services;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.tdl.river.Repository.BranchDAO;
import com.tdl.river.Repository.FeedbackDao;
import com.tdl.river.models.Branch;
import com.tdl.river.models.Feedback;
import com.tdl.river.models.Utility;
import com.tdl.river.util.services.CreateTicketService;
import com.tdl.river.util.services.TaskService;

@Service
public class SmsAndQrService {

	@Autowired
	BranchDAO branchDao;

	@Autowired
	FeedbackDao feedbackDao;
	
	@Autowired
	TaskService taskService;

	@Autowired
	@Qualifier("taskExceutor")
	private Executor executor;

	@Autowired
	CreateTicketService createTService;

	HashMap<String, Object> response = new HashMap<>();

	public ResponseEntity<HashMap<String, Object>> saveQrFeedback(Feedback fb) {
		Integer fbId = feedbackDao.checkDuplicate(fb.getCreated_date(), fb.getChannelID(), fb.getFeedback(),
				fb.getRating(), fb.getName(), fb.getRefNo(), fb.getType(), fb.getCompanyID(), fb.getContactNo());
		response.clear();
		fb.setCreated_date(Utility.getLocalTime(fb.getCountryID(), fb.getCompanyID()));
		long diff = 0;
		int feedbackID = 0;
		if (fbId == null || fbId == 0) {
			LocalDateTime time = feedbackDao.checkDifference(fb.getChannelID(), fb.getFeedback(), fb.getRating(),
					fb.getName(), fb.getRefNo(), fb.getType(), fb.getCompanyID(), fb.getContactNo());
			if (time != null) {
				LocalDateTime currTime = Utility.getLocalTime(fb.getCountryID(), fb.getCompanyID());
				if (fb.getCompanyID() == 133 && fb.getChannelID() == 3)
					diff = ChronoUnit.DAYS.between(time, currTime);
				else
					diff = ChronoUnit.MINUTES.between(time, currTime);
			} else
				diff = -1;
		} else {

		}
		if (diff > 30 || diff == -1) {
			feedbackID = feedbackDao.save(fb).getId();
		}
		//taskService.calculatePsi(fb);
//		CompletableFuture.runAsync(() -> createTService.createTicket(12, fb), executor).exceptionally(e -> {
//			// log.error(e.getMessage(), e);
//			return null;
//		});

		response.put("status", HttpStatus.OK.value());
		response.put("feedbackId", feedbackID);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	public ResponseEntity<HashMap<String, Object>> getBranchData(int branchId) {
		response.clear();
		Optional<Branch> branch = branchDao.findById((long) branchId);
		response.put("branchID", branch.get().getId());
		response.put("companyID", branch.get().getCompanyID());
		response.put("countryID", branch.get().getCountryID());
		response.put("created_by", taskService.getcreatedBy(branchId));
		response.put("status", HttpStatus.OK.value());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
