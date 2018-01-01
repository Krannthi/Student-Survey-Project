package swe645.Survey;


import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@ManagedBean
@Entity
@Table

public class Student {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String firstname;

		private String lastname;

		private String street;

		private String city;

		private String state;

		private String zip;

		private String telephone;
		
        private String email;

        private String start_date; 
        
        private String interest;

		private String mostliked;

		private String likelihood;

		private String raffle;

		private String comments;

		private String dateofsurvey;
		
		
		public long getid()
		{
			return id;
		}
		
		@Column(name="firstname", nullable=false)
		public String getfirstname()
		{
			
			return firstname;

		}
		public void setfirstname(String a)
		{
			
		this.firstname = a;

		}

		
		
		@Column(name="lastname", nullable=false)
		public String getlastname()
		{
			
			return lastname;

		}
		public void setlastname(String a)
		{
			
		this.lastname = a;

		}
		

		@Column(name="street", nullable=false)
		public String getstreet()
		{
			
			return street;

		}
		public void setstreet(String a)
		{
			
			this.street = a;

		}

		
		
		@Column(name="city", nullable=false)
		public String getcity()
		{
			
			return city;

		}
		public void setcity(String a)
		{
			
			this.city = a;

		}

		

		@Column(name="state", nullable=false)
		public String getstate()
		{
			
			return state;

		}

		public void setstate(String a)
		{
			
			this.state = a;

		}

		
		@Column(name="zip", nullable=false)
		public String getzip()
		{
			
			return zip;

		}
		public void setzip(String a)
		{
			
			this.zip = a;

		}

		

		@Column(name="telephone", nullable=false)
		public String gettelephone()
		{
			
			return telephone;

		}
		public void settelephone(String a)
		{
			
			this.telephone = a;

		}

		
		
		@Column(name="email", nullable=false)
		public String getemail()
		{
			
			return email;

		}
		public void setemail(String a)
		{
			
			this.email = a;

		}

	
		
		
		@Column(name="dateofsurvey", nullable=false)
		public String getdateofsurvey()
		{
			
			return dateofsurvey;

		}
		public void setdateofsurvey(String a)
		{
			
			this.dateofsurvey = a;

		}
		
		
		@Column(name="start_date", nullable=false)
		public String getstart_date()
		{
			
			return start_date;

		}
		public void setstart_date(String a)
		{
			
			this.start_date = a;

		}

		
		
		@Column(name="interest", nullable=true)
		public String getinterest()
		{
			
			return interest;

		}

		public void setinterest(String a)
		{
			
			this.interest = a;

		}

		
		
		@Column(name="mostliked", nullable=true)
		public String getmostliked()
		{
			
			return mostliked;

		}
		public void setmostliked(String a)
		{
			
			this.mostliked = a;

		}

		
		
		@Column(name="likelihood", nullable=true)
		public String getlikelihood()
		{
			
			return likelihood;

		}
		public void setlikelihood(String a)
		{
			
			this.likelihood = a;

		}

		
		
		
		@Column(name="raffle", nullable=true)
		public String getraffle()
		{
			
			return raffle;

		}
		public void setraffle(String a)
		{
			
			this.raffle = a;

		}

		
		
		@Column(name="comments", nullable=true)
		public String getcomments()
		{
			
			return comments;

		}
		public void setcomments(String a)
		{
			
			this.comments = a;

		}


/*
		public String toString()
		{
		
			String t = firstname+lastname+street+city+state+zip+telephone+email+start_date+interest+mostliked+likelihood+raffle+comments+dateofsurvey;
			
			return t;

		}
*/
}
