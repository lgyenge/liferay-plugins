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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import dinet.orgsetup62.model.CegClp;
import dinet.orgsetup62.model.FooClp;
import dinet.orgsetup62.model.OrgClp;
import dinet.orgsetup62.model.ProductClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gyengelaszlo
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"orgsetup62-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"orgsetup62-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "orgsetup62-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(CegClp.class.getName())) {
			return translateInputCeg(oldModel);
		}

		if (oldModelClassName.equals(FooClp.class.getName())) {
			return translateInputFoo(oldModel);
		}

		if (oldModelClassName.equals(OrgClp.class.getName())) {
			return translateInputOrg(oldModel);
		}

		if (oldModelClassName.equals(ProductClp.class.getName())) {
			return translateInputProduct(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputCeg(BaseModel<?> oldModel) {
		CegClp oldClpModel = (CegClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCegRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFoo(BaseModel<?> oldModel) {
		FooClp oldClpModel = (FooClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFooRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputOrg(BaseModel<?> oldModel) {
		OrgClp oldClpModel = (OrgClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getOrgRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProduct(BaseModel<?> oldModel) {
		ProductClp oldClpModel = (ProductClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProductRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals("dinet.orgsetup62.model.impl.CegImpl")) {
			return translateOutputCeg(oldModel);
		}

		if (oldModelClassName.equals("dinet.orgsetup62.model.impl.FooImpl")) {
			return translateOutputFoo(oldModel);
		}

		if (oldModelClassName.equals("dinet.orgsetup62.model.impl.OrgImpl")) {
			return translateOutputOrg(oldModel);
		}

		if (oldModelClassName.equals("dinet.orgsetup62.model.impl.ProductImpl")) {
			return translateOutputProduct(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("dinet.orgsetup62.NoSuchCegException")) {
			return new dinet.orgsetup62.NoSuchCegException();
		}

		if (className.equals("dinet.orgsetup62.NoSuchFooException")) {
			return new dinet.orgsetup62.NoSuchFooException();
		}

		if (className.equals("dinet.orgsetup62.NoSuchOrgException")) {
			return new dinet.orgsetup62.NoSuchOrgException();
		}

		if (className.equals("dinet.orgsetup62.NoSuchProductException")) {
			return new dinet.orgsetup62.NoSuchProductException();
		}

		return throwable;
	}

	public static Object translateOutputCeg(BaseModel<?> oldModel) {
		CegClp newModel = new CegClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCegRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFoo(BaseModel<?> oldModel) {
		FooClp newModel = new FooClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFooRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputOrg(BaseModel<?> oldModel) {
		OrgClp newModel = new OrgClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setOrgRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProduct(BaseModel<?> oldModel) {
		ProductClp newModel = new ProductClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProductRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}