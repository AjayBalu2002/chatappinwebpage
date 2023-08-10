package com.example.coomunicator.demo.communcitcator.service;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.coomunicator.demo.communcitcator.model.CommunicationModel;
import com.example.coomunicator.demo.communcitcator.model.MessageModel;
import com.example.coomunicator.demo.communcitcator.model.loginmodel;
import com.example.coomunicator.demo.communcitcator.repository.communicationrepo;
import com.example.coomunicator.demo.communcitcator.repository.loginrepo;


@Service
public class loginservice {
	private loginrepo loginRepo;
	private communicationrepo commrepo;
	
	
	public loginservice(loginrepo loginRepo,communicationrepo commrepo)
	{
		this.loginRepo = loginRepo;
		this.commrepo=commrepo;
	}

	
	public List<loginmodel> getallrep()
	{
		
		List<loginmodel> allitem = loginRepo.findAll();
		return allitem;
	}
	
	public loginmodel savellrep(loginmodel modul)
	{
		 return loginRepo.save(modul);
	}
	
	
	public boolean checkthelogin(String email,String password)
	{
		int inc = 0;
		if(loginRepo.findByEmail(email)==null)
		{
			inc++;
		}
		if(loginRepo.findByPassword(password)==null)
		{
			inc++;
		}
		if(inc==0)
		{
			return true;
		}
		return false;
	
	
	}
	
	
	public long findByIId(String email )
	{
	if(loginRepo.findByEmail(email).getId()==null)
	{
	return 0;	
	}
	else
	{
		return loginRepo.findByEmail(email).getId();
	}
	
		
	}
	
	public void findBytwoId(long inptone,long inpttwo,CommunicationModel starterlist)
	{
		
		List<CommunicationModel> a=	commrepo.findAll();
	    boolean found = false;

	    for (CommunicationModel ids : a) {
	        if ((ids.idOne == inptone && ids.idTwo == inpttwo) || (ids.idOne == inpttwo && ids.idTwo == inptone)) {
	            found = true;
	            break;
	        }
	    }

	    if (!found) {
	        // post
	       
	    	commrepo.save(starterlist);
	       
	    }
	
	  

	
	
	}
	
	
	public CommunicationModel addthemessage(CommunicationModel starterlist)
	{
		long inptone = starterlist.idOne ;
		long inpttwo = starterlist.idTwo ;
	    List<CommunicationModel> communicationModels = commrepo.findAll();

	    CommunicationModel dummy = null;
	    for (CommunicationModel communicationModel : communicationModels) {
	        if ((communicationModel.getIdOne() == inptone && communicationModel.getIdTwo() == inpttwo) ||
	            (communicationModel.getIdOne() == inpttwo && communicationModel.getIdTwo() == inptone)) {
	        	communicationModel.getMessages().addAll(starterlist.getMessages());   
	        	commrepo.save(communicationModel);
	        	return communicationModel;
	        }
	    }
	    
	  
		return dummy;
		
		
	}
	
	
	public CommunicationModel geteachconv(CommunicationModel starterlist)
	{
		long inptone = starterlist.idOne ;
		long inpttwo = starterlist.idTwo ;
		  List<CommunicationModel> communicationModels = commrepo.findAll();
	    CommunicationModel dummy = null;
	    for (CommunicationModel communicationModel : communicationModels) {
	        if ((communicationModel.getIdOne() == inptone && communicationModel.getIdTwo() == inpttwo) ||
	            (communicationModel.getIdOne() == inpttwo && communicationModel.getIdTwo() == inptone)) {
	        
	        	return communicationModel;
	        }
	    }
	    
	  
		return dummy;	
		
	}
	
	
	
	
	
}
