import java.util.Scanner;

/**
 * MODUL UTAMA PEMROSESAN PENGOLAHAN NILAI
 * Modul ini mengorkestrasikan seluruh modul (InputData → Validasi → Komputasi)
 * dan mengembalikan hasil akhir ke Main sebagai interface aplikasi.
 *
 * Alur:
 *   1. InputData  → terima input (sudah tervalidasi di dalamnya)
 *   2. Komputasi  → hitung nilai akhir, grade, status
 *   3. Kembalikan hasil ke Main untuk ditampilkan
 */
public class ProsesNilai {

    /**
     * Menjalankan satu siklus penuh pengolahan nilai satu mahasiswa.
     *
     * @param sc  Scanner bersama
     * @return    String laporan hasil yang siap ditampilkan ke layar
     */
    public static String proses(Scanner sc) {
        // ── 1. INPUT DATA (validasi sudah di dalam modul InputData) ──
        Object[] data = InputData.inputNilai(sc);

        String nama  = (String) data[0];
        double tugas = (double) data[1];
        double uts   = (double) data[2];
        double uas   = (double) data[3];

        // ── 2. KOMPUTASI ──
        double nilaiAkhir = Komputasi.hitungNilaiAkhir(tugas, uts, uas);

        if (nilaiAkhir == -1) {
            return "  [ERROR] Terjadi kesalahan saat menghitung nilai akhir.";
        }

        String grade   = Komputasi.menentukanGrade(nilaiAkhir);
        String status  = Komputasi.menentukanKelulusan(nilaiAkhir);

        // ── 3. SUSUN LAPORAN & KEMBALIKAN KE MAIN ──
        return buildLaporan(nama, tugas, uts, uas, nilaiAkhir, grade, status);
    }

    /** Menyusun teks laporan hasil pengolahan nilai. */
    private static String buildLaporan(String nama,
                                        double tugas, double uts, double uas,
                                        double nilaiAkhir, String grade, String status) {
        String garis = "  " + "=".repeat(46);
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append(garis).append("\n");
        sb.append("        HASIL PENGOLAHAN NILAI MAHASISWA\n");
        sb.append(garis).append("\n");
        sb.append(String.format("  %-20s : %s%n",        "Nama",         nama));
        sb.append(garis).append("\n");
        sb.append(String.format("  %-20s : %.2f%n",      "Nilai Tugas",  tugas));
        sb.append(String.format("  %-20s : %.2f%n",      "Nilai UTS",    uts));
        sb.append(String.format("  %-20s : %.2f%n",      "Nilai UAS",    uas));
        sb.append(garis).append("\n");
        sb.append(String.format("  %-20s : %.2f%n",      "Nilai Akhir",  nilaiAkhir));
        sb.append(String.format("  %-20s : %s%n",        "Grade",        grade));
        sb.append(String.format("  %-20s : %s%n",        "Status",       status));
        sb.append(garis).append("\n");
        return sb.toString();
    }
}
