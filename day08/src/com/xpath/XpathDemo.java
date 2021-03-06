package com.xpath;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XpathDemo {
	public static void main(String[] args) throws DocumentException {
		//加载dom树
		Document doc=new SAXReader().read("xml/web.xml");
		//获取节点
		List<Node> list=doc.selectNodes("/web-app/servlet/servlet-name");
		System.out.println(list.get(0).getText());
		Node no=doc.selectSingleNode("//servlet/servlet-name");
		System.out.println(no.getText());
	}
}
