package org.ingservicios.practicaREST;

import java.sql.Timestamp;

public class DTOVehiculos {

	private int parkingId; //0 o 1
	private String matricula;
	private Timestamp fechaRegistro;
	
	
	public DTOVehiculos(){
		this.parkingId=0;
		this.matricula="";
		this.fechaRegistro=null;
	}
	
	
	public DTOVehiculos(int parkingID, String matricula, Timestamp fechaRegistro) {
		this.parkingId = parkingID;
		this.matricula = matricula;
		this.fechaRegistro = fechaRegistro;
	}
	

	
	public int getParkingId() {
		return parkingId;
	}


	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}


	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
	
}
