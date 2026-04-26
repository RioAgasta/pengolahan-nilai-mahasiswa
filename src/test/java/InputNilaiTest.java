import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

/**
 * InputNilaiTest.java
 * Kelompok 3 — White-Box / Basis Path Testing
 * Method yang diuji: UI.inputNilai() returns Mahasiswa
 * Stub Scanner menggunakan ByteArrayInputStream
 * Pola: AAA (Arrange -> Act -> Assert)
 */
class InputNilaiTest {

    @Test
    @DisplayName("TC-01 | Path P1 | Nama & nilai valid 'Budi 75 80 85' -> objek Mahasiswa lengkap")
    void testInputNilai_NamaValidNilaiValid_ReturnMahasiswa() {
        // Arrange
        final String INPUT_SEQ = "Budi\n75\n80\n85\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(INPUT_SEQ.getBytes()));
        UI ui = new UI(sc);

        // Act
        Mahasiswa result = ui.inputNilai();

        // Assert
        assertEquals("Budi", result.getNama(),            "Nama seharusnya 'Budi'");
        assertEquals(75.0,   result.getNilaiTugas(), 0.001, "Tugas seharusnya 75.0");
        assertEquals(80.0,   result.getNilaiUts(),   0.001, "UTS seharusnya 80.0");
        assertEquals(85.0,   result.getNilaiUas(),   0.001, "UAS seharusnya 85.0");
    }

    @Test
    @DisplayName("TC-02 | Path P1 | Nama & nilai maksimum 'Sari 100 100 100' -> objek Mahasiswa lengkap")
    void testInputNilai_NamaSariNilaiMaksimum_ReturnMahasiswa() {
        // Arrange
        final String INPUT_SEQ = "Sari\n100\n100\n100\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(INPUT_SEQ.getBytes()));
        UI ui = new UI(sc);

        // Act
        Mahasiswa result = ui.inputNilai();

        // Assert
        assertEquals("Sari",  result.getNama(),            "Nama seharusnya 'Sari'");
        assertEquals(100.0,   result.getNilaiTugas(), 0.001, "Tugas seharusnya 100.0");
        assertEquals(100.0,   result.getNilaiUts(),   0.001, "UTS seharusnya 100.0");
        assertEquals(100.0,   result.getNilaiUas(),   0.001, "UAS seharusnya 100.0");
    }

    @Test
    @DisplayName("TC-03 | Path P1 | Nama & nilai minimum non-zero 'Tono 1 1 1' -> objek Mahasiswa lengkap")
    void testInputNilai_NamaTonoNilaiMinimumNonZero_ReturnMahasiswa() {
        // Arrange
        final String INPUT_SEQ = "Tono\n1\n1\n1\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(INPUT_SEQ.getBytes()));
        UI ui = new UI(sc);

        // Act
        Mahasiswa result = ui.inputNilai();

        // Assert
        assertEquals("Tono", result.getNama(),           "Nama seharusnya 'Tono'");
        assertEquals(1.0,    result.getNilaiTugas(), 0.001, "Tugas seharusnya 1.0");
        assertEquals(1.0,    result.getNilaiUts(),   0.001, "UTS seharusnya 1.0");
        assertEquals(1.0,    result.getNilaiUas(),   0.001, "UAS seharusnya 1.0");
    }

    @Test
    @DisplayName("TC-04 | Path P2 | Nama kosong -> nama='Tidak Diketahui', nilai 75 80 85")
    void testInputNilai_NamaKosong_ReturnNamaTidakDiketahui() {
        // Arrange
        final String INPUT_SEQ    = "\n75\n80\n85\n";
        final String NAMA_DEFAULT = "Tidak Diketahui";
        Scanner sc = new Scanner(new ByteArrayInputStream(INPUT_SEQ.getBytes()));
        UI ui = new UI(sc);

        // Act
        Mahasiswa result = ui.inputNilai();

        // Assert
        assertEquals(NAMA_DEFAULT, result.getNama(),            "Nama kosong seharusnya diganti 'Tidak Diketahui'");
        assertEquals(75.0,         result.getNilaiTugas(), 0.001, "Tugas seharusnya 75.0");
        assertEquals(80.0,         result.getNilaiUts(),   0.001, "UTS seharusnya 80.0");
        assertEquals(85.0,         result.getNilaiUas(),   0.001, "UAS seharusnya 85.0");
    }

