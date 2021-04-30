package com.example.demo.Service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Compte;
import com.example.demo.Repository.CompteRepository;




@RestController
@RequestMapping(value = "credit_card")
public class CreditCardService {
	@Autowired
	CompteRepository compteRepository;

	@Produces(MediaType.TEXT_PLAIN)
	@RequestMapping(path ="/auth/{p_email}/{p_pass}", method = RequestMethod.GET)
	//public boolean authentification(@RequestParam(name = "email", required = false) String  p_email,@RequestParam(name = "pass", required = false) String  pass) {
	public boolean authentification(@PathVariable String p_email, @PathVariable String p_pass) {	
		System.out.println(p_pass);
		Compte cp = compteRepository.findCompte(p_email,p_pass);
		if(cp!=null) {
			return true;
		}else {
			return false;
		}	
	}
	
	
	
	@Produces(MediaType.APPLICATION_JSON)
	@GetMapping("/Listobject")
	public List<Compte> getallwithService() {
		return compteRepository.findAll();
	}
	
	
	@PostMapping(path = "/members", consumes = "application/json", produces = "application/json")
	public boolean addMember(@RequestBody String member , HttpServletRequest request) {
		
		/*String[] params = member.split("&");     
	    for (String param : params) {           
	       System.out.println(param.split("=")[0]+" : "+param.split("=")[1]);
	    }*/
		System.out.println("==================================================");
		System.out.println("Json Paquet : "+paramJson(member));
		System.out.println("Votre Adresse IP : "+request.getRemoteAddr());
		System.out.println("Votre Session : "+request.getSession().getId());
		System.out.println("==================================================");
		
		
		
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(paramJson(member));
			String name = jsonObj.getString("Nom");
			System.out.println("Tbag : "+name);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	    return true;
	}
	
	public static String paramJson(String paramIn) {
	    paramIn = paramIn.replaceAll("=", "\":\"");
	    paramIn = paramIn.replaceAll("&", "\",\"");
	    return "{\"" + paramIn + "\"}";
	}
	
	@PostMapping(path = "/auth", consumes = "application/json", produces = "application/json")
	public boolean authPost(@RequestBody String member , HttpServletRequest request) {
		
		/*String[] params = member.split("&");     
	    for (String param : params) {           
	       System.out.println(param.split("=")[0]+" : "+param.split("=")[1]);
	    }*/
		System.out.println("==================================================");
		System.out.println("Json Paquet : "+member);
		System.out.println("Votre Adresse IP : "+request.getRemoteAddr());
		System.out.println("Votre Session : "+request.getSession().getId());
		System.out.println("==================================================");
	    return true;
	}

}
