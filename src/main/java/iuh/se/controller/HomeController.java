package iuh.se.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import iuh.se.beans.ChiTietHoaDon;
import iuh.se.beans.HoaDon;
import iuh.se.beans.NhaSanXuat;
import iuh.se.beans.SanPham;
import iuh.se.beans.TaiKhoan;
import iuh.se.dao.ChiTietHoaDonDAO;
import iuh.se.dao.HoaDonDAO;
import iuh.se.dao.NhaSanXuatDAO;
import iuh.se.dao.SanPhamDAO;
import iuh.se.dao.TaiKhoanDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final String UPLOAD_DIRECTORY = "resources/spxe";
	@Autowired
	TaiKhoanDAO tkdao;
	@Autowired
	NhaSanXuatDAO nsxdao;
	@Autowired
	SanPhamDAO spdao;
	@Autowired 
	HoaDonDAO hddao;
	@Autowired 
	ChiTietHoaDonDAO cthddao;

	private List<NhaSanXuat> addNSXNav() {
		List<NhaSanXuat> listNSX = nsxdao.getAllNSX();
		return listNSX;

	}
	

	private String layNgayGioHienTai() {
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return df1.format(date);
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/dangky", method = RequestMethod.GET)
	public String dangky(Locale locale, ModelMap model) {
		TaiKhoan dkkh = new TaiKhoan();
		model.addAttribute("dkkh", dkkh);
		return "dangky";
	}

	@RequestMapping(value = "/xulydangky", method = RequestMethod.POST)
	public String xulydangky(@ModelAttribute("dkkh") @Validated TaiKhoan dkkh, BindingResult result, Model model,
			HttpSession session) throws Exception {
		try {
			
			tkdao.dangKyTaiKhoanKhachHang(dkkh);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String trungEmail = "Địa chỉ mail này đã đăng ký rồi!";
			model.addAttribute("trungEmail", trungEmail);
			return "dangky";

		}

		return "dangnhap";
	}

	@RequestMapping(value = "/dangnhap", method = RequestMethod.GET)
	public String dangnhap(Locale locale, Model model) {
		TaiKhoan tk = new TaiKhoan();
		model.addAttribute("tk",tk);

		return "dangnhap";
	}

	@RequestMapping(value = "/xulydangnhap", method = RequestMethod.POST)
	public String xulydangnhap(@ModelAttribute("tk") @Validated TaiKhoan tk, HttpSession session, Model model) {

		if (tk != null) {
			// lay tai khoan theo email,pass
			TaiKhoan userDN;
			try {

				userDN = tkdao.ktraDN(tk.getEmailTK(), tk.getPwTK());
				System.out.println(userDN.toString());
				if (userDN != null) {
					// gan userDN vao session
					session.setAttribute("userDN", userDN);
					// ktra co phai admin k
					if (userDN.getLoaiTK() == 1) {
						// dung la admin thi tra ve gia dien quan ly
						return "redirect:/adminquanlysp";
					} else {
						session.removeAttribute("tkNll");
						return "redirect:/";
					}

				}
			} catch (EmptyResultDataAccessException e) {
				String err = "Tên đăng nhập hoặc mật khẩu sai!";
				model.addAttribute("err", err);
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block

				e.printStackTrace();
			}

		}

		return "dangnhap";
	}

	@RequestMapping(value = "/adminquanlysp", method = RequestMethod.GET)
	public String adminquanlysp(Locale locale, ModelMap model) {
		List<SanPham> dssp = spdao.getAllSanPham();
		model.addAttribute("dssp", dssp);

		return "adminquanly";
	}

	@RequestMapping(value = "/dangxuat", method = RequestMethod.GET)
	public String dangxuat(HttpSession session, ModelMap model) {
		session.removeAttribute("userDN");
		return "redirect:/";
	}

	@RequestMapping(value = {"/xemay" }, method = RequestMethod.GET)
	public String xemay(Locale locale, Model model, HttpSession session) {
		 
		List<SanPham> listSP = spdao.getSPTheoLoaiXe();
		model.addAttribute("listNSX", addNSXNav());
		model.addAttribute("listSP", listSP);
	 
		return "xemay";
	}
	@RequestMapping(value = {"/home","/" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		 
		List<SanPham> listSP = spdao.getAllSanPham();
		model.addAttribute("listNSX", addNSXNav());
		model.addAttribute("listSP", listSP);
	 
		return "xemay";
	}

	@RequestMapping(value = "/timsptheonsx", method = RequestMethod.GET)
	public String timsptheonsx(@Validated String maNSX, Model model) {
		int maNSXInt = Integer.parseInt(maNSX);
		List<SanPham> dssp = spdao.getSPTheoNSX(maNSXInt);
		model.addAttribute("listNSX", addNSXNav());
		model.addAttribute("listNSX", addNSXNav());
		String erro404 = "Không có sản phẩm này";
		if (dssp.isEmpty()) {

			model.addAttribute("erro404", erro404);
		} else {

			model.addAttribute("timsptheonsx", dssp);
		}

		return "xemay";
	}
	@RequestMapping(value = "/phukienxe", method = RequestMethod.GET)
	public String phukienxe( Model model) {
	 
		List<SanPham> dssp = spdao.getSPTheoLoai();
		
		model.addAttribute("listNSX", addNSXNav());
		model.addAttribute("listNSX", addNSXNav());
		String erro404 = "Không có sản phẩm này";
		if (dssp.isEmpty()) {

			model.addAttribute("erro404", erro404);
		} else {

			model.addAttribute("timsptheonsx", dssp);
		}

		return "xemay";
	}

	@RequestMapping(value = "/timsanpham", method = RequestMethod.GET)
	public String timsanpham(@Validated String tensp_nsx, Model model) {
		model.addAttribute("listNSX", addNSXNav());
		List<SanPham> dssp = spdao.timSPTheoTenorNSX(tensp_nsx);
		String tuKhoatimxe = tensp_nsx;

		String erro404 = "Không có sản phẩm này !!!";
		if (dssp.isEmpty()) {
			model.addAttribute("tuKhoatimxe", tuKhoatimxe);

			model.addAttribute("erro404", erro404);
		} else {
			model.addAttribute("tuKhoatimxe", tuKhoatimxe);
			model.addAttribute("timxe", dssp);
		}

		return "xemay";
	}

	@RequestMapping(value = "/chitietsanpham", method = RequestMethod.GET)
	public String chitietsanpham(@Validated String masp, Model model) {
		int maspInt = Integer.parseInt(masp);
		List<SanPham> litSP = spdao.layCTSP(maspInt);
		model.addAttribute("listNSX", addNSXNav());
		SanPham sp = litSP.get(0);

		System.out.println(litSP.toString());

		model.addAttribute("ctxe", sp);

		return "chitietsanpham";
	}

	// xoa sp
	@RequestMapping("/adminxoasp/{maSp}")
	public String xoaXe(@PathVariable String maSp) {
		spdao.xoaSP(maSp);
		return "redirect:/adminquanlysp";
	}

	@RequestMapping("/adminthemsp")
	public String adminthemsp(Locale locale, ModelMap model) {
		SanPham sp = new SanPham();
		model.addAttribute("sp", sp);
		model.addAttribute("listNSX", addNSXNav());

		//
		//
		// String err404 = "Nhập đầy đủ thông tin!";
		// model.addAttribute("err404", err404);

		return "adminthemsp";
	}

	@RequestMapping(value = "/xulyadminthemsp", method = RequestMethod.POST)
	public String xulyadminthemxe(@ModelAttribute("sp") @Validated SanPham sp, BindingResult result, Model model,
			@RequestParam CommonsMultipartFile file, HttpSession session) throws Exception {

		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		String filename = file.getOriginalFilename();

		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(path + File.separator + filename)));

		stream.write(bytes);
		stream.flush();
		stream.close();

		sp.setHinhAnhSp("spxe/" + filename);

		sp.setNgayNhap(layNgayGioHienTai());

		spdao.themXe(sp);
		System.out.println("Them thanh cong" + sp.toString());
		return "redirect:/adminthemsp";
	}

	@RequestMapping(value = "/admintimsp", method = RequestMethod.GET)
	public String admintimsp(@Validated String tensp, Model model) {

		List<SanPham> dspe = spdao.timSPTheoTenorNSX(tensp);
		String tuKhoatimxe = tensp;

		String erro404 = "Không tìm thấy " + tuKhoatimxe + " !!!";
		if (dspe.isEmpty()) {

			model.addAttribute("erro404", erro404);
		} else {
			model.addAttribute("tuKhoatimsp", tuKhoatimxe);
			model.addAttribute("admintimsp", dspe);
		}

		return "adminquanly";

	}

	@RequestMapping("/adminquanlynsx")
	public String adminquanlynsx(Locale locale, ModelMap model) {
		List<NhaSanXuat> dsnsx = nsxdao.getAllNSX();
		model.addAttribute("dsnsx", dsnsx);

		return "adminquanlynsx";
	}

	@RequestMapping("/adminthemnsx")
	public String adminthemnsx(Locale locale, ModelMap model) {
		NhaSanXuat nsx = new NhaSanXuat();
		model.addAttribute("nsx", nsx);

		return "adminthemnsx";
	}

	@RequestMapping(value = "/xulyadminthemnsx", method = RequestMethod.POST)
	public String xulyadminthemnsx(@ModelAttribute("nsx") @Validated NhaSanXuat nsx, BindingResult result, Model model,
			HttpSession session) throws Exception {

		nsxdao.themNSX(nsx);
		return "redirect:/adminquanlynsx";
	}

	@RequestMapping("/adminxoansx/{maNSX}")
	public String adminxoansx(@PathVariable String maNSX) {
		nsxdao.xoaNSX(maNSX);
		return "redirect:/adminquanlynsx";
	}

	@RequestMapping(value = "/admineditnsx", method = RequestMethod.GET)
	public String admineditnsx(@Validated String maNSX, Model model) {
		int manx = Integer.parseInt(maNSX);
		NhaSanXuat nsxedit = nsxdao.layNSXTheoMa(manx);
		model.addAttribute("nsxedit", nsxedit);
		return "admineditnsx";
	}

	@RequestMapping(value = "/xulyeditmnsx", method = RequestMethod.POST)
	public String xulyeditmnsx(@ModelAttribute("nsxedit") @Validated NhaSanXuat nsxedit, BindingResult result,
			Model model, HttpSession session) throws Exception {

		nsxdao.updateNSX(nsxedit);
		return "redirect:/adminquanlynsx";
	}

	@RequestMapping(value = "/admineditsp", method = RequestMethod.GET)
	public String admineditsp(@Validated String maSP, Model model) {
		int masp = Integer.parseInt(maSP);
		SanPham spedit = spdao.layChiTietSP(masp);
		model.addAttribute("spedit", spedit);
		model.addAttribute("listNSX", addNSXNav());
		System.out.println("lay se di cap nhat" + spedit.toString());

		return "admineditsp";
	}

	@RequestMapping(value = "/xulyeditmnsp", method = RequestMethod.POST)
	public String xulyeditmnsp(@ModelAttribute("spedit") @Validated SanPham spedit, BindingResult result, Model model,
			@RequestParam CommonsMultipartFile file,	HttpSession session) throws Exception {
		ServletContext context = session.getServletContext();
		String path = context.getRealPath(UPLOAD_DIRECTORY);
		String filename = file.getOriginalFilename();

		byte[] bytes = file.getBytes();
		BufferedOutputStream stream = new BufferedOutputStream(
				new FileOutputStream(new File(path + File.separator + filename)));

		stream.write(bytes);
		stream.flush();
		stream.close();

		spedit.setHinhAnhSp("spxe/" + filename);
		System.out.println("da cap nhat" + spedit.toString());
			spdao.updateSP(spedit);

		return "redirect:/adminquanlysp";
	}
	
	@RequestMapping(value = { "/quanlydonhang" }, method = RequestMethod.GET)
	public String quanlydonhang(Locale locale, Model model) {

		List<HoaDon> listhd = hddao.getAllHoaDon();		 
		model.addAttribute("listhd", listhd);
 
		return "danhsachhoadon";
	}
	@RequestMapping(value ="/cthd",  method = RequestMethod.GET)
	public String cthd(@Validated String maHD, Model model) {
		int mahd = Integer.parseInt(maHD);
		List<ChiTietHoaDon> listCTHD = cthddao.getAllChiTietHoaDon(mahd);
		model.addAttribute("listCTHD",listCTHD);
		System.out.println(listCTHD.toString());
		
		return "chitiethoadon";
	}


}
