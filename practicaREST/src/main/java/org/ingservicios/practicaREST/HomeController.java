package org.ingservicios.practicaREST;


import java.sql.Timestamp;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		boolean resul=false;
		if(dao.buscaMatricula(vehiculo.getMatricula())==null && vehiculo.getParkingId()==0) {
		dao.addVehiculo(vehiculo);
		
		
		}else if(dao.buscaMatricula(vehiculo.getMatricula())!=null && vehiculo.getParkingId()==1 
				&& dao.buscaParkingIDVehiculo(vehiculo.getParkingId())==null) {
			dao.addVehiculo(vehiculo);
			
		}else if(dao.buscaMatricula(vehiculo.getMatricula())!=null && dao.buscaParkingIDVehiculo(vehiculo.getParkingId())!=null 
				&& vehiculo.getParkingId()==0) {
			dao.updateCoche(vehiculo);
		}else {
			dao.updateCoche(vehiculo);
		}
		
		ResponseEntity<DTOVehiculos> respuestaHTTP = new ResponseEntity<DTOVehiculos>(vehiculo, HttpStatus.CREATED);
		return respuestaHTTP;
		
		
	}
	
	
	 @RequestMapping(value = "/pago", method = RequestMethod.GET)
		public String mostrarPago (Model model) {
			
				return "testcoste";
			
		} 
	 
	
	 //En el caso de solicitar los datos de un único elemento, es común identificarlo mediante un id 
	 //en la URL del recurso, para ello, Spring facilita la etiqueta @PathVariable
	 @RequestMapping(value="coste/{matricula}",method= RequestMethod.GET)
	 public @ResponseBody String coste(@PathVariable (value="matricula")String matricula,Model model) {
	 	String precio=""; 	
	 	/*
	 	DTOVehiculos vehiculos = new DTOVehiculos();
	 	vehiculos = dao.buscaMatricula(matricula);
	 	*/
	 	//Buscamos la matricula en BDDD
	 	if(dao.buscaMatricula(matricula)!=null) {
	 		int registroEntr=dao.buscaRegistroVehiculo(matricula, 0).getRegistro();
	 		int registroSali=dao.buscaRegistroVehiculo(matricula, 1).getRegistro();
	 		//obtenemos el tiempo de entrada y salida 
	 		Timestamp tentrada = dao.tentrada(registroEntr);
	 		Timestamp tsalida = dao.tsalida(registroSali);

	 		//comparamos que el tsalida sea mayor que tiempo de entrada	 		if(tsalida!=null && tentrada!=null && tsalida>=tentrada) {
	 		System.out.println("Segundos de estancia: "+((tsalida.getTime()-
	 				tentrada.getTime())/1000) );
	 		long tiempo = ((tsalida.getTime()-tentrada.getTime())/1000);
	 		long Tarifa=(long) 0.3456;
	 		long coste= tiempo * Tarifa ;
	 	
	        model.addAttribute("cos",coste) ;
	 	   
	 		precio = Long.toString(coste);


	 	return precio;
	 	}

	return precio;
}
}
