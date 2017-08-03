package com.laoge.apromise.service.solr.impl;

import com.laoge.apromise.service.solr.SolrService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.common.params.CommonParams;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yuhou on 2017/5/11.
 */
@Service
public class SolrServiceImpl implements SolrService {

    @Resource
    private SolrClient solrClient;

    @Override
    public Object querySolrData() throws Exception {
        SolrQuery solrQuery = new SolrQuery();
        solrQuery.setStart(1);
        solrQuery.setRows(1);
        solrQuery.set(CommonParams.Q, "*:*");
        return solrClient.query(solrQuery);
    }
}
