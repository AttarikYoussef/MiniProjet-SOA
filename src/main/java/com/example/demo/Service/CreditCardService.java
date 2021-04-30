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
	
	
	public static String paramJson(String paramIn) {
	    paramIn = paramIn.replaceAll("=", "\":\"");
	    paramIn = paramIn.replaceAll("&", "\",\"");
	    return "{\"" + paramIn + "\"}";
	}
	
	
	@PostMapping(path = "/authentification", consumes = "application/json", produces = "application/json")
	public boolean authentification(@RequestBody String info) {
		
		String email ="";
		String pass = "";
		JSONObject jsonObj;
		try {
			jsonObj = new JSONObject(paramJson(info));
			 email = jsonObj.getString("login");
			 pass = jsonObj.getString("pass");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		Compte cp = compteRepository.findCompte(email,pass);
		if(cp!=null) {
			return true;
		}else {
			return false;
		}	
	}
	
	
}
