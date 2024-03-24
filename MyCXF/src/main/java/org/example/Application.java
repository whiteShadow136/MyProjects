package org.example;

/**
 * @Description:org.example
 * @Date:2024/3/23
 * @Author:谢锦创
 */
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServiceImpl;
import org.apache.cxf.jaxrs.model.ClassResourceInfo;
import org.apache.cxf.jaxrs.model.OperationResourceInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.transport.Destination;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:applicationContext.xml"})
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        System.out.println(11111);


        Bus bus = (Bus) context.getBean(Bus.DEFAULT_BUS_ID);

// 遍历所有服务
        for (Server server : bus.getExtension(org.apache.cxf.endpoint.ServerRegistry.class).getServers()) {
            Destination destination = server.getDestination();
            EndpointInfo endpointInfo = server.getEndpoint().getEndpointInfo();

            // 获取基础地址
            String address = endpointInfo.getAddress();

            if (server.getEndpoint().getService() instanceof JAXRSServiceImpl) {
                JAXRSServiceImpl service = (JAXRSServiceImpl) server.getEndpoint().getService();

                for (ClassResourceInfo cri : service.getClassResourceInfos()) {
                    // 获取资源类路径
                    String resourcePath = cri.getURITemplate().getValue();

                    for (OperationResourceInfo ori : cri.getMethodDispatcher().getOperationResourceInfos()) {
                        // 获取具体方法的HTTP方法和路径
                        String httpMethod = ori.getHttpMethod();
                        String operationPath = ori.getURITemplate().getValue();

                        // 构建并打印完整路径
                        System.out.println("HTTP Method: " + httpMethod + " | Full Path: " + address + resourcePath + operationPath);
                    }
                }
            }
        }


    }
}
