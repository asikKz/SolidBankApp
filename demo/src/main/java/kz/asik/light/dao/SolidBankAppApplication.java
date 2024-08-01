package kz.asik.light.dao;
import kz.asik.light.cli.myCli.MyCLI;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SolidBankAppApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("kz.asik.light.config");
		MyCLI myCLI = context.getBean(MyCLI.class);
		myCLI.start();
	}


}
