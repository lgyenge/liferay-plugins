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

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CegLocalService}.
 *
 * @author gyengelaszlo
 * @see CegLocalService
 * @generated
 */
public class CegLocalServiceWrapper implements CegLocalService,
	ServiceWrapper<CegLocalService> {
	public CegLocalServiceWrapper(CegLocalService cegLocalService) {
		_cegLocalService = cegLocalService;
	}

	/**
	* Adds the ceg to the database. Also notifies the appropriate model listeners.
	*
	* @param ceg the ceg
	* @return the ceg that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public dinet.orgsetup62.model.Ceg addCeg(dinet.orgsetup62.model.Ceg ceg)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.addCeg(ceg);
	}

	/**
	* Creates a new ceg with the primary key. Does not add the ceg to the database.
	*
	* @param cegId the primary key for the new ceg
	* @return the new ceg
	*/
	@Override
	public dinet.orgsetup62.model.Ceg createCeg(long cegId) {
		return _cegLocalService.createCeg(cegId);
	}

	/**
	* Deletes the ceg with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param cegId the primary key of the ceg
	* @return the ceg that was removed
	* @throws PortalException if a ceg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public dinet.orgsetup62.model.Ceg deleteCeg(long cegId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.deleteCeg(cegId);
	}

	/**
	* Deletes the ceg from the database. Also notifies the appropriate model listeners.
	*
	* @param ceg the ceg
	* @return the ceg that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public dinet.orgsetup62.model.Ceg deleteCeg(dinet.orgsetup62.model.Ceg ceg)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.deleteCeg(ceg);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _cegLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public dinet.orgsetup62.model.Ceg fetchCeg(long cegId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.fetchCeg(cegId);
	}

	/**
	* Returns the ceg with the primary key.
	*
	* @param cegId the primary key of the ceg
	* @return the ceg
	* @throws PortalException if a ceg with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public dinet.orgsetup62.model.Ceg getCeg(long cegId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.getCeg(cegId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<dinet.orgsetup62.model.Ceg> getCegs(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.getCegs(start, end);
	}

	/**
	* Returns the number of cegs.
	*
	* @return the number of cegs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCegsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.getCegsCount();
	}

	/**
	* Updates the ceg in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ceg the ceg
	* @return the ceg that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public dinet.orgsetup62.model.Ceg updateCeg(dinet.orgsetup62.model.Ceg ceg)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.updateCeg(ceg);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _cegLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_cegLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _cegLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public dinet.orgsetup62.model.Ceg addCeg(
		dinet.orgsetup62.model.Ceg newCeg, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.addCeg(newCeg, userId);
	}

	@Override
	public java.util.List<dinet.orgsetup62.model.Ceg> getAllCegByCategoryNames(
		java.lang.String categorynames)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.getAllCegByCategoryNames(categorynames);
	}

	@Override
	public java.util.List<dinet.orgsetup62.model.Ceg> getAllCeg()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.getAllCeg();
	}

	@Override
	public java.util.List<dinet.orgsetup62.model.Ceg> getAllCegByAzon(long azon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.getAllCegByAzon(azon);
	}

	@Override
	public java.util.List<dinet.orgsetup62.model.Ceg> getAllCegByPageURLAzon(
		java.lang.String urlazon)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _cegLocalService.getAllCegByPageURLAzon(urlazon);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CegLocalService getWrappedCegLocalService() {
		return _cegLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCegLocalService(CegLocalService cegLocalService) {
		_cegLocalService = cegLocalService;
	}

	@Override
	public CegLocalService getWrappedService() {
		return _cegLocalService;
	}

	@Override
	public void setWrappedService(CegLocalService cegLocalService) {
		_cegLocalService = cegLocalService;
	}

	private CegLocalService _cegLocalService;
}