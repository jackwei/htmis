package dwz.framework.context;

import java.util.Locale;

public class AppContextHolder {

	private static final InheritableThreadLocal<AppContext> holder = new InheritableThreadLocal<AppContext>() {

		protected AppContext initialValue() {
			return null;
		}

	};

	public static AppContext getContext() {
		return holder.get();
	}

	public static void setContext(AppContext context) {
		holder.set(context);
	}
	
}
