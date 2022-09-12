package iuh.se.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import iuh.se.beans.ChiTietHoaDon;
 
@Repository
public class ChiTietHoaDonDAO {
	@Autowired
	private JdbcTemplate template;
	@Autowired HoaDonDAO hddao;
	@Autowired SanPhamDAO spdao;
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int insertCTHD(ChiTietHoaDon cthd) {

		String sql = "Insert into db.ChiTietHoaDon Values(" + cthd.getSlMua() + "," + cthd.getSp().getMaSp() + ","+ cthd.getHd().getMaHD() +","+cthd.getTongTien()+")";
		return template.update(sql);
	}
	public List<ChiTietHoaDon> getAllChiTietHoaDon(int maHD){
		String sql = "select * from db.ChiTietHoaDon where maHD ="+maHD;;
		return template.query(sql, new RowMapper<ChiTietHoaDon>() {

			@Override
			public ChiTietHoaDon mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				ChiTietHoaDon cthd = new ChiTietHoaDon();
				cthd.setMaCTHD(rs.getInt(1));
				cthd.setSlMua(rs.getInt(2));
				cthd.setSp(spdao.layChiTietSP(rs.getInt(3)));
				cthd.setTongTien(rs.getFloat(5));
				
				return cthd;
			}
			
		});
	}

}
