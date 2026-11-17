/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package kalkulatorbangunruang1;

// CLASS INDUK
abstract class BangunRuang {

    public abstract double hitungVolume();

    public abstract double hitungLuasPermukaan();

    public abstract String getNama();
}

// CLASS KUBUS
class Kubus extends BangunRuang {

    private double sisi;

    public Kubus(double sisi) {
        this.sisi = sisi;
    }

    public double getSisi() {
        return sisi;
    }

    public void setSisi(double sisi) {
        this.sisi = sisi;
    }

    @Override
    public double hitungVolume() {
        return sisi * sisi * sisi;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 6 * sisi * sisi;
    }

    @Override
    public String getNama() {
        return "Kubus";
    }
}

// CLASS BALOK
class Balok extends BangunRuang {

    private double panjang;
    private double lebar;
    private double tinggi;

    public Balok(double panjang, double lebar, double tinggi) {
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        return panjang * lebar * tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * (
            panjang * lebar +
            panjang * tinggi +
            lebar * tinggi
        );
    }

    @Override
    public String getNama() {
        return "Balok";
    }
}

// CLASS TABUNG
class Tabung extends BangunRuang {

    private double jariJari;
    private double tinggi;

    public Tabung(double jariJari, double tinggi) {
        this.jariJari = jariJari;
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        return Math.PI * jariJari * jariJari * tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * Math.PI * jariJari *
               (jariJari + tinggi);
    }

    @Override
    public String getNama() {
        return "Tabung";
    }
}