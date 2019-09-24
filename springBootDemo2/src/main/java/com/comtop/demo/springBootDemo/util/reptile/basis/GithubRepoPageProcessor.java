package com.comtop.demo.springBootDemo.util.reptile.basis;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

//webmagic，基础部分
public class GithubRepoPageProcessor implements PageProcessor {
    private Site site = Site.me().setDomain("gcssloop.com");

    @Override
    public void process(Page page) {
        List<String> links = page.getHtml().links().regex("https://www\\.gcssloop\\.com/#blog\\w+").all();
        page.addTargetRequests(links);
        page.putField("title", page.getHtml().xpath("//div[@class='main-post-list']/li/h2").toString());
    }

    @Override
    public Site getSite() {
        return site;

    }

    public static void main(String[] args) {
        Spider.create(new GithubRepoPageProcessor()).addUrl("https://www.gcssloop.com")
                .addPipeline(new ConsolePipeline()).run();
    }
}
