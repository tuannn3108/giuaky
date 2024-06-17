package com.example.truonganhtuan.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "phongban")
public class phongban {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String Id;
    @Column(name = "ten_phong")
    private String ten_phong;

    @OneToMany(mappedBy = "phongban",cascade = CascadeType.ALL)
    private List<nhanvien> nhanviens;

    public List<nhanvien> getNhanviens() {
        return nhanviens;
    }

    public void setNhanviens(List<nhanvien> nhanviens) {
        this.nhanviens = nhanviens;
    }

    public String getTen_phong() {
        return ten_phong;
    }

    public void setTen_phong(String ten_phong) {
        this.ten_phong = ten_phong;
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public phongban() {

    }
}
