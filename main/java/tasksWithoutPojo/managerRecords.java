package tasksWithoutPojo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import testrest.Employee;
import testrest.resultset;

@Path("managerrecords2")
public class managerRecords {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{managerName}")
	public JSONArray threejson(@PathParam("managerName") String managerName) {

		String q="select * from employee where employee.\"ReportingTo\"='"+managerName+"';";
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
