package dwz.framework.context;

import com.git.business.sys.User;

public interface AppContext {

	public User getUser();

	public void setUser(User user);

//	public Website getWebsite();
//	public void setWebsite(Website website);

}
