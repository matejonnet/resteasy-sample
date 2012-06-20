package org.jboss.resteasysample.server.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * @author Matej Lazar
 */
@Path("/serverInfo")
public class ServerInfo {

    @GET
    @Path("/timeStamp")
    //@Produces({"application/json"})
    public long getTimeStamp() {
        return System.currentTimeMillis();
    }

}
