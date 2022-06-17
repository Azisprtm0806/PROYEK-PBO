package com.proyek_pbo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.proyek_pbo.dto.SearchFormKeluar;
import com.proyek_pbo.entity.SuratKeluar;
import com.proyek_pbo.service.SuratKeluarServices;

@Controller
@RequestMapping("/surat-keluar")
public class keluarController {

  @Autowired
  private SuratKeluarServices suratKeluarServices;

  // ======== SURAT KELUAR =======
  @GetMapping()
  public String suratKeluar(Model model) {
    model.addAttribute("SearchForm", new SearchFormKeluar());
    model.addAttribute("SuratKeluar", suratKeluarServices.findAll());
    return "surat-keluar";
  }

  @GetMapping("/addKeluar")
  public String addKeluar(Model model) {
    model.addAttribute("SuratKeluar", new SuratKeluar());
    return "addKeluar";
  }

  @PostMapping("/saveKeluar")
  public String saveKeluar(SuratKeluar suratKeluar) {
    suratKeluarServices.addSuratKeluar(suratKeluar);
    return "redirect:/surat-keluar";
  }

  @GetMapping("/deleteKeluar/{id}")
  public String deleteKeluar(@PathVariable("id") Long id) {
    suratKeluarServices.deleteById(id);
    return "redirect:/surat-keluar";
  }

  @GetMapping("/editKeluar/{id}")
  public String editKeluar(@PathVariable("id") Long id, Model model) {
    model.addAttribute("SuratKeluar", suratKeluarServices.findByID(id));
    return "editKeluar";
  }

  // action edit
  @PostMapping("/updateKeluar")
  public String update(SuratKeluar suratKeluar) {
    // call services update
    suratKeluarServices.updateKeluar(suratKeluar);
    return "redirect:/surat-keluar";
  }

  // Search
  @PostMapping("/search")
  public String searchKeluar(SearchFormKeluar searchFormKeluar, Model model) {
    model.addAttribute("SearchForm", searchFormKeluar);
    model.addAttribute("SuratMasuk", suratKeluarServices.findBynoSurat(searchFormKeluar.getKeywordKeluar()));
    return "index-surat";
  }
}
