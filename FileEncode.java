import java.io.*;
 
// File Encode Transform
public class FileEncode {
	private String srcDir;
	private String desDir;
	
	public static void main(String[] args) throws Exception
	{
		
		String srcdir="C:/pds/wid/wid-source/java";	
		
		FileEncode fileEncode = new FileEncode(srcdir);
		fileEncode.dirProcess(srcdir);
		System.out.println("File Encode Change OK.");

		
	}
	
	FileEncode(String srcdir) {
		srcDir = srcdir; 
		desDir = srcdir + "-2";
	}
	
	public void dirProcess(String dirname) throws Exception {
		File dir = new File(dirname);
		File[] files = dir.listFiles();
		String desdir = desDir + dirname.substring(srcDir.length());
		File mkDir = new File(desdir);
		mkDir.mkdir();
		for (File f : files) {
			//System.out.println( f.getName() );
			if (f.isDirectory()) {
				String subdir = dirname + '/' + f.getName();
				dirProcess(subdir);
			} else {
				String fname=dirname+'/'+f.getName();
				String oname=desdir + '/' + f.getName();
				fileEncodeChange(fname, oname, "UTF-8", "GB2312");
				
			}
		}
		
		
	}
	
	public void fileEncodeChange(String filename, String outname, String oldCharset, String toCharset) throws Exception
	{

		BufferedReader fin = new BufferedReader( new InputStreamReader(new FileInputStream(new File(filename)),"UTF-8") );
		String line,text="";
		while ((line=fin.readLine())!=null) text += line + '\n';

		BufferedOutputStream fout=new BufferedOutputStream(new FileOutputStream(outname));
		fout.write( text.getBytes("GB2312"));
		fout.flush();
		fout.close();
		fin.close();
		System.out.println(filename + " to " + toCharset + " OK");
		
	}
	
	public byte[] changeCharset(String str, String toCharset) throws UnsupportedEncodingException
	{
		if (str==null) return null;
		byte[] bs = str.getBytes(toCharset);
		return bs;
	}

}
