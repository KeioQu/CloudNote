package aspect;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 当系统发生service异常时，将异常信息写入到日志文件
 * @author xiangnan.qu
 *
 */
@Component //扫描到spring容器
@Aspect //将该类作为切面组件
public class ExceptionBean {
	//e是目标组件抛出的异常对象
	@AfterThrowing(
			throwing="e",
			pointcut="within(service..*)")
	public void execute(Exception e) {
		FileWriter fw;
		try {
			fw = new FileWriter("D:/log.txt");
			PrintWriter pw = new PrintWriter(fw);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String timeStr = sdf.format(date);
			pw.println(e);
			pw.println(timeStr);
			e.printStackTrace(pw);
			pw.close();
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
