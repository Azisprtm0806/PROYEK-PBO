package com.proyek_pbo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyek_pbo.dto.SearchFormData;
import com.proyek_pbo.entity.SuratMasuk;
import com.proyek_pbo.service.SuratMasukService;

@Controller
@RequestMapping("")
public class MasukController {

  @Autowired
  private SuratMasukService suratMasukService;

  // ======= SURAT MASUK ========
  @GetMapping
  public String welcome(Model model) {
    model.addAttribute("SearchForm", new SearchFormData());
    model.addAttribute("SuratMasuk", suratMasukService.findAll());
    return "index-surat";
  }

  @GetMapping("/addMasuk")
  public String addMasuk(Model model) {
    model.addAttribute("SuratMasuk", new SuratMasuk());
    return "addMasuk";
  }

  @PostMapping("/saveMasuk")
  public String saveMasuk(SuratMasuk suratMasuk, Model model) {
    suratMasukService.addSuratMasuk(suratMasuk);
    return "redirect:/";
  }

  @GetMapping("/deleteMasuk/{id}")
  public String deleteMasuk(@PathVariable("id") Long id) {
    suratMasukService.deleteById(id);
    return "redirect:/";
  }

  @GetMapping("/editMasuk/{id}")
  public String editMasuk(@PathVariable("id") Long id, Model model) {
    model.addAttribute("SuratMasuk", suratMasukService.findByID(id));
    return "editMasuk";
  }

  // action edit
  @PostMapping("/updateMasuk")
  public String update(SuratMasuk suratMasuk) {
    // call services update
    suratMasukService.updateMasuk(suratMasuk);
    return "redirect:/";
  }

  // Search
  @PostMapping("/search")
  public String searchMasuk(SearchFormData searchFormData, Model model) {
    model.addAttribute("SearchForm", searchFormData);
    model.addAttribute("SuratMasuk", suratMasukService.findBynoSurat(searchFormData.getKeyword()));
    return "index-surat";
  }

}
