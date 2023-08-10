package com.example.coomunicator.demo.communcitcator.controller;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.support.incrementer.SybaseAnywhereMaxValueIncrementer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.coomunicator.demo.communcitcator.model.CommunicationModel;
import com.example.coomunicator.demo.communcitcator.model.loginmodel;
import com.example.coomunicator.demo.communcitcator.repository.loginrepo;
import com.example.coomunicator.demo.communcitcator.service.loginservice;


@RestController
public class logincontroller {


	private loginservice loginService;
	
	public logincontroller(loginservice loginService) {
		super();
		this.loginService = loginService;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/getall")
	public List<loginmodel> getall()
	{
		List<loginmodel> mean = loginService.getallrep();
		return mean;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/save")
	public loginmodel saveall(@RequestBody loginmodel saveelement)
	{
	loginmodel a = 	loginService.savellrep(saveelement);
		return a;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/checkarr")
    public boolean checkthedetails(@RequestBody loginmodel emailpass)
	{
		
      return loginService.checkthelogin(emailpass.getEmail(),emailpass.getPassword());
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/checktheidone")
	public long checktheidone(@RequestBody Map<String, String> requestBody)
	{
		String email = requestBody.get("email");
		return loginService.findByIId(email);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/setthestarter")
    public  void setthestarter(@RequestBody CommunicationModel starterlist)
    {
        long inptone =  starterlist.idOne;
        long inpttwo =   starterlist.idTwo;
      	loginService.findBytwoId(inptone, inpttwo, starterlist);
System.out.println(starterlist.idOne);
    }
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/addthemessage")
	public CommunicationModel updatethemessages(@RequestBody  CommunicationModel starterlist)
	{
		return loginService.addthemessage(starterlist);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/retrieveeachconvo")
	public CommunicationModel retrieveeachconvo(@RequestBody  CommunicationModel starterlist)
	{
		return loginService.geteachconv(starterlist);
	}	
	
	
	
}
