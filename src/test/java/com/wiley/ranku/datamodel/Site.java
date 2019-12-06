package com.wiley.ranku.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Site {

    @JsonProperty("Environment")
    private Environment environment;

    @JsonProperty("homeUrl")
    private String homeUrl;

    @JsonProperty("applyNowUrl")
    private String applyNowUrl;

    @JsonProperty("Configurations")
    private Configurations configurations;

    @JsonProperty("AppPages")
    private AppPages AppPages;

    public Configurations getConfigurations() {
        return configurations;
    }

    public AppPages getAppPages() {
        return AppPages;
    }

    public String getHomeUrl() {
        return homeUrl;
    }

    public String getApplyNowUrl() {
        return applyNowUrl;
    }

    public Environment getEnvironment() {
        return environment;
    }

}
