package kr.co.infopub.chapter.num;
import java.io.File;
public class FileNumberMaining2 {
	public static void main(String[] args) {
		int v=191;
		//String t="";
		//String t="/model"; 
		//String s="s"+v+t;  
		String s="";
		//File ff=new File("D:/java200book/workspace/hrms192server/src/main/java/kr/co/infopub/hrm/"+s);
		File ff=new File("D:/java200book/workspace/hrms192server/src/test/java/kr/co/infopub/hrm/"+s);
		File[] ffs=ff.listFiles();
		for (File fff: ffs) {
			FileCommentsNumber fc=new FileCommentsNumber(fff.getAbsolutePath());
			fc.fileRWInAnyType();
			//System.out.println(fff.getAbsolutePath());
		}
	}
}
