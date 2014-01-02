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

import dinet.orgsetup62.model.Org;

/**
 * The persistence interface for the org service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gyengelaszlo
 * @see OrgPersistenceImpl
 * @see OrgUtil
 * @generated
 */
public interface OrgPersistence extends BasePersistence<Org> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link OrgUtil} to access the org persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the org where azon_r = &#63; and subAzon_r = &#63; or throws a {@link dinet.orgsetup62.NoSuchOrgException} if it could not be found.
	*
	* @param azon_r the azon_r
	* @param subAzon_r the sub azon_r
	* @return the matching org
	* @throws dinet.orgsetup62.NoSuchOrgException if a matching org could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Org findByA_SA(long azon_r, long subAzon_r)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchOrgException;

	/**
	* Returns the org where azon_r = &#63; and subAzon_r = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param azon_r the azon_r
	* @param subAzon_r the sub azon_r
	* @return the matching org, or <code>null</code> if a matching org could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Org fetchByA_SA(long azon_r, long subAzon_r)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the org where azon_r = &#63; and subAzon_r = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param azon_r the azon_r
	* @param subAzon_r the sub azon_r
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching org, or <code>null</code> if a matching org could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Org fetchByA_SA(long azon_r, long subAzon_r,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the org where azon_r = &#63; and subAzon_r = &#63; from the database.
	*
	* @param azon_r the azon_r
	* @param subAzon_r the sub azon_r
	* @return the org that was removed
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Org removeByA_SA(long azon_r, long subAzon_r)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchOrgException;

	/**
	* Returns the number of orgs where azon_r = &#63; and subAzon_r = &#63;.
	*
	* @param azon_r the azon_r
	* @param subAzon_r the sub azon_r
	* @return the number of matching orgs
	* @throws SystemException if a system exception occurred
	*/
	public int countByA_SA(long azon_r, long subAzon_r)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the org in the entity cache if it is enabled.
	*
	* @param org the org
	*/
	public void cacheResult(dinet.orgsetup62.model.Org org);

	/**
	* Caches the orgs in the entity cache if it is enabled.
	*
	* @param orgs the orgs
	*/
	public void cacheResult(java.util.List<dinet.orgsetup62.model.Org> orgs);

	/**
	* Creates a new org with the primary key. Does not add the org to the database.
	*
	* @param orgID the primary key for the new org
	* @return the new org
	*/
	public dinet.orgsetup62.model.Org create(long orgID);

	/**
	* Removes the org with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orgID the primary key of the org
	* @return the org that was removed
	* @throws dinet.orgsetup62.NoSuchOrgException if a org with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Org remove(long orgID)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchOrgException;

	public dinet.orgsetup62.model.Org updateImpl(dinet.orgsetup62.model.Org org)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the org with the primary key or throws a {@link dinet.orgsetup62.NoSuchOrgException} if it could not be found.
	*
	* @param orgID the primary key of the org
	* @return the org
	* @throws dinet.orgsetup62.NoSuchOrgException if a org with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Org findByPrimaryKey(long orgID)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchOrgException;

	/**
	* Returns the org with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param orgID the primary key of the org
	* @return the org, or <code>null</code> if a org with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Org fetchByPrimaryKey(long orgID)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the orgs.
	*
	* @return the orgs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Org> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the orgs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.OrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orgs
	* @param end the upper bound of the range of orgs (not inclusive)
	* @return the range of orgs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Org> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the orgs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.OrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of orgs
	* @param end the upper bound of the range of orgs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of orgs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Org> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the orgs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of orgs.
	*
	* @return the number of orgs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}