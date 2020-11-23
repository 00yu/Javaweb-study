/**
 * 
 * 测试继承
 * 
 * */
public class TestExtends {
	public static void main(String[] args) {
		Stu stu=new Stu("tom",185,"science");
		stu.study();
		stu.rest();
		System.out.println(stu instanceof Stu);
		System.out.println(stu instanceof Person);
		System.out.println(stu instanceof Object);
		System.out.println(new Person() instanceof Stu);
	}
}
class Person {
    String name;
    int height;
    public void rest(){
        System.out.println("休息一会！");
    }  
}
class Stu extends Person {
    String major; //专业
    public void study(){
        System.out.println("在尚学堂，学习Java");
    }  
    public Stu(String name,int height,String major) {
        //天然拥有父类的属性
        this.name = name;
        this.height = height;
        this.major = major;
    }
    public Stu() {}
}