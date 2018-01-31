package aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerController {
	@Before("within(controller..*)")
	public void loggerController() {
		System.out.println("AOP注入");
	}
}
