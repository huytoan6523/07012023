package com.example.demo.service;

import com.example.demo.entity.NhanVien;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NhanVienService {

    List<NhanVien> getAll();

    void addNhanVien(NhanVien nhanVien);

    void updateNhanVien(NhanVien nhanVien);

    void removeNhanVien(String id);

    NhanVien detailNhanVien(String id);

    Page<NhanVien> phanTrang(Integer pageNo);

    List<NhanVien> search(Integer min, Integer max);
}
