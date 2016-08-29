package com.ifxme.api.resouces;

import com.ifxme.api.DBUtils;
import com.ifxme.api.Response;
import com.ifxme.api.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

/**
 * Created by Slbw on 2016/8/22.
 */
@Path("/user")
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


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{id}/info")
    public String deleteContact(@PathParam("id") String id) {
        return "info," + id;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response testParam(@QueryParam("userId") int userId) {
//        User user=new User();
//        user.setId(userId);
//        user.setName("小明");
//        user.setAge(23);

        QueryRunner runner = new QueryRunner();
        ;
        String sql = "select id,username,age from user where id=?";
        User user = null;
        try {
            user = runner.query(DBUtils.getConnection(), sql, new BeanHandler<User>(User.class), userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Response(1, user);
    }
}
