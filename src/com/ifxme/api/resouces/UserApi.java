package com.ifxme.api.resouces;

import com.ifxme.api.DBUtils;
import com.ifxme.api.Response;
import com.ifxme.api.model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Slbw on 2016/9/5.
 */
@Path("/user")
public class UserApi {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response getUserList() {

        QueryRunner runner = new QueryRunner();
        ;
        String sql = "select a.id,a.name,a.phone,b.role from user a,role b where b.id=a.roleId ";
        List<User> users = null;
        try {
            users = (List<User>) runner.query(DBUtils.getConnection(), sql, new BeanListHandler(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new Response(1, users);
    }

    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@QueryParam("userId") int userId) {

        QueryRunner runner = new QueryRunner();

        String sql = "select a.id,a.name,a.phone,b.role from user a,role b where b.id=a.roleId and a.id=?";
        User user = null;
        try {
            user = runner.query(DBUtils.getConnection(), sql, new BeanHandler<User>(User.class), userId);
        } catch (SQLException e) {
            e.printStackTrace();
            return new Response(0, "查询用户失败");
        }
        if (user == null) {
            return new Response(0, "没有查询到用户信息");
        }
        return new Response(1, user);
    }

    /**
     * 添加用户
     * @param userId 管理员的id
     * @return
     */
    @GET
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertUser(@QueryParam("userId") int userId) {

        //检测是不是管理员
        return new Response(1, null);
    }

    @Path("/delete")
    public void deleteUser(@QueryParam("userId") int userId)
    {

    }


    @GET
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response doLogin(@QueryParam("phone") String phone, @QueryParam("password") String password) {
        QueryRunner runner = new QueryRunner();
        String sql = "select a.id,a.name,a.phone,b.role from user a,role b where b.id=a.roleId and (a.phone=? and a.password=?)";
        User user = null;
        try {
            user = runner.query(DBUtils.getConnection(), sql, new BeanHandler<User>(User.class), phone, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return new Response(0, "查询用户失败");
        }
        if (user == null) {
            return new Response(0, "登录失败");
        }
        return new Response(1, user);
    }


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


}
