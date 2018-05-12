package org.ingservicios.practicaREST;

import javax.sql.DataSource;

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

	
	
	public void addVehiculo(DTOVehiculos vehiculo) {			
		String sql = "insert into vehiculos(ParkingID,Matricula) values(?,?)";
		Object[ ] parametros = {vehiculo.getParkingId(), vehiculo.getMatricula()}; //Array de objetos
		//Para operaciones INSERT, UPDATE o DELETE se usa el método jdbcTemplate.update
		this.jdbcTemplate.update(sql,parametros);
		}
	
}
