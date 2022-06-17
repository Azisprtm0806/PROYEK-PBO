package com.proyek_pbo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_suratMasuk")
public class SuratMasuk {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 100)
  private String noSurat;

  @Column(length = 200)
  private String asalSurat;

  @Column(length = 50)
  private Date tanggal;

  @Column(length = 200)
  private String prihal;

  @Column(length = 500)
  private String deskripsi;

  public SuratMasuk() {
  }

  public SuratMasuk(Long id, String noSurat, String asalSurat, Date tanggal, String prihal, String deskripsi) {
    this.id = id;
    this.noSurat = noSurat;
    this.asalSurat = asalSurat;
    this.tanggal = tanggal;
    this.prihal = prihal;
    this.deskripsi = deskripsi;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNoSurat() {
    return noSurat;
  }

  public void setNoSurat(String noSurat) {
    this.noSurat = noSurat;
  }

  public String getAsalSurat() {
    return asalSurat;
  }

  public void setAsalSurat(String asalSurat) {
    this.asalSurat = asalSurat;
  }

  public Date getTanggal() {
    return tanggal;
  }

  public void setTanggal(Date tanggal) {
    this.tanggal = tanggal;
  }

  public String getPrihal() {
    return prihal;
  }

  public void setPrihal(String prihal) {
    this.prihal = prihal;
  }

  public String getDeskripsi() {
    return deskripsi;
  }

  public void setDeskripsi(String deskripsi) {
    this.deskripsi = deskripsi;
  }

}
