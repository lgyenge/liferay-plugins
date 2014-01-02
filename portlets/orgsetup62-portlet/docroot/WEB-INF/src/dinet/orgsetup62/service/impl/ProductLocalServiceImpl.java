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

package dinet.orgsetup62.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import dinet.orgsetup62.model.Product;
import dinet.orgsetup62.service.base.ProductLocalServiceBaseImpl;

/**
 * The implementation of the product local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link dinet.orgsetup62.service.ProductLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gyengelaszlo
 * @see dinet.orgsetup62.service.base.ProductLocalServiceBaseImpl
 * @see dinet.orgsetup62.service.ProductLocalServiceUtil
 */
public class ProductLocalServiceImpl extends ProductLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link dinet.orgsetup62.service.ProductLocalServiceUtil} to access the product local service.
	 */
	public Product addProduct(Product newProduct, long userId)
			throws SystemException, PortalException {
			Product product = productPersistence.create(counterLocalService.increment(Product.class.getName()));
//			resourceLocalService.addResources(newProduct.getCompanyId(),
//					newProduct.getGroupId(), userId,
//					Product.class.getName(),
//					product.getPrimaryKey(), false, true, true); 
			product.setAzon(newProduct.getAzon());
			product.setName(newProduct.getName());
			product.setDescription(newProduct.getDescription());
			product.setServices(newProduct.getServices());
			product.setImage(newProduct.getImage());
			product.setDatasheet(newProduct.getDatasheet());
			product.setDistributor(newProduct.getDistributor());
			product.setCategory(newProduct.getCategory());
			product.setSubcategory(newProduct.getSubcategory());
			product.setPageURL(newProduct.getPageURL());
			product.setPagetitle(newProduct.getPagetitle());
			product.setStartingpage(newProduct.getStartingpage());
			product.setDate(newProduct.getDate());
			product.setLiferayOrgId(newProduct.getLiferayOrgId());
			product.setPageURLAzon(newProduct.getPageURLAzon());
			
			return productPersistence.update(product);
//			return productPersistence.update(product, false);
			
	}
			
	/*	public Product getProductByAzon(long azon)
	        throws SystemException {

	        Product product =
	            productPersistence.findByA(azon);
	        return product;
	    }
	*/	
		public List<Product> getAllProductByPageURLAzon(String urlazon)
		        throws SystemException {

		        List<Product> products =
		            productPersistence.findByPageURLAzon (urlazon);
		        return products;
		 }
		
		public List<Product> getAllProducts()
		        throws SystemException {

		        List<Product> products =
		            productPersistence.findAll ();
		        return products;
		 }
	
	
}