import java.util.Scanner;

/**
 * MODUL INPUT DATA
 * Modul terisolasi untuk menerima input nilai mahasiswa dari user.
 * Modul ini memanggil Validasi secara internal — user tidak bisa lanjut
 * sebelum data dinyatakan valid.
 *
 * Output : array double[3] = { tugas, uts, uas }
 */
public class InputData {

    /**
     * Meminta user menginputkan:
     *   - Nama mahasiswa
     *   - Nilai Tugas, UTS, UAS
     * Perulangan berlanjut hingga semua nilai valid.
     *
     * @param sc  Scanner yang dipakai bersama di seluruh aplikasi
     * @return    array [nama, tugas, uts, uas] sebagai Object[]
     */
    public static Object[] inputNilai(Scanner sc) {
        String nama;
        double tugas, uts, uas;

        // --- Input nama ---
        System.out.print("  Nama Mahasiswa : ");
        nama = sc.nextLine().trim();
        if (nama.isEmpty()) nama = "Tidak Diketahui";

        // --- Input nilai dengan validasi berulang ---
        while (true) {
            tugas = bacaNilai(sc, "Nilai Tugas (0-100)");
            uts   = bacaNilai(sc, "Nilai UTS   (0-100)");
            uas   = bacaNilai(sc, "Nilai UAS   (0-100)");

            if (Validasi.validasiNilai(tugas, uts, uas)) {
                break;                          // data valid, keluar dari loop
            } else {
                System.out.println();
                System.out.println(Validasi.pesanKesalahan(tugas, uts, uas));
                System.out.println("  Silakan masukkan nilai kembali.\n");
            }
        }

        return new Object[]{nama, tugas, uts, uas};
    }

    /**
     * Membaca satu nilai numerik dari keyboard dengan penanganan
     * InputMismatchException agar program tidak crash.
     */
    private static double bacaNilai(Scanner sc, String label) {
        double nilai = 0;
        boolean berhasil = false;
        while (!berhasil) {
            System.out.print("  " + label + " : ");
            try {
                nilai    = Double.parseDouble(sc.nextLine().trim());
                berhasil = true;
            } catch (NumberFormatException e) {
                System.out.println("  [!] Input tidak valid. Harap masukkan angka.");
            }
        }
        return nilai;
    }
}
