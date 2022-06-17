package com.proyek_pbo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.proyek_pbo.entity.SuratMasuk;

public interface SuratMasukRepo extends CrudRepository<SuratMasuk, Long> {

  List<SuratMasuk> findBynoSuratContains(String noSurat);
}
