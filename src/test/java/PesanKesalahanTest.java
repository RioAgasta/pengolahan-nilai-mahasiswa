import org.junit.jupiter.api.*;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

/**
 * PesanKesalahanTest.java
 * Kelompok 2 — White-Box / Basis Path Testing
 * Method yang diuji: UI.pesanKesalahan(double tugas, double uts, double uas)
 * Pola: AAA (Arrange -> Act -> Assert)
 */
class PesanKesalahanTest {

    private UI ui;

    @BeforeEach
    void setUp() {
        // UI memerlukan Scanner, tapi pesanKesalahan tidak menggunakannya
        ui = new UI(new Scanner(System.in));
    }

    @Test
    @DisplayName("TC-01 | Path P1 | Input valid 75,80,85 -> pesan fallback")
    void testPesanKesalahan_InputValid_ReturnFallback() {
        // Arrange
        final double TUGAS    = 75.0;
        final double UTS      = 80.0;
        final double UAS      = 85.0;
        final String EXPECTED = "  [!] Input tidak valid.";

        // Act
        String result = ui.pesanKesalahan(TUGAS, UTS, UAS);

        // Assert
        assertEquals(EXPECTED, result, "Input valid seharusnya mengembalikan pesan fallback");
    }

    @Test
    @DisplayName("TC-02 | Path P1 | Input valid 100,100,100 -> pesan fallback")
    void testPesanKesalahan_NilaiMaksimumValid_ReturnFallback() {
        // Arrange
        final double TUGAS    = 100.0;
        final double UTS      = 100.0;
        final double UAS      = 100.0;
        final String EXPECTED = "  [!] Input tidak valid.";

        // Act
        String result = ui.pesanKesalahan(TUGAS, UTS, UAS);

        // Assert
        assertEquals(EXPECTED, result, "Nilai 100,100,100 seharusnya mengembalikan pesan fallback");
    }

    @Test
    @DisplayName("TC-03 | Path P1 | Input valid 1,1,1 -> pesan fallback")
    void testPesanKesalahan_NilaiMinimumNonZeroValid_ReturnFallback() {
        // Arrange
        final double TUGAS    = 1.0;
        final double UTS      = 1.0;
        final double UAS      = 1.0;
        final String EXPECTED = "  [!] Input tidak valid.";

        // Act
        String result = ui.pesanKesalahan(TUGAS, UTS, UAS);

        // Assert
        assertEquals(EXPECTED, result, "Nilai 1,1,1 seharusnya mengembalikan pesan fallback");
    }

    @Test
    @DisplayName("TC-04 | Path P2 | Tugas=-1 -> pesan Nilai Tugas harus 0-100")
    void testPesanKesalahan_TugasNegatif_ReturnPesanTugas() {
        // Arrange
        final double TUGAS    = -1.0;
        final double UTS      = 80.0;
        final double UAS      = 85.0;
        final String EXPECTED = "  [!] Nilai Tugas (" + TUGAS + ") harus berada di antara 0 dan 100.";

        // Act
        String result = ui.pesanKesalahan(TUGAS, UTS, UAS);

        // Assert
        assertEquals(EXPECTED, result, "Tugas=-1 seharusnya mengembalikan pesan kesalahan Tugas");
    }

    @Test
    @DisplayName("TC-05 | Path P2 | Tugas=101 -> pesan Nilai Tugas harus 0-100")
    void testPesanKesalahan_TugasMelebihi100_ReturnPesanTugas() {
        // Arrange
        final double TUGAS    = 101.0;
        final double UTS      = 80.0;
        final double UAS      = 85.0;
        final String EXPECTED = "  [!] Nilai Tugas (" + TUGAS + ") harus berada di antara 0 dan 100.";

        // Act
        String result = ui.pesanKesalahan(TUGAS, UTS, UAS);

        // Assert
        assertEquals(EXPECTED, result, "Tugas=101 seharusnya mengembalikan pesan kesalahan Tugas");
    }

    @Test
    @DisplayName("TC-06 | Path P3 | UTS=-1 -> pesan Nilai UTS harus 0-100")
    void testPesanKesalahan_UtsNegatif_ReturnPesanUts() {
        // Arrange
        final double TUGAS    = 75.0;
        final double UTS      = -1.0;
        final double UAS      = 85.0;
        final String EXPECTED = "  [!] Nilai UTS (" + UTS + ") harus berada di antara 0 dan 100.";

        // Act
        String result = ui.pesanKesalahan(TUGAS, UTS, UAS);

        // Assert
        assertEquals(EXPECTED, result, "UTS=-1 seharusnya mengembalikan pesan kesalahan UTS");
    }

    @Test
    @DisplayName("TC-07 | Path P3 | UTS=101 -> pesan Nilai UTS harus 0-100")
    void testPesanKesalahan_UtsMelebihi100_ReturnPesanUts() {
        // Arrange
        final double TUGAS    = 75.0;
        final double UTS      = 101.0;
        final double UAS      = 85.0;
        final String EXPECTED = "  [!] Nilai UTS (" + UTS + ") harus berada di antara 0 dan 100.";

        // Act
        String result = ui.pesanKesalahan(TUGAS, UTS, UAS);

        // Assert
        assertEquals(EXPECTED, result, "UTS=101 seharusnya mengembalikan pesan kesalahan UTS");
    }

    @Test
    @DisplayName("TC-08 | Path P4 | UAS=-1 -> pesan Nilai UAS harus 0-100")
    void testPesanKesalahan_UasNegatif_ReturnPesanUas() {
        // Arrange
        final double TUGAS    = 75.0;
        final double UTS      = 80.0;
        final double UAS      = -1.0;
        final String EXPECTED = "  [!] Nilai UAS (" + UAS + ") harus berada di antara 0 dan 100.";

        // Act
        String result = ui.pesanKesalahan(TUGAS, UTS, UAS);

        // Assert
        assertEquals(EXPECTED, result, "UAS=-1 seharusnya mengembalikan pesan kesalahan UAS");
    }

    @Test
    @DisplayName("TC-09 | Path P4 | UAS=101 -> pesan Nilai UAS harus 0-100")
    void testPesanKesalahan_UasMelebihi100_ReturnPesanUas() {
        // Arrange
        final double TUGAS    = 75.0;
        final double UTS      = 80.0;
        final double UAS      = 101.0;
        final String EXPECTED = "  [!] Nilai UAS (" + UAS + ") harus berada di antara 0 dan 100.";

        // Act
        String result = ui.pesanKesalahan(TUGAS, UTS, UAS);

        // Assert
        assertEquals(EXPECTED, result, "UAS=101 seharusnya mengembalikan pesan kesalahan UAS");
    }

    @Test
    @DisplayName("TC-10 | Path P5 | Semua nol -> pesan semua nilai tidak boleh 0")
    void testPesanKesalahan_SemuaNol_ReturnPesanNol() {
        // Arrange
        final double TUGAS    = 0.0;
        final double UTS      = 0.0;
        final double UAS      = 0.0;
        final String EXPECTED = "  [!] Semua nilai tidak boleh 0 (dianggap belum diinput).";

        // Act
        String result = ui.pesanKesalahan(TUGAS, UTS, UAS);

        // Assert
        assertEquals(EXPECTED, result, "Semua 0 seharusnya mengembalikan pesan belum diinput");
    }
}
