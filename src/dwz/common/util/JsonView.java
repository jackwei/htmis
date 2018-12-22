package dwz.common.util;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

/**
 * Viewer类 
 * @author shona
 *
 */
public class JsonView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		 PrintWriter out=response.getWriter();  
		 out.println((String)model.get("json"));//json字符串从这里走向世界  
	}
}
