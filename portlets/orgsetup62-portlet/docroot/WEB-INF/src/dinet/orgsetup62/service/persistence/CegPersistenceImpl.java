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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import dinet.orgsetup62.NoSuchCegException;

import dinet.orgsetup62.model.Ceg;
import dinet.orgsetup62.model.impl.CegImpl;
import dinet.orgsetup62.model.impl.CegModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * The persistence implementation for the ceg service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gyengelaszlo
 * @see CegPersistence
 * @see CegUtil
 * @generated
 */
public class CegPersistenceImpl extends BasePersistenceImpl<Ceg>
	implements CegPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CegUtil} to access the ceg persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CegImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegModelImpl.FINDER_CACHE_ENABLED, CegImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegModelImpl.FINDER_CACHE_ENABLED, CegImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_A = new FinderPath(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegModelImpl.FINDER_CACHE_ENABLED, CegImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByA",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A = new FinderPath(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegModelImpl.FINDER_CACHE_ENABLED, CegImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByA",
			new String[] { Long.class.getName() },
			CegModelImpl.AZON_U_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_A = new FinderPath(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByA",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the cegs where azon_u = &#63;.
	 *
	 * @param azon_u the azon_u
	 * @return the matching cegs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ceg> findByA(long azon_u) throws SystemException {
		return findByA(azon_u, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Ceg> findByA(long azon_u, int start, int end)
		throws SystemException {
		return findByA(azon_u, start, end, null);
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
	@Override
	public List<Ceg> findByA(long azon_u, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A;
			finderArgs = new Object[] { azon_u };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_A;
			finderArgs = new Object[] { azon_u, start, end, orderByComparator };
		}

		List<Ceg> list = (List<Ceg>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Ceg ceg : list) {
				if ((azon_u != ceg.getAzon_u())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CEG_WHERE);

			query.append(_FINDER_COLUMN_A_AZON_U_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CegModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(azon_u);

				if (!pagination) {
					list = (List<Ceg>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Ceg>(list);
				}
				else {
					list = (List<Ceg>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first ceg in the ordered set where azon_u = &#63;.
	 *
	 * @param azon_u the azon_u
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ceg
	 * @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg findByA_First(long azon_u, OrderByComparator orderByComparator)
		throws NoSuchCegException, SystemException {
		Ceg ceg = fetchByA_First(azon_u, orderByComparator);

		if (ceg != null) {
			return ceg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("azon_u=");
		msg.append(azon_u);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCegException(msg.toString());
	}

	/**
	 * Returns the first ceg in the ordered set where azon_u = &#63;.
	 *
	 * @param azon_u the azon_u
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ceg, or <code>null</code> if a matching ceg could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg fetchByA_First(long azon_u, OrderByComparator orderByComparator)
		throws SystemException {
		List<Ceg> list = findByA(azon_u, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Ceg findByA_Last(long azon_u, OrderByComparator orderByComparator)
		throws NoSuchCegException, SystemException {
		Ceg ceg = fetchByA_Last(azon_u, orderByComparator);

		if (ceg != null) {
			return ceg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("azon_u=");
		msg.append(azon_u);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCegException(msg.toString());
	}

	/**
	 * Returns the last ceg in the ordered set where azon_u = &#63;.
	 *
	 * @param azon_u the azon_u
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ceg, or <code>null</code> if a matching ceg could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg fetchByA_Last(long azon_u, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByA(azon_u);

		if (count == 0) {
			return null;
		}

		List<Ceg> list = findByA(azon_u, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Ceg[] findByA_PrevAndNext(long cegId, long azon_u,
		OrderByComparator orderByComparator)
		throws NoSuchCegException, SystemException {
		Ceg ceg = findByPrimaryKey(cegId);

		Session session = null;

		try {
			session = openSession();

			Ceg[] array = new CegImpl[3];

			array[0] = getByA_PrevAndNext(session, ceg, azon_u,
					orderByComparator, true);

			array[1] = ceg;

			array[2] = getByA_PrevAndNext(session, ceg, azon_u,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ceg getByA_PrevAndNext(Session session, Ceg ceg, long azon_u,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CEG_WHERE);

		query.append(_FINDER_COLUMN_A_AZON_U_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CegModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(azon_u);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ceg);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Ceg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cegs where azon_u = &#63; from the database.
	 *
	 * @param azon_u the azon_u
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByA(long azon_u) throws SystemException {
		for (Ceg ceg : findByA(azon_u, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(ceg);
		}
	}

	/**
	 * Returns the number of cegs where azon_u = &#63;.
	 *
	 * @param azon_u the azon_u
	 * @return the number of matching cegs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByA(long azon_u) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_A;

		Object[] finderArgs = new Object[] { azon_u };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CEG_WHERE);

			query.append(_FINDER_COLUMN_A_AZON_U_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(azon_u);

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

	private static final String _FINDER_COLUMN_A_AZON_U_2 = "ceg.azon_u = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LIFERAYORGID =
		new FinderPath(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegModelImpl.FINDER_CACHE_ENABLED, CegImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLiferayOrgId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIFERAYORGID =
		new FinderPath(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegModelImpl.FINDER_CACHE_ENABLED, CegImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLiferayOrgId",
			new String[] { Long.class.getName() },
			CegModelImpl.LIFERAYORGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LIFERAYORGID = new FinderPath(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLiferayOrgId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the cegs where liferayOrgId = &#63;.
	 *
	 * @param liferayOrgId the liferay org ID
	 * @return the matching cegs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ceg> findByLiferayOrgId(long liferayOrgId)
		throws SystemException {
		return findByLiferayOrgId(liferayOrgId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Ceg> findByLiferayOrgId(long liferayOrgId, int start, int end)
		throws SystemException {
		return findByLiferayOrgId(liferayOrgId, start, end, null);
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
	@Override
	public List<Ceg> findByLiferayOrgId(long liferayOrgId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIFERAYORGID;
			finderArgs = new Object[] { liferayOrgId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LIFERAYORGID;
			finderArgs = new Object[] {
					liferayOrgId,
					
					start, end, orderByComparator
				};
		}

		List<Ceg> list = (List<Ceg>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Ceg ceg : list) {
				if ((liferayOrgId != ceg.getLiferayOrgId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CEG_WHERE);

			query.append(_FINDER_COLUMN_LIFERAYORGID_LIFERAYORGID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CegModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(liferayOrgId);

				if (!pagination) {
					list = (List<Ceg>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Ceg>(list);
				}
				else {
					list = (List<Ceg>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first ceg in the ordered set where liferayOrgId = &#63;.
	 *
	 * @param liferayOrgId the liferay org ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ceg
	 * @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg findByLiferayOrgId_First(long liferayOrgId,
		OrderByComparator orderByComparator)
		throws NoSuchCegException, SystemException {
		Ceg ceg = fetchByLiferayOrgId_First(liferayOrgId, orderByComparator);

		if (ceg != null) {
			return ceg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("liferayOrgId=");
		msg.append(liferayOrgId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCegException(msg.toString());
	}

	/**
	 * Returns the first ceg in the ordered set where liferayOrgId = &#63;.
	 *
	 * @param liferayOrgId the liferay org ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ceg, or <code>null</code> if a matching ceg could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg fetchByLiferayOrgId_First(long liferayOrgId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Ceg> list = findByLiferayOrgId(liferayOrgId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Ceg findByLiferayOrgId_Last(long liferayOrgId,
		OrderByComparator orderByComparator)
		throws NoSuchCegException, SystemException {
		Ceg ceg = fetchByLiferayOrgId_Last(liferayOrgId, orderByComparator);

		if (ceg != null) {
			return ceg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("liferayOrgId=");
		msg.append(liferayOrgId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCegException(msg.toString());
	}

	/**
	 * Returns the last ceg in the ordered set where liferayOrgId = &#63;.
	 *
	 * @param liferayOrgId the liferay org ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ceg, or <code>null</code> if a matching ceg could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg fetchByLiferayOrgId_Last(long liferayOrgId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLiferayOrgId(liferayOrgId);

		if (count == 0) {
			return null;
		}

		List<Ceg> list = findByLiferayOrgId(liferayOrgId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Ceg[] findByLiferayOrgId_PrevAndNext(long cegId, long liferayOrgId,
		OrderByComparator orderByComparator)
		throws NoSuchCegException, SystemException {
		Ceg ceg = findByPrimaryKey(cegId);

		Session session = null;

		try {
			session = openSession();

			Ceg[] array = new CegImpl[3];

			array[0] = getByLiferayOrgId_PrevAndNext(session, ceg,
					liferayOrgId, orderByComparator, true);

			array[1] = ceg;

			array[2] = getByLiferayOrgId_PrevAndNext(session, ceg,
					liferayOrgId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ceg getByLiferayOrgId_PrevAndNext(Session session, Ceg ceg,
		long liferayOrgId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CEG_WHERE);

		query.append(_FINDER_COLUMN_LIFERAYORGID_LIFERAYORGID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CegModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(liferayOrgId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ceg);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Ceg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cegs where liferayOrgId = &#63; from the database.
	 *
	 * @param liferayOrgId the liferay org ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByLiferayOrgId(long liferayOrgId)
		throws SystemException {
		for (Ceg ceg : findByLiferayOrgId(liferayOrgId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ceg);
		}
	}

	/**
	 * Returns the number of cegs where liferayOrgId = &#63;.
	 *
	 * @param liferayOrgId the liferay org ID
	 * @return the number of matching cegs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByLiferayOrgId(long liferayOrgId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LIFERAYORGID;

		Object[] finderArgs = new Object[] { liferayOrgId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CEG_WHERE);

			query.append(_FINDER_COLUMN_LIFERAYORGID_LIFERAYORGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(liferayOrgId);

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

	private static final String _FINDER_COLUMN_LIFERAYORGID_LIFERAYORGID_2 = "ceg.liferayOrgId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PAGEURLAZON =
		new FinderPath(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegModelImpl.FINDER_CACHE_ENABLED, CegImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPageURLAzon",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAGEURLAZON =
		new FinderPath(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegModelImpl.FINDER_CACHE_ENABLED, CegImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPageURLAzon",
			new String[] { String.class.getName() },
			CegModelImpl.PAGEURLAZON_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_PAGEURLAZON = new FinderPath(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPageURLAzon",
			new String[] { String.class.getName() });

	/**
	 * Returns all the cegs where pageURLAzon = &#63;.
	 *
	 * @param pageURLAzon the page u r l azon
	 * @return the matching cegs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ceg> findByPageURLAzon(String pageURLAzon)
		throws SystemException {
		return findByPageURLAzon(pageURLAzon, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Ceg> findByPageURLAzon(String pageURLAzon, int start, int end)
		throws SystemException {
		return findByPageURLAzon(pageURLAzon, start, end, null);
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
	@Override
	public List<Ceg> findByPageURLAzon(String pageURLAzon, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAGEURLAZON;
			finderArgs = new Object[] { pageURLAzon };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PAGEURLAZON;
			finderArgs = new Object[] { pageURLAzon, start, end, orderByComparator };
		}

		List<Ceg> list = (List<Ceg>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Ceg ceg : list) {
				if (!Validator.equals(pageURLAzon, ceg.getPageURLAzon())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CEG_WHERE);

			boolean bindPageURLAzon = false;

			if (pageURLAzon == null) {
				query.append(_FINDER_COLUMN_PAGEURLAZON_PAGEURLAZON_1);
			}
			else if (pageURLAzon.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PAGEURLAZON_PAGEURLAZON_3);
			}
			else {
				bindPageURLAzon = true;

				query.append(_FINDER_COLUMN_PAGEURLAZON_PAGEURLAZON_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CegModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPageURLAzon) {
					qPos.add(pageURLAzon);
				}

				if (!pagination) {
					list = (List<Ceg>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Ceg>(list);
				}
				else {
					list = (List<Ceg>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first ceg in the ordered set where pageURLAzon = &#63;.
	 *
	 * @param pageURLAzon the page u r l azon
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ceg
	 * @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg findByPageURLAzon_First(String pageURLAzon,
		OrderByComparator orderByComparator)
		throws NoSuchCegException, SystemException {
		Ceg ceg = fetchByPageURLAzon_First(pageURLAzon, orderByComparator);

		if (ceg != null) {
			return ceg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("pageURLAzon=");
		msg.append(pageURLAzon);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCegException(msg.toString());
	}

	/**
	 * Returns the first ceg in the ordered set where pageURLAzon = &#63;.
	 *
	 * @param pageURLAzon the page u r l azon
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ceg, or <code>null</code> if a matching ceg could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg fetchByPageURLAzon_First(String pageURLAzon,
		OrderByComparator orderByComparator) throws SystemException {
		List<Ceg> list = findByPageURLAzon(pageURLAzon, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Ceg findByPageURLAzon_Last(String pageURLAzon,
		OrderByComparator orderByComparator)
		throws NoSuchCegException, SystemException {
		Ceg ceg = fetchByPageURLAzon_Last(pageURLAzon, orderByComparator);

		if (ceg != null) {
			return ceg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("pageURLAzon=");
		msg.append(pageURLAzon);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCegException(msg.toString());
	}

	/**
	 * Returns the last ceg in the ordered set where pageURLAzon = &#63;.
	 *
	 * @param pageURLAzon the page u r l azon
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ceg, or <code>null</code> if a matching ceg could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg fetchByPageURLAzon_Last(String pageURLAzon,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByPageURLAzon(pageURLAzon);

		if (count == 0) {
			return null;
		}

		List<Ceg> list = findByPageURLAzon(pageURLAzon, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Ceg[] findByPageURLAzon_PrevAndNext(long cegId, String pageURLAzon,
		OrderByComparator orderByComparator)
		throws NoSuchCegException, SystemException {
		Ceg ceg = findByPrimaryKey(cegId);

		Session session = null;

		try {
			session = openSession();

			Ceg[] array = new CegImpl[3];

			array[0] = getByPageURLAzon_PrevAndNext(session, ceg, pageURLAzon,
					orderByComparator, true);

			array[1] = ceg;

			array[2] = getByPageURLAzon_PrevAndNext(session, ceg, pageURLAzon,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ceg getByPageURLAzon_PrevAndNext(Session session, Ceg ceg,
		String pageURLAzon, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CEG_WHERE);

		boolean bindPageURLAzon = false;

		if (pageURLAzon == null) {
			query.append(_FINDER_COLUMN_PAGEURLAZON_PAGEURLAZON_1);
		}
		else if (pageURLAzon.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_PAGEURLAZON_PAGEURLAZON_3);
		}
		else {
			bindPageURLAzon = true;

			query.append(_FINDER_COLUMN_PAGEURLAZON_PAGEURLAZON_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CegModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindPageURLAzon) {
			qPos.add(pageURLAzon);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ceg);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Ceg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cegs where pageURLAzon = &#63; from the database.
	 *
	 * @param pageURLAzon the page u r l azon
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByPageURLAzon(String pageURLAzon)
		throws SystemException {
		for (Ceg ceg : findByPageURLAzon(pageURLAzon, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ceg);
		}
	}

	/**
	 * Returns the number of cegs where pageURLAzon = &#63;.
	 *
	 * @param pageURLAzon the page u r l azon
	 * @return the number of matching cegs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByPageURLAzon(String pageURLAzon) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_PAGEURLAZON;

		Object[] finderArgs = new Object[] { pageURLAzon };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CEG_WHERE);

			boolean bindPageURLAzon = false;

			if (pageURLAzon == null) {
				query.append(_FINDER_COLUMN_PAGEURLAZON_PAGEURLAZON_1);
			}
			else if (pageURLAzon.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_PAGEURLAZON_PAGEURLAZON_3);
			}
			else {
				bindPageURLAzon = true;

				query.append(_FINDER_COLUMN_PAGEURLAZON_PAGEURLAZON_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindPageURLAzon) {
					qPos.add(pageURLAzon);
				}

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

	private static final String _FINDER_COLUMN_PAGEURLAZON_PAGEURLAZON_1 = "ceg.pageURLAzon IS NULL";
	private static final String _FINDER_COLUMN_PAGEURLAZON_PAGEURLAZON_2 = "ceg.pageURLAzon = ?";
	private static final String _FINDER_COLUMN_PAGEURLAZON_PAGEURLAZON_3 = "(ceg.pageURLAzon IS NULL OR ceg.pageURLAzon = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYNAME =
		new FinderPath(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegModelImpl.FINDER_CACHE_ENABLED, CegImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME =
		new FinderPath(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegModelImpl.FINDER_CACHE_ENABLED, CegImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryName",
			new String[] { String.class.getName() },
			CegModelImpl.CATEGORY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYNAME = new FinderPath(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the cegs where category = &#63;.
	 *
	 * @param category the category
	 * @return the matching cegs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ceg> findByCategoryName(String category)
		throws SystemException {
		return findByCategoryName(category, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Ceg> findByCategoryName(String category, int start, int end)
		throws SystemException {
		return findByCategoryName(category, start, end, null);
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
	@Override
	public List<Ceg> findByCategoryName(String category, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME;
			finderArgs = new Object[] { category };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYNAME;
			finderArgs = new Object[] { category, start, end, orderByComparator };
		}

		List<Ceg> list = (List<Ceg>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Ceg ceg : list) {
				if (!Validator.equals(category, ceg.getCategory())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_CEG_WHERE);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CegModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategory) {
					qPos.add(category);
				}

				if (!pagination) {
					list = (List<Ceg>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Ceg>(list);
				}
				else {
					list = (List<Ceg>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Returns the first ceg in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ceg
	 * @throws dinet.orgsetup62.NoSuchCegException if a matching ceg could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg findByCategoryName_First(String category,
		OrderByComparator orderByComparator)
		throws NoSuchCegException, SystemException {
		Ceg ceg = fetchByCategoryName_First(category, orderByComparator);

		if (ceg != null) {
			return ceg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("category=");
		msg.append(category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCegException(msg.toString());
	}

	/**
	 * Returns the first ceg in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ceg, or <code>null</code> if a matching ceg could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg fetchByCategoryName_First(String category,
		OrderByComparator orderByComparator) throws SystemException {
		List<Ceg> list = findByCategoryName(category, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Ceg findByCategoryName_Last(String category,
		OrderByComparator orderByComparator)
		throws NoSuchCegException, SystemException {
		Ceg ceg = fetchByCategoryName_Last(category, orderByComparator);

		if (ceg != null) {
			return ceg;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("category=");
		msg.append(category);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCegException(msg.toString());
	}

	/**
	 * Returns the last ceg in the ordered set where category = &#63;.
	 *
	 * @param category the category
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ceg, or <code>null</code> if a matching ceg could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg fetchByCategoryName_Last(String category,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCategoryName(category);

		if (count == 0) {
			return null;
		}

		List<Ceg> list = findByCategoryName(category, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Ceg[] findByCategoryName_PrevAndNext(long cegId, String category,
		OrderByComparator orderByComparator)
		throws NoSuchCegException, SystemException {
		Ceg ceg = findByPrimaryKey(cegId);

		Session session = null;

		try {
			session = openSession();

			Ceg[] array = new CegImpl[3];

			array[0] = getByCategoryName_PrevAndNext(session, ceg, category,
					orderByComparator, true);

			array[1] = ceg;

			array[2] = getByCategoryName_PrevAndNext(session, ceg, category,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ceg getByCategoryName_PrevAndNext(Session session, Ceg ceg,
		String category, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CEG_WHERE);

		boolean bindCategory = false;

		if (category == null) {
			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORY_1);
		}
		else if (category.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORY_3);
		}
		else {
			bindCategory = true;

			query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORY_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CegModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindCategory) {
			qPos.add(category);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ceg);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Ceg> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the cegs where category = &#63; from the database.
	 *
	 * @param category the category
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCategoryName(String category) throws SystemException {
		for (Ceg ceg : findByCategoryName(category, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ceg);
		}
	}

	/**
	 * Returns the number of cegs where category = &#63;.
	 *
	 * @param category the category
	 * @return the number of matching cegs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCategoryName(String category) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CATEGORYNAME;

		Object[] finderArgs = new Object[] { category };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CEG_WHERE);

			boolean bindCategory = false;

			if (category == null) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORY_1);
			}
			else if (category.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORY_3);
			}
			else {
				bindCategory = true;

				query.append(_FINDER_COLUMN_CATEGORYNAME_CATEGORY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindCategory) {
					qPos.add(category);
				}

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

	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORY_1 = "ceg.category IS NULL";
	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORY_2 = "ceg.category = ?";
	private static final String _FINDER_COLUMN_CATEGORYNAME_CATEGORY_3 = "(ceg.category IS NULL OR ceg.category = '')";

	public CegPersistenceImpl() {
		setModelClass(Ceg.class);
	}

	/**
	 * Caches the ceg in the entity cache if it is enabled.
	 *
	 * @param ceg the ceg
	 */
	@Override
	public void cacheResult(Ceg ceg) {
		EntityCacheUtil.putResult(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegImpl.class, ceg.getPrimaryKey(), ceg);

		ceg.resetOriginalValues();
	}

	/**
	 * Caches the cegs in the entity cache if it is enabled.
	 *
	 * @param cegs the cegs
	 */
	@Override
	public void cacheResult(List<Ceg> cegs) {
		for (Ceg ceg : cegs) {
			if (EntityCacheUtil.getResult(CegModelImpl.ENTITY_CACHE_ENABLED,
						CegImpl.class, ceg.getPrimaryKey()) == null) {
				cacheResult(ceg);
			}
			else {
				ceg.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all cegs.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CegImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CegImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ceg.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Ceg ceg) {
		EntityCacheUtil.removeResult(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegImpl.class, ceg.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Ceg> cegs) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Ceg ceg : cegs) {
			EntityCacheUtil.removeResult(CegModelImpl.ENTITY_CACHE_ENABLED,
				CegImpl.class, ceg.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ceg with the primary key. Does not add the ceg to the database.
	 *
	 * @param cegId the primary key for the new ceg
	 * @return the new ceg
	 */
	@Override
	public Ceg create(long cegId) {
		Ceg ceg = new CegImpl();

		ceg.setNew(true);
		ceg.setPrimaryKey(cegId);

		return ceg;
	}

	/**
	 * Removes the ceg with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param cegId the primary key of the ceg
	 * @return the ceg that was removed
	 * @throws dinet.orgsetup62.NoSuchCegException if a ceg with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg remove(long cegId) throws NoSuchCegException, SystemException {
		return remove((Serializable)cegId);
	}

	/**
	 * Removes the ceg with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ceg
	 * @return the ceg that was removed
	 * @throws dinet.orgsetup62.NoSuchCegException if a ceg with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg remove(Serializable primaryKey)
		throws NoSuchCegException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Ceg ceg = (Ceg)session.get(CegImpl.class, primaryKey);

			if (ceg == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCegException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ceg);
		}
		catch (NoSuchCegException nsee) {
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
	protected Ceg removeImpl(Ceg ceg) throws SystemException {
		ceg = toUnwrappedModel(ceg);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ceg)) {
				ceg = (Ceg)session.get(CegImpl.class, ceg.getPrimaryKeyObj());
			}

			if (ceg != null) {
				session.delete(ceg);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ceg != null) {
			clearCache(ceg);
		}

		return ceg;
	}

	@Override
	public Ceg updateImpl(dinet.orgsetup62.model.Ceg ceg)
		throws SystemException {
		ceg = toUnwrappedModel(ceg);

		boolean isNew = ceg.isNew();

		CegModelImpl cegModelImpl = (CegModelImpl)ceg;

		Session session = null;

		try {
			session = openSession();

			if (ceg.isNew()) {
				session.save(ceg);

				ceg.setNew(false);
			}
			else {
				session.merge(ceg);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CegModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((cegModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { cegModelImpl.getOriginalAzon_u() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A,
					args);

				args = new Object[] { cegModelImpl.getAzon_u() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_A, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_A,
					args);
			}

			if ((cegModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIFERAYORGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cegModelImpl.getOriginalLiferayOrgId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIFERAYORGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIFERAYORGID,
					args);

				args = new Object[] { cegModelImpl.getLiferayOrgId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LIFERAYORGID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LIFERAYORGID,
					args);
			}

			if ((cegModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAGEURLAZON.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						cegModelImpl.getOriginalPageURLAzon()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PAGEURLAZON,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAGEURLAZON,
					args);

				args = new Object[] { cegModelImpl.getPageURLAzon() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PAGEURLAZON,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PAGEURLAZON,
					args);
			}

			if ((cegModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { cegModelImpl.getOriginalCategory() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME,
					args);

				args = new Object[] { cegModelImpl.getCategory() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYNAME,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYNAME,
					args);
			}
		}

		EntityCacheUtil.putResult(CegModelImpl.ENTITY_CACHE_ENABLED,
			CegImpl.class, ceg.getPrimaryKey(), ceg);

		return ceg;
	}

	protected Ceg toUnwrappedModel(Ceg ceg) {
		if (ceg instanceof CegImpl) {
			return ceg;
		}

		CegImpl cegImpl = new CegImpl();

		cegImpl.setNew(ceg.isNew());
		cegImpl.setPrimaryKey(ceg.getPrimaryKey());

		cegImpl.setCegId(ceg.getCegId());
		cegImpl.setAzon_r(ceg.getAzon_r());
		cegImpl.setSubAzon_r(ceg.getSubAzon_r());
		cegImpl.setCategory_r(ceg.getCategory_r());
		cegImpl.setOrgname_r(ceg.getOrgname_r());
		cegImpl.setAzon_u(ceg.getAzon_u());
		cegImpl.setSubAzon_u(ceg.getSubAzon_u());
		cegImpl.setLiferayOrgId(ceg.getLiferayOrgId());
		cegImpl.setOrgname(ceg.getOrgname());
		cegImpl.setLogo(ceg.getLogo());
		cegImpl.setCategoryId(ceg.getCategoryId());
		cegImpl.setCategory(ceg.getCategory());
		cegImpl.setPostalcode(ceg.getPostalcode());
		cegImpl.setCity(ceg.getCity());
		cegImpl.setStreet(ceg.getStreet());
		cegImpl.setContact(ceg.getContact());
		cegImpl.setWeb(ceg.getWeb());
		cegImpl.setDescription(ceg.getDescription());
		cegImpl.setHtmldescription(ceg.getHtmldescription());
		cegImpl.setKeywords(ceg.getKeywords());
		cegImpl.setPageURL(ceg.getPageURL());
		cegImpl.setPagename(ceg.getPagename());
		cegImpl.setDate(ceg.getDate());
		cegImpl.setPageURLAzon(ceg.getPageURLAzon());

		return cegImpl;
	}

	/**
	 * Returns the ceg with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ceg
	 * @return the ceg
	 * @throws dinet.orgsetup62.NoSuchCegException if a ceg with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCegException, SystemException {
		Ceg ceg = fetchByPrimaryKey(primaryKey);

		if (ceg == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCegException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ceg;
	}

	/**
	 * Returns the ceg with the primary key or throws a {@link dinet.orgsetup62.NoSuchCegException} if it could not be found.
	 *
	 * @param cegId the primary key of the ceg
	 * @return the ceg
	 * @throws dinet.orgsetup62.NoSuchCegException if a ceg with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg findByPrimaryKey(long cegId)
		throws NoSuchCegException, SystemException {
		return findByPrimaryKey((Serializable)cegId);
	}

	/**
	 * Returns the ceg with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ceg
	 * @return the ceg, or <code>null</code> if a ceg with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Ceg ceg = (Ceg)EntityCacheUtil.getResult(CegModelImpl.ENTITY_CACHE_ENABLED,
				CegImpl.class, primaryKey);

		if (ceg == _nullCeg) {
			return null;
		}

		if (ceg == null) {
			Session session = null;

			try {
				session = openSession();

				ceg = (Ceg)session.get(CegImpl.class, primaryKey);

				if (ceg != null) {
					cacheResult(ceg);
				}
				else {
					EntityCacheUtil.putResult(CegModelImpl.ENTITY_CACHE_ENABLED,
						CegImpl.class, primaryKey, _nullCeg);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CegModelImpl.ENTITY_CACHE_ENABLED,
					CegImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ceg;
	}

	/**
	 * Returns the ceg with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param cegId the primary key of the ceg
	 * @return the ceg, or <code>null</code> if a ceg with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ceg fetchByPrimaryKey(long cegId) throws SystemException {
		return fetchByPrimaryKey((Serializable)cegId);
	}

	/**
	 * Returns all the cegs.
	 *
	 * @return the cegs
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ceg> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Ceg> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Ceg> findAll(int start, int end,
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

		List<Ceg> list = (List<Ceg>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CEG);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CEG;

				if (pagination) {
					sql = sql.concat(CegModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Ceg>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Ceg>(list);
				}
				else {
					list = (List<Ceg>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the cegs from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Ceg ceg : findAll()) {
			remove(ceg);
		}
	}

	/**
	 * Returns the number of cegs.
	 *
	 * @return the number of cegs
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

				Query q = session.createQuery(_SQL_COUNT_CEG);

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

	@Override
	protected Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	/**
	 * Initializes the ceg persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.dinet.orgsetup62.model.Ceg")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Ceg>> listenersList = new ArrayList<ModelListener<Ceg>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Ceg>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(CegImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CEG = "SELECT ceg FROM Ceg ceg";
	private static final String _SQL_SELECT_CEG_WHERE = "SELECT ceg FROM Ceg ceg WHERE ";
	private static final String _SQL_COUNT_CEG = "SELECT COUNT(ceg) FROM Ceg ceg";
	private static final String _SQL_COUNT_CEG_WHERE = "SELECT COUNT(ceg) FROM Ceg ceg WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ceg.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Ceg exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Ceg exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CegPersistenceImpl.class);
	private static Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"date"
			});
	private static Ceg _nullCeg = new CegImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Ceg> toCacheModel() {
				return _nullCegCacheModel;
			}
		};

	private static CacheModel<Ceg> _nullCegCacheModel = new CacheModel<Ceg>() {
			@Override
			public Ceg toEntityModel() {
				return _nullCeg;
			}
		};
}