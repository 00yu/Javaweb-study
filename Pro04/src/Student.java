
public class Student {
	// 属性（成员变量）
	int id;
	String sname;
	int age;
	
	Computer comp;//表示每人有台电脑

	// 方法
	void study() {
		System.out.println("我正在学习！"+"使用电脑："+comp.brand);
	}

	// 构造方法，无参的构造方法可以由系统自动创建，方法名需要与类名一致
	Student() {
	}

	// 程序执行的入口
	public static void main(String[] args) {
		Student stu = new Student();// 通过构造方法创建一个对象
		stu.id=1001;
		stu.sname="Tom";
		stu.age=18;
		Computer c1=new Computer();
		c1.brand="联想";
		stu.comp=c1;
		stu.study();
	}
}

class Computer{
	String brand;
	
}