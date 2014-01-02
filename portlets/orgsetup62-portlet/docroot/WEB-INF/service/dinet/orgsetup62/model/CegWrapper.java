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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Ceg}.
 * </p>
 *
 * @author gyengelaszlo
 * @see Ceg
 * @generated
 */
public class CegWrapper implements Ceg, ModelWrapper<Ceg> {
	public CegWrapper(Ceg ceg) {
		_ceg = ceg;
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

	/**
	* Returns the primary key of this ceg.
	*
	* @return the primary key of this ceg
	*/
	@Override
	public long getPrimaryKey() {
		return _ceg.getPrimaryKey();
	}

	/**
	* Sets the primary key of this ceg.
	*
	* @param primaryKey the primary key of this ceg
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ceg.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ceg ID of this ceg.
	*
	* @return the ceg ID of this ceg
	*/
	@Override
	public long getCegId() {
		return _ceg.getCegId();
	}

	/**
	* Sets the ceg ID of this ceg.
	*
	* @param cegId the ceg ID of this ceg
	*/
	@Override
	public void setCegId(long cegId) {
		_ceg.setCegId(cegId);
	}

	/**
	* Returns the azon_r of this ceg.
	*
	* @return the azon_r of this ceg
	*/
	@Override
	public long getAzon_r() {
		return _ceg.getAzon_r();
	}

	/**
	* Sets the azon_r of this ceg.
	*
	* @param azon_r the azon_r of this ceg
	*/
	@Override
	public void setAzon_r(long azon_r) {
		_ceg.setAzon_r(azon_r);
	}

	/**
	* Returns the sub azon_r of this ceg.
	*
	* @return the sub azon_r of this ceg
	*/
	@Override
	public long getSubAzon_r() {
		return _ceg.getSubAzon_r();
	}

	/**
	* Sets the sub azon_r of this ceg.
	*
	* @param subAzon_r the sub azon_r of this ceg
	*/
	@Override
	public void setSubAzon_r(long subAzon_r) {
		_ceg.setSubAzon_r(subAzon_r);
	}

	/**
	* Returns the category_r of this ceg.
	*
	* @return the category_r of this ceg
	*/
	@Override
	public java.lang.String getCategory_r() {
		return _ceg.getCategory_r();
	}

	/**
	* Sets the category_r of this ceg.
	*
	* @param category_r the category_r of this ceg
	*/
	@Override
	public void setCategory_r(java.lang.String category_r) {
		_ceg.setCategory_r(category_r);
	}

	/**
	* Returns the orgname_r of this ceg.
	*
	* @return the orgname_r of this ceg
	*/
	@Override
	public java.lang.String getOrgname_r() {
		return _ceg.getOrgname_r();
	}

	/**
	* Sets the orgname_r of this ceg.
	*
	* @param orgname_r the orgname_r of this ceg
	*/
	@Override
	public void setOrgname_r(java.lang.String orgname_r) {
		_ceg.setOrgname_r(orgname_r);
	}

	/**
	* Returns the azon_u of this ceg.
	*
	* @return the azon_u of this ceg
	*/
	@Override
	public long getAzon_u() {
		return _ceg.getAzon_u();
	}

	/**
	* Sets the azon_u of this ceg.
	*
	* @param azon_u the azon_u of this ceg
	*/
	@Override
	public void setAzon_u(long azon_u) {
		_ceg.setAzon_u(azon_u);
	}

	/**
	* Returns the sub azon_u of this ceg.
	*
	* @return the sub azon_u of this ceg
	*/
	@Override
	public long getSubAzon_u() {
		return _ceg.getSubAzon_u();
	}

	/**
	* Sets the sub azon_u of this ceg.
	*
	* @param subAzon_u the sub azon_u of this ceg
	*/
	@Override
	public void setSubAzon_u(long subAzon_u) {
		_ceg.setSubAzon_u(subAzon_u);
	}

	/**
	* Returns the liferay org ID of this ceg.
	*
	* @return the liferay org ID of this ceg
	*/
	@Override
	public long getLiferayOrgId() {
		return _ceg.getLiferayOrgId();
	}

	/**
	* Sets the liferay org ID of this ceg.
	*
	* @param liferayOrgId the liferay org ID of this ceg
	*/
	@Override
	public void setLiferayOrgId(long liferayOrgId) {
		_ceg.setLiferayOrgId(liferayOrgId);
	}

	/**
	* Returns the orgname of this ceg.
	*
	* @return the orgname of this ceg
	*/
	@Override
	public java.lang.String getOrgname() {
		return _ceg.getOrgname();
	}

	/**
	* Sets the orgname of this ceg.
	*
	* @param orgname the orgname of this ceg
	*/
	@Override
	public void setOrgname(java.lang.String orgname) {
		_ceg.setOrgname(orgname);
	}

	/**
	* Returns the logo of this ceg.
	*
	* @return the logo of this ceg
	*/
	@Override
	public java.lang.String getLogo() {
		return _ceg.getLogo();
	}

	/**
	* Sets the logo of this ceg.
	*
	* @param logo the logo of this ceg
	*/
	@Override
	public void setLogo(java.lang.String logo) {
		_ceg.setLogo(logo);
	}

	/**
	* Returns the category ID of this ceg.
	*
	* @return the category ID of this ceg
	*/
	@Override
	public long getCategoryId() {
		return _ceg.getCategoryId();
	}

	/**
	* Sets the category ID of this ceg.
	*
	* @param categoryId the category ID of this ceg
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_ceg.setCategoryId(categoryId);
	}

	/**
	* Returns the category of this ceg.
	*
	* @return the category of this ceg
	*/
	@Override
	public java.lang.String getCategory() {
		return _ceg.getCategory();
	}

	/**
	* Sets the category of this ceg.
	*
	* @param category the category of this ceg
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_ceg.setCategory(category);
	}

	/**
	* Returns the postalcode of this ceg.
	*
	* @return the postalcode of this ceg
	*/
	@Override
	public java.lang.String getPostalcode() {
		return _ceg.getPostalcode();
	}

	/**
	* Sets the postalcode of this ceg.
	*
	* @param postalcode the postalcode of this ceg
	*/
	@Override
	public void setPostalcode(java.lang.String postalcode) {
		_ceg.setPostalcode(postalcode);
	}

	/**
	* Returns the city of this ceg.
	*
	* @return the city of this ceg
	*/
	@Override
	public java.lang.String getCity() {
		return _ceg.getCity();
	}

	/**
	* Sets the city of this ceg.
	*
	* @param city the city of this ceg
	*/
	@Override
	public void setCity(java.lang.String city) {
		_ceg.setCity(city);
	}

	/**
	* Returns the street of this ceg.
	*
	* @return the street of this ceg
	*/
	@Override
	public java.lang.String getStreet() {
		return _ceg.getStreet();
	}

	/**
	* Sets the street of this ceg.
	*
	* @param street the street of this ceg
	*/
	@Override
	public void setStreet(java.lang.String street) {
		_ceg.setStreet(street);
	}

	/**
	* Returns the contact of this ceg.
	*
	* @return the contact of this ceg
	*/
	@Override
	public java.lang.String getContact() {
		return _ceg.getContact();
	}

	/**
	* Sets the contact of this ceg.
	*
	* @param contact the contact of this ceg
	*/
	@Override
	public void setContact(java.lang.String contact) {
		_ceg.setContact(contact);
	}

	/**
	* Returns the web of this ceg.
	*
	* @return the web of this ceg
	*/
	@Override
	public java.lang.String getWeb() {
		return _ceg.getWeb();
	}

	/**
	* Sets the web of this ceg.
	*
	* @param web the web of this ceg
	*/
	@Override
	public void setWeb(java.lang.String web) {
		_ceg.setWeb(web);
	}

	/**
	* Returns the description of this ceg.
	*
	* @return the description of this ceg
	*/
	@Override
	public java.lang.String getDescription() {
		return _ceg.getDescription();
	}

	/**
	* Sets the description of this ceg.
	*
	* @param description the description of this ceg
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_ceg.setDescription(description);
	}

	/**
	* Returns the htmldescription of this ceg.
	*
	* @return the htmldescription of this ceg
	*/
	@Override
	public java.lang.String getHtmldescription() {
		return _ceg.getHtmldescription();
	}

	/**
	* Sets the htmldescription of this ceg.
	*
	* @param htmldescription the htmldescription of this ceg
	*/
	@Override
	public void setHtmldescription(java.lang.String htmldescription) {
		_ceg.setHtmldescription(htmldescription);
	}

	/**
	* Returns the keywords of this ceg.
	*
	* @return the keywords of this ceg
	*/
	@Override
	public java.lang.String getKeywords() {
		return _ceg.getKeywords();
	}

	/**
	* Sets the keywords of this ceg.
	*
	* @param keywords the keywords of this ceg
	*/
	@Override
	public void setKeywords(java.lang.String keywords) {
		_ceg.setKeywords(keywords);
	}

	/**
	* Returns the page u r l of this ceg.
	*
	* @return the page u r l of this ceg
	*/
	@Override
	public java.lang.String getPageURL() {
		return _ceg.getPageURL();
	}

	/**
	* Sets the page u r l of this ceg.
	*
	* @param pageURL the page u r l of this ceg
	*/
	@Override
	public void setPageURL(java.lang.String pageURL) {
		_ceg.setPageURL(pageURL);
	}

	/**
	* Returns the pagename of this ceg.
	*
	* @return the pagename of this ceg
	*/
	@Override
	public java.lang.String getPagename() {
		return _ceg.getPagename();
	}

	/**
	* Sets the pagename of this ceg.
	*
	* @param pagename the pagename of this ceg
	*/
	@Override
	public void setPagename(java.lang.String pagename) {
		_ceg.setPagename(pagename);
	}

	/**
	* Returns the date of this ceg.
	*
	* @return the date of this ceg
	*/
	@Override
	public java.util.Date getDate() {
		return _ceg.getDate();
	}

	/**
	* Sets the date of this ceg.
	*
	* @param date the date of this ceg
	*/
	@Override
	public void setDate(java.util.Date date) {
		_ceg.setDate(date);
	}

	/**
	* Returns the page u r l azon of this ceg.
	*
	* @return the page u r l azon of this ceg
	*/
	@Override
	public java.lang.String getPageURLAzon() {
		return _ceg.getPageURLAzon();
	}

	/**
	* Sets the page u r l azon of this ceg.
	*
	* @param pageURLAzon the page u r l azon of this ceg
	*/
	@Override
	public void setPageURLAzon(java.lang.String pageURLAzon) {
		_ceg.setPageURLAzon(pageURLAzon);
	}

	@Override
	public boolean isNew() {
		return _ceg.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_ceg.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _ceg.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ceg.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _ceg.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _ceg.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ceg.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ceg.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_ceg.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_ceg.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ceg.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CegWrapper((Ceg)_ceg.clone());
	}

	@Override
	public int compareTo(dinet.orgsetup62.model.Ceg ceg) {
		return _ceg.compareTo(ceg);
	}

	@Override
	public int hashCode() {
		return _ceg.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<dinet.orgsetup62.model.Ceg> toCacheModel() {
		return _ceg.toCacheModel();
	}

	@Override
	public dinet.orgsetup62.model.Ceg toEscapedModel() {
		return new CegWrapper(_ceg.toEscapedModel());
	}

	@Override
	public dinet.orgsetup62.model.Ceg toUnescapedModel() {
		return new CegWrapper(_ceg.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ceg.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ceg.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ceg.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CegWrapper)) {
			return false;
		}

		CegWrapper cegWrapper = (CegWrapper)obj;

		if (Validator.equals(_ceg, cegWrapper._ceg)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Ceg getWrappedCeg() {
		return _ceg;
	}

	@Override
	public Ceg getWrappedModel() {
		return _ceg;
	}

	@Override
	public void resetOriginalValues() {
		_ceg.resetOriginalValues();
	}

	private Ceg _ceg;
}