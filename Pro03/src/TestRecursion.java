/**
 * 
 * 测试递归
 * @author yudonghai
 *
 */
public class TestRecursion {
	public static void main(String[] args) {
		a();
	}
	static int count=0;
	static void a() {
		System.out.println("a");
		count++;
		if(count<10) {
			a();
		}else{
			return;
		}
	}
	static void b() {
		System.out.println("b");
	}
}
