package iuh.se.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import iuh.se.beans.TaiKhoan;
 

@Repository
public class TaiKhoanDAO {
	@Autowired
	private JdbcTemplate template;
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	// them tai khoan
	public int dangKyTaiKhoanKhachHang(TaiKhoan tk) {
	 
		String sql = "insert into db.TaiKhoan values ('" + tk.getEmailTK() + "','" + tk.getPwTK() + "','"
				+ tk.getLoaiTK() + "',N'" + tk.getHoTenKH() + "',N'" + tk.getDiaChiKH() + "')";
		return template.update(sql);
	}

	// dang nhap admin
	public TaiKhoan ktraDN(String tkEmail, String tkPassword) throws Exception {
		String sql = "select * from db.TaiKHoan where emailTK = ? and pwTK = ?";
		return template.queryForObject(sql, new Object[] { tkEmail, tkPassword },new BeanPropertyRowMapper<TaiKhoan>(TaiKhoan.class));
	}
	public TaiKhoan layTKTheoEmail(String tkEmail) throws Exception {
		String sql = "select * from db.TaiKHoan where emailTK = ?  ";
		return template.queryForObject(sql, new Object[] { tkEmail },new BeanPropertyRowMapper<TaiKhoan>(TaiKhoan.class));
	}
	
	// lay tat ca tai khoan
	public List<TaiKhoan> getAllTaiKhoanKH() {
		String sql = "Select * from db.TaiKhoan";
		return template.query(sql, new RowMapper<TaiKhoan>() {
			@Override
			public TaiKhoan mapRow(ResultSet rs, int row) throws SQLException {
				TaiKhoan tk = new TaiKhoan();	
	 
				tk.setEmailTK(rs.getString(2));
				tk.setPwTK(rs.getString(3));
				tk.setLoaiTK(rs.getInt(4));
				tk.setHoTenKH(rs.getString(5));
				tk.setDiaChiKH(rs.getString(6)); 
			 
				return tk;
			}
		});
	}

}
