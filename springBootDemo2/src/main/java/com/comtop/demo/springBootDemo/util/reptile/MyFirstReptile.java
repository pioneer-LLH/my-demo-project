package com.comtop.demo.springBootDemo.util.reptile;

import com.comtop.demo.springBootDemo.dao.demo.Reptile;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;

import java.util.Collections;
import java.util.List;


//WebMagic爬虫框架——我的第一个爬虫程序
public class MyFirstReptile implements  PageProcessor{
    private Site site = Site.me().setDomain("my.oschina.net");


    @Override
    public void process(Page page) {
        List<String> links = page.getHtml().links().regex("http://my\\.oschina\\.net/flashsword/blog/\\d+").all();
        page.addTargetRequests(links);
        page.putField("title", page.getHtml().xpath("//div[@class='BlogEntity']/div[@class='BlogTitle']/h1").toString());
        page.putField("content", page.getHtml().$("div.content").toString());
        page.putField("tags",page.getHtml().xpath("//div[@class='BlogTags']/a/text()").all());
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new MyFirstReptile()).addUrl("http://my.oschina.net/flashsword/blog")
                .addPipeline(new ConsolePipeline()).run();
    }
}
