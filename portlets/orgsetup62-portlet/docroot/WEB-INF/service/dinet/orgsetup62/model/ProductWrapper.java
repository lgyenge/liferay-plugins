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
 * This class is a wrapper for {@link Product}.
 * </p>
 *
 * @author gyengelaszlo
 * @see Product
 * @generated
 */
public class ProductWrapper implements Product, ModelWrapper<Product> {
	public ProductWrapper(Product product) {
		_product = product;
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

	/**
	* Returns the primary key of this product.
	*
	* @return the primary key of this product
	*/
	@Override
	public long getPrimaryKey() {
		return _product.getPrimaryKey();
	}

	/**
	* Sets the primary key of this product.
	*
	* @param primaryKey the primary key of this product
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_product.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the azon of this product.
	*
	* @return the azon of this product
	*/
	@Override
	public long getAzon() {
		return _product.getAzon();
	}

	/**
	* Sets the azon of this product.
	*
	* @param azon the azon of this product
	*/
	@Override
	public void setAzon(long azon) {
		_product.setAzon(azon);
	}

	/**
	* Returns the name of this product.
	*
	* @return the name of this product
	*/
	@Override
	public java.lang.String getName() {
		return _product.getName();
	}

	/**
	* Sets the name of this product.
	*
	* @param name the name of this product
	*/
	@Override
	public void setName(java.lang.String name) {
		_product.setName(name);
	}

	/**
	* Returns the description of this product.
	*
	* @return the description of this product
	*/
	@Override
	public java.lang.String getDescription() {
		return _product.getDescription();
	}

	/**
	* Sets the description of this product.
	*
	* @param description the description of this product
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_product.setDescription(description);
	}

	/**
	* Returns the services of this product.
	*
	* @return the services of this product
	*/
	@Override
	public java.lang.String getServices() {
		return _product.getServices();
	}

	/**
	* Sets the services of this product.
	*
	* @param services the services of this product
	*/
	@Override
	public void setServices(java.lang.String services) {
		_product.setServices(services);
	}

	/**
	* Returns the image of this product.
	*
	* @return the image of this product
	*/
	@Override
	public java.lang.String getImage() {
		return _product.getImage();
	}

	/**
	* Sets the image of this product.
	*
	* @param image the image of this product
	*/
	@Override
	public void setImage(java.lang.String image) {
		_product.setImage(image);
	}

	/**
	* Returns the datasheet of this product.
	*
	* @return the datasheet of this product
	*/
	@Override
	public java.lang.String getDatasheet() {
		return _product.getDatasheet();
	}

	/**
	* Sets the datasheet of this product.
	*
	* @param datasheet the datasheet of this product
	*/
	@Override
	public void setDatasheet(java.lang.String datasheet) {
		_product.setDatasheet(datasheet);
	}

	/**
	* Returns the distributor of this product.
	*
	* @return the distributor of this product
	*/
	@Override
	public java.lang.String getDistributor() {
		return _product.getDistributor();
	}

	/**
	* Sets the distributor of this product.
	*
	* @param distributor the distributor of this product
	*/
	@Override
	public void setDistributor(java.lang.String distributor) {
		_product.setDistributor(distributor);
	}

	/**
	* Returns the category of this product.
	*
	* @return the category of this product
	*/
	@Override
	public java.lang.String getCategory() {
		return _product.getCategory();
	}

	/**
	* Sets the category of this product.
	*
	* @param category the category of this product
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_product.setCategory(category);
	}

	/**
	* Returns the subcategory of this product.
	*
	* @return the subcategory of this product
	*/
	@Override
	public java.lang.String getSubcategory() {
		return _product.getSubcategory();
	}

	/**
	* Sets the subcategory of this product.
	*
	* @param subcategory the subcategory of this product
	*/
	@Override
	public void setSubcategory(java.lang.String subcategory) {
		_product.setSubcategory(subcategory);
	}

	/**
	* Returns the page u r l of this product.
	*
	* @return the page u r l of this product
	*/
	@Override
	public java.lang.String getPageURL() {
		return _product.getPageURL();
	}

	/**
	* Sets the page u r l of this product.
	*
	* @param pageURL the page u r l of this product
	*/
	@Override
	public void setPageURL(java.lang.String pageURL) {
		_product.setPageURL(pageURL);
	}

	/**
	* Returns the pagetitle of this product.
	*
	* @return the pagetitle of this product
	*/
	@Override
	public java.lang.String getPagetitle() {
		return _product.getPagetitle();
	}

	/**
	* Sets the pagetitle of this product.
	*
	* @param pagetitle the pagetitle of this product
	*/
	@Override
	public void setPagetitle(java.lang.String pagetitle) {
		_product.setPagetitle(pagetitle);
	}

	/**
	* Returns the startingpage of this product.
	*
	* @return the startingpage of this product
	*/
	@Override
	public java.lang.String getStartingpage() {
		return _product.getStartingpage();
	}

	/**
	* Sets the startingpage of this product.
	*
	* @param startingpage the startingpage of this product
	*/
	@Override
	public void setStartingpage(java.lang.String startingpage) {
		_product.setStartingpage(startingpage);
	}

	/**
	* Returns the date of this product.
	*
	* @return the date of this product
	*/
	@Override
	public java.util.Date getDate() {
		return _product.getDate();
	}

	/**
	* Sets the date of this product.
	*
	* @param date the date of this product
	*/
	@Override
	public void setDate(java.util.Date date) {
		_product.setDate(date);
	}

	/**
	* Returns the liferay org ID of this product.
	*
	* @return the liferay org ID of this product
	*/
	@Override
	public long getLiferayOrgId() {
		return _product.getLiferayOrgId();
	}

	/**
	* Sets the liferay org ID of this product.
	*
	* @param liferayOrgId the liferay org ID of this product
	*/
	@Override
	public void setLiferayOrgId(long liferayOrgId) {
		_product.setLiferayOrgId(liferayOrgId);
	}

	/**
	* Returns the page u r l azon of this product.
	*
	* @return the page u r l azon of this product
	*/
	@Override
	public java.lang.String getPageURLAzon() {
		return _product.getPageURLAzon();
	}

	/**
	* Sets the page u r l azon of this product.
	*
	* @param pageURLAzon the page u r l azon of this product
	*/
	@Override
	public void setPageURLAzon(java.lang.String pageURLAzon) {
		_product.setPageURLAzon(pageURLAzon);
	}

	@Override
	public boolean isNew() {
		return _product.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_product.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _product.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_product.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _product.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _product.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_product.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _product.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_product.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_product.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_product.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProductWrapper((Product)_product.clone());
	}

	@Override
	public int compareTo(dinet.orgsetup62.model.Product product) {
		return _product.compareTo(product);
	}

	@Override
	public int hashCode() {
		return _product.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<dinet.orgsetup62.model.Product> toCacheModel() {
		return _product.toCacheModel();
	}

	@Override
	public dinet.orgsetup62.model.Product toEscapedModel() {
		return new ProductWrapper(_product.toEscapedModel());
	}

	@Override
	public dinet.orgsetup62.model.Product toUnescapedModel() {
		return new ProductWrapper(_product.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _product.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _product.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_product.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductWrapper)) {
			return false;
		}

		ProductWrapper productWrapper = (ProductWrapper)obj;

		if (Validator.equals(_product, productWrapper._product)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Product getWrappedProduct() {
		return _product;
	}

	@Override
	public Product getWrappedModel() {
		return _product;
	}

	@Override
	public void resetOriginalValues() {
		_product.resetOriginalValues();
	}

	private Product _product;
}