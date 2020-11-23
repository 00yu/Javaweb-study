/**
 * 
 * 测试算术运算符
 * @author yudonghai
 *
 */
public class TestOperator {
	public static void main(String[] args) {
		byte a=1;
		int b=2;
		long b2=3;
		//byte c=a+b;	不能将byte转为int
		//int c2=b2+b;	不能将int转为long
		float f1=3.14f;
		float d=b+b2;
		//float d2=f1+6.2; 不能将double转为float
		//取余余数符号和左边操作数相同
		System.out.println(9%5);//4
		System.out.println(-9%5);//-4
		
		int a1 = 3;
		int b1 = a1++;   //执行完后,b=3。先给b赋值，再自增。
		System.out.println("a1="+a1+"\nb1="+b1);
		a1 = 3;
		b1 = ++a1;   //执行完后,b=4。a先自增，再给b赋值
		System.out.println("a1="+a1+"\nb1="+b1);
		
		a=3;
		b=4;
		a+=b;//相当于a=a+b;
		System.out.println("a="+a+"\nb="+b);
		a=3;
		a*=b+3;//相当于a=a*(b+3)
		System.out.println("a="+a+"\nb="+b);
		
		//1>2的结果为false，那么整个表达式的结果即为false，将不再计算2>(3/0)
		boolean c = 1>2 && 2>(3/0);
		System.out.println(c);
		//1>2的结果为false，那么整个表达式的结果即为false，还要计算2>(3/0)，0不能做除数，//会输出异常信息
		boolean e = 1>2 & 2>(3/0);
		System.out.println(e);

	}
}
