<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This file is part of Liferay Social Office. Liferay Social Office is free
 * software: you can redistribute it and/or modify it under the terms of the GNU
 * Affero General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * Liferay Social Office is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Liferay Social Office. If not, see http://www.gnu.org/licenses/agpl-3.0.html.
 */
--%>

<%@ include file="/init.jsp" %>

<%--
		System.out.println(group);

--%>

 	
This is the <b>Organization Profile Portlet</b> portlet in View mode.

<%
	Group group = themeDisplay.getScopeGroup();
String visszateroURL = themeDisplay.getURLCurrent() ;
request.setAttribute("visszateroURL", visszateroURL);
%>

<c:choose>
	<c:when test="<%=group.isOrganization()%>">

		<aui:layout cssClass="contacts-container">
			<liferay-util:include page="/html/organizationprofile/view_organization.jsp" servletContext="<%=application%>" />
		</aui:layout>
	</c:when>
	<c:otherwise>
		<div class="lfr-message-info">
			<liferay-ui:message key="this-application-will-only-function-when-placed-on-an-organization-page" />
		</div>
	</c:otherwise>
</c:choose>