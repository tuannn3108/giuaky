package com.example.truonganhtuan.repository;

import com.example.truonganhtuan.entity.nhanvien;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface INhanvienRepository extends
        JpaRepository<nhanvien, Long> {
    default List<nhanvien> findAllBooks(Integer pageNo,
                                       Integer pageSize,
                                       String sortBy) {
        return findAll(PageRequest.of(pageNo,
                pageSize,
                Sort.by(sortBy)))
                .getContent();
    }
}
