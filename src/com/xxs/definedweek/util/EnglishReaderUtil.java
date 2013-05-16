package com.xxs.definedweek.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;

import com.xxs.definedweek.bean.English;

/**
 * 工具类 - english集合读取
 */

public class EnglishReaderUtil {

	private static final String ENGLISH_XML_FILE_NAME = "english.xml";// definedweek.xml配置文件名称

	@SuppressWarnings("unchecked")
	public static List<English> getEnglishList() {
		List<English> englishList = null;
		File englishXmlFile = null;
		Document document = null;
		try {
			englishXmlFile = new ClassPathResource(ENGLISH_XML_FILE_NAME)
					.getFile();
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(englishXmlFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Node> nodeList = document.selectNodes("/wordbook/*");
		Iterator<Node> iterator = nodeList.iterator();

		englishList = new ArrayList<English>();
		while (iterator.hasNext()) {
			Node node = iterator.next();
			Node wordNode = node.selectSingleNode("word");
			Node transNode = node.selectSingleNode("trans");
			Node phoneticNode = node.selectSingleNode("phonetic");
			Node tagsNode = node.selectSingleNode("tags");
			Node progressNode = node.selectSingleNode("progress");

			English english = new English();

			english.setWord(wordNode.getText());
			english.setTrans(transNode.getText());
			english.setTags(tagsNode.getText());
			english.setPhonetic(phoneticNode.getText());
			english.setProgress(progressNode.getText());
			englishList.add(english);
		}
		return englishList;
	}

}