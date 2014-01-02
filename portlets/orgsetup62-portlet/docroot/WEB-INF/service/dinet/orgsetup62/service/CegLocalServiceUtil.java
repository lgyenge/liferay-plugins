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

package dinet.orgsetup62.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Ceg. This utility wraps
 * {@link dinet.orgsetup62.service.impl.CegLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author gyengelaszlo
 * @see CegLocalService
 * @see dinet.orgsetup62.service.base.CegLocalServiceBaseImpl
 * @see dinet.orgsetup62.service.impl.CegLocalServiceImpl
 * @generated
 */
public class CegLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link dinet.orgsetup62.service.impl.CegLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the ceg to the database. Also notifies the appropriate model listeners.
	*
	* @param ceg the ceg
	* @return the ceg that was added
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg addCeg(
		dinet.orgsetup62.model.Ceg ceg)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCeg(ceg);
	}

	/**
	* Creates a new ceg with the primary key. Does not add the ceg to the database.
	*
	* @param cegId the primary key for the new ceg
	* @return the new ceg
	*/
	public static dinet.orgsetup62.model.Ceg createCeg(long cegId) {
		return getService().createCeg(cegId);
	}

	/**
	* Deletes the ceg with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cegId the primary key of the ceg
	* @return the ceg that was removed
	* @throws PortalException if a ceg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg deleteCeg(long cegId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCeg(cegId);
	}

	/**
	* Deletes the ceg from the database. Also notifies the appropriate model listeners.
	*
	* @param ceg the ceg
	* @return the ceg that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg deleteCeg(
		dinet.orgsetup62.model.Ceg ceg)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCeg(ceg);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.CegModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.CegModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static dinet.orgsetup62.model.Ceg fetchCeg(long cegId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCeg(cegId);
	}

	/**
	* Returns the ceg with the primary key.
	*
	* @param cegId the primary key of the ceg
	* @return the ceg
	* @throws PortalException if a ceg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg getCeg(long cegId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCeg(cegId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<dinet.orgsetup62.model.Ceg> getCegs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCegs(start, end);
	}

	/**
	* Returns the number of cegs.
	*
	* @return the number of cegs
	* @throws SystemException if a system exception occurred
	*/
	public static int getCegsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCegsCount();
	}

	/**
	* Updates the ceg in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ceg the ceg
	* @return the ceg that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static dinet.orgsetup62.model.Ceg updateCeg(
		dinet.orgsetup62.model.Ceg ceg)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCeg(ceg);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static dinet.orgsetup62.model.Ceg addCeg(
		dinet.orgsetup62.model.Ceg newCeg, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addCeg(newCeg, userId);
	}

	public static java.util.List<dinet.orgsetup62.model.Ceg> getAllCegByCategoryNames(
		java.lang.String categorynames)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCegByCategoryNames(categorynames);
	}

	public static java.util.List<dinet.orgsetup62.model.Ceg> getAllCeg()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCeg();
	}

	public static java.util.List<dinet.orgsetup62.model.Ceg> getAllCegByAzon(
		long azon) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCegByAzon(azon);
	}

	public static java.util.List<dinet.orgsetup62.model.Ceg> getAllCegByPageURLAzon(
		java.lang.String urlazon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCegByPageURLAzon(urlazon);
	}

	public static void clearService() {
		_service = null;
	}

	public static CegLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CegLocalService.class.getName());

			if (invokableLocalService instanceof CegLocalService) {
				_service = (CegLocalService)invokableLocalService;
			}
			else {
				_service = new CegLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CegLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CegLocalService service) {
	}

	private static CegLocalService _service;
}