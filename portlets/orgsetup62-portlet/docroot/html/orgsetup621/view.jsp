<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<%@include file="/init.jsp"%>

This is the <b>Org Setup621</b> portlet in View mode.

<portlet:actionURL name="setupOrganization621" var="setupOrganizationURL" />
<aui:form action="<%=setupOrganizationURL.toString()%>" method="post">
	<aui:fieldset>
		<aui:input name="organizationName" size="45" />
		<aui:input name="organizationId" size="45" />
		<aui:button-row>
			<aui:button type="submit" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>



