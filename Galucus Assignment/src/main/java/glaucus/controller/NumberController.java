package glaucus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import glaucus.service.NumberService;

//controller layer which will get the request from the client

@Controller
public class NumberController {

	NumberService numberService;
	@Autowired
	public  NumberController(NumberService numberService) {
		this.numberService = numberService;
	}
	
	//end-point which will will be called when the api is called .
	//The API will be : "http://localhost:8080/glaucus/increment/number"
	//PUT method is used to update the value with each call
	
	@RequestMapping(value="/increment/number" , method = RequestMethod.PUT,produces = "text/plain; charset=UTF-8")
	public @ResponseBody ResponseEntity<String> increaseAndUpdateNumber(){
		try {
			return new ResponseEntity<String>(numberService.increaseAndUpdateNumber(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
