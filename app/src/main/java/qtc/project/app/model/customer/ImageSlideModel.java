package qtc.project.app.model.customer;

import qtc.project.app.model.BaseResponseModel;

public class ImageSlideModel extends BaseResponseModel {

    /**
     * id : 5
     * num_order : 1
     * img_1920_1080 : uploads/web-slide/newslide.jpg
     */

    private String id;
    private String num_order;
    private String img_1920_1080;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum_order() {
        return num_order;
    }

    public void setNum_order(String num_order) {
        this.num_order = num_order;
    }

    public String getImg_1920_1080() {
        return img_1920_1080;
    }

    public void setImg_1920_1080(String img_1920_1080) {
        this.img_1920_1080 = img_1920_1080;
    }
}
