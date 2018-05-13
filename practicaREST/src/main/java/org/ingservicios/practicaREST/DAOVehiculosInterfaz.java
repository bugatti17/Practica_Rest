package org.ingservicios.practicaREST;

import java.sql.Timestamp;
import java.util.List;

public interface DAOVehiculosInterfaz {

	public void addVehiculo(DTOVehiculos vehiculo);
	
	public List<DTOVehiculos> leeVehiculos();
	
	public DTOVehiculos buscaMatricula(String matricula);
	
	public DTOVehiculos buscaRegistroVehiculo(String matricula, int parkingID);
	
	public DTOVehiculos buscaParkingIDVehiculo(int id);
	
	public void updateCoche(DTOVehiculos vehiculo);
	
	public Timestamp tsalida(int registro);

	public Timestamp tentrada(int registro);
}
