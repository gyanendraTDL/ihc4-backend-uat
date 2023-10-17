package com.tdl.river.controllers;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tdl.river.models.Feedback;
import com.tdl.river.models.Utility;
import com.tdl.river.services.FeedbackService;
import com.tdl.river.services.SmsAndQrService;

@RestController
@RequestMapping("/river/sms-qr")
public class SmsAndQrController {

	@Autowired
	FeedbackService feedbackService;

	@Autowired
	SmsAndQrService smsQrService;

	@PostMapping("/saveQrFb")
	public ResponseEntity<HashMap<String, Object>> saveQrFbRiver(HttpServletRequest request,
			@RequestBody Feedback feedback) {
		return smsQrService.saveQrFeedback(feedback);
	}

	@GetMapping("/getbranachData")
	public ResponseEntity<HashMap<String, Object>> getBranchData(HttpServletRequest request,
			@RequestParam int branchId) {
		return smsQrService.getBranchData(branchId);
	}

}
