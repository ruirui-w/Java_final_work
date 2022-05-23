package com.ikags.utils.bxml;

import com.ikags.utils.FileUtil;
import com.ikags.utils.StringUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class J2SETest {
	public static void main(String[] args){
		
		testjson(); //JSON��ȡ
		//testxml();  //xml��ȡ
	}
	
	public static void testjson(){
		String path="C:\\Users\\airzhangfish\\Desktop\\�����⳵\\store��ɳ.txt";
		

		try{
			System.out.println("startload");
			String data=StringUtil.getLocalFileText(path);
			com.ikags.utils.bxml.BXmlElement root=new com.ikags.utils.bxml.BXmlElement();
			root.setTagName("root");
			root= com.ikags.utils.bxml.BJsonDriver.loadJson(root,data);
//			root.printNode(1);
			
			String savecsvdata= com.ikags.utils.bxml.BXmlUtil.converterBXml2CSV(root,true,true);
			FileUtil.saveFile(path, ".csv", savecsvdata);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static void testxml(){
		File file=new File("C:\\Users\\airzhangfish\\Desktop\\�����⳵\\store����.txt");
		try{
			long[] long1=new long[10];
			long[] long2=new long[10];
//			for(int i=0;i<10;i++){
				
				//SAX�������ٶ�
				InputStream in2 = new FileInputStream(file);
		  		long starttime2=System.currentTimeMillis();
		  		com.ikags.utils.bxml.BXmlElement root2=testBXML2(in2);
				long endtime2=System.currentTimeMillis();
				
				root2.printNode(1);
				
			
		
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	public static com.ikags.utils.bxml.BXmlElement testBXML2(InputStream in){
		com.ikags.utils.bxml.BXmlElement root=null;
	      try{
	  		 root= com.ikags.utils.bxml.BXmlDriver.loadXML(in);
	        }catch(Exception ex){
	      	  ex.printStackTrace();
	        }	
	      return root;
	}
	
	
	
}
