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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import dinet.orgsetup62.model.Org;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Org in entity cache.
 *
 * @author gyengelaszlo
 * @see Org
 * @generated
 */
public class OrgCacheModel implements CacheModel<Org>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{orgID=");
		sb.append(orgID);
		sb.append(", origAzon=");
		sb.append(origAzon);
		sb.append(", azon_r=");
		sb.append(azon_r);
		sb.append(", subAzon_r=");
		sb.append(subAzon_r);
		sb.append(", category_r=");
		sb.append(category_r);
		sb.append(", orgname_r=");
		sb.append(orgname_r);
		sb.append(", city=");
		sb.append(city);
		sb.append(", address1=");
		sb.append(address1);
		sb.append(", postalCode=");
		sb.append(postalCode);
		sb.append(", webURL=");
		sb.append(webURL);
		sb.append(", contact=");
		sb.append(contact);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", description=");
		sb.append(description);
		sb.append(", keywords=");
		sb.append(keywords);
		sb.append(", imageURL=");
		sb.append(imageURL);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Org toEntityModel() {
		OrgImpl orgImpl = new OrgImpl();

		orgImpl.setOrgID(orgID);
		orgImpl.setOrigAzon(origAzon);
		orgImpl.setAzon_r(azon_r);
		orgImpl.setSubAzon_r(subAzon_r);

		if (category_r == null) {
			orgImpl.setCategory_r(StringPool.BLANK);
		}
		else {
			orgImpl.setCategory_r(category_r);
		}

		if (orgname_r == null) {
			orgImpl.setOrgname_r(StringPool.BLANK);
		}
		else {
			orgImpl.setOrgname_r(orgname_r);
		}

		if (city == null) {
			orgImpl.setCity(StringPool.BLANK);
		}
		else {
			orgImpl.setCity(city);
		}

		if (address1 == null) {
			orgImpl.setAddress1(StringPool.BLANK);
		}
		else {
			orgImpl.setAddress1(address1);
		}

		if (postalCode == null) {
			orgImpl.setPostalCode(StringPool.BLANK);
		}
		else {
			orgImpl.setPostalCode(postalCode);
		}

		if (webURL == null) {
			orgImpl.setWebURL(StringPool.BLANK);
		}
		else {
			orgImpl.setWebURL(webURL);
		}

		if (contact == null) {
			orgImpl.setContact(StringPool.BLANK);
		}
		else {
			orgImpl.setContact(contact);
		}

		if (emailAddress == null) {
			orgImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			orgImpl.setEmailAddress(emailAddress);
		}

		if (description == null) {
			orgImpl.setDescription(StringPool.BLANK);
		}
		else {
			orgImpl.setDescription(description);
		}

		if (keywords == null) {
			orgImpl.setKeywords(StringPool.BLANK);
		}
		else {
			orgImpl.setKeywords(keywords);
		}

		if (imageURL == null) {
			orgImpl.setImageURL(StringPool.BLANK);
		}
		else {
			orgImpl.setImageURL(imageURL);
		}

		orgImpl.resetOriginalValues();

		return orgImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		orgID = objectInput.readLong();
		origAzon = objectInput.readLong();
		azon_r = objectInput.readLong();
		subAzon_r = objectInput.readLong();
		category_r = objectInput.readUTF();
		orgname_r = objectInput.readUTF();
		city = objectInput.readUTF();
		address1 = objectInput.readUTF();
		postalCode = objectInput.readUTF();
		webURL = objectInput.readUTF();
		contact = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		description = objectInput.readUTF();
		keywords = objectInput.readUTF();
		imageURL = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(orgID);
		objectOutput.writeLong(origAzon);
		objectOutput.writeLong(azon_r);
		objectOutput.writeLong(subAzon_r);

		if (category_r == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category_r);
		}

		if (orgname_r == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(orgname_r);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (address1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address1);
		}

		if (postalCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postalCode);
		}

		if (webURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(webURL);
		}

		if (contact == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contact);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (keywords == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(keywords);
		}

		if (imageURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageURL);
		}
	}

	public long orgID;
	public long origAzon;
	public long azon_r;
	public long subAzon_r;
	public String category_r;
	public String orgname_r;
	public String city;
	public String address1;
	public String postalCode;
	public String webURL;
	public String contact;
	public String emailAddress;
	public String description;
	public String keywords;
	public String imageURL;
}