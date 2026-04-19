/**
 * MODUL KOMPUTASI
 * Modul terisolasi untuk menghitung nilai akhir, grade, dan status kelulusan.
 * Setiap metode berdiri sendiri (modular & terisolasi).
 */
public class Komputasi {

    // ---------------------------------------------------------------
    // MODUL PERHITUNGAN NILAI AKHIR
    // Input  : nilai_tugas (30%), nilai_uts (30%), nilai_uas (40%)
    // Output : nilai_akhir (double), atau -1 jika error
    // ---------------------------------------------------------------
    public static double hitungNilaiAkhir(double tugas, double uts, double uas) {
        // Jika tidak valid → return error sentinel
        if (!Validasi.validasiNilai(tugas, uts, uas)) return -1;

        double nilaiAkhir = (0.3 * tugas) + (0.3 * uts) + (0.4 * uas);

        // Nilai akhir tidak boleh melebihi 100
        if (nilaiAkhir > 100) return -1;

        return nilaiAkhir;
    }

    // ---------------------------------------------------------------
    // MODUL PENENTUAN GRADE
    // Input  : nilai_akhir
    // Output : grade (A / B / C / D / E)
    // ---------------------------------------------------------------
    public static String menentukanGrade(double nilaiAkhir) {
        if (nilaiAkhir >= 85)              return "A";
        else if (nilaiAkhir >= 70)         return "B";
        else if (nilaiAkhir >= 60)         return "C";
        else if (nilaiAkhir >= 50)         return "D";
        else                               return "E";
    }

    // ---------------------------------------------------------------
    // MODUL PENENTUAN KELULUSAN
    // Input  : nilai_akhir
    // Output : status kelulusan (Lulus / Tidak Lulus)
    // ---------------------------------------------------------------
    public static String menentukanKelulusan(double nilaiAkhir) {
        if (nilaiAkhir >= 60) return "LULUS";
        else                  return "TIDAK LULUS";
    }
}
