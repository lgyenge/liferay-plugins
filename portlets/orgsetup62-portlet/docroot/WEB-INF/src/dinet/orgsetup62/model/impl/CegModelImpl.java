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

package dinet.orgsetup62.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import dinet.orgsetup62.model.Ceg;
import dinet.orgsetup62.model.CegModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Ceg service. Represents a row in the &quot;orgsetup_Ceg&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link dinet.orgsetup62.model.CegModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CegImpl}.
 * </p>
 *
 * @author gyengelaszlo
 * @see CegImpl
 * @see dinet.orgsetup62.model.Ceg
 * @see dinet.orgsetup62.model.CegModel
 * @generated
 */
public class CegModelImpl extends BaseModelImpl<Ceg> implements CegModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ceg model instance should use the {@link dinet.orgsetup62.model.Ceg} interface instead.
	 */
	public static final String TABLE_NAME = "orgsetup_Ceg";
	public static final Object[][] TABLE_COLUMNS = {
			{ "cegId", Types.BIGINT },
			{ "azon_r", Types.BIGINT },
			{ "subAzon_r", Types.BIGINT },
			{ "category_r", Types.VARCHAR },
			{ "orgname_r", Types.VARCHAR },
			{ "azon_u", Types.BIGINT },
			{ "subAzon_u", Types.BIGINT },
			{ "liferayOrgId", Types.BIGINT },
			{ "orgname", Types.VARCHAR },
			{ "logo", Types.VARCHAR },
			{ "categoryId", Types.BIGINT },
			{ "category", Types.VARCHAR },
			{ "postalcode", Types.VARCHAR },
			{ "city", Types.VARCHAR },
			{ "street", Types.VARCHAR },
			{ "contact", Types.VARCHAR },
			{ "web", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "htmldescription", Types.VARCHAR },
			{ "keywords", Types.VARCHAR },
			{ "pageURL", Types.VARCHAR },
			{ "pagename", Types.VARCHAR },
			{ "date_", Types.TIMESTAMP },
			{ "pageURLAzon", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table orgsetup_Ceg (cegId LONG not null primary key,azon_r LONG,subAzon_r LONG,category_r VARCHAR(75) null,orgname_r VARCHAR(75) null,azon_u LONG,subAzon_u LONG,liferayOrgId LONG,orgname VARCHAR(75) null,logo VARCHAR(256) null,categoryId LONG,category VARCHAR(256) null,postalcode VARCHAR(75) null,city VARCHAR(75) null,street VARCHAR(75) null,contact VARCHAR(75) null,web VARCHAR(75) null,description STRING null,htmldescription TEXT null,keywords VARCHAR(2000) null,pageURL VARCHAR(256) null,pagename VARCHAR(75) null,date_ DATE null,pageURLAzon VARCHAR(256) null)";
	public static final String TABLE_SQL_DROP = "drop table orgsetup_Ceg";
	public static final String ORDER_BY_JPQL = " ORDER BY ceg.cegId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY orgsetup_Ceg.cegId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.dinet.orgsetup62.model.Ceg"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.dinet.orgsetup62.model.Ceg"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.dinet.orgsetup62.model.Ceg"),
			true);
	public static long AZON_U_COLUMN_BITMASK = 1L;
	public static long CATEGORY_COLUMN_BITMASK = 2L;
	public static long LIFERAYORGID_COLUMN_BITMASK = 4L;
	public static long PAGEURLAZON_COLUMN_BITMASK = 8L;
	public static long CEGID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.dinet.orgsetup62.model.Ceg"));

	public CegModelImpl() {
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
	public Class<?> getModelClass() {
		return Ceg.class;
	}

	@Override
	public String getModelClassName() {
		return Ceg.class.getName();
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
	}

	@Override
	public long getAzon_r() {
		return _azon_r;
	}

	@Override
	public void setAzon_r(long azon_r) {
		_azon_r = azon_r;
	}

	@Override
	public long getSubAzon_r() {
		return _subAzon_r;
	}

	@Override
	public void setSubAzon_r(long subAzon_r) {
		_subAzon_r = subAzon_r;
	}

	@Override
	public String getCategory_r() {
		if (_category_r == null) {
			return StringPool.BLANK;
		}
		else {
			return _category_r;
		}
	}

	@Override
	public void setCategory_r(String category_r) {
		_category_r = category_r;
	}

	@Override
	public String getOrgname_r() {
		if (_orgname_r == null) {
			return StringPool.BLANK;
		}
		else {
			return _orgname_r;
		}
	}

	@Override
	public void setOrgname_r(String orgname_r) {
		_orgname_r = orgname_r;
	}

	@Override
	public long getAzon_u() {
		return _azon_u;
	}

	@Override
	public void setAzon_u(long azon_u) {
		_columnBitmask |= AZON_U_COLUMN_BITMASK;

		if (!_setOriginalAzon_u) {
			_setOriginalAzon_u = true;

			_originalAzon_u = _azon_u;
		}

		_azon_u = azon_u;
	}

	public long getOriginalAzon_u() {
		return _originalAzon_u;
	}

	@Override
	public long getSubAzon_u() {
		return _subAzon_u;
	}

	@Override
	public void setSubAzon_u(long subAzon_u) {
		_subAzon_u = subAzon_u;
	}

	@Override
	public long getLiferayOrgId() {
		return _liferayOrgId;
	}

	@Override
	public void setLiferayOrgId(long liferayOrgId) {
		_columnBitmask |= LIFERAYORGID_COLUMN_BITMASK;

		if (!_setOriginalLiferayOrgId) {
			_setOriginalLiferayOrgId = true;

			_originalLiferayOrgId = _liferayOrgId;
		}

		_liferayOrgId = liferayOrgId;
	}

	public long getOriginalLiferayOrgId() {
		return _originalLiferayOrgId;
	}

	@Override
	public String getOrgname() {
		if (_orgname == null) {
			return StringPool.BLANK;
		}
		else {
			return _orgname;
		}
	}

	@Override
	public void setOrgname(String orgname) {
		_orgname = orgname;
	}

	@Override
	public String getLogo() {
		if (_logo == null) {
			return StringPool.BLANK;
		}
		else {
			return _logo;
		}
	}

	@Override
	public void setLogo(String logo) {
		_logo = logo;
	}

	@Override
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	@Override
	public String getCategory() {
		if (_category == null) {
			return StringPool.BLANK;
		}
		else {
			return _category;
		}
	}

	@Override
	public void setCategory(String category) {
		_columnBitmask |= CATEGORY_COLUMN_BITMASK;

		if (_originalCategory == null) {
			_originalCategory = _category;
		}

		_category = category;
	}

	public String getOriginalCategory() {
		return GetterUtil.getString(_originalCategory);
	}

	@Override
	public String getPostalcode() {
		if (_postalcode == null) {
			return StringPool.BLANK;
		}
		else {
			return _postalcode;
		}
	}

	@Override
	public void setPostalcode(String postalcode) {
		_postalcode = postalcode;
	}

	@Override
	public String getCity() {
		if (_city == null) {
			return StringPool.BLANK;
		}
		else {
			return _city;
		}
	}

	@Override
	public void setCity(String city) {
		_city = city;
	}

	@Override
	public String getStreet() {
		if (_street == null) {
			return StringPool.BLANK;
		}
		else {
			return _street;
		}
	}

	@Override
	public void setStreet(String street) {
		_street = street;
	}

	@Override
	public String getContact() {
		if (_contact == null) {
			return StringPool.BLANK;
		}
		else {
			return _contact;
		}
	}

	@Override
	public void setContact(String contact) {
		_contact = contact;
	}

	@Override
	public String getWeb() {
		if (_web == null) {
			return StringPool.BLANK;
		}
		else {
			return _web;
		}
	}

	@Override
	public void setWeb(String web) {
		_web = web;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public String getHtmldescription() {
		if (_htmldescription == null) {
			return StringPool.BLANK;
		}
		else {
			return _htmldescription;
		}
	}

	@Override
	public void setHtmldescription(String htmldescription) {
		_htmldescription = htmldescription;
	}

	@Override
	public String getKeywords() {
		if (_keywords == null) {
			return StringPool.BLANK;
		}
		else {
			return _keywords;
		}
	}

	@Override
	public void setKeywords(String keywords) {
		_keywords = keywords;
	}

	@Override
	public String getPageURL() {
		if (_pageURL == null) {
			return StringPool.BLANK;
		}
		else {
			return _pageURL;
		}
	}

	@Override
	public void setPageURL(String pageURL) {
		_pageURL = pageURL;
	}

	@Override
	public String getPagename() {
		if (_pagename == null) {
			return StringPool.BLANK;
		}
		else {
			return _pagename;
		}
	}

	@Override
	public void setPagename(String pagename) {
		_pagename = pagename;
	}

	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_date = date;
	}

	@Override
	public String getPageURLAzon() {
		if (_pageURLAzon == null) {
			return StringPool.BLANK;
		}
		else {
			return _pageURLAzon;
		}
	}

	@Override
	public void setPageURLAzon(String pageURLAzon) {
		_columnBitmask |= PAGEURLAZON_COLUMN_BITMASK;

		if (_originalPageURLAzon == null) {
			_originalPageURLAzon = _pageURLAzon;
		}

		_pageURLAzon = pageURLAzon;
	}

	public String getOriginalPageURLAzon() {
		return GetterUtil.getString(_originalPageURLAzon);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Ceg.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Ceg toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Ceg)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CegImpl cegImpl = new CegImpl();

		cegImpl.setCegId(getCegId());
		cegImpl.setAzon_r(getAzon_r());
		cegImpl.setSubAzon_r(getSubAzon_r());
		cegImpl.setCategory_r(getCategory_r());
		cegImpl.setOrgname_r(getOrgname_r());
		cegImpl.setAzon_u(getAzon_u());
		cegImpl.setSubAzon_u(getSubAzon_u());
		cegImpl.setLiferayOrgId(getLiferayOrgId());
		cegImpl.setOrgname(getOrgname());
		cegImpl.setLogo(getLogo());
		cegImpl.setCategoryId(getCategoryId());
		cegImpl.setCategory(getCategory());
		cegImpl.setPostalcode(getPostalcode());
		cegImpl.setCity(getCity());
		cegImpl.setStreet(getStreet());
		cegImpl.setContact(getContact());
		cegImpl.setWeb(getWeb());
		cegImpl.setDescription(getDescription());
		cegImpl.setHtmldescription(getHtmldescription());
		cegImpl.setKeywords(getKeywords());
		cegImpl.setPageURL(getPageURL());
		cegImpl.setPagename(getPagename());
		cegImpl.setDate(getDate());
		cegImpl.setPageURLAzon(getPageURLAzon());

		cegImpl.resetOriginalValues();

		return cegImpl;
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

		if (!(obj instanceof Ceg)) {
			return false;
		}

		Ceg ceg = (Ceg)obj;

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
	public void resetOriginalValues() {
		CegModelImpl cegModelImpl = this;

		cegModelImpl._originalAzon_u = cegModelImpl._azon_u;

		cegModelImpl._setOriginalAzon_u = false;

		cegModelImpl._originalLiferayOrgId = cegModelImpl._liferayOrgId;

		cegModelImpl._setOriginalLiferayOrgId = false;

		cegModelImpl._originalCategory = cegModelImpl._category;

		cegModelImpl._originalPageURLAzon = cegModelImpl._pageURLAzon;

		cegModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Ceg> toCacheModel() {
		CegCacheModel cegCacheModel = new CegCacheModel();

		cegCacheModel.cegId = getCegId();

		cegCacheModel.azon_r = getAzon_r();

		cegCacheModel.subAzon_r = getSubAzon_r();

		cegCacheModel.category_r = getCategory_r();

		String category_r = cegCacheModel.category_r;

		if ((category_r != null) && (category_r.length() == 0)) {
			cegCacheModel.category_r = null;
		}

		cegCacheModel.orgname_r = getOrgname_r();

		String orgname_r = cegCacheModel.orgname_r;

		if ((orgname_r != null) && (orgname_r.length() == 0)) {
			cegCacheModel.orgname_r = null;
		}

		cegCacheModel.azon_u = getAzon_u();

		cegCacheModel.subAzon_u = getSubAzon_u();

		cegCacheModel.liferayOrgId = getLiferayOrgId();

		cegCacheModel.orgname = getOrgname();

		String orgname = cegCacheModel.orgname;

		if ((orgname != null) && (orgname.length() == 0)) {
			cegCacheModel.orgname = null;
		}

		cegCacheModel.logo = getLogo();

		String logo = cegCacheModel.logo;

		if ((logo != null) && (logo.length() == 0)) {
			cegCacheModel.logo = null;
		}

		cegCacheModel.categoryId = getCategoryId();

		cegCacheModel.category = getCategory();

		String category = cegCacheModel.category;

		if ((category != null) && (category.length() == 0)) {
			cegCacheModel.category = null;
		}

		cegCacheModel.postalcode = getPostalcode();

		String postalcode = cegCacheModel.postalcode;

		if ((postalcode != null) && (postalcode.length() == 0)) {
			cegCacheModel.postalcode = null;
		}

		cegCacheModel.city = getCity();

		String city = cegCacheModel.city;

		if ((city != null) && (city.length() == 0)) {
			cegCacheModel.city = null;
		}

		cegCacheModel.street = getStreet();

		String street = cegCacheModel.street;

		if ((street != null) && (street.length() == 0)) {
			cegCacheModel.street = null;
		}

		cegCacheModel.contact = getContact();

		String contact = cegCacheModel.contact;

		if ((contact != null) && (contact.length() == 0)) {
			cegCacheModel.contact = null;
		}

		cegCacheModel.web = getWeb();

		String web = cegCacheModel.web;

		if ((web != null) && (web.length() == 0)) {
			cegCacheModel.web = null;
		}

		cegCacheModel.description = getDescription();

		String description = cegCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			cegCacheModel.description = null;
		}

		cegCacheModel.htmldescription = getHtmldescription();

		String htmldescription = cegCacheModel.htmldescription;

		if ((htmldescription != null) && (htmldescription.length() == 0)) {
			cegCacheModel.htmldescription = null;
		}

		cegCacheModel.keywords = getKeywords();

		String keywords = cegCacheModel.keywords;

		if ((keywords != null) && (keywords.length() == 0)) {
			cegCacheModel.keywords = null;
		}

		cegCacheModel.pageURL = getPageURL();

		String pageURL = cegCacheModel.pageURL;

		if ((pageURL != null) && (pageURL.length() == 0)) {
			cegCacheModel.pageURL = null;
		}

		cegCacheModel.pagename = getPagename();

		String pagename = cegCacheModel.pagename;

		if ((pagename != null) && (pagename.length() == 0)) {
			cegCacheModel.pagename = null;
		}

		Date date = getDate();

		if (date != null) {
			cegCacheModel.date = date.getTime();
		}
		else {
			cegCacheModel.date = Long.MIN_VALUE;
		}

		cegCacheModel.pageURLAzon = getPageURLAzon();

		String pageURLAzon = cegCacheModel.pageURLAzon;

		if ((pageURLAzon != null) && (pageURLAzon.length() == 0)) {
			cegCacheModel.pageURLAzon = null;
		}

		return cegCacheModel;
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

	private static ClassLoader _classLoader = Ceg.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] { Ceg.class };
	private long _cegId;
	private long _azon_r;
	private long _subAzon_r;
	private String _category_r;
	private String _orgname_r;
	private long _azon_u;
	private long _originalAzon_u;
	private boolean _setOriginalAzon_u;
	private long _subAzon_u;
	private long _liferayOrgId;
	private long _originalLiferayOrgId;
	private boolean _setOriginalLiferayOrgId;
	private String _orgname;
	private String _logo;
	private long _categoryId;
	private String _category;
	private String _originalCategory;
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
	private String _originalPageURLAzon;
	private long _columnBitmask;
	private Ceg _escapedModel;
}