package pengolahannilai;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("ValidatorNilai - White Box Path Testing V(G)=5")
class ValidatorNilaiTest {

    @Nested
    @DisplayName("validasiNilai()")
    class ValidasiNilaiTest {

        @Test
        @DisplayName("TC1 | P1 | tugas=75, uts=80, uas=85 → true")
        void tc1_pathP1_nilaiUmumValid() {
            ValidatorNilai v = new ValidatorNilai(75, 80, 85);
            assertTrue(v.validasiNilai());
        }

        @Test
        @DisplayName("TC2 | P1 | tugas=100, uts=100, uas=100 → true")
        void tc2_pathP1_nilaiBatasAtasValid() {
            ValidatorNilai v = new ValidatorNilai(100, 100, 100);
            assertTrue(v.validasiNilai());
        }

        @Test
        @DisplayName("TC3 | P1 | tugas=1, uts=1, uas=1 → true")
        void tc3_pathP1_nilaiBatasBawahValid() {
            ValidatorNilai v = new ValidatorNilai(1, 1, 1);
            assertTrue(v.validasiNilai());
        }

        @Test
        @DisplayName("TC4 | P2 | tugas=-1, uts=80, uas=85 → false")
        void tc4_pathP2_tugasNegatif() {
            ValidatorNilai v = new ValidatorNilai(-1, 80, 85);
            assertFalse(v.validasiNilai());
        }

        @Test
        @DisplayName("TC5 | P2 | tugas=101, uts=80, uas=85 → false")
        void tc5_pathP2_tugasLebihDari100() {
            ValidatorNilai v = new ValidatorNilai(101, 80, 85);
            assertFalse(v.validasiNilai());
        }

        @Test
        @DisplayName("TC6 | P3 | tugas=75, uts=-1, uas=85 → false")
        void tc6_pathP3_utsNegatif() {
            ValidatorNilai v = new ValidatorNilai(75, -1, 85);
            assertFalse(v.validasiNilai());
        }

        @Test
        @DisplayName("TC7 | P3 | tugas=75, uts=101, uas=85 → false")
        void tc7_pathP3_utsLebihDari100() {
            ValidatorNilai v = new ValidatorNilai(75, 101, 85);
            assertFalse(v.validasiNilai());
        }

        @Test
        @DisplayName("TC8 | P4 | tugas=75, uts=80, uas=-1 → false")
        void tc8_pathP4_uasNegatif() {
            ValidatorNilai v = new ValidatorNilai(75, 80, -1);
            assertFalse(v.validasiNilai());
        }

        @Test
        @DisplayName("TC9 | P4 | tugas=75, uts=80, uas=101 → false")
        void tc9_pathP4_uasLebihDari100() {
            ValidatorNilai v = new ValidatorNilai(75, 80, 101);
            assertFalse(v.validasiNilai());
        }

        @Test
        @DisplayName("TC10 | P5 | tugas=0, uts=0, uas=0 → false")
        void tc10_pathP5_semuaNilaiNol() {
            ValidatorNilai v = new ValidatorNilai(0, 0, 0);
            assertFalse(v.validasiNilai());
        }
    }

    @Nested
    @DisplayName("pesanKesalahan()")
    class PesanKesalahanTest {

        @Test
        @DisplayName("TC1 | P1 | tugas=75, uts=80, uas=85 → pesan default")
        void tc1_pathP1_nilaiUmumValid() {
            ValidatorNilai v = new ValidatorNilai(75, 80, 85);
            assertEquals("  [!] Input tidak valid.", v.pesanKesalahan());
        }

        @Test
        @DisplayName("TC2 | P1 | tugas=100, uts=100, uas=100 → pesan default")
        void tc2_pathP1_nilaiBatasAtasValid() {
            ValidatorNilai v = new ValidatorNilai(100, 100, 100);
            assertEquals("  [!] Input tidak valid.", v.pesanKesalahan());
        }

        @Test
        @DisplayName("TC3 | P1 | tugas=1, uts=1, uas=1 → pesan default")
        void tc3_pathP1_nilaiBatasBawahValid() {
            ValidatorNilai v = new ValidatorNilai(1, 1, 1);
            assertEquals("  [!] Input tidak valid.", v.pesanKesalahan());
        }

        @Test
        @DisplayName("TC4 | P2 | tugas=-1 → pesan tugas invalid")
        void tc4_pathP2_tugasNegatif() {
            ValidatorNilai v = new ValidatorNilai(-1, 80, 85);
            assertEquals("  [!] Nilai Tugas (-1.0) harus berada di antara 0 dan 100.", v.pesanKesalahan());
        }

        @Test
        @DisplayName("TC5 | P2 | tugas=101 → pesan tugas invalid")
        void tc5_pathP2_tugasLebihDari100() {
            ValidatorNilai v = new ValidatorNilai(101, 80, 85);
            assertEquals("  [!] Nilai Tugas (101.0) harus berada di antara 0 dan 100.", v.pesanKesalahan());
        }

        @Test
        @DisplayName("TC6 | P3 | uts=-1 → pesan UTS invalid")
        void tc6_pathP3_utsNegatif() {
            ValidatorNilai v = new ValidatorNilai(75, -1, 85);
            assertEquals("  [!] Nilai UTS (-1.0) harus berada di antara 0 dan 100.", v.pesanKesalahan());
        }

        @Test
        @DisplayName("TC7 | P3 | uts=101 → pesan UTS invalid")
        void tc7_pathP3_utsLebihDari100() {
            ValidatorNilai v = new ValidatorNilai(75, 101, 85);
            assertEquals("  [!] Nilai UTS (101.0) harus berada di antara 0 dan 100.", v.pesanKesalahan());
        }

        @Test
        @DisplayName("TC8 | P4 | uas=-1 → pesan UAS invalid")
        void tc8_pathP4_uasNegatif() {
            ValidatorNilai v = new ValidatorNilai(75, 80, -1);
            assertEquals("  [!] Nilai UAS (-1.0) harus berada di antara 0 dan 100.", v.pesanKesalahan());
        }

        @Test
        @DisplayName("TC9 | P4 | uas=101 → pesan UAS invalid")
        void tc9_pathP4_uasLebihDari100() {
            ValidatorNilai v = new ValidatorNilai(75, 80, 101);
            assertEquals("  [!] Nilai UAS (101.0) harus berada di antara 0 dan 100.", v.pesanKesalahan());
        }

        @Test
        @DisplayName("TC10 | P5 | semua=0 → pesan semua nol")
        void tc10_pathP5_semuaNilaiNol() {
            ValidatorNilai v = new ValidatorNilai(0, 0, 0);
            assertEquals("  [!] Semua nilai tidak boleh 0 (dianggap belum diinput).", v.pesanKesalahan());
        }
    }
}
