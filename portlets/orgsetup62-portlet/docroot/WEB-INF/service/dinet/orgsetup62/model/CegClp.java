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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import dinet.orgsetup62.service.CegLocalServiceUtil;
import dinet.orgsetup62.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gyengelaszlo
 */
public class CegClp extends BaseModelImpl<Ceg> implements Ceg {
	public CegClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Ceg.class;
	}

	@Override
	public String getModelClassName() {
		return Ceg.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _cegId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCegId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _cegId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("cegId", getCegId());
		attributes.put("azon_r", getAzon_r());
		attributes.put("subAzon_r", getSubAzon_r());
		attributes.put("category_r", getCategory_r());
		attributes.put("orgname_r", getOrgname_r());
		attributes.put("azon_u", getAzon_u());
		attributes.put("subAzon_u", getSubAzon_u());
		attributes.put("liferayOrgId", getLiferayOrgId());
		attributes.put("orgname", getOrgname());
		attributes.put("logo", getLogo());
		attributes.put("categoryId", getCategoryId());
		attributes.put("category", getCategory());
		attributes.put("postalcode", getPostalcode());
		attributes.put("city", getCity());
		attributes.put("street", getStreet());
		attributes.put("contact", getContact());
		attributes.put("web", getWeb());
		attributes.put("description", getDescription());
		attributes.put("htmldescription", getHtmldescription());
		attributes.put("keywords", getKeywords());
		attributes.put("pageURL", getPageURL());
		attributes.put("pagename", getPagename());
		attributes.put("date", getDate());
		attributes.put("pageURLAzon", getPageURLAzon());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long cegId = (Long)attributes.get("cegId");

		if (cegId != null) {
			setCegId(cegId);
		}

		Long azon_r = (Long)attributes.get("azon_r");

		if (azon_r != null) {
			setAzon_r(azon_r);
		}

		Long subAzon_r = (Long)attributes.get("subAzon_r");

		if (subAzon_r != null) {
			setSubAzon_r(subAzon_r);
		}

		String category_r = (String)attributes.get("category_r");

		if (category_r != null) {
			setCategory_r(category_r);
		}

		String orgname_r = (String)attributes.get("orgname_r");

		if (orgname_r != null) {
			setOrgname_r(orgname_r);
		}

		Long azon_u = (Long)attributes.get("azon_u");

		if (azon_u != null) {
			setAzon_u(azon_u);
		}

		Long subAzon_u = (Long)attributes.get("subAzon_u");

		if (subAzon_u != null) {
			setSubAzon_u(subAzon_u);
		}

		Long liferayOrgId = (Long)attributes.get("liferayOrgId");

		if (liferayOrgId != null) {
			setLiferayOrgId(liferayOrgId);
		}

		String orgname = (String)attributes.get("orgname");

		if (orgname != null) {
			setOrgname(orgname);
		}

		String logo = (String)attributes.get("logo");

		if (logo != null) {
			setLogo(logo);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String postalcode = (String)attributes.get("postalcode");

		if (postalcode != null) {
			setPostalcode(postalcode);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String street = (String)attributes.get("street");

		if (street != null) {
			setStreet(street);
		}

		String contact = (String)attributes.get("contact");

		if (contact != null) {
			setContact(contact);
		}

		String web = (String)attributes.get("web");

		if (web != null) {
			setWeb(web);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String htmldescription = (String)attributes.get("htmldescription");

		if (htmldescription != null) {
			setHtmldescription(htmldescription);
		}

		String keywords = (String)attributes.get("keywords");

		if (keywords != null) {
			setKeywords(keywords);
		}

		String pageURL = (String)attributes.get("pageURL");

		if (pageURL != null) {
			setPageURL(pageURL);
		}

		String pagename = (String)attributes.get("pagename");

		if (pagename != null) {
			setPagename(pagename);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String pageURLAzon = (String)attributes.get("pageURLAzon");

		if (pageURLAzon != null) {
			setPageURLAzon(pageURLAzon);
		}
	}

	@Override
	public long getCegId() {
		return _cegId;
	}

	@Override
	public void setCegId(long cegId) {
		_cegId = cegId;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setCegId", long.class);

				method.invoke(_cegRemoteModel, cegId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAzon_r() {
		return _azon_r;
	}

	@Override
	public void setAzon_r(long azon_r) {
		_azon_r = azon_r;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setAzon_r", long.class);

				method.invoke(_cegRemoteModel, azon_r);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSubAzon_r() {
		return _subAzon_r;
	}

	@Override
	public void setSubAzon_r(long subAzon_r) {
		_subAzon_r = subAzon_r;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setSubAzon_r", long.class);

				method.invoke(_cegRemoteModel, subAzon_r);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategory_r() {
		return _category_r;
	}

	@Override
	public void setCategory_r(String category_r) {
		_category_r = category_r;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory_r", String.class);

				method.invoke(_cegRemoteModel, category_r);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrgname_r() {
		return _orgname_r;
	}

	@Override
	public void setOrgname_r(String orgname_r) {
		_orgname_r = orgname_r;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setOrgname_r", String.class);

				method.invoke(_cegRemoteModel, orgname_r);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAzon_u() {
		return _azon_u;
	}

	@Override
	public void setAzon_u(long azon_u) {
		_azon_u = azon_u;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setAzon_u", long.class);

				method.invoke(_cegRemoteModel, azon_u);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSubAzon_u() {
		return _subAzon_u;
	}

	@Override
	public void setSubAzon_u(long subAzon_u) {
		_subAzon_u = subAzon_u;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setSubAzon_u", long.class);

				method.invoke(_cegRemoteModel, subAzon_u);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLiferayOrgId() {
		return _liferayOrgId;
	}

	@Override
	public void setLiferayOrgId(long liferayOrgId) {
		_liferayOrgId = liferayOrgId;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setLiferayOrgId", long.class);

				method.invoke(_cegRemoteModel, liferayOrgId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrgname() {
		return _orgname;
	}

	@Override
	public void setOrgname(String orgname) {
		_orgname = orgname;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setOrgname", String.class);

				method.invoke(_cegRemoteModel, orgname);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLogo() {
		return _logo;
	}

	@Override
	public void setLogo(String logo) {
		_logo = logo;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setLogo", String.class);

				method.invoke(_cegRemoteModel, logo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId", long.class);

				method.invoke(_cegRemoteModel, categoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategory() {
		return _category;
	}

	@Override
	public void setCategory(String category) {
		_category = category;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_cegRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPostalcode() {
		return _postalcode;
	}

	@Override
	public void setPostalcode(String postalcode) {
		_postalcode = postalcode;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setPostalcode", String.class);

				method.invoke(_cegRemoteModel, postalcode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public void setCity(String city) {
		_city = city;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_cegRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStreet() {
		return _street;
	}

	@Override
	public void setStreet(String street) {
		_street = street;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setStreet", String.class);

				method.invoke(_cegRemoteModel, street);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContact() {
		return _contact;
	}

	@Override
	public void setContact(String contact) {
		_contact = contact;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setContact", String.class);

				method.invoke(_cegRemoteModel, contact);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWeb() {
		return _web;
	}

	@Override
	public void setWeb(String web) {
		_web = web;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setWeb", String.class);

				method.invoke(_cegRemoteModel, web);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_cegRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHtmldescription() {
		return _htmldescription;
	}

	@Override
	public void setHtmldescription(String htmldescription) {
		_htmldescription = htmldescription;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setHtmldescription",
						String.class);

				method.invoke(_cegRemoteModel, htmldescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getKeywords() {
		return _keywords;
	}

	@Override
	public void setKeywords(String keywords) {
		_keywords = keywords;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setKeywords", String.class);

				method.invoke(_cegRemoteModel, keywords);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPageURL() {
		return _pageURL;
	}

	@Override
	public void setPageURL(String pageURL) {
		_pageURL = pageURL;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setPageURL", String.class);

				method.invoke(_cegRemoteModel, pageURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPagename() {
		return _pagename;
	}

	@Override
	public void setPagename(String pagename) {
		_pagename = pagename;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setPagename", String.class);

				method.invoke(_cegRemoteModel, pagename);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_date = date;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setDate", Date.class);

				method.invoke(_cegRemoteModel, date);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPageURLAzon() {
		return _pageURLAzon;
	}

	@Override
	public void setPageURLAzon(String pageURLAzon) {
		_pageURLAzon = pageURLAzon;

		if (_cegRemoteModel != null) {
			try {
				Class<?> clazz = _cegRemoteModel.getClass();

				Method method = clazz.getMethod("setPageURLAzon", String.class);

				method.invoke(_cegRemoteModel, pageURLAzon);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCegRemoteModel() {
		return _cegRemoteModel;
	}

	public void setCegRemoteModel(BaseModel<?> cegRemoteModel) {
		_cegRemoteModel = cegRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _cegRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_cegRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CegLocalServiceUtil.addCeg(this);
		}
		else {
			CegLocalServiceUtil.updateCeg(this);
		}
	}

	@Override
	public Ceg toEscapedModel() {
		return (Ceg)ProxyUtil.newProxyInstance(Ceg.class.getClassLoader(),
			new Class[] { Ceg.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CegClp clone = new CegClp();

		clone.setCegId(getCegId());
		clone.setAzon_r(getAzon_r());
		clone.setSubAzon_r(getSubAzon_r());
		clone.setCategory_r(getCategory_r());
		clone.setOrgname_r(getOrgname_r());
		clone.setAzon_u(getAzon_u());
		clone.setSubAzon_u(getSubAzon_u());
		clone.setLiferayOrgId(getLiferayOrgId());
		clone.setOrgname(getOrgname());
		clone.setLogo(getLogo());
		clone.setCategoryId(getCategoryId());
		clone.setCategory(getCategory());
		clone.setPostalcode(getPostalcode());
		clone.setCity(getCity());
		clone.setStreet(getStreet());
		clone.setContact(getContact());
		clone.setWeb(getWeb());
		clone.setDescription(getDescription());
		clone.setHtmldescription(getHtmldescription());
		clone.setKeywords(getKeywords());
		clone.setPageURL(getPageURL());
		clone.setPagename(getPagename());
		clone.setDate(getDate());
		clone.setPageURLAzon(getPageURLAzon());

		return clone;
	}

	@Override
	public int compareTo(Ceg ceg) {
		long primaryKey = ceg.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CegClp)) {
			return false;
		}

		CegClp ceg = (CegClp)obj;

		long primaryKey = ceg.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{cegId=");
		sb.append(getCegId());
		sb.append(", azon_r=");
		sb.append(getAzon_r());
		sb.append(", subAzon_r=");
		sb.append(getSubAzon_r());
		sb.append(", category_r=");
		sb.append(getCategory_r());
		sb.append(", orgname_r=");
		sb.append(getOrgname_r());
		sb.append(", azon_u=");
		sb.append(getAzon_u());
		sb.append(", subAzon_u=");
		sb.append(getSubAzon_u());
		sb.append(", liferayOrgId=");
		sb.append(getLiferayOrgId());
		sb.append(", orgname=");
		sb.append(getOrgname());
		sb.append(", logo=");
		sb.append(getLogo());
		sb.append(", categoryId=");
		sb.append(getCategoryId());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", postalcode=");
		sb.append(getPostalcode());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", street=");
		sb.append(getStreet());
		sb.append(", contact=");
		sb.append(getContact());
		sb.append(", web=");
		sb.append(getWeb());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", htmldescription=");
		sb.append(getHtmldescription());
		sb.append(", keywords=");
		sb.append(getKeywords());
		sb.append(", pageURL=");
		sb.append(getPageURL());
		sb.append(", pagename=");
		sb.append(getPagename());
		sb.append(", date=");
		sb.append(getDate());
		sb.append(", pageURLAzon=");
		sb.append(getPageURLAzon());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(76);

		sb.append("<model><model-name>");
		sb.append("dinet.orgsetup62.model.Ceg");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>cegId</column-name><column-value><![CDATA[");
		sb.append(getCegId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>azon_r</column-name><column-value><![CDATA[");
		sb.append(getAzon_r());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subAzon_r</column-name><column-value><![CDATA[");
		sb.append(getSubAzon_r());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category_r</column-name><column-value><![CDATA[");
		sb.append(getCategory_r());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgname_r</column-name><column-value><![CDATA[");
		sb.append(getOrgname_r());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>azon_u</column-name><column-value><![CDATA[");
		sb.append(getAzon_u());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subAzon_u</column-name><column-value><![CDATA[");
		sb.append(getSubAzon_u());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>liferayOrgId</column-name><column-value><![CDATA[");
		sb.append(getLiferayOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orgname</column-name><column-value><![CDATA[");
		sb.append(getOrgname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logo</column-name><column-value><![CDATA[");
		sb.append(getLogo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postalcode</column-name><column-value><![CDATA[");
		sb.append(getPostalcode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>street</column-name><column-value><![CDATA[");
		sb.append(getStreet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contact</column-name><column-value><![CDATA[");
		sb.append(getContact());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>web</column-name><column-value><![CDATA[");
		sb.append(getWeb());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htmldescription</column-name><column-value><![CDATA[");
		sb.append(getHtmldescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>keywords</column-name><column-value><![CDATA[");
		sb.append(getKeywords());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pageURL</column-name><column-value><![CDATA[");
		sb.append(getPageURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pagename</column-name><column-value><![CDATA[");
		sb.append(getPagename());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pageURLAzon</column-name><column-value><![CDATA[");
		sb.append(getPageURLAzon());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _cegRemoteModel;
}