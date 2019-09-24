package com.comtop.demo.springBootDemo.dao.demo;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;

//爬虫接口类
public interface Reptile {
    public void process(Page page);
    public Site getSite();
}
