package javasist;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;

public class JavasisCreateClass {
	public static void main(String[] args) {
		ClassPool cp=ClassPool.getDefault();
		CtClass clazz=cp.makeClass("javasist.Emp");
		
		try {
			CtField field=CtField.make("private int email", clazz);
			clazz.addField(field);
			clazz.writeFile("MyEmp");
		} catch (CannotCompileException | IOException e) {
			e.printStackTrace();
		}
	}
}
