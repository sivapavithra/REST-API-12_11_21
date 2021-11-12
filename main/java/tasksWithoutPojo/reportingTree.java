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

@Path("reportingtree")
public class reportingTree {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{employeeName}")
	public JSONArray threejson(@PathParam("employeeName") String employeeName) {

		String q="SELECT p.\"Name\" FROM employee AS n,employee AS p WHERE n.\"lft\" BETWEEN p.\"lft\" AND p.\"rgt\" AND n.\"Name\" = '"+employeeName+"'"
				+ " ORDER BY p.\"lft\";";
		ResultSet rs=resultset.registerEmployee(q);
		JSONArray employees=new JSONArray();
		try {
			while(rs.next()) {
			JSONObject obj=new JSONObject();
			
			obj.put("Name",rs.getString("Name"));

			employees.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
}
