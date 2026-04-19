/**
 * ============================================================
 *  Unit Test untuk class   : Validasi
 *  Metode pengujian         : White Box Testing – Path Testing
 *  Cyclomatic Complexity    : V(G) = 5  (per method)
 *  Jumlah independent path  : 5
 *
 *  CFG – validasiNilai() :
 *    P1 : 1-2-4-6-8-10-11  → semua nilai valid (bukan 0 semua)  → true
 *    P2 : 1-2-3-11          → tugas < 0 atau tugas > 100         → false
 *    P3 : 1-2-4-5-11        → uts  < 0 atau uts  > 100          → false
 *    P4 : 1-2-4-6-7-11      → uas  < 0 atau uas  > 100          → false
 *    P5 : 1-2-4-6-8-9-11    → semua nilai = 0                   → false
 *
 *  CFG – pesanKesalahan() :
 *    P1 : 1-2-4-6-8-10      → nilai valid  → "[!] Input tidak valid."
 *    P2 : 1-2-3             → tugas tidak valid → pesan tugas
 *    P3 : 1-2-4-5           → uts  tidak valid  → pesan uts
 *    P4 : 1-2-4-6-7         → uas  tidak valid  → pesan uas
 *    P5 : 1-2-4-6-8-9       → semua = 0        → pesan semua nol
 * ============================================================
 */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Validasi - White Box Testing (Path Testing, V(G) = 5)")
class ValidasiTest {

    // ================================================================
    //  NESTED CLASS 1 : Pengujian method validasiNilai()
    // ================================================================
    @Nested
    @DisplayName("validasiNilai() - 10 Test Case (5 Jalur x 2 Varian)")
    class ValidasiNilaiTest {

        // ---------------- PATH P1 : 1-2-4-6-8-10-11 ----------------
        // Semua nilai berada antara 0‒100 dan tidak semuanya 0 → true

        @Test
        @DisplayName("TC1 | Path P1 (1-2-4-6-8-10-11) | Nilai umum valid: tugas=75, uts=80, uas=85")
        void tc1_pathP1_nilaiUmumValid() {
            // TC1 | Path P1 | tugas=75, uts=80, uas=85 → true
            assertTrue(Validasi.validasiNilai(75, 80, 85));
        }

        @Test
        @DisplayName("TC2 | Path P1 (1-2-4-6-8-10-11) | Nilai batas atas valid: tugas=100, uts=100, uas=100")
        void tc2_pathP1_nIlaiBatasAtasValid() {
            // TC2 | Path P1 | tugas=100, uts=100, uas=100 → true
            assertTrue(Validasi.validasiNilai(100, 100, 100));
        }

        @Test
        @DisplayName("TC3 | Path P1 (1-2-4-6-8-10-11) | Nilai batas bawah valid: tugas=1, uts=1, uas=1")
        void tc3_pathP1_nilaiBatasBawahValid() {
            // TC3 | Path P1 | tugas=1, uts=1, uas=1 → true
            assertTrue(Validasi.validasiNilai(1, 1, 1));
        }

        // ---------------- PATH P2 : 1-2-3-11 ----------------
        // tugas < 0 atau tugas > 100 → langsung return false

        @Test
        @DisplayName("TC4 | Path P2 (1-2-3-11) | Tugas negatif: tugas=-1, uts=80, uas=85")
        void tc4_pathP2_tugasNegatif() {
            // TC4 | Path P2 | tugas=-1, uts=80, uas=85 → false
            assertFalse(Validasi.validasiNilai(-1, 80, 85));
        }

        @Test
        @DisplayName("TC5 | Path P2 (1-2-3-11) | Tugas melebihi 100: tugas=101, uts=80, uas=85")
        void tc5_pathP2_tugasLebihDari100() {
            // TC5 | Path P2 | tugas=101, uts=80, uas=85 → false
            assertFalse(Validasi.validasiNilai(101, 80, 85));
        }

