package iuh.se.beans;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TaiKhoan {
	
	private int id;
	//@Email(message = "Email không hợp lệ")
	private String emailTK;
	//@NotBlank(message = "Mật khẩu không được rỗng!")
	private String pwTK;
	private int loaiTK;
	//@NotBlank(message = "Tên không được rỗng!")
	private String hoTenKH;
	//@NotBlank(message = "Địa chỉ không được rỗng!")
	private String diaChiKH;
	
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaiKhoan(int id, String emailTK, String pwTK, int loaiTK, String hoTenKH, String diaChiKH) {
		super();
		this.id = id;
		this.emailTK = emailTK;
		this.pwTK = pwTK;
		this.loaiTK = loaiTK;
		this.hoTenKH = hoTenKH;
		this.diaChiKH = diaChiKH;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailTK() {
		return emailTK;
	}
	public void setEmailTK(String emailTK) {
		this.emailTK = emailTK;
	}
	public String getPwTK() {
		return pwTK;
	}
	public void setPwTK(String pwTK) {
		this.pwTK = pwTK;
	}
	public int getLoaiTK() {
		return loaiTK;
	}
	public void setLoaiTK(int loaiTK) {
		this.loaiTK = loaiTK;
	}
	public String getHoTenKH() {
		return hoTenKH;
	}
	public void setHoTenKH(String hoTenKH) {
		this.hoTenKH = hoTenKH;
	}
	public String getDiaChiKH() {
		return diaChiKH;
	}
	public void setDiaChiKH(String diaChiKH) {
		this.diaChiKH = diaChiKH;
	}
	@Override
	public String toString() {
		return "TaiKhoan [id=" + id + ", emailTK=" + emailTK + ", pwTK=" + pwTK + ", loaiTK=" + loaiTK + ", hoTenKH="
				+ hoTenKH + ", diaChiKH=" + diaChiKH + "]";
	}
	
	

}
