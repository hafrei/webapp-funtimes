package displaypage.controllers;

import displaypage.model.VideoInformation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hfreiburger1 on 15-02-26.
 */
@Controller
public class YTController {

    @RequestMapping("/yt")
    public ModelAndView ytStream() throws IOException{

        //String sourceURL = "http://en.wikipedia.org/";
        //String targetClass = "#mp-itn b a";

        //String sourceURL = "https://www.youtube.com/user/Vihart/videos?shelf_id=0&view=0&sort=dd";
        String sourceURL = "https://www.youtube.com/user/CGPGrey/videos?shelf_id=0&view=0&sort=dd";
        //String targetClass = "#channels-content-item yt-shelf-grid-item yt-uix-shelfslider-item";

        String targetClass = ".yt-lockup-dismissable";

        ModelAndView modelAndView = new ModelAndView("ytrunner");
        List<List<VideoInformation>> videoInformationLists = new ArrayList<>();
        List<VideoInformation> videoInformationList = new ArrayList<>();

        Document doc = Jsoup.connect(sourceURL).get();
        Elements videos = doc.select(targetClass);

        int i = 0;
        System.out.println(videos.size());

        for(Element video : videos){
            i++;

            //Containing class for thumbnail: yt-thumb-clip
            Element thumbURL = video.getElementsByClass("yt-thumb-clip").first().getElementsByTag("img").get(0);
            String thumbnailURL = thumbURL.attr("src");

            if (thumbnailURL.startsWith("//")) {
                thumbnailURL = "http:" + thumbnailURL;
            }

            //Containing class for video URL: yt-uix-sessionlink.yt-uix-tile-link.spf-link.yt-ui-ellipsis.yt-ui-ellipsis-2
            Element srcURL = video.getElementsByClass("yt-ui-ellipsis-2").first();
            String videoURL = "http://www.youtube.com" + srcURL.attr("href");
            String title = srcURL.attr("title");
            //Containing class for viewcount: yt-lockup-meta-info
            Element numberOfViews = video.getElementsByClass("yt-lockup-meta-info").first().getElementsByTag("li").get(0);
            String viewcount = numberOfViews.text();
            Element existedFor = video.getElementsByClass("yt-lockup-meta-info").first().getElementsByTag("li").get(1);
            String age = existedFor.text();

            VideoInformation videoInformation = new VideoInformation(thumbnailURL,videoURL,title,viewcount,age);
            videoInformationList.add(videoInformation);

            if (i % 3 == 0){
                videoInformationLists.add(videoInformationList);
                videoInformationList = new ArrayList<>();
            }
        }

        modelAndView.addObject("videoInformationLists", videoInformationLists);

        return modelAndView;
    }
}
