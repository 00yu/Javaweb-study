
public class TestThis {
	int a,b,c;
	TestThis(int a, int b){
		this.a=a;
		this.b=b;
	}
	TestThis(int a, int b, int c){
		//this.a=a;
		//this.b=b;
		this(a,b);//必须位于第一句
		this.c=c;
	}
}
