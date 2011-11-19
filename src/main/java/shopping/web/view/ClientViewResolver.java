package shopping.web.view;

import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.ClassUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import shopping.web.client.Client;
import shopping.web.client.ClientFactory;

public class ClientViewResolver extends UrlBasedViewResolver {
    
    @Inject
    ClientFactory clientFactory;
    
    public ClientViewResolver() {
        setViewClass(requiredViewClass());
    }

    @Override
    protected Class<?> requiredViewClass() {
        return JstlView.class;
    }
    
    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {

        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if(ClassUtils.isAssignable(requestAttributes.getClass(), ServletRequestAttributes.class)) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            ServletWebRequest webRequest = new ServletWebRequest(request);
            
            Client client = clientFactory.create(webRequest);
            
            viewName = viewName + "_" + client.getClientType().getCode();
        }
        
        return super.resolveViewName(viewName, locale);
    }

    @Override
    protected View loadView(String viewName, Locale locale) throws Exception {
        View view = super.loadView(viewName, locale);
        if(AbstractUrlBasedView.class.isAssignableFrom(view.getClass()))
            return getApplicationContext().getResource(((AbstractUrlBasedView) view).getUrl()).exists() ? view : null;
        else
            return view;
    }

}
