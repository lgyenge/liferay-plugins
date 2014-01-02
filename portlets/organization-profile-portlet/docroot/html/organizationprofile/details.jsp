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

<%
 User selUser = (User)request.getAttribute("user.selUser");
long groupId = 0;
// Organization organization = (Organization)request.getAttribute("WebKeys.ORGANIZATION");
Organization organization = (Organization)request.getAttribute("ORGANIZATION");

if (organization != null) {
	Group group = organization.getGroup();

	groupId = group.getGroupId();
}
%>

<%-- <aui:model-context bean="<%= selUser %>" model="<%= User.class %>" /> --%>
<aui:model-context bean="<%= organization %>" model="<%= Organization.class %>" />

<h3><liferay-ui:message key="details" /></h3>

<aui:fieldset column="<%= true %>" cssClass="aui-w50">
<%-- 	<aui:input name="screenName" /> --%>
	<aui:input name="Name" />

	<aui:input bean="<%= organization %>" model="<%= Organization.class %>" name="name">
		<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.USERS_EMAIL_ADDRESS_REQUIRED) %>">
			<aui:validator name="required" />
		</c:if>
	</aui:input>

	<%-- <aui:input name="firstName" />

	<aui:input name="middleName" />

	<aui:input name="lastName" />

	<aui:input name="jobTitle" /> --%>
</aui:fieldset>

<aui:fieldset column="<%= true %>" cssClass="aui-w50">
	<div class="user-profile-image" id="<portlet:namespace />userProfileImage">
		<c:if test="<%= selUser != null %>">

			<%
			Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), GroupConstants.CONTROL_PANEL);

			long controlPanelPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);
			%>

			<%-- <liferay-portlet:renderURL plid="<%= controlPanelPlid %>" portletName="<%= PortletKeys.MY_ACCOUNT %>" refererPlid="<%= plid %>" var="editUserPortraitURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
				<portlet:param name="struts_action" value="/my_account/edit_user_portrait" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="p_u_i_d" value="<%= String.valueOf(selUser.getUserId()) %>" />
				<portlet:param name="portrait_id" value="<%= String.valueOf(selUser.getPortraitId()) %>" />
			</liferay-portlet:renderURL>

			<liferay-ui:logo-selector
				defaultLogoURL="<%= UserConstants.getPortraitURL(themeDisplay.getPathImage(), selUser.isMale(), 0) %>"
				editLogoURL="<%= editUserPortraitURL %>"
				imageId="<%= selUser.getPortraitId() %>"
				logoDisplaySelector=".user-logo"
				showBackground="<%= false %>"
			/> --%>
		</c:if>
	</div>
</aui:fieldset>

<aui:fieldset column="<%= true %>" cssClass="aui-w50">
	<div class="user-profile-image" id="<portlet:namespace />userProfileImage">
		<c:if test="<%= organization != null %>">

			<%
			long logoId = 0;

			LayoutSet publicLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, false);
			LayoutSet privateLayoutSet = LayoutSetLocalServiceUtil.getLayoutSet(groupId, true);

			if (publicLayoutSet.getLogoId() > 0) {
				logoId = publicLayoutSet.getLogoId();
			}
			else if (privateLayoutSet.getLogoId() > 0) {
				logoId = privateLayoutSet.getLogoId();
			}
			
			
			Group controlPanelGroup = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), GroupConstants.CONTROL_PANEL);

			long controlPanelPlid = LayoutLocalServiceUtil.getDefaultPlid(controlPanelGroup.getGroupId(), true);
			
			
			%>

<%-- 			<liferay-portlet:renderURL plid="<%= controlPanelPlid %>" portletName="<%= PortletKeys.MY_ACCOUNT %>" refererPlid="<%= plid %>" var="editUserPortraitURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>"> --%>

<%-- 			<liferay-portlet:renderURL plid="<%= controlPanelPlid %>" portletName="<%= PortletKeys.MY_ACCOUNT %>" refererPlid="<%= plid %>" var="editOrganizationLogoURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">	 --%>
<%-- 				<portlet:param name="struts_action" value="/my_account/edit_user_portrait" /> --%>
			<liferay-portlet:renderURL plid="<%= controlPanelPlid %>" portletName="<%= PortletKeys.USERS_ADMIN %>" refererPlid="<%= plid %>" var="editOrganizationLogoURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">				
				<portlet:param name="struts_action" value="/users_admin/edit_organization_logo" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
<%-- 				<portlet:param name="p_u_i_d" value="<%= String.valueOf(selUser.getUserId()) %>" /> --%>
<%-- 				<portlet:param name="portrait_id" value="<%= String.valueOf(selUser.getPortraitId()) %>" /> --%>
				<portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" />
				<portlet:param name="publicLayoutSetId" value="<%= String.valueOf(publicLayoutSet.getLayoutSetId()) %>" />
			</liferay-portlet:renderURL>
			
	
		<%-- 	
			<portlet:renderURL var="editOrganizationLogoURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
				<portlet:param name="struts_action" value="/users_admin/edit_organization_logo" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" />
				<portlet:param name="publicLayoutSetId" value="<%= String.valueOf(publicLayoutSet.getLayoutSetId()) %>" />
			</portlet:renderURL>
 --%>
			
	
			<liferay-ui:logo-selector
				defaultLogoURL='<%= themeDisplay.getPathImage() + "/organization_logo?img_id=0" %>'
				editLogoURL="<%= editOrganizationLogoURL %>"
				imageId="<%= logoId %>"
				logoDisplaySelector=".organization-logo"
				showBackground="<%= false %>"
			/>
		</c:if>
	</div>
</aui:fieldset>


<aui:script use="aui-base">
	window['<%= PortalUtil.getPortletNamespace(PortletKeys.MY_ACCOUNT) %>changeLogo'] = function(logoURL) {
		var avatarDialog = A.one('#<portlet:namespace />userProfileImage .avatar');

		if (avatarDialog) {
			avatarDialog.attr('src', logoURL);
		}

		var avatarSidebar = A.one('#so-sidebar .profile-image img');

		if (avatarSidebar) {
			avatarSidebar.attr('src', logoURL);
		}

		var avatarDockbar = A.one('.user-fullname.user-portrait img');

		if (avatarDockbar) {
			avatarDockbar.attr('src', logoURL);
		}
	}
</aui:script>