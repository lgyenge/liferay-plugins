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
String backURL = ParamUtil.getString(request, "backURL");

long userId = ParamUtil.getLong(request, "userId");

themeDisplay.setIncludeServiceJs(true); // to enable dynamic selectors

/* 
User user2 = null;

if (userId > 0) {
	user2 = UserLocalServiceUtil.getUser(userId);
}
else {
	user2 = (User)request.getAttribute(WebKeys.CONTACTS_USER);
}

user2 = user2.toEscapedModel();

request.setAttribute("view_user.jsp-user", user2);
 */
%>

<%
Organization organization = null;
Group group = themeDisplay.getScopeGroup();
if (group.isOrganization()) {
	organization = OrganizationLocalServiceUtil.getOrganization(group.getClassPK());	
}
organization = organization.toEscapedModel();
request.setAttribute("view_organization", organization); 
// String currentURL = PortalUtil.getCurrentURL(request);
%>


<c:if test="<%= organization != null %>">
	<div class="contacts-profile <%= (true) ? "my-profile" : StringPool.BLANK %>" id="<portlet:namespace />organizationProfile">
		<c:if test="<%= (displayStyle == OrganizationportletConstants.DISPLAY_STYLE_BASIC) || (displayStyle == OrganizationportletConstants.DISPLAY_STYLE_FULL) %>">
			
			<div class="lfr-detail-info field-group" data-sectionId="details" data-title="<%= LanguageUtil.get(pageContext, "details") %>">
				<c:if test="<%= showIcon %>">
					<div class="lfr-contact-thumb">
<%-- 						<a href="<%= currentURL %>" title="<%=organization.getName()%>"><img	alt="<%=organization.getName()%>" src="<%=themeDisplay.getLayoutSetLogo()%>" /></a> --%>
						<img	alt="<%=organization.getName()%>" src="<%=themeDisplay.getLayoutSetLogo()%>" />
					</div>
				</c:if>

				<%-- <div class="<%= showIcon ? StringPool.BLANK : "no-icon" %> lfr-contact-info">
					<div class="lfr-contact-name">
						<a href="<%= user2.getDisplayURL(themeDisplay) %>"><%= user2.getFullName() %></a>
					</div>

					<div class="lfr-contact-job-title">
						<%= user2.getJobTitle() %>
					</div>

					<div class="lfr-contact-extra">
						<a href="mailto:<%= user2.getEmailAddress() %>"><%= user2.getEmailAddress() %></a>
					</div>
				</div>

				<div class="clear"><!-- --></div> --%>
			</div>
		</c:if>

		<c:if test="<%= ((displayStyle == OrganizationportletConstants.DISPLAY_STYLE_DETAIL) || (displayStyle == OrganizationportletConstants.DISPLAY_STYLE_FULL) ||  showCompleteYourProfile) && UserPermissionUtil.contains(permissionChecker, user.getUserId(), ActionKeys.VIEW) %>">
			<div class="user-information" id="<portlet:namespace />organizationInformation">
				<aui:layout>
					<c:if test="<%= showUsersInformation %>">
						<aui:column columnWidth="<%= showSites ? 80 : 100 %>" cssClass="user-information-column-1">
							<div class="user-information-title">
								<liferay-ui:message key="about" />
							</div>

							<div class="lfr-user-info-container">
								<liferay-util:include page="/html/organizationprofile/view_organization_information.jsp" servletContext="<%= application %>" />
							</div>

							<%
							Map<String, String> extensions = ContactsExtensionsUtil.getExtensions();

							Set<String> servletContextNames = extensions.keySet();

							request.setAttribute("view_user.jsp-showCompleteYourProfile", String.valueOf(showCompleteYourProfile));

							for (String servletContextName : servletContextNames) {
								String extensionPath = extensions.get(servletContextName);

								ServletContext extensionServletContext = ServletContextPool.get(servletContextName);

								String title = extensionPath.substring(extensionPath.lastIndexOf(StringPool.SLASH) + 1, extensionPath.lastIndexOf(StringPool.PERIOD));

								title = title.replace(CharPool.UNDERLINE, CharPool.DASH);

								String cssClass = "lfr-" + title + "-container";
							%>

								<div class="user-information-title">
									<liferay-ui:message key="<%= title %>" />
								</div>

								<liferay-util:include page="<%= extensionPath %>" servletContext="<%= extensionServletContext %>" />

							<%
							}
							%>

						</aui:column>
					</c:if>

					<c:if test="<%= showTags %>">
						<aui:column columnWidth="<%= showUsersInformation ? 20 : 100 %>" cssClass="user-information-column-2">
							<div class="user-tags-title">
								<liferay-ui:message key="tags" />
							</div>

							<%
							List<AssetTag> assetTags = AssetTagLocalServiceUtil.getTags(Organization.class.getName(), organization.getOrganizationId());
							%>

							<c:choose>
								<c:when test="<%= !assetTags.isEmpty() %>">
									<div class="field-group" data-sectionId="categorization" data-title="<%= LanguageUtil.get(pageContext, "tags") %>">
										<ul class="user-tags">

											<%
											StringBuilder sb = new StringBuilder();

											for (AssetTag assetTag : assetTags) {
												PortletURL searchURL = ((LiferayPortletResponse)renderResponse).createRenderURL("3");

												searchURL.setWindowState(WindowState.MAXIMIZED);

												searchURL.setParameter("groupId", "0");
												searchURL.setParameter("keywords", assetTag.getName());
												searchURL.setParameter("struts_action", "/search/search");

												sb.append("<li><a href=\"");
												sb.append(searchURL);
												sb.append("\">");
												sb.append(assetTag.getName());
												sb.append("</a></li>");
											}
											%>

											<%= sb.toString() %>
										</ul>
									</div>
								</c:when>
								<c:otherwise>

									<%
