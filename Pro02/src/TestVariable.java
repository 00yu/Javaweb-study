/**
 * 
 * 测试变量
 * @author yudonghai
 *
 */
public class TestVariable {
	int a;//成员变量,声明位置：类内部方法外部,会自动被初始化,跟随对象创建--从属于对象
	static int size;//静态变量--从属于类
	public static void main(String[] args) {
		{
			int i;
			//System.out.println(i); 局部变量，需要初始化才能使用上--从属于方法/语句块
		}
		//i=3; 局部变量i在方法块中声明，无法赋值
		TestVariable test=new TestVariable();
		System.out.println(test.a);
	}
}
