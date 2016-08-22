package com.ifxme.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Slbw on 2016/8/22.
 */
@Path("/hello")
public class Hello {
    // This method is called if TEXT_PLAIN is request
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
        return "Hello Jersey";
    }
    // This method is called if XML is request
    @GET
    @Produces(MediaType.TEXT_XML)
    public String sayXMLHello() {
        return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
    }
    // This method is called if HTML is request
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        return "<html> " + "<title>" + "Hello Jersey" + "</title>"
                + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
    }

    // This method is called if HTML is request
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayJsonHello() {
        return "{\"code\":0,\"data\":{\"country\":\"\\u4e2d\\u56fd\",\"country_id\":\"CN\",\"area\":\"\\u534e\\u4e1c\",\"area_id\":\"300000\",\"region\":\"\\u6c5f\\u82cf\\u7701\",\"region_id\":\"320000\",\"city\":\"\\u5357\\u4eac\\u5e02\",\"city_id\":\"320100\",\"county\":\"\",\"county_id\":\"-1\",\"isp\":\"\\u7535\\u4fe1\",\"isp_id\":\"100017\",\"ip\":\"114.221.128.140\"}}";
    }
}
