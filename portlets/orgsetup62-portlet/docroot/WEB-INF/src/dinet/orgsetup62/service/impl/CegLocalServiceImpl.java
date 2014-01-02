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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import dinet.orgsetup62.model.Ceg;
import dinet.orgsetup62.service.base.CegLocalServiceBaseImpl;
import java.util.List;

/**
 * The implementation of the ceg local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link dinet.orgsetup62.service.CegLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author gyengelaszlo
 * @see dinet.orgsetup62.service.base.CegLocalServiceBaseImpl
 * @see dinet.orgsetup62.service.CegLocalServiceUtil
 */
public class CegLocalServiceImpl extends CegLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link dinet.orgsetup62.service.CegLocalServiceUtil} to access the ceg local service.
	 */
	
	public Ceg addCeg(Ceg newCeg, long userId)
			throws SystemException, PortalException {
			Ceg ceg = cegPersistence.create(counterLocalService.increment(Ceg.class.getName()));
//			resourceLocalService.addResources(newCeg.getCompanyId(),
//					newCeg.getGroupId(), userId,
//					Ceg.class.getName(),
//					ceg.getPrimaryKey(), false, true, true); 
			ceg.setAzon_r(newCeg.getAzon_r());
			ceg.setSubAzon_r(newCeg.getSubAzon_r());
			ceg.setCategory_r(newCeg.getCategory_r());
			ceg.setOrgname_r(newCeg.getOrgname_r());
			ceg.setAzon_u(newCeg.getAzon_u());
			ceg.setSubAzon_u(newCeg.getSubAzon_u());
			ceg.setLiferayOrgId(newCeg.getLiferayOrgId());
			ceg.setOrgname(newCeg.getOrgname());
			ceg.setLogo(newCeg.getLogo());
			ceg.setCategoryId(newCeg.getCategoryId());
			ceg.setCategory(newCeg.getCategory());
			ceg.setPostalcode(newCeg.getPostalcode());
			ceg.setCity(newCeg.getCity());
			ceg.setStreet(newCeg.getStreet());
			ceg.setContact(newCeg.getContact());
			ceg.setWeb(newCeg.getWeb());
			ceg.setDescription(newCeg.getDescription());
			ceg.setHtmldescription(newCeg.getHtmldescription());
			ceg.setKeywords(newCeg.getKeywords());
			ceg.setPageURL(newCeg.getPageURL());
			ceg.setPagename(newCeg.getPagename());
			ceg.setDate(newCeg.getDate());
			ceg.setPageURLAzon(newCeg.getPageURLAzon());
			return cegPersistence.update(ceg);
//			return cegPersistence.update(ceg, false);
			
	}
	
	
	public List<Ceg> getAllCegByCategoryNames(String categorynames)
        throws SystemException {

        List<Ceg> cegek =
            cegPersistence.findByCategoryName(categorynames);
        return cegek;
    }
	
	public List<Ceg> getAllCeg()
	        throws SystemException {

	        List<Ceg> cegek =
	            cegPersistence.findAll();
	        return cegek;
	    }
	
	public List<Ceg> getAllCegByAzon(long azon)
        throws SystemException {

        List<Ceg> cegek =
            cegPersistence.findByA(azon);
        return cegek;
    }
	
	public List<Ceg> getAllCegByPageURLAzon(String urlazon)
	        throws SystemException {

	        List<Ceg> cegek =
	            cegPersistence.findByPageURLAzon (urlazon);
	        return cegek;
	    }

}