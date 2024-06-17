package com.example.truonganhtuan.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "nhanvien")
public class nhanvien {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "ten_nv")
    private String ten_nv;
    @Column(name = "phai")
    private String phai;
    @Column(name = "noi_sinh")
    private String noisinh;
    @Column(name = "Luong")
    private Integer Luong;

    @ManyToOne
    @JoinColumn(name = "Ma_Phong")
    private phongban phongban;

    public nhanvien() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTen_nv() {
        return ten_nv;
    }

    public void setTen_nv(String ten_nv) {
        this.ten_nv = ten_nv;
    }

    public String getPhai() {
        return phai;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public String getNoisinh() {
        return noisinh;
    }

    public void setNoisinh(String noisinh) {
        this.noisinh = noisinh;
    }

    public Integer getLuong() {
        return Luong;
    }

    public void setLuong(Integer luong) {
        Luong = luong;
    }

    public com.example.truonganhtuan.entity.phongban getPhongban() {
        return phongban;
    }

    public void setPhongban(com.example.truonganhtuan.entity.phongban phongban) {
        this.phongban = phongban;
    }
}

