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
// request.setAttribute("view_user.jsp-user", user2);
Organization organization = (Organization)request.getAttribute("view_organization");

// Contact contact2 = user2.getContact();

boolean incompleteProfile = false;

List<AssetTag> assetTags = AssetTagLocalServiceUtil.getTags(Organization.class.getName(), organization.getOrganizationId());

if (assetTags.isEmpty()) {
	incompleteProfile = true;
}

if (Validator.isNull(organization.getComments())) {
	incompleteProfile = true;
}
%>

<c:if test="<%= showComments && Validator.isNotNull(organization.getComments()) %>">
	<div class="section field-group lfr-user-comments" data-sectionId="comments" data-title="<%= LanguageUtil.get(pageContext, "introduction") %>">
		<h3><liferay-ui:message key="introduction" />:</h3>

		<ul class="property-list">
			<li>
				<span class="property"><%= organization.getComments() %></span>
			</li>
		</ul>
	</div>
</c:if>




<%
List<Phone> phones = PhoneServiceUtil.getPhones(Organization.class.getName(), organization.getOrganizationId());

if (phones.isEmpty()) {
	incompleteProfile = true;
}
%>

<c:if test="<%= showPhones && !phones.isEmpty() %>">
	<div class="section field-group lfr-user-phones" data-sectionId="phoneNumbers" data-title="<%= LanguageUtil.get(pageContext, "phone-numbers") %>">
		<h3><liferay-ui:message key="phones" />:</h3>

		<ul class="property-list">

			<%
			for (Phone phone: phones) {
			%>

				<li class="<%= phone.isPrimary() ? "primary" : "" %>">
					<span class="property-type"><%= LanguageUtil.get(pageContext, phone.getType().getName()) %></span>
					<span class="property"><%= HtmlUtil.escape(phone.getNumber()) %> <%= phone.getExtension() %></span>
				</li>

			<%
			}
			%>

		</ul>
	</div>
</c:if>


<%
List<EmailAddress> emailAddresses = EmailAddressServiceUtil.getEmailAddresses(Organization.class.getName(), organization.getOrganizationId());

if (emailAddresses.isEmpty()) {
	incompleteProfile = true;
}
%>

<c:if test="<%= showAdditionalEmailAddresses && !emailAddresses.isEmpty() %>">
	<div class="section field-group lfr-user-email-addresses" data-sectionId="additionalEmailAddresses" data-title="<%= LanguageUtil.get(pageContext, "additional-email-addresses") %>">
		<h3><liferay-ui:message key="additional-email-addresses" />:</h3>

		<ul class="property-list">

			<%
			for (int i = 0; i < emailAddresses.size(); i++) {
				EmailAddress emailAddress = emailAddresses.get(i);
			%>

				<li class="<%= emailAddress.isPrimary() ? "primary" : "" %>">
					<span class="property-type"><%= LanguageUtil.get(pageContext, emailAddress.getType().getName()) %></span>
					<span class="property"><a href="mailto:<%= emailAddress.getAddress() %>"><%= emailAddress.getAddress() %></a></span>
				</li>

			<%
			}
			%>

		</ul>
	</div>
</c:if>

 


<%
List<Address> addresses = AddressServiceUtil.getAddresses(Organization.class.getName(), organization.getOrganizationId());

if (addresses.isEmpty()) {
	incompleteProfile = true;
}
%>

<c:if test="<%= showAddresses && !addresses.isEmpty() %>">
	<div class="section field-group lfr-user-addresses" data-sectionId="addresses" data-title="<%= LanguageUtil.get(pageContext, "addresses") %>">
		<h3><liferay-ui:message key="addresses" />:</h3>

		<ul class="property-list">

			<%
			for (Address address: addresses) {
				String street1 = address.getStreet1();
				String street2 = address.getStreet2();
				String street3 = address.getStreet3();

				String zipCode = address.getZip();
				String city = address.getCity();

				Country country = address.getCountry();

				String countryName = StringPool.BLANK;

				if (country != null) {
					countryName = country.getName();
				}

				Region region = address.getRegion();

				String regionName = StringPool.BLANK;

				if (region != null) {
					regionName = region.getName();
				}

				String mailingName = LanguageUtil.get(pageContext, address.getType().getName());
			%>

				<li class="<%= address.isPrimary() ? "primary" : "" %>">
					<span class="property-type"><%= mailingName %></span>

					<c:if test="<%= Validator.isNotNull(street1) %>">
						<%= HtmlUtil.escape(street1) %>,
					</c:if>

					<c:if test="<%= Validator.isNotNull(street2) %>">
						<%= HtmlUtil.escape(street2) %>,
					</c:if>

					<c:if test="<%= Validator.isNotNull(street3) %>">
						<%= HtmlUtil.escape(street3) %>,
					</c:if>

					<c:if test="<%= Validator.isNotNull(city) %>">
						<%= HtmlUtil.escape(city) %>,
					</c:if>

					<c:if test="<%= Validator.isNotNull(zipCode) %>">
						<%= HtmlUtil.escape(zipCode) %>,
					</c:if>

					<c:if test="<%= Validator.isNotNull(regionName) %>">
						<%= regionName %>,
					</c:if>

					<c:if test="<%= Validator.isNotNull(countryName) %>">
						<%= countryName %>
					</c:if>

					<c:if test="<%= address.isMailing() %>">(<liferay-ui:message key="mailing" />)</c:if>
				</li>

			<%
			}
			%>

		</ul>
	</div>
</c:if>

<%
List<Website> websites = WebsiteServiceUtil.getWebsites(Organization.class.getName(), organization.getOrganizationId());

if (websites.isEmpty()) {
	incompleteProfile = true;
}
%>

<c:if test="<%= showWebsites && !websites.isEmpty() %>">
	<div class="section field-group lfr-user-websites" data-sectionId="websites" data-title="<%= LanguageUtil.get(pageContext, "websites") %>">
		<h3><liferay-ui:message key="websites" />:</h3>

		<ul class="property-list">

			<%
			for (Website website : websites) {
				website = website.toEscapedModel();
			%>

				<li class="<%= website.isPrimary() ? "primary" : "" %>">
					<span class="property-type"><%= LanguageUtil.get(pageContext, website.getType().getName()) %></span>

					<span class="property"><a href="<%= website.getUrl() %>"><%= website.getUrl() %></a></span>
				</li>

			<%
			}
			%>

		</ul>
	</div>
</c:if>


<%-- <c:if test="<%= incompleteProfile && showCompleteYourProfile && UserPermissionUtil.contains(permissionChecker, user.getUserId(), ActionKeys.VIEW)(themeDisplay.getUserId() == user2.getUserId()) %>"> --%>
<c:if test="<%= incompleteProfile && showCompleteYourProfile && UserPermissionUtil.contains(permissionChecker, user.getUserId(), ActionKeys.VIEW) %>">
	
</c:if>

<%@ include file="/html/organizationprofile/complete_your_profile.jspf" %>
 