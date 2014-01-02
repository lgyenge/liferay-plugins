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

import dinet.orgsetup62.model.Ceg;

/**
 * The persistence interface for the ceg service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gyengelaszlo
 * @see CegPersistenceImpl
 * @see CegUtil
 * @generated
 */
public interface CegPersistence extends BasePersistence<Ceg> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CegUtil} to access the ceg persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the cegs where azon_u = &#63;.
	*
	* @param azon_u the azon_u
	* @return the matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Ceg> findByA(long azon_u)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cegs where azon_u = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.CegModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param azon_u the azon_u
	* @param start the lower bound of the range of cegs
	* @param end the upper bound of the range of cegs (not inclusive)
	* @return the range of matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Ceg> findByA(long azon_u,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cegs where azon_u = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.CegModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param azon_u the azon_u
	* @param start the lower bound of the range of cegs
	* @param end the upper bound of the range of cegs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Ceg> findByA(long azon_u,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ceg in the ordered set where azon_u = &#63;.
	*
	* @param azon_u the azon_u
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg findByA_First(long azon_u,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException;

	/**
	* Returns the first ceg in the ordered set where azon_u = &#63;.
	*
	* @param azon_u the azon_u
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ceg, or <code>null</code> if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg fetchByA_First(long azon_u,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ceg in the ordered set where azon_u = &#63;.
	*
	* @param azon_u the azon_u
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg findByA_Last(long azon_u,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException;

	/**
	* Returns the last ceg in the ordered set where azon_u = &#63;.
	*
	* @param azon_u the azon_u
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ceg, or <code>null</code> if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg fetchByA_Last(long azon_u,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cegs before and after the current ceg in the ordered set where azon_u = &#63;.
	*
	* @param cegId the primary key of the current ceg
	* @param azon_u the azon_u
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a ceg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg[] findByA_PrevAndNext(long cegId,
		long azon_u,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException;

	/**
	* Removes all the cegs where azon_u = &#63; from the database.
	*
	* @param azon_u the azon_u
	* @throws SystemException if a system exception occurred
	*/
	public void removeByA(long azon_u)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cegs where azon_u = &#63;.
	*
	* @param azon_u the azon_u
	* @return the number of matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public int countByA(long azon_u)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cegs where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @return the matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Ceg> findByLiferayOrgId(
		long liferayOrgId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cegs where liferayOrgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.CegModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param liferayOrgId the liferay org ID
	* @param start the lower bound of the range of cegs
	* @param end the upper bound of the range of cegs (not inclusive)
	* @return the range of matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Ceg> findByLiferayOrgId(
		long liferayOrgId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cegs where liferayOrgId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.CegModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param liferayOrgId the liferay org ID
	* @param start the lower bound of the range of cegs
	* @param end the upper bound of the range of cegs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Ceg> findByLiferayOrgId(
		long liferayOrgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ceg in the ordered set where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg findByLiferayOrgId_First(
		long liferayOrgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException;

	/**
	* Returns the first ceg in the ordered set where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ceg, or <code>null</code> if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg fetchByLiferayOrgId_First(
		long liferayOrgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ceg in the ordered set where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg findByLiferayOrgId_Last(
		long liferayOrgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException;

	/**
	* Returns the last ceg in the ordered set where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ceg, or <code>null</code> if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg fetchByLiferayOrgId_Last(
		long liferayOrgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cegs before and after the current ceg in the ordered set where liferayOrgId = &#63;.
	*
	* @param cegId the primary key of the current ceg
	* @param liferayOrgId the liferay org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a ceg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg[] findByLiferayOrgId_PrevAndNext(
		long cegId, long liferayOrgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException;

	/**
	* Removes all the cegs where liferayOrgId = &#63; from the database.
	*
	* @param liferayOrgId the liferay org ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByLiferayOrgId(long liferayOrgId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cegs where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @return the number of matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public int countByLiferayOrgId(long liferayOrgId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cegs where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @return the matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Ceg> findByPageURLAzon(
		java.lang.String pageURLAzon)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cegs where pageURLAzon = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.CegModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pageURLAzon the page u r l azon
	* @param start the lower bound of the range of cegs
	* @param end the upper bound of the range of cegs (not inclusive)
	* @return the range of matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Ceg> findByPageURLAzon(
		java.lang.String pageURLAzon, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cegs where pageURLAzon = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.CegModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param pageURLAzon the page u r l azon
	* @param start the lower bound of the range of cegs
	* @param end the upper bound of the range of cegs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Ceg> findByPageURLAzon(
		java.lang.String pageURLAzon, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ceg in the ordered set where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg findByPageURLAzon_First(
		java.lang.String pageURLAzon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException;

	/**
	* Returns the first ceg in the ordered set where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ceg, or <code>null</code> if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg fetchByPageURLAzon_First(
		java.lang.String pageURLAzon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ceg in the ordered set where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg findByPageURLAzon_Last(
		java.lang.String pageURLAzon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException;

	/**
	* Returns the last ceg in the ordered set where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ceg, or <code>null</code> if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg fetchByPageURLAzon_Last(
		java.lang.String pageURLAzon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cegs before and after the current ceg in the ordered set where pageURLAzon = &#63;.
	*
	* @param cegId the primary key of the current ceg
	* @param pageURLAzon the page u r l azon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a ceg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg[] findByPageURLAzon_PrevAndNext(
		long cegId, java.lang.String pageURLAzon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException;

	/**
	* Removes all the cegs where pageURLAzon = &#63; from the database.
	*
	* @param pageURLAzon the page u r l azon
	* @throws SystemException if a system exception occurred
	*/
	public void removeByPageURLAzon(java.lang.String pageURLAzon)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cegs where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @return the number of matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public int countByPageURLAzon(java.lang.String pageURLAzon)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cegs where category = &#63;.
	*
	* @param category the category
	* @return the matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Ceg> findByCategoryName(
		java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cegs where category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.CegModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param category the category
	* @param start the lower bound of the range of cegs
	* @param end the upper bound of the range of cegs (not inclusive)
	* @return the range of matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Ceg> findByCategoryName(
		java.lang.String category, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cegs where category = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.CegModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param category the category
	* @param start the lower bound of the range of cegs
	* @param end the upper bound of the range of cegs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Ceg> findByCategoryName(
		java.lang.String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first ceg in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg findByCategoryName_First(
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException;

	/**
	* Returns the first ceg in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ceg, or <code>null</code> if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg fetchByCategoryName_First(
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last ceg in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg findByCategoryName_Last(
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException;

	/**
	* Returns the last ceg in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ceg, or <code>null</code> if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg fetchByCategoryName_Last(
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the cegs before and after the current ceg in the ordered set where category = &#63;.
	*
	* @param cegId the primary key of the current ceg
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a ceg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg[] findByCategoryName_PrevAndNext(
		long cegId, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException;

	/**
	* Removes all the cegs where category = &#63; from the database.
	*
	* @param category the category
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryName(java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cegs where category = &#63;.
	*
	* @param category the category
	* @return the number of matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryName(java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the ceg in the entity cache if it is enabled.
	*
	* @param ceg the ceg
	*/
	public void cacheResult(dinet.orgsetup62.model.Ceg ceg);

	/**
	* Caches the cegs in the entity cache if it is enabled.
	*
	* @param cegs the cegs
	*/
	public void cacheResult(java.util.List<dinet.orgsetup62.model.Ceg> cegs);

	/**
	* Creates a new ceg with the primary key. Does not add the ceg to the database.
	*
	* @param cegId the primary key for the new ceg
	* @return the new ceg
	*/
	public dinet.orgsetup62.model.Ceg create(long cegId);

	/**
	* Removes the ceg with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cegId the primary key of the ceg
	* @return the ceg that was removed
	* @throws dinet.orgsetup62.NoSuchCegException if a ceg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg remove(long cegId)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException;

	public dinet.orgsetup62.model.Ceg updateImpl(dinet.orgsetup62.model.Ceg ceg)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the ceg with the primary key or throws a {@link dinet.orgsetup62.NoSuchCegException} if it could not be found.
	*
	* @param cegId the primary key of the ceg
	* @return the ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a ceg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg findByPrimaryKey(long cegId)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException;

	/**
	* Returns the ceg with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cegId the primary key of the ceg
	* @return the ceg, or <code>null</code> if a ceg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public dinet.orgsetup62.model.Ceg fetchByPrimaryKey(long cegId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the cegs.
	*
	* @return the cegs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Ceg> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the cegs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.CegModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cegs
	* @param end the upper bound of the range of cegs (not inclusive)
	* @return the range of cegs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Ceg> findAll(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the cegs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.CegModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of cegs
	* @param end the upper bound of the range of cegs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of cegs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<dinet.orgsetup62.model.Ceg> findAll(int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the cegs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of cegs.
	*
	* @return the number of cegs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}