package pengolahannilai;

public class PenghitungNilai {

    private double tugas;
    private double uts;
    private double uas;

    public PenghitungNilai(double tugas, double uts, double uas) {
        this.tugas = tugas;
        this.uts = uts;
        this.uas = uas;
    }

    public double hitungNilaiAkhir() {
        ValidatorNilai validator = new ValidatorNilai(tugas, uts, uas);
        if (!validator.validasiNilai()) return -1;

        double nilaiAkhir = (0.3 * tugas) + (0.3 * uts) + (0.4 * uas);
        if (nilaiAkhir > 100) return -1;

        return nilaiAkhir;
    }

    public String menentukanGrade(double nilaiAkhir) {
        if (nilaiAkhir >= 85)      return "A";
        else if (nilaiAkhir >= 70) return "B";
        else if (nilaiAkhir >= 60) return "C";
        else if (nilaiAkhir >= 50) return "D";
        else                       return "E";
    }

    public String menentukanKelulusan(double nilaiAkhir) {
        if (nilaiAkhir >= 60) return "LULUS";
        else                  return "TIDAK LULUS";
    }
}
