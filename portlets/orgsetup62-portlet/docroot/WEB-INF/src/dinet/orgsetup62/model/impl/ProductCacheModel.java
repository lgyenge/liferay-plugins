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

import dinet.orgsetup62.model.Product;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Product in entity cache.
 *
 * @author gyengelaszlo
 * @see Product
 * @generated
 */
public class ProductCacheModel implements CacheModel<Product>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{azon=");
		sb.append(azon);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", services=");
		sb.append(services);
		sb.append(", image=");
		sb.append(image);
		sb.append(", datasheet=");
		sb.append(datasheet);
		sb.append(", distributor=");
		sb.append(distributor);
		sb.append(", category=");
		sb.append(category);
		sb.append(", subcategory=");
		sb.append(subcategory);
		sb.append(", pageURL=");
		sb.append(pageURL);
		sb.append(", pagetitle=");
		sb.append(pagetitle);
		sb.append(", startingpage=");
		sb.append(startingpage);
		sb.append(", date=");
		sb.append(date);
		sb.append(", liferayOrgId=");
		sb.append(liferayOrgId);
		sb.append(", pageURLAzon=");
		sb.append(pageURLAzon);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Product toEntityModel() {
		ProductImpl productImpl = new ProductImpl();

		productImpl.setAzon(azon);

		if (name == null) {
			productImpl.setName(StringPool.BLANK);
		}
		else {
			productImpl.setName(name);
		}

		if (description == null) {
			productImpl.setDescription(StringPool.BLANK);
		}
		else {
			productImpl.setDescription(description);
		}

		if (services == null) {
			productImpl.setServices(StringPool.BLANK);
		}
		else {
			productImpl.setServices(services);
		}

		if (image == null) {
			productImpl.setImage(StringPool.BLANK);
		}
		else {
			productImpl.setImage(image);
		}

		if (datasheet == null) {
			productImpl.setDatasheet(StringPool.BLANK);
		}
		else {
			productImpl.setDatasheet(datasheet);
		}

		if (distributor == null) {
			productImpl.setDistributor(StringPool.BLANK);
		}
		else {
			productImpl.setDistributor(distributor);
		}

		if (category == null) {
			productImpl.setCategory(StringPool.BLANK);
		}
		else {
			productImpl.setCategory(category);
		}

		if (subcategory == null) {
			productImpl.setSubcategory(StringPool.BLANK);
		}
		else {
			productImpl.setSubcategory(subcategory);
		}

		if (pageURL == null) {
			productImpl.setPageURL(StringPool.BLANK);
		}
		else {
			productImpl.setPageURL(pageURL);
		}

		if (pagetitle == null) {
			productImpl.setPagetitle(StringPool.BLANK);
		}
		else {
			productImpl.setPagetitle(pagetitle);
		}

		if (startingpage == null) {
			productImpl.setStartingpage(StringPool.BLANK);
		}
		else {
			productImpl.setStartingpage(startingpage);
		}

		if (date == Long.MIN_VALUE) {
			productImpl.setDate(null);
		}
		else {
			productImpl.setDate(new Date(date));
		}

		productImpl.setLiferayOrgId(liferayOrgId);

		if (pageURLAzon == null) {
			productImpl.setPageURLAzon(StringPool.BLANK);
		}
		else {
			productImpl.setPageURLAzon(pageURLAzon);
		}

		productImpl.resetOriginalValues();

		return productImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		azon = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		services = objectInput.readUTF();
		image = objectInput.readUTF();
		datasheet = objectInput.readUTF();
		distributor = objectInput.readUTF();
		category = objectInput.readUTF();
		subcategory = objectInput.readUTF();
		pageURL = objectInput.readUTF();
		pagetitle = objectInput.readUTF();
		startingpage = objectInput.readUTF();
		date = objectInput.readLong();
		liferayOrgId = objectInput.readLong();
		pageURLAzon = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(azon);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (services == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(services);
		}

		if (image == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(image);
		}

		if (datasheet == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(datasheet);
		}

		if (distributor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(distributor);
		}

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (subcategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subcategory);
		}

		if (pageURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pageURL);
		}

		if (pagetitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pagetitle);
		}

		if (startingpage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(startingpage);
		}

		objectOutput.writeLong(date);
		objectOutput.writeLong(liferayOrgId);

		if (pageURLAzon == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pageURLAzon);
		}
	}

	public long azon;
	public String name;
	public String description;
	public String services;
	public String image;
	public String datasheet;
	public String distributor;
	public String category;
	public String subcategory;
	public String pageURL;
	public String pagetitle;
	public String startingpage;
	public long date;
	public long liferayOrgId;
	public String pageURLAzon;
}