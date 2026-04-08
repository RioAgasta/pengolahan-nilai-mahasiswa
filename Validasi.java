/**
 * MODUL VALIDASI DATA
 * Modul terisolasi untuk memvalidasi input nilai mahasiswa.
 * Input  : nilai_tugas, nilai_uts, nilai_uas
 * Output : boolean (true = valid, false = tidak valid)
 */
public class Validasi {

    /**
     * Memvalidasi nilai berdasarkan aturan:
     * 1. Semua nilai harus antara 0–100
     * 2. Jika ada nilai < 0 atau > 100 → tidak valid
     * 3. Jika semua nilai = 0 → tidak valid (dianggap belum diinput)
     */
    public static boolean validasiNilai(double tugas, double uts, double uas) {
        // Aturan 2: cek rentang 0–100
        if (tugas < 0 || tugas > 100) return false;
        if (uts   < 0 || uts   > 100) return false;
        if (uas   < 0 || uas   > 100) return false;

        // Aturan 3: semua nol dianggap belum diinput
        if (tugas == 0 && uts == 0 && uas == 0) return false;

        // Aturan 1: semua dalam rentang → valid
        return true;
    }

    /** Kembalikan pesan kesalahan yang sesuai untuk ditampilkan ke user. */
    public static String pesanKesalahan(double tugas, double uts, double uas) {
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
}
