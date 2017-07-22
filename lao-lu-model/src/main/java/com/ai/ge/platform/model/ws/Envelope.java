package com.ai.ge.platform.model.ws;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by sx on 2016/3/10.
 */

@XStreamAlias("soapenv:Envelope")
public class Envelope {
    @XStreamAlias("soapenv:Body")
    private Body body;

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
