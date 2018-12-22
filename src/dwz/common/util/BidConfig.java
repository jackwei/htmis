package dwz.common.util;

import java.io.FileInputStream;
import java.util.Properties;

public class BidConfig {

	private static final String propertiesName = "params.properties";

	private static Properties props = null;

	static {
		String path = BidConfig.class.getResource("/").getPath();
		if (false == path.endsWith("/")) {
			path += "/";
		}
		String filename = path + propertiesName;

		try {
			FileInputStream fis = new FileInputStream(filename);
			props = new Properties();
			props.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getSysId() {
		return getProp("sys_id");
	}

	public static String getWebServiceSeid() {
		return getProp("webservice_seid");
	}

	public static String getWebServiceGroupId() {
		return getProp("webservice_groupid");
	}

	public static String[] getWebServiceAllowIp() {
		String ips = getProp("webservice_allow_ip");

		if (isEmpty(ips)) {
			return null;
		} else {
			return ips.split(",");
		}
	}
	
	public static boolean isEmpty(String str) {
		return (null == str || str.trim().equals(""));
	}

	public static String getAgentGroup() {
		return getProp("agent_group");
	}

	public static String getOtaiDir(){
		return getProp("OTAI.INFORMATION.DIR");
	}
	/**
	 * �Ƿ�����Ķ�����
	 * 
	 * @return
	 */
	public static String getRuleCtrl() {
		return "T".equalsIgnoreCase(getProp("rule_ctrl")) ? "T" : "F";
	}

	private static String getProp(String key) {
		if (props == null)
			return "";
		return props.getProperty(key);
	}

	public static String getOrgCname() {

		return getProp("org_cname");
	}

	public static String getOrgEname() {
		return getProp("org_ename");
	}

	/**
	 * �õ����Ի�����Ŀ¼
	 * 
	 * @return
	 */
	public static String getOrgDir() {
		return "/config/" + getOrgEname();
	}

	public static boolean isUC() {

		return "true".equals(getProp("bid_use_uc"));
	}

	public static String getUCDomain() {
		return getProp("IFLOW_SITE_DOMAIN");
	}

	public static String getHallStyle() {
		return getProp("hall_style");
	}

	public static String getUCUrl() {
		return getProp("zbxuc_webservice_url");
	}

	public static String getUserRegUrl() {
		return getProp("user_reg");
	}

	public static String getUserLoginUrl() {
		String url = getProp("user_login");
		return url;
	}

	public static String getUserLogoutUrl() {
		return getProp("user_logout");
	}

	public static String getAdminLoginUrl() {
		return getProp("admin_login");
	}

	public static String getAdminLogoutUrl() {
		return getProp("admin_logout");
	}

	public static boolean isSingleUser() {
		return "true".equals(getProp("bid_single_login"));
	}

	public static String getAdminGroup() {
		return getProp("admin_group");
	}

	public static boolean allowUserReg() {
		return "true".equals(getProp("user_reg_flag"));

	}

	public static String getIndexPath() {
		return getProp("index_path");
	}

	public static String getDataPath() {
		return getProp("file_path");
	}

	public static String getUploadPath() {
		return getProp("upload_path");
	}
	
	public static String getChangePath(){
		return getProp("change_path");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(BidConfig.getChangePath()+"ddd//ee");

	}

}
