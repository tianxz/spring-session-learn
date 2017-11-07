package org.vinci.spring.sessionlearn.server.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.CookieSerializer;
import org.vinci.spring.sessionlearn.server.session.VinciCookieSerializer;

/**
 * Created by XizeTian on 2017/11/6.
 */
@Configuration
public class SessionConf {
    @Bean
    public CookieSerializer cookieSerializer() {
        VinciCookieSerializer serializer = new VinciCookieSerializer();
        serializer.setCookieName("VINCI_SESSION"); // <1>
        serializer.setCookiePath("/"); // <2>
        serializer.setUseBase64Encoding(false);
        serializer.setDomainNamePattern("^.+?\\.(\\w+\\.[a-z]+)$"); // <3>
        return serializer;
    }
}