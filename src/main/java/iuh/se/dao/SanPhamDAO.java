package iuh.se.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import iuh.se.beans.NhaSanXuat;
import iuh.se.beans.SanPham;
 
 
 
 

@Repository
public class SanPhamDAO {
	@Autowired
	JdbcTemplate template;
 
	@Autowired
	NhaSanXuatDAO nsxdao;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	//danh sach xe moi
		public List<SanPham> getAllSanPham(){
			String sql = "select * from db.SanPham";
			return template.query(sql, new RowMapper<SanPham>() {

				@Override
				public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					SanPham spxe = new SanPham();
					spxe.setMaSp (rs.getInt(1));
					spxe.setTenSp(rs.getString(2));
					spxe.setGiaSp(rs.getFloat(3));
					spxe.setTongSLSp(rs.getInt(4));
					spxe.setHinhAnhSp(rs.getString(5));
					spxe.setMoTaSp(rs.getString(6));
					spxe.setNgayNhap(rs.getString(7));
					spxe.setLoaiSP(rs.getString(8)); 
					NhaSanXuat nsx = nsxdao.layNSXTheoMa(rs.getInt(9));
					spxe.setNsx(nsx);
				 
					return spxe;
				}
				
			});
		}
		
		public List<SanPham> getSPTheoNSX(int maNSX){
			String sql = "select * from db.SanPham s where s.maNSX ='" + maNSX + "'";
			return template.query(sql, new RowMapper<SanPham>() {

				@Override
				public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					SanPham spxe = new SanPham();
					spxe.setMaSp (rs.getInt(1));
					spxe.setTenSp(rs.getString(2));
					spxe.setGiaSp(rs.getFloat(3));
					spxe.setTongSLSp(rs.getInt(4));
					spxe.setHinhAnhSp(rs.getString(5));
					spxe.setMoTaSp(rs.getString(6));
					spxe.setNgayNhap(rs.getString(7));
					spxe.setLoaiSP(rs.getString(8)); 
					NhaSanXuat nsx = nsxdao.layNSXTheoMa(rs.getInt(9));
					spxe.setNsx(nsx);
				 
	 		
			 			
					return spxe;
				}
				
			});
		}
		public List<SanPham> getSPTheoLoai( ){
			String x ="Phu kien";
			String sql = "select * from db.SanPham s where s.loaiSP ='" + x + "'";
			return template.query(sql, new RowMapper<SanPham>() {

				@Override
				public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					SanPham spxe = new SanPham();
					spxe.setMaSp (rs.getInt(1));
					spxe.setTenSp(rs.getString(2));
					spxe.setGiaSp(rs.getFloat(3));
					spxe.setTongSLSp(rs.getInt(4));
					spxe.setHinhAnhSp(rs.getString(5));
					spxe.setMoTaSp(rs.getString(6));
					spxe.setNgayNhap(rs.getString(7));
					spxe.setLoaiSP(rs.getString(8)); 
					NhaSanXuat nsx = nsxdao.layNSXTheoMa(rs.getInt(9));
					spxe.setNsx(nsx);
				 
	 		
			 			
					return spxe;
				}
				
			});
		}
		
		public List<SanPham> getSPTheoLoaiXe( ){
			String x ="Xe";
			String sql = "select * from db.SanPham s where s.loaiSP ='" + x + "'";
			return template.query(sql, new RowMapper<SanPham>() {

				@Override
				public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					SanPham spxe = new SanPham();
					spxe.setMaSp (rs.getInt(1));
					spxe.setTenSp(rs.getString(2));
					spxe.setGiaSp(rs.getFloat(3));
					spxe.setTongSLSp(rs.getInt(4));
					spxe.setHinhAnhSp(rs.getString(5));
					spxe.setMoTaSp(rs.getString(6));
					spxe.setNgayNhap(rs.getString(7));
					spxe.setLoaiSP(rs.getString(8)); 
					NhaSanXuat nsx = nsxdao.layNSXTheoMa(rs.getInt(9));
					spxe.setNsx(nsx);
				 
	 		
			 			
					return spxe;
				}
				
			});
		}
		public List<SanPham> layCTSP(int maSP){
			String sql = "select * from db.SanPham s where s.maSP ='" + maSP + "'";
			return template.query(sql, new RowMapper<SanPham>() {

				@Override
				public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					SanPham spxe = new SanPham();
					spxe.setMaSp (rs.getInt(1));
					spxe.setTenSp(rs.getString(2));
					spxe.setGiaSp(rs.getFloat(3));
					spxe.setTongSLSp(rs.getInt(4));
					spxe.setHinhAnhSp(rs.getString(5));
					spxe.setMoTaSp(rs.getString(6));
					spxe.setNgayNhap(rs.getString(7));
					spxe.setLoaiSP(rs.getString(8)); 
					NhaSanXuat nsx = nsxdao.layNSXTheoMa(rs.getInt(9));
					spxe.setNsx(nsx);
					return spxe;
				}
				
			});
		}
		
		//lay chi tiet sp theo maSP
		public SanPham layChiTietSP(int masp) {
			String sql = "select * from db.SanPham   where maSp = ?";		 
			return template.queryForObject(sql, new Object[] {masp},new BeanPropertyRowMapper<SanPham>(SanPham.class));
		}
		
		//timsp theo loai va nsx
		public List<SanPham> timSPTheoTenorNSX(String tensp_nsx){
			String sql = "select * from db.SanPham s join db.NhaSanXuat n ON n.maNSX = s.maNSX  Where s.tenSp LIKE '%"+tensp_nsx+"%' OR n.tenNSX like '%"+tensp_nsx+"%'";
			return template.query(sql, new RowMapper<SanPham>() {
				@Override
				public SanPham mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					SanPham spxe = new SanPham();
					spxe.setMaSp (rs.getInt(1));
					spxe.setTenSp(rs.getString(2));
					spxe.setGiaSp(rs.getFloat(3));
					spxe.setTongSLSp(rs.getInt(4));
					spxe.setHinhAnhSp(rs.getString(5));
					spxe.setMoTaSp(rs.getString(6));
					spxe.setNgayNhap(rs.getString(7));
					spxe.setLoaiSP(rs.getString(8)); 
					NhaSanXuat nsx = nsxdao.layNSXTheoMa(rs.getInt(9));
					spxe.setNsx(nsx);			
					return spxe;
				}
				
			});
		}
		
		public int xoaSP(String maSp) {
			String sql = "delete from db.SanPham where maSp = '"+maSp+"'";
			return template.update(sql);
		}
		//them sp
		public int themXe(SanPham sp) {
		 
			String sql = "insert into db.SanPham values (N'"+sp.getTenSp()+"','"+sp.getGiaSp()+"','"+sp.getTongSLSp()+"','"+sp.getHinhAnhSp()+"',N'"+sp.getMoTaSp()+"','"+sp.getNgayNhap()+"',N'"+sp.getLoaiSP()+"','"+sp.getMaNSX()+ "')";
			return template.update(sql);
		}
		public int updateSP(SanPham sp) {
			String sql="update db.SanPham set tenSp=?,giaSp=?, tongSLSp=?,hinhAnhSp=?, moTaSp=?, loaiSP=?, maNSX=? where maSp=?";
			return template.update(sql,sp.getTenSp(), sp.getGiaSp(), sp.getTongSLSp(), sp.getHinhAnhSp(), sp.getMoTaSp(), sp.getLoaiSP(), sp.getMaNSX(), sp.getMaSp());
		}
		

	 

}
