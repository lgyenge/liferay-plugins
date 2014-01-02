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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import dinet.orgsetup62.NoSuchOrgException;

import dinet.orgsetup62.model.Org;
import dinet.orgsetup62.model.impl.OrgImpl;
import dinet.orgsetup62.model.impl.OrgModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the org service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gyengelaszlo
 * @see OrgPersistence
 * @see OrgUtil
 * @generated
 */
public class OrgPersistenceImpl extends BasePersistenceImpl<Org>
	implements OrgPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link OrgUtil} to access the org persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = OrgImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(OrgModelImpl.ENTITY_CACHE_ENABLED,
			OrgModelImpl.FINDER_CACHE_ENABLED, OrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(OrgModelImpl.ENTITY_CACHE_ENABLED,
			OrgModelImpl.FINDER_CACHE_ENABLED, OrgImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(OrgModelImpl.ENTITY_CACHE_ENABLED,
			OrgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_A_SA = new FinderPath(OrgModelImpl.ENTITY_CACHE_ENABLED,
			OrgModelImpl.FINDER_CACHE_ENABLED, OrgImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByA_SA",
			new String[] { Long.class.getName(), Long.class.getName() },
			OrgModelImpl.AZON_R_COLUMN_BITMASK |
			OrgModelImpl.SUBAZON_R_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A_SA = new FinderPath(OrgModelImpl.ENTITY_CACHE_ENABLED,
			OrgModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA_SA",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns the org where azon_r = &#63; and subAzon_r = &#63; or throws a {@link dinet.orgsetup62.NoSuchOrgException} if it could not be found.
	 *
	 * @param azon_r the azon_r
	 * @param subAzon_r the sub azon_r
	 * @return the matching org
	 * @throws dinet.orgsetup62.NoSuchOrgException if a matching org could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Org findByA_SA(long azon_r, long subAzon_r)
		throws NoSuchOrgException, SystemException {
		Org org = fetchByA_SA(azon_r, subAzon_r);

		if (org == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("azon_r=");
			msg.append(azon_r);

			msg.append(", subAzon_r=");
			msg.append(subAzon_r);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchOrgException(msg.toString());
		}

		return org;
	}

	/**
	 * Returns the org where azon_r = &#63; and subAzon_r = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param azon_r the azon_r
	 * @param subAzon_r the sub azon_r
	 * @return the matching org, or <code>null</code> if a matching org could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Org fetchByA_SA(long azon_r, long subAzon_r)
		throws SystemException {
		return fetchByA_SA(azon_r, subAzon_r, true);
	}

	/**
	 * Returns the org where azon_r = &#63; and subAzon_r = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param azon_r the azon_r
	 * @param subAzon_r the sub azon_r
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching org, or <code>null</code> if a matching org could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Org fetchByA_SA(long azon_r, long subAzon_r,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { azon_r, subAzon_r };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_A_SA,
					finderArgs, this);
		}

		if (result instanceof Org) {
			Org org = (Org)result;

			if ((azon_r != org.getAzon_r()) ||
					(subAzon_r != org.getSubAzon_r())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_ORG_WHERE);

			query.append(_FINDER_COLUMN_A_SA_AZON_R_2);

			query.append(_FINDER_COLUMN_A_SA_SUBAZON_R_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(azon_r);

				qPos.add(subAzon_r);

				List<Org> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_SA,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"OrgPersistenceImpl.fetchByA_SA(long, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Org org = list.get(0);

					result = org;

					cacheResult(org);

					if ((org.getAzon_r() != azon_r) ||
							(org.getSubAzon_r() != subAzon_r)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_SA,
							finderArgs, org);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_A_SA,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Org)result;
		}
	}

	/**
	 * Removes the org where azon_r = &#63; and subAzon_r = &#63; from the database.
	 *
	 * @param azon_r the azon_r
	 * @param subAzon_r the sub azon_r
	 * @return the org that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Org removeByA_SA(long azon_r, long subAzon_r)
		throws NoSuchOrgException, SystemException {
		Org org = findByA_SA(azon_r, subAzon_r);

		return remove(org);
	}

	/**
	 * Returns the number of orgs where azon_r = &#63; and subAzon_r = &#63;.
	 *
	 * @param azon_r the azon_r
	 * @param subAzon_r the sub azon_r
	 * @return the number of matching orgs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByA_SA(long azon_r, long subAzon_r)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_A_SA;

		Object[] finderArgs = new Object[] { azon_r, subAzon_r };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ORG_WHERE);

			query.append(_FINDER_COLUMN_A_SA_AZON_R_2);

			query.append(_FINDER_COLUMN_A_SA_SUBAZON_R_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(azon_r);

				qPos.add(subAzon_r);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_A_SA_AZON_R_2 = "org.azon_r = ? AND ";
	private static final String _FINDER_COLUMN_A_SA_SUBAZON_R_2 = "org.subAzon_r = ?";

	public OrgPersistenceImpl() {
		setModelClass(Org.class);
	}

	/**
	 * Caches the org in the entity cache if it is enabled.
	 *
	 * @param org the org
	 */
	@Override
	public void cacheResult(Org org) {
		EntityCacheUtil.putResult(OrgModelImpl.ENTITY_CACHE_ENABLED,
			OrgImpl.class, org.getPrimaryKey(), org);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_SA,
			new Object[] { org.getAzon_r(), org.getSubAzon_r() }, org);

		org.resetOriginalValues();
	}

	/**
	 * Caches the orgs in the entity cache if it is enabled.
	 *
	 * @param orgs the orgs
	 */
	@Override
	public void cacheResult(List<Org> orgs) {
		for (Org org : orgs) {
			if (EntityCacheUtil.getResult(OrgModelImpl.ENTITY_CACHE_ENABLED,
						OrgImpl.class, org.getPrimaryKey()) == null) {
				cacheResult(org);
			}
			else {
				org.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all orgs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(OrgImpl.class.getName());
		}

		EntityCacheUtil.clearCache(OrgImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the org.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Org org) {
		EntityCacheUtil.removeResult(OrgModelImpl.ENTITY_CACHE_ENABLED,
			OrgImpl.class, org.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(org);
	}

	@Override
	public void clearCache(List<Org> orgs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Org org : orgs) {
			EntityCacheUtil.removeResult(OrgModelImpl.ENTITY_CACHE_ENABLED,
				OrgImpl.class, org.getPrimaryKey());

			clearUniqueFindersCache(org);
		}
	}

	protected void cacheUniqueFindersCache(Org org) {
		if (org.isNew()) {
			Object[] args = new Object[] { org.getAzon_r(), org.getSubAzon_r() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_A_SA, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_SA, args, org);
		}
		else {
			OrgModelImpl orgModelImpl = (OrgModelImpl)org;

			if ((orgModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_A_SA.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { org.getAzon_r(), org.getSubAzon_r() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_A_SA, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_A_SA, args, org);
			}
		}
	}

	protected void clearUniqueFindersCache(Org org) {
		OrgModelImpl orgModelImpl = (OrgModelImpl)org;

		Object[] args = new Object[] { org.getAzon_r(), org.getSubAzon_r() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A_SA, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_A_SA, args);

		if ((orgModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_A_SA.getColumnBitmask()) != 0) {
			args = new Object[] {
					orgModelImpl.getOriginalAzon_r(),
					orgModelImpl.getOriginalSubAzon_r()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A_SA, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_A_SA, args);
		}
	}

	/**
	 * Creates a new org with the primary key. Does not add the org to the database.
	 *
	 * @param orgID the primary key for the new org
	 * @return the new org
	 */
	@Override
	public Org create(long orgID) {
		Org org = new OrgImpl();

		org.setNew(true);
		org.setPrimaryKey(orgID);

		return org;
	}

	/**
	 * Removes the org with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param orgID the primary key of the org
	 * @return the org that was removed
	 * @throws dinet.orgsetup62.NoSuchOrgException if a org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Org remove(long orgID) throws NoSuchOrgException, SystemException {
		return remove((Serializable)orgID);
	}

	/**
	 * Removes the org with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the org
	 * @return the org that was removed
	 * @throws dinet.orgsetup62.NoSuchOrgException if a org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Org remove(Serializable primaryKey)
		throws NoSuchOrgException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Org org = (Org)session.get(OrgImpl.class, primaryKey);

			if (org == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchOrgException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(org);
		}
		catch (NoSuchOrgException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Org removeImpl(Org org) throws SystemException {
		org = toUnwrappedModel(org);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(org)) {
				org = (Org)session.get(OrgImpl.class, org.getPrimaryKeyObj());
			}

			if (org != null) {
				session.delete(org);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (org != null) {
			clearCache(org);
		}

		return org;
	}

	@Override
	public Org updateImpl(dinet.orgsetup62.model.Org org)
		throws SystemException {
		org = toUnwrappedModel(org);

		boolean isNew = org.isNew();

		Session session = null;

		try {
			session = openSession();

			if (org.isNew()) {
				session.save(org);

				org.setNew(false);
			}
			else {
				session.merge(org);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !OrgModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(OrgModelImpl.ENTITY_CACHE_ENABLED,
			OrgImpl.class, org.getPrimaryKey(), org);

		clearUniqueFindersCache(org);
		cacheUniqueFindersCache(org);

		return org;
	}

	protected Org toUnwrappedModel(Org org) {
		if (org instanceof OrgImpl) {
			return org;
		}

		OrgImpl orgImpl = new OrgImpl();

		orgImpl.setNew(org.isNew());
		orgImpl.setPrimaryKey(org.getPrimaryKey());

		orgImpl.setOrgID(org.getOrgID());
		orgImpl.setOrigAzon(org.getOrigAzon());
		orgImpl.setAzon_r(org.getAzon_r());
		orgImpl.setSubAzon_r(org.getSubAzon_r());
		orgImpl.setCategory_r(org.getCategory_r());
		orgImpl.setOrgname_r(org.getOrgname_r());
		orgImpl.setCity(org.getCity());
		orgImpl.setAddress1(org.getAddress1());
		orgImpl.setPostalCode(org.getPostalCode());
		orgImpl.setWebURL(org.getWebURL());
		orgImpl.setContact(org.getContact());
		orgImpl.setEmailAddress(org.getEmailAddress());
		orgImpl.setDescription(org.getDescription());
		orgImpl.setKeywords(org.getKeywords());
		orgImpl.setImageURL(org.getImageURL());

		return orgImpl;
	}

	/**
	 * Returns the org with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the org
	 * @return the org
	 * @throws dinet.orgsetup62.NoSuchOrgException if a org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Org findByPrimaryKey(Serializable primaryKey)
		throws NoSuchOrgException, SystemException {
		Org org = fetchByPrimaryKey(primaryKey);

		if (org == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchOrgException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return org;
	}

	/**
	 * Returns the org with the primary key or throws a {@link dinet.orgsetup62.NoSuchOrgException} if it could not be found.
	 *
	 * @param orgID the primary key of the org
	 * @return the org
	 * @throws dinet.orgsetup62.NoSuchOrgException if a org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Org findByPrimaryKey(long orgID)
		throws NoSuchOrgException, SystemException {
		return findByPrimaryKey((Serializable)orgID);
	}

	/**
	 * Returns the org with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the org
	 * @return the org, or <code>null</code> if a org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Org fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Org org = (Org)EntityCacheUtil.getResult(OrgModelImpl.ENTITY_CACHE_ENABLED,
				OrgImpl.class, primaryKey);

		if (org == _nullOrg) {
			return null;
		}

		if (org == null) {
			Session session = null;

			try {
				session = openSession();

				org = (Org)session.get(OrgImpl.class, primaryKey);

				if (org != null) {
					cacheResult(org);
				}
				else {
					EntityCacheUtil.putResult(OrgModelImpl.ENTITY_CACHE_ENABLED,
						OrgImpl.class, primaryKey, _nullOrg);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(OrgModelImpl.ENTITY_CACHE_ENABLED,
					OrgImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return org;
	}

	/**
	 * Returns the org with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param orgID the primary key of the org
	 * @return the org, or <code>null</code> if a org with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Org fetchByPrimaryKey(long orgID) throws SystemException {
		return fetchByPrimaryKey((Serializable)orgID);
	}

	/**
	 * Returns all the orgs.
	 *
	 * @return the orgs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Org> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Org> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Org> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Org> list = (List<Org>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ORG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ORG;

				if (pagination) {
					sql = sql.concat(OrgModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Org>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Org>(list);
				}
				else {
					list = (List<Org>)QueryUtil.list(q, getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the orgs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Org org : findAll()) {
			remove(org);
		}
	}

	/**
	 * Returns the number of orgs.
	 *
	 * @return the number of orgs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ORG);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the org persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.dinet.orgsetup62.model.Org")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Org>> listenersList = new ArrayList<ModelListener<Org>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Org>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(OrgImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ORG = "SELECT org FROM Org org";
	private static final String _SQL_SELECT_ORG_WHERE = "SELECT org FROM Org org WHERE ";
	private static final String _SQL_COUNT_ORG = "SELECT COUNT(org) FROM Org org";
	private static final String _SQL_COUNT_ORG_WHERE = "SELECT COUNT(org) FROM Org org WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "org.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Org exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Org exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(OrgPersistenceImpl.class);
	private static Org _nullOrg = new OrgImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Org> toCacheModel() {
				return _nullOrgCacheModel;
			}
		};

	private static CacheModel<Org> _nullOrgCacheModel = new CacheModel<Org>() {
			@Override
			public Org toEntityModel() {
				return _nullOrg;
			}
		};
}