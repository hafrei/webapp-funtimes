package displaypage.model;

/**
 * Created by hfreiburger1 on 15-02-27.
 */
public class VideoInformation {
    private String thumbnailURL;
    private String videoURL;
    private String title;
    private String viewcount;
    private String age;

    public VideoInformation(String thumbnailURL, String videoURL, String title, String viewcount, String age){
        this.thumbnailURL = thumbnailURL;
        this.videoURL = videoURL;
        this.title = title;
        this.viewcount = viewcount;
        this.age = age;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getViewcount() {
        return viewcount;
    }

    public void setViewcount(String viewcount) {
        this.viewcount = viewcount;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
