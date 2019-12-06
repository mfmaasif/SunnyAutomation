package com.wiley.ranku.datamodel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Environment {

    @JsonProperty("dev")
    private String dev;

    @JsonProperty("stag")
    private String stag;

    @JsonProperty("prod")
    private String prod;

    public String getDev() {
        return dev;
    }

    public String getStag() {
        return stag;
    }

    public String getProd() {
        return prod;
    }

    public String getLaunchUrl(String env) {
        String  url = null;

        switch (env.toLowerCase().trim()) {
            case "dev":
                url = dev;
                break;
            case "stag":
                url = stag;
                break;
            case "prod":
                url = prod;
        }

        return  url;

    }
}
