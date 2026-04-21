package pengolahannilai;

import java.util.Scanner;

public class InputData {

    private Scanner sc;

    public InputData(Scanner sc) {
        this.sc = sc;
    }

    public Mahasiswa inputNilai() {
        System.out.print("  Nama Mahasiswa : ");
        String nama = sc.nextLine().trim();
        if (nama.isEmpty()) nama = "Tidak Diketahui";

        double tugas, uts, uas;

        while (true) {
            tugas = bacaNilai("Nilai Tugas (0-100)");
            uts   = bacaNilai("Nilai UTS   (0-100)");
            uas   = bacaNilai("Nilai UAS   (0-100)");

            ValidatorNilai validator = new ValidatorNilai(tugas, uts, uas);

            if (validator.validasiNilai()) {
                break;
            } else {
                System.out.println();
                System.out.println(validator.pesanKesalahan());
                System.out.println("  Silakan masukkan nilai kembali.\n");
            }
        }

        return new Mahasiswa(nama, tugas, uts, uas);
    }

    private double bacaNilai(String label) {
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
