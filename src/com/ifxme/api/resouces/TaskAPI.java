package com.ifxme.api.resouces;

import com.ifxme.api.DBUtils;
import com.ifxme.api.Response;
import com.ifxme.api.model.Task;
import com.ifxme.api.model.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Slbw on 2016/9/18.
 */
@Path("/task")
public class TaskAPI {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
        return "Hello task";
    }


    /**
     * 添加任务
     *
     * @param createrId 创建者id
     * @param taskName  任务名
     * @param taskDesc  任务描述
     * @param beginTime 开始日期
     * @param type      任务类型 0 男方任务  1女方任务
     * @return
     */
    @GET
    @Path("/insert")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertTask(@QueryParam("createrId") int createrId, @QueryParam("taskName") String taskName, @QueryParam("taskDesc") String taskDesc,
                               @QueryParam("beginTime") long beginTime, @QueryParam("type") int type,@QueryParam("taskRemark") String taskRemark, @QueryParam("staffId") int staffId) {

        QueryRunner runner = new QueryRunner();
        String sql = "insert into task(taskName,taskDesc,taskRemark,staffId,beginTime,createrId,type) values(?,?,?,?,?,?,?)";
        Object[] params = {taskName, taskDesc, beginTime, createrId, type};
        try {
            runner.update(DBUtils.getConnection(), sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
            return new Response(0, "插入失败");
        }
        //todo 检测是不是管理员
        return new Response(1, "插入成功");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/list")
    public Response getUserList() {

        QueryRunner runner = new QueryRunner();

        String sql = "select a.id,a.taskName,a.taskDesc,a.taskRemark,a.staffId,b.userName as staffName,a.beginTime,a.createrId,a.type from task a,user b where a.staffId=b.id";
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
