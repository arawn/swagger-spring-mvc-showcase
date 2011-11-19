package shopping.web.client;

import javax.inject.Inject;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

public class ClientArgumentsResolver implements WebArgumentResolver {

    @Inject
    ClientFactory clientFactory;
    
    @Override
    public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {
        
        if(methodParameter.getParameterType().equals(Client.class)) {
            return clientFactory.create(webRequest);
        }
        
        return UNRESOLVED;
    }

}
