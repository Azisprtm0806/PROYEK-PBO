package com.proyek_pbo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyek_pbo.entity.SuratKeluar;
import com.proyek_pbo.repository.SuratKeluarRepo;

@Service
@Transactional
public class SuratKeluarServices {

  @Autowired
  private SuratKeluarRepo suratKeluarRepo;

  // add surat keluar
  public void addSuratKeluar(SuratKeluar suratKeluar) {
    suratKeluarRepo.save(suratKeluar);
  }

  // find all surat keluar
  public Iterable<SuratKeluar> findAll() {
    return suratKeluarRepo.findAll();
  }

  // delete by id
  public void deleteById(Long id) {
    suratKeluarRepo.deleteById(id);
  }

  // page edit surat keluar
  public Optional<SuratKeluar> findByID(long id) {
    return suratKeluarRepo.findById(id);
  }

  // service action edit
  public void updateKeluar(SuratKeluar suratKeluar) {
    suratKeluarRepo.save(suratKeluar);
  }

  // search
  public List<SuratKeluar> findBynoSurat(String keyword) {
    return suratKeluarRepo.findBynoSuratContains(keyword);
  }
}
