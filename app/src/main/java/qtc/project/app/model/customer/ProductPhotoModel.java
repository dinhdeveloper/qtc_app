package qtc.project.app.model.customer;

import qtc.project.app.model.BaseResponseModel;

public class ProductPhotoModel extends BaseResponseModel {
    /**
     * id : 1003
     * id_product : 55
     * img_370_530 : uploads/product/web00098.png
     */

    private String id;
    private String id_product;
    private String img_370_530;

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

    public String getImg_370_530() {
        return img_370_530;
    }

    public void setImg_370_530(String img_370_530) {
        this.img_370_530 = img_370_530;
    }
}
