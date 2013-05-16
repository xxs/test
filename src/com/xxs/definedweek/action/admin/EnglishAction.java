package com.xxs.definedweek.action.admin;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;

import com.xxs.definedweek.action.shop.BaseShopAction;
import com.xxs.definedweek.bean.English;
import com.xxs.definedweek.util.EnglishReaderUtil;

/**
 * 前台Action类 - english
 */

@ParentPackage("admin")
public class EnglishAction extends BaseShopAction {

	private static final long serialVersionUID = -5370876618776672055L;
	
	private List<English> englishList;

	public String list() {
		englishList = EnglishReaderUtil.getEnglishList();
		return LIST;
	}

	public List<English> getEnglishList() {
		return englishList;
	}

	public void setEnglishList(List<English> englishList) {
		this.englishList = englishList;
	}
	
}