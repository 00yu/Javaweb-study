
public class TestObject {
	public static void main(String[] args) {
		//Object obj; String
		TestObject to=new TestObject();
		System.out.println(to);//等价于System.out.println(to.toString());
		/*public String toString() {
        	return getClass().getName() + "@" + Integer.toHexString(hashCode());
    	}*/
	}
	public String toString() {
		return "测试Object对象";
	}
}
