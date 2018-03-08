package poc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
	
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	private SimpMessagingTemplate template;


	@MessageMapping("/send/message")
	public void onReceiveMessage(String message) {
		if(message!=null && message.trim()!="") {
			System.out.println("message="+message);
			this.template.convertAndSend("/chat", simpleDateFormat.format(new Date()) + " " + message);
		}
	}

}
