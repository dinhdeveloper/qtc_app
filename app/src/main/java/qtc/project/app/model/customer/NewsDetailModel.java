package qtc.project.app.model.customer;

import java.util.List;

import qtc.project.app.model.BaseResponseModel;

public class NewsDetailModel extends BaseResponseModel {

    /**
     * id : 1
     * id_category : 3
     * upload_date : 2020-10-16 14:35:29
     * thumb_800_300 : uploads/news/thumb/th.jpg
     * news_content : Facebook tiếp tục chỉ trích Apple về những thay đổi quyền riêng tư trên iOS 14 ảnh hưởng đến quảng cáo.
     Trong bài phỏng vấn ngày 6/10 với CNBC, David Fischer, Giám đốc Doanh thu của Facebook cho rằng mô hình quảng cáo được cá nhân hóa của công ty đang bị đe dọa khi Apple sắp áp dụng những thay đổi quyền riêng tư trên iOS 14.
     Rắc rối đến từ thay đổi quan trọng của IDFA (Identifier for Advertisers) - mã số riêng trên mỗi iPhone, iPad giúp các doanh nghiệp triển khai quảng cáo được cá nhân hóa cho từng thiết bị.
     Các ứng dụng sẽ phải xin ý kiến trước khi theo dõi hành vi người dùng trên các ứng dụng và website khác để thu thập dữ liệu, vốn là những thông tin cần thiết trong việc hướng đối tượng quảng cáo, đo lường hiệu quả marketing. Mô hình quảng cáo của Facebook đang bị tấn công sau những thay đổi trên iOS 14. Ảnh: Getty Images.
     Ban đầu, Apple muốn áp dụng thay đổi ngay khi iOS 14 được phát hành. Tuy nhiên đến phút chót, hãng đã dời việc triển khai đến năm 2021 để các ứng dụng có thời gian thay đổi. Fischer cho biết dù có những lo lắng về rủi ro của quảng cáo được cá nhân hóa, chúng là thứ cần thiết để Internet tiếp tục phát triển. “Không chỉ Facebook mà rất nhiều doanh nghiệp cũng đang dựa vào mô hình kinh doanh này… Nó mang đến những nội dung miễn phí, giúp doanh nghiệp hoạt động nhờ quảng cáo”, giám đốc doanh thu Facebook cho biết mô hình kinh doanh này đang bị (Apple) tấn công, và người ảnh hưởng nhiều nhất chính là doanh nghiệp và lập trình viên.
     Trong khi đó, Apple nói sự thay đổi nhằm bảo vệ quyền riêng tư của người dùng chứ không phải tấn công vào ngành quảng cáo. Quy định được đưa ra sau nhiều bê bối liên quan đến các doanh nghiệp thu thập dữ liệu người dùng, và Facebook là một trong số đó. “Có nhiều mô hình kinh doanh đang hoạt động. Apple có mô hình bán sản phẩm cao cấp và dịch vụ, chủ yếu dành cho người dùng như chúng tôi, những người may mắn có thu nhập cao… Tuy nhiên, tôi cho rằng việc ra lệnh áp đặt các mô hình kinh doanh khác là không phù hợp”, Fischer cho biết sẽ bảo vệ mô hình quảng cáo của Facebook. Theo Fischer, quảng cáo là mô hình kinh doanh có giá trị, đối với Facebook là quảng cáo được cá nhân hóa. Không chỉ Facebook mà cả ngành quảng cáo sẽ bảo vệ mô hình này. Apple bị các nhà quảng cáo chỉ trích khi bổ sung tính năng hiện cửa sổ xin ý kiến theo dõi người dùng trên iOS 14. Ảnh: AppleInsider. Jake Moore, chuyên gia an ninh mạng của ESET cho rằng iOS 14 sẽ khiến người dùng suy nghĩ lại về những rủi ro khi chia sẻ dữ liệu. Điều đó buộc Facebook xem xét các nguồn doanh thu khác để chuẩn bị cho “làn sóng quyền riêng tư”. “Apple đã gián tiếp thay đổi đáng kể mô hình kinh doanh của Facebook khi tập trung vào quyền riêng tư. Nó như cú tát vào Facebook và các doanh nghiệp phụ thuộc vào việc thu thập dữ liệu người dùng”, Moore cho biết. Tất nhiên, vẫn có những ý kiến trái chiều về loạt tính năng kiểm soát quyền riêng tư trên iOS 14. Casey Newton, biên tập viên The Verge cho rằng Apple đang áp dụng các quy tắc để phục vụ tính năng hướng đối tượng quảng cáo của riêng họ.
     * img_photo : [{"id":"3","id_news":"1","img_photo":"uploads/news/07507102020.jpeg"},{"id":"4","id_news":"1","img_photo":"uploads/news/07607102020.jpg"}]
     */

    private String id;
    private String id_category;
    private String upload_date;
    private String thumb_800_300;
    private String news_content;
    private ImgPhotoNewsModel[] img_photo;

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

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public ImgPhotoNewsModel[] getImg_photo() {
        return img_photo;
    }

    public void setImg_photo(ImgPhotoNewsModel[] img_photo) {
        this.img_photo = img_photo;
    }
}
