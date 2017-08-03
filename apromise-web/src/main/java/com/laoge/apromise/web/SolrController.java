package com.laoge.apromise.web;

import com.laoge.apromise.service.solr.SolrService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by yuhou on 2017/5/11.
 */
@RestController
@RequestMapping("solr")
public class SolrController {


    @Resource
    private SolrService solrService;

    @RequestMapping("/query")
    public Object query() throws Exception {
        return solrService.querySolrData();
    }
}
