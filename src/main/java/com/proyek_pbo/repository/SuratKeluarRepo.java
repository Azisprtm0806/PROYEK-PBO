package com.proyek_pbo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyek_pbo.entity.SuratKeluar;

public interface SuratKeluarRepo extends CrudRepository<SuratKeluar, Long> {
  List<SuratKeluar> findBynoSuratContains(String noSurat);
}
