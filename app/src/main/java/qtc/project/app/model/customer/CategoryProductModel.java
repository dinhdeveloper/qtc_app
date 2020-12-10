package qtc.project.app.model.customer;

import qtc.project.app.model.BaseResponseModel;

public class CategoryProductModel extends BaseResponseModel {

    /**
     * id : 1
     * category_title : Kho giao diện Website
     * category_img : images/category/xe_moi_ve.png
     */

    private String id;
    private String category_title;
    private String category_img;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_title() {
        return category_title;
    }

    public void setCategory_title(String category_title) {
        this.category_title = category_title;
    }

    public String getCategory_img() {
        return category_img;
    }

    public void setCategory_img(String category_img) {
        this.category_img = category_img;
    }
}
