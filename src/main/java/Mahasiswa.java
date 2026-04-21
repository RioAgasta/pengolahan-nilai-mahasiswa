package src.main.java;

public class Mahasiswa {

    private String nama;
    private double nilaiTugas;
    private double nilaiUts;
    private double nilaiUas;

    public Mahasiswa(String nama, double nilaiTugas, double nilaiUts, double nilaiUas) {
        this.nama = nama;
        this.nilaiTugas = nilaiTugas;
        this.nilaiUts = nilaiUts;
        this.nilaiUas = nilaiUas;
    }

    public String getNama() {
        return nama;
    }

    public double getNilaiTugas() {
        return nilaiTugas;
    }

    public double getNilaiUts() {
        return nilaiUts;
    }

    public double getNilaiUas() {
        return nilaiUas;
    }
}
