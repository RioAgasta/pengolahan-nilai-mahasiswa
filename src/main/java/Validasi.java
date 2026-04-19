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
     *
     * CFG validasiNilai:
     *   Node 1  → START / masuk method
     *   Node 2  → if (tugas < 0 || tugas > 100)
     *   Node 3  →   [true]  return false
     *   Node 4  → if (uts < 0 || uts > 100)
     *   Node 5  →   [true]  return false
     *   Node 6  → if (uas < 0 || uas > 100)
     *   Node 7  →   [true]  return false
     *   Node 8  → if (tugas == 0 && uts == 0 && uas == 0)
     *   Node 9  →   [true]  return false
     *   Node 10 → [false] return true  (END)
     */
    public static boolean validasiNilai(double tugas, double uts, double uas) {
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

    /**
     * Kembalikan pesan kesalahan yang sesuai untuk ditampilkan ke user.
     *
     * CFG pesanKesalahan:
     *   Node 1  → START / masuk method
     *   Node 2  → if (tugas < 0 || tugas > 100)
     *   Node 3  →   [true]  return pesan tugas
     *   Node 4  → if (uts < 0 || uts > 100)
     *   Node 5  →   [true]  return pesan uts
     *   Node 6  → if (uas < 0 || uas > 100)
     *   Node 7  →   [true]  return pesan uas
     *   Node 8  → if (tugas == 0 && uts == 0 && uas == 0)
     *   Node 9  →   [true]  return pesan semua nol
     *   Node 10 → [false] return pesan default  (END)
     */
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
