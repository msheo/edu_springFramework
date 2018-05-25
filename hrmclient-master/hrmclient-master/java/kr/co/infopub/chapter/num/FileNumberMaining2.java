package kr.co.infopub.chapter.num;
import java.io.File;
public class FileNumberMaining2 {
	public static void main(String[] args) {
		int v=195;
		//String t="";
		String t="/"; 
		String s="s"+v+t;  
		File ff=new File("D:/java200book/workspace/hrmclient/src/main/java/kr/co/infopub/chapter/"+s);
		File[] ffs=ff.listFiles();
		for (File fff: ffs) {
			FileCommentsNumber fc=new FileCommentsNumber(fff.getAbsolutePath());
			fc.fileRWInAnyType();
		}
	}
}
