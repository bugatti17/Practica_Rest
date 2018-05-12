package org.ingservicios.practicaREST;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VehiculosMapper implements RowMapper <DTOVehiculos>{
	public DTOVehiculos mapRow(ResultSet rs, int rowNum) throws SQLException{
		DTOVehiculos vehiculos = new DTOVehiculos();
		vehiculos.setParkingId(rs.getInt("ParkingID"));
		vehiculos.setMatricula(rs.getString("Matricula"));
		vehiculos.setFechaRegistro(rs.getTimestamp("TimeStamp"));
		
		
		return vehiculos;
	}
}
