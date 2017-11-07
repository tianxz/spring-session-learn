package org.vinci.spring.sessionlearn.server.session;

import org.springframework.session.web.http.DefaultCookieSerializer;

/**
 * Created by XizeTian on 2017/11/6.
 */
public class VinciCookieSerializer extends DefaultCookieSerializer {
    @Override
    public void writeCookieValue(CookieValue cookieValue) {
        CookieValue newCookie = new CookieValue(cookieValue.getRequest(),
                cookieValue.getResponse(),
                cookieValue.getCookieValue());
        super.writeCookieValue(newCookie);
    }
}