import org.junit.jupiter.api.*;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ValidasiNilaiTest.java
 * Kelompok 1 — White-Box / Basis Path Testing
 * Method yang diuji: UI.validasiNilai(double tugas, double uts, double uas)
 * Pola: AAA (Arrange -> Act -> Assert)
 */
class ValidasiNilaiTest {

    private UI ui;

    @BeforeEach
    void setUp() {
        // UI memerlukan Scanner, tapi validasiNilai tidak menggunakannya
        ui = new UI(new Scanner(System.in));
    }

    @Test
    @DisplayName("TC-01 | Path P1 | Semua nilai valid normal -> true")
    void testValidasiNilai_NilaiNormalValid_ReturnTrue() {
        // Arrange
        final double TUGAS = 75.0;
        final double UTS   = 80.0;
        final double UAS   = 85.0;

        // Act
        boolean result = ui.validasiNilai(TUGAS, UTS, UAS);

        // Assert
        assertTrue(result, "Nilai normal (75,80,85) seharusnya valid -> true");
    }

    @Test
    @DisplayName("TC-02 | Path P1 | Semua nilai maksimum 100 -> true")
    void testValidasiNilai_NilaiMaksimum_ReturnTrue() {
        // Arrange
        final double TUGAS = 100.0;
        final double UTS   = 100.0;
        final double UAS   = 100.0;

        // Act
        boolean result = ui.validasiNilai(TUGAS, UTS, UAS);

        // Assert
        assertTrue(result, "Nilai maksimum (100,100,100) seharusnya valid -> true");
    }

    @Test
    @DisplayName("TC-03 | Path P1 | Semua nilai minimum non-zero 1 -> true")
    void testValidasiNilai_NilaiMinimumNonZero_ReturnTrue() {
        // Arrange
        final double TUGAS = 1.0;
        final double UTS   = 1.0;
        final double UAS   = 1.0;

        // Act
        boolean result = ui.validasiNilai(TUGAS, UTS, UAS);

        // Assert
        assertTrue(result, "Nilai minimum non-zero (1,1,1) seharusnya valid -> true");
    }

    @Test
    @DisplayName("TC-04 | Path P2 | Tugas negatif -1 -> false")
    void testValidasiNilai_TugasNegatif_ReturnFalse() {
        // Arrange
        final double TUGAS = -1.0;
        final double UTS   = 80.0;
        final double UAS   = 85.0;

        // Act
        boolean result = ui.validasiNilai(TUGAS, UTS, UAS);

        // Assert
        assertFalse(result, "Tugas=-1 seharusnya tidak valid -> false");
    }

    @Test
    @DisplayName("TC-05 | Path P2 | Tugas melebihi 100 -> false")
    void testValidasiNilai_TugasMelebihi100_ReturnFalse() {
        // Arrange
        final double TUGAS = 101.0;
        final double UTS   = 80.0;
        final double UAS   = 85.0;

        // Act
        boolean result = ui.validasiNilai(TUGAS, UTS, UAS);

        // Assert
        assertFalse(result, "Tugas=101 seharusnya tidak valid -> false");
    }

    @Test
    @DisplayName("TC-06 | Path P3 | UTS negatif -1 -> false")
    void testValidasiNilai_UtsNegatif_ReturnFalse() {
        // Arrange
        final double TUGAS = 75.0;
        final double UTS   = -1.0;
        final double UAS   = 85.0;

        // Act
        boolean result = ui.validasiNilai(TUGAS, UTS, UAS);

        // Assert
        assertFalse(result, "UTS=-1 seharusnya tidak valid -> false");
    }

    @Test
    @DisplayName("TC-07 | Path P3 | UTS melebihi 100 -> false")
    void testValidasiNilai_UtsMelebihi100_ReturnFalse() {
        // Arrange
        final double TUGAS = 75.0;
        final double UTS   = 101.0;
        final double UAS   = 85.0;

        // Act
        boolean result = ui.validasiNilai(TUGAS, UTS, UAS);

        // Assert
        assertFalse(result, "UTS=101 seharusnya tidak valid -> false");
    }

    @Test
    @DisplayName("TC-08 | Path P4 | UAS negatif -1 -> false")
    void testValidasiNilai_UasNegatif_ReturnFalse() {
        // Arrange
        final double TUGAS = 75.0;
        final double UTS   = 80.0;
        final double UAS   = -1.0;

        // Act
        boolean result = ui.validasiNilai(TUGAS, UTS, UAS);

        // Assert
        assertFalse(result, "UAS=-1 seharusnya tidak valid -> false");
    }

    @Test
    @DisplayName("TC-09 | Path P4 | UAS melebihi 100 -> false")
    void testValidasiNilai_UasMelebihi100_ReturnFalse() {
        // Arrange
        final double TUGAS = 75.0;
        final double UTS   = 80.0;
        final double UAS   = 101.0;

        // Act
        boolean result = ui.validasiNilai(TUGAS, UTS, UAS);

        // Assert
        assertFalse(result, "UAS=101 seharusnya tidak valid -> false");
    }

    @Test
    @DisplayName("TC-10 | Path P5 | Semua nilai nol -> false")
    void testValidasiNilai_SemuaNol_ReturnFalse() {
        // Arrange
        final double TUGAS = 0.0;
        final double UTS   = 0.0;
        final double UAS   = 0.0;

        // Act
        boolean result = ui.validasiNilai(TUGAS, UTS, UAS);

        // Assert
        assertFalse(result, "Semua nilai 0 dianggap belum diinput -> false");
    }
}
