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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Org}.
 * </p>
 *
 * @author gyengelaszlo
 * @see Org
 * @generated
 */
public class OrgWrapper implements Org, ModelWrapper<Org> {
	public OrgWrapper(Org org) {
		_org = org;
	}

	@Override
	public Class<?> getModelClass() {
		return Org.class;
	}

	@Override
	public String getModelClassName() {
		return Org.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("orgID", getOrgID());
		attributes.put("origAzon", getOrigAzon());
		attributes.put("azon_r", getAzon_r());
		attributes.put("subAzon_r", getSubAzon_r());
		attributes.put("category_r", getCategory_r());
		attributes.put("orgname_r", getOrgname_r());
		attributes.put("city", getCity());
		attributes.put("address1", getAddress1());
		attributes.put("postalCode", getPostalCode());
		attributes.put("webURL", getWebURL());
		attributes.put("contact", getContact());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("description", getDescription());
		attributes.put("keywords", getKeywords());
		attributes.put("imageURL", getImageURL());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long orgID = (Long)attributes.get("orgID");

		if (orgID != null) {
			setOrgID(orgID);
		}

		Long origAzon = (Long)attributes.get("origAzon");

		if (origAzon != null) {
			setOrigAzon(origAzon);
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

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String postalCode = (String)attributes.get("postalCode");

		if (postalCode != null) {
			setPostalCode(postalCode);
		}

		String webURL = (String)attributes.get("webURL");

		if (webURL != null) {
			setWebURL(webURL);
		}

		String contact = (String)attributes.get("contact");

		if (contact != null) {
			setContact(contact);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String keywords = (String)attributes.get("keywords");

		if (keywords != null) {
			setKeywords(keywords);
		}

		String imageURL = (String)attributes.get("imageURL");

		if (imageURL != null) {
			setImageURL(imageURL);
		}
	}

	/**
	* Returns the primary key of this org.
	*
	* @return the primary key of this org
	*/
	@Override
	public long getPrimaryKey() {
		return _org.getPrimaryKey();
	}

	/**
	* Sets the primary key of this org.
	*
	* @param primaryKey the primary key of this org
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_org.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the org i d of this org.
	*
	* @return the org i d of this org
	*/
	@Override
	public long getOrgID() {
		return _org.getOrgID();
	}

	/**
	* Sets the org i d of this org.
	*
	* @param orgID the org i d of this org
	*/
	@Override
	public void setOrgID(long orgID) {
		_org.setOrgID(orgID);
	}

	/**
	* Returns the orig azon of this org.
	*
	* @return the orig azon of this org
	*/
	@Override
	public long getOrigAzon() {
		return _org.getOrigAzon();
	}

	/**
	* Sets the orig azon of this org.
	*
	* @param origAzon the orig azon of this org
	*/
	@Override
	public void setOrigAzon(long origAzon) {
		_org.setOrigAzon(origAzon);
	}

	/**
	* Returns the azon_r of this org.
	*
	* @return the azon_r of this org
	*/
	@Override
	public long getAzon_r() {
		return _org.getAzon_r();
	}

	/**
	* Sets the azon_r of this org.
	*
	* @param azon_r the azon_r of this org
	*/
	@Override
	public void setAzon_r(long azon_r) {
		_org.setAzon_r(azon_r);
	}

	/**
	* Returns the sub azon_r of this org.
	*
	* @return the sub azon_r of this org
	*/
	@Override
	public long getSubAzon_r() {
		return _org.getSubAzon_r();
	}

	/**
	* Sets the sub azon_r of this org.
	*
	* @param subAzon_r the sub azon_r of this org
	*/
	@Override
	public void setSubAzon_r(long subAzon_r) {
		_org.setSubAzon_r(subAzon_r);
	}

	/**
	* Returns the category_r of this org.
	*
	* @return the category_r of this org
	*/
	@Override
	public java.lang.String getCategory_r() {
		return _org.getCategory_r();
	}

	/**
	* Sets the category_r of this org.
	*
	* @param category_r the category_r of this org
	*/
	@Override
	public void setCategory_r(java.lang.String category_r) {
		_org.setCategory_r(category_r);
	}

	/**
	* Returns the orgname_r of this org.
	*
	* @return the orgname_r of this org
	*/
	@Override
	public java.lang.String getOrgname_r() {
		return _org.getOrgname_r();
	}

	/**
	* Sets the orgname_r of this org.
	*
	* @param orgname_r the orgname_r of this org
	*/
	@Override
	public void setOrgname_r(java.lang.String orgname_r) {
		_org.setOrgname_r(orgname_r);
	}

	/**
	* Returns the city of this org.
	*
	* @return the city of this org
	*/
	@Override
	public java.lang.String getCity() {
		return _org.getCity();
	}

	/**
	* Sets the city of this org.
	*
	* @param city the city of this org
	*/
	@Override
	public void setCity(java.lang.String city) {
		_org.setCity(city);
	}

	/**
	* Returns the address1 of this org.
	*
	* @return the address1 of this org
	*/
	@Override
	public java.lang.String getAddress1() {
		return _org.getAddress1();
	}

	/**
	* Sets the address1 of this org.
	*
	* @param address1 the address1 of this org
	*/
	@Override
	public void setAddress1(java.lang.String address1) {
		_org.setAddress1(address1);
	}

	/**
	* Returns the postal code of this org.
	*
	* @return the postal code of this org
	*/
	@Override
	public java.lang.String getPostalCode() {
		return _org.getPostalCode();
	}

	/**
	* Sets the postal code of this org.
	*
	* @param postalCode the postal code of this org
	*/
	@Override
	public void setPostalCode(java.lang.String postalCode) {
		_org.setPostalCode(postalCode);
	}

	/**
	* Returns the web u r l of this org.
	*
	* @return the web u r l of this org
	*/
	@Override
	public java.lang.String getWebURL() {
		return _org.getWebURL();
	}

	/**
	* Sets the web u r l of this org.
	*
	* @param webURL the web u r l of this org
	*/
	@Override
	public void setWebURL(java.lang.String webURL) {
		_org.setWebURL(webURL);
	}

	/**
	* Returns the contact of this org.
	*
	* @return the contact of this org
	*/
	@Override
	public java.lang.String getContact() {
		return _org.getContact();
	}

	/**
	* Sets the contact of this org.
	*
	* @param contact the contact of this org
	*/
	@Override
	public void setContact(java.lang.String contact) {
		_org.setContact(contact);
	}

	/**
	* Returns the email address of this org.
	*
	* @return the email address of this org
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _org.getEmailAddress();
	}

	/**
	* Sets the email address of this org.
	*
	* @param emailAddress the email address of this org
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_org.setEmailAddress(emailAddress);
	}

	/**
	* Returns the description of this org.
	*
	* @return the description of this org
	*/
	@Override
	public java.lang.String getDescription() {
		return _org.getDescription();
	}

	/**
	* Sets the description of this org.
	*
	* @param description the description of this org
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_org.setDescription(description);
	}

	/**
	* Returns the keywords of this org.
	*
	* @return the keywords of this org
	*/
	@Override
	public java.lang.String getKeywords() {
		return _org.getKeywords();
	}

	/**
	* Sets the keywords of this org.
	*
	* @param keywords the keywords of this org
	*/
	@Override
	public void setKeywords(java.lang.String keywords) {
		_org.setKeywords(keywords);
	}

	/**
	* Returns the image u r l of this org.
	*
	* @return the image u r l of this org
	*/
	@Override
	public java.lang.String getImageURL() {
		return _org.getImageURL();
	}

	/**
	* Sets the image u r l of this org.
	*
	* @param imageURL the image u r l of this org
	*/
	@Override
	public void setImageURL(java.lang.String imageURL) {
		_org.setImageURL(imageURL);
	}

	@Override
	public boolean isNew() {
		return _org.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_org.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _org.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_org.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _org.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _org.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_org.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _org.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_org.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_org.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_org.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrgWrapper((Org)_org.clone());
	}

	@Override
	public int compareTo(dinet.orgsetup62.model.Org org) {
		return _org.compareTo(org);
	}

	@Override
	public int hashCode() {
		return _org.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<dinet.orgsetup62.model.Org> toCacheModel() {
		return _org.toCacheModel();
	}

	@Override
	public dinet.orgsetup62.model.Org toEscapedModel() {
		return new OrgWrapper(_org.toEscapedModel());
	}

	@Override
	public dinet.orgsetup62.model.Org toUnescapedModel() {
		return new OrgWrapper(_org.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _org.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _org.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_org.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrgWrapper)) {
			return false;
		}

		OrgWrapper orgWrapper = (OrgWrapper)obj;

		if (Validator.equals(_org, orgWrapper._org)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Org getWrappedOrg() {
		return _org;
	}

	@Override
	public Org getWrappedModel() {
		return _org;
	}

	@Override
	public void resetOriginalValues() {
		_org.resetOriginalValues();
	}

	private Org _org;
}