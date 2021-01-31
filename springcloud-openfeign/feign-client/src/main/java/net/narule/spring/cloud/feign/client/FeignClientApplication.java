package net.narule.spring.cloud.feign.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@RestController
public class FeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}
	@Autowired
	private FeignInterFace feignInterFace;
	
	@RequestMapping("/request-feign-client")
	public ResponseResult requestFeignClient() {
		String id = String.valueOf(System.currentTimeMillis());
		ResponseResult reuqestEurekaClient = feignInterFace.reuqestEurekaClient(id);
		return ResponseResult.ok(reuqestEurekaClient);
	}
	
	
	@FeignClient("eureka-client")
	interface FeignInterFace {
		
		@RequestMapping(value = "/request-eureka-client/{id}")
		public ResponseResult reuqestEurekaClient(@PathVariable("id") String id);
		
	}

}
