package com.path.xml;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

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

public class XmlGeneratorWithHierarchy {

	/**
	 * 
	 * @param data
	 */
	public static void prepareData(HashMap<String, Object> data)
	{
		TagsCO tagsCO = new TagsCO();
		tagsCO.setName("Id");
		tagsCO.setValue("123");
		data.put("FIToFIPmtStsReq_TxInf_InstgAgt_BrnchId_Id", tagsCO);
		
		TagsCO tagsCO1 = new TagsCO();
		tagsCO1.setName("Nm");
		tagsCO1.setValue("11");
		data.put("FIToFIPmtStsReq_TxInf_InstgAgt_BrnchId_Nm", tagsCO1);
		
		TagsCO tagsCO3 = new TagsCO();
		tagsCO3.setName("LEI");
		tagsCO3.setValue("22");
		data.put("FIToFIPmtStsReq_TxInf_InstgAgt_BrnchId_LEI", tagsCO3);
		
		TagsCO tagsCO4 = new TagsCO();
		tagsCO4.setName("StsReqId");
		tagsCO4.setValue("33");
		data.put("FIToFIPmtStsReq_TxInf", tagsCO4);
		
		TagsCO tagsCO5 = new TagsCO();
		tagsCO5.setName("StsReqId");
		tagsCO5.setValue("44");
		data.put("FIToFIPmtStsReq_TxInf_StsReqId", tagsCO5);
		
		TagsCO tagsCO6 = new TagsCO();
		tagsCO6.setName("AccptncDtTm");
		tagsCO6.setValue("44");
		data.put("FIToFIPmtStsReq_TxInf_AccptncDtTm", tagsCO6);
		
		TagsCO tagsCO7 = new TagsCO();
		tagsCO7.setName("ClrSysRef");
		tagsCO7.setValue("55");
		data.put("FIToFIPmtStsReq_TxInf_ClrSysRef", tagsCO7);
		
		TagsCO tagsCO8 = new TagsCO();
		tagsCO8.setName("InstgAgt");
		tagsCO8.setValue("66");
		data.put("FIToFIPmtStsReq_TxInf_InstgAgt", tagsCO8);
		
		
		TagsCO tagsCO9 = new TagsCO();
		tagsCO9.setName("PlcAndNm");
		tagsCO9.setValue("77");
		data.put("FIToFIPmtStsReq_SplmtryData_PlcAndNm", tagsCO9);
		
		TagsCO tagsCO10 = new TagsCO();
		tagsCO10.setName("Cd");
		tagsCO10.setValue("88");
		data.put("FIToFIPmtStsReq_GrpHdr_InstdAgt_FinInstnId_PstlAdr_AdrTpCd_Cd", tagsCO10);
	}
	
	
	public static void processData() throws ParserConfigurationException, TransformerException
	{
		HashMap<String, Object> data = new HashMap<String, Object>();
		
		prepareData(data);
		
		
		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
		Document document = documentBuilder.newDocument();
		
		for (Map.Entry<String,Object> entry : data.entrySet())
		{
			
			String key = entry.getKey();
			Object value = entry.getValue();
			
			
			if(key == null || key.equals("")) continue;
			String HierarchySplitted[] = key.split("_");
			Element root = document.createElement(HierarchySplitted[0]);
			document.appendChild(root);
			
			for(String pTag : HierarchySplitted)
			{
				if(pTag.equals(HierarchySplitted[0])) continue;
				
				Element root1 = document.createElement(pTag);
				root.appendChild(root1);
			}
			
			System.out.println(convertToStr(document));
			
			break;
			
    	} 
		
		
	}
	
	
	public static void main(String[] args) throws ParserConfigurationException, TransformerException 
	{
		
		processData();

//		long start = Calendar.getInstance().getTimeInMillis();
//		
//		HashMap<String, Object> row1 = new HashMap<String, Object>();
//		row1.put("name", "Salman");
//		row1.put("pass", "123");
//		
//		
//		HashMap<String, Object> row2 = new HashMap<String, Object>();
//		row2.put("name", "Alim");
//		row2.put("pass", "1233");
//		
//		
//		ArrayList<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
//		
//		list.add(row1);
//		list.add(row2);
//		
//		DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
//		DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
//		Document document = documentBuilder.newDocument();
//		
//		// root element
//		Element root = document.createElement("user");
//		document.appendChild(root);
//		
//		
//		for(HashMap<String, Object> map : list)
//		{   
//			// root element
//			Element root1 = document.createElement("user");
//			root.appendChild(root1);
//			
//			for(String key : map.keySet())
//			{
//				Element element = createNode(key, root1);
//				element.appendChild(document.createTextNode(map.get(key).toString()));
//				root1.appendChild(element);
//			}
//			
//		}
//		System.out.println(convertToStr(document));
//		
//		long end = Calendar.getInstance().getTimeInMillis();
//		
//	    System.out.println(" Time take for looping took= " + (end - start)
//			    + "Ms");

	    
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
