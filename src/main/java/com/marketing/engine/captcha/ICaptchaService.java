package com.marketing.engine.captcha;



import com.marketing.engine.Web.error.ReCaptchaInvalidException;


public interface ICaptchaService {
    void processResponse(final String response) throws ReCaptchaInvalidException;

    String getReCaptchaSite();

    String getReCaptchaSecret();
}
