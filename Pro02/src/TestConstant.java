/**
 * 
 * 测试常量
 * @author yudonghai
 *变量和常量命名规范（规范是程序员的基本准则，不规范会直接损害你的个人形象）：

所有变量、方法、类名：见名知意

类成员变量：首字母小写和驼峰原则:  monthSalary

局部变量：首字母小写和驼峰原则

常量：大写字母和下划线：MAX_VALUE

类名：首字母大写和驼峰原则:  Man, GoodMan

方法名：首字母小写和驼峰原则: run(), runRun()
 */
public class TestConstant {
	public static void main(String[] args) {
		final double PI = 3.14;
        // PI = 3.15; //编译错误，不能再被赋值！ 
        double r = 4;
        double area = PI * r * r;
        double circle = 2 * PI * r;
        System.out.println("area = " + area);
        System.out.println("circle = " + circle);
	}
}
