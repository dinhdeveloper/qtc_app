package qtc.project.app.model.customer;

import java.util.List;

import qtc.project.app.model.BaseResponseModel;

public class ProductHomeModel extends BaseResponseModel {

    /**
     * id : 70
     * id_category : 1
     * product_title : Web shop thời trang
     * product_icon : [{"id":"1","id_category":"1","icon_category":"images/category/apple.png"},{"id":"2","id_category":"1","icon_category":"images/category/and.png"},{"id":"3","id_category":"1","icon_category":"images/category/chplay.png"}]
     */

    private String id;
    private String id_category;
    private String product_thumb;
    private String product_title;
    private String product_icon;

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

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }

    public String getProduct_thumb() {
        return product_thumb;
    }

    public void setProduct_thumb(String product_thumb) {
        this.product_thumb = product_thumb;
    }

    public String getProduct_icon() {
        return product_icon;
    }

    public void setProduct_icon(String product_icon) {
        this.product_icon = product_icon;
    }
}
