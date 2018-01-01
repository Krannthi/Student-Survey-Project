package swe645.Survey;






import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;




@ManagedBean(name="surveyBean")
@RequestScoped


public class SurveyBean {

private String firstname;

private String lastname;

private String street;

private String city;

private String state;

private Date start_date;

private String zip;

private String telephone;

private String email;

private String interest;

private String[] mostliked;

private String likelihood;

private String raffle;

private String comments;

private Date dateofsurvey;

private WinningResult winningresult;

private StudentService s;

private List<Student> studentinfo;

private static final String SelectionString = "VeryLikely,Unlikely,Likely"; // More in real code
private static final String[] SelectionArray = SelectionString.split(",");

private HashMap<String,String> map = new HashMap<String,String>();


public SurveyBean()
{

	
	map.put("22030","FairFax VA");
	map.put("22312","Alexandria VA");
	map.put("22301","Tysons Corner MD");
	map.put("20148","Ashburn VA");
		
}

public void setfirstname(String a)
{
	
this.firstname = a.trim();

}

public void setlastname(String a)
{
	
this.lastname = a.trim();

}

public void setstreet(String a)
{
	
	this.street = a;

}

public void setcity(String a)
{
	
	this.city = a.trim();

}

public void setstate(String a)
{
	
	this.state = a.trim();

}

public void setzip(String a)
{
	this.zip = a;

	Client client = Client.create();

	WebResource webResource = client
	   .resource("http://ec2-34-198-131-81.compute-1.amazonaws.com/SWE-645_Assignment3/access-city-state/zipcollection/"+a.toString());

	ClientResponse response = webResource.accept("text/plain")
               .get(ClientResponse.class);
	
	String output = response.getEntity(String.class);
	
    if(!output.isEmpty())
    {
    
    	String[] fields = output.split(" ");
    	this.city = fields[0];
    	this.state = fields[1];
    		
    }
	
}

public void settelephone(String a)
{
	
	this.telephone = a;

}

public void setemail(String a)
{
	
	this.email = a;

}

public void setinterest(String a)
{
	//if(a == null)
	//interest = "";
	
	//else
	this.interest = a;

}

public void setmostliked(String[] a)
{
	//if(a == null)
	//mostliked[0] = "";
	
	//else
	this.mostliked = a;
}

public void setlikelihood(String a)

{

	this.likelihood = a;

}

public void setraffle(String a)
{

	this.raffle = a;

}

public void setcomments(String a)
{
	//if(a==null)
	//comments="";
	
	//else
	this.comments = a;

}

public void setdateofsurvey(Date a)
{

	this.dateofsurvey = a;
}

public void setstart_date(Date a)
{

	this.start_date = a;
}

public String getfirstname()
{
	
	return firstname;

}

public String getlastname()
{
	
	return lastname;

}

public String getstreet()
{
	
	return street;

}

public String getcity()
{
	
	return city;

}

public String getstate()
{
	
	return state;

}

public String getzip()
{
	
	return zip;

}

public String gettelephone()
{
	
	return telephone;

}

public String getemail()
{
	
	return email;

}

public String getinterest()
{
	
	return interest;

}

public String[] getmostliked()
{
	
	return mostliked;

}

public String getmostlikedinstring()
{
	
if(mostliked.equals(""))
return "";

else
{
StringBuffer k = new StringBuffer();

for(String i : mostliked)
k.append(i+" ");

return k.toString();	
	
}

}

public String getlikelihood()
{
	
	return likelihood;

}

public String visitorinfo()
{
	
	return "ListSurvey";

}

public String getraffle()
{
	
	return raffle;

}

public String getcomments()
{
	
	return comments;

}

public Date getdateofsurvey()
{
	return dateofsurvey;
}

public Date getstart_date()
{
	
	return start_date;
}

public List<String> selections(String a)
{
	List<String> b = new ArrayList<String>();
	
	for(String i:SelectionArray)
	{	
		
		if(i.startsWith(a.toUpperCase()))
			b.add(i);
		
	}	
		
		
	return b;
}


public List<Student> getstudentinfo()
{
	try {
	s = new StudentService();

	studentinfo = s.Retrievedata();
	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}

	return studentinfo;

}

public WinningResult getwinningResult()
{
	
	return winningresult;

}

public String reset()
{
	 firstname=null;
	 lastname=null;
	 street=null;
	 city=null;
	 state=null;
	 zip=null;
	 telephone=null;
	 email=null;
	 interest=null;
	 mostliked=null;
	 likelihood=null;
	 raffle=null;
	 comments=null;
	 dateofsurvey=null;
	 winningresult = null;
	 s=null;
	 studentinfo = null;
	 start_date = null;
	 return "index";
	
}

public String resetsearch()
{
	 firstname=null;
	 lastname=null;
	 city=null;
	 state=null;
	 return "Search";
	
}





public String search(){

List<Student> search_records;

Student st = new Student();

st.setfirstname(firstname.toString());
st.setlastname(lastname.toString());
st.setcity(city.toString());
st.setstate(state.toString());

try
{
StudentService s = new StudentService();
search_records = s.Searchdata(st);
FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("search",search_records);
}

catch(Exception e)
{
	e.printStackTrace();
}
		
return "ListSearch";
}


public String deleteAction(Student s)
{

StudentService ss = new StudentService();
List<Student> arr = (ArrayList<Student>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("search");
List<Student> fin = new ArrayList<Student>();

for(Student k: arr)
{
	
if(k.getid() != s.getid())
fin.add(k);

}

FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("search",fin);	

ss.deleterow(s);

return "ListSearch";	

}



public String Actionmethod() throws ClassNotFoundException, SQLException, IOException
{
	if(start_date==null || start_date.equals(dateofsurvey) || start_date.after(dateofsurvey))
	{	
	Student temp = new Student();
	winningresult = new WinningResult();
	StudentService s = new StudentService();
	temp.setfirstname(firstname.toString());
	temp.setlastname(lastname.toString());
	temp.setcity(city.toString());
	temp.setstate(state.toString());
	temp.setzip(zip.toString());
	temp.setstreet(street.toString());
	temp.settelephone(telephone.toString());
	temp.setemail(email.toString());
	temp.setraffle(raffle.toString());
	temp.setcomments(comments.toString());
	temp.setdateofsurvey(dateofsurvey.toString());
	temp.setstart_date(start_date.toString());
	temp.setinterest(interest.toString());
	temp.setmostliked(getmostlikedinstring());
	temp.setlikelihood(likelihood.toString());
    s.Storedata(temp);

if(raffle.isEmpty())
{
   winningresult.setmean(0.0);
   winningresult.setstandarddeviation(0.0);
   return "SimpleAcknowledgement";
	
}

else
	
{

winningresult = s.getMeanSD(raffle.split(","));
if(winningresult.getmean() > 90.0)
return "WinnerAcknowledgement";
else
return "SimpleAcknowledgement";	

}
	}
	
else
{
		
	FacesContext context = FacesContext.getCurrentInstance();
	FacesMessage errorMessage = new FacesMessage("Semester-start-date must be on or after start date");
	errorMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
	context.addMessage("start-date", errorMessage);
	return(null);			

}
}
}

	