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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import dinet.orgsetup62.model.Ceg;

import java.util.List;

/**
 * The persistence utility for the ceg service. This utility wraps {@link CegPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gyengelaszlo
 * @see CegPersistence
 * @see CegPersistenceImpl
 * @generated
 */
public class CegUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Ceg ceg) {
		getPersistence().clearCache(ceg);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Ceg> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Ceg> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Ceg> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Ceg update(Ceg ceg) throws SystemException {
		return getPersistence().update(ceg);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Ceg update(Ceg ceg, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(ceg, serviceContext);
	}

	/**
	* Returns all the cegs where azon_u = &#63;.
	*
	* @param azon_u the azon_u
	* @return the matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<dinet.orgsetup62.model.Ceg> findByA(
		long azon_u) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByA(azon_u);
	}

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
	public static java.util.List<dinet.orgsetup62.model.Ceg> findByA(
		long azon_u, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByA(azon_u, start, end);
	}

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
	public static java.util.List<dinet.orgsetup62.model.Ceg> findByA(
		long azon_u, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByA(azon_u, start, end, orderByComparator);
	}

	/**
	* Returns the first ceg in the ordered set where azon_u = &#63;.
	*
	* @param azon_u the azon_u
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg findByA_First(long azon_u,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException {
		return getPersistence().findByA_First(azon_u, orderByComparator);
	}

	/**
	* Returns the first ceg in the ordered set where azon_u = &#63;.
	*
	* @param azon_u the azon_u
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ceg, or <code>null</code> if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg fetchByA_First(long azon_u,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByA_First(azon_u, orderByComparator);
	}

	/**
	* Returns the last ceg in the ordered set where azon_u = &#63;.
	*
	* @param azon_u the azon_u
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg findByA_Last(long azon_u,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException {
		return getPersistence().findByA_Last(azon_u, orderByComparator);
	}

	/**
	* Returns the last ceg in the ordered set where azon_u = &#63;.
	*
	* @param azon_u the azon_u
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ceg, or <code>null</code> if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg fetchByA_Last(long azon_u,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByA_Last(azon_u, orderByComparator);
	}

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
	public static dinet.orgsetup62.model.Ceg[] findByA_PrevAndNext(long cegId,
		long azon_u,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException {
		return getPersistence()
				   .findByA_PrevAndNext(cegId, azon_u, orderByComparator);
	}

	/**
	* Removes all the cegs where azon_u = &#63; from the database.
	*
	* @param azon_u the azon_u
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByA(long azon_u)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByA(azon_u);
	}

	/**
	* Returns the number of cegs where azon_u = &#63;.
	*
	* @param azon_u the azon_u
	* @return the number of matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByA(long azon_u)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByA(azon_u);
	}

	/**
	* Returns all the cegs where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @return the matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<dinet.orgsetup62.model.Ceg> findByLiferayOrgId(
		long liferayOrgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLiferayOrgId(liferayOrgId);
	}

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
	public static java.util.List<dinet.orgsetup62.model.Ceg> findByLiferayOrgId(
		long liferayOrgId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByLiferayOrgId(liferayOrgId, start, end);
	}

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
	public static java.util.List<dinet.orgsetup62.model.Ceg> findByLiferayOrgId(
		long liferayOrgId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByLiferayOrgId(liferayOrgId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first ceg in the ordered set where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg findByLiferayOrgId_First(
		long liferayOrgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException {
		return getPersistence()
				   .findByLiferayOrgId_First(liferayOrgId, orderByComparator);
	}

	/**
	* Returns the first ceg in the ordered set where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ceg, or <code>null</code> if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg fetchByLiferayOrgId_First(
		long liferayOrgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLiferayOrgId_First(liferayOrgId, orderByComparator);
	}

	/**
	* Returns the last ceg in the ordered set where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg findByLiferayOrgId_Last(
		long liferayOrgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException {
		return getPersistence()
				   .findByLiferayOrgId_Last(liferayOrgId, orderByComparator);
	}

	/**
	* Returns the last ceg in the ordered set where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ceg, or <code>null</code> if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg fetchByLiferayOrgId_Last(
		long liferayOrgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByLiferayOrgId_Last(liferayOrgId, orderByComparator);
	}

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
	public static dinet.orgsetup62.model.Ceg[] findByLiferayOrgId_PrevAndNext(
		long cegId, long liferayOrgId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException {
		return getPersistence()
				   .findByLiferayOrgId_PrevAndNext(cegId, liferayOrgId,
			orderByComparator);
	}

	/**
	* Removes all the cegs where liferayOrgId = &#63; from the database.
	*
	* @param liferayOrgId the liferay org ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByLiferayOrgId(long liferayOrgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByLiferayOrgId(liferayOrgId);
	}

	/**
	* Returns the number of cegs where liferayOrgId = &#63;.
	*
	* @param liferayOrgId the liferay org ID
	* @return the number of matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByLiferayOrgId(long liferayOrgId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByLiferayOrgId(liferayOrgId);
	}

	/**
	* Returns all the cegs where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @return the matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<dinet.orgsetup62.model.Ceg> findByPageURLAzon(
		java.lang.String pageURLAzon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPageURLAzon(pageURLAzon);
	}

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
	public static java.util.List<dinet.orgsetup62.model.Ceg> findByPageURLAzon(
		java.lang.String pageURLAzon, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPageURLAzon(pageURLAzon, start, end);
	}

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
	public static java.util.List<dinet.orgsetup62.model.Ceg> findByPageURLAzon(
		java.lang.String pageURLAzon, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByPageURLAzon(pageURLAzon, start, end, orderByComparator);
	}

	/**
	* Returns the first ceg in the ordered set where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg findByPageURLAzon_First(
		java.lang.String pageURLAzon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException {
		return getPersistence()
				   .findByPageURLAzon_First(pageURLAzon, orderByComparator);
	}

	/**
	* Returns the first ceg in the ordered set where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ceg, or <code>null</code> if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg fetchByPageURLAzon_First(
		java.lang.String pageURLAzon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPageURLAzon_First(pageURLAzon, orderByComparator);
	}

	/**
	* Returns the last ceg in the ordered set where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg findByPageURLAzon_Last(
		java.lang.String pageURLAzon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException {
		return getPersistence()
				   .findByPageURLAzon_Last(pageURLAzon, orderByComparator);
	}

	/**
	* Returns the last ceg in the ordered set where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ceg, or <code>null</code> if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg fetchByPageURLAzon_Last(
		java.lang.String pageURLAzon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByPageURLAzon_Last(pageURLAzon, orderByComparator);
	}

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
	public static dinet.orgsetup62.model.Ceg[] findByPageURLAzon_PrevAndNext(
		long cegId, java.lang.String pageURLAzon,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException {
		return getPersistence()
				   .findByPageURLAzon_PrevAndNext(cegId, pageURLAzon,
			orderByComparator);
	}

	/**
	* Removes all the cegs where pageURLAzon = &#63; from the database.
	*
	* @param pageURLAzon the page u r l azon
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByPageURLAzon(java.lang.String pageURLAzon)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByPageURLAzon(pageURLAzon);
	}

	/**
	* Returns the number of cegs where pageURLAzon = &#63;.
	*
	* @param pageURLAzon the page u r l azon
	* @return the number of matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByPageURLAzon(java.lang.String pageURLAzon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByPageURLAzon(pageURLAzon);
	}

	/**
	* Returns all the cegs where category = &#63;.
	*
	* @param category the category
	* @return the matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<dinet.orgsetup62.model.Ceg> findByCategoryName(
		java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryName(category);
	}

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
	public static java.util.List<dinet.orgsetup62.model.Ceg> findByCategoryName(
		java.lang.String category, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCategoryName(category, start, end);
	}

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
	public static java.util.List<dinet.orgsetup62.model.Ceg> findByCategoryName(
		java.lang.String category, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCategoryName(category, start, end, orderByComparator);
	}

	/**
	* Returns the first ceg in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg findByCategoryName_First(
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException {
		return getPersistence()
				   .findByCategoryName_First(category, orderByComparator);
	}

	/**
	* Returns the first ceg in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ceg, or <code>null</code> if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg fetchByCategoryName_First(
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryName_First(category, orderByComparator);
	}

	/**
	* Returns the last ceg in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg findByCategoryName_Last(
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException {
		return getPersistence()
				   .findByCategoryName_Last(category, orderByComparator);
	}

	/**
	* Returns the last ceg in the ordered set where category = &#63;.
	*
	* @param category the category
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ceg, or <code>null</code> if a matching ceg could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg fetchByCategoryName_Last(
		java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCategoryName_Last(category, orderByComparator);
	}

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
	public static dinet.orgsetup62.model.Ceg[] findByCategoryName_PrevAndNext(
		long cegId, java.lang.String category,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException {
		return getPersistence()
				   .findByCategoryName_PrevAndNext(cegId, category,
			orderByComparator);
	}

	/**
	* Removes all the cegs where category = &#63; from the database.
	*
	* @param category the category
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCategoryName(java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCategoryName(category);
	}

	/**
	* Returns the number of cegs where category = &#63;.
	*
	* @param category the category
	* @return the number of matching cegs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCategoryName(java.lang.String category)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCategoryName(category);
	}

	/**
	* Caches the ceg in the entity cache if it is enabled.
	*
	* @param ceg the ceg
	*/
	public static void cacheResult(dinet.orgsetup62.model.Ceg ceg) {
		getPersistence().cacheResult(ceg);
	}

	/**
	* Caches the cegs in the entity cache if it is enabled.
	*
	* @param cegs the cegs
	*/
	public static void cacheResult(
		java.util.List<dinet.orgsetup62.model.Ceg> cegs) {
		getPersistence().cacheResult(cegs);
	}

	/**
	* Creates a new ceg with the primary key. Does not add the ceg to the database.
	*
	* @param cegId the primary key for the new ceg
	* @return the new ceg
	*/
	public static dinet.orgsetup62.model.Ceg create(long cegId) {
		return getPersistence().create(cegId);
	}

	/**
	* Removes the ceg with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cegId the primary key of the ceg
	* @return the ceg that was removed
	* @throws dinet.orgsetup62.NoSuchCegException if a ceg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg remove(long cegId)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException {
		return getPersistence().remove(cegId);
	}

	public static dinet.orgsetup62.model.Ceg updateImpl(
		dinet.orgsetup62.model.Ceg ceg)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ceg);
	}

	/**
	* Returns the ceg with the primary key or throws a {@link dinet.orgsetup62.NoSuchCegException} if it could not be found.
	*
	* @param cegId the primary key of the ceg
	* @return the ceg
	* @throws dinet.orgsetup62.NoSuchCegException if a ceg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg findByPrimaryKey(long cegId)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchCegException {
		return getPersistence().findByPrimaryKey(cegId);
	}

	/**
	* Returns the ceg with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param cegId the primary key of the ceg
	* @return the ceg, or <code>null</code> if a ceg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg fetchByPrimaryKey(long cegId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(cegId);
	}

	/**
	* Returns all the cegs.
	*
	* @return the cegs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<dinet.orgsetup62.model.Ceg> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<dinet.orgsetup62.model.Ceg> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<dinet.orgsetup62.model.Ceg> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the cegs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of cegs.
	*
	* @return the number of cegs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CegPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CegPersistence)PortletBeanLocatorUtil.locate(dinet.orgsetup62.service.ClpSerializer.getServletContextName(),
					CegPersistence.class.getName());

			ReferenceRegistry.registerReference(CegUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CegPersistence persistence) {
	}

	private static CegPersistence _persistence;
}