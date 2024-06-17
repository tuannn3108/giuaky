package com.example.truonganhtuan.services;

import com.example.truonganhtuan.entity.nhanvien;
import com.example.truonganhtuan.repository.INhanvienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class nhanvienService {

    @Autowired
    private INhanvienRepository nhanvienRepository;
    public List<nhanvien> getAllnhanvien(){
        List<nhanvien> nhanvienList = nhanvienRepository.findAll();
        return nhanvienList;
    }


    public void updateBook(nhanvien nhanviens){
        nhanvienRepository.save(nhanviens);

    }
    public List<nhanvien> getAllnhanviens(Integer pageNo,
                                        Integer pageSize,
                                        String sortBy) {

        return nhanvienRepository.findAllBooks(pageNo, pageSize, sortBy);
    }
    public void deletenhanvien(Long id){
        nhanvienRepository.deleteById(id);
    }
    public void Addproduct(nhanvien products ){

        nhanvienRepository.save(products);

    }
}
