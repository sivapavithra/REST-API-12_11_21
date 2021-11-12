package tasks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import testrest.SearchClass;
import testrest.Employee;
import testrest.resultset;

@Path("searchrecords")
public class searchRecords {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{name}/{operation}/{data}")
	public ArrayList<Employee> twojson(@PathParam("name") String recordName, @PathParam("operation") String operation, @PathParam("data") String data) {
		SearchClass obj=new SearchClass();
		String q;
		if(recordName.equals("Age")) {
			int i=Integer.parseInt(data); 
			q=obj.search(recordName,i,operation);
		}
		else {

			q=obj.search(recordName,data,operation);
		}
		ResultSet rs=resultset.registerEmployee(q);
		ArrayList<Employee> ar2=new ArrayList<Employee>();

		try {
			while(rs.next()){
				int ID=rs.getInt(1);
				String Name=rs.getString(2);
				int Age=rs.getInt(3);
				String Department=rs.getString(4);
				String Designation=rs.getString(5);
				String ReportingTo=rs.getString(6);


				Employee cd2=new Employee();

				cd2.setID(ID);
				cd2.setName(Name);
				cd2.setAge(Age);
				cd2.setDepartment(Department);
				cd2.setDesignation(Designation);
				cd2.setReportingTo(ReportingTo);

				ar2.add(cd2);
			}

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ar2;
	}
}
