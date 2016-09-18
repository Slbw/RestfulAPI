package com.ifxme.api.resouces;

import com.ifxme.api.DBUtils;
import com.ifxme.api.Response;
import com.ifxme.api.model.Task;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Slbw on 2016/9/18.
 */
@Path("/flow")
public class FlowAPI {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
        return "Hello flow";
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response getUserList() {

        QueryRunner runner = new QueryRunner();

        String sql = "select a.taskName,a.taskDesc a.type a.createrId,b.userName as createrName from task a,user b,flow c where task a.createId=b.id order by a.beginTime desc";
        List<Task> tasks = null;
        try {
            tasks = (List<Task>) runner.query(DBUtils.getConnection(), sql, new BeanListHandler(Task.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return new Response(0, "获取失败");
        }
        return new Response(1, tasks);
    }


}
