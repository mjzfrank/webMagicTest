package pageProcessor;

import dao.KaolaPicDao;
import method.DownloadImage;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.List;

/**
 * Created by wulvge on 2017/12/18.
 */
public class KaolaPageProcessor implements PageProcessor {
    //列表页正则表达式
    private static final String REGEX_PAGE_URL = "https://www\\.kaola\\.com/search\\.html\\?key=[\\s\\S]+\\w+?\\&changeContent=brandId";
    private static final String REGEX_ALL_URL = "https://www\\.kaola\\.com/search\\.html\\?zn=top&key=[\\s\\S]+";
    // 抓取网站的相关配置，包括：编码、抓取间隔、重试次数等
    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    private String path ="D:\\kaolaImg\\";

    private String brandName = "";
    @Override
    public void process(Page page) {
        if(page.getUrl().regex(REGEX_PAGE_URL).match()){
            String imgUrl = page.getHtml().xpath("//div[@class=\"m-brand\"]/a/img/@data-src").get();
            String fileName = page.getHtml().xpath("//div[@class='m-brand']/div[@class='info']/p[@class='title']/a/span/text()").get();
            try {
                System.out.println("开始下载:   " + fileName + "     品牌图片");
                if(fileName == null){
                    System.out.print("测怪");
                }else{
                    DownloadImage.download("http:" + imgUrl, fileName + ".jpg", "D:\\kaolaImg\\");
                }
            } catch (Exception e){
                brandName += fileName + ",   ";
                System.out.println("下载:   " + fileName + "     品牌图片失败");
            }
        }else{
            if(page.getUrl().regex(REGEX_ALL_URL).match()){
                List<String> urls = page.getHtml().xpath("//div[@class=\"brands\"]/a").links().all();
                if(urls!=null && urls.size()>0){
                    for(String url :urls){
                        page.addTargetRequest(url);
                    }
                }
            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        System.out.println("开始爬");
        //启动
        Spider.create(new KaolaPageProcessor())
                //添加初始化的URL
                .addUrl("https://www.kaola.com/search.html?zn=top&key=%25E5%2593%2581%25E7%2589%258C")
                //启动10个线程
                .thread(10)
                //运行
                .run();
        System.out.println();
    }
}
