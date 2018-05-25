package kr.co.infopub.chapter.num;


import java.io.*;
/**
 * @author hyonny
 * 교재를 만들때 자동 번호를 붙이려고 한다. </br>
 * 읽을 파일명을 생성자에 입력을 하면 </br>
 * 확장자가 없거나 .java라면 파일명.txt로 저장</br>
 * 확장자가 .txt라면 파일명+500내의 임의수.txt로 저장</br>
 */
public class FileCommentsNumber {
	private String fileNameInRead;
	private String fileNameInWrite;
	
	public FileCommentsNumber(String filename){
		this.fileNameInRead=attachJavaName(filename);
		this.fileNameInWrite=attachTxtName(filename);
	}
	public String makeFName(String filename){//확장자
		String str=
		   filename.substring(filename.lastIndexOf(".")+1);
		return str;
	}
	public String makeFirstName(String filename){
		String str=
		   filename.substring(0,filename.lastIndexOf("."));
		return str;
	}
	private String attachJavaName(String filename){
		String str="";
		if(makeFName(filename).equals(filename)){
			str=filename+".java";
		}else{
			str=filename;
		}
		return str;
	}
	public void fileRWInAnyType(){
		if(makeFName(fileNameInRead).equals("java")){//확장자가 java
			fileReadAndWrite();
		}else if(makeFName(fileNameInRead).equals("txt")){
			txtReadAndWrite();
		}else{
			fileReadAndWrite();
		}
	}
	private String attachTxtName(String filename){
		String str="";
		if(makeFName(filename).equals(filename)){
			str=filename+".txt";
		}else if(makeFName(filename).equals("txt")){
			str=makeFirstName(filename)
			+System.currentTimeMillis()%500+".txt";
		}else{
			str=makeFirstName(filename)+".txt";
		}
		return str;
	}
	private BufferedReader fileBuffered(){
		BufferedReader br=null;
		FileReader fr=null;
		File f1=null;
		try{
			f1=new File(fileNameInRead);
			fr=new FileReader(f1);
			br=new BufferedReader(fr);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return br;
	}
	private PrintWriter filePrint(){
		PrintWriter pw=null;
		FileWriter fw=null;
		File f2=null;
		try{
			f2=new File(fileNameInWrite);
			fw=new FileWriter(f2,false);
			pw=new PrintWriter(fw,true);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return pw;
	}
	public void fileReadAndWrite(){
		PrintWriter pw=null;
		BufferedReader br=null;
		try{
			br=fileBuffered();
			pw=filePrint();
			String str="";
			int i=0;
			while((str=br.readLine())!=null){
				pw.println(to3nums(++i,str));//filename.txt 저장
				//System.out.println(str);//콘솔에 출력
			}
			close(br,pw);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void txtReadAndWrite(){
		PrintWriter pw=null;
		BufferedReader br=null;
		try{
			br=fileBuffered();
			pw=filePrint();
			String str="";
			int i=0;
			while((str=br.readLine())!=null){
				pw.println(str);
				//System.out.println(str);//콘솔에 출력
			}
			close(br,pw);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void fileRAWDeleteSpace(){
		PrintWriter pw=null;
		BufferedReader br=null;
		try{
			br=fileBuffered();
			pw=filePrint();
			String str="";
			int i=0;
			while((str=br.readLine())!=null){//EOF
				if(isSpace(str)){
					continue;//공백이 있다면 다음라인으로
				}
				pw.println(to3nums(++i,str));
			}
			close(br,pw);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void close(BufferedReader br,PrintWriter pw){
		try{
			if(br!=null){
				br.close();
			}
			if(pw!=null){
				pw.close();
			}
		}catch(IOException ioe){
			ioe.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public int fileLineNums(){
		int i=0;
		BufferedReader br=null;
		try{
			br=fileBuffered();
			String str="";
			
			while((str=br.readLine())!=null){
				/*
				if(isSpace(str)){
					continue;
				}
				*/
				i++;
			}
			close(br,null);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}
	public int fileLineCiphers(){
		return toNum(fileLineNums());
	}
	private int toNum(int i){
		return (i+"").length();
	}
	private String to3nums(int i,String s){
		String str=toZeronums(i);
		str+=i+": "+s;
		return str;
	}
	private String toZeronums(int i){
		int count=fileLineCiphers();
		String stzero="";
		for(int j=0;j<count-toNum(i);j++){
			stzero+="0";
		}
		return stzero;
	}
	private boolean isSpace(String s){
		boolean isS=false;
		if(s.trim().length()==0){
			isS=true;
		}
		return isS;
	}
}