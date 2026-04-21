package pengolahannilai;

import java.util.Scanner;

public class Main {

    private Scanner sc;
    private boolean lanjut;

    public Main() {
        this.sc = new Scanner(System.in);
        this.lanjut = true;
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.jalankan();
    }

    public void jalankan() {
        tampilkanHeader();

        while (lanjut) {
            tampilkanMenu();

            System.out.print("  Pilih menu [1/2] : ");
            String pilihan = sc.nextLine().trim();

            switch (pilihan) {
                case "1":
                    PemrosesNilai pemroses = new PemrosesNilai(sc);
                    String hasil = pemroses.proses();
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

    private void tampilkanHeader() {
        System.out.println("\n  ================================================");
        System.out.println("     SISTEM PENGOLAHAN NILAI MAHASISWA  v1.0");
        System.out.println("  ================================================");
        System.out.println("  Formula Nilai Akhir:");
        System.out.println("    (30% x Tugas) + (30% x UTS) + (40% x UAS)");
        System.out.println("  ================================================\n");
    }

    private void tampilkanMenu() {
        System.out.println("  ┌─────────────────────────────┐");
        System.out.println("  │           MENU UTAMA        │");
        System.out.println("  ├─────────────────────────────┤");
        System.out.println("  │  1. Input Nilai Mahasiswa   │");
        System.out.println("  │  2. Keluar                  │");
        System.out.println("  └─────────────────────────────┘");
    }
}
