package pengolahannilai;

public class ValidatorNilai {

    private double tugas;
    private double uts;
    private double uas;

    public ValidatorNilai(double tugas, double uts, double uas) {
        this.tugas = tugas;
        this.uts = uts;
        this.uas = uas;
    }

    public double getTugas() {
        return tugas;
    }

    public double getUts() {
        return uts;
    }

    public double getUas() {
        return uas;
    }

    public boolean validasiNilai() {
        if (tugas < 0 || tugas > 100)
            return false;
        if (uts < 0 || uts > 100)
            return false;
        if (uas < 0 || uas > 100)
            return false;
        if (tugas == 0 && uts == 0 && uas == 0)
            return false;
        return true;
    }

    public String pesanKesalahan() {
        if (tugas < 0 || tugas > 100)
            return "  [!] Nilai Tugas (" + tugas + ") harus berada di antara 0 dan 100.";
        if (uts < 0 || uts > 100)
            return "  [!] Nilai UTS (" + uts + ") harus berada di antara 0 dan 100.";
        if (uas < 0 || uas > 100)
            return "  [!] Nilai UAS (" + uas + ") harus berada di antara 0 dan 100.";
        if (tugas == 0 && uts == 0 && uas == 0)
            return "  [!] Semua nilai tidak boleh 0 (dianggap belum diinput).";
        return "  [!] Input tidak valid.";
    }
}
