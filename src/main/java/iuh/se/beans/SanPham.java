package iuh.se.beans;
 

public class SanPham {
 
	private int maSp;
	private String tenSp;
	private float giaSp;
	private int tongSLSp;
	private String hinhAnhSp;
	private String moTaSp;
	private String ngayNhap;
	private String loaiSP;
	private NhaSanXuat nsx;
	private int maNSX;
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getMaNSX() {
		return maNSX;
	}

	public void setMaNSX(int maNSX) {
		this.maNSX = maNSX;
	}

	public SanPham(int maSp, String tenSp, float giaSp, int tongSLSp, String hinhAnhSp, String moTaSp, String ngayNhap,
			String loaiSP, NhaSanXuat nsx, int maNSX) {
		super();
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.giaSp = giaSp;
		this.tongSLSp = tongSLSp;
		this.hinhAnhSp = hinhAnhSp;
		this.moTaSp = moTaSp;
		this.ngayNhap = ngayNhap;
		this.loaiSP = loaiSP;
		this.nsx = nsx;
		this.maNSX = maNSX;
	}

	public SanPham(int maSp, String tenSp, float giaSp, int tongSLSp, String hinhAnhSp, String moTaSp, String ngayNhap,
			String loaiSP, NhaSanXuat nsx) {
		super();
		this.maSp = maSp;
		this.tenSp = tenSp;
		this.giaSp = giaSp;
		this.tongSLSp = tongSLSp;
		this.hinhAnhSp = hinhAnhSp;
		this.moTaSp = moTaSp;
		this.ngayNhap = ngayNhap;
		this.loaiSP = loaiSP;
		this.nsx = nsx;
	}
	public int getMaSp() {
		return maSp;
	}
	public void setMaSp(int maSp) {
		this.maSp = maSp;
	}
	public String getTenSp() {
		return tenSp;
	}
	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}
	public float getGiaSp() {
		return giaSp;
	}
	public void setGiaSp(float giaSp) {
		this.giaSp = giaSp;
	}
	public int getTongSLSp() {
		return tongSLSp;
	}
	public void setTongSLSp(int tongSLSp) {
		this.tongSLSp = tongSLSp;
	}
	public String getHinhAnhSp() {
		return hinhAnhSp;
	}
	public void setHinhAnhSp(String hinhAnhSp) {
		this.hinhAnhSp = hinhAnhSp;
	}
	public String getMoTaSp() {
		return moTaSp;
	}
	public void setMoTaSp(String moTaSp) {
		this.moTaSp = moTaSp;
	}
	public String getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public String getLoaiSP() {
		return loaiSP;
	}
	public void setLoaiSP(String loaiSP) {
		this.loaiSP = loaiSP;
	}
	public NhaSanXuat getNsx() {
		return nsx;
	}
	public void setNsx(NhaSanXuat nsx) {
		this.nsx = nsx;
	}
	@Override
	public String toString() {
		return "SanPham [maSp=" + maSp + ", tenSp=" + tenSp + ", giaSp=" + giaSp + ", tongSLSp=" + tongSLSp
				+ ", hinhAnhSp=" + hinhAnhSp + ", moTaSp=" + moTaSp + ", ngayNhap=" + ngayNhap + ", loaiSP=" + loaiSP
				+   ", maNSX=" + maNSX + "]";
	}
	 
	
	 
}
