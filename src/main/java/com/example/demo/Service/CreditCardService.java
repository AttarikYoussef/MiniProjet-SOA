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
import com.example.demo.Entity.CreditCard;
import com.example.demo.Entity.Historique;
import com.example.demo.Repository.CompteRepository;
import com.example.demo.Repository.CreditCardRepository;
import com.example.demo.Repository.HistoriqueRepository;




@RestController
@RequestMapping(value = "credit_card")
public class CreditCardService {
	@Autowired
	CompteRepository compteRepository;
	@Autowired
	HistoriqueRepository historique;
	@Autowired
	CreditCardRepository card;

//	@Produces(MediaType.TEXT_PLAIN)
//	@RequestMapping(path ="/auth/{p_email}/{p_pass}", method = RequestMethod.GET)
//	//public boolean authentification(@RequestParam(name = "email", required = false) String  p_email,@RequestParam(name = "pass", required = false) String  pass) {
//	public boolean authentification(@PathVariable String p_email, @PathVariable String p_pass) {	
//		System.out.println(p_pass);
//		Compte cp = compteRepository.findCompte(p_email,p_pass);
//		if(cp!=null) {
//			return true;
//		}else {
//			return false;
//		}	
//	}
	
	
	
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
		char test = member.charAt(0);
		try {
			if(test=='{') {
				jsonObj = new JSONObject(member);
				String name = jsonObj.getString("Title");
				System.out.println("Tbag : "+name);
			}else {
				jsonObj = new JSONObject(paramJson(member));
				String name = jsonObj.getString("Nom");
				System.out.println("Tbag : "+name);
			}
			
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
		System.out.println("====================Authentification===========================");
		System.out.println("Json Paquet : "+member);
		System.out.println("Votre Adresse IP : "+request.getRemoteAddr());
		System.out.println("Votre Session : "+request.getSession().getId());
		System.out.println("===============================================================");
		
		JSONObject jsonObj;
		char test = member.charAt(0);
		boolean res = false;
		try {
			if(test=='{') {
				jsonObj = new JSONObject(member);
				Compte cp = compteRepository.findCompte(jsonObj.getString("login"),jsonObj.getString("pass"));
				if(cp!=null) {
					res = true;
					historique.save(new Historique(compteRepository.findCompteEmail(jsonObj.getString("login")),getdatestring(), "Authentification"));

				}else {
					res = false;
				}	
			}else {
				jsonObj = new JSONObject(paramJson(member));				
				Compte cp = compteRepository.findCompte(jsonObj.getString("login"),jsonObj.getString("pass"));
				if(cp!=null) {
					res = true;
					historique.save(new Historique(compteRepository.findCompteEmail(jsonObj.getString("login")),getdatestring(), "Authentification"));
				}else {
					res = false;
				}	
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping(path ="/getCompte/{p_email}", method = RequestMethod.GET)
	public Compte getCompte(@PathVariable String p_email) {	
		System.out.println(p_email);
		Compte cp = compteRepository.findCompteEmail(p_email);
		if(cp!=null) {
			System.out.println(cp);
			return cp;
		}else {
			return null;
		}
	}
	
	public String getdatestring() {
		 java.util.Date dt = new java.util.Date();
		    java.text.SimpleDateFormat sdf = 
		         new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String currentTime = sdf.format(dt);
		    return currentTime;
	}
	
	@PostMapping(path = "/create", consumes = "application/json", produces = "application/json")
	public boolean createPost(@RequestBody String member , HttpServletRequest request) {
		boolean res=false;
		try {
			JSONObject jsonObj = new JSONObject(member);
			Compte cp = compteRepository.findCompteEmail(jsonObj.getString("email_C"));
			if(cp!=null) {
				res =  false;
				historique.save(new Historique(compteRepository.findCompteEmail(jsonObj.getString("email_C")),getdatestring(), "Attaque de Pirate"));
			}
			else {
				compteRepository.save(new Compte(jsonObj.getString("nom_C"), jsonObj.getString("prenom_C"), jsonObj.getString("email_C"), jsonObj.getString("password_C")));
				res =  true;
				historique.save(new Historique(compteRepository.findCompteEmail(jsonObj.getString("email_C")),getdatestring(), "Creation de Compte"));
			}
			
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return res;
	}
	
	@PostMapping(path = "/createCard", consumes = "application/json", produces = "application/json")
	public boolean cardPost(@RequestBody String member , HttpServletRequest request) {
		boolean res=false;
		CreditCard cd;
		try {
			JSONObject jsonObj = new JSONObject(member);
			cd = card.getCardID(jsonObj.getLong("id_C"));
			if(cd!=null) {
				res = false;
			}else {
				boolean resLuhn = ValidateCard(""+jsonObj.getLong("id_C"));
				if(resLuhn==true) {
					res = true;
					card.save(new CreditCard(jsonObj.getLong("id_C"),compteRepository.findCompteEmail(jsonObj.getString("email_C")),getdatestring()));
					historique.save(new Historique(compteRepository.findCompteEmail(jsonObj.getString("email_C")),getdatestring(), "Creation de la Carte"));

				}else {
					res = false;
				}
				
				
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}
	
	public boolean ValidateCard (String ccNumber) {
		int sum = 0;
        boolean alternate = false;
        for (int i = ccNumber.length() - 1; i >= 0; i--)
        {
                int n = Integer.parseInt(ccNumber.substring(i, i + 1));
                if (alternate)
                {
                        n *= 2;
                        if (n > 9)
                        {
                                n = (n % 10) + 1;
                        }
                }
                sum += n;
                alternate = !alternate;
        }
        return (sum % 10 == 0);
	
	}
}
