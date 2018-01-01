package swe645.Survey;

import java.util.HashMap;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("zipcollection")

public class Zipper {
	
private HashMap<String,String> map = new HashMap<String,String>();

public Zipper()
{
	map.put("22030","FairFax VA");
	map.put("22312","Alexandria VA");
	map.put("22301","Tysons-Corner MD");
	map.put("20148","Ashburn VA");
	
}

@GET	
@Path("{zip}")
@Produces("text/plain")
public String zipcollect(@PathParam("zip")String a)
{
	
	if(map.containsKey(a))
	{
   return map.get(a);
	}
	
	return "";
}
	
}	

