package pengolahannilai;

import java.util.Scanner;

public class PemrosesNilai {

    private Scanner sc;

    public PemrosesNilai(Scanner sc) {
        this.sc = sc;
    }

    public String proses() {
        InputData inputData = new InputData(sc);
        Mahasiswa mhs = inputData.inputNilai();

        double tugas = mhs.getNilaiTugas();
        double uts   = mhs.getNilaiUts();
        double uas   = mhs.getNilaiUas();

        PenghitungNilai penghitung = new PenghitungNilai(tugas, uts, uas);
        double nilaiAkhir = penghitung.hitungNilaiAkhir();

        if (nilaiAkhir == -1) {
            return "  [ERROR] Terjadi kesalahan saat menghitung nilai akhir.";
        }

        String grade  = penghitung.menentukanGrade(nilaiAkhir);
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
        sb.append(String.format("  %-20s : %s%n",   "Nama",        nama));
        sb.append(garis).append("\n");
        sb.append(String.format("  %-20s : %.2f%n", "Nilai Tugas", tugas));
        sb.append(String.format("  %-20s : %.2f%n", "Nilai UTS",   uts));
        sb.append(String.format("  %-20s : %.2f%n", "Nilai UAS",   uas));
        sb.append(garis).append("\n");
        sb.append(String.format("  %-20s : %.2f%n", "Nilai Akhir", nilaiAkhir));
        sb.append(String.format("  %-20s : %s%n",   "Grade",       grade));
        sb.append(String.format("  %-20s : %s%n",   "Status",      status));
        sb.append(garis).append("\n");
        return sb.toString();
    }
}
