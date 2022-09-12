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
 
 

 

@Repository
public class NhaSanXuatDAO {
	@Autowired
	private JdbcTemplate template;
	@Autowired
	SanPhamDAO spdao;

	public JdbcTemplate getTemplate() {
		return template;
	}


	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}


		//list nsx
		public List<NhaSanXuat> getAllNSX(){ 
			String sql = "select * from  db.NhaSanXuat ";
			
			return template.query(sql, new RowMapper<NhaSanXuat>() {
				@Override
				public NhaSanXuat mapRow(ResultSet rs, int rowNum) throws SQLException {
					// TODO Auto-generated method stub
					NhaSanXuat nsx = new NhaSanXuat();		 
			 
					nsx.setMaNSX(rs.getInt(1));
					nsx.setTenNSX(rs.getString(2));						 
					return nsx;
				}				
			});			 
		}
		
	 
		
		
		//lay nsx theo ma
		public NhaSanXuat layNSXTheoMa(int maNSX) {
			String sql = "select * from db.NhaSanXuat n where n.maNSX = ?";
			return template.queryForObject(sql, new Object[] {maNSX},new BeanPropertyRowMapper<NhaSanXuat>(NhaSanXuat.class));
		}
		 
		public int themNSX(NhaSanXuat nsx) {
			 
			String sql = "insert into db.NhaSanXuat values ('" + nsx.getTenNSX() +"')";
			return template.update(sql);
		}
		public int xoaNSX(String maNSX) {
			String sql = "delete from db.NhaSanXuat where maNSX = '"+maNSX+"'";
			return template.update(sql);
		}
		public int updateNSX(NhaSanXuat nsx) {
			String sql="update db.NhaSanXuat set tenNSX=? where maNSX=?";
			return template.update(sql,nsx.getTenNSX(), nsx.getMaNSX());
		}
	 
		 
		 

}
