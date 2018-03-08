package poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import poc.controller.WebSocketController;

@SpringBootApplication
public class App {
	
	public static void main(String[]args) {
		
		ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);
		WebSocketController bean = applicationContext.getBean(WebSocketController.class);
		
		while(true) {
			bean.onReceiveMessage("Send Message from back");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
