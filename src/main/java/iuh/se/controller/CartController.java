package iuh.se.controller;

import java.text.DateFormat;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import iuh.se.beans.ChiTietHoaDon;
import iuh.se.beans.HoaDon;
import iuh.se.beans.SanPham;
import iuh.se.beans.TaiKhoan;
import iuh.se.dao.ChiTietHoaDonDAO;
import iuh.se.dao.HoaDonDAO;
import iuh.se.dao.NhaSanXuatDAO;
import iuh.se.dao.SanPhamDAO;
import iuh.se.dao.TaiKhoanDAO;

@Controller
public class CartController {
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

	// private DecimalFormat df = new DecimalFormat("#,###");
	NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

	private String layNgayGioHienTai() {
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		return df1.format(date);
	}

	private int checkSLSP(String maSP) {
		int x;
		int msp = Integer.parseInt(maSP);
		SanPham sp = spdao.layChiTietSP(msp);
		x = sp.getTongSLSp();
		return x;
	}

	private void demItem(HttpSession session, HoaDon hoaDon) {
		int i = 0;

		if (hoaDon == null) {
			i = 0;
		} else {
			List<ChiTietHoaDon> listCTHD = hoaDon.getListCTHD();
			i = listCTHD.size();
		}
		session.setAttribute("demItem", i);

	}

	@RequestMapping(value = "/thanhtoan", method = RequestMethod.GET)
	public String thanhtoan(HttpSession session, Model model) {
		HoaDon hd = (HoaDon) session.getAttribute("GioHang");
		TaiKhoan tk = (TaiKhoan) session.getAttribute("userDN");
 
		if (tk != null && hd != null) {

			hd.setTkMua(tk);
			hd.setNgayMua(layNgayGioHienTai());
			System.out.println(hd.toString());
			hddao.insertHD(hd);

			List<ChiTietHoaDon> lsitCTHD = hd.getListCTHD();
			for (ChiTietHoaDon chiTietHoaDon : lsitCTHD) {
				chiTietHoaDon.setHd(hddao.getLastID());
				cthddao.insertCTHD(chiTietHoaDon);
			}

			session.removeAttribute("GioHang");
			session.removeAttribute("demItem");
			return "giohang";
		} else {
			String tkNll = "Vui lòng đăng nhập để thanh toán";
			session.setAttribute("tkNll", tkNll);
			return "giohang";
		}

	}

	@RequestMapping(value = "/xemgiohang", method = RequestMethod.GET)
	public String giohang(HttpSession session, Model model) {

		return "giohang";
	}

	@RequestMapping(value = "/themgiohang", method = RequestMethod.POST)
	public String themgiohang(@Validated String cartMaSp, @Validated String cartSLSp, HttpSession session,
			Model model) {

		session.removeAttribute("hdNll");
		session.removeAttribute("tkNll");
		TaiKhoan tk = (TaiKhoan) session.getAttribute("userDN");
		int slmua = Integer.parseInt(cartSLSp);
		int cartMaSpInt = Integer.parseInt(cartMaSp);
		if (slmua > checkSLSP(cartMaSp) || slmua<0) {

			 return "redirect:/xemay";
		} else {

			HoaDon hd = (HoaDon) session.getAttribute("GioHang");

			// chua co don hang nao
			if (hd == null) {
				// tao 1 danh sach don hang
				List<ChiTietHoaDon> listCTHD = new ArrayList<ChiTietHoaDon>();
				// lay 1 sp
				List<SanPham> listSP = spdao.layCTSP(cartMaSpInt);
				SanPham sp = listSP.get(0);
				// tao 1 line items
				ChiTietHoaDon cthd = new ChiTietHoaDon();

				cthd.setSlMua(slmua);
				cthd.setSp(sp);
				cthd.setTongTien(slmua * sp.getGiaSp());

				listCTHD.add(cthd);

				float tongTienCart = 0;
				for (ChiTietHoaDon chiTietHoaDon : listCTHD) {
					tongTienCart += chiTietHoaDon.getTongTien();

				}
				hd = new HoaDon();
				hd.setTogTien(tongTienCart);
				hd.setListCTHD(listCTHD);
				System.out.println("Khoi tao don hang" + hd.toString());

				session.setAttribute("GioHang", hd);
				String tongTienCartStr = currencyFormat.format(tongTienCart);
				session.setAttribute("tongTienCart", tongTienCartStr);
				demItem(session, hd);
			}
			// da co don hang
			else {

				boolean ktraSP = false;
				int maSP;
				List<ChiTietHoaDon> listCTHDs = hd.getListCTHD();

				for (ChiTietHoaDon chiTietHoaDon : listCTHDs) {
					maSP = chiTietHoaDon.getSp().getMaSp();
					if (maSP == cartMaSpInt) {
						int slHienTai = chiTietHoaDon.getSlMua();
						int updateSlMua = slHienTai + slmua;
						chiTietHoaDon.setSlMua(updateSlMua);
						chiTietHoaDon.setTongTien(updateSlMua * chiTietHoaDon.getSp().getGiaSp());
						float tongTienCart = 0;
						for (ChiTietHoaDon chiTiethd : listCTHDs) {
							tongTienCart += chiTiethd.getTongTien();
						}

						hd.setTogTien(tongTienCart);
						hd.setTkMua(tk);
						ktraSP = true;
						// System.out.println("Da co don hang" +hd.toString());
						demItem(session, hd);
						break;
					}

				}
				if (ktraSP == false) {
					List<SanPham> listSP = spdao.layCTSP(cartMaSpInt);
					SanPham sp = listSP.get(0);

					ChiTietHoaDon cthd = new ChiTietHoaDon();
					cthd.setSlMua(slmua);
					cthd.setSp(sp);
					cthd.setTongTien(slmua * sp.getGiaSp());
					listCTHDs.add(cthd);
					float tongTienCart = 0;
					for (ChiTietHoaDon chiTietHoaDon : listCTHDs) {
						tongTienCart += chiTietHoaDon.getTongTien();
					}
					hd.setListCTHD(listCTHDs);
					hd.setTogTien(tongTienCart);

					String tongTienCartStr = currencyFormat.format(tongTienCart);
					session.setAttribute("tongTienCart", tongTienCartStr);
					session.setAttribute("GioHang", hd);
					demItem(session, hd);

				}

			}
		 }
		return "giohang";
	}

