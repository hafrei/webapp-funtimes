package displaypage.model;

/**
 * Created by hfreiburger1 on 15-02-24.
 */
public class Holder {
    private String linkURL;
    private String thumbURL;
    private int counter;

    public Holder(String linkURL, String thumbURL, int counter) {
        this.linkURL = linkURL;
        this.thumbURL = thumbURL;
        this.counter = counter;
    }

    public String getThumbURL() {
        return thumbURL;
    }

    public void setThumbURL(String thumbURL) {
        this.thumbURL = thumbURL;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setLinkURL(String linkURL){
        this.linkURL = linkURL;
    }

    public String getLinkURL() {
        return linkURL;
    }
}
