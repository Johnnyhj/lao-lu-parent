package com.ai.ge.platform.serviceimpl.http.ws;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Sam on 17/6/16.
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
