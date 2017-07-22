package com.ai.ge.platform.common.jcaptcha;

import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;

/**
 * 提供了判断仓库中是否有相应的验证码存在
 */
public class EcManageableImageCaptchaService extends DefaultManageableImageCaptchaService {

    public EcManageableImageCaptchaService(com.octo.captcha.service.captchastore.CaptchaStore captchaStore, com.octo
            .captcha.engine.CaptchaEngine captchaEngine, int minGuarantedStorageDelayInSeconds, int
                                                   maxCaptchaStoreSize, int captchaStoreLoadBeforeGarbageCollection) {
        super(captchaStore, captchaEngine, minGuarantedStorageDelayInSeconds, maxCaptchaStoreSize,
                captchaStoreLoadBeforeGarbageCollection);
    }

    public boolean hasCapcha(String id, String userCaptchaResponse) {
        return store.getCaptcha(id).validateResponse(userCaptchaResponse);
    }
}
