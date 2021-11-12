package tasks;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public ArrayList<Employee> threejson(@PathParam("summaryName") String summaryName) {

		String q="SELECT \""+summaryName+"\",count(\""+summaryName+"\") as ct FROM employee group by \""+summaryName+"\";";
		ResultSet rs=resultset.registerEmployee(q);
		ArrayList<Employee> ar1=new ArrayList<Employee>();

		try {
			while(rs.next()){
				Employee ed1=new Employee();
				String sname=rs.getString(summaryName);
				int Count=rs.getInt("ct");
				if(summaryName.equals("Department")) {
					ed1.setDepartment(sname);
				}
				else if(summaryName.equals("Designation")) {
					ed1.setDesignation(sname);
				}
				else if(summaryName.equals("ReportingTo")) {
					ed1.setReportingTo(sname);
				}
				ed1.setCount(Count);

				ar1.add(ed1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar1;


	}
}
