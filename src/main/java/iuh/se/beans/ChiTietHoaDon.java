package iuh.se.beans;

public class ChiTietHoaDon {
		private int maCTHD;
		private int slMua;	 
		private float tongTien;
		
		private SanPham sp;
		private HoaDon  hd;
		
		public ChiTietHoaDon() {
			super();
			// TODO Auto-generated constructor stub
		}
		public int getMaCTHD() {
			return maCTHD;
		}
		public void setMaCTHD(int maCTHD) {
			this.maCTHD = maCTHD;
		}
		public int getSlMua() {
			return slMua;
		}
		public void setSlMua(int slMua) {
			this.slMua = slMua;
		}
		public float getTongTien() {
			return tongTien;
		}
		public void setTongTien(float tongTien) {
			this.tongTien = tongTien;
		}
		public SanPham getSp() {
			return sp;
		}
		public void setSp(SanPham sp) {
			this.sp = sp;
		}
		public HoaDon getHd() {
			return hd;
		}
		public void setHd(HoaDon hd) {
			this.hd = hd;
		}
		@Override
		public String toString() {
			return "ChiTietHoaDon [maCTHD=" + maCTHD + ", slMua=" + slMua + ", tongTien=" + tongTien + ", sp=" + sp
					+ ", hd=" + hd + "]";
		}
		public ChiTietHoaDon(int maCTHD, int slMua, float tongTien, SanPham sp, HoaDon hd) {
			super();
			this.maCTHD = maCTHD;
			this.slMua = slMua;
			this.tongTien = tongTien;
			this.sp = sp;
			this.hd = hd;
		}
		 

	 
		
		
		 
}
