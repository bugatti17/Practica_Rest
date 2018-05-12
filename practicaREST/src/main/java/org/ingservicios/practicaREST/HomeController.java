package org.ingservicios.practicaREST;


import java.util.Locale;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	//Al marcarlo con @Autowired, se inyectará, como una instancia de dao, 
		//un bean de una clase que implemente el interfaz DAOVehiculosInterfaz
		@Autowired
		private DAOVehiculosInterfaz dao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "testparking";
	}
	
	
	@RequestMapping(value="/registroMatricula/enviar", method = RequestMethod.POST)
	public ResponseEntity<DTOVehiculos> crearVehiculo(@RequestBody DTOVehiculos vehiculo){
		dao.addVehiculo(vehiculo);
		
		ResponseEntity<DTOVehiculos> respuestaHTTP = new ResponseEntity<DTOVehiculos>(vehiculo, HttpStatus.CREATED);
		return respuestaHTTP;
		
	}
	
	@RequestMapping(value = "/testparking", method= RequestMethod.GET)
	public String testParking (Locale locale, Model model) {
		
		return "";
	}
	
}
