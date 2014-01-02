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
 * Provides a wrapper for {@link OrgLocalService}.
 *
 * @author gyengelaszlo
 * @see OrgLocalService
 * @generated
 */
public class OrgLocalServiceWrapper implements OrgLocalService,
	ServiceWrapper<OrgLocalService> {
	public OrgLocalServiceWrapper(OrgLocalService orgLocalService) {
		_orgLocalService = orgLocalService;
	}

	/**
	* Adds the org to the database. Also notifies the appropriate model listeners.
	*
	* @param org the org
	* @return the org that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public dinet.orgsetup62.model.Org addOrg(dinet.orgsetup62.model.Org org)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgLocalService.addOrg(org);
	}

	/**
	* Creates a new org with the primary key. Does not add the org to the database.
	*
	* @param orgID the primary key for the new org
	* @return the new org
	*/
	@Override
	public dinet.orgsetup62.model.Org createOrg(long orgID) {
		return _orgLocalService.createOrg(orgID);
	}

	/**
	* Deletes the org with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param orgID the primary key of the org
	* @return the org that was removed
	* @throws PortalException if a org with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public dinet.orgsetup62.model.Org deleteOrg(long orgID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgLocalService.deleteOrg(orgID);
	}

	/**
	* Deletes the org from the database. Also notifies the appropriate model listeners.
	*
	* @param org the org
	* @return the org that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public dinet.orgsetup62.model.Org deleteOrg(dinet.orgsetup62.model.Org org)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgLocalService.deleteOrg(org);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _orgLocalService.dynamicQuery();
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
		return _orgLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.OrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _orgLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link dinet.orgsetup62.model.impl.OrgModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _orgLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _orgLocalService.dynamicQueryCount(dynamicQuery);
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
		return _orgLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public dinet.orgsetup62.model.Org fetchOrg(long orgID)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgLocalService.fetchOrg(orgID);
	}

	/**
	* Returns the org with the primary key.
	*
	* @param orgID the primary key of the org
	* @return the org
	* @throws PortalException if a org with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public dinet.orgsetup62.model.Org getOrg(long orgID)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgLocalService.getOrg(orgID);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<dinet.orgsetup62.model.Org> getOrgs(int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgLocalService.getOrgs(start, end);
	}

	/**
	* Returns the number of orgs.
	*
	* @return the number of orgs
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOrgsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgLocalService.getOrgsCount();
	}

	/**
	* Updates the org in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param org the org
	* @return the org that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public dinet.orgsetup62.model.Org updateOrg(dinet.orgsetup62.model.Org org)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _orgLocalService.updateOrg(org);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _orgLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_orgLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _orgLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public dinet.orgsetup62.model.Org addOrg(
		dinet.orgsetup62.model.Org newOrg, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _orgLocalService.addOrg(newOrg, userId);
	}

	/**
	* Retrieves all of the organizations from the database having the given category name
	*
	* @return
	* @throws com.liferay.portal.kernel.exception.SystemException
	* @throws NoSuchOrgException
	*/
	@Override
	public dinet.orgsetup62.model.Org getOrgByAzonSubazon(long azon,
		long subazon)
		throws com.liferay.portal.kernel.exception.SystemException,
			dinet.orgsetup62.NoSuchOrgException {
		return _orgLocalService.getOrgByAzonSubazon(azon, subazon);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OrgLocalService getWrappedOrgLocalService() {
		return _orgLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOrgLocalService(OrgLocalService orgLocalService) {
		_orgLocalService = orgLocalService;
	}

	@Override
	public OrgLocalService getWrappedService() {
		return _orgLocalService;
	}

	@Override
	public void setWrappedService(OrgLocalService orgLocalService) {
		_orgLocalService = orgLocalService;
	}

	private OrgLocalService _orgLocalService;
}