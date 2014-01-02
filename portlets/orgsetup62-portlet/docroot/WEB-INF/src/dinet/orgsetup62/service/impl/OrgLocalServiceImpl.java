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

import dinet.orgsetup62.NoSuchOrgException;
import dinet.orgsetup62.service.base.OrgLocalServiceBaseImpl;
import dinet.orgsetup62.model.Org;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;
//import com.dinet.internet.productregistration.NoSuchProductException;
//import com.inkwell.internet.productregistration.model.PRProduct;
//import com.liferay.portal.model.ResourceConstants;  

/**
 * The implementation of the org local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link dinet.orgsetup62.service.OrgLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gyengelaszlo
 * @see dinet.orgsetup62.service.base.OrgLocalServiceBaseImpl
 * @see dinet.orgsetup62.service.OrgLocalServiceUtil
 */
public class OrgLocalServiceImpl extends OrgLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link dinet.orgsetup62.service.OrgLocalServiceUtil} to access the org local service.
	 */
	
	public Org addOrg(Org newOrg, long userId)
			throws SystemException, PortalException {
			Org org = orgPersistence.create(counterLocalService.increment(Org.class.getName()));
//			resourceLocalService.addResources(newOrg.getCompanyId(),
//					newOrg.getGroupId(), userId,
//					Org.class.getName(),
//					org.getPrimaryKey(), false, true, true); 
			org.setOrgname_r(newOrg.getOrgname_r());
//			org.setOrgId(newOrg.getOrgId());
			org.setOrigAzon(newOrg.getOrigAzon());
			org.setAzon_r(newOrg.getAzon_r());
			org.setSubAzon_r(newOrg.getSubAzon_r());
			org.setCategory_r(newOrg.getCategory_r());
			org.setCity(newOrg.getCity());
			org.setAddress1(newOrg.getAddress1());
			org.setPostalCode(newOrg.getPostalCode());
			org.setWebURL(newOrg.getWebURL());
			org.setContact(newOrg.getContact());
			org.setEmailAddress(newOrg.getEmailAddress());
			org.setDescription(newOrg.getDescription());
			org.setKeywords(newOrg.getKeywords());
			org.setImageURL(newOrg.getImageURL());
//			return orgPersistence.update(org);
			return orgPersistence.update(org, false);
			
	}

	 /**
     * Retrieves all of the organizations from the database having the given category name
     *
     * @return
     * @throws com.liferay.portal.kernel.exception.SystemException
	 * @throws NoSuchOrgException 
     */
   
	
	public Org getOrgByAzonSubazon(long azon, long subazon)
        throws SystemException, NoSuchOrgException {

        Org org =
            orgPersistence.findByA_SA(azon, subazon);
        return org;
    }
    
    
    
    /**
     * Retrieves all of the organizations from the database having the given Azon 
     * (this is the original excel azon)
     *
     * @return
     * @throws com.liferay.portal.kernel.exception.SystemException
     */
    
	/*
	public List<Org> getAllOrganizationsByAzon(long azon)
        throws SystemException {

        List<Org> organizations =
            orgPersistence.findByA(azon);
        return organizations;
    }
    */
 

}