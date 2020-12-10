package qtc.project.app.model.customer;

import qtc.project.app.model.BaseResponseModel;

public class AboutUsModel extends BaseResponseModel {

    /**
     * id : 1
     * about_title : CÔNG TY CỔ PHẦN INFORMATICS QTC
     * about_content : <p>Là một doanh nghiệp hoạt động đa lĩnh vực :</p>

     <ol>
     <li style="text-align: center;">Thiết kế website</li>
     <li style="text-align: center;">Giải pháp phần mềm, ứng dụng </li>
     <li style="text-align: center;">Giải pháp quản lý tập chung</li>
     <li style="text-align: center;">Giải pháp công nghệ đa điểm</li>
     <li style="text-align: center;">Giải pháp bảo mật hệ thống</li>
     <li style="text-align: center;">Cung cấp thiết bị công nghệ thông tin</li>
     </ol>

     <p>Với các chuyên gia hàng đầu, quy trình làm việc chuyên nghiệp, QTC luôn được trau dồi, tu dưỡng và ý thức được sứ mệnh phục vụ khách hàng của mình. “<strong>Cho đi và nhận lại</strong>” chính là giá trị sống của chúng tôi.</p>

     <p>QTC cũng sẽ không ngừng lắng nghe những ý kiến đóng góp, cũng như những phê bình nghiêm túc để phấn đấu nâng cao chất lượng phục vụ, nâng cao năng lực cạnh tranh, cải tiến quy trình quản lý, và cải thiện chất lượng phục vụ theo phương châm: “<strong>Không ngừng học hỏi, sáng tạo</strong>”.</p>

     <p>QTC luôn trân trọng giá trị nền tảng cho sự phát triển, đó là các cơ hội được hợp tác với Quý khách hàng, và không có bất kỳ khó khăn nào có thể ngăn cản chúng tôi mang lại những giá trị tiện ích phù hợp với mong muốn và lợi ích của Quý khách hàng.</p>

     <p>Chúng tôi tin tưởng rằng với đội ngũ QTC đoàn kết, vững mạnh và sự ủng hộ của Quý khách hàng, QTC chắc chắn sẽ gặt hái được nhiều thành công hơn nữa.</p>
     * img_370_530 : uploads/web-aboutus/profile.png
     */

    private String id;
    private String about_title;
    private String about_content;
    private String img_370_530;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAbout_title() {
        return about_title;
    }

    public void setAbout_title(String about_title) {
        this.about_title = about_title;
    }

    public String getAbout_content() {
        return about_content;
    }

    public void setAbout_content(String about_content) {
        this.about_content = about_content;
    }

    public String getImg_370_530() {
        return img_370_530;
    }

    public void setImg_370_530(String img_370_530) {
        this.img_370_530 = img_370_530;
    }
}
