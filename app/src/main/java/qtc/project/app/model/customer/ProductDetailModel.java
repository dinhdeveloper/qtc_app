package qtc.project.app.model.customer;

import java.util.List;

import qtc.project.app.model.BaseResponseModel;

public class ProductDetailModel extends BaseResponseModel {

    /**
     * product_id : 55
     * category_id : 1
     * category_title : Kho giao diện Website
     * product_thumb : uploads/product/thumb/template01.jpg
     * product_star : 5
     * product_price : Liên hệ
     * product_description : Website được thiết kế bởi công ty cổ phần phát triển công nghệ INFORMATICS QTC hỗ trợ khách hàng 
     Website dành cho kinh doanh Shop thương mại điện tử, công ty xây dựng.
     * product_short_description : Website mua bán xe hỗ trợ đăng bài tin tức , tương tác với khách hàng , mô tả đăc trưng chi tiết xe, thông báo khi có khách hàng liên hệ trực tiếp
     * product_specification : Ngôn ngữ : PHP Version 7.5

     Cơ sở dữ liệu : MySQL

     Hệ thống xử lý : Apache

     Front-end : HTML5, CSS3, JQUERY,JS....
     * product_information : Hỗ trợ Trình duyệt : Firefox , IE , Edge, Google Chrome ,Opera, Safari
     Hỗ trợ thiết bị : PC , Table , Mobile , Pocket
     * product_photo : [{"id":"1003","id_product":"55","img_370_530":"uploads/product/web00098.png"}]
     * product_tag : [{"id":"1","id_product":"55","tag_title":"Website"},{"id":"3","id_product":"55","tag_title":"qtctek"},{"id":"181","id_product":"55","tag_title":"app"},{"id":"182","id_product":"55","tag_title":"ios"},{"id":"183","id_product":"55","tag_title":"android"},{"id":"184","id_product":"55","tag_title":"web"},{"id":"185","id_product":"55","tag_title":"thiết kế website đẹp"}]
     */

    private String product_id;
    private String category_id;
    private String category_title;
    private String product_thumb;
    private String product_star;
    private String product_price;
    private String product_description;
    private String product_short_description;
    private String product_specification;
    private String product_information;
    private ProductPhotoModel[] product_photo;
    private ProductTagModel[] product_tag;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_title() {
        return category_title;
    }

    public void setCategory_title(String category_title) {
        this.category_title = category_title;
    }

    public String getProduct_thumb() {
        return product_thumb;
    }

    public void setProduct_thumb(String product_thumb) {
        this.product_thumb = product_thumb;
    }

    public String getProduct_star() {
        return product_star;
    }

    public void setProduct_star(String product_star) {
        this.product_star = product_star;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_short_description() {
        return product_short_description;
    }

    public void setProduct_short_description(String product_short_description) {
        this.product_short_description = product_short_description;
    }

    public String getProduct_specification() {
        return product_specification;
    }

    public void setProduct_specification(String product_specification) {
        this.product_specification = product_specification;
    }

    public String getProduct_information() {
        return product_information;
    }

    public void setProduct_information(String product_information) {
        this.product_information = product_information;
    }

    public ProductPhotoModel[] getProduct_photo() {
        return product_photo;
    }

    public void setProduct_photo(ProductPhotoModel[] product_photo) {
        this.product_photo = product_photo;
    }

    public ProductTagModel[] getProduct_tag() {
        return product_tag;
    }

    public void setProduct_tag(ProductTagModel[] product_tag) {
        this.product_tag = product_tag;
    }
}
