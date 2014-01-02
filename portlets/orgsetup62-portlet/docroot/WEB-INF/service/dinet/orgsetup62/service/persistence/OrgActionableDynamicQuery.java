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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import dinet.orgsetup62.model.Org;

import dinet.orgsetup62.service.OrgLocalServiceUtil;

/**
 * @author gyengelaszlo
 * @generated
 */
public abstract class OrgActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public OrgActionableDynamicQuery() throws SystemException {
		setBaseLocalService(OrgLocalServiceUtil.getService());
		setClass(Org.class);

		setClassLoader(dinet.orgsetup62.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("orgID");
	}
}