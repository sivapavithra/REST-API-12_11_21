package tasksWithoutPojo;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import testrest.resultset;

@Path("showallrecords")
public class showAllRecords {
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public JSONArray onejson() {
		
		String q="select * from employee";
		ResultSet rs=resultset.registerEmployee(q);
		JSONArray employees=new JSONArray();
		try {
			while(rs.next()) {
			JSONObject obj=new JSONObject();
			obj.put("ID", rs.getInt("ID"));
			obj.put("Name",rs.getString("Name"));
			obj.put("Age", rs.getInt("Age"));
			obj.put("Department",rs.getString("Department"));
			obj.put("Designation",rs.getString("Designation"));
			obj.put("ReportingTo",rs.getString("ReportingTo"));
			employees.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
		
}
}
