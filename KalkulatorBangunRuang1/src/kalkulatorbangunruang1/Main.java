/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kalkulatorbangunruang1;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    // METHOD INPUT ANGKA
    static double inputAngka(String pesan) {
        double angka;

        while (true) {
            System.out.print(pesan);

            try {
                angka = Double.parseDouble(
                    input.nextLine().replace(",", ".")
                );

                if (angka > 0) {
                    return angka;
                } else {
                    System.out.println(
                        "Angka harus lebih dari 0!"
                    );
                }

            } catch (NumberFormatException e) {
                System.out.println(
                    "Input harus berupa angka!"
                );
            }
        }
    }

    // METHOD MENAMPILKAN HASIL
    static void tampilkanHasil(BangunRuang bangun) {

        System.out.println("\n================================");
        System.out.println("       HASIL PERHITUNGAN");
        System.out.println("================================");

        System.out.println("Bangun Ruang : " + bangun.getNama());

        System.out.printf(
            "Volume       : %.2f%n",
            bangun.hitungVolume()
        );

        System.out.printf(
            "Luas Permukaan: %.2f%n",
            bangun.hitungLuasPermukaan()
        );

        System.out.println("================================");
    }

    // METHOD UTAMA
    public static void main(String[] args) {

        int pilihan = 0;

        do {
            System.out.println("\n================================");
            System.out.println("     KALKULATOR BANGUN RUANG");
            System.out.println("================================");
            System.out.println("1. Kubus");
            System.out.println("2. Balok");
            System.out.println("3. Tabung");
            System.out.println("4. Keluar");
            System.out.println("================================");

            System.out.print("Pilih menu: ");

            try {
                pilihan = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                pilihan = 0;
            }

            BangunRuang bangun = null;

            switch (pilihan) {

                case 1:
                    System.out.println("\n--- KALKULATOR KUBUS ---");

                    double sisi = inputAngka(
                        "Masukkan sisi: "
                    );

                    bangun = new Kubus(sisi);
                    break;

                case 2:
                    System.out.println("\n--- KALKULATOR BALOK ---");

                    double panjang = inputAngka(
                        "Masukkan panjang: "
                    );

                    double lebar = inputAngka(
                        "Masukkan lebar: "
                    );

                    double tinggi = inputAngka(
                        "Masukkan tinggi: "
                    );

                    bangun = new Balok(
                        panjang, lebar, tinggi
                    );
                    break;

                case 3:
                    System.out.println("\n--- KALKULATOR TABUNG ---");

                    double jari = inputAngka(
                        "Masukkan jari-jari: "
                    );

                    double tinggiTabung = inputAngka(
                        "Masukkan tinggi: "
                    );

                    bangun = new Tabung(
                        jari, tinggiTabung
                    );
                    break;

                case 4:
                    System.out.println("\nTerima kasih!");
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println(
                        "Pilihan tidak tersedia!"
                    );
            }

            if (bangun != null) {
                tampilkanHasil(bangun);
            }

        } while (pilihan != 4);

        input.close();
    }
}