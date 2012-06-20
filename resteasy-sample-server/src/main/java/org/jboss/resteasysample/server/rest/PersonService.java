package org.jboss.resteasysample.server.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasysample.server.domain.Person;



/**
 * @author Matej Lazar
 */
@Stateless
@Path("/persons")
public class PersonService {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Path("all")
    public List<Person> getAll() {
        Query q = em.createNativeQuery("select * from person", Person.class);
        List<Person> result = q.getResultList();
        return result;
    }

    @GET
    @Path("mock-insert")
    public void moskInsert() {
        Person person = new Person();
        person.setName("John");
        person.setSurname("Doe");
        em.persist(person);
    }


}
