package com.iflytek.IFly12.config;


import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Component
@EnableSwagger2
@Configuration
public class SwaggerPrintConfig implements ApplicationListener<WebServerInitializedEvent> {
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        //获取IP
        String hostAddress = "127.0.0.1";
        //获取端口号
        int port = event.getWebServer().getPort();
        //获取应用名
        String applicationName = event.getApplicationContext().getApplicationName();
        //swagger3和swagger2的地址不一样
        System.out.println("\n项目启动启动成功！接口文档地址: \n"+"    http://"+hostAddress+":"+event.getWebServer().getPort()+applicationName+"/swagger-ui/index.html");
    }
}