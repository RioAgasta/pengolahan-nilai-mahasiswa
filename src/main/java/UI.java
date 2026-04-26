

import java.util.Scanner;

// import src.main.java.pengolahannilai.ValidatorNilai;

public class UI {

  private Scanner sc;

  public UI(Scanner sc) {
    this.sc = sc;
  }

  public Mahasiswa inputNilai() {
    System.out.print("  Nama Mahasiswa : ");
    String nama = sc.nextLine().trim();
    if (nama.isEmpty())
      nama = "Tidak Diketahui";

    double tugas, uts, uas;

    while (true) {
      tugas = bacaNilai("Nilai Tugas (0-100)");
      uts = bacaNilai("Nilai UTS   (0-100)");
      uas = bacaNilai("Nilai UAS   (0-100)");

      // ValidatorNilai validator = new ValidatorNilai(tugas, uts, uas);

      if (validasiNilai(tugas, uts, uas)) {
        break;
      } else {
        System.out.println();
        System.out.println(pesanKesalahan(tugas, uts, uas));
        System.out.println("  Silakan masukkan nilai kembali.\n");
      }
    }

    return new Mahasiswa(nama, tugas, uts, uas);
  }

  private double bacaNilai(String label) {
    double nilai = 0;
    boolean berhasil = false;
    while (!berhasil) {
      System.out.print("  " + label + " : ");
      try {
        nilai = Double.parseDouble(sc.nextLine().trim());
        berhasil = true;
      } catch (NumberFormatException e) {
        System.out.println("  [!] Input tidak valid. Harap masukkan angka.");
      }
    }
    return nilai;
  }

  public boolean validasiNilai(double tugas, double uts, double uas) {
    if (tugas < 0 || tugas > 100)
      return false;
    if (uts < 0 || uts > 100)
      return false;
    if (uas < 0 || uas > 100)
      return false;
    if (tugas == 0 && uts == 0 && uas == 0)
      return false;
    return true;
  }

  public String pesanKesalahan(double tugas, double uts, double uas) {
    if (tugas < 0 || tugas > 100)
      return "  [!] Nilai Tugas (" + tugas + ") harus berada di antara 0 dan 100.";
    if (uts < 0 || uts > 100)
      return "  [!] Nilai UTS (" + uts + ") harus berada di antara 0 dan 100.";
    if (uas < 0 || uas > 100)
      return "  [!] Nilai UAS (" + uas + ") harus berada di antara 0 dan 100.";
    if (tugas == 0 && uts == 0 && uas == 0)
      return "  [!] Semua nilai tidak boleh 0 (dianggap belum diinput).";
    return "  [!] Input tidak valid.";
  }

  public void tampilkanHeader() {
    System.out.println("\n  ================================================");
    System.out.println("     SISTEM PENGOLAHAN NILAI MAHASISWA  v1.0");
    System.out.println("  ================================================");
    System.out.println("  Formula Nilai Akhir:");
    System.out.println("    (30% x Tugas) + (30% x UTS) + (40% x UAS)");
    System.out.println("  ================================================\n");
  }

  public void tampilkanMenu() {
    System.out.println("  +-----------------------------+");
    System.out.println("  |        MENU UTAMA           |");
    System.out.println("  +--------------+--------------+");
    System.out.println("  |  1. Input Nilai Mahasiswa   |");
    System.out.println("  |  2. Keluar                  |");
    System.out.println("  +-----------------------------+");
  }
}
