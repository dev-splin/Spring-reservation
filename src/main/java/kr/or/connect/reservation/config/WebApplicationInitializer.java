package kr.or.connect.reservation.config;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
        // 배열로 되어있기 때문에 ','로 여러개의 Config파일을 지정할 수 있습니다.
		return new Class<?>[] {ApplicationConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebMvcContextConfiguration.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        // request와 response에 encoding을 적용한다는 것입니다.
        encodingFilter.setForceEncoding(true);

        return new Filter[]{encodingFilter};
	}
//	// 웹 어플리케이션이 시작할 때 자동으로 이 메서드가 실행 됩니다.
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		registerListener(servletContext);
//		registerDispatcherServlet(servletContext);
//		registerFilter(servletContext);
//	}
//	
//	// 리스너를 생성하는 함수입니다. Override된 onStartup() 함수에서 호출해야 합니다.
//	private void registerListener(ServletContext servletContext) {
//		// ApplicationConfig(java Configuration)를 이용해 AnnotationConfigWebApplicationContext을 만들고 
//		AnnotationConfigWebApplicationContext context = createContext(ApplicationConfig.class);
//        // Listener에 context-param을 등록해 줍니다.
//		servletContext.addListener(new ContextLoaderListener(context));
//	}
//	
//	// DispatcherServlet를 만들어 줍니다.
//	private void registerDispatcherServlet(ServletContext servletContext) {
//        // WebMvcContextConfiguration(java Configuration)를 이용해 AnnotationConfigWebApplicationContext을 만들고
//		AnnotationConfigWebApplicationContext context = createContext(WebMvcContextConfiguration.class);
//		
//        // DispatcherServlet를 만든 후, 서블릿들 간의 우선순위를 정해주고, url-pattern을 지정해줍니다.
//		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
//		dispatcher.setLoadOnStartup(1);
//		dispatcher.addMapping("/");
//	}
//	
//	// 필터를 만듭니다.
//	private void registerFilter(ServletContext servletContext) {
//		// CharacterEncodingFilter 인자의 true, true는 request, response이 존재할 때 encoding을 적용한다는 것입니다. 
//		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("UTF-8", true, true);
//		FilterRegistration.Dynamic webEncodingFilter = servletContext.addFilter("webEncodingFilter", encodingFilter);
//		webEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
//	}
//	
//	// 필터를 만듭니다.
//	private void registerFilter(ServletContext servletContext) {
//      // CharacterEncodingFilter 인자의 true, true는 request, response이 존재할 때 encoding을 적용한다는 것입니다.
//		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("UTF-8", true, true);
//		FilterRegistration.Dynamic webEncodingFilter = servletContext.addFilter("webEncodingFilter", encodingFilter);
//		webEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
//	}
	
	

}
