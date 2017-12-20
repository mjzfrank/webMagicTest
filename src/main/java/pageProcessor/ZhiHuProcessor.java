package pageProcessor;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;


/**
 * Created by wulvge on 2017/9/13.
 */
public class ZhiHuProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(5).setSleepTime(1000);

    @Override
    public Site getSite() {
        return this.site;
    }

    @Override
    public void process(Page page) {

    }

    public static void main(String[] args) {
        long startTime, endTime;
        System.out.println("【爬虫开始】");
        startTime = System.currentTimeMillis();
        endTime = System.currentTimeMillis();
    }
}
