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

@Path("summaryofrecords")
public class summaryOfRecords {
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("{summaryName}")
	public JSONArray threejson(@PathParam("summaryName") String summaryName) {

		String q="SELECT \""+summaryName+"\",count(\""+summaryName+"\") as ct FROM employee group by \""+summaryName+"\";";
		ResultSet rs=resultset.registerEmployee(q);
		JSONArray employees=new JSONArray();
		try {
			while(rs.next()) {
			JSONObject obj=new JSONObject();
			obj.put(summaryName,rs.getString(summaryName));
			obj.put("Count",rs.getInt("ct"));
			
			employees.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
}
