/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package dinet.orgsetup62.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gyengelaszlo
 * @generated
 */
public class CegSoap implements Serializable {
	public static CegSoap toSoapModel(Ceg model) {
		CegSoap soapModel = new CegSoap();

		soapModel.setCegId(model.getCegId());
		soapModel.setAzon_r(model.getAzon_r());
		soapModel.setSubAzon_r(model.getSubAzon_r());
		soapModel.setCategory_r(model.getCategory_r());
		soapModel.setOrgname_r(model.getOrgname_r());
		soapModel.setAzon_u(model.getAzon_u());
		soapModel.setSubAzon_u(model.getSubAzon_u());
		soapModel.setLiferayOrgId(model.getLiferayOrgId());
		soapModel.setOrgname(model.getOrgname());
		soapModel.setLogo(model.getLogo());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setCategory(model.getCategory());
		soapModel.setPostalcode(model.getPostalcode());
		soapModel.setCity(model.getCity());
		soapModel.setStreet(model.getStreet());
		soapModel.setContact(model.getContact());
		soapModel.setWeb(model.getWeb());
		soapModel.setDescription(model.getDescription());
		soapModel.setHtmldescription(model.getHtmldescription());
		soapModel.setKeywords(model.getKeywords());
		soapModel.setPageURL(model.getPageURL());
		soapModel.setPagename(model.getPagename());
		soapModel.setDate(model.getDate());
		soapModel.setPageURLAzon(model.getPageURLAzon());

		return soapModel;
	}

	public static CegSoap[] toSoapModels(Ceg[] models) {
		CegSoap[] soapModels = new CegSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CegSoap[][] toSoapModels(Ceg[][] models) {
		CegSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CegSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CegSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CegSoap[] toSoapModels(List<Ceg> models) {
		List<CegSoap> soapModels = new ArrayList<CegSoap>(models.size());

		for (Ceg model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CegSoap[soapModels.size()]);
	}

	public CegSoap() {
	}

	public long getPrimaryKey() {
		return _cegId;
	}

	public void setPrimaryKey(long pk) {
		setCegId(pk);
	}

	public long getCegId() {
		return _cegId;
	}

	public void setCegId(long cegId) {
		_cegId = cegId;
	}

	public long getAzon_r() {
		return _azon_r;
	}

	public void setAzon_r(long azon_r) {
		_azon_r = azon_r;
	}

	public long getSubAzon_r() {
		return _subAzon_r;
	}

	public void setSubAzon_r(long subAzon_r) {
		_subAzon_r = subAzon_r;
	}

	public String getCategory_r() {
		return _category_r;
	}

	public void setCategory_r(String category_r) {
		_category_r = category_r;
	}

	public String getOrgname_r() {
		return _orgname_r;
	}

	public void setOrgname_r(String orgname_r) {
		_orgname_r = orgname_r;
	}

	public long getAzon_u() {
		return _azon_u;
	}

	public void setAzon_u(long azon_u) {
		_azon_u = azon_u;
	}

	public long getSubAzon_u() {
		return _subAzon_u;
	}

	public void setSubAzon_u(long subAzon_u) {
		_subAzon_u = subAzon_u;
	}

	public long getLiferayOrgId() {
		return _liferayOrgId;
	}

	public void setLiferayOrgId(long liferayOrgId) {
		_liferayOrgId = liferayOrgId;
	}

	public String getOrgname() {
		return _orgname;
	}

	public void setOrgname(String orgname) {
		_orgname = orgname;
	}

	public String getLogo() {
		return _logo;
	}

	public void setLogo(String logo) {
		_logo = logo;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getPostalcode() {
		return _postalcode;
	}

	public void setPostalcode(String postalcode) {
		_postalcode = postalcode;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getStreet() {
		return _street;
	}

	public void setStreet(String street) {
		_street = street;
	}

	public String getContact() {
		return _contact;
	}

	public void setContact(String contact) {
		_contact = contact;
	}

	public String getWeb() {
		return _web;
	}

	public void setWeb(String web) {
		_web = web;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getHtmldescription() {
		return _htmldescription;
	}

	public void setHtmldescription(String htmldescription) {
		_htmldescription = htmldescription;
	}

	public String getKeywords() {
		return _keywords;
	}

	public void setKeywords(String keywords) {
		_keywords = keywords;
	}

	public String getPageURL() {
		return _pageURL;
	}

	public void setPageURL(String pageURL) {
		_pageURL = pageURL;
	}

	public String getPagename() {
		return _pagename;
	}

	public void setPagename(String pagename) {
		_pagename = pagename;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public String getPageURLAzon() {
		return _pageURLAzon;
	}

	public void setPageURLAzon(String pageURLAzon) {
		_pageURLAzon = pageURLAzon;
	}

	private long _cegId;
	private long _azon_r;
	private long _subAzon_r;
	private String _category_r;
	private String _orgname_r;
	private long _azon_u;
	private long _subAzon_u;
	private long _liferayOrgId;
	private String _orgname;
	private String _logo;
	private long _categoryId;
	private String _category;
	private String _postalcode;
	private String _city;
	private String _street;
	private String _contact;
	private String _web;
	private String _description;
	private String _htmldescription;
	private String _keywords;
	private String _pageURL;
	private String _pagename;
	private Date _date;
	private String _pageURLAzon;
}