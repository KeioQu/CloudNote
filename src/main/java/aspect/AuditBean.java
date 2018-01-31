package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuditBean {
	//service包下所有方法性能审计
	@Around("within(service..*)")
	public Object audit(ProceedingJoinPoint point) {
		Object object = null;
		try {
			long timeStart = System.currentTimeMillis();
			object = point.proceed();
			long timeEnd = System.currentTimeMillis();
			String str = point.getSignature().toShortString();
			System.out.println(str + "耗时：" + (timeEnd - timeStart));
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return object;
		
	}
}
