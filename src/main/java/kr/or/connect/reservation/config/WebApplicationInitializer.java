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
	// root-config를 설정해줍니다.(리스너)
	protected Class<?>[] getRootConfigClasses() {
        // 배열로 되어있기 때문에 ','로 여러개의 Config파일을 지정할 수 있습니다.
		return new Class<?>[] {ApplicationConfig.class, SecurityConfig.class};
	}

	@Override
	// DispatcherServlet 설정
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebMvcContextConfiguration.class};
	}

	@Override
	// url-pattern 지정
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	@Override
	// 필터 설정
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        // request와 response에 encoding을 적용한다는 것입니다.
        encodingFilter.setForceEncoding(true);

        return new Filter[]{encodingFilter};
	}
}
