package org.ingservicios.practicaREST;

import java.sql.Timestamp;

public class DTOVehiculos {

	private int registro;
	private int parkingID;
	private String matricula;
	private Timestamp fechaRegistro;
	
	
	public DTOVehiculos() {
		this.registro=0;
		this.parkingID=0;
		this.matricula="";
		this.fechaRegistro=null;
	}
	
	
	public DTOVehiculos(int registro, int parkingID, String matricula, Timestamp fechaRegistro) {
		this.registro = registro;
		this.parkingID = parkingID;
		this.matricula = matricula;
		this.fechaRegistro = fechaRegistro;
	}
	
	public int getRegistro() {
		return registro;
	}
	public void setRegistro(int registro) {
		this.registro = registro;
	}
	public int getParkingID() {
		return parkingID;
	}
	public void setParkingID(int parkingID) {
		this.parkingID = parkingID;
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