        // ---------------- PATH P3 : 1-2-4-5-11 ----------------
        // tugas valid, uts < 0 atau uts > 100 → return false

        @Test
        @DisplayName("TC6 | Path P3 (1-2-4-5-11) | UTS negatif: tugas=75, uts=-1, uas=85")
        void tc6_pathP3_utsNegatif() {
            // TC6 | Path P3 | tugas=75, uts=-1, uas=85 → false
            assertFalse(Validasi.validasiNilai(75, -1, 85));
        }

        @Test
        @DisplayName("TC7 | Path P3 (1-2-4-5-11) | UTS melebihi 100: tugas=75, uts=101, uas=85")
        void tc7_pathP3_utsLebihDari100() {
            // TC7 | Path P3 | tugas=75, uts=101, uas=85 → false
            assertFalse(Validasi.validasiNilai(75, 101, 85));
        }

        // ---------------- PATH P4 : 1-2-4-6-7-11 ----------------
        // tugas & uts valid, uas < 0 atau uas > 100 → return false

        @Test
        @DisplayName("TC8 | Path P4 (1-2-4-6-7-11) | UAS negatif: tugas=75, uts=80, uas=-1")
        void tc8_pathP4_uasNegatif() {
            // TC8 | Path P4 | tugas=75, uts=80, uas=-1 → false
            assertFalse(Validasi.validasiNilai(75, 80, -1));
        }

        @Test
        @DisplayName("TC9 | Path P4 (1-2-4-6-7-11) | UAS melebihi 100: tugas=75, uts=80, uas=101")
        void tc9_pathP4_uasLebihDari100() {
            // TC9 | Path P4 | tugas=75, uts=80, uas=101 → false
            assertFalse(Validasi.validasiNilai(75, 80, 101));
        }

        // ---------------- PATH P5 : 1-2-4-6-8-9-11 ----------------
        // Semua nilai = 0 → dianggap belum diinput → return false

        @Test
        @DisplayName("TC10 | Path P5 (1-2-4-6-8-9-11) | Semua nilai nol: tugas=0, uts=0, uas=0")
        void tc10_pathP5_semuaNilaiNol() {
            // TC10 | Path P5 | tugas=0, uts=0, uas=0 → false
            assertFalse(Validasi.validasiNilai(0, 0, 0));
        }
    }

    // ================================================================
    //  NESTED CLASS 2 : Pengujian method pesanKesalahan()
    // ================================================================
    @Nested
    @DisplayName("pesanKesalahan() - 10 Test Case (5 Jalur x 2 Varian)")
    class PesanKesalahanTest {

        // ---------------- PATH P1 ----------------
        // Semua nilai valid (bukan 0 semua) → pesan default

        @Test
        @DisplayName("TC1 | Path P1 | Nilai umum valid: tugas=75, uts=80, uas=85")
        void tc1_pathP1_nilaiUmumValid() {
            // TC1 | Path P1 | tugas=75, uts=80, uas=85 → "[!] Input tidak valid."
            String expected = "  [!] Input tidak valid.";
            assertEquals(expected, Validasi.pesanKesalahan(75, 80, 85));
        }

        @Test
        @DisplayName("TC2 | Path P1 | Nilai batas atas valid: tugas=100, uts=100, uas=100")
        void tc2_pathP1_nilaiBatasAtasValid() {
            // TC2 | Path P1 | tugas=100, uts=100, uas=100 → "[!] Input tidak valid."
            String expected = "  [!] Input tidak valid.";
            assertEquals(expected, Validasi.pesanKesalahan(100, 100, 100));
        }

        @Test
        @DisplayName("TC3 | Path P1 | Nilai batas bawah valid: tugas=1, uts=1, uas=1")
        void tc3_pathP1_nilaiBatasBawahValid() {
            // TC3 | Path P1 | tugas=1, uts=1, uas=1 → "[!] Input tidak valid."
            String expected = "  [!] Input tidak valid.";
            assertEquals(expected, Validasi.pesanKesalahan(1, 1, 1));
        }

