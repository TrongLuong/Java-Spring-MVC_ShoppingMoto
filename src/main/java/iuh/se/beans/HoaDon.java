package iuh.se.beans;

import java.util.ArrayList;
import java.util.List;

public class HoaDon {	 
	private int maHD;
	private String ngayMua;
	private float togTien;	
	private TaiKhoan tkMua;
	private List<ChiTietHoaDon> listCTHD = new ArrayList<ChiTietHoaDon>();
	
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public String getNgayMua() {
		return ngayMua;
	}

	public void setNgayMua(String ngayMua) {
		this.ngayMua = ngayMua;
	}

	public float getTogTien() {
		return togTien;
	}

	public void setTogTien(float togTien) {
		this.togTien = togTien;
	}

	public TaiKhoan getTkMua() {
		return tkMua;
	}

	public void setTkMua(TaiKhoan tkMua) {
		this.tkMua = tkMua;
	}

	public List<ChiTietHoaDon> getListCTHD() {
		return listCTHD;
	}

	public void setListCTHD(List<ChiTietHoaDon> listCTHD) {
		this.listCTHD = listCTHD;
	}

	public HoaDon(int maHD, String ngayMua, float togTien, TaiKhoan tkMua, List<ChiTietHoaDon> listCTHD) {
		super();
		this.maHD = maHD;
		this.ngayMua = ngayMua;
		this.togTien = togTien;
		this.tkMua = tkMua;
		this.listCTHD = listCTHD;
	}

	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ngayMua=" + ngayMua + ", togTien=" + togTien + ", tkMua=" + tkMua
				+ ", listCTHD=" + listCTHD + "]";
	}
 
	
	
	
	 

}
