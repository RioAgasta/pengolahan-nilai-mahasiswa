import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pengujian Class PenghitungNilai")
class PenghitungNilaiTest {

    private PenghitungNilai penghitung;

    @BeforeEach
    void setUp() {
        // Precondition: Object terinisialisasi sebelum setiap test dijalankan
        penghitung = new PenghitungNilai();
    }

    @Nested
    @DisplayName("Pengujian Method: hitungNilaiAkhir")
    class HitungNilaiAkhirTest {

        @Test
        @DisplayName("TC-HN-01 | Nilai wajar mahasiswa pada umumnya")
        void testHitungNilaiAkhir_NormalBiasa() {
            assertEquals(80.5, penghitung.hitungNilaiAkhir(75, 80, 85), 0.001);
        }

        @Test
        @DisplayName("TC-HN-02 | Nilai wajar dengan angka yang sama")
        void testHitungNilaiAkhir_NormalSama() {
            assertEquals(70.0, penghitung.hitungNilaiAkhir(70, 70, 70), 0.001);
        }

        @Test
        @DisplayName("TC-HN-03 | Batas bawah absolut (Semua 0)")
        void testHitungNilaiAkhir_BatasBawah() {
            assertEquals(0.0, penghitung.hitungNilaiAkhir(0, 0, 0), 0.001);
        }

        @Test
        @DisplayName("TC-HN-04 | Batas atas absolut valid (Semua 100)")
        void testHitungNilaiAkhir_BatasAtas() {
            assertEquals(100.0, penghitung.hitungNilaiAkhir(100, 100, 100), 0.001);
        }

        @Test
        @DisplayName("TC-HN-05 | BVA/Edge | Batas kritis atas (Melebihi batas tipis)")
        void testHitungNilaiAkhir_MelebihiBatasTipis() {
            // 30%*100 + 30%*100 + 40%*101 = 100.4 -> harus return -1
            assertEquals(-1.0, penghitung.hitungNilaiAkhir(100, 100, 101), 0.001);
        }

        @Test
        @DisplayName("TC-HN-06 | Nilai jauh di atas batas (> 100)")
        void testHitungNilaiAkhir_MelebihiBatasJauh() {
            assertEquals(-1.0, penghitung.hitungNilaiAkhir(150, 150, 150), 0.001);
        }

        @Test
        @DisplayName("TC-HN-07 | Nilai negatif ekstrem")
        void testHitungNilaiAkhir_Negatif() {
            // Fungsi ini tidak memfilter negatif, jadi akan mengembalikan kalkulasi matematisnya (-10.0)
            assertEquals(-10.0, penghitung.hitungNilaiAkhir(-10, -10, -10), 0.001);
        }
    }

    @Nested
    @DisplayName("Pengujian Method: menentukanGrade")
    class MenentukanGradeTest {

        @Test
        @DisplayName("TC-MG-01 | Grade A wajar")
        void testMenentukanGrade_NormalA() {
            assertEquals("A", penghitung.menentukanGrade(92.0));
        }

        @Test
        @DisplayName("TC-MG-02 | Grade B wajar")
        void testMenentukanGrade_NormalB() {
            assertEquals("B", penghitung.menentukanGrade(78.0));
        }

        @Test
        @DisplayName("TC-MG-03 | Grade C wajar")
        void testMenentukanGrade_NormalC() {
            assertEquals("C", penghitung.menentukanGrade(65.0));
        }

        @Test
        @DisplayName("TC-MG-04 | Grade D wajar")
        void testMenentukanGrade_NormalD() {
            assertEquals("D", penghitung.menentukanGrade(55.0));
        }

        @Test
        @DisplayName("TC-MG-05 | Grade E wajar")
        void testMenentukanGrade_NormalE() {
            assertEquals("E", penghitung.menentukanGrade(35.0));
        }

        @Test
        @DisplayName("TC-MG-06 | Batas atas invalid (> 100)")
        void testMenentukanGrade_LebihDari100() {
            assertEquals("A", penghitung.menentukanGrade(105.0));
        }

        @Test
        @DisplayName("TC-MG-07 | Batas atas absolut valid")
        void testMenentukanGrade_BatasAtasValid() {
            assertEquals("A", penghitung.menentukanGrade(100.0));
        }

