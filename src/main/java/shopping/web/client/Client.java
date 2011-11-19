package shopping.web.client;

import org.springframework.util.Assert;

public class Client {
    
    private PlatformType platformType;
    private ClientType clientType;
    
    public Client(ClientType clientType, PlatformType platformType) {
        Assert.notNull(clientType);
        Assert.notNull(platformType);
        
        this.clientType = clientType;
        this.platformType = platformType;
    }
    
    public ClientType getClientType() {
        return clientType;
    }
    public PlatformType getPlatformType() {
        return platformType;
    }

    public boolean isPhone() {
        return clientType.isPhone();
    }
    public boolean isTablet() {
        return clientType.isTablet();
    }
    public boolean isEtc() {
        return clientType.isEtc();
    }

    public boolean isIOS() {
        return platformType.isIOS();
    }
    public boolean isAndroid() {
        return platformType.isAndroid();
    }
    
}
