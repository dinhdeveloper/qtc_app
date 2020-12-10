package qtc.project.app.model.customer;

import qtc.project.app.model.BaseResponseModel;

public class ContactModel extends BaseResponseModel {

    /**
     * id : 1
     * address : Hẻm 595/11-Lô B CMT8, Phường 15, Quận 10, HCM
     * hotline : (+84)90 6868 234
     * email : info@ninomotor.com
     * title_company : Nino Motor
     * facebook_contact :
     * zalo_contact : 0902911707
     * youtube_contact :
     */

    private String id;
    private String address;
    private String hotline;
    private String email;
    private String title_company;
    private String facebook_contact;
    private String zalo_contact;
    private String youtube_contact;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHotline() {
        return hotline;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle_company() {
        return title_company;
    }

    public void setTitle_company(String title_company) {
        this.title_company = title_company;
    }

    public String getFacebook_contact() {
        return facebook_contact;
    }

    public void setFacebook_contact(String facebook_contact) {
        this.facebook_contact = facebook_contact;
    }

    public String getZalo_contact() {
        return zalo_contact;
    }

    public void setZalo_contact(String zalo_contact) {
        this.zalo_contact = zalo_contact;
    }

    public String getYoutube_contact() {
        return youtube_contact;
    }

    public void setYoutube_contact(String youtube_contact) {
        this.youtube_contact = youtube_contact;
    }
}
