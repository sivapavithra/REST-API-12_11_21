package tasks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import testrest.Employee;
import testrest.resultset;

@Path("showallrecords")
public class showAllRecords {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public ArrayList<Employee> onejson() {
		
		String q="select * from employee";
		ResultSet rs=resultset.registerEmployee(q);
		ArrayList<Employee> ar1=new ArrayList<Employee>();
		JSONObject jo1 = null;
		try {
			while(rs.next()){
				int ID=rs.getInt(1);
				String Name=rs.getString(2);
				int Age=rs.getInt(3);
				String Department=rs.getString(4);
				String Designation=rs.getString(5);
				String ReportingTo=rs.getString(6);


				Employee ed1=new Employee();

				ed1.setID(ID);
				ed1.setName(Name);
				ed1.setAge(Age);
				ed1.setDepartment(Department);
				ed1.setDesignation(Designation);
				ed1.setReportingTo(ReportingTo);				
				ar1.add(ed1);
			}
			return ar1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar1;



	}
}
