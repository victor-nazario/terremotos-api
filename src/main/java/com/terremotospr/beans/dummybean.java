package com.terremotospr.beans;

import org.springframework.context.annotation.Bean;

/**
 * Created on  -
 *
 * @author Victor Nazario
 */

public class dummybean {
    private String dummyName;

    public String getDummyName() {
        return dummyName;
    }

    public void setDummyName(String dummyName) {
        this.dummyName = dummyName;
    }
}
