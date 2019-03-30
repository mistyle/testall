/**
* @Title: Xml2Json.java
* @Package demo.tools
* @Description: XML转JSON Java工具类
* @author 陈杨
* @date 2016年7月8日 下午8:07:46
* @version V1.0
*/
package com.example.demo.tools;
import java.io.ByteArrayInputStream;  
import java.io.File;  
import java.io.InputStream;  
import java.util.HashMap;  
import java.util.LinkedList;  
import java.util.List;  
import java.util.Map;  

import net.sf.json.JSONObject;   

import org.jdom.Document;  
import org.jdom.Element;  
import org.jdom.input.SAXBuilder; 
/**
 * @ClassName: Xml2Json
 * @Description: XML转JSON算法
 * @author 陈杨
 * @date 2016年7月8日 下午8:07:46
 */
public class Xml2Json {
	/** 
     * 转换一个xml格式的字符串到json格式 
     * @author 陈杨
     * @param xml格式的字符串 
     * @return 成功返回json 格式的字符串;失败返回null 
     */  
    public static String xml2JSON(String xml) {  
        JSONObject obj = new JSONObject();  
        try {  
            InputStream is = new ByteArrayInputStream(xml.getBytes("utf-8"));  
            SAXBuilder sb = new SAXBuilder();  
            Document doc = sb.build(is);  
            Element root = doc.getRootElement();  
            obj.put(root.getName(), iterateElement(root));  
            return obj.toString();  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
  
    /** 
     * 转换一个xml格式的字符串到json格式 
     * @author 陈杨
     * @param file，java.io.File实例是一个有效的xml文件 
     * @return 成功反回json 格式的字符串;失败反回null 
     */   
    public static String xml2JSON(File file) {  
        JSONObject obj = new JSONObject();  
        try {  
            SAXBuilder sb = new SAXBuilder();  
            Document doc = sb.build(file);  
            Element root = doc.getRootElement();  
            obj.put(root.getName(), iterateElement(root));  
            return obj.toString();  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
  
    /** 
     * 一个迭代方法 
     * @author 陈杨 
     * @param element org.jdom.Element 
     * @return java.util.Map 实例 
     */  
    private static Map<String, List>  iterateElement(Element element) {  
        List<?> jiedian = element.getChildren();  
        Element et = null;  
        Map<String, List> obj = new HashMap<String, List>();  
        List<Object> list = null;  
        for (int i = 0; i < jiedian.size(); i++) {  
            list = new LinkedList<Object>();  
            et = (Element) jiedian.get(i);  
            if (et.getTextTrim().equals("")) {  
                if (et.getChildren().size() == 0)  
                    continue;  
                if (obj.containsKey(et.getName())) {  
                    list = obj.get(et.getName());  
                }  
                list.add(iterateElement(et));  
                obj.put(et.getName(), list);  
            } else {  
                if (obj.containsKey(et.getName())) {  
                    list = obj.get(et.getName());  
                }  
                list.add(et.getTextTrim());  
                obj.put(et.getName(), list);  
            }  
        }  
        return obj;  
    }  
}