	@RequestMapping("deleteitem/{maSP}")
	public String xoaitem(@PathVariable String maSP, HttpSession session, Model model) {
		HoaDon hd = (HoaDon) session.getAttribute("GioHang");

		List<ChiTietHoaDon> dsCTHD = hd.getListCTHD();

		for (int i = 0; i < dsCTHD.size(); i++) {
			String x = "maSP=" + dsCTHD.get(i).getSp().getMaSp();
			System.out.println("msp: " + x);
			if (x.equalsIgnoreCase(maSP)) {
				dsCTHD.remove(i);

				break;

			}

		}
		float tongTienCart = 0;
		for (ChiTietHoaDon chiTietHoaDon : dsCTHD) {
			tongTienCart += chiTietHoaDon.getTongTien();
		}
		hd.setTogTien(tongTienCart);
		session.setAttribute("GioHang", hd);
		demItem(session, hd);
		return "redirect:/xemgiohang";

	}

	@RequestMapping(value = "/capnhatgiohang", method = RequestMethod.POST)
	public String capnhatgiohang(@Validated String maSP, @Validated String editSlmua, HttpSession session,
			Model model) {
		HoaDon hd = (HoaDon) session.getAttribute("GioHang");

		// System.out.print("zzzzzzzzz"+maSP+"-"+editSlmua+hd.toString());
		List<ChiTietHoaDon> dsCTHD = hd.getListCTHD();
		int maSPInt = Integer.parseInt(maSP);
		for (int i = 0; i < dsCTHD.size(); i++) {
			if (dsCTHD.get(i).getSp().getMaSp() == maSPInt) {
				int sl = Integer.parseInt(editSlmua);
				if (sl > checkSLSP(maSP)) {
					return "giohang";
				}
				else if (sl == 0) {
					dsCTHD.remove(i);
					float tongTienCart = 0;
					for (ChiTietHoaDon chiTietHoaDon : dsCTHD) {
						tongTienCart += chiTietHoaDon.getTongTien();
					}
					hd.setTogTien(tongTienCart);
					demItem(session, hd);
					session.setAttribute("GioHang", hd);
					break;
				}

				dsCTHD.get(i).setSlMua(sl);
				dsCTHD.get(i).setTongTien(sl * dsCTHD.get(i).getSp().getGiaSp());
				break;

			}

		}
		float tongTienCart = 0;
		for (ChiTietHoaDon chiTietHoaDon : dsCTHD) {
			tongTienCart += chiTietHoaDon.getTongTien();
		}
		hd.setTogTien(tongTienCart);
		session.setAttribute("GioHang", hd);

		return "giohang";
	}

}
