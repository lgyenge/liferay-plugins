package dinet.orgsetup62;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.model.Company;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class OrgSetup621
 */
public class OrgSetup621 extends MVCPortlet {
	public void setupOrganization621(ActionRequest request, ActionResponse response)
			throws Exception {
		if (!isFirstRun()) {
			SessionErrors.add(request, "not-first-run-error");
			return;
		}
		
//		import categories excel to  liferay asset categories
//		OrganizationSetupUtil.importCategoryes(); 

//		load organizatios from excel to  database helper table 
//		OrganizationSetupUtil.importOrgData(); 
		
//		load ceg from excel to  database helper table 
//		OrganizationSetupUtil.importCegData(); 
		
//		load Procucts from excel to  database helper table 
//		OrganizationSetupUtil.importProductData(); 
		
//		setup appropriate categories from Liferay asset categories to Ceg helper table
//		OrganizationSetupUtil.setupOrgCategories();
		
//		create PageURLId in product table ( forign key to ceg helper table)
//		OrganizationSetupUtil.setupProductPageURL();
		
//		create CegURLId in Ceg table 
//		OrganizationSetupUtil.setupCegPageURL();
		
//		import organizations to liferay (not 7Cogs)		
		OrganizationSetupUtil.setupOrganization(); // upgrade(UpgradeCompany.class);
		// SessionMessages.add(request, "organization-upgraded-successfully");
	}

	protected boolean isFirstRun() throws Exception {
		List<Company> companies = CompanyLocalServiceUtil.getCompanies();

		if (companies.isEmpty() || companies.size() > 1) {
			return false;
		}

		Company company = companies.get(0);

		long companyId = company.getCompanyId();

		try {

			// If Bruno exists, do not run again

			UserLocalServiceUtil.getUserByScreenName(companyId, "bruno");

			return false;
		}
		catch (NoSuchUserException nsue) {
		}

		return true;
	} 
 

}
