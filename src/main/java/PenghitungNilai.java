

// import src.main.java.pengolahannilai.ValidatorNilai;

public class PenghitungNilai {
  public double hitungNilaiAkhir(double tugas, double uts, double uas) {
    // ValidatorNilai validator = new ValidatorNilai(tugas, uts, uas);
    // if (!validator.validasiNilai())
    // return -1;

    double nilaiAkhir = (0.3 * tugas) + (0.3 * uts) + (0.4 * uas);
    if (nilaiAkhir > 100)
      return -1;

    return nilaiAkhir;
  }

  public String menentukanGrade(double nilaiAkhir) {
    if (nilaiAkhir >= 85)
      return "A";
    else if (nilaiAkhir >= 70)
      return "B";
    else if (nilaiAkhir >= 60)
      return "C";
    else if (nilaiAkhir >= 50)
      return "D";
    else
      return "E";
  }

  public String menentukanKelulusan(double nilaiAkhir) {
    if (nilaiAkhir >= 60)
      return "LULUS";
    else
      return "TIDAK LULUS";
  }
}
