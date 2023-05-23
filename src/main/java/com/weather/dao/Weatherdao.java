package com.weather.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;
import com.weather.models.Report;

@Component
public class Weatherdao {

	@Autowired
	JdbcTemplate template;
	
		public List<Report> getdetailsfromdb() {
			List<Report> li=new ArrayList<>();
			
			return template.query("SELECT * FROM weather.report", new ResultSetExtractor<List<Report>>() {

				@Override
				public List<Report> extractData(ResultSet rs) throws SQLException, DataAccessException {
					while(rs.next()) {
						Report re=new Report();
						re.setPincode(rs.getInt("pincode"));
						re.setDate(rs.getString("date"));
						re.setTemperature(rs.getString("temperature"));
						li.add(re);
					}
					return li;
				}

			});
		}
	}

