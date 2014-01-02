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

import dinet.orgsetup62.model.Ceg;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Ceg in entity cache.
 *
 * @author gyengelaszlo
 * @see Ceg
 * @generated
 */
public class CegCacheModel implements CacheModel<Ceg>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{cegId=");
		sb.append(cegId);
		sb.append(", azon_r=");
		sb.append(azon_r);
		sb.append(", subAzon_r=");
		sb.append(subAzon_r);
		sb.append(", category_r=");
		sb.append(category_r);
		sb.append(", orgname_r=");
		sb.append(orgname_r);
		sb.append(", azon_u=");
		sb.append(azon_u);
		sb.append(", subAzon_u=");
		sb.append(subAzon_u);
		sb.append(", liferayOrgId=");
		sb.append(liferayOrgId);
		sb.append(", orgname=");
		sb.append(orgname);
		sb.append(", logo=");
		sb.append(logo);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", category=");
		sb.append(category);
		sb.append(", postalcode=");
		sb.append(postalcode);
		sb.append(", city=");
		sb.append(city);
		sb.append(", street=");
		sb.append(street);
		sb.append(", contact=");
		sb.append(contact);
		sb.append(", web=");
		sb.append(web);
		sb.append(", description=");
		sb.append(description);
		sb.append(", htmldescription=");
		sb.append(htmldescription);
		sb.append(", keywords=");
		sb.append(keywords);
		sb.append(", pageURL=");
		sb.append(pageURL);
		sb.append(", pagename=");
		sb.append(pagename);
		sb.append(", date=");
		sb.append(date);
		sb.append(", pageURLAzon=");
		sb.append(pageURLAzon);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Ceg toEntityModel() {
		CegImpl cegImpl = new CegImpl();

		cegImpl.setCegId(cegId);
		cegImpl.setAzon_r(azon_r);
		cegImpl.setSubAzon_r(subAzon_r);

		if (category_r == null) {
			cegImpl.setCategory_r(StringPool.BLANK);
		}
		else {
			cegImpl.setCategory_r(category_r);
		}

		if (orgname_r == null) {
			cegImpl.setOrgname_r(StringPool.BLANK);
		}
		else {
			cegImpl.setOrgname_r(orgname_r);
		}

		cegImpl.setAzon_u(azon_u);
		cegImpl.setSubAzon_u(subAzon_u);
		cegImpl.setLiferayOrgId(liferayOrgId);

		if (orgname == null) {
			cegImpl.setOrgname(StringPool.BLANK);
		}
		else {
			cegImpl.setOrgname(orgname);
		}

		if (logo == null) {
			cegImpl.setLogo(StringPool.BLANK);
		}
		else {
			cegImpl.setLogo(logo);
		}

		cegImpl.setCategoryId(categoryId);

		if (category == null) {
			cegImpl.setCategory(StringPool.BLANK);
		}
		else {
			cegImpl.setCategory(category);
		}

		if (postalcode == null) {
			cegImpl.setPostalcode(StringPool.BLANK);
		}
		else {
			cegImpl.setPostalcode(postalcode);
		}

		if (city == null) {
			cegImpl.setCity(StringPool.BLANK);
		}
		else {
			cegImpl.setCity(city);
		}

		if (street == null) {
			cegImpl.setStreet(StringPool.BLANK);
		}
		else {
			cegImpl.setStreet(street);
		}

		if (contact == null) {
			cegImpl.setContact(StringPool.BLANK);
		}
		else {
			cegImpl.setContact(contact);
		}

		if (web == null) {
			cegImpl.setWeb(StringPool.BLANK);
		}
		else {
			cegImpl.setWeb(web);
		}

		if (description == null) {
			cegImpl.setDescription(StringPool.BLANK);
		}
		else {
			cegImpl.setDescription(description);
		}

		if (htmldescription == null) {
			cegImpl.setHtmldescription(StringPool.BLANK);
		}
		else {
			cegImpl.setHtmldescription(htmldescription);
		}

		if (keywords == null) {
			cegImpl.setKeywords(StringPool.BLANK);
		}
		else {
			cegImpl.setKeywords(keywords);
		}

		if (pageURL == null) {
			cegImpl.setPageURL(StringPool.BLANK);
		}
		else {
			cegImpl.setPageURL(pageURL);
		}

		if (pagename == null) {
			cegImpl.setPagename(StringPool.BLANK);
		}
		else {
			cegImpl.setPagename(pagename);
		}

		if (date == Long.MIN_VALUE) {
			cegImpl.setDate(null);
		}
		else {
			cegImpl.setDate(new Date(date));
		}

		if (pageURLAzon == null) {
			cegImpl.setPageURLAzon(StringPool.BLANK);
		}
		else {
			cegImpl.setPageURLAzon(pageURLAzon);
		}

		cegImpl.resetOriginalValues();

		return cegImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		cegId = objectInput.readLong();
		azon_r = objectInput.readLong();
		subAzon_r = objectInput.readLong();
		category_r = objectInput.readUTF();
		orgname_r = objectInput.readUTF();
		azon_u = objectInput.readLong();
		subAzon_u = objectInput.readLong();
		liferayOrgId = objectInput.readLong();
		orgname = objectInput.readUTF();
		logo = objectInput.readUTF();
		categoryId = objectInput.readLong();
		category = objectInput.readUTF();
		postalcode = objectInput.readUTF();
		city = objectInput.readUTF();
		street = objectInput.readUTF();
		contact = objectInput.readUTF();
		web = objectInput.readUTF();
		description = objectInput.readUTF();
		htmldescription = objectInput.readUTF();
		keywords = objectInput.readUTF();
		pageURL = objectInput.readUTF();
		pagename = objectInput.readUTF();
		date = objectInput.readLong();
		pageURLAzon = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(cegId);
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

		objectOutput.writeLong(azon_u);
		objectOutput.writeLong(subAzon_u);
		objectOutput.writeLong(liferayOrgId);

		if (orgname == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(orgname);
		}

		if (logo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(logo);
		}

		objectOutput.writeLong(categoryId);

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (postalcode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postalcode);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (street == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(street);
		}

		if (contact == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contact);
		}

		if (web == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(web);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (htmldescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(htmldescription);
		}

		if (keywords == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(keywords);
		}

		if (pageURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pageURL);
		}

		if (pagename == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pagename);
		}

		objectOutput.writeLong(date);

		if (pageURLAzon == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pageURLAzon);
		}
	}

	public long cegId;
	public long azon_r;
	public long subAzon_r;
	public String category_r;
	public String orgname_r;
	public long azon_u;
	public long subAzon_u;
	public long liferayOrgId;
	public String orgname;
	public String logo;
	public long categoryId;
	public String category;
	public String postalcode;
	public String city;
	public String street;
	public String contact;
	public String web;
	public String description;
	public String htmldescription;
	public String keywords;
	public String pageURL;
	public String pagename;
	public long date;
	public String pageURLAzon;
}