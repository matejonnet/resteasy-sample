package org.jboss.resteasysample.server.rest;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.jboss.resteasysample.server.domain.Message;



/**
 * @author Matej Lazar
 */
@Stateless
@Path("/message")
public class MessageService {

    @PersistenceContext
    private EntityManager em;

    @GET
    @Path("/")
    public List<Message> getAll() {
        Query q = em.createNativeQuery("select * from message", Message.class);
        List<Message> result = q.getResultList();
        return result;
    }

    @GET
    @Path("/gt/{id}")
    public List<Message> getFromId(@PathParam("id") String id) {
        Query q = em.createNativeQuery("select * from message where id > :id", Message.class);
        q.setParameter("id", id);
        List<Message> result = q.getResultList();
        return result;
    }



    @GET
    @Path("mock-insert")
    public void moskInsert() {
        Message message = new Message();
        message.setTitle("Title" + System.currentTimeMillis());
        message.setBody("The quick brown fox jumps over the lazy dog.");
        em.persist(message);
    }


}
