package com.laoge.apromise.service.solr.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by yuhou on 2017/5/11.
 */
@ConfigurationProperties(prefix = "solr")
public class SolrEnvironment {

    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
