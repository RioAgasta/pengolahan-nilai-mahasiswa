import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

/**
 * BacaNilaiTest.java
 * Kelompok 4 — White-Box / Basis Path Testing
 * Method yang diuji: UI.bacaNilai(String label) [private — diakses via reflection]
 * Pola: AAA (Arrange -> Act -> Assert)
 */
class BacaNilaiTest {

    /**
     * Helper: buat UI dengan input sequence tertentu dan invoke bacaNilai via reflection.
     */
    private double invokeBacaNilai(String inputSeq) throws Exception {
        Scanner sc = new Scanner(new ByteArrayInputStream(inputSeq.getBytes()));
        UI ui = new UI(sc);
        Method method = UI.class.getDeclaredMethod("bacaNilai", String.class);
        method.setAccessible(true);
        return (double) method.invoke(ui, "Nilai Tugas (0-100)");
    }

    @Test
    @DisplayName("TC-01 | Path P1 | Input angka bulat '75' -> return 75.0")
    void testBacaNilai_InputAngkaBulat_Return75() throws Exception {
        // Arrange
        final String INPUT_SEQ      = "75\n";
        final double EXPECTED_NILAI = 75.0;

        // Act
        double result = invokeBacaNilai(INPUT_SEQ);

        // Assert
        assertEquals(EXPECTED_NILAI, result, 0.001, "Input '75' seharusnya mengembalikan 75.0");
    }

    @Test
    @DisplayName("TC-02 | Path P1 | Input desimal '87.5' -> return 87.5")
    void testBacaNilai_InputDesimal_Return87_5() throws Exception {
        // Arrange
        final String INPUT_SEQ      = "87.5\n";
        final double EXPECTED_NILAI = 87.5;

        // Act
        double result = invokeBacaNilai(INPUT_SEQ);

        // Assert
        assertEquals(EXPECTED_NILAI, result, 0.001, "Input '87.5' seharusnya mengembalikan 87.5");
    }

    @Test
    @DisplayName("TC-03 | Path P1 | Input nol '0' -> return 0.0")
    void testBacaNilai_InputNol_Return0() throws Exception {
        // Arrange
        final String INPUT_SEQ      = "0\n";
        final double EXPECTED_NILAI = 0.0;

        // Act
        double result = invokeBacaNilai(INPUT_SEQ);

        // Assert
        assertEquals(EXPECTED_NILAI, result, 0.001, "Input '0' seharusnya mengembalikan 0.0");
    }

    @Test
    @DisplayName("TC-04 | Path P2 | Input huruf 'abc' -> NumberFormatException -> retry -> return 75.0")
    void testBacaNilai_InputHurufLaluRetry_Return75() throws Exception {
        // Arrange
        // Baris 1 'abc' memicu NumberFormatException -> loop retry
        // Baris 2 '75' berhasil di-parse
        final String INPUT_SEQ      = "abc\n75\n";
        final double EXPECTED_NILAI = 75.0;

        // Act
        double result = invokeBacaNilai(INPUT_SEQ);

        // Assert
        assertEquals(EXPECTED_NILAI, result, 0.001, "Setelah input 'abc', retry '75' seharusnya mengembalikan 75.0");
    }

    @Test
    @DisplayName("TC-05 | Path P2 | Input spasi ' ' -> di-trim jadi '' -> NumberFormatException -> retry -> return 90.0")
    void testBacaNilai_InputSpasiLaluRetry_Return90() throws Exception {
        // Arrange
        // Baris 1 ' ' setelah trim menjadi "" -> parseDouble("") memicu NumberFormatException
        // Baris 2 '90' berhasil di-parse
        final String INPUT_SEQ      = " \n90\n";
        final double EXPECTED_NILAI = 90.0;

        // Act
        double result = invokeBacaNilai(INPUT_SEQ);

        // Assert
        assertEquals(EXPECTED_NILAI, result, 0.001, "Setelah input spasi, retry '90' seharusnya mengembalikan 90.0");
    }

    @Test
    @Disabled(
        "INFEASIBLE PATH — Path 1-2-6 (masuk method -> evaluasi kondisi while -> langsung keluar loop) " +
        "tidak dapat dilalui karena variabel 'berhasil' diinisialisasi false sehingga kondisi " +
        "while(!berhasil) selalu true saat pertama kali dievaluasi. " +
        "Artinya body loop pasti dieksekusi minimal 1 kali; " +
        "path yang melewati (bypass) loop sama sekali secara struktural tidak mungkin terjadi."
    )
    @DisplayName("TC-06 | Path P3 | INFEASIBLE — bypass loop while(!berhasil)")
    void testBacaNilai_InfeasibleBypassLoop_TidakDapatDiuji() {
        // Path ini tidak dapat dijangkau karena boolean berhasil = false selalu memaksa
        // eksekusi minimal satu iterasi loop.
    }
}
