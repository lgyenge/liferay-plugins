package dinet.orgsetup62;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.OrganizationConstants;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalThreadLocal;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.AddressLocalServiceUtil;
import com.liferay.portal.service.EmailAddressLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.OrganizationLocalServiceUtil;
// gyl 2013_12_17 kivéve import com.liferay.portal.service.PermissionLocalServiceUtil;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.WebsiteLocalServiceUtil;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleConstants;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.model.JournalTemplate;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;
import com.liferay.portlet.journal.service.JournalTemplateLocalServiceUtil;
import com.liferay.portlet.messageboards.model.MBCategory;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageConstants;
import com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;
import com.liferay.portlet.social.model.SocialActivityCounter;
import com.liferay.portlet.social.model.SocialActivityCounterConstants;
import com.liferay.portlet.social.model.SocialRequest;
import com.liferay.portlet.social.model.SocialRequestConstants;
import com.liferay.portlet.social.service.SocialActivityCounterLocalServiceUtil;
import com.liferay.portlet.social.service.SocialActivitySettingLocalServiceUtil;
import com.liferay.portlet.social.service.SocialRequestLocalServiceUtil;
import com.liferay.portlet.social.util.SocialCounterPeriodUtil;
import com.liferay.portlet.wiki.model.WikiNode;
import com.liferay.portlet.wiki.model.WikiPage;
import com.liferay.portlet.wiki.service.WikiNodeLocalServiceUtil;
import com.liferay.portlet.wiki.service.WikiPageLocalServiceUtil;


// POI excel
//import org.apache.poi.hssf.usermodel.XSSFSheet;
//import org.apache.poi.hssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dinet.orgsetup62.model.Org;
import dinet.orgsetup62.model.impl.OrgImpl;
import dinet.orgsetup62.service.OrgLocalServiceUtil;
import dinet.orgsetup62.model.Ceg;
import dinet.orgsetup62.model.impl.CegImpl;
import dinet.orgsetup62.service.CegLocalServiceUtil;
import dinet.orgsetup62.model.Product;
import dinet.orgsetup62.model.impl.ProductImpl;
import dinet.orgsetup62.service.ProductLocalServiceUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Date;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;


import javax.portlet.PortletPreferences;


public class OrganizationSetupUtil {

	// public class UpgradeCompany extends UpgradeProcess {

		protected static AssetCategory addAssetCategory(long userId,
				long parentCategoryId, String title, long vocabularyId,
				ServiceContext serviceContext) throws Exception {

			Map<Locale, String> titleMap = new HashMap<Locale, String>();

			setLocalizedValue(titleMap, title);

			return AssetCategoryLocalServiceUtil.addCategory(userId,
					parentCategoryId, titleMap, null, vocabularyId, null,
					serviceContext);
		}

		protected static AssetVocabulary addAssetVocabulary(long userId,
				String title, ServiceContext serviceContext) throws Exception {

			Map<Locale, String> titleMap = new HashMap<Locale, String>();

			setLocalizedValue(titleMap, title);

			return AssetVocabularyLocalServiceUtil.addVocabulary(userId,
					StringPool.BLANK, titleMap, null, null, serviceContext);
		}

		protected static BlogsEntry addBlogsEntry(long userId, String title,
				String fileName, ServiceContext serviceContext) throws Exception {

			String content = getString(fileName);

			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);

			return BlogsEntryLocalServiceUtil.addEntry(userId, title,
					StringPool.BLANK, content, 1, 1, 2008, 0, 0, false, false,
					new String[0], false, null, null, null, serviceContext);
		}

		protected static FileEntry addDLFileEntry(long userId, long groupId,
				long folderId, String fileName, String name, String mimeType,
				String title, String description, ServiceContext serviceContext)
				throws Exception {

			byte[] bytes = getBytes(fileName);

			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(false);

			try {
				return DLAppLocalServiceUtil.addFileEntry(userId, groupId,
						folderId, fileName, mimeType, title, description,
						StringPool.BLANK, bytes, serviceContext);
			} catch (DuplicateFileException dfe) {
				return DLAppLocalServiceUtil.updateFileEntry(userId, groupId, name,
						mimeType, title, description, StringPool.BLANK, true,
						bytes, serviceContext);
			}
		}

		protected static FileEntry addDLFileEntry(long userId, long folderId,
				String filePath, ServiceContext serviceContext) throws Exception {

			String fileName = StringUtil.extractLast(filePath, StringPool.SLASH);

			byte[] bytes = getBytes(filePath);

			return DLAppLocalServiceUtil.addFileEntry(userId,
					serviceContext.getScopeGroupId(), folderId, fileName,
					"image/png", fileName, StringPool.BLANK, StringPool.BLANK,
					bytes, serviceContext);
		}

		protected static Folder addDLFolder(long userId, long groupId, String name,
				String description) throws Exception {

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(false);

			return DLAppLocalServiceUtil.addFolder(userId, groupId, 0, name,
					description, serviceContext);
		}

		protected static JournalArticle addJournalArticle(long userId,
				long groupId, String title, String fileName,
				ServiceContext serviceContext) throws Exception {

			return addJournalArticle(userId, groupId, title, fileName,
					StringPool.BLANK, StringPool.BLANK, serviceContext);
		}

		protected static JournalArticle addJournalArticle(long userId,
				long groupId, String title, String fileName, String structureId,
				String templateId, ServiceContext serviceContext) throws Exception {

			String content = getString(fileName);

			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);

			Map<Locale, String> titleMap = new HashMap<Locale, String>();

			setLocalizedValue(titleMap, title);
			
//			Gyl groupId-t megadni ++ lejjebb null lett beszúrva
			
			JournalArticle journalArticle = JournalArticleLocalServiceUtil
					.addArticle(userId, groupId, 0, 0, groupId, StringPool.BLANK, true,
							JournalArticleConstants.VERSION_DEFAULT, titleMap,
							null, content, "general", structureId, templateId,
							StringPool.BLANK, 1, 1, 2008, 0, 0, 0, 0, 0, 0, 0,
							true, 0, 0, 0, 0, 0, true, true, false,
							StringPool.BLANK, null, null, StringPool.BLANK,
							serviceContext);

