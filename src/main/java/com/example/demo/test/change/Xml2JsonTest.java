package com.example.demo.test.change;

import com.example.demo.tools.JsonFormat;
import com.example.demo.tools.Xml2Json;

import net.sf.json.xml.XMLSerializer;
/**
 * xml转json
 * @author lenovo
 *
 */
public class Xml2JsonTest {

	public static void main(String[] args) {
		String xml1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?><REQUEST_XML><ID>0001</ID><NAME>零零幺</NAME><AGE>100</AGE><LIKE><FOOD></FOOD></LIKE></REQUEST_XML>";
		String xml2 = "<?xml version=\"1.0\" encoding=\"utf-8\"?><REQUEST_XML><ID>0001</ID><NAME>零零幺</NAME><AGE>100</AGE><LIKE><FOOD>香蕉</FOOD></LIKE></REQUEST_XML>";
		String xml3 = "<?xml version=\"1.0\" encoding=\"utf-8\"?><REQUEST_XML><ID>0001</ID><NAME>零零幺</NAME><AGE>100</AGE><LIKE><FOOD>香蕉</FOOD><FOOD>苹果</FOOD></LIKE></REQUEST_XML>";

		String xml = "<env:Envelope xmlns:env=\"http://schemas.xmlsoap.org/soap/envelope/\"><env:Header/><env:Body><ns1:EchoResponse xmlns:ns1=\"http://api.dcp.ericsson.net/ApiStatus\">"
				+ "<message>陈杨hello</message><message>陈杨hello</message></ns1:EchoResponse></env:Body></env:Envelope>";
		System.out.println(Xml2Json.xml2JSON(xml));

		String json = JsonFormat.formatJson(Xml2Json.xml2JSON(xml));
		System.out.println(json);
	}

	public static String xml2JSON(String xml) {
		return new XMLSerializer().read(xml).toString();
	}

}
