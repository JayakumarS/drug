package com.drug.security;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.drug.common.Email;
import com.drug.employeeMaster.EmployeeMasterBean;
import com.drug.employeeMaster.EmployeeMasterService;
import com.drug.setup.roles.RolesMasterBean;
import com.drug.setup.roles.RolesMasterService;
import com.drug.usermanagement.User;
import com.drug.usermanagement.UserDetailsImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@Api(tags="Authentication", description="Manages Authentication operation")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	private EmployeeMasterService employeeMasterService;
	
	@Autowired
	private RolesMasterService rolesMasterService;
	
	@ApiOperation(value = "Sign In")
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		//loginRequest.setPassword(jwtUtils.decrypt(loginRequest.getPassword()));
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
//				.collect(Collectors.toList());
		List<RolesMasterBean>  roles = rolesMasterService.getLoginRoleList(userDetails.getUsername());
		Integer defaultRoleId =  roles.get(0).getRoleId();
		String defaultRole = roles.get(0).getRoleName();
		String mailIdReq = "cvivek7080@gmail.com";
		try {
			requestMail(mailIdReq);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles,true,"Sucess",defaultRoleId,defaultRole));
	}

	@ApiOperation(value = "Get user info by token")
	@GetMapping("/userbytoken")
	public Optional<User> getUserDetail(@RequestParam("token") String jwtToken) {
		Optional<User> userDetails = null;
		if (jwtToken != null && jwtUtils.validateJwtToken(jwtToken)) {
			String username = jwtUtils.getUserNameFromJwtToken(jwtToken);
			//userDetails = userRepository.findByUsername(username); // by Kannan for JPA
			try {
				userDetails = employeeMasterService.getEmployeeUserName(username);
			} catch (Exception e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			userDetails.get().setPassword(null);

		}
		return userDetails;
	}

	@ApiOperation(value = "Sign Up")
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody EmployeeMasterBean employeeMasterBean) {
//		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//			
//			return ResponseEntity.badRequest().body(new MessageResponse("Username is already taken!"));
//		}
//
//		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//			return ResponseEntity.badRequest().body(new MessageResponse("Email is already in use!"));
//		}

		// Create new user's account
		/*
		 * User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
		 * encoder.encode(signUpRequest.getPassword()));
		 */

		/*
		 * Set<String> strRoles = signUpRequest.getRole(); Set<Role> roles = new
		 * HashSet<>();
		 * 
		 * if (strRoles == null) { Role userRole =
		 * roleRepository.findByName(ERole.ROLE_USER) .orElseThrow(() -> new
		 * RuntimeException("Error: Role is not found.")); roles.add(userRole); } else {
		 * strRoles.forEach(role -> { switch (role) { case "admin": Role adminRole =
		 * roleRepository.findByName(ERole.ROLE_ADMIN) .orElseThrow(() -> new
		 * RuntimeException("Error: Role is not found.")); roles.add(adminRole);
		 * 
		 * break; default: Role userRole = roleRepository.findByName(ERole.ROLE_USER)
		 * .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		 * roles.add(userRole); } }); }
		 * 
		 * user.setRoles(roles); userRepository.save(user);
		 */
		
//		employeeMasterBean.setPassword(encoder.encode(employeeMasterBean.getPassword()));
//		EmployeeMasterResultBean insertAppUserMaster = employeeMasterService.addEmployeeMaster(employeeMasterBean); 
//		
		
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	//Mail
	
	private String requestMail(String mailId)
			throws Exception {
		Email email = new Email();
		StringBuffer sb = new StringBuffer();
		String path = "";
		email.setFromEmailAddress("info@talentchek.com");
		//mailId = "kathiravan@paragondynamics.in";
		String toMailAddress = mailId;
		String[] toEmailIds = toMailAddress.split(",");
		email.setToEmailAddress(toEmailIds);
		String logoImage = "https://visitorchek.com/assets/images/vc_logo_1.png";
		//String logoIdmage = "http://183.82.246.243/assets/images/vc_logo_1.png";
		//sb.append("<img style='width:86px;height:50px;' src="+logoImage+">");

 		sb.append("<!DOCTYPE html>\r\n");
		sb.append(
				"<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">");

		sb.append("<head>\r\n");
		sb.append("<meta charset=\"UTF-8\">");

		sb.append("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">");
		sb.append("<meta name=\"x-apple-disable-message-reformatting\">");

		sb.append("<style>");
		sb.append(" table, td, div, h1, p {font-family: Arial, sans-serif;}\r\n");
		
		sb.append("</style>");
		sb.append("</head>");

		sb.append("<h1 style=\\\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\\\">Your OTP Number is</h1>");
//		sb.append("<br>");
		sb.append("<h2 style=\\\\\\\"font-size:24px;margin:0 0 20px 0;font-family:Arial,sans-serif;\\\\\\\">12536</h2>");
		

		sb.append("</tr>");
		sb.append("</table>");

		sb.append("</td>");
		sb.append("</tr>");

		sb.append("</table>");
		sb.append("</td>");

		sb.append("</tr>");
		sb.append("</table>");

		sb.append("</body>");
		sb.append("</html>");

		email.setBodyHtml(sb.toString());
		email.setSubject("OTP Number");
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					sendMail(email, path);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();

		return path;
	}
	
	
	public static void sendMail(Email email, String path) throws Exception {

		String host = "smtpout.secureserver.net";
		// Create properties for the Session
		Properties props = System.getProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		// Get a session
		Session session = Session.getInstance(props);

		try {
			Transport bus = session.getTransport("smtp");

			bus.connect("smtpout.secureserver.net", "info@talentchek.com", "Talent@123456!");
			Message msg = new MimeMessage(session);

			// Set message attributes
			msg.setFrom(new InternetAddress(email.getFromEmailAddress()));

			int n = email.getToEmailAddress().length;
			InternetAddress[] address = new InternetAddress[n];
			for (int i = 0; i < n; i++) {
				address[i] = new InternetAddress(email.getToEmailAddress()[i]);

			}
			msg.setRecipients(Message.RecipientType.TO, address);
			
//			  String toAddress = "sgopes@gmail.com"; InternetAddress[] toAddresses = {
//			  new  InternetAddress(toAddress) };
//			  msg.setRecipients(Message.RecipientType.BCC,  toAddresses);
			 
			
			if (email.getCcEmailAddress() != null) {
				int ccCount = email.getCcEmailAddress().length;
				InternetAddress[] ccAddress = new InternetAddress[ccCount];
				for (int i = 0; i < ccCount; i++) {
					ccAddress[i] = new InternetAddress(email.getCcEmailAddress()[i]);
				}
				msg.setRecipients(Message.RecipientType.CC, ccAddress);
				
				
			}

			msg.setSubject(email.getSubject());
			msg.setSentDate(new Date());
			msg.setContent(email.getBodyHtml(), "text/html");
			msg.saveChanges();
			bus.sendMessage(msg, msg.getAllRecipients());
			bus.close();

		} catch (MessagingException mex) {
			mex.printStackTrace();
			while (mex.getNextException() != null) {
				Exception ex = mex.getNextException();
				ex.printStackTrace();
				if (!(ex instanceof MessagingException))
					break;
				else
					mex = (MessagingException) ex;
			}
			throw mex;
		} finally {
			System.out.println("mail core smtp Successfully");
		}
	}
	
}
