package com.wiley.ranku.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class AppPages {

    @JsonProperty("Home")
    private AppPage home;

    @JsonProperty("RFI")
    private AppPage rfi;

    @JsonProperty("Sign-Up")
    private AppPage signup;

    @JsonProperty("DegreePage")
    private AppPage degreePage;

    @JsonProperty("ProgramPage")
    private AppPage programPage;

    public AppPage getHome() {
        return home;
    }

    public AppPage getRfi() {
        return rfi;
    }

    public AppPage getSignUp(){
        return signup;
    }

    public AppPage getDegreePage() {
        return degreePage;
    }

    public AppPage getProgramPage() {
        return programPage;
    }
}