//			JournalArticle journalArticle = JournalArticleLocalServiceUtil
//					.addArticle(userId, groupId, 0, 0, StringPool.BLANK, true,
//							JournalArticleConstants.VERSION_DEFAULT, titleMap,
//							null, content, "general", structureId, templateId,
//							StringPool.BLANK, 1, 1, 2008, 0, 0, 0, 0, 0, 0, 0,
//							true, 0, 0, 0, 0, 0, true, true, false,
//							StringPool.BLANK, null, null, StringPool.BLANK,
//							serviceContext);

			JournalArticleLocalServiceUtil.updateStatus(userId, groupId,
					journalArticle.getArticleId(), journalArticle.getVersion(),
					WorkflowConstants.STATUS_APPROVED, StringPool.BLANK,
					null, serviceContext);

			return journalArticle;
		}

		protected static JournalStructure addJournalStructure(long userId,
				long groupId, String fileName) throws Exception {

			Map<Locale, String> nameMap = new HashMap<Locale, String>();

			setLocalizedValue(nameMap, "Single Image");

			Map<Locale, String> descriptionMap = new HashMap<Locale, String>();

			setLocalizedValue(descriptionMap, "A single image, optional link");

			String xsd = getString(fileName);

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);

			return JournalStructureLocalServiceUtil.addStructure(userId, groupId,
					"SINGLE-IMAGE", false, StringPool.BLANK, nameMap,
					descriptionMap, xsd, serviceContext);
		}

		protected static JournalTemplate addJournalTemplate(long userId,
				long groupId, String fileName) throws Exception {

			Map<Locale, String> descriptionMap = new HashMap<Locale, String>();

			setLocalizedValue(descriptionMap, "A single image, optional URL");

			Map<Locale, String> nameMap = new HashMap<Locale, String>();

			setLocalizedValue(nameMap, "Single Image");

			String xsl = getString(fileName);

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);

			return JournalTemplateLocalServiceUtil.addTemplate(userId, groupId,
					"SINGLE-IMAGE", false, "SINGLE-IMAGE", nameMap, descriptionMap,
					xsl, true, "vm", true, false, StringPool.BLANK, null,
					serviceContext);
		}

		protected static Layout addLayout(Group group, String name,
				boolean privateLayout, String friendlyURL, String layouteTemplateId)
				throws Exception {

			ServiceContext serviceContext = new ServiceContext();

			Layout layout = LayoutLocalServiceUtil.addLayout(
					group.getCreatorUserId(), group.getGroupId(), privateLayout,
					LayoutConstants.DEFAULT_PARENT_LAYOUT_ID, name,
					StringPool.BLANK, StringPool.BLANK,
					LayoutConstants.TYPE_PORTLET, false, friendlyURL,
					serviceContext);

			LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout
					.getLayoutType();

			layoutTypePortlet.setLayoutTemplateId(0, layouteTemplateId, false); // !!!
																				// elszáll
																				// mert
																				// nincs
																				// home
																				// nevû
																				// layout

			addResources(layout, PortletKeys.DOCKBAR);

			return layout;
		}

		protected static MBCategory addMBCategory(long userId, String name,
				String description, ServiceContext serviceContext) throws Exception {

			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);

			return MBCategoryLocalServiceUtil.addCategory(userId, 0, name,
					description, "default", StringPool.BLANK, StringPool.BLANK,
					StringPool.BLANK, 0, false, StringPool.BLANK, StringPool.BLANK,
					1, StringPool.BLANK, false, StringPool.BLANK, 0, false,
					StringPool.BLANK, StringPool.BLANK, false, false,
					serviceContext);
		}

		protected static MBMessage addMBMessage(long userId, String userName,
				long groupId, long categoryId, long threadId, long parentMessageId,
				String subject, String filePath, ServiceContext serviceContext)
				throws Exception {

			String fileName = StringUtil.extractLast(filePath, StringPool.SLASH);

			String body = getString(filePath);

			List<ObjectValuePair<String, InputStream>> inputStreamOVPs = new ArrayList<ObjectValuePair<String, InputStream>>();

			InputStream inputStream = getInputStream(filePath);

			ObjectValuePair<String, InputStream> inputStreamOVP = new ObjectValuePair<String, InputStream>(
					fileName, inputStream);

			inputStreamOVPs.add(inputStreamOVP);

			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);

			return MBMessageLocalServiceUtil.addMessage(userId, userName, groupId,
					categoryId, threadId, parentMessageId, subject, body,
					MBMessageConstants.DEFAULT_FORMAT, inputStreamOVPs, false,
					-1.0, false, serviceContext);
		}

		protected static String addPortletId(Layout layout, String portletId,
				String columnId) throws Exception {

			LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout
					.getLayoutType();

			portletId = layoutTypePortlet.addPortletId(0, portletId, columnId, -1,
					false);

			addResources(layout, portletId);
			updateLayout(layout);

			return portletId;
		}

		protected static void addResources(Layout layout, String portletId)
				throws Exception {

			String rootPortletId = PortletConstants.getRootPortletId(portletId);

			String portletPrimaryKey = PortletPermissionUtil.getPrimaryKey(
					layout.getPlid(), portletId);

			ResourceLocalServiceUtil.addResources(layout.getCompanyId(),
					layout.getGroupId(), 0, rootPortletId, portletPrimaryKey, true,
					true, true);
		}

		protected static void addSocialActivityCounter(Group group,
				List<User> users, String socialActivityCounterName, String line,
				Map<String, SocialActivityCounter> socialActivityCounters)
				throws Exception {

			String[] lineParts = StringUtil.split(line);

			int endPeriodOffset = GetterUtil.getInteger(lineParts[3]);

			int endPeriod = SocialCounterPeriodUtil.getEndPeriod(endPeriodOffset);

			if (endPeriod < 0) {
				return;
			}

			String className = lineParts[0];

			long classNameId = PortalUtil.getClassNameId(className);

			String classPKString = lineParts[1];

			long classPK = 12345;

			if (className.equals(User.class.getName())) {
				if (classPKString.equals("0")) {
					int index = getRandomNumber(0, 3);

					User user = users.get(index);

					classPK = user.getUserId();
				} else {
					for (User user : users) {
						if (classPKString.equalsIgnoreCase(user.getScreenName())) {
							classPK = user.getUserId();
						}
					}
				}
			} else {
				AssetEntryQuery assetEntryQuery = new AssetEntryQuery();

				assetEntryQuery.setClassName(className);
				assetEntryQuery.setGroupIds(new long[] { group.getGroupId() });

				List<AssetEntry> assetEntries = AssetEntryLocalServiceUtil
						.getEntries(assetEntryQuery);

				if (!assetEntries.isEmpty()) {
					int index = getRandomNumber(0, assetEntries.size() - 1);

					AssetEntry assetEntry = assetEntries.get(index);

					classPK = assetEntry.getClassPK();
				}
			}

			int ownerType = SocialActivityCounterConstants.TYPE_ACTOR;

			if (socialActivityCounterName.startsWith("asset.")) {
				ownerType = SocialActivityCounterConstants.TYPE_ASSET;
			} else if (socialActivityCounterName.equals("contribution")) {
				ownerType = SocialActivityCounterConstants.TYPE_CREATOR;
			}

			int startPeriodOffset = GetterUtil.getInteger(lineParts[2]);

			int startPeriod = SocialCounterPeriodUtil
					.getStartPeriod(startPeriodOffset);

			SocialActivityCounter socialActivityCounter = SocialActivityCounterLocalServiceUtil
					.fetchActivityCounterByStartPeriod(group.getGroupId(),
							classNameId, classPK, socialActivityCounterName,
							ownerType, startPeriod);

			int currentValue = getRandomNumber(0, 100);
			int totalValue = currentValue;

			if (socialActivityCounter != null) {
				totalValue = totalValue + socialActivityCounter.getTotalValue();
			}

			StringBundler sb = new StringBundler(7);

			sb.append(StringUtil.toHexString(group.getGroupId()));
			sb.append(StringPool.POUND);
			sb.append(StringUtil.toHexString(classNameId));
			sb.append(StringPool.POUND);
			sb.append(StringUtil.toHexString(classPK));
			sb.append(StringPool.POUND);
			sb.append(StringUtil.toHexString(socialActivityCounterName));

			String key = sb.toString();

			SocialActivityCounter latestSocialActivityCounter = socialActivityCounters
					.get(key);

			if (latestSocialActivityCounter != null) {
				totalValue = totalValue
						+ latestSocialActivityCounter.getTotalValue();
			}

			if ((socialActivityCounter == null)
					|| (socialActivityCounter.getStartPeriod() != startPeriod)) {

				if (endPeriodOffset == 0) {
					endPeriod = -1;
				}

				socialActivityCounter = SocialActivityCounterLocalServiceUtil
						.addActivityCounter(group.getGroupId(), classNameId,
								classPK, socialActivityCounterName, ownerType, 0,
								0, startPeriod, endPeriod);
			}

			socialActivityCounter.setCurrentValue(socialActivityCounter
					.getCurrentValue() + currentValue);
			socialActivityCounter.setTotalValue(totalValue);

			SocialActivityCounterLocalServiceUtil
					.updateSocialActivityCounter(socialActivityCounter);

			socialActivityCounters.put(key, socialActivityCounter);
		}

		protected static void addSocialActivityCounters(Group group,
				List<User> users, String socialActivityCounterName)
				throws Exception {

			String content = getString("/sample/activity/counters/"
					+ socialActivityCounterName + ".csv");

			String[] lines = StringUtil.splitLines(content);

			Map<String, SocialActivityCounter> socialActivityCounters = new HashMap<String, SocialActivityCounter>();

			for (String line : lines) {
				addSocialActivityCounter(group, users, socialActivityCounterName,
						line, socialActivityCounters);
			}
		}

		protected static void addSocialRequest(User user, User receiverUser,
				boolean confirm) throws Exception {

			SocialRequest socialRequest = SocialRequestLocalServiceUtil.addRequest(
					user.getUserId(), 0, User.class.getName(), user.getUserId(),
					_SN_FRIENDS_REQUEST_KEYS_ADD_FRIEND, StringPool.BLANK,
					receiverUser.getUserId());

			if (confirm) {
				SocialRequestLocalServiceUtil.updateRequest(
						socialRequest.getRequestId(),
						SocialRequestConstants.STATUS_CONFIRM, new ThemeDisplay());
			}
		}

		protected static User addUser(long companyId, String screenName,
				String firstName, String lastName, boolean male, String jobTitle,
				long[] roleIds) throws Exception {

			long creatorUserId = 0;
			boolean autoPassword = false;
			String password1 = screenName;
			String password2 = password1;
			boolean autoScreenName = false;
			String emailAddress = screenName + "@7cogs.com";
			long facebookId = 0;
			String openId = StringPool.BLANK;
			Locale locale = LocaleUtil.getDefault();
			String middleName = StringPool.BLANK;
			int prefixId = 0;
			int suffixId = 0;
			int birthdayMonth = Calendar.JANUARY;
			int birthdayDay = 1;
			int birthdayYear = 1970;

			Group guestGroup = GroupLocalServiceUtil.getGroup(companyId,
					GroupConstants.GUEST);

			long[] groupIds = new long[] { guestGroup.getGroupId() };

			Organization sevenCogsOrganization = OrganizationLocalServiceUtil
					.getOrganization(companyId, "7Cogs, Inc.");

			long[] organizationIds = new long[] { sevenCogsOrganization
					.getOrganizationId() };

			long[] userGroupIds = null;
			boolean sendEmail = false;

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setScopeGroupId(guestGroup.getGroupId());

			User user = UserLocalServiceUtil.addUser(creatorUserId, companyId,
					autoPassword, password1, password2, autoScreenName, screenName,
					emailAddress, facebookId, openId, locale, firstName,
					middleName, lastName, prefixId, suffixId, male, birthdayMonth,
					birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds,
					roleIds, userGroupIds, sendEmail, serviceContext);

			UserLocalServiceUtil.updateLastLogin(user.getUserId(),
					user.getLoginIP());

			UserLocalServiceUtil.updatePasswordReset(user.getUserId(), false);

			byte[] portrait = getBytes("/users/images/" + screenName
					+ "_portrait.jpg");

			UserLocalServiceUtil.updatePortrait(user.getUserId(), portrait);

			String[] questions = StringUtil.split(PropsUtil
					.get("users.reminder.queries.questions"));

			String question = questions[0];
			String answer = "1234";

			UserLocalServiceUtil.updateReminderQuery(user.getUserId(), question,
					answer);

			Group group = user.getGroup();

			// Profile layout

			Layout layout = addLayout(group, "Profile", false, "/profile",
					"2_columns_ii");

			String portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-2");

			highlightPortlet(layout, portletId);

			serviceContext.setAssetTagNames(new String[] { "community", "tips" });

			String fileName = "/users/journal/articles/my_community_"
					+ user.getScreenName() + ".xml";

			JournalArticle journalArticle = addJournalArticle(user.getUserId(),
					group.getGroupId(), "Public Pages " + user.getScreenName(),
					fileName, serviceContext);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			addPortletId(layout, "1_WAR_socialnetworkingportlet", "column-1");
			addPortletId(layout, PortletKeys.REQUESTS, "column-1");
			addPortletId(layout, "2_WAR_socialnetworkingportlet", "column-1");
			addPortletId(layout, PortletKeys.ACTIVITIES, "column-2");
			addPortletId(layout, "3_WAR_socialnetworkingportlet", "column-2");

			// Blog layout

			layout = addLayout(group, "Blog", false, "/blog", "2_columns_ii");

			addPortletId(layout, PortletKeys.RECENT_BLOGGERS, "column-1");
			addPortletId(layout, PortletKeys.BLOGS, "column-2");

			// Social layout

			layout = addLayout(group, "Social", true, "/social", "2_columns_ii");

			addPortletId(layout, "1_WAR_socialnetworkingportlet", "column-1");
			addPortletId(layout, PortletKeys.REQUESTS, "column-1");

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-2");

			highlightPortlet(layout, portletId);

			serviceContext.setAssetTagNames(new String[] { "social", "tips" });

			fileName = "/users/journal/articles/private_pages_"
					+ user.getScreenName() + ".xml";

			journalArticle = addJournalArticle(user.getUserId(),
					group.getGroupId(), "Public Pages " + user.getScreenName(),
					fileName, serviceContext);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			addPortletId(layout, "4_WAR_socialnetworkingportlet", "column-2");

			portletId = addPortletId(layout, PortletKeys.IFRAME, "column-1");

			Map<String, String> preferences = new HashMap<String, String>();

			preferences.put("portlet-setup-show-borders", Boolean.FALSE.toString());

			if (screenName.equals("kendra") || screenName.equals("bruno")) {
				preferences.put("src", "http://m.digg.com");
				preferences.put("height-normal", "400");
			} else if (screenName.equals("michelle")) {
				preferences.put("src", "http://m.digg.com");
				preferences.put("height-normal", "400");
			} else if (screenName.equals("richard")) {
				preferences.put("src", "http://m.linkedin.com");
				preferences.put("height-normal", "350");
			}

			updatePortletSetup(layout, portletId, preferences);

			// Workspace layout

			layout = addLayout(group, "Workspace", true, "/workspace",
					"2_columns_i");

			addPortletId(layout, PortletKeys.RECENT_DOCUMENTS, "column-1");
			addPortletId(layout, PortletKeys.DOCUMENT_LIBRARY, "column-1");
			addPortletId(layout, PortletKeys.MEDIA_GALLERY_DISPLAY, "column-1");

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-2");

			highlightPortlet(layout, portletId);

			serviceContext.setAssetTagNames(new String[] { "documents", "tips" });

			journalArticle = addJournalArticle(user.getUserId(),
					group.getGroupId(), "My documents",
					"/users/journal/articles/workspace_docs.xml", serviceContext);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			addPortletId(layout, PortletKeys.CALENDAR, "column-2");

			// Email layout

			layout = addLayout(group, "Email", true, "/email", "1_column");

			addPortletId(layout, "1_WAR_mailportlet", "column-1");

			return user;
		}

		protected static WikiPage addWikiPage(long userId, long nodeId,
				String title, String fileName, ServiceContext serviceContext)
				throws Exception {

			String content = getString(fileName);

			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);

			return WikiPageLocalServiceUtil.addPage(userId, nodeId, title, content,
					"New", false, serviceContext);
		}

		protected static void clearData(long companyId) throws Exception {

			// Users

			List<User> users = UserLocalServiceUtil.search(companyId, null,
					WorkflowConstants.STATUS_ANY, null, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, (OrderByComparator) null);

			for (User user : users) {
				String screenName = user.getScreenName();

				String defaultAdminScreenName = PropsUtil
						.get(PropsKeys.DEFAULT_ADMIN_SCREEN_NAME);

				if (screenName.equals("joebloggs") || screenName.equals("test")
						|| screenName.equals(defaultAdminScreenName)) {

					continue;
				}

				UserLocalServiceUtil.deleteUser(user.getUserId());
			}

			// Organizations

			deleteOrganizations(companyId,
					OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID);

			// Groups

			List<Group> groups = GroupLocalServiceUtil.search(companyId, null,
					null, null, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			for (Group group : groups) {
				if (!PortalUtil.isSystemGroup(group.getName())) {
					GroupLocalServiceUtil.deleteGroup(group.getGroupId());
				} else {
					ServiceContext serviceContext = new ServiceContext();

					DLAppLocalServiceUtil.deleteAll(group.getGroupId());

					JournalArticleLocalServiceUtil.deleteArticles(group
							.getGroupId());
					JournalTemplateLocalServiceUtil.deleteTemplates(group
							.getGroupId());
					JournalStructureLocalServiceUtil.deleteStructures(group
							.getGroupId());

					LayoutLocalServiceUtil.deleteLayouts(group.getGroupId(), false,
							serviceContext);
					LayoutLocalServiceUtil.deleteLayouts(group.getGroupId(), true,
							serviceContext);
				}
			}
		}

		protected static void configureGroupStatistics(Layout layout,
				String portletId, String[][] chartData) throws Exception {

			PortletPreferences portletSetup = PortletPreferencesFactoryUtil
					.getLayoutPortletSetup(layout, portletId);

			String[] indexes = new String[chartData.length];

			for (int i = 0; i < chartData.length; i++) {
				indexes[i] = String.valueOf(i);

				portletSetup.setValue("chartType" + (i), chartData[i][1]);
				portletSetup.setValue("chartWidth" + (i), chartData[i][3]);
				portletSetup.setValue("dataRange" + (i), chartData[i][2]);
				portletSetup.setValue("displayActivityCounterName" + (i),
						chartData[i][0]);
			}

			portletSetup.setValue("displayActivityCounterNameIndexes",
					StringUtil.merge(indexes));

			portletSetup.store();
		}

		protected static void configureJournalContent(Layout layout,
				String portletId, String articleId) throws Exception {

			PortletPreferences portletSetup = PortletPreferencesFactoryUtil
					.getLayoutPortletSetup(layout, portletId);

			portletSetup.setValue("groupId", String.valueOf(layout.getGroupId()));
			portletSetup.setValue("articleId", articleId);

			portletSetup.store();
		}

		protected static void configurePortletTitle(Layout layout,
				String portletId, String title) throws Exception {

			PortletPreferences portletSetup = PortletPreferencesFactoryUtil
					.getLayoutPortletSetup(layout, portletId);

			portletSetup.setValue("portletSetupTitle", title);

			portletSetup.store();
		}

		protected static void configureUserStatistics(Layout layout,
				String portletId, String[] socialActivityCounterNames)
				throws Exception {

			PortletPreferences portletSetup = PortletPreferencesFactoryUtil
					.getLayoutPortletSetup(layout, portletId);

			String[] indexes = new String[socialActivityCounterNames.length + 1];

			indexes[0] = "0";

			for (int i = 0; i < socialActivityCounterNames.length; i++) {
				indexes[i + 1] = String.valueOf(i + 1);

				portletSetup.setValue("displayActivityCounterName" + (i + 1),
						socialActivityCounterNames[i]);
			}

			portletSetup.setValue("displayActivityCounterNameIndexes",
					StringUtil.merge(indexes));
			portletSetup.setValue("showHeaderText", "false");
			portletSetup.setValue("showTotals", "false");

			portletSetup.store();
		}

		protected static void deleteOrganizations(long companyId,
				long parentOrganizationId) throws Exception {

			List<Organization> organizations = OrganizationLocalServiceUtil.search(
					companyId, parentOrganizationId, null, null, null, null, null,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, (OrderByComparator) null);

			for (Organization organization : organizations) {
				deleteOrganizations(companyId, organization.getOrganizationId());
			}

			if (parentOrganizationId > 0) {
				long[] userIds = UserLocalServiceUtil
						.getOrganizationUserIds(parentOrganizationId);

				UserLocalServiceUtil.unsetOrganizationUsers(parentOrganizationId,
						userIds);

				OrganizationLocalServiceUtil
						.deleteOrganization(parentOrganizationId);
			}
		}

		// @Override
		// protected void doUpgrade() throws Exception {

		protected static void enableSocialActivities(long groupId) throws Exception {

			SocialActivitySettingLocalServiceUtil.updateActivitySetting(groupId,
					BlogsEntry.class.getName(), true);
			SocialActivitySettingLocalServiceUtil.updateActivitySetting(groupId,
					MBMessage.class.getName(), true);
			SocialActivitySettingLocalServiceUtil.updateActivitySetting(groupId,
					WikiPage.class.getName(), true);
		}

		protected static byte[] getBytes(String path) throws Exception {
			return FileUtil.getBytes(getInputStream(path));
		}

		protected static InputStream getInputStream(String path) throws Exception {
			// Class<?> clazz = getClass();

			// ClassLoader classLoader = clazz.getClassLoader();
			ClassLoader classLoader = OrganizationSetupUtil.class.getClassLoader(); // GYL!!!

			return classLoader.getResourceAsStream("/resources" + path);
		}

		protected static int getRandomNumber(int min, int max) {
			return (int) (Math.round(min + Math.random() * (max - min)));
		}

		protected static String getString(String path) throws Exception {
			return new String(getBytes(path));
		}

		protected static void highlightPortlet(Layout layout, String portletId)
				throws Exception {

			PortletPreferences portletSetup = PortletPreferencesFactoryUtil
					.getLayoutPortletSetup(layout, portletId);

			portletSetup.setValue("portletSetupShowBorders",
					String.valueOf(Boolean.FALSE));
			portletSetup.setValue("portletSetupCss",
					getString("/preferences/highlight.json"));

			portletSetup.store();
		}

		
		public static void importCategoryes() throws Exception {


			long companyId = PortalUtil.getDefaultCompanyId();
			Group group = GroupLocalServiceUtil.getCompanyGroup(companyId);
			long defaultUserId = UserLocalServiceUtil.getDefaultUserId(companyId);
			
			
//			long userId = defaultUserId;
	/*		long parentOrganizationId = OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID;
			String name = "7Cogs, Inc.";
			String type = OrganizationConstants.TYPE_REGULAR_ORGANIZATION;
			boolean recursable = true;
			long regionId = 0;
			long countryId = 0;
			int statusId = GetterUtil
					.getInteger(PropsUtil
							.get("sql.data.com.liferay.portal.model.ListType.organization.status"));
			String comments = "Dinet Site";
	*/
			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);

			serviceContext.setScopeGroupId(group.getGroupId());

			// Asset

			AssetVocabulary sectorAssetVocabulary = addAssetVocabulary(
					defaultUserId, "Ágazat", serviceContext);

			/*		
			AssetCategory liferayAssetCategory = addAssetCategory(defaultUserId, 0,
					"Liferay", topicAssetVocabulary.getVocabularyId(),
					serviceContext);

			_assetCategories = new HashMap<String, AssetCategory>();

			_assetCategories.put("Icon", iconAssetCategory);
			_assetCategories.put("Banner", bannerAssetCategory);
			_assetCategories.put("Learning", learningAssetCategory);
			_assetCategories.put("Products", productsAssetCategory);
			_assetCategories.put("Liferay", liferayAssetCategory);
			*/
		
//			Org newOrg = new OrgImpl();
//			String fileName = "/orgsetup/organizations_2013_11_07_test" +".xlsx";
			String fileName = "/orgsetup/categories_2013_11_08_test" +".xlsx";

			try {

				// FileInputStream file = new FileInputStream(new
				// File("C:\\test.xls"));
				InputStream file = getInputStream(fileName);

				// Get the workbook instance for XLSX file
				XSSFWorkbook workbook = new XSSFWorkbook(file);

				// Get first sheet from the workbook
				XSSFSheet sheet = workbook.getSheetAt(0);

				String parent="", category="";
				AssetCategory parentAssetCategory = null;
				Cell cell;

				// Decide which rows to process
				int rowStart = Math.min(15, sheet.getFirstRowNum() + 1); // header
				int rowEnd = Math.max(10, sheet.getLastRowNum());
				// Iterate through each rows from first sheet
				for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
					Row r = sheet.getRow(rowNum);
					// For each row, iterate through each columns
					
					cell = r.getCell(0, Row.RETURN_BLANK_AS_NULL);
					
					if (cell != null) {
						parent = cell.getStringCellValue();
						System.out.print("parent -" + parent + "\n");
						parentAssetCategory = addAssetCategory(defaultUserId, 0,
								parent, sectorAssetVocabulary.getVocabularyId(),
								serviceContext);
					}
					
					cell = r.getCell(1, Row.RETURN_BLANK_AS_NULL);
					
					if (cell != null) {
						category = cell.getStringCellValue();
						System.out.print("categoy -" + category + "\n");
						AssetCategory childAssetCategory = addAssetCategory(defaultUserId,
								parentAssetCategory.getCategoryId(),
								category, sectorAssetVocabulary.getVocabularyId(),
								serviceContext);
					}		
									
					System.out.println("vége");
				}

				file.close();
				// FileOutputStream out =
				// new FileOutputStream(new File("C:\\test.xls"));
				// workbook.write(out);
				// out.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static void importCegData() throws Exception {

			// addJournalStructure(
			// defaultUserId, group.getGroupId(),
			// "/sample/journal/structures/single_image.xml");

			long companyId = PortalUtil.getDefaultCompanyId();
			Group group = GroupLocalServiceUtil.getCompanyGroup(companyId);
			long defaultUserId = UserLocalServiceUtil.getDefaultUserId(companyId);
			Ceg newCeg = new CegImpl();
			String fileName = "/orgsetup/ceg_osszes_2013_12_21.xlsx";

			try {

				InputStream file = getInputStream(fileName);

				// Get the workbook instance for XLSX file
				XSSFWorkbook workbook = new XSSFWorkbook(file);

				// Get first sheet from the workbook
				XSSFSheet sheet = workbook.getSheetAt(0);

				Date date = new Date();
				long l;
				String s;

				// Decide which rows to process
				int rowStart = sheet.getFirstRowNum() + 1; // header
//				int rowEnd =  sheet.getLastRowNum()+1;
				int rowEnd =  11;
				// Iterate through each rows from first sheet
				for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
					Row r = sheet.getRow(rowNum);
					// For each row, iterate through each columns
					l = 0;
					s = "";
					Cell cell = r.getCell(0, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					 newCeg.setAzon_r(l);

					l = 0;
					s = "";
					cell = r.getCell(1, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setSubAzon_r(l);

					l = 0;
					s = "";
					cell = r.getCell(2, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setCategory_r(s);

					l = 0;
					s = "";
					cell = r.getCell(3, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setOrgname_r(s);



					l = 0;
					s = "";
					cell = r.getCell(4, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setAzon_u(l);

					l = 0;
					s = "";
					cell = r.getCell(5, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setSubAzon_u(l);

					

					l = 0;
					s = "";
					cell = r.getCell(6, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
//					newCeg.setLiferayOrgId(l);

					l = 0;
					s = "";
					cell = r.getCell(7, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setOrgname(s);

					l = 0;
					s = "";
					cell = r.getCell(8, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setLogo(s);

					l = 0;
					s = "";
					cell = r.getCell(9, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
//					newCeg.setCategoryId(l);

					l = 0;
					s = "";
					cell = r.getCell(10, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setCategory(s);

					l = 0;
					s = "";
					cell = r.getCell(11, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							s= String.valueOf(l);
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setPostalcode(s);

					l = 0;
					s = "";
					cell = r.getCell(12, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setCity(s);

					l = 0;
					s = "";
					cell = r.getCell(13, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setStreet(s);

					l = 0;
					s = "";
					cell = r.getCell(14, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setContact(s);
					

					l = 0;
					s = "";
					cell = r.getCell(15, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setWeb(s);
					

					l = 0;
					s = "";
					cell = r.getCell(16, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setDescription(s);
					

					l = 0;
					s = "";
					cell = r.getCell(17, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setHtmldescription(s);
					

					l = 0;
					s = "";
					cell = r.getCell(18, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setKeywords(s);
					

					l = 0;
					s = "";
					cell = r.getCell(19, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setPageURL(s);
					

					l = 0;
					s = "";
					cell = r.getCell(20, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setPagename(s);
					

					l = 0;
					s = "";
					cell = r.getCell(21, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newCeg.setDate(date);
					

					l = 0;
					s = "";
					cell = r.getCell(22, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
//					newCeg.setPageURLAzon(s);
										
					CegLocalServiceUtil.addCeg(newCeg,defaultUserId);
					System.out.println("");
				}

				file.close();
				// FileOutputStream out =
				// new FileOutputStream(new File("C:\\test.xls"));
				// workbook.write(out);
				// out.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static void importOrgData() throws Exception {

			long companyId = PortalUtil.getDefaultCompanyId();
			long defaultUserId = UserLocalServiceUtil.getDefaultUserId(companyId);
			Org newOrg = new OrgImpl();
			String fileName = "/orgsetup/organizations_2013_12_21.xlsx";

			try {

				// FileInputStream file = new FileInputStream(new
				// File("C:\\test.xls"));
				InputStream file = getInputStream(fileName);

				// Get the workbook instance for XLSX file
				XSSFWorkbook workbook = new XSSFWorkbook(file);

				// Get first sheet from the workbook
				XSSFSheet sheet = workbook.getSheetAt(0);

				long l;
				String s;

				// Decide which rows to process
				int rowStart = sheet.getFirstRowNum() + 1; // header
//				int rowEnd =  sheet.getLastRowNum()+1;
				int rowEnd =  11;
				// Iterate through each rows from first sheet
				for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
					Row r = sheet.getRow(rowNum);
					// For each row, iterate through each columns
					l = 0;
					s = "";
					Cell cell = r.getCell(0, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					// newOrg.setOrgId(l);

					l = 0;
					s = "";
					cell = r.getCell(1, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newOrg.setOrigAzon(l);

					l = 0;
					s = "";
					cell = r.getCell(2, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newOrg.setAzon_r(l);

					l = 0;
					s = "";
					cell = r.getCell(3, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newOrg.setSubAzon_r(l);



					l = 0;
					s = "";
					cell = r.getCell(4, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newOrg.setCategory_r(s);

					l = 0;
					s = "";
					cell = r.getCell(5, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newOrg.setOrgname_r(s);

					

					l = 0;
					s = "";
					cell = r.getCell(6, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newOrg.setCity(s);

					l = 0;
					s = "";
					cell = r.getCell(7, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newOrg.setAddress1(s);

					l = 0;
					s = "";
					cell = r.getCell(8, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							s= String.valueOf(l);
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newOrg.setPostalCode(s);

					l = 0;
					s = "";
					cell = r.getCell(9, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newOrg.setWebURL(s);

					l = 0;
					s = "";
					cell = r.getCell(10, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newOrg.setContact(s);

					l = 0;
					s = "";
					cell = r.getCell(11, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newOrg.setEmailAddress(s);

					l = 0;
					s = "";
					cell = r.getCell(12, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newOrg.setDescription(s);

					l = 0;
					s = "";
					cell = r.getCell(13, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newOrg.setKeywords(s);

					l = 0;
					s = "";
					cell = r.getCell(14, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newOrg.setImageURL(s);

					OrgLocalServiceUtil.addOrg(newOrg,defaultUserId);
					System.out.println("");
				}

				file.close();
				// FileOutputStream out =
				// new FileOutputStream(new File("C:\\test.xls"));
				// workbook.write(out);
				// out.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static void importProductData() throws Exception {

			long companyId = PortalUtil.getDefaultCompanyId();
			long defaultUserId = UserLocalServiceUtil.getDefaultUserId(companyId);
			
			Product newProduct = new ProductImpl();
			String fileName = "/orgsetup/termekek_2013_12_21.xlsx";

			try {

				InputStream file = getInputStream(fileName);

				// Get the workbook instance for XLSX file
				XSSFWorkbook workbook = new XSSFWorkbook(file);

				// Get first sheet from the workbook
				XSSFSheet sheet = workbook.getSheetAt(0);

				Date date = new Date();
				long l;
				String s;

				// Decide which rows to process
				int rowStart = sheet.getFirstRowNum() + 1; // header
//				int rowEnd =  sheet.getLastRowNum()+1;
				int rowEnd =  11;
				// Iterate through each rows from first sheet
				for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
					Row r = sheet.getRow(rowNum);
					// For each row, iterate through each columns
					l = 0;
					s = "";
					Cell cell = r.getCell(0, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					 newProduct.setAzon(l);

					l = 0;
					s = "";
					cell = r.getCell(1, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newProduct.setName(s);

					l = 0;
					s = "";
					cell = r.getCell(2, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newProduct.setDescription(s);

					l = 0;
					s = "";
					cell = r.getCell(3, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newProduct.setServices(s);



					l = 0;
					s = "";
					cell = r.getCell(4, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newProduct.setImage(s);

					l = 0;
					s = "";
					cell = r.getCell(5, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newProduct.setDatasheet(s);

					

					l = 0;
					s = "";
					cell = r.getCell(6, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newProduct.setDistributor(s);

					l = 0;
					s = "";
					cell = r.getCell(7, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newProduct.setCategory(s);

					l = 0;
					s = "";
					cell = r.getCell(8, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newProduct.setSubcategory(s);

					l = 0;
					s = "";
					cell = r.getCell(9, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newProduct.setPageURL(s);

					l = 0;
					s = "";
					cell = r.getCell(10, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newProduct.setPagetitle(s);

					l = 0;
					s = "";
					cell = r.getCell(11, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newProduct.setStartingpage(s);

					l = 0;
					s = "";
					cell = r.getCell(12, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
					newProduct.setDate(date);

					l = 0;
					s = "";
					cell = r.getCell(13, Row.RETURN_BLANK_AS_NULL);
					if (cell != null) {
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							l = (long) cell.getNumericCellValue();
							System.out.print(l + "\t");
							break;
						case Cell.CELL_TYPE_STRING:
							s = cell.getStringCellValue();
							System.out.print(s + "\t");
							break;
						}
					}
//					newProduct.setPageURLAzon(s);

					
										
					ProductLocalServiceUtil.addProduct(newProduct,defaultUserId);
					System.out.println("");
				}

				file.close();
				// FileOutputStream out =
				// new FileOutputStream(new File("C:\\test.xls"));
				// workbook.write(out);
				// out.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		protected static void removePortletBorder(Layout layout, String portletId)
				throws Exception {

			PortletPreferences portletSetup = PortletPreferencesFactoryUtil
					.getLayoutPortletSetup(layout, portletId);

			portletSetup.setValue("portletSetupShowBorders",
					String.valueOf(Boolean.FALSE));

			portletSetup.store();
		}

		protected static void setLocalizedValue(Map<Locale, String> map,
				String value) {
			Locale locale = LocaleUtil.getDefault();

			map.put(locale, value);

			if (!locale.equals(Locale.US)) {
				map.put(Locale.US, value);
			}
		}


		protected static void setRolePermissions(Role role, String name,
				String[] actionIds) throws Exception {

			long roleId = role.getRoleId();
			long companyId = role.getCompanyId();
			int scope = ResourceConstants.SCOPE_COMPANY;
			String primKey = String.valueOf(companyId);

/*			if (_PERMISSIONS_USER_CHECK_ALGORITHM == 6) {
				ResourcePermissionLocalServiceUtil.setResourcePermissions(
						companyId, name, scope, primKey, roleId, actionIds);
			} else {
				PermissionLocalServiceUtil.setRolePermissions(roleId, companyId,
						name, scope, primKey, actionIds);
			}
*/
			ResourcePermissionLocalServiceUtil.setResourcePermissions(
					companyId, name, scope, primKey, roleId, actionIds);
		}

		// @Override
		// protected void doUpgrade() throws Exception {
		
		public static void setupCegPageURL() throws Exception {
			
			List<Ceg> cegek = CegLocalServiceUtil.getAllCeg();
						
			for(Ceg ceg : cegek ){
			
				String pageURLAzon;
				String pageURL= ceg.getPageURL();
				
				int lastpos = pageURL.lastIndexOf("/");
				if (lastpos != -1 && pageURL != null){
					pageURLAzon = pageURL.substring(0,lastpos);
					ceg.setPageURLAzon(pageURLAzon);
					CegLocalServiceUtil.updateCeg(ceg);
					System.out.print(pageURL+"\n");
					System.out.print(pageURLAzon+"\n");
				}
			} 
			System.out.print("vege\n");
		}

		public static void setupOrganization() throws Exception {
			String name = PrincipalThreadLocal.getName();
		
			try {
				long companyId = PortalUtil.getDefaultCompanyId();
		
				long defaultUserId = UserLocalServiceUtil
						.getDefaultUserId(companyId);
		
				PrincipalThreadLocal.setName(defaultUserId);
		
				// clearData(companyId);
				// setupSites(companyId, defaultUserId);
		
//				Organization organization = setupOrganizations(companyId,
//						defaultUserId);
				setupOrganizations(companyId, defaultUserId);
		
				// setupRoles(companyId, defaultUserId);
		
				// List<User> users = setupUsers(companyId);
		
				// setupSocialActivityCounters(organization.getGroup(), users);
				// setupWorkflow(companyId, defaultUserId);
			} finally {
				PrincipalThreadLocal.setName(name);
			}
		}

		protected static void setupOrganizations(long companyId,
				long defaultUserId) throws Exception {

			// 7Cogs, Inc. organization

			long userId = defaultUserId;
			long parentOrganizationId = OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID;
			String name = "7Cogs, Inc.";
			String type = OrganizationConstants.TYPE_REGULAR_ORGANIZATION;
			boolean recursable = true;
			long regionId = 0;
			long countryId = 6; // Hungary
			int addressType = 12001; // other
			String city = null;
			String zip = null;
			String street1 = null;
			String comments = "Loaded by Dinet-0001";
			String webURL = null;
			String emailAddress = null;
			String contact = null;
			String description = null;
			String description1 = null;
			String description2 = null;
			String keywords = null;
			String imageURL = null;
			String defaultOrgImageUrl = "mecsek_espresso_perfetto_latte_macchiato_001.jpg";
			String tempimageURL;
			String assetTagName;
			String assetTagNames[];
			Long assetCategoryID;
			Long assetCategoryIds[];
			ArrayList<Long> alAssetCategoryIds = new ArrayList<Long>();
			ArrayList<String> alAssetTagNames = new ArrayList<String>();
			List<Org> orgs;
			List<Ceg> cegek;
			Organization organization;

			int statusId = GetterUtil
					.getInteger(PropsUtil
							.get("sql.data.com.liferay.portal.model.ListType.organization.status"));

			for (int azon = 1; azon < 3; azon = azon + 1) {

//				orgs = OrgLocalServiceUtil.getAllOrganizationsByAzon(azon);
				cegek = CegLocalServiceUtil.getAllCegByAzon(azon);

				if (cegek != null) {

					int i = 0;

					for (Ceg ceg : cegek) {
						
					
						// find org (old data for the same company) if exist
						Long azon_r = ceg.getAzon_r();
						Long subazon_r = ceg.getSubAzon_r();
						Org org=null;
						
						boolean orgexist = true;
						if (azon_r==null || azon_r==0 || subazon_r==null || subazon_r== 0){
							orgexist = false;
						}
									
						if (orgexist){
							org = OrgLocalServiceUtil.getOrgByAzonSubazon(azon_r,subazon_r);
						}
						
						// first Ceg element
						if (i == 0) {
							i = 1;
							description = null;
							description1 = null;
							description2 = null;
							alAssetCategoryIds = new ArrayList<Long>();
							alAssetTagNames = new ArrayList<String>();
							name = ceg.getOrgname();
							city = ceg.getCity();

							zip = ceg.getPostalcode();
	 						if (zip==null || zip ==""){
	 							zip = "XXXX";
	 						}
							street1 = ceg.getStreet();
							
							
							webURL = ceg.getWeb();
							if ((webURL==null||webURL=="") && orgexist ) {
								webURL = org.getWebURL();
							}
							
							if (orgexist ) {
								emailAddress = org.getEmailAddress();
							}
							contact = ceg.getContact();
							
							
							imageURL = defaultOrgImageUrl;
							// test
							System.out.print(name + "\n");
						}
						// all Ceg elements
						description1 = ceg.getDescription();
						if ((description1==null||description1=="") && orgexist ) {
							description1 = org.getDescription();
						}

						// add the description if it's not the same as previous
						if (description2 != description1 ) {
							if (description==null && description1 !=null){
								description = description1;
							} else {
								description = description + "\n" + "\n"+ description1;
							}
						}
						description2 = description1;

						// replace imageURL(previous) if tempimageURL(current) is
						// not null
						
						tempimageURL = ceg.getLogo();
						if ((tempimageURL==null||tempimageURL=="") && orgexist ) {
							tempimageURL = org.getImageURL();
						}
						
						int firstpos = tempimageURL.lastIndexOf("\\");
						if (firstpos != -1 && tempimageURL != null){
							tempimageURL = tempimageURL.substring(firstpos+1);
						}
						if (tempimageURL!=null&&tempimageURL!="") {
							imageURL = tempimageURL;
						}
						// prepare category ID array
						assetCategoryID = ceg.getCategoryId();
						alAssetCategoryIds.add(assetCategoryID);

						// prepare assatTagName array
						assetTagName = ceg.getKeywords();
						if ((assetTagName==null||assetTagName=="") && orgexist ) {
							assetTagName = org.getKeywords();
						}
											
						String tempAssetTagNames[] = assetTagName.split(",");
						int len = tempAssetTagNames.length;
						// test
						System.out.print(assetTagName + "\n" + "\n");

						for (int j = 0; j < len; j++) {
							alAssetTagNames.add(tempAssetTagNames[j]);
						}
					}

					// test
					System.out.print(imageURL + "\n" + "\n");
					System.out.print(description + "\n" + "\n");

					assetTagNames = alAssetTagNames.toArray(new String[0]);
					assetCategoryIds = alAssetCategoryIds.toArray(new Long[0]);
					
					// convert Long to long
					long[] assetCategoryIdsPrimLong = new long[assetCategoryIds.length];

					for(int index = 0; index < assetCategoryIds.length; index++)
					{
						assetCategoryIdsPrimLong[index] = assetCategoryIds[index];
					}

					ServiceContext serviceContext = new ServiceContext();

					serviceContext.setAddGroupPermissions(true);
					serviceContext.setAddGuestPermissions(true);

					// add organization to liferay
/*	deprecated				organization = OrganizationLocalServiceUtil
							.addOrganization(userId, parentOrganizationId, name,
									type, recursable, regionId, countryId,
									statusId, comments, true, serviceContext);
*/					
					organization = OrganizationLocalServiceUtil
							.addOrganization(userId, parentOrganizationId, name,
									type, regionId, countryId,
									statusId, comments, true, serviceContext);

					// restore liferayOrgId to Org table (for each line)
					Long liferayOrgId = organization.getOrganizationId();
					for (Ceg ceg : cegek) {

						ceg.setLiferayOrgId(liferayOrgId);
						CegLocalServiceUtil.updateCeg(ceg);
					}

					// Group

					Group group = organization.getGroup();
					GroupLocalServiceUtil.updateFriendlyURL(group.getGroupId(), "/"
							+ name);

					serviceContext.setScopeGroupId(group.getGroupId());

					// add Organization Address, Phone, Email, Website to liferay
					// organization

					// addOrganizationAddress () ;
					String className = Organization.class.getName();
					if (street1 != null && city != null) {

/*	deprecated					AddressLocalServiceUtil.addAddress(userId, className,
								organization.getOrganizationId(), street1, null,
								null, city, zip, regionId, countryId, addressType,
								false, false);
*/						
						AddressLocalServiceUtil.addAddress(userId, className,
								organization.getOrganizationId(), street1, null,
								null, city, zip, regionId, countryId, addressType,
								false, false, serviceContext);
					}
					// addOrganizationPhoneNumber ;

					// addOrganizationEmailAddress ;
					if (Validator.isEmailAddress(emailAddress)) {

						int typeId = 12004;
						EmailAddressLocalServiceUtil.addEmailAddress(userId,
								className, organization.getOrganizationId(),
								emailAddress, typeId, false, serviceContext);
						// test
						System.out.print("EmailAddress:" + emailAddress + "\n");
					}
					// addOrganizationWebSite () ;
					if (Validator.isUrl(webURL)) {

						int typeId = 12020;
						WebsiteLocalServiceUtil.addWebsite(userId, className,
								organization.getOrganizationId(), webURL, typeId,
								false, serviceContext);
						// for test
						System.out.print("Website:" + webURL + "\n");
					}

					// Layout set

					// add Logo
					String logoUrl = "/orgsetup/Logo/" + imageURL;
					System.out.print("Logo:" + logoUrl + "\n");
					LayoutSetLocalServiceUtil.updateLogo(group.getGroupId(), false,
							true, getInputStream(logoUrl));

/*					LayoutSetLocalServiceUtil.updateLookAndFeel(group.getGroupId(),
							false, "so_WAR_sotheme", "01", "", false);
*/					
					LayoutSetLocalServiceUtil.updateLookAndFeel(group.getGroupId(),
							false, "classic", "01", "", false);
				
					// if org != null			}
//				return ; // gyl beszúrás
	// for 1-9000		}
//		setuporgs }
	/*
			// Asset

			AssetVocabulary topicAssetVocabulary = addAssetVocabulary(
					defaultUserId, "Topic", serviceContext);

			AssetVocabulary imageAssetVocabulary = addAssetVocabulary(
					defaultUserId, "Image Type", serviceContext);

			AssetCategory iconAssetCategory = addAssetCategory(defaultUserId, 0,
					"Icon", imageAssetVocabulary.getVocabularyId(), serviceContext);

			AssetCategory bannerAssetCategory = addAssetCategory(defaultUserId, 0,
					"Banner", imageAssetVocabulary.getVocabularyId(),
					serviceContext);

			AssetCategory learningAssetCategory = addAssetCategory(defaultUserId,
					0, "Learning", topicAssetVocabulary.getVocabularyId(),
					serviceContext);

			AssetCategory productsAssetCategory = addAssetCategory(defaultUserId,
					0, "Products", topicAssetVocabulary.getVocabularyId(),
					serviceContext);

			AssetCategory liferayAssetCategory = addAssetCategory(defaultUserId, 0,
					"Liferay", topicAssetVocabulary.getVocabularyId(),
					serviceContext);

			_assetCategories = new HashMap<String, AssetCategory>();

			_assetCategories.put("Icon", iconAssetCategory);
			_assetCategories.put("Banner", bannerAssetCategory);
			_assetCategories.put("Learning", learningAssetCategory);
			_assetCategories.put("Products", productsAssetCategory);
			_assetCategories.put("Liferay", liferayAssetCategory);
	*/
	  		// Journal

			addJournalStructure(defaultUserId, group.getGroupId(),
					"/sample/journal/structures/single_image.xml");
			addJournalTemplate(defaultUserId, group.getGroupId(),
					"/sample/journal/templates/single_image.xml");

			// Image gallery

			serviceContext.setScopeGroupId(group.getGroupId());

			//gyl	
//			Folder folder = DLAppLocalServiceUtil.addFolder(defaultUserId,
//					group.getGroupId(), 0, "7Cogs Web Content",
//					"Images used for content", serviceContext);

	//gyl		
			Folder folder = DLAppLocalServiceUtil.addFolder(defaultUserId,
					group.getGroupId(), 0, "Content",
					"Images used for content", serviceContext);

//			serviceContext.setAssetTagNames(new String[] { "icons" });
//			serviceContext.setAssetCategoryIds(new long[] { iconAssetCategory
//					.getCategoryId() });

			
	//gyl		
			FileEntry logoFileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/orgsetup/Logo/" + imageURL,
					serviceContext);
			

	/*		FileEntry cogLightBlueIconFileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/sample/images/cog_light_blue.png",
					serviceContext);

			FileEntry cogOrangeIconFileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/sample/images/cog_orange.png",
					serviceContext);

			serviceContext.setAssetTagNames(new String[] { "home page", "blogs" });
			serviceContext.setAssetCategoryIds(new long[] { iconAssetCategory
					.getCategoryId() });

			FileEntry blogsIconFileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/sample/images/blogs_icon.png",
					serviceContext);

			serviceContext.setAssetTagNames(new String[] { "home page" });
			serviceContext.setAssetCategoryIds(new long[] { productsAssetCategory
					.getCategoryId() });

			FileEntry cogNetworkAdFileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(),
					"/sample/images/cog_network_advertisement.png", serviceContext);

			serviceContext.setAssetTagNames(new String[] { "home page", "forums" });
			serviceContext.setAssetCategoryIds(new long[] { iconAssetCategory
					.getCategoryId() });

			FileEntry forumsIconFileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/sample/images/forums_icon.png",
					serviceContext);

			serviceContext.setAssetTagNames(new String[] { "liferay", "logo" });
			serviceContext.setAssetCategoryIds(new long[] { liferayAssetCategory
					.getCategoryId() });

			FileEntry liferayLogoFileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/sample/images/liferay_logo.png",
					serviceContext);

			serviceContext.setAssetTagNames(new String[] { "home page" });
			serviceContext.setAssetCategoryIds(new long[] { bannerAssetCategory
					.getCategoryId() });

			FileEntry homePageBannerFileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/sample/images/home_page_banner.png",
					serviceContext);

			serviceContext
					.setAssetTagNames(new String[] { "home page", "products" });
			serviceContext.setAssetCategoryIds(new long[] { iconAssetCategory
					.getCategoryId() });

			FileEntry productsIconFileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/sample/images/products_icon.png",
					serviceContext);

			serviceContext.setAssetTagNames(new String[] { "products" });
			serviceContext.setAssetCategoryIds(new long[] { productsAssetCategory
					.getCategoryId() });

			FileEntry productLandingFileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/sample/images/product_landing.png",
					serviceContext);
	*/
			// Home layout

			// Layout layout = addLayout(group, "Home", false, "/home", "home"); //
			// !!! elszáll mert nincs home nevû layout
	  		// Layout layout = addLayout(group, "Home", false, "/home",
			// "3_columns");
			Layout layout = addLayout(group, "Home", false, "/home",
					"1_2_1_columns");

			// Home Page Banner content portlet

			String portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-1");

			removePortletBorder(layout, portletId);

	// Ez mûködik
			
//			serviceContext.setAssetTagNames(new String[] {"árvíztűrőtükörfúrógép","Portál","Weblap","Honlap","Plakát","Szórólap","Katalógus","Nyomdai elõkészítés2","liferay", "7cogs" });

	// de ez a jó!!! Kérdõjel (?) nem lehet a tag-ban, mert az addJurnalArticle elszáll !!! 
					serviceContext.setAssetTagNames(assetTagNames);		
					serviceContext.setAssetCategoryIds(assetCategoryIdsPrimLong);
					
			JournalArticle journalArticle = addJournalArticle(defaultUserId,
					group.getGroupId(), "Banner",
					"/sample/journal/articles/home_page_banner.xml", serviceContext);

			
			
			String content = StringUtil
					.replace(
							journalArticle.getContent(),
							new String[] { "[$GROUP_ID$]",
									"[$HOME_PAGE_BANNER_R_FE_UUID$]" },
							new String[] {
									String.valueOf(group.getGroupId()),
									String.valueOf(logoFileEntry
											.getUuid()) });

	/* gyl		
			String content = StringUtil
					.replace(
							journalArticle.getContent(),
							new String[] { "[$GROUP_ID$]",
									"[$HOME_PAGE_BANNER_R_FE_UUID$]" },
							new String[] {
									String.valueOf(group.getGroupId()),
									String.valueOf(logoFileEntry
											.getUuid()) });
	*/
	  		JournalArticleLocalServiceUtil.updateContent(group.getGroupId(),
					journalArticle.getArticleId(), journalArticle.getVersion(),
					content);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			// Home Page Products Button content portlet
	/*
			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-2");

			removePortletBorder(layout, portletId);

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"Products Button",
					"/sample/journal/articles/home_page_products_button.xml",
					serviceContext);

			content = StringUtil.replace(
					journalArticle.getContent(),
					new String[] { "[$GROUP_ID$]",
							"[$HOME_PAGE_PRODUCTS_R_FE_UUID$]" },
					new String[] { String.valueOf(group.getGroupId()),
							String.valueOf(logoFileEntry.getUuid()) });

			JournalArticleLocalServiceUtil.updateContent(group.getGroupId(),
					journalArticle.getArticleId(), journalArticle.getVersion(),
					content);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			// Home Page Blogs Button content portlet

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-3");

			removePortletBorder(layout, portletId);

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"Blogs Button",
					"/sample/journal/articles/home_page_blogs_button.xml",
					serviceContext);

			content = StringUtil
					.replace(journalArticle.getContent(), new String[] {
							"[$GROUP_ID$]", "[$HOME_PAGE_BLOGS_R_FE_UUID$]" },
							new String[] { String.valueOf(group.getGroupId()),
									String.valueOf(logoFileEntry.getUuid()) });

			JournalArticleLocalServiceUtil.updateContent(group.getGroupId(),
					journalArticle.getArticleId(), journalArticle.getVersion(),
					content);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			// Home Page Forums Button content porltet

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-4");

			removePortletBorder(layout, portletId);

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"Forums Button",
					"/sample/journal/articles/home_page_forums_button.xml",
					serviceContext);

			content = StringUtil
					.replace(journalArticle.getContent(), new String[] {
							"[$GROUP_ID$]", "[$HOME_PAGE_FORUMS_R_FE_UUID$]" },
							new String[] { String.valueOf(group.getGroupId()),
									String.valueOf(logoFileEntry.getUuid()) });

			JournalArticleLocalServiceUtil.updateContent(group.getGroupId(),
					journalArticle.getArticleId(), journalArticle.getVersion(),
					content);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			// Home Page Intro content portlet

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-4");

			removePortletBorder(layout, portletId);

			serviceContext.setAssetTagNames(new String[] { "front" });

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"Home Page Intro",
					"/sample/journal/articles/home_page_intro.xml", serviceContext);

			content = StringUtil
					.replace(
							journalArticle.getContent(),
							new String[] { "[$GROUP_ID$]",
									"[$PRODUCT_LANDING_R_FE_UUID$]" },
							new String[] {
									String.valueOf(group.getGroupId()),
									String.valueOf(logoFileEntry
											.getUuid()) });

			JournalArticleLocalServiceUtil.updateContent(group.getGroupId(),
					journalArticle.getArticleId(), journalArticle.getVersion(),
					content);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			// Cog Network Ad content portlet

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-4");

			removePortletBorder(layout, portletId);

			serviceContext
					.setAssetTagNames(new String[] { "liferay", "enterprise" });

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"Cog Network Ad",
					"/sample/journal/articles/home_cog_network_ad.xml",
					serviceContext);

			content = StringUtil
					.replace(
							journalArticle.getContent(),
							new String[] { "[$GROUP_ID$]",
									"[$COG_NETWORK_AD_R_FE_UUID$]" },
							new String[] { String.valueOf(group.getGroupId()),
									String.valueOf(logoFileEntry.getUuid()) });

			JournalArticleLocalServiceUtil.updateContent(group.getGroupId(),
					journalArticle.getArticleId(), journalArticle.getVersion(),
					content);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			// Products layout

			layout = addLayout(group, "Products", false, "/products",
					"1_2_columns_ii");

			// Products Banner content portlet

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-1");

			removePortletBorder(layout, portletId);

			serviceContext.setAssetTagNames(new String[] { "Vix-998", "7cogs" });

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"Products Banner",
					"/sample/journal/articles/products_banner.xml", serviceContext);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			// Products Landing Intro content portlet

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-2");

			removePortletBorder(layout, portletId);

			serviceContext.setAssetTagNames(new String[] { "products" });

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"Products Landing Intro",
					"/sample/journal/articles/products_landing_intro.xml",
					serviceContext);

			content = StringUtil
					.replace(
							journalArticle.getContent(),
							new String[] { "[$GROUP_ID$]",
									"[$PRODUCT_LANDING_R_FE_UUID$]" },
							new String[] {
									String.valueOf(group.getGroupId()),
									String.valueOf(logoFileEntry
											.getUuid()) });

			JournalArticleLocalServiceUtil.updateContent(group.getGroupId(),
					journalArticle.getArticleId(), journalArticle.getVersion(),
					content);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			// Products Landing Intro Info content portlet

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-2");

			removePortletBorder(layout, portletId);

			serviceContext.setAssetTagNames(new String[] { "products" });

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"Products Landing Intro Info",
					"/sample/journal/articles/products_landing_intro_info.xml",
					serviceContext);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			// Introducing Vix content portlet

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-3");

			removePortletBorder(layout, portletId);

			serviceContext.setAssetTagNames(new String[] { "Vix-998", "7cogs" });

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"Products Catalog",
					"/sample/journal/articles/products_catalog.xml", serviceContext);

			content = StringUtil.replace(journalArticle.getContent(), new String[] {
					"[$COG_BLUE_R_FE_UUID$]", "[$COG_LIGHT_BLUE_R_FE_UUID$]",
					"[$COG_ORANGE_R_FE_UUID$]", "[$GROUP_ID$]" },
					new String[] { String.valueOf(logoFileEntry.getUuid()),
							String.valueOf(logoFileEntry.getUuid()),
							String.valueOf(logoFileEntry.getUuid()),
							String.valueOf(group.getGroupId()) });

			JournalArticleLocalServiceUtil.updateContent(group.getGroupId(),
					journalArticle.getArticleId(), journalArticle.getVersion(),
					content);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());
	*/
	/*
			// Blogs layout

			layout = addLayout(group, "Blogs", false, "/blogs", "1_2_columns_i");

			// Blogs Banner content portlet

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-1");

			removePortletBorder(layout, portletId);

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"Blogs Banner", "/sample/journal/articles/blogs_banner.xml",
					serviceContext);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			// Recent Bloggers portlet

			addPortletId(layout, PortletKeys.RECENT_BLOGGERS, "column-2");

			// Blogs Aggregator portlet

			portletId = addPortletId(layout, PortletKeys.BLOGS_AGGREGATOR,
					"column-3");

			configurePortletTitle(layout, portletId, "Blogs");

			// Wiki layout

			layout = addLayout(group, "Wiki", false, "/wiki", "1_column");

			// Wiki Banner content portlet

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-1");

			removePortletBorder(layout, portletId);

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"Wiki Banner", "/sample/journal/articles/wiki_banner.xml",
					serviceContext);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			// Wiki portlet

			portletId = addPortletId(layout, PortletKeys.WIKI, "column-1");

			removePortletBorder(layout, portletId);

			WikiNode wikiNode = WikiNodeLocalServiceUtil.addNode(defaultUserId,
					"Main", StringPool.BLANK, serviceContext);

			serviceContext.setAssetTagNames(new String[] { "new", "features" });
			serviceContext.setAssetCategoryIds(new long[] { learningAssetCategory
					.getCategoryId() });

			addWikiPage(defaultUserId, wikiNode.getNodeId(), "FrontPage",
					"/sample/wiki/FrontPage.xml", serviceContext);

			serviceContext.setAssetTagNames(new String[] { "vix-998", "features" });
			serviceContext.setAssetCategoryIds(new long[] { productsAssetCategory
					.getCategoryId() });

			addWikiPage(defaultUserId, wikiNode.getNodeId(), "Vix-998",
					"/sample/wiki/Vix-998.xml", serviceContext);

			// Forums layout

			layout = addLayout(group, "Forums", false, "/forums", "1_column");

			// Forums Banner content portlet

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-1");

			removePortletBorder(layout, portletId);

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"Forums Banner", "/sample/journal/articles/forums_banner.xml",
					serviceContext);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			// Message Boards portlet

			portletId = addPortletId(layout, PortletKeys.MESSAGE_BOARDS, "column-1");

			removePortletBorder(layout, portletId);

			// Dashboard layout

			layout = addLayout(group, "Dashboard", false, "/dashboard",
					"2_columns_ii");

			portletId = addPortletId(layout, PortletKeys.USER_STATISTICS,
					"column-1");

			configureUserStatistics(layout, portletId, new String[] {
					"user.message-posts", "user.blogs", "user.wikis" });

			// Group Statistics portlet

			portletId = addPortletId(layout, PortletKeys.GROUP_STATISTICS,
					"column-2");

			String[][] chartData = new String[3][4];

			chartData[0] = new String[] { "user.message-posts", "area", "12months",
					"40" };
			chartData[1] = new String[] { "asset.activities", "pie", "12months",
					"50" };
			chartData[2] = new String[] { "asset.activities", "tag-cloud",
					"12months", "40" };

			configureGroupStatistics(layout, portletId, chartData);

			// Activities portlet

			portletId = addPortletId(layout, PortletKeys.ACTIVITIES, "column-2");

			// About Us layout

			layout = addLayout(group, "About Us", false, "/about_us",
					"1_2_columns_ii");

			// About Us Banner content portlet

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-1");

			removePortletBorder(layout, portletId);

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"About Us Banner",
					"/sample/journal/articles/about_us_banner.xml", serviceContext);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			// About Us content portlet

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-2");

			highlightPortlet(layout, portletId);

			serviceContext.setAssetTagNames(new String[] { "liferay" });

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"About Us", "/sample/journal/articles/home_7cogs_about_us.xml",
					serviceContext);

			content = StringUtil.replace(
					journalArticle.getContent(),
					new String[] { "[$GROUP_ID$]", "[$LIFERAY_LOGO_R_FE_UUID$]" },
					new String[] { String.valueOf(group.getGroupId()),
							String.valueOf(liferayLogoFileEntry.getUuid()) });

			JournalArticleLocalServiceUtil.updateContent(group.getGroupId(),
					journalArticle.getArticleId(), journalArticle.getVersion(),
					content);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());
	*/
			/*
			 * // Google Maps
			 * 
			 * portletId = addPortletId(layout, "1_WAR_googlemapsportlet",
			 * "column-2");
			 * 
			 * Map<String, String> preferences = new HashMap<String, String>();
			 * 
			 * preferences.put("mapAddress", "Los Angeles, USA");
			 * preferences.put("height", "300");
			 * 
			 * updatePortletSetup(layout, portletId, preferences);
			 * 
			 * // Web Form
			 * 
			 * addPortletId(layout, "1_WAR_webformportlet", "column-3");
			 */
			// Home layout

			layout = addLayout(group, "Home", true, "/home", "2_columns_ii");

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-1");

			highlightPortlet(layout, portletId);

//			serviceContext.setAssetTagNames(new String[] { "7cogs", "tips" });

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"Home",
					"/sample/journal/articles/home_7cogs_private_pages.xml",
					serviceContext);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			portletId = addPortletId(layout, PortletKeys.ACTIVITIES, "column-2");

			configurePortletTitle(layout, portletId,
					"Last Activities in "+name+" Organization");

			// Documents layout

			layout = addLayout(group, "Documents", true, "/documents",
					"2_columns_iii");

			addPortletId(layout, PortletKeys.DOCUMENT_LIBRARY, "column-1");
			addPortletId(layout, PortletKeys.MEDIA_GALLERY_DISPLAY, "column-1");

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-2");

			highlightPortlet(layout, portletId);

			serviceContext
					.setAssetTagNames(new String[] { "documents", "sharing" });

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"Shared Documents",
					"/sample/journal/articles/documents_shared_docs.xml",
					serviceContext);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			}
		}
	}

		public static void setupOrgCategories() throws Exception {
		
				List<Ceg> cegek;
				List<AssetCategory> assetCategories;
				assetCategories = AssetCategoryLocalServiceUtil.getCategories();
				
				for(AssetCategory assetCategory : assetCategories ){
				
					String categoryname= assetCategory.getName();
					Long categoryId= assetCategory.getCategoryId();
  					cegek = CegLocalServiceUtil.getAllCegByCategoryNames(categoryname);
					
					for(Ceg ceg : cegek ){
						
						ceg.setCategoryId(categoryId);
						CegLocalServiceUtil.updateCeg(ceg);
					
						System.out.print(ceg.getOrgname()+"\n");
					}
					System.out.print(categoryname+"\n");
				} 
				System.out.print("vege\n");
			}
		
		public static void setupProductPageURL() throws Exception {
				
			List<Product> products = ProductLocalServiceUtil.getAllProducts();
						
			for(Product product : products ){
			
				String pageURLAzon;
				String pageURL= product.getPageURL();
				
				int lastpos = pageURL.lastIndexOf("/");
				if (lastpos != -1 && pageURL != null){
					pageURLAzon = pageURL.substring(0,lastpos);
					product.setPageURLAzon(pageURLAzon);
					ProductLocalServiceUtil.updateProduct(product);
					System.out.print(pageURL+"\n");
					System.out.print(pageURLAzon+"\n");
				}
			} 
			System.out.print("vege\n");
		}
	
		
		protected static void setupRoles(long companyId, long defaultUserId)
				throws Exception {

			Map<Locale, String> descriptionMap = new HashMap<Locale, String>();

			setLocalizedValue(descriptionMap,
					"Publishers are responsible for publishing content.");

			Role publisherRole = RoleLocalServiceUtil.fetchRole(companyId,
					"Publisher");

			if (publisherRole == null) {
				publisherRole = RoleLocalServiceUtil.addRole(defaultUserId,
						companyId, "Publisher", null, descriptionMap,
						RoleConstants.TYPE_REGULAR);
			}

			setRolePermissions(publisherRole, PortletKeys.JOURNAL,
					new String[] { ActionKeys.ACCESS_IN_CONTROL_PANEL });

			setRolePermissions(publisherRole, "com.liferay.portlet.journal",
					new String[] { ActionKeys.ADD_ARTICLE, ActionKeys.ADD_FEED,
							ActionKeys.ADD_STRUCTURE, ActionKeys.ADD_TEMPLATE });

			setRolePermissions(publisherRole, JournalArticle.class.getName(),
					new String[] { ActionKeys.ADD_DISCUSSION, ActionKeys.DELETE,
							ActionKeys.EXPIRE, ActionKeys.PERMISSIONS,
							ActionKeys.UPDATE, ActionKeys.VIEW });

			descriptionMap.clear();

			setLocalizedValue(descriptionMap,
					"Writers are responsible for creating content.");

			Role writerRole = RoleLocalServiceUtil.fetchRole(companyId, "Writer");

			if (writerRole == null) {
				writerRole = RoleLocalServiceUtil.addRole(defaultUserId, companyId,
						"Writer", null, descriptionMap, RoleConstants.TYPE_REGULAR);
			}

			setRolePermissions(writerRole, PortletKeys.JOURNAL,
					new String[] { ActionKeys.ACCESS_IN_CONTROL_PANEL });

			setRolePermissions(writerRole, "com.liferay.portlet.journal",
					new String[] { ActionKeys.ADD_ARTICLE, ActionKeys.ADD_FEED,
							ActionKeys.ADD_STRUCTURE, ActionKeys.ADD_TEMPLATE });

			setRolePermissions(writerRole, JournalArticle.class.getName(),
					new String[] { ActionKeys.UPDATE, ActionKeys.VIEW });
		}

		protected static void setupSites(long companyId, long defaultUserId)
				throws Exception {

			// Guest site

			Group group = GroupLocalServiceUtil.getGroup(companyId,
					GroupConstants.GUEST);

			// Journal

			addJournalStructure(defaultUserId, group.getGroupId(),
					"/guest/journal/structures/single_image.xml");
			addJournalTemplate(defaultUserId, group.getGroupId(),
					"/guest/journal/templates/single_image.xml");

			// Image gallery

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);
			serviceContext.setScopeGroupId(group.getGroupId());

			Folder folder = DLAppLocalServiceUtil.addFolder(defaultUserId,
					group.getGroupId(), 0, "Web Content",
					"Images used for content", serviceContext);

			FileEntry cellBgFileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/guest/images/cell_bg.png",
					serviceContext);

			FileEntry customer1FileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/guest/images/customer_1.png",
					serviceContext);

			FileEntry customer2FileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/guest/images/customer_2.png",
					serviceContext);

			FileEntry customer3FileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/guest/images/customer_3.png",
					serviceContext);

			FileEntry customer4FileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/guest/images/customer_4.png",
					serviceContext);

			FileEntry customer5FileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/guest/images/customer_5.png",
					serviceContext);

			FileEntry customer6FileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/guest/images/customer_6.png",
					serviceContext);

			FileEntry customer7FileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/guest/images/customer_7.png",
					serviceContext);

			FileEntry portalMashupFileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/guest/images/portal_mashup.png",
					serviceContext);

			FileEntry sevenCogsAdFileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/guest/images/sevencogs_ad.png",
					serviceContext);

			FileEntry sharedWorkspacesFileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/guest/images/shared_workspaces.png",
					serviceContext);

			FileEntry socialNetworkingFileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/guest/images/social_network.png",
					serviceContext);

			FileEntry webPublishingFileEntry = addDLFileEntry(defaultUserId,
					folder.getFolderId(), "/guest/images/web_publishing.png",
					serviceContext);

			// Site theme settings

			String noPortletBorders = "lfr-theme:regular:portlet-setup-show-borders-default=false";

			LayoutSetLocalServiceUtil.updateSettings(group.getGroupId(), false,
					noPortletBorders);

			// Welcome layout

			Layout layout = addLayout(group, "Welcome", false, "/home",
					"2_columns_iii");

			// Welcome content portlet

			String portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-1");

			removePortletBorder(layout, portletId);

			serviceContext.setAssetTagNames(new String[] { "liferay", "welcome" });

			JournalArticle journalArticle = addJournalArticle(defaultUserId,
					group.getGroupId(), "Welcome",
					"/guest/journal/articles/welcome.xml", serviceContext);

			String content = StringUtil.replace(
					journalArticle.getContent(),
					new String[] { "[$CELL_BG_R_FE_UUID$]",
							"[$CUSTOMER_1_R_FE_UUID$]", "[$CUSTOMER_2_R_FE_UUID$]",
							"[$CUSTOMER_3_R_FE_UUID$]", "[$CUSTOMER_4_R_FE_UUID$]",
							"[$CUSTOMER_5_R_FE_UUID$]", "[$CUSTOMER_6_R_FE_UUID$]",
							"[$CUSTOMER_7_R_FE_UUID$]", "[$GROUP_ID$]",
							"[$PORTAL_MASHUPS_R_FE_UUID$]",
							"[$SHARED_WORKSPACES_R_FE_UUID$]",
							"[$SOCIAL_NETWORKING_R_FE_UUID$]",
							"[$WEB_PUBLISHING_R_FE_UUID$]" },
					new String[] { String.valueOf(cellBgFileEntry.getUuid()),
							String.valueOf(customer1FileEntry.getUuid()),
							String.valueOf(customer2FileEntry.getUuid()),
							String.valueOf(customer3FileEntry.getUuid()),
							String.valueOf(customer4FileEntry.getUuid()),
							String.valueOf(customer5FileEntry.getUuid()),
							String.valueOf(customer6FileEntry.getUuid()),
							String.valueOf(customer7FileEntry.getUuid()),
							String.valueOf(group.getGroupId()),
							String.valueOf(portalMashupFileEntry.getUuid()),
							String.valueOf(sharedWorkspacesFileEntry.getUuid()),
							String.valueOf(socialNetworkingFileEntry.getUuid()),
							String.valueOf(webPublishingFileEntry.getUuid()) });

			JournalArticleLocalServiceUtil.updateContent(group.getGroupId(),
					journalArticle.getArticleId(), journalArticle.getVersion(),
					content);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			// 7Cogs Ad content portlet

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-2");

			removePortletBorder(layout, portletId);

			serviceContext.setAssetTagNames(new String[] { "liferay", "7cogs" });

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"7Cogs Ad", "/guest/journal/articles/sample_site_ad.xml",
					serviceContext);

			content = StringUtil
					.replace(
							journalArticle.getContent(),
							new String[] { "[$GROUP_ID$]", "[$GROUP_URL$]",
									"[$R_FE_UUID$]" },
							new String[] { String.valueOf(group.getGroupId()),
									"/web/7cogs/home",
									String.valueOf(sevenCogsAdFileEntry.getUuid()) });

			JournalArticleLocalServiceUtil.updateContent(group.getGroupId(),
					journalArticle.getArticleId(), journalArticle.getVersion(),
					content);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			// Welcome Note content portlet

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-2");

			removePortletBorder(layout, portletId);

			serviceContext.setAssetTagNames(new String[] { "welcome" });

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"Welcome Note", "/guest/journal/articles/welcome_note.xml",
					serviceContext);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			// Welcome Login content portlet

			portletId = addPortletId(layout, PortletKeys.JOURNAL_CONTENT,
					"column-2");

			serviceContext.setAssetTagNames(new String[] { "login", "users",
					"welcome" });

			journalArticle = addJournalArticle(defaultUserId, group.getGroupId(),
					"Welcome Login", "/guest/journal/articles/welcome_login.xml",
					serviceContext);

			content = StringUtil.replace(journalArticle.getContent(),
					"[$COMPANY_ID$]", String.valueOf(companyId));

			JournalArticleLocalServiceUtil.updateContent(group.getGroupId(),
					journalArticle.getArticleId(), journalArticle.getVersion(),
					content);

			configureJournalContent(layout, portletId,
					journalArticle.getArticleId());

			configurePortletTitle(layout, portletId, "Current Users");

			// Login portlet

			addPortletId(layout, PortletKeys.LOGIN, "column-2");
		}

		protected static void setupSocialActivityCounters(Group group,
				List<User> users) throws Exception {

			enableSocialActivities(group.getGroupId());

			addSocialActivityCounters(group, users, "asset.activities");
			addSocialActivityCounters(group, users, "contribution");
			addSocialActivityCounters(group, users, "participation");
			addSocialActivityCounters(group, users, "user.message-posts");
		}

		protected static List<User> setupUsers(long companyId) throws Exception {

			// Roles

			Role adminRole = RoleLocalServiceUtil.getRole(companyId,
					RoleConstants.ADMINISTRATOR);

			Role portalContentReviewer = RoleLocalServiceUtil.getRole(companyId,
					"Portal Content Reviewer");

			Role powerUserRole = RoleLocalServiceUtil.getRole(companyId,
					RoleConstants.POWER_USER);

			Role publisherRole = RoleLocalServiceUtil.getRole(companyId,
					"Publisher");

			Role writerRole = RoleLocalServiceUtil.getRole(companyId, "Writer");

			// Users

			long[] roleIds = { adminRole.getRoleId(), powerUserRole.getRoleId() };

			User brunoUser = addUser(companyId, "bruno", "Bruno", "Admin", true,
					"Administrator", roleIds);

			List<User> users = new ArrayList<User>();

			users.add(brunoUser);

			roleIds = new long[] { powerUserRole.getRoleId() };

			User kendraUser = addUser(companyId, "kendra", "Kendra", "Regular",
					true, "Employee", roleIds);

			users.add(kendraUser);

			roleIds = new long[] { powerUserRole.getRoleId(),
					writerRole.getRoleId() };

			User michelleUser = addUser(companyId, "michelle", "Michelle",
					"Writer", false, "Writer", roleIds);

			users.add(michelleUser);

			roleIds = new long[] { powerUserRole.getRoleId(),
					publisherRole.getRoleId(), portalContentReviewer.getRoleId() };

			User richardUser = addUser(companyId, "richard", "Richard",
					"Publisher", true, "Publisher", roleIds);

			users.add(richardUser);

			// Asset

			AssetCategory learningAssetCategory = _assetCategories.get("Learning");
			AssetCategory liferayAssetCategory = _assetCategories.get("Liferay");

			// Blogs

			ServiceContext serviceContext = new ServiceContext();

			serviceContext.setAssetTagNames(new String[] { "new", "features",
					"control panel" });
			serviceContext.setAssetCategoryIds(new long[] {
					learningAssetCategory.getCategoryId(),
					liferayAssetCategory.getCategoryId() });
			serviceContext.setScopeGroupId(brunoUser.getGroupId());

			addBlogsEntry(brunoUser.getUserId(), "New Control Panel!!",
					"/users/blogs/controlpanel.xml", serviceContext);

			serviceContext.setAssetCategoryIds(new long[] {
					learningAssetCategory.getCategoryId(),
					liferayAssetCategory.getCategoryId() });
			serviceContext.setAssetTagNames(new String[] { "configuration",
					"portal.properties", "customization" });

			addBlogsEntry(brunoUser.getUserId(),
					"Configuration of the portal: portal.properties",
					"/users/blogs/portalproperties.xml", serviceContext);

			serviceContext.setAssetCategoryIds(new long[] {
					learningAssetCategory.getCategoryId(),
					liferayAssetCategory.getCategoryId() });
			serviceContext.setAssetTagNames(new String[] { "new", "wiki",
					"knowledge" });
			serviceContext.setScopeGroupId(kendraUser.getGroupId());

			addBlogsEntry(kendraUser.getUserId(), "Using the wiki",
					"/users/blogs/wiki.xml", serviceContext);

			serviceContext.setAssetCategoryIds(new long[] {
					learningAssetCategory.getCategoryId(),
					liferayAssetCategory.getCategoryId() });
			serviceContext.setAssetTagNames(new String[] { "new", "chat",
					"communications", "features" });
			serviceContext.setScopeGroupId(michelleUser.getGroupId());

			addBlogsEntry(michelleUser.getUserId(), "We have an amazing Chat!",
					"/users/blogs/chat.xml", serviceContext);

			// Document library

			Folder folder = addDLFolder(brunoUser.getUserId(),
					brunoUser.getGroupId(), "Important Documents",
					"Documents related with the company");

			serviceContext.setAssetTagNames(new String[] { "document", "budget",
					"2009" });

			addDLFileEntry(brunoUser.getUserId(), folder.getGroupId(),
					folder.getFolderId(), "/users/document_library/Budget.xls",
					"Budget.xls", ContentTypes.APPLICATION_VND_MS_EXCEL, "Budget",
					"Budgets for the current year", serviceContext);

			addDLFolder(michelleUser.getUserId(), michelleUser.getGroupId(),
					"My Documents", "Personal docs");

			folder = addDLFolder(michelleUser.getUserId(),
					michelleUser.getGroupId(), "Work Documents", "Works docs");

			serviceContext.setAssetTagNames(new String[] { "document", "notes",
					"meeting" });

			addDLFileEntry(michelleUser.getUserId(), folder.getGroupId(),
					folder.getFolderId(),
					"/users/document_library/Notes from the last meeting.doc",
					"Notes from the last meeting.doc",
					ContentTypes.APPLICATION_MSWORD, "Notes from the last meeting",
					"Important notes", serviceContext);

			addDLFolder(richardUser.getUserId(), richardUser.getGroupId(),
					"Documentation", StringPool.BLANK);

			folder = addDLFolder(richardUser.getUserId(), richardUser.getGroupId(),
					"Innovation", "New things");

			serviceContext.setAssetTagNames(new String[] { "new", "features",
					"2009" });

			addDLFileEntry(richardUser.getUserId(), folder.getGroupId(),
					folder.getFolderId(),
					"/users/document_library/New Features.ppt", "New Features.ppt",
					ContentTypes.APPLICATION_VND_MS_POWERPOINT, "New Features",
					"Features for the current year", serviceContext);

			// Message boards

			Organization sevenCogsOrganization = OrganizationLocalServiceUtil
					.getOrganization(companyId, "7Cogs, Inc.");

			serviceContext.setScopeGroupId(sevenCogsOrganization.getGroupId());

			MBCategory mbCategory = addMBCategory(brunoUser.getUserId(),
					"Using the forum", "Some advice on using the forum",
					serviceContext);

			serviceContext.setAssetTagNames(new String[] { "forums", "liferay",
					"7cogs" });

			addMBMessage(brunoUser.getUserId(), brunoUser.getFullName(),
					mbCategory.getGroupId(), mbCategory.getCategoryId(), 0, 0,
					"Nice Forums", "/sample/message_boards/general.xml",
					serviceContext);

			mbCategory = addMBCategory(brunoUser.getUserId(), "General Questions",
					"Product questions and more!", serviceContext);

			serviceContext.setAssetTagNames(new String[] { "vix-998", "liferay" });

			MBMessage vix1Message = addMBMessage(brunoUser.getUserId(),
					brunoUser.getFullName(), mbCategory.getGroupId(),
					mbCategory.getCategoryId(), 0, 0, "About the Vix-998",
					"/sample/message_boards/vix1.xml", serviceContext);

			serviceContext.setAssetTagNames(new String[] { "vix-998", "latin" });

			MBMessage vix2Message = addMBMessage(richardUser.getUserId(),
					richardUser.getFullName(), mbCategory.getGroupId(),
					mbCategory.getCategoryId(), vix1Message.getThreadId(),
					vix1Message.getMessageId(), "RE: About the Vix-998",
					"/sample/message_boards/vix2.xml", serviceContext);

			serviceContext.setAssetTagNames(new String[] { "vix-998", "vulgo" });

			addMBMessage(michelleUser.getUserId(), michelleUser.getFullName(),
					mbCategory.getGroupId(), mbCategory.getCategoryId(),
					vix1Message.getThreadId(), vix2Message.getMessageId(),
					"RE: About the Vix-998", "/sample/message_boards/vix3.xml",
					serviceContext);

			// Social

			addSocialRequest(michelleUser, brunoUser, true);
			addSocialRequest(michelleUser, kendraUser, true);
			addSocialRequest(michelleUser, richardUser, true);

			addSocialRequest(kendraUser, brunoUser, false);
			addSocialRequest(kendraUser, richardUser, false);

			return users;
		}

		protected static void setupWorkflow(long companyId, long defaultUserId)
				throws Exception {

			Group group = GroupLocalServiceUtil.getGroup(companyId,
					GroupConstants.GUEST);

			String workflowDefinitionName = "Single Approver";
			int workflowDefinitionVersion = 1;

			WorkflowDefinitionLinkLocalServiceUtil.updateWorkflowDefinitionLink(
					defaultUserId, companyId, group.getGroupId(),
					JournalArticle.class.getName(), 0, 0, workflowDefinitionName,
					workflowDefinitionVersion);
		}

		protected static void updateLayout(Layout layout) throws Exception {
			LayoutLocalServiceUtil.updateLayout(layout.getGroupId(),
					layout.isPrivateLayout(), layout.getLayoutId(),
					layout.getTypeSettings());
		}

		protected static PortletPreferences updatePortletSetup(Layout layout,
				String portletId, Map<String, String> preferences) throws Exception {

			PortletPreferences portletSetup = PortletPreferencesFactoryUtil
					.getLayoutPortletSetup(layout, portletId);

			Iterator<Map.Entry<String, String>> itr = preferences.entrySet()
					.iterator();

			while (itr.hasNext()) {
				Map.Entry<String, String> entry = itr.next();

				String key = entry.getKey();
				String value = entry.getValue();

				portletSetup.setValue(key, value);
			}

			portletSetup.store();

			return portletSetup;
		}

/*git-ből		private static int _PERMISSIONS_USER_CHECK_ALGORITHM = GetterUtil
				.getInteger(PropsUtil
						.get(PropsKeys.PERMISSIONS_USER_CHECK_ALGORITHM));

*/
		private static final int _SN_FRIENDS_REQUEST_KEYS_ADD_FRIEND = 1;

		private static Map<String, AssetCategory> _assetCategories;


	
}
