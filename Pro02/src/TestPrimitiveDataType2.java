import java.math.BigDecimal;

/**
 * 
 * 测试字符型
 * @author yudonghai
 *
 */
public class TestPrimitiveDataType2 {
	public static void main(String[] args) {
		char a='T';
		char b='好';
		char c = '\u0061';//'a'
		System.out.println(c);
		
		//转义字符
		System.out.println('a'+'b');//195 字符间出现加号则字符自动转为unicode
		System.out.println(""+'a'+'b');//ab 前加空字符串变成输出字符
		System.out.println(""+'a'+'\n'+'b');//换行
		System.out.println(""+'a'+'\t'+'b');//tab
		System.out.println(""+'a'+'\''+'b');//a'b
	}
}