    @Test
    @DisplayName("TC-05 | Path P2 | Nama kosong -> nama='Tidak Diketahui', nilai 50 60 70")
    void testInputNilai_NamaKosongNilaiLain_ReturnNamaTidakDiketahui() {
        // Arrange
        final String INPUT_SEQ    = "\n50\n60\n70\n";
        final String NAMA_DEFAULT = "Tidak Diketahui";
        Scanner sc = new Scanner(new ByteArrayInputStream(INPUT_SEQ.getBytes()));
        UI ui = new UI(sc);

        // Act
        Mahasiswa result = ui.inputNilai();

        // Assert
        assertEquals(NAMA_DEFAULT, result.getNama(),            "Nama kosong seharusnya diganti 'Tidak Diketahui'");
        assertEquals(50.0,         result.getNilaiTugas(), 0.001, "Tugas seharusnya 50.0");
        assertEquals(60.0,         result.getNilaiUts(),   0.001, "UTS seharusnya 60.0");
        assertEquals(70.0,         result.getNilaiUas(),   0.001, "UAS seharusnya 70.0");
    }

    @Test
    @DisplayName("TC-06 | Path P3 | Iterasi 1 gagal (tugas=-1), iterasi 2 valid -> nilai final 75 80 85")
    void testInputNilai_IterasiPertamaGagalTugasNegatif_ReturnIterasiKedua() {
        // Arrange
        // Iterasi 1: tugas=-1 (tidak valid) -> loop ulang
        // Iterasi 2: tugas=75, uts=80, uas=85 (valid) -> break
        final String INPUT_SEQ = "Budi\n-1\n80\n85\n75\n80\n85\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(INPUT_SEQ.getBytes()));
        UI ui = new UI(sc);

        // Act
        Mahasiswa result = ui.inputNilai();

        // Assert
        assertEquals("Budi", result.getNama(),            "Nama seharusnya 'Budi'");
        assertEquals(75.0,   result.getNilaiTugas(), 0.001, "Tugas seharusnya 75.0 setelah retry");
        assertEquals(80.0,   result.getNilaiUts(),   0.001, "UTS seharusnya 80.0 setelah retry");
        assertEquals(85.0,   result.getNilaiUas(),   0.001, "UAS seharusnya 85.0 setelah retry");
    }

    @Test
    @DisplayName("TC-07 | Path P3 | Iterasi 1 gagal (semua 0), iterasi 2 valid -> nilai final 70 75 80")
    void testInputNilai_IterasiPertamaGagalSemuaNol_ReturnIterasiKedua() {
        // Arrange
        // Iterasi 1: tugas=0, uts=0, uas=0 (semua nol, tidak valid) -> loop ulang
        // Iterasi 2: tugas=70, uts=75, uas=80 (valid) -> break
        final String INPUT_SEQ = "Tono\n0\n0\n0\n70\n75\n80\n";
        Scanner sc = new Scanner(new ByteArrayInputStream(INPUT_SEQ.getBytes()));
        UI ui = new UI(sc);

        // Act
        Mahasiswa result = ui.inputNilai();

        // Assert
        assertEquals("Tono", result.getNama(),            "Nama seharusnya 'Tono'");
        assertEquals(70.0,   result.getNilaiTugas(), 0.001, "Tugas seharusnya 70.0 setelah retry");
        assertEquals(75.0,   result.getNilaiUts(),   0.001, "UTS seharusnya 75.0 setelah retry");
        assertEquals(80.0,   result.getNilaiUas(),   0.001, "UAS seharusnya 80.0 setelah retry");
    }
}
