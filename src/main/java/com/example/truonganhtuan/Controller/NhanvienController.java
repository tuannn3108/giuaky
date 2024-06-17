package com.example.truonganhtuan.Controller;


import com.example.truonganhtuan.entity.nhanvien;
import com.example.truonganhtuan.entity.phongban;
import com.example.truonganhtuan.services.nhanvienService;
import com.example.truonganhtuan.services.phongbanService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
//@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/nhanvien")
public class NhanvienController {
    @Autowired
    private nhanvienService nhanvienServices;
    @Autowired
    private phongbanService phongbanServices;
    @GetMapping()
    public String showAllBooks(
            @NotNull Model model,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        model.addAttribute("nhanviens", nhanvienServices.getAllnhanviens(pageNo,
                pageSize, sortBy));
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("phongbans",
                phongbanServices.getAllphongban());
        int totalProducts = nhanvienServices.getAllnhanviens(pageNo, pageSize, sortBy).size();
        int totalPages = (int) Math.ceil((double) totalProducts / pageSize);

        model.addAttribute("totalPages", totalPages);
        return "Admin/Product";
    }



    @GetMapping("/add")
    public String addproductForm(Model model){
        model.addAttribute("nhanviens",new nhanvien());
        model.addAttribute("phongbans",phongbanServices.getAllphongban());
        return "Admin/add";
    }

    @PostMapping("/add")

    public String addproduct(@ModelAttribute("nhanviens") nhanvien products){
        nhanvienServices.Addproduct(products);
        return "redirect:/nhanvien";

    }
    @GetMapping("/delete/{id}")
    public String deleteproduct(@PathVariable("id")  Long id){

        nhanvienServices.deletenhanvien(id);
        return "redirect:/admin/product";
    }
//    @GetMapping("/edit/{id}")
//    public String editproductForm(@PathVariable("id") Long id, Model model) {
//        nhanvien product = nhanvienServices.getproductId(id);
//        model.addAttribute("categories", categoryService.getAllcategory());
//
//
//        model.addAttribute("product", product);
//        return "Admin/edit";
//    }
//    @PostMapping("/edit/{id}")
//    public String editproduct(@PathVariable("id") Long id, @ModelAttribute("product") product product ,@RequestParam("file") MultipartFile file) {
//        product product1 = productsService.getproductId(id);
//
//        product1.setTitle(product.getTitle());
//        product1.setDescription(product.getDescription());
//        product1.setQuantity(product.getQuantity());
//        product1.setPrice(product.getPrice());
//
//        product1.setCategory(product.getCategory());
//
//
//        productsService.Addproduct(product1 ,file);
//        return "redirect:/admin/product";
//    }


}