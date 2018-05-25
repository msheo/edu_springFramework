package kr.co.infopub.chapter.num;
import java.io.File;

public class FileNumberMaining {

	
	public static void main(String[] args) {
		for(int i=62; i< 64 ;i++){
			String s="s0"+i;
			File ff=new File("D:/java200book/workspace/java200book/src/kr/co/infopub/chapter/"+s);
			File[] ffs=ff.listFiles();
			for (File fff: ffs) {
				FileCommentsNumber fc=new FileCommentsNumber(fff.getAbsolutePath());
				fc.fileRWInAnyType();//확장자가 있건 없건,  java, txt이라도 된다.
				//System.out.println(fff.getAbsolutePath());
			}
		}
		
	}

}
