package com.example.truonganhtuan.services;

import com.example.truonganhtuan.entity.nhanvien;
import com.example.truonganhtuan.entity.phongban;
import com.example.truonganhtuan.repository.INhanvienRepository;
import com.example.truonganhtuan.repository.IPhongbanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class phongbanService {

    @Autowired
    private IPhongbanRepository nhanvienRepository;
    public List<phongban> getAllphongban(){
        List<phongban> nhanvienList = nhanvienRepository.findAll();
        return nhanvienList;
    }


    public void updateBook(phongban nhanviens){
        nhanvienRepository.save(nhanviens);

    }

    public void deletenhanvien(Long id){
        nhanvienRepository.deleteById(id);
    }
    public void Addproduct(phongban products ){

        nhanvienRepository.save(products);

    }
}