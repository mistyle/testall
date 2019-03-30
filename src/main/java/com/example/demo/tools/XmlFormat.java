/**
* @Title: XmlFormat.java
* @Package demo.m2m
* @Description: TODO
* @author 陈杨
* @date 2016年7月8日 下午7:10:51
* @version V1.0
*/
package com.example.demo.tools;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @ClassName: XmlFormat
 * @Description: TODO
 * @author 陈杨
 * @date 2016年7月8日 下午7:10:51
 */
public class XmlFormat {
    public static String formatXml(String result) throws DocumentException, IOException {  
	   SAXReader reader=new SAXReader();  
	   StringReader in=new StringReader(result);  
	   Document doc=reader.read(in);  
	   OutputFormat formater=OutputFormat.createPrettyPrint();  
	   formater.setEncoding("UTF-8");  
	   StringWriter out=new StringWriter();  
	   XMLWriter writer=new XMLWriter(out,formater);  
	   writer.write(doc);  
	   writer.close();  
	   return out.toString();  
	}

	public static SOAPMessage formatXml(SOAPMessage soapResponse) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Result formatXml(StreamResult result) {
		// TODO Auto-generated method stub
		return null;
	}  


}
