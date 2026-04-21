package src.main.java;

import java.util.Scanner;

public class Main {

  private Scanner sc;
  private UI ui;
  private boolean lanjut;

  public Main() {
    this.sc = new Scanner(System.in);
    this.ui = new UI(sc);
    this.lanjut = true;
  }

  public static void main(String[] args) {
    Main app = new Main();
    app.start();
  }

  public void start() {
    ui.tampilkanHeader();

    while (lanjut) {
      ui.tampilkanMenu();

      System.out.print("  Pilih menu [1/2] : ");
      String pilihan = sc.nextLine().trim();

      switch (pilihan) {
        case "1":
          // PemrosesNilai pemroses = new PemrosesNilai(sc);
          String hasil = proses();
          System.out.println(hasil);
          break;

        case "2":
          System.out.println("\n  Terima kasih telah menggunakan sistem ini. Sampai jumpa!\n");
          lanjut = false;
          break;

        default:
          System.out.println("  [!] Pilihan tidak dikenali. Masukkan 1 atau 2.\n");
      }
    }

    sc.close();
  }

  private String proses() {
    // InputData inputData = new InputData(sc);
    Mahasiswa mhs = ui.inputNilai();

    double tugas = mhs.getNilaiTugas();
    double uts = mhs.getNilaiUts();
    double uas = mhs.getNilaiUas();

    PenghitungNilai penghitung = new PenghitungNilai();
    double nilaiAkhir = penghitung.hitungNilaiAkhir(tugas, uts, uas);

    if (nilaiAkhir == -1) {
      return "  [ERROR] Terjadi kesalahan saat menghitung nilai akhir.";
    }

    String grade = penghitung.menentukanGrade(nilaiAkhir);
    String status = penghitung.menentukanKelulusan(nilaiAkhir);

    return buildLaporan(mhs.getNama(), tugas, uts, uas, nilaiAkhir, grade, status);
  }

  private String buildLaporan(String nama,
      double tugas, double uts, double uas,
      double nilaiAkhir, String grade, String status) {
    String garis = "  " + "=".repeat(46);
    StringBuilder sb = new StringBuilder();
    sb.append("\n").append(garis).append("\n");
    sb.append("        HASIL PENGOLAHAN NILAI MAHASISWA\n");
    sb.append(garis).append("\n");
    sb.append(String.format("  %-20s : %s%n", "Nama", nama));
    sb.append(garis).append("\n");
    sb.append(String.format("  %-20s : %.2f%n", "Nilai Tugas", tugas));
    sb.append(String.format("  %-20s : %.2f%n", "Nilai UTS", uts));
    sb.append(String.format("  %-20s : %.2f%n", "Nilai UAS", uas));
    sb.append(garis).append("\n");
    sb.append(String.format("  %-20s : %.2f%n", "Nilai Akhir", nilaiAkhir));
    sb.append(String.format("  %-20s : %s%n", "Grade", grade));
    sb.append(String.format("  %-20s : %s%n", "Status", status));
    sb.append(garis).append("\n");
    return sb.toString();
  }
}
