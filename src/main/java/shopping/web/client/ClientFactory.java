package shopping.web.client;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.WebRequest;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

@Component
public class ClientFactory {

    private Set<String> iosPhoneDeviceNames = new LinkedHashSet<String>();
    private Set<String> iosTabletDeviceNames = new LinkedHashSet<String>();
    private Set<String> androidPhoneDeviceNames = new LinkedHashSet<String>();
    private Set<String> androidTabletDeviceNames = new LinkedHashSet<String>();
    
    private Set<String> phoneDeviceNames = new LinkedHashSet<String>();
    private Set<String> tabletDeviceNames = new LinkedHashSet<String>();
    
    private Set<String> iosDeviceNames = new LinkedHashSet<String>();
    private Set<String> androidDeviceNames = new LinkedHashSet<String>();
    
    @Value("#{configProperties['iosPhone.device.names']}")
    public void setIosPhoneDeviceNames(String commaSeparatedDeviceNames) {
        Assert.hasText(commaSeparatedDeviceNames);
        
        iosPhoneDeviceNames.addAll(
                this.separateDevicenames(commaSeparatedDeviceNames));
    }
    
    @Value("#{configProperties['iosTablet.device.names']}")
    public void setIosTabletDeviceNames(String commaSeparatedtabletDeviceNames) {
        Assert.hasText(commaSeparatedtabletDeviceNames);
        
        iosTabletDeviceNames.addAll(
                this.separateDevicenames(commaSeparatedtabletDeviceNames));
    }
    
    @Value("#{configProperties['androidPhone.device.names']}")
    public void setAndroidPhoneDeviceNames(String commaSeparatedDeviceNames) {
        Assert.hasText(commaSeparatedDeviceNames);
        
        androidPhoneDeviceNames.addAll(
                this.separateDevicenames(commaSeparatedDeviceNames));
    }
    
    @Value("#{configProperties['androidTablet.device.names']}")
    public void setAndroidTabletDeviceNames(String commaSeparatedtabletDeviceNames) {
        Assert.hasText(commaSeparatedtabletDeviceNames);
        
        androidTabletDeviceNames.addAll(
                this.separateDevicenames(commaSeparatedtabletDeviceNames));
    }
    
    @PostConstruct
    public void init() {
        if(!iosPhoneDeviceNames.isEmpty()) {
            phoneDeviceNames.addAll(iosPhoneDeviceNames);
            iosDeviceNames.addAll(iosPhoneDeviceNames);
        }
        
        if(!iosTabletDeviceNames.isEmpty()) {
            tabletDeviceNames.addAll(iosTabletDeviceNames);
            iosDeviceNames.addAll(iosTabletDeviceNames);
        }
        
        if(!androidPhoneDeviceNames.isEmpty()) {
            phoneDeviceNames.addAll(androidPhoneDeviceNames);
            androidDeviceNames.addAll(androidPhoneDeviceNames);
        }
        
        if(!androidTabletDeviceNames.isEmpty()) {
            tabletDeviceNames.addAll(androidTabletDeviceNames);
            androidDeviceNames.addAll(androidTabletDeviceNames);
        } 
    }    
    
    private List<String> separateDevicenames(String commaSeparatedDeviceNames) {
        List<String> tokens = new ArrayList<String>(); 
        String[] separatedTokens = commaSeparatedDeviceNames.split(",");
        for(String token: separatedTokens) {
            token = token.trim();
            if(StringUtils.hasText(token))
                tokens.add(token);
        }
        
        return tokens;
    }
    
    public Client create(WebRequest webRequest) {
        ClientType clientType = findClientType(webRequest);
        PlatformType platformType = findPlatformType(webRequest);
        
        return new Client(clientType, platformType);
    }
    
    public PlatformType findPlatformType(WebRequest webRequest) {
        
        PlatformType platformType = null;
        
        final String userAgent = getUserAgent(webRequest);
        
        // IOS냐?
        if(Iterables.any(iosDeviceNames, new Predicate<String>() {
            @Override
            public boolean apply(String value) {
                return userAgent.indexOf(value) > -1;
            }
        })) platformType = PlatformType.IOS;
        
        // 안드로이드냐?
        if(Iterables.any(androidDeviceNames, new Predicate<String>() {
            @Override
            public boolean apply(String value) {
                return userAgent.indexOf(value) > -1;
            }
        })) platformType = PlatformType.ANDROID;  
        
        return platformType == null ? PlatformType.ETC : platformType;
    }

    public ClientType findClientType(WebRequest webRequest) {
        
        final String userAgent = getUserAgent(webRequest);
        
        // 태블릿이냐?
        if(Iterables.any(tabletDeviceNames, new Predicate<String>() {
            @Override
            public boolean apply(String value) {
                return userAgent.indexOf(value) > -1;
            }
        })) return ClientType.TABLET;
        
        // 폰이냐?
        if(Iterables.any(phoneDeviceNames, new Predicate<String>() {
            @Override
            public boolean apply(String value) {
                return userAgent.indexOf(value) > -1;
            }
        })) return ClientType.PHONE;
        
        return ClientType.ETC;
    }
    
    private String getUserAgent(WebRequest webRequest) {
        String userAgent = webRequest.getHeader("user-agent");
        
        if(!StringUtils.hasLength(userAgent))
            return "";
        
        return userAgent;
    }

}
