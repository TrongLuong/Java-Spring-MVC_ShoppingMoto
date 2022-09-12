package iuh.se.beans;

import java.util.List;

public class NhaSanXuat {
	private int maNSX;
	private String tenNSX;
	private List<SanPham> listSP;
	public NhaSanXuat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NhaSanXuat(int maNSX, String tenNSX, List<SanPham> listSP) {
		super();
		this.maNSX = maNSX;
		this.tenNSX = tenNSX;
		this.listSP = listSP;
	}

	public int getMaNSX() {
		return maNSX;
	}

	public void setMaNSX(int maNSX) {
		this.maNSX = maNSX;
	}

	public String getTenNSX() {
		return tenNSX;
	}

	public void setTenNSX(String tenNSX) {
		this.tenNSX = tenNSX;
	}

	public List<SanPham> getListSP() {
		return listSP;
	}

	public void setListSP(List<SanPham> listSP) {
		this.listSP = listSP;
	}

	@Override
	public String toString() {
		return "NhaSanXuat [maNSX=" + maNSX + ", tenNSX=" + tenNSX + ", listSP=" + listSP + "]";
	}

	 
}
