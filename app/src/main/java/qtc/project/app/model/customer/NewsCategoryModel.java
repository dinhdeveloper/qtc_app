package qtc.project.app.model.customer;

import qtc.project.app.model.BaseResponseModel;

public class NewsCategoryModel extends BaseResponseModel {


    /**
     * id : 1
     * num_order : 0
     * category_title : Tuyển Dụng
     */

    private String id;
    private String num_order;
    private String category_title;

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

    public String getCategory_title() {
        return category_title;
    }

    public void setCategory_title(String category_title) {
        this.category_title = category_title;
    }
}
