package com.example.truonganhtuan.repository;

import com.example.truonganhtuan.entity.phongban;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface IPhongbanRepository extends
        JpaRepository<phongban, Long> {

}