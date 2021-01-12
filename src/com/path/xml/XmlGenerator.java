package com.path.xml;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlGenerator {

	
	public static void main(String[] args) throws ParserConfigurationException, TransformerException 
	{

		long start = Calendar.getInstance().getTimeInMillis();
		
		HashMap<String, Object> row1 = new HashMap<String, Object>();
		
		
		row1.put("name", "Salman");
		row1.put("pass", "123");
		
		
		HashMap<String, Object> row2 = new HashMap<String, Object>();
		row2.put("name", "Alim");
		row2.put("pass", "1233");
		
		
		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		list.add(row1);
		list.add(row2);
		
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
		Document document = documentBuilder.newDocument();
		
		// root element
		Element root = document.createElement("user");
		document.appendChild(root);
		
		
		for(HashMap<String, Object> map : list)
		{   
			// root element
			Element root1 = document.createElement("user");
			root.appendChild(root1);
			
			for(String key : map.keySet())
			{
				Element element = createNode(key, root1);
				element.appendChild(document.createTextNode(map.get(key).toString()));
				root1.appendChild(element);
			}
			
		}
		System.out.println(convertToStr(document));
		
		long end = Calendar.getInstance().getTimeInMillis();
		
	    System.out.println(" Time take for looping took= " + (end - start)
			    + "Ms");

	    
	}
	
	
	public static Element createNode(String nodeName, Element root)
	{
		Document document = root.getOwnerDocument();
		// prepare parse element
		Element node = document.createElement(nodeName);
		
		return node;
	}
	
	public static void createNode(Element root) throws TransformerException
	{
		Document document = root.getOwnerDocument();

		// prepare parse element
		Element node = document.createElement("firstname");
		node.appendChild(document.createTextNode("yong"));
        
//		Attr attr = document.createAttribute("type");
//		attr.setValue("111");
//		parseElement.setAttributeNode(attr);
		
		
		root.appendChild(node);
		
	}
	
	/**
	 * /**
	 * Xml Section will be moved to another method
	 */
//	DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
	//DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
	//document = documentBuilder.newDocument();
	
	
    /**
     * 
     * @param document
     * @return
     * @throws TransformerException
     */
    public static String convertToStr(Document document) throws TransformerException
    {

	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
	transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	//DOMImplementation domImpl = document.getImplementation();

	// @todo change this
//	DocumentType doctype = domImpl.createDocumentType("doctype", "-//J8583//DTD CONFIG 1.0//EN",
//		"http://j8583.sourceforge.net/j8583.dtd");
//
//	transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, doctype.getPublicId());
//	transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, doctype.getSystemId());

	StringWriter writer = new StringWriter();
	StreamResult result = new StreamResult(writer);
	DOMSource domSource = new DOMSource(document);
	transformer.transform(domSource, result);

	// print out the configuration to the file
	//Log.getInstance().debug(writer.toString());

	return writer.toString();

    }

}
