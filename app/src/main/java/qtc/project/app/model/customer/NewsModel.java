package qtc.project.app.model.customer;

import qtc.project.app.model.BaseResponseModel;

public class NewsModel extends BaseResponseModel {


    /**
     * id : 2
     * id_category : 1
     * news_title : Tuyển dụng vị trí iOS Developer
     * upload_date : 2020-10-16 14:37:04
     * thumb_800_300 : uploads/news/thumb/tuyendung.jpg
     */

    private String id;
    private String id_category;
    private String news_title;
    private String upload_date;
    private String thumb_800_300;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_category() {
        return id_category;
    }

    public void setId_category(String id_category) {
        this.id_category = id_category;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getUpload_date() {
        return upload_date;
    }

    public void setUpload_date(String upload_date) {
        this.upload_date = upload_date;
    }

    public String getThumb_800_300() {
        return thumb_800_300;
    }

    public void setThumb_800_300(String thumb_800_300) {
        this.thumb_800_300 = thumb_800_300;
    }
}
