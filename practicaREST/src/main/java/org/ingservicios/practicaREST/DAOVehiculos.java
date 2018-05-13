package org.ingservicios.practicaREST;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.ingservicios.practicaREST.VehiculosMapper;
import org.ingservicios.practicaREST.DTOVehiculos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DAOVehiculos implements DAOVehiculosInterfaz {
	//Añadir libreria spring-jdbc y dependencia junto a la versión
	public JdbcTemplate jdbcTemplate;
	//private DataSource dataSource;
	@Autowired
	public void setDataSource(DataSource dataSource) {
	this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	public List<DTOVehiculos> leeVehiculos(){
		String sql = "select * from vehiculos";
		VehiculosMapper mapper = new VehiculosMapper();
		List<DTOVehiculos> vehiculos = this.jdbcTemplate.query(sql,mapper);
		return vehiculos;
	}
	
	
	public void addVehiculo(DTOVehiculos vehiculo) {			
		String sql = "insert into vehiculos(ParkingID,Matricula) values(?,?)";
		Object[ ] parametros = {vehiculo.getParkingId(), vehiculo.getMatricula()}; //Array de objetos
		//Para operaciones INSERT, UPDATE o DELETE se usa el método jdbcTemplate.update
		this.jdbcTemplate.update(sql,parametros);
		}
	
	//Devuelve el vehiculo buscado o null si no existe segun matricula
	public DTOVehiculos buscaMatricula(String matricula){ 
		String sql = "select * from vehiculos where Matricula = ?";
		Object[ ] parametros = {matricula}; //Array de objetos
		VehiculosMapper mapper = new VehiculosMapper();
		List<DTOVehiculos> vehiculos = this.jdbcTemplate.query(sql, parametros, mapper);
		if (vehiculos.isEmpty()) return null;
		else return vehiculos.get(0);
		}
	
	
	public DTOVehiculos buscaRegistroVehiculo(String matricula, int parkingID) {
		String sql = "select Registro from vehiculos where Matricula = ? AND ParkingID = ?";
		Object[] parametros = {matricula, parkingID};
		VehiculosMapper mapper = new VehiculosMapper();
		List<DTOVehiculos> vehiculos = this.jdbcTemplate.query(sql, parametros, mapper);
		if (vehiculos.isEmpty()) return null;
		else return vehiculos.get(0);
	}
	

	public DTOVehiculos buscaParkingIDVehiculo(int id){ 
		String sql = "select * from vehiculos where ParkingID= ?";
		Object[ ] parametros = {id}; //Array de objetos
		VehiculosMapper mapper = new VehiculosMapper();
		List<DTOVehiculos> vehiculos = this.jdbcTemplate.query(sql, parametros, mapper);
		if (vehiculos.isEmpty()) return null;
		else return vehiculos.get(0);
		}
	
	public void updateCoche(DTOVehiculos vehiculo){
		String sql = "update vehiculos SET ParkingID = ?, Matricula = ? ,TimeStamp =? where ParkingID= ?";
		//Obtenemos fecha actual para actualizarla
		Calendar calendar = Calendar.getInstance();
		Timestamp currentTimestamp = new java.sql.Timestamp(calendar.getTime().getTime());
		Object[] parametros = {vehiculo.getParkingId(),vehiculo.getMatricula(),currentTimestamp,vehiculo.getParkingId()}; 
		//Para operaciones INSERT, UPDATE o DELETE se usa el método jdbcTemplate.update
		this.jdbcTemplate.update(sql,parametros);
	}
	
	
	//Obtener tiempo de salida
	public Timestamp tsalida(int registro){
		String sql = "select TimeStamp from vehiculos where Registro= ?";
		Object[] parametros = {registro}; 
		VehiculosMapper mapper = new VehiculosMapper();
		List<DTOVehiculos> vehiculos = this.jdbcTemplate.query(sql, parametros, mapper);
		if (vehiculos.isEmpty()) return null;
		else return vehiculos.get(0).getFechaRegistro();
		}
	//Obtener tiempo de entrada
	public Timestamp tentrada(int registro){
		String sql = "select TimeStamp from vehiculos where Registro= ?";
		Object[] parametros = {registro};
		VehiculosMapper mapper = new VehiculosMapper();
		List <DTOVehiculos> vehiculos = this.jdbcTemplate.query(sql, parametros, mapper);
		if (vehiculos.isEmpty()) return null;
		else return vehiculos.get(0).getFechaRegistro();
		}		

			
}
