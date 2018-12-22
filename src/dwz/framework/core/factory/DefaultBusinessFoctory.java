package dwz.framework.core.factory;

import org.apache.poi.hssf.record.formula.functions.T;
import org.springframework.context.ApplicationContext;

import dwz.constants.BeanManagerKey;
import dwz.framework.config.Configuration;
import dwz.framework.core.business.BusinessObjectManager;
import dwz.framework.http.session.mdb.mysqldb.schedule.SessionManager;
import dwz.framework.mail.MailManager;

public class DefaultBusinessFoctory extends BusinessFactory {

	private Configuration	config	= null;

	public DefaultBusinessFoctory() {
	}

	public Configuration retrieveConfiguration() {
		return this.config;
	}

	public ApplicationContext getApplicationContext() {
		return this.config.getApplicationContext();
	}


	protected Object getBean(String beanName) {
		return getApplicationContext().getBean(beanName);
	}

	public void injectConfiguration(Configuration config) {
		if (this.config != null) {
			this.config.clear();
			this.config = null;
			System.gc();
		}

		this.config = config;

	}


	@SuppressWarnings("unchecked")
	public <T extends BusinessObjectManager> T getManager(BeanManagerKey beanManagerKey) {
		return (T) getBean(beanManagerKey.toString());
	}


	public SessionManager getSessionManager() {
		return (SessionManager) getBean(BeanManagerKey.sessionManager.toString());
	}



	public MailManager getMailmanager() {
		return (MailManager) getBean(BeanManagerKey.mailManager.toString());
	}

}