        // ---------------- PATH P2 ----------------
        // tugas tidak valid → pesan error tugas

        @Test
        @DisplayName("TC4 | Path P2 | Tugas negatif: tugas=-1, uts=80, uas=85")
        void tc4_pathP2_tugasNegatif() {
            // TC4 | Path P2 | tugas=-1, uts=80, uas=85 → pesan Nilai Tugas (-1.0)
            String expected = "  [!] Nilai Tugas (-1.0) harus berada di antara 0 dan 100.";
            assertEquals(expected, Validasi.pesanKesalahan(-1, 80, 85));
        }

        @Test
        @DisplayName("TC5 | Path P2 | Tugas melebihi 100: tugas=101, uts=80, uas=85")
        void tc5_pathP2_tugasLebihDari100() {
            // TC5 | Path P2 | tugas=101, uts=80, uas=85 → pesan Nilai Tugas (101.0)
            String expected = "  [!] Nilai Tugas (101.0) harus berada di antara 0 dan 100.";
            assertEquals(expected, Validasi.pesanKesalahan(101, 80, 85));
        }

        // ---------------- PATH P3 ----------------
        // uts tidak valid → pesan error uts

        @Test
        @DisplayName("TC6 | Path P3 | UTS negatif: tugas=75, uts=-1, uas=85")
        void tc6_pathP3_utsNegatif() {
            // TC6 | Path P3 | tugas=75, uts=-1, uas=85 → pesan Nilai UTS (-1.0)
            String expected = "  [!] Nilai UTS (-1.0) harus berada di antara 0 dan 100.";
            assertEquals(expected, Validasi.pesanKesalahan(75, -1, 85));
        }

        @Test
        @DisplayName("TC7 | Path P3 | UTS melebihi 100: tugas=75, uts=101, uas=85")
        void tc7_pathP3_utsLebihDari100() {
            // TC7 | Path P3 | tugas=75, uts=101, uas=85 → pesan Nilai UTS (101.0)
            String expected = "  [!] Nilai UTS (101.0) harus berada di antara 0 dan 100.";
            assertEquals(expected, Validasi.pesanKesalahan(75, 101, 85));
        }

        // ---------------- PATH P4 ----------------
        // uas tidak valid → pesan error uas

        @Test
        @DisplayName("TC8 | Path P4 | UAS negatif: tugas=75, uts=80, uas=-1")
        void tc8_pathP4_uasNegatif() {
            // TC8 | Path P4 | tugas=75, uts=80, uas=-1 → pesan Nilai UAS (-1.0)
            String expected = "  [!] Nilai UAS (-1.0) harus berada di antara 0 dan 100.";
            assertEquals(expected, Validasi.pesanKesalahan(75, 80, -1));
        }

        @Test
        @DisplayName("TC9 | Path P4 | UAS melebihi 100: tugas=75, uts=80, uas=101")
        void tc9_pathP4_uasLebihDari100() {
            // TC9 | Path P4 | tugas=75, uts=80, uas=101 → pesan Nilai UAS (101.0)
            String expected = "  [!] Nilai UAS (101.0) harus berada di antara 0 dan 100.";
            assertEquals(expected, Validasi.pesanKesalahan(75, 80, 101));
        }

        // ---------------- PATH P5 ----------------
        // Semua nilai = 0 → pesan semua nol

        @Test
        @DisplayName("TC10 | Path P5 | Semua nilai nol: tugas=0, uts=0, uas=0")
        void tc10_pathP5_semuaNilaiNol() {
            // TC10 | Path P5 | tugas=0, uts=0, uas=0 → pesan semua nilai tidak boleh 0
            String expected = "  [!] Semua nilai tidak boleh 0 (dianggap belum diinput).";
            assertEquals(expected, Validasi.pesanKesalahan(0, 0, 0));
        }
    }
}
