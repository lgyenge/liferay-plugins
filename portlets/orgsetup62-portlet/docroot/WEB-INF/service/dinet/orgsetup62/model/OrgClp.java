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

import dinet.orgsetup62.service.ClpSerializer;
import dinet.orgsetup62.service.OrgLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gyengelaszlo
 */
public class OrgClp extends BaseModelImpl<Org> implements Org {
	public OrgClp() {
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
	public long getPrimaryKey() {
		return _orgID;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOrgID(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _orgID;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getOrgID() {
		return _orgID;
	}

	@Override
	public void setOrgID(long orgID) {
		_orgID = orgID;

		if (_orgRemoteModel != null) {
			try {
				Class<?> clazz = _orgRemoteModel.getClass();

				Method method = clazz.getMethod("setOrgID", long.class);

				method.invoke(_orgRemoteModel, orgID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrigAzon() {
		return _origAzon;
	}

	@Override
	public void setOrigAzon(long origAzon) {
		_origAzon = origAzon;

		if (_orgRemoteModel != null) {
			try {
				Class<?> clazz = _orgRemoteModel.getClass();

				Method method = clazz.getMethod("setOrigAzon", long.class);

				method.invoke(_orgRemoteModel, origAzon);
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

		if (_orgRemoteModel != null) {
			try {
				Class<?> clazz = _orgRemoteModel.getClass();

				Method method = clazz.getMethod("setAzon_r", long.class);

				method.invoke(_orgRemoteModel, azon_r);
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

		if (_orgRemoteModel != null) {
			try {
				Class<?> clazz = _orgRemoteModel.getClass();

				Method method = clazz.getMethod("setSubAzon_r", long.class);

				method.invoke(_orgRemoteModel, subAzon_r);
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

		if (_orgRemoteModel != null) {
			try {
				Class<?> clazz = _orgRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory_r", String.class);

				method.invoke(_orgRemoteModel, category_r);
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

		if (_orgRemoteModel != null) {
			try {
				Class<?> clazz = _orgRemoteModel.getClass();

				Method method = clazz.getMethod("setOrgname_r", String.class);

				method.invoke(_orgRemoteModel, orgname_r);
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

		if (_orgRemoteModel != null) {
			try {
				Class<?> clazz = _orgRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_orgRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAddress1() {
		return _address1;
	}

	@Override
	public void setAddress1(String address1) {
		_address1 = address1;

		if (_orgRemoteModel != null) {
			try {
				Class<?> clazz = _orgRemoteModel.getClass();

				Method method = clazz.getMethod("setAddress1", String.class);

				method.invoke(_orgRemoteModel, address1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPostalCode() {
		return _postalCode;
	}

	@Override
	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;

		if (_orgRemoteModel != null) {
			try {
				Class<?> clazz = _orgRemoteModel.getClass();

				Method method = clazz.getMethod("setPostalCode", String.class);

				method.invoke(_orgRemoteModel, postalCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWebURL() {
		return _webURL;
	}

	@Override
	public void setWebURL(String webURL) {
		_webURL = webURL;

		if (_orgRemoteModel != null) {
			try {
				Class<?> clazz = _orgRemoteModel.getClass();

				Method method = clazz.getMethod("setWebURL", String.class);

				method.invoke(_orgRemoteModel, webURL);
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

		if (_orgRemoteModel != null) {
			try {
				Class<?> clazz = _orgRemoteModel.getClass();

				Method method = clazz.getMethod("setContact", String.class);

				method.invoke(_orgRemoteModel, contact);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;

		if (_orgRemoteModel != null) {
			try {
				Class<?> clazz = _orgRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_orgRemoteModel, emailAddress);
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

		if (_orgRemoteModel != null) {
			try {
				Class<?> clazz = _orgRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_orgRemoteModel, description);
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

		if (_orgRemoteModel != null) {
			try {
				Class<?> clazz = _orgRemoteModel.getClass();

				Method method = clazz.getMethod("setKeywords", String.class);

				method.invoke(_orgRemoteModel, keywords);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageURL() {
		return _imageURL;
	}

	@Override
	public void setImageURL(String imageURL) {
		_imageURL = imageURL;

		if (_orgRemoteModel != null) {
			try {
				Class<?> clazz = _orgRemoteModel.getClass();

				Method method = clazz.getMethod("setImageURL", String.class);

				method.invoke(_orgRemoteModel, imageURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getOrgRemoteModel() {
		return _orgRemoteModel;
	}

	public void setOrgRemoteModel(BaseModel<?> orgRemoteModel) {
		_orgRemoteModel = orgRemoteModel;
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

		Class<?> remoteModelClass = _orgRemoteModel.getClass();

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

		Object returnValue = method.invoke(_orgRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OrgLocalServiceUtil.addOrg(this);
		}
		else {
			OrgLocalServiceUtil.updateOrg(this);
		}
	}

	@Override
	public Org toEscapedModel() {
		return (Org)ProxyUtil.newProxyInstance(Org.class.getClassLoader(),
			new Class[] { Org.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OrgClp clone = new OrgClp();

		clone.setOrgID(getOrgID());
		clone.setOrigAzon(getOrigAzon());
		clone.setAzon_r(getAzon_r());
		clone.setSubAzon_r(getSubAzon_r());
		clone.setCategory_r(getCategory_r());
		clone.setOrgname_r(getOrgname_r());
		clone.setCity(getCity());
		clone.setAddress1(getAddress1());
		clone.setPostalCode(getPostalCode());
		clone.setWebURL(getWebURL());
		clone.setContact(getContact());
		clone.setEmailAddress(getEmailAddress());
		clone.setDescription(getDescription());
		clone.setKeywords(getKeywords());
		clone.setImageURL(getImageURL());

		return clone;
	}

	@Override
	public int compareTo(Org org) {
		long primaryKey = org.getPrimaryKey();

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

		if (!(obj instanceof OrgClp)) {
			return false;
		}

		OrgClp org = (OrgClp)obj;

		long primaryKey = org.getPrimaryKey();

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
		StringBundler sb = new StringBundler(31);

		sb.append("{orgID=");
		sb.append(getOrgID());
		sb.append(", origAzon=");
		sb.append(getOrigAzon());
		sb.append(", azon_r=");
		sb.append(getAzon_r());
		sb.append(", subAzon_r=");
		sb.append(getSubAzon_r());
		sb.append(", category_r=");
		sb.append(getCategory_r());
		sb.append(", orgname_r=");
		sb.append(getOrgname_r());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", address1=");
		sb.append(getAddress1());
		sb.append(", postalCode=");
		sb.append(getPostalCode());
		sb.append(", webURL=");
		sb.append(getWebURL());
		sb.append(", contact=");
		sb.append(getContact());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", keywords=");
		sb.append(getKeywords());
		sb.append(", imageURL=");
		sb.append(getImageURL());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("dinet.orgsetup62.model.Org");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>orgID</column-name><column-value><![CDATA[");
		sb.append(getOrgID());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>origAzon</column-name><column-value><![CDATA[");
		sb.append(getOrigAzon());
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
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>address1</column-name><column-value><![CDATA[");
		sb.append(getAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postalCode</column-name><column-value><![CDATA[");
		sb.append(getPostalCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>webURL</column-name><column-value><![CDATA[");
		sb.append(getWebURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contact</column-name><column-value><![CDATA[");
		sb.append(getContact());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>keywords</column-name><column-value><![CDATA[");
		sb.append(getKeywords());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageURL</column-name><column-value><![CDATA[");
		sb.append(getImageURL());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _orgID;
	private long _origAzon;
	private long _azon_r;
	private long _subAzon_r;
	private String _category_r;
	private String _orgname_r;
	private String _city;
	private String _address1;
	private String _postalCode;
	private String _webURL;
	private String _contact;
	private String _emailAddress;
	private String _description;
	private String _keywords;
	private String _imageURL;
	private BaseModel<?> _orgRemoteModel;
}