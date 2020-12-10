package qtc.project.app.model.customer;

import qtc.project.app.model.BaseResponseModel;

public class ImgPhotoNewsModel  extends BaseResponseModel {
    /**
     * id : 3
     * id_news : 1
     * img_photo : uploads/news/07507102020.jpeg
     */

    private String id;
    private String id_news;
    private String img_photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_news() {
        return id_news;
    }

    public void setId_news(String id_news) {
        this.id_news = id_news;
    }

    public String getImg_photo() {
        return img_photo;
    }

    public void setImg_photo(String img_photo) {
        this.img_photo = img_photo;
    }
}
