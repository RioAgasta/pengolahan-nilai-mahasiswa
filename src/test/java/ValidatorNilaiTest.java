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
            UI ui = new UI(null);
            assertTrue(ui.validasiNilai(75, 80, 85));
        }

        @Test
        @DisplayName("TC2 | P1 | tugas=100, uts=100, uas=100 → true")
        void tc2_pathP1_nilaiBatasAtasValid() {
            UI ui = new UI(null);
            assertTrue(ui.validasiNilai(100, 100, 100));
        }

        @Test
        @DisplayName("TC3 | P1 | tugas=1, uts=1, uas=1 → true")
        void tc3_pathP1_nilaiBatasBawahValid() {
            UI ui = new UI(null);
            assertTrue(ui.validasiNilai(1, 1, 1));
        }

        @Test
        @DisplayName("TC4 | P2 | tugas=-1, uts=80, uas=85 → false")
        void tc4_pathP2_tugasNegatif() {
            UI ui = new UI(null);
            assertFalse(ui.validasiNilai(-1, 80, 85));
        }

        @Test
        @DisplayName("TC5 | P2 | tugas=101, uts=80, uas=85 → false")
        void tc5_pathP2_tugasLebihDari100() {
            UI ui = new UI(null);
            assertFalse(ui.validasiNilai(101, 80, 85));
        }

        @Test
        @DisplayName("TC6 | P3 | tugas=75, uts=-1, uas=85 → false")
        void tc6_pathP3_utsNegatif() {
            UI ui = new UI(null);
            assertFalse(ui.validasiNilai(75, -1, 85));
        }

        @Test
        @DisplayName("TC7 | P3 | tugas=75, uts=101, uas=85 → false")
        void tc7_pathP3_utsLebihDari100() {
            UI ui = new UI(null);
            assertFalse(ui.validasiNilai(75, 101, 85));
        }

        @Test
        @DisplayName("TC8 | P4 | tugas=75, uts=80, uas=-1 → false")
        void tc8_pathP4_uasNegatif() {
            UI ui = new UI(null);
            assertFalse(ui.validasiNilai(75, 80, -1));
        }

        @Test
        @DisplayName("TC9 | P4 | tugas=75, uts=80, uas=101 → false")
        void tc9_pathP4_uasLebihDari100() {
            UI ui = new UI(null);
            assertFalse(ui.validasiNilai(75, 80, 101));
        }

        @Test
        @DisplayName("TC10 | P5 | tugas=0, uts=0, uas=0 → false")
        void tc10_pathP5_semuaNilaiNol() {
            UI ui = new UI(null);
            assertFalse(ui.validasiNilai(0, 0, 0));
        }
    }

    @Nested
    @DisplayName("pesanKesalahan()")
    class PesanKesalahanTest {

        @Test
        @DisplayName("TC1 | P1 | tugas=75, uts=80, uas=85 → pesan default")
        void tc1_pathP1_nilaiUmumValid() {
            UI ui = new UI(null);
            assertEquals("  [!] Input tidak valid.", ui.pesanKesalahan(75, 80, 85));
        }

        @Test
        @DisplayName("TC2 | P1 | tugas=100, uts=100, uas=100 → pesan default")
        void tc2_pathP1_nilaiBatasAtasValid() {
            UI ui = new UI(null);
            assertEquals("  [!] Input tidak valid.", ui.pesanKesalahan(100, 100, 100));
        }

        @Test
        @DisplayName("TC3 | P1 | tugas=1, uts=1, uas=1 → pesan default")
        void tc3_pathP1_nilaiBatasBawahValid() {
            UI ui = new UI(null);
            assertEquals("  [!] Input tidak valid.", ui.pesanKesalahan(1, 1, 1));
        }

        @Test
        @DisplayName("TC4 | P2 | tugas=-1 → pesan tugas invalid")
        void tc4_pathP2_tugasNegatif() {
            UI ui = new UI(null);
            assertEquals("  [!] Nilai Tugas (-1.0) harus berada di antara 0 dan 100.", ui.pesanKesalahan(-1, 80, 85));
        }

        @Test
        @DisplayName("TC5 | P2 | tugas=101 → pesan tugas invalid")
        void tc5_pathP2_tugasLebihDari100() {
            UI ui = new UI(null);
            assertEquals("  [!] Nilai Tugas (101.0) harus berada di antara 0 dan 100.", ui.pesanKesalahan(101, 80, 85));
        }

        @Test
        @DisplayName("TC6 | P3 | uts=-1 → pesan UTS invalid")
        void tc6_pathP3_utsNegatif() {
            UI ui = new UI(null);
            assertEquals("  [!] Nilai UTS (-1.0) harus berada di antara 0 dan 100.", ui.pesanKesalahan(75, -1, 85));
        }

        @Test
        @DisplayName("TC7 | P3 | uts=101 → pesan UTS invalid")
        void tc7_pathP3_utsLebihDari100() {
            UI ui = new UI(null);
            assertEquals("  [!] Nilai UTS (101.0) harus berada di antara 0 dan 100.", ui.pesanKesalahan(75, 101, 85));
        }

        @Test
        @DisplayName("TC8 | P4 | uas=-1 → pesan UAS invalid")
        void tc8_pathP4_uasNegatif() {
            UI ui = new UI(null);
            assertEquals("  [!] Nilai UAS (-1.0) harus berada di antara 0 dan 100.", ui.pesanKesalahan(75, 80, -1));
        }

        @Test
        @DisplayName("TC9 | P4 | uas=101 → pesan UAS invalid")
        void tc9_pathP4_uasLebihDari100() {
            UI ui = new UI(null);
            assertEquals("  [!] Nilai UAS (101.0) harus berada di antara 0 dan 100.", ui.pesanKesalahan(75, 80, 101));
        }

        @Test
        @DisplayName("TC10 | P5 | semua=0 → pesan semua nol")
        void tc10_pathP5_semuaNilaiNol() {
            UI ui = new UI(null);
            assertEquals("  [!] Semua nilai tidak boleh 0 (dianggap belum diinput).", ui.pesanKesalahan(0, 0, 0));
        }
    }
}
