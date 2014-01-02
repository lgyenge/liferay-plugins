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
public class ProductSoap implements Serializable {
	public static ProductSoap toSoapModel(Product model) {
		ProductSoap soapModel = new ProductSoap();

		soapModel.setAzon(model.getAzon());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setServices(model.getServices());
		soapModel.setImage(model.getImage());
		soapModel.setDatasheet(model.getDatasheet());
		soapModel.setDistributor(model.getDistributor());
		soapModel.setCategory(model.getCategory());
		soapModel.setSubcategory(model.getSubcategory());
		soapModel.setPageURL(model.getPageURL());
		soapModel.setPagetitle(model.getPagetitle());
		soapModel.setStartingpage(model.getStartingpage());
		soapModel.setDate(model.getDate());
		soapModel.setLiferayOrgId(model.getLiferayOrgId());
		soapModel.setPageURLAzon(model.getPageURLAzon());

		return soapModel;
	}

	public static ProductSoap[] toSoapModels(Product[] models) {
		ProductSoap[] soapModels = new ProductSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductSoap[][] toSoapModels(Product[][] models) {
		ProductSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductSoap[] toSoapModels(List<Product> models) {
		List<ProductSoap> soapModels = new ArrayList<ProductSoap>(models.size());

		for (Product model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductSoap[soapModels.size()]);
	}

	public ProductSoap() {
	}

	public long getPrimaryKey() {
		return _azon;
	}

	public void setPrimaryKey(long pk) {
		setAzon(pk);
	}

	public long getAzon() {
		return _azon;
	}

	public void setAzon(long azon) {
		_azon = azon;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getServices() {
		return _services;
	}

	public void setServices(String services) {
		_services = services;
	}

	public String getImage() {
		return _image;
	}

	public void setImage(String image) {
		_image = image;
	}

	public String getDatasheet() {
		return _datasheet;
	}

	public void setDatasheet(String datasheet) {
		_datasheet = datasheet;
	}

	public String getDistributor() {
		return _distributor;
	}

	public void setDistributor(String distributor) {
		_distributor = distributor;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getSubcategory() {
		return _subcategory;
	}

	public void setSubcategory(String subcategory) {
		_subcategory = subcategory;
	}

	public String getPageURL() {
		return _pageURL;
	}

	public void setPageURL(String pageURL) {
		_pageURL = pageURL;
	}

	public String getPagetitle() {
		return _pagetitle;
	}

	public void setPagetitle(String pagetitle) {
		_pagetitle = pagetitle;
	}

	public String getStartingpage() {
		return _startingpage;
	}

	public void setStartingpage(String startingpage) {
		_startingpage = startingpage;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public long getLiferayOrgId() {
		return _liferayOrgId;
	}

	public void setLiferayOrgId(long liferayOrgId) {
		_liferayOrgId = liferayOrgId;
	}

	public String getPageURLAzon() {
		return _pageURLAzon;
	}

	public void setPageURLAzon(String pageURLAzon) {
		_pageURLAzon = pageURLAzon;
	}

	private long _azon;
	private String _name;
	private String _description;
	private String _services;
	private String _image;
	private String _datasheet;
	private String _distributor;
	private String _category;
	private String _subcategory;
	private String _pageURL;
	private String _pagetitle;
	private String _startingpage;
	private Date _date;
	private long _liferayOrgId;
	private String _pageURLAzon;
}