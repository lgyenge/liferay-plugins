
package com.dinet.organization.util;

public class OrganizationportletConstants {
	
	public static final int DISPLAY_STYLE_BASIC = 1;

	public static final String DISPLAY_STYLE_BASIC_LABEL = "basic";

	public static final int DISPLAY_STYLE_DETAIL = 2;

	public static final String DISPLAY_STYLE_DETAIL_LABEL = "detail";

	public static final int DISPLAY_STYLE_FULL = 3;

	public static final String DISPLAY_STYLE_FULL_LABEL = "full";

	public static final String FILTER_BY_DEFAULT = "default";

	public static final String FILTER_BY_GROUP = "group_";

	public static final String FILTER_BY_TYPE = "type_";

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
