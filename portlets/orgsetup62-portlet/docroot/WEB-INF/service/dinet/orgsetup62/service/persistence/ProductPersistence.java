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

package dinet.orgsetup62.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import dinet.orgsetup62.model.Product;

/**
 * The persistence interface for the product service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gyengelaszlo
 * @see ProductPersistenceImpl
 * @see ProductUtil
 * @generated
 */
public interface ProductPersistence extends BasePersistence<Product> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductUtil} to access the product persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the product where azon = &#63; or throws a {@link dinet.orgsetup62.NoSuchProductException} if it could not be found.
	*
	* @param azon the azon
	* @return the matching product
	* @throws dinet.orgsetup62.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product findByA(long azon)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchProductException;

	/**
	* Returns the product where azon = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param azon the azon
	* @return the matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product fetchByA(long azon)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product where azon = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param azon the azon
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product fetchByA(long azon,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the product where azon = &#63; from the database.
	*
	* @param azon the azon
	* @return the product that was removed
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product removeByA(long azon)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchProductException;

	/**
	* Returns the number of products where azon = &#63;.
	*
	* @param azon the azon
	* @return the number of matching products
	* @throws SystemException if a system exception occurred
	*/
	public int countByA(long azon)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the products where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @return the matching products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Product> findByLiferayOrgId(
		long liferayOrgId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the products where liferayOrgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param liferayOrgId the liferay org ID
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @return the range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Product> findByLiferayOrgId(
		long liferayOrgId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the products where liferayOrgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param liferayOrgId the liferay org ID
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Product> findByLiferayOrgId(
		long liferayOrgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first product in the ordered set where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product
	* @throws dinet.orgsetup62.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product findByLiferayOrgId_First(
		long liferayOrgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchProductException;

	/**
	* Returns the first product in the ordered set where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product fetchByLiferayOrgId_First(
		long liferayOrgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last product in the ordered set where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product
	* @throws dinet.orgsetup62.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product findByLiferayOrgId_Last(
		long liferayOrgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchProductException;

	/**
	* Returns the last product in the ordered set where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product fetchByLiferayOrgId_Last(
		long liferayOrgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the products before and after the current product in the ordered set where liferayOrgId = &#63;.
	*
	* @param azon the primary key of the current product
	* @param liferayOrgId the liferay org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next product
	* @throws dinet.orgsetup62.NoSuchProductException if a product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product[] findByLiferayOrgId_PrevAndNext(
		long azon, long liferayOrgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchProductException;

	/**
	* Removes all the products where liferayOrgId = &#63; from the database.
	*
	* @param liferayOrgId the liferay org ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLiferayOrgId(long liferayOrgId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of products where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @return the number of matching products
	* @throws SystemException if a system exception occurred
	*/
	public int countByLiferayOrgId(long liferayOrgId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the products where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @return the matching products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Product> findByPageURLAzon(
		java.lang.String pageURLAzon)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the products where pageURLAzon = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pageURLAzon the page u r l azon
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @return the range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Product> findByPageURLAzon(
		java.lang.String pageURLAzon, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the products where pageURLAzon = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pageURLAzon the page u r l azon
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Product> findByPageURLAzon(
		java.lang.String pageURLAzon, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first product in the ordered set where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product
	* @throws dinet.orgsetup62.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product findByPageURLAzon_First(
		java.lang.String pageURLAzon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchProductException;

	/**
	* Returns the first product in the ordered set where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product fetchByPageURLAzon_First(
		java.lang.String pageURLAzon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last product in the ordered set where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product
	* @throws dinet.orgsetup62.NoSuchProductException if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product findByPageURLAzon_Last(
		java.lang.String pageURLAzon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchProductException;

	/**
	* Returns the last product in the ordered set where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching product, or <code>null</code> if a matching product could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product fetchByPageURLAzon_Last(
		java.lang.String pageURLAzon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the products before and after the current product in the ordered set where pageURLAzon = &#63;.
	*
	* @param azon the primary key of the current product
	* @param pageURLAzon the page u r l azon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next product
	* @throws dinet.orgsetup62.NoSuchProductException if a product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product[] findByPageURLAzon_PrevAndNext(
		long azon, java.lang.String pageURLAzon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchProductException;

	/**
	* Removes all the products where pageURLAzon = &#63; from the database.
	*
	* @param pageURLAzon the page u r l azon
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPageURLAzon(java.lang.String pageURLAzon)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of products where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @return the number of matching products
	* @throws SystemException if a system exception occurred
	*/
	public int countByPageURLAzon(java.lang.String pageURLAzon)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the product in the entity cache if it is enabled.
	*
	* @param product the product
	*/
	public void cacheResult(dinet.orgsetup62.model.Product product);

	/**
	* Caches the products in the entity cache if it is enabled.
	*
	* @param products the products
	*/
	public void cacheResult(
		java.util.List<dinet.orgsetup62.model.Product> products);

	/**
	* Creates a new product with the primary key. Does not add the product to the database.
	*
	* @param azon the primary key for the new product
	* @return the new product
	*/
	public dinet.orgsetup62.model.Product create(long azon);

	/**
	* Removes the product with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param azon the primary key of the product
	* @return the product that was removed
	* @throws dinet.orgsetup62.NoSuchProductException if a product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product remove(long azon)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchProductException;

	public dinet.orgsetup62.model.Product updateImpl(
		dinet.orgsetup62.model.Product product)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the product with the primary key or throws a {@link dinet.orgsetup62.NoSuchProductException} if it could not be found.
	*
	* @param azon the primary key of the product
	* @return the product
	* @throws dinet.orgsetup62.NoSuchProductException if a product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product findByPrimaryKey(long azon)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchProductException;

	/**
	* Returns the product with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param azon the primary key of the product
	* @return the product, or <code>null</code> if a product with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Product fetchByPrimaryKey(long azon)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the products.
	*
	* @return the products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Product> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @return the range of products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Product> findAll(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the products.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.ProductModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of products
	* @param end the upper bound of the range of products (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of products
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Product> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the products from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of products.
	*
	* @return the number of products
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}