        @Test
        @DisplayName("TC-MG-08 | Batas bawah Grade A")
        void testMenentukanGrade_BatasBawahA() {
            assertEquals("A", penghitung.menentukanGrade(85.0));
        }

        @Test
        @DisplayName("TC-MG-09 | Batas atas kritis Grade B")
        void testMenentukanGrade_BatasAtasKritisB() {
            assertEquals("B", penghitung.menentukanGrade(84.9));
        }

        @Test
        @DisplayName("TC-MG-10 | Batas bawah Grade B")
        void testMenentukanGrade_BatasBawahB() {
            assertEquals("B", penghitung.menentukanGrade(70.0));
        }

        @Test
        @DisplayName("TC-MG-11 | Batas atas kritis Grade C")
        void testMenentukanGrade_BatasAtasKritisC() {
            assertEquals("C", penghitung.menentukanGrade(69.9));
        }

        @Test
        @DisplayName("TC-MG-12 | Batas bawah Grade C")
        void testMenentukanGrade_BatasBawahC() {
            assertEquals("C", penghitung.menentukanGrade(60.0));
        }

        @Test
        @DisplayName("TC-MG-13 | Batas atas kritis Grade D")
        void testMenentukanGrade_BatasAtasKritisD() {
            assertEquals("D", penghitung.menentukanGrade(59.9));
        }

        @Test
        @DisplayName("TC-MG-14 | Batas bawah Grade D")
        void testMenentukanGrade_BatasBawahD() {
            assertEquals("D", penghitung.menentukanGrade(50.0));
        }

        @Test
        @DisplayName("TC-MG-15 | Batas atas kritis Grade E")
        void testMenentukanGrade_BatasAtasKritisE() {
            assertEquals("E", penghitung.menentukanGrade(49.9));
        }

        @Test
        @DisplayName("TC-MG-16 | Batas bawah absolut (0)")
        void testMenentukanGrade_BatasBawahAbsolut() {
            assertEquals("E", penghitung.menentukanGrade(0.0));
        }

        @Test
        @DisplayName("TC-MG-17 | Nilai ekstrem negatif")
        void testMenentukanGrade_NegatifEkstrem() {
            assertEquals("E", penghitung.menentukanGrade(-5.0));
        }
    }

    @Nested
    @DisplayName("Pengujian Method: menentukanKelulusan")
    class MenentukanKelulusanTest {

        @Test
        @DisplayName("TC-MK-01 | Mahasiswa LULUS ideal")
        void testMenentukanKelulusan_LulusIdeal() {
            assertEquals("LULUS", penghitung.menentukanKelulusan(80.0));
        }

        @Test
        @DisplayName("TC-MK-02 | Mahasiswa TIDAK LULUS ideal")
        void testMenentukanKelulusan_TidakLulusIdeal() {
            assertEquals("TIDAK LULUS", penghitung.menentukanKelulusan(45.0));
        }

        @Test
        @DisplayName("TC-MK-03 | Nilai invalid melebihi 100")
        void testMenentukanKelulusan_LebihDari100() {
            assertEquals("LULUS", penghitung.menentukanKelulusan(105.0));
        }

        @Test
        @DisplayName("TC-MK-04 | Batas atas absolut valid")
        void testMenentukanKelulusan_BatasAtasValid() {
            assertEquals("LULUS", penghitung.menentukanKelulusan(100.0));
        }

        @Test
        @DisplayName("TC-MK-05 | Batas kritis bawah Lulus")
        void testMenentukanKelulusan_BatasKritisBawahLulus() {
            assertEquals("LULUS", penghitung.menentukanKelulusan(60.0));
        }

        @Test
        @DisplayName("TC-MK-06 | Batas kritis atas Tidak Lulus")
        void testMenentukanKelulusan_BatasKritisAtasTidakLulus() {
            assertEquals("TIDAK LULUS", penghitung.menentukanKelulusan(59.9));
        }

        @Test
        @DisplayName("TC-MK-07 | Batas bawah absolut valid (0)")
        void testMenentukanKelulusan_BatasBawahAbsolut() {
            assertEquals("TIDAK LULUS", penghitung.menentukanKelulusan(0.0));
        }

        @Test
        @DisplayName("TC-MK-08 | Nilai ekstrem negatif")
        void testMenentukanKelulusan_NegatifEkstrem() {
            assertEquals("TIDAK LULUS", penghitung.menentukanKelulusan(-5.5));
        }
    }
}
