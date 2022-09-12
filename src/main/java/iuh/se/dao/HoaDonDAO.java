package iuh.se.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import iuh.se.beans.HoaDon;
 
 

 

@Repository
public class HoaDonDAO {
	@Autowired
	private JdbcTemplate template;
	@Autowired
	TaiKhoanDAO tkdao;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	public int insertHD(HoaDon hd) {
		String sql = "Insert into db.HoaDon Values('"+hd.getNgayMua()+"', '"+hd.getTogTien()+"', '"+hd.getTkMua().getEmailTK()+"')";
		return template.update(sql);
	}
	
 
	public HoaDon getLastID() {
	 
		String sql = "Select top 1 * From db.HoaDon ORDER BY maHD DESC";
		return template.queryForObject(sql, new BeanPropertyRowMapper<HoaDon>(HoaDon.class));
	}
	public List<HoaDon> getAllHoaDon(){
		String sql = "select * from db.HoaDon";
		return template.query(sql, new RowMapper<HoaDon>() {

			@Override
			public HoaDon mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				HoaDon hd = new HoaDon();
				hd.setMaHD(rs.getInt(1));
				hd.setNgayMua(rs.getString(2));
				hd.setTogTien(rs.getFloat(3)); 
				
				try {
					hd.setTkMua(tkdao.layTKTheoEmail(rs.getString(4)));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 
				return hd;
			}
			
		});
	}
	
	 
	
}
