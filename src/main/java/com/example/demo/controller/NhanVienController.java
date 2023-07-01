package com.example.demo.controller;


import com.example.demo.entity.ChucVu;
import com.example.demo.entity.NhanVien;
import com.example.demo.service.ChucVuService;
import com.example.demo.service.CuaHangService;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/nhan-vien")
public class NhanVienController {

//    adaf
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private CuaHangService cuaHangService;
    @Autowired
    private ChucVuService chucVuService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model,@RequestParam(defaultValue = "0", name = "page") Integer number) {
        model.addAttribute("nhanViens1", this.nhanVienService.phanTrang(number));
        model.addAttribute("nhanViens", this.nhanVienService.phanTrang(number).getContent());
        model.addAttribute("cuaHangs", this.cuaHangService.getAll());
        model.addAttribute("chucVus", this.chucVuService.getAll());
        model.addAttribute("nhanVienAdd", new NhanVien());
        return "trang-chu";
    }

    @GetMapping("/remove/{id}")
    public String removeNhanVien(@PathVariable("id") String id) {
        this.nhanVienService.removeNhanVien(id);
        return "redirect:/nhan-vien/hien-thi";
    }

    @GetMapping("/detail/{id}")
    public String detailNhanVien(@PathVariable("id") String id, Model model,@RequestParam(defaultValue = "0", name = "page") Integer number) {
        model.addAttribute("nhanViens1", this.nhanVienService.phanTrang(number));
        model.addAttribute("nhanViens", this.nhanVienService.phanTrang(number).getContent());
        model.addAttribute("cuaHangs", this.cuaHangService.getAll());
        model.addAttribute("chucVus", this.chucVuService.getAll());
        model.addAttribute("nhanVienAdd", this.nhanVienService.detailNhanVien(id));
        return "trang-chu";
    }

    @GetMapping("/view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id, Model model,@RequestParam(defaultValue = "0", name = "page") Integer number) {
        model.addAttribute("nhanViens1", this.nhanVienService.phanTrang(number));
        model.addAttribute("nhanViens", this.nhanVienService.phanTrang(number).getContent());
        model.addAttribute("cuaHangs", this.cuaHangService.getAll());
        model.addAttribute("chucVus", this.chucVuService.getAll());
        model.addAttribute("nhanVienAdd", this.nhanVienService.detailNhanVien(id));
        return "view-update";
    }

    @PostMapping("/add")
    public String addNhanVien(@ModelAttribute("nhanVienAdd") NhanVien nhanVien) {
        this.nhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }

    @PostMapping("/update/{id}")
    public String updateNhanVien(@ModelAttribute("nhanVienAdd") NhanVien nhanVien, @PathVariable("id") String id) {
        nhanVien.setId(id);
        System.out.println(nhanVien.toString());
        this.nhanVienService.updateNhanVien(nhanVien);
        return "redirect:/nhan-vien/hien-thi";
    }
//
//    @PostMapping("/search")
//    public String search(@RequestParam("tuoiMin") Integer min,
//                         @RequestParam("tuoiMax") Integer max){
//
//    }
}
