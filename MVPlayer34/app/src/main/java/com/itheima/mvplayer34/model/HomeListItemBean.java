package com.itheima.mvplayer34.model;

/**
 * Created by Leon on 2017/1/16.
 */

public class HomeListItemBean {

    /**
     * type : PLAYLIST
     * id : 4610252
     * title : 田馥甄:要死就一定要死在你手里
     * posterPic : http://img3.c.yinyuetai.com/others/mobile_front_page/170115/0/-M-7f8e88615b95e7750686346c706a9b9f_0x0.jpg
     * thumbnailPic : http://img3.c.yinyuetai.com/video/playlist/170115/0/-M-fb6398c28e2e60b89fabb8c34529c3ee_220x220.jpg
     * videoSize : 0
     * hdVideoSize : 0
     * uhdVideoSize : 0
     * status : 0
     * traceUrl : http://www.yinyuetai.com/v?a=102437&un=53a621a9362eb7ed4e46425ac834f4b545fe1eff443acb1e2ba5fdc547da9314f66a78b03b640904a24e6f25376102b0c1dc16842b2b37e0d446aaffccd10a8cf69d2ebc6c2e79bfe31b925f005aee7e12ef159d573c37c97845c34d5e9dc329d8763c9a0e375997
     * clickUrl : http://mapi.yinyuetai.com/statistics/click.json?id=5113
     */

    private String type;
    private int id;
    private String title;
    private String posterPic;
    private String thumbnailPic;
    private int videoSize;
    private int hdVideoSize;
    private int uhdVideoSize;
    private int status;
    private String traceUrl;
    private String clickUrl;

    private String description;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPosterPic() {
        return posterPic;
    }

    public void setPosterPic(String posterPic) {
        this.posterPic = posterPic;
    }

    public String getThumbnailPic() {
        return thumbnailPic;
    }

    public void setThumbnailPic(String thumbnailPic) {
        this.thumbnailPic = thumbnailPic;
    }

    public int getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(int videoSize) {
        this.videoSize = videoSize;
    }

    public int getHdVideoSize() {
        return hdVideoSize;
    }

    public void setHdVideoSize(int hdVideoSize) {
        this.hdVideoSize = hdVideoSize;
    }

    public int getUhdVideoSize() {
        return uhdVideoSize;
    }

    public void setUhdVideoSize(int uhdVideoSize) {
        this.uhdVideoSize = uhdVideoSize;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTraceUrl() {
        return traceUrl;
    }

    public void setTraceUrl(String traceUrl) {
        this.traceUrl = traceUrl;
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl;
    }
}
