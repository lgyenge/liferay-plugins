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
import dinet.orgsetup62.service.ProductLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gyengelaszlo
 */
public class ProductClp extends BaseModelImpl<Product> implements Product {
	public ProductClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Product.class;
	}

	@Override
	public String getModelClassName() {
		return Product.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _azon;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAzon(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _azon;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("azon", getAzon());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("services", getServices());
		attributes.put("image", getImage());
		attributes.put("datasheet", getDatasheet());
		attributes.put("distributor", getDistributor());
		attributes.put("category", getCategory());
		attributes.put("subcategory", getSubcategory());
		attributes.put("pageURL", getPageURL());
		attributes.put("pagetitle", getPagetitle());
		attributes.put("startingpage", getStartingpage());
		attributes.put("date", getDate());
		attributes.put("liferayOrgId", getLiferayOrgId());
		attributes.put("pageURLAzon", getPageURLAzon());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long azon = (Long)attributes.get("azon");

		if (azon != null) {
			setAzon(azon);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String services = (String)attributes.get("services");

		if (services != null) {
			setServices(services);
		}

		String image = (String)attributes.get("image");

		if (image != null) {
			setImage(image);
		}

		String datasheet = (String)attributes.get("datasheet");

		if (datasheet != null) {
			setDatasheet(datasheet);
		}

		String distributor = (String)attributes.get("distributor");

		if (distributor != null) {
			setDistributor(distributor);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String subcategory = (String)attributes.get("subcategory");

		if (subcategory != null) {
			setSubcategory(subcategory);
		}

		String pageURL = (String)attributes.get("pageURL");

		if (pageURL != null) {
			setPageURL(pageURL);
		}

		String pagetitle = (String)attributes.get("pagetitle");

		if (pagetitle != null) {
			setPagetitle(pagetitle);
		}

		String startingpage = (String)attributes.get("startingpage");

		if (startingpage != null) {
			setStartingpage(startingpage);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		Long liferayOrgId = (Long)attributes.get("liferayOrgId");

		if (liferayOrgId != null) {
			setLiferayOrgId(liferayOrgId);
		}

		String pageURLAzon = (String)attributes.get("pageURLAzon");

		if (pageURLAzon != null) {
			setPageURLAzon(pageURLAzon);
		}
	}

	@Override
	public long getAzon() {
		return _azon;
	}

	@Override
	public void setAzon(long azon) {
		_azon = azon;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setAzon", long.class);

				method.invoke(_productRemoteModel, azon);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_productRemoteModel, name);
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

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_productRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getServices() {
		return _services;
	}

	@Override
	public void setServices(String services) {
		_services = services;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setServices", String.class);

				method.invoke(_productRemoteModel, services);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImage() {
		return _image;
	}

	@Override
	public void setImage(String image) {
		_image = image;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setImage", String.class);

				method.invoke(_productRemoteModel, image);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDatasheet() {
		return _datasheet;
	}

	@Override
	public void setDatasheet(String datasheet) {
		_datasheet = datasheet;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setDatasheet", String.class);

				method.invoke(_productRemoteModel, datasheet);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDistributor() {
		return _distributor;
	}

	@Override
	public void setDistributor(String distributor) {
		_distributor = distributor;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setDistributor", String.class);

				method.invoke(_productRemoteModel, distributor);
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

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_productRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSubcategory() {
		return _subcategory;
	}

	@Override
	public void setSubcategory(String subcategory) {
		_subcategory = subcategory;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setSubcategory", String.class);

				method.invoke(_productRemoteModel, subcategory);
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

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setPageURL", String.class);

				method.invoke(_productRemoteModel, pageURL);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPagetitle() {
		return _pagetitle;
	}

	@Override
	public void setPagetitle(String pagetitle) {
		_pagetitle = pagetitle;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setPagetitle", String.class);

				method.invoke(_productRemoteModel, pagetitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStartingpage() {
		return _startingpage;
	}

	@Override
	public void setStartingpage(String startingpage) {
		_startingpage = startingpage;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setStartingpage", String.class);

				method.invoke(_productRemoteModel, startingpage);
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

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setDate", Date.class);

				method.invoke(_productRemoteModel, date);
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

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setLiferayOrgId", long.class);

				method.invoke(_productRemoteModel, liferayOrgId);
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

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setPageURLAzon", String.class);

				method.invoke(_productRemoteModel, pageURLAzon);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProductRemoteModel() {
		return _productRemoteModel;
	}

	public void setProductRemoteModel(BaseModel<?> productRemoteModel) {
		_productRemoteModel = productRemoteModel;
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

		Class<?> remoteModelClass = _productRemoteModel.getClass();

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

		Object returnValue = method.invoke(_productRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProductLocalServiceUtil.addProduct(this);
		}
		else {
			ProductLocalServiceUtil.updateProduct(this);
		}
	}

	@Override
	public Product toEscapedModel() {
		return (Product)ProxyUtil.newProxyInstance(Product.class.getClassLoader(),
			new Class[] { Product.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProductClp clone = new ProductClp();

		clone.setAzon(getAzon());
		clone.setName(getName());
		clone.setDescription(getDescription());
		clone.setServices(getServices());
		clone.setImage(getImage());
		clone.setDatasheet(getDatasheet());
		clone.setDistributor(getDistributor());
		clone.setCategory(getCategory());
		clone.setSubcategory(getSubcategory());
		clone.setPageURL(getPageURL());
		clone.setPagetitle(getPagetitle());
		clone.setStartingpage(getStartingpage());
		clone.setDate(getDate());
		clone.setLiferayOrgId(getLiferayOrgId());
		clone.setPageURLAzon(getPageURLAzon());

		return clone;
	}

	@Override
	public int compareTo(Product product) {
		long primaryKey = product.getPrimaryKey();

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

		if (!(obj instanceof ProductClp)) {
			return false;
		}

		ProductClp product = (ProductClp)obj;

		long primaryKey = product.getPrimaryKey();

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

		sb.append("{azon=");
		sb.append(getAzon());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", services=");
		sb.append(getServices());
		sb.append(", image=");
		sb.append(getImage());
		sb.append(", datasheet=");
		sb.append(getDatasheet());
		sb.append(", distributor=");
		sb.append(getDistributor());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", subcategory=");
		sb.append(getSubcategory());
		sb.append(", pageURL=");
		sb.append(getPageURL());
		sb.append(", pagetitle=");
		sb.append(getPagetitle());
		sb.append(", startingpage=");
		sb.append(getStartingpage());
		sb.append(", date=");
		sb.append(getDate());
		sb.append(", liferayOrgId=");
		sb.append(getLiferayOrgId());
		sb.append(", pageURLAzon=");
		sb.append(getPageURLAzon());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("dinet.orgsetup62.model.Product");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>azon</column-name><column-value><![CDATA[");
		sb.append(getAzon());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>services</column-name><column-value><![CDATA[");
		sb.append(getServices());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>image</column-name><column-value><![CDATA[");
		sb.append(getImage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>datasheet</column-name><column-value><![CDATA[");
		sb.append(getDatasheet());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>distributor</column-name><column-value><![CDATA[");
		sb.append(getDistributor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subcategory</column-name><column-value><![CDATA[");
		sb.append(getSubcategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pageURL</column-name><column-value><![CDATA[");
		sb.append(getPageURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pagetitle</column-name><column-value><![CDATA[");
		sb.append(getPagetitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startingpage</column-name><column-value><![CDATA[");
		sb.append(getStartingpage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>date</column-name><column-value><![CDATA[");
		sb.append(getDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>liferayOrgId</column-name><column-value><![CDATA[");
		sb.append(getLiferayOrgId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pageURLAzon</column-name><column-value><![CDATA[");
		sb.append(getPageURLAzon());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _productRemoteModel;
}