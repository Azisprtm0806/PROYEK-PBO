package com.proyek_pbo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyek_pbo.entity.SuratMasuk;
import com.proyek_pbo.repository.SuratMasukRepo;

@Service
@Transactional
public class SuratMasukService {

  @Autowired
  private SuratMasukRepo suratMasukRepo;

  // add surat Masuk
  public void addSuratMasuk(SuratMasuk suratMasuk) {
    suratMasukRepo.save(suratMasuk);
  }

  // find all
  public Iterable<SuratMasuk> findAll() {
    return suratMasukRepo.findAll();
  }

  // delete by id
  public void deleteById(Long id) {
    suratMasukRepo.deleteById(id);
  }

  // page edit surat masuk
  public Optional<SuratMasuk> findByID(long id) {
    return suratMasukRepo.findById(id);
  }

  // service action edit
  public void updateMasuk(SuratMasuk suratMasuk) {
    suratMasukRepo.save(suratMasuk);
  }

  // search
  public List<SuratMasuk> findBynoSurat(String keyword) {
    return suratMasukRepo.findBynoSuratContains(keyword);
  }
}
