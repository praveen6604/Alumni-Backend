package com.alumni.backend.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alumni.backend.model.Alumni;
import com.alumni.backend.model.AuthenticationRequest;
import com.alumni.backend.model.AuthenticationResponse;
import com.alumni.backend.model.Event;
import com.alumni.backend.model.Follow;
import com.alumni.backend.model.Give;
import com.alumni.backend.model.JobPosting;
import com.alumni.backend.model.ValidationResponse;
import com.alumni.backend.repository.AlumniRepository;
import com.alumni.backend.repository.EventRepository;
import com.alumni.backend.repository.FollowRepository;
import com.alumni.backend.repository.GiveRepository;
import com.alumni.backend.repository.JobPostingRepository;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/alumni")
public class AlumniController {
	
	private static final Logger logger = LoggerFactory.getLogger(AlumniController.class);
	
	@Autowired
	private AlumniRepository alumniRepo;
	
	@Autowired
	private JobPostingRepository jobRepo;
	
	@Autowired
	private EventRepository eventRepo;
	
	@Autowired
	private FollowRepository followRepo;
	
	@Autowired
	private GiveRepository giveRepo;
	
	@GetMapping("/getAllAlumni")
	public List<Alumni> getAllAlumni() {
		return alumniRepo.findAll();
	}
	
	@GetMapping("/getAllAlumni/{id}")
	public Optional<Alumni> getEmployee(@PathVariable(value = "id") int alumniId) {
		 Optional<Alumni> alumni = alumniRepo.findById(alumniId);
		 if (!alumni.isPresent()) {
			 System.out.println("Alumni not found");
			 logger.info("Alumni not found");
		 }
		 return alumni;
	}
	
	@PostMapping("/saveAlumni")
	public Alumni createAlumni(@RequestBody Alumni alumni) {
	 return alumniRepo.save(alumni);
	}
	
	@PostMapping("/saveAlumni/{id}")
	public Alumni createAlumni(@PathVariable(value = "id") int alumniId,@RequestBody Alumni alumni) {
		 Optional<Alumni> alumniFind = alumniRepo.findById(alumniId);
		 if (!alumniFind.isPresent()) {
			 System.out.println("Alumni not found");
			 logger.info("Alumni not found");
		 } else {
			 alumniRepo.save(alumni);
		 }
	 return alumni;
	}
	
	@GetMapping("/getAllJobs")
	public List<JobPosting> getAllJobs() {
		return jobRepo.findAll();
	}
	
	@PostMapping("/createJobPost")
	public JobPosting createJobPost(@RequestBody JobPosting job) {
	 return jobRepo.save(job);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationTokenAndLogin(@RequestBody AuthenticationRequest request){
		HttpHeaders headers = new HttpHeaders();
		headers.add("ContentType", MediaType.APPLICATION_JSON_VALUE);
		if(null!=request.getEmail() && null!=request.getPassword()) {
			String authenticatedUserId = doLogin(request.getEmail(), request.getPassword());
			if(null!=authenticatedUserId) {
				logger.info("User is authenticated!!");
				AuthenticationResponse authenticationResponse = new AuthenticationResponse();
				authenticationResponse.setMessage("User authentication success");
				authenticationResponse.setUserId(authenticatedUserId);
				return ResponseEntity.ok().headers(headers).body(authenticationResponse);
			}else {
				logger.error("User Authentication failed for " + request.getEmail());
				AuthenticationResponse authenticationResponse = new AuthenticationResponse();
				authenticationResponse.setMessage("User authentication failed");
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).headers(headers).body(authenticationResponse);
			}
		}else {
//			Logger.error("Request is empty. Throwing validation error");
			ValidationResponse validationResponse = new ValidationResponse();
			validationResponse.setMessage("Request is invalid");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(validationResponse);
		}
		}
	
	
	@RequestMapping("/getEventsEnrollmentForAUser/{userId:[\\d]+}")
	public ResponseEntity<?> getEventsAndEnrollmentForAUser(@PathVariable("userId") String userId) throws InterruptedException, ExecutionException{
//		LOGGER.info("Get Event enrollments");
		HttpHeaders headers = new HttpHeaders();
		headers.add("ContentType", MediaType.APPLICATION_JSON_VALUE);
		try {
			int userIdValid = Integer.parseInt(userId);
			return ResponseEntity.ok(eventRepo.findAll());
		} catch (NumberFormatException e) {
//			LOGGER.error("Passed UserId is not valid. Throwing validation error");
			ValidationResponse validationResponse = new ValidationResponse();
			validationResponse.setMessage("UserId is invalid");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(validationResponse);
		}
	}
	
	@PostMapping("/updateEventsEnrollment")
	public Event createJobPost(@RequestBody Event event) {
	 return eventRepo.save(event);
	}
	
	@PostMapping("/createFollowerForAUser")
	public ResponseEntity<?> createFollowEnrollment(@RequestBody Follow follow) {
//		LOGGER.info("Enrolling to an Followe for a user");
//		int createdparticipant = alumniService.createFollowing(follow);
		return ResponseEntity.ok(followRepo.save(follow));
//		if(createdparticipant !=0) {
//			return ResponseEntity.ok(createdparticipant);
//		}
//		ValidationResponse response = new ValidationResponse();
//		response.setMessage("Follow enrollment Failure. Please try again");
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	
	@GetMapping("/findAllFollowers/{id}")
	public List<Follow> getAllFollowers(@PathVariable(value = "id") int followerId) {
	    return followRepo.findAll();
	}
	
	@PostMapping("/saveFund")
	public Give saveFund(@RequestBody Give fund) {
	    return giveRepo.save(fund);
	}
		
	public String doLogin(String emailId, String password) {
		Alumni alumni = alumniRepo.findByAlumniEmail(emailId);
		
		return alumni!=null ? alumni.getPassword().equals(password) ? String.valueOf(alumni.getAlumniId()): null : null;
	}

}
