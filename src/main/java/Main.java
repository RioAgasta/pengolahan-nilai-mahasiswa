import java.util.Scanner;

/**
 * ╔══════════════════════════════════════════════════════╗
 * ║      APLIKASI PENGOLAHAN NILAI MAHASISWA             ║
 * ║                                                      ║
 * ║  Arsitektur Modul:                                   ║
 * ║    Main          → Interface & loop menu             ║
 * ║    ProsesNilai   → Orkestrator modul                 ║
 * ║    InputData     → Modul input data                  ║
 * ║    Validasi      → Modul validasi data               ║
 * ║    Komputasi     → Modul hitung nilai, grade, status ║
 * ╚══════════════════════════════════════════════════════╝
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean lanjut = true;

        tampilkanHeader();

        while (lanjut) {
            tampilkanMenu();

            System.out.print("  Pilih menu [1/2] : ");
            String pilihan = sc.nextLine().trim();

            switch (pilihan) {
                case "1":
                    // Delegasikan ke ProsesNilai — Main hanya terima string hasil
                    String hasil = ProsesNilai.proses(sc);
                    System.out.println(hasil);
                    break;

                case "2":
                    System.out.println("\n  Terima kasih telah menggunakan sistem ini. Sampai jumpa!\n");
                    lanjut = false;
                    break;

                default:
                    System.out.println("  [!] Pilihan tidak dikenali. Masukkan 1 atau 2.\n");
            }
        }

        sc.close();
    }

    // ── Tampilan banner pembuka ──────────────────────────────────────
    private static void tampilkanHeader() {
        System.out.println("\n  ================================================");
        System.out.println("     SISTEM PENGOLAHAN NILAI MAHASISWA  v1.0");
        System.out.println("  ================================================");
        System.out.println("  Formula Nilai Akhir:");
        System.out.println("    (30% x Tugas) + (30% x UTS) + (40% x UAS)");
        System.out.println("  ================================================\n");
    }

    // ── Tampilan loop menu ───────────────────────────────────────────
    private static void tampilkanMenu() {
        System.out.println("  ┌─────────────────────────────┐");
        System.out.println("  │           MENU UTAMA        │");
        System.out.println("  ├─────────────────────────────┤");
        System.out.println("  │  1. Input Nilai Mahasiswa   │");
        System.out.println("  │  2. Keluar                  │");
        System.out.println("  └─────────────────────────────┘");
    }
}
