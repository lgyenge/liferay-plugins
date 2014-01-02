package com.dinet.organization.util;

import com.dinet.organization.util.SocialRelationConstants;

public class ContactsConstants {
	
	public static final int DISPLAY_STYLE_BASIC = 1;

	public static final String DISPLAY_STYLE_BASIC_LABEL = "basic";

	public static final int DISPLAY_STYLE_DETAIL = 2;

	public static final String DISPLAY_STYLE_DETAIL_LABEL = "detail";

	public static final int DISPLAY_STYLE_FULL = 3;

	public static final String DISPLAY_STYLE_FULL_LABEL = "full";

	public static final String FILTER_BY_DEFAULT = "default";

	public static final String FILTER_BY_GROUP = "group_";

	public static final String FILTER_BY_TYPE = "type_";

	public static final String FILTER_BY_TYPE_BI_CONNECTION =
		FILTER_BY_TYPE + SocialRelationConstants.TYPE_BI_CONNECTION;

	public static final String FILTER_BY_TYPE_MY_CONTACTS =
		FILTER_BY_TYPE + SocialRelationConstants.TYPE_MY_CONTACTS;

	public static final String FILTER_BY_TYPE_UNI_FOLLOWER =
		FILTER_BY_TYPE + SocialRelationConstants.TYPE_UNI_FOLLOWER;

	public static final int MAX_RESULT_COUNT = 100;

	public static String getDisplayStyleLabel(int displayStyle) {
		if (displayStyle == DISPLAY_STYLE_BASIC) {
			return DISPLAY_STYLE_BASIC_LABEL;
		}
		else if (displayStyle == DISPLAY_STYLE_DETAIL) {
			return DISPLAY_STYLE_DETAIL_LABEL;
		}
		else if (displayStyle == DISPLAY_STYLE_FULL) {
			return DISPLAY_STYLE_FULL_LABEL;
		}
		else {
			return null;
		}
	}


}
