package com.example.demo.service.impl;

import com.example.demo.entity.NhanVien;
import com.example.demo.repository.NhanVienRepository;
import com.example.demo.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    @Override
    public List<NhanVien> getAll() {
        return this.nhanVienRepository.findAll();
    }

    @Override
    public void addNhanVien(NhanVien nhanVien) {
        this.nhanVienRepository.save(nhanVien);
    }

    @Override
    public void updateNhanVien(NhanVien nhanVien) {
        this.nhanVienRepository.save(nhanVien);
    }

    @Override
    public void removeNhanVien(String id) {
        this.nhanVienRepository.delete(this.detailNhanVien(id));
    }

    @Override
    public NhanVien detailNhanVien(String id) {
        Optional<NhanVien> nhanVien = this.nhanVienRepository.findById(id);
        if (nhanVien.isPresent()) {
            return nhanVien.get();
        }
        return null;
    }

    @Override
    public Page<NhanVien> phanTrang(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo,5);
        return this.nhanVienRepository.findAll(pageable);
    }

    @Override
    public List<NhanVien> search(Integer min, Integer max) {
        return null;
    }
}
