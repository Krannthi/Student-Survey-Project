package swe645.Survey;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.UserTransaction;


public class StudentService {

	@PersistenceUnit 
	EntityManagerFactory emf;
	
	@Resource
	UserTransaction ut;
	
public void Storedata(Student temp)throws ClassNotFoundException, SQLException, IOException  
{
	emf = Persistence.createEntityManagerFactory("Hibernate1");
	EntityManager em = emf.createEntityManager();
	
	try {
	  em.getTransaction().begin();
	  em.persist(temp);
	  em.getTransaction().commit();
	} catch (Exception e) {
		 em.getTransaction().rollback();
		e.printStackTrace();	
	  
	}
	finally
	{
		em.close();
		emf.close();
	}	
	
} 
	


public List<Student> Retrievedata()

{
	
emf = Persistence.createEntityManagerFactory("Hibernate1");
EntityManager em = emf.createEntityManager();
ArrayList<Student> arr;

Query q = em.createQuery("Select x from Student x");

arr = (ArrayList<Student>)q.getResultList();

em.close();
emf.close();

return arr;

}


public List<Student> Searchdata(Student temp) throws ClassNotFoundException, SQLException, IOException

{
	
emf = Persistence.createEntityManagerFactory("Hibernate1");
EntityManager em = emf.createEntityManager();

ArrayList<Student> search;

Query q = em.createQuery("from Student s where s.firstname = :firstname or s.lastname  = :lastname  or s.city = :city or s.state = :state");
q.setParameter("firstname", temp.getfirstname());
q.setParameter("lastname", temp.getlastname());
q.setParameter("city", temp.getcity());
q.setParameter("state", temp.getstate());

search = (ArrayList<Student>) q.getResultList();

em.close();
emf.close();

return search;

}


public void deleterow(Student s)
{
	
	emf = Persistence.createEntityManagerFactory("Hibernate1");
	EntityManager em = emf.createEntityManager();
	  
		try {
			    em.getTransaction().begin();
			    Student temp = em.find(Student.class,s.getid());
				em.remove(temp);
			   em.getTransaction().commit();	
			} catch (Exception ex) {
				 em.getTransaction().rollback();
				 ex.printStackTrace();	
			  
			}
		finally{
			
			em.close();
			emf.close();
		}
	
}


public WinningResult getMeanSD(String[] numbers)
{

Double mean=0.0;
Double sd=0.0;

for(String t : numbers)
{
mean += Double.valueOf(t);
}

mean = mean/numbers.length;

for(String t : numbers)
{
	sd += ((Double.valueOf(t) - mean) * (Double.valueOf(t) - mean)) ;
	
}

sd = sd/numbers.length;

sd = Math.sqrt(sd);

WinningResult wr = new WinningResult();	

wr.setmean(mean);

wr.setstandarddeviation(sd);
	
return wr;

}

}
