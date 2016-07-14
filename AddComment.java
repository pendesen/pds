

import java.io.*;

// hello git
// Change Java Spring Code: @Controller --> //@Controller
// Easy for source insight to parse

public class AddComment {
	private String srcDir;
	private String desDir;
	
	public static void main(String[] args) throws Exception
	{
		
		String srcdir="C:/pds/wid/wid-source/java";	
		
		AddComment add = new AddComment(srcdir);
		add.dirProcess(srcdir);
		System.out.println("Process OK.");

		
	}
	
	AddComment(String srcdir) {
		srcDir = srcdir; 
		desDir = srcdir + "-2";
	}
	
	public void addComment(String fname, String oname) throws Exception {
		BufferedReader fin = new BufferedReader( new InputStreamReader(new FileInputStream(new File(fname)),"UTF-8") );
		PrintWriter fout=new PrintWriter(oname);
		String line;
		while ((line=fin.readLine())!=null) {
			if ( line.trim().startsWith("@")) {
				int i= line.indexOf('@');
				line = line.substring(0, i) + "// " + line.substring(i);
			}
			line += '\n';
			fout.write(line);
		}
		fin.close();
		fout.flush();
		fout.close();

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
				addComment(fname, oname);
				
			}
		}
		
		
	} 

}
