package com.laoge.apromise.service.solr;

import com.laoge.apromise.service.solr.config.SolrEnvironment;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by yuhou on 2017/5/11.
 */
@Configuration
@EnableConfigurationProperties(SolrEnvironment.class)
public class SolrConfig {

    private static final Logger logger = LoggerFactory.getLogger(SolrConfig.class);

    @Autowired
    private SolrEnvironment solrEnvironment;

    @Bean
    public SolrClient solrClient() {

        logger.info(">>>>>>>SolrConfig.baseUrl>>>>>>>>>>.{}", solrEnvironment.getBaseUrl());

        return new HttpSolrClient(solrEnvironment.getBaseUrl());
    }
}
