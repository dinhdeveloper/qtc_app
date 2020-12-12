package qtc.project.app.model.customer;

import qtc.project.app.model.BaseResponseModel;

public class HashTagModel extends BaseResponseModel {
    /**
     * id : 1
     * id_product : 55
     * tag_title : Website
     */

    private String id;
    private String id_product;
    private String tag_title;
    /**
     * id_news : 1
     */

    private String id_news;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getTag_title() {
        return tag_title;
    }

    public void setTag_title(String tag_title) {
        this.tag_title = tag_title;
    }

    public String getId_news() {
        return id_news;
    }

    public void setId_news(String id_news) {
        this.id_news = id_news;
    }
}
