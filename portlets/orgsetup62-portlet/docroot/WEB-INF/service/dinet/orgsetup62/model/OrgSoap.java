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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gyengelaszlo
 * @generated
 */
public class OrgSoap implements Serializable {
	public static OrgSoap toSoapModel(Org model) {
		OrgSoap soapModel = new OrgSoap();

		soapModel.setOrgID(model.getOrgID());
		soapModel.setOrigAzon(model.getOrigAzon());
		soapModel.setAzon_r(model.getAzon_r());
		soapModel.setSubAzon_r(model.getSubAzon_r());
		soapModel.setCategory_r(model.getCategory_r());
		soapModel.setOrgname_r(model.getOrgname_r());
		soapModel.setCity(model.getCity());
		soapModel.setAddress1(model.getAddress1());
		soapModel.setPostalCode(model.getPostalCode());
		soapModel.setWebURL(model.getWebURL());
		soapModel.setContact(model.getContact());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setDescription(model.getDescription());
		soapModel.setKeywords(model.getKeywords());
		soapModel.setImageURL(model.getImageURL());

		return soapModel;
	}

	public static OrgSoap[] toSoapModels(Org[] models) {
		OrgSoap[] soapModels = new OrgSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrgSoap[][] toSoapModels(Org[][] models) {
		OrgSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrgSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrgSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrgSoap[] toSoapModels(List<Org> models) {
		List<OrgSoap> soapModels = new ArrayList<OrgSoap>(models.size());

		for (Org model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrgSoap[soapModels.size()]);
	}

	public OrgSoap() {
	}

	public long getPrimaryKey() {
		return _orgID;
	}

	public void setPrimaryKey(long pk) {
		setOrgID(pk);
	}

	public long getOrgID() {
		return _orgID;
	}

	public void setOrgID(long orgID) {
		_orgID = orgID;
	}

	public long getOrigAzon() {
		return _origAzon;
	}

	public void setOrigAzon(long origAzon) {
		_origAzon = origAzon;
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

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getAddress1() {
		return _address1;
	}

	public void setAddress1(String address1) {
		_address1 = address1;
	}

	public String getPostalCode() {
		return _postalCode;
	}

	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;
	}

	public String getWebURL() {
		return _webURL;
	}

	public void setWebURL(String webURL) {
		_webURL = webURL;
	}

	public String getContact() {
		return _contact;
	}

	public void setContact(String contact) {
		_contact = contact;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getKeywords() {
		return _keywords;
	}

	public void setKeywords(String keywords) {
		_keywords = keywords;
	}

	public String getImageURL() {
		return _imageURL;
	}

	public void setImageURL(String imageURL) {
		_imageURL = imageURL;
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
}