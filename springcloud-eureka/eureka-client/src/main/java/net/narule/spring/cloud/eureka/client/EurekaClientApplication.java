package net.narule.spring.cloud.eureka.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}

	@Autowired
	private DiscoveryClient discoveryClient;
	@RequestMapping("/request-eureka-client/{id}")
	public ResponseResult requestEurekaClient(@PathVariable String id) {
		List<ServiceInstance> instances = discoveryClient.getInstances("feign-client");
		ServiceInstance serviceInstance = instances.get(0);
		String host = serviceInstance.getHost();
		String instanceId = serviceInstance.getInstanceId();
		URI uri = serviceInstance.getUri();
		System.out.println("host:" + host);
		System.out.println("instanceId:" + instanceId);
		System.out.println("uri:" + uri);
		return ResponseResult.ok(id + "from-eureka-client");
	}
}
