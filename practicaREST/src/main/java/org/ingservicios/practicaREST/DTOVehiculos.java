package org.ingservicios.practicaREST;

import java.sql.Timestamp;

public class DTOVehiculos {

	private int parkingId; //0 o 1
	private String matricula;
	private Timestamp fechaRegistro;
	private int registro;
	
	
	public DTOVehiculos(){
		this.parkingId=0;
		this.matricula="";
		this.fechaRegistro=null;
		this.registro=0;
	}
	
	
	public DTOVehiculos(int parkingID, String matricula, Timestamp fechaRegistro, int reg) {
		this.parkingId = parkingID;
		this.matricula = matricula;
		this.fechaRegistro = fechaRegistro;
		this.registro = reg;
	}
	
	
	

	public int getRegistro() {
		return registro;
	}


	public void setRegistro(int registro) {
		this.registro = registro;
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
