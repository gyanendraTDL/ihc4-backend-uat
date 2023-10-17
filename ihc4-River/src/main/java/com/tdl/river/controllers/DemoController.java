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
import com.tdl.river.services.DemoService;
import com.tdl.river.services.FeedbackService;

@RestController
@RequestMapping("/river/demo")
public class DemoController {

	@Autowired
	DemoService demoService;

	@GetMapping("/check")
	public String getCheck() {
		return "success";
	}

	@GetMapping("/userDetails")
	public ResponseEntity<HashMap<String, Object>> getUserDetails(HttpServletRequest request,
			@RequestParam String email, @RequestParam String userPass, @RequestParam int userId) {
		return demoService.getUserDetail(email, userPass, userId);
	}

	@GetMapping("/ticketDetails")
	public ResponseEntity<HashMap<String, Object>> getTicketDetails(HttpServletRequest request,
			@RequestParam int companyId, @RequestParam int ticketId, @RequestParam int userId) {
		return demoService.getTicketDetails(companyId, ticketId, userId);
	}

	@PostMapping("/saveTktRsln")
	public ResponseEntity<HashMap<String, Object>> saveTktRsln(HttpServletRequest request, @RequestParam int companyId,
			@RequestParam int ticketId, @RequestParam int userId, @RequestParam int countryId,
			@RequestParam String deptNote, @RequestParam int status) {
		return demoService.saveTktRsln(companyId, ticketId, userId, countryId, status, deptNote);
	}
	

}
