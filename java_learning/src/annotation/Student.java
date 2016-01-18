package annotation;
@Table("tb_student")
public class Student {
	@Field(columnName="name",type="string",length=20)
	private String name;
	@Field(columnName="age",type="int",length=10)
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
