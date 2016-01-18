package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
//反射获取类的注解 和 字段的注解. ORM框架就可以这样做，通过反射得到类的表名，类的字段名字，
//然后拼出DDL语句，使用JDBC执行sql ，操作数据库
public class TestAnnotition {
	public static void main(String[] args) {
		try {
			Class<?> clazz=Class.forName("annotation.Student");
		Annotation ans[]=clazz.getAnnotations();
		for(Annotation i:ans)
			System.out.println(i);
			//2
		Table table=(Table) clazz.getAnnotation(Table.class);
		System.out.println(table.value());
		
		
		Field f=clazz.getDeclaredField("name");
		annotation.Field ff= f.getAnnotation(annotation.Field.class);
		System.out.println(ff.columnName()+"-"+ff.length()+"-"+ff.type());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