// 										Group group = themeDisplay.getScopeGroup();
										%>

									<liferay-ui:message arguments="<%= HtmlUtil.escape(PortalUtil.getUserName(organization.getOrganizationId(), group.getDescriptiveName(locale))) %>" key="x-does-not-have-any-tags" />
								</c:otherwise>
							</c:choose>
						</aui:column>
					</c:if>
				</aui:layout>
			</div>

			<%-- <c:if test="<%= showRecentActivity && UserPermissionUtil.contains(permissionChecker, user2.getUserId(), ActionKeys.VIEW) %>">
				<div class="user-information-title">
					<liferay-ui:message key="recent-activity" />
				</div>

				<liferay-ui:social-activities
					activities="<%= SocialActivityLocalServiceUtil.getUserActivities(user2.getUserId(), 0, 10) %>"
					feedEnabled="<%= false %>"
				/>
			</c:if> --%>
		</c:if>
	</div>
</c:if>

	

<%-- <c:if test="<%= themeDisplay.getUserId() == user2.getUserId() %>"> --%>
	<aui:script use="aui-base,aui-dialog">
			var organizationProfile = A.one('#<portlet:namespace />organizationProfile');

			organizationProfile.delegate(
				'click',
				function(event) {
					var node = event.target;

					var tagName = node.get('tagName');

					if (!tagName || (tagName.toLowerCase() != 'a')) {
						<portlet:namespace />openDialog(event);
					}
				},
				'.field-group, .action-field'
			);

			var <portlet:namespace />openDialog = function(event) {
				var node = event.currentTarget;

				var uri = '<portlet:renderURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>"><portlet:param name="mvcPath" value="/html/organizationprofile/edit_organization_dialogs.jsp" /></portlet:renderURL>';

				if (node.getAttribute('data-sectionId')) {
					uri = Liferay.Util.addParams('curSectionId=' + node.getAttribute('data-sectionId'), uri) || uri;
				}

				if (node.getAttribute('data-extension')) {
					uri = Liferay.Util.addParams('extension=' + node.getAttribute('data-extension'), uri) || uri;
				}

				var dialog = new A.Dialog(
					{
						align: {
							node: null,
							points: ['tc', 'tc']
						},
						constrain2view: true,
						cssClass: 'profile-dialog',
						destroyOnClose: true,
						modal: true,
						resizable: false,
						title: node.getAttribute('data-title'),
						width: 500
					}
				).plug(
					A.Plugin.IO,
					{
						uri: uri
					}
				).render();
			};
	</aui:script>
<%-- </c:if> --%>