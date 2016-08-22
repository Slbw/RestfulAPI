package com.ifxme.api;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by abcca on 2016/8/22 0022.
 */
public class RestApplication extends ResourceConfig{

    public RestApplication() {

        //服务类所在的包路径
        packages("com.ifxme.api.resouces");
        //注册JSON转换器
        register(JacksonJsonProvider.class);

    }

}
