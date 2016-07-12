import java.io.UnsupportedEncodingException;


public class CharEncode {
	public static void main(String[] args) throws Exception
	{
//		String str="Hello 汉字";
//		printStrHex(str, "UTF-8");
//		printStrHex(str, "UTF-16");
//		printStrHex(str, "UTF-16LE");
//		printStrHex(str, "UTF-16BE");
//		printStrHex(str, "GBK");
//		printStrHex(str, "GB2312");
//		char[] cs = str.toCharArray();
//		System.out.println(cs.length);
		
		
	}
	
	public static byte[] changeCharset(String str, String toCharset) throws UnsupportedEncodingException
	{
		if (str==null) return null;
		byte[] bs = str.getBytes(toCharset);
		return bs;
	}

	public static void printStrHex(String str, String charset) throws UnsupportedEncodingException
	{
		byte[] bs=str.getBytes(charset);
		String res="";
		for (byte b : bs ) {
			String s=Integer.toHexString(b & 0xFF);
			if (s.length()==1) s="0"+s;
			res += s + ' ';
		}
		System.out.printf("%10s: %s\n", charset, res);
	}

}




