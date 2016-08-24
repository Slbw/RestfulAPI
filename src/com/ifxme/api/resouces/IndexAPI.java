package com.ifxme.api.resouces;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by abcca on 2016/8/24 0024.
 */
@Path("/html")
public class IndexAPI {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        return "<html> " + "<title>" + "Hello HTML" + "</title>"
                + "<body><h1>" + "Hello Slbw" + "</body></h1>" + "</html> ";
    }

}
