import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String word = "sistem informasi";
        char[] kata = new char[word.length()];
        String kunci = "kita jurusan";
        int hitung = 0;
        int salah = 0;
        boolean isTrue = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\n\t\t\t\t<<<< GAME TEBAK KATA >>>>\n");
        System.out.println("PERATURAN :");
        System.out.println("Kesalahan hanya diberikan 3 kali. Jika melebihi, dinyatakan kalah");
        System.out.println("\nKata Kunci      : " + kunci);
        System.out.print("\nTampilan Awal   : ");
        for (int y = 0; y < word.length(); y++) {
            kata[y] = '*';
            System.out.print(kata[y]);
        }

        for (int y = 0; y < word.length(); y++) {
            System.out.print("\n\nTebak huruf ke " + (y + 1) + ": ");
            char tebak = scanner.nextLine().charAt(0);

            hitung = 0;
            for (int c = 0; c < word.length(); c++) {
                if (tebak == word.charAt(c)) {
                    kata[c] = tebak;
                    hitung++;
                }
            }

            System.out.print("tampilan: ");
            for (int x = 0; x < word.length(); x++) {
                System.out.print(kata[x]);
            }

            if (hitung < 1) {
                salah++;
                System.out.println("\n\n>>> Elo Salah! <<<\njumlah kesalahan = " + salah);
            } else {
                System.out.println("\n\n>>> Good Job! <<<\njumlah kesalahan = " + salah);
            }

            if (salah > 2) {
                System.out.println("\n\n\n\n<< MAAF KESEMPATAN ANDA SUDAH HABIS >>");
                System.out.println("\n\n\n====================kalah yaa kasihan.....!!!====================");
                break;
            }

            isTrue = true;
            for (int c = 0; c < word.length(); c++) {
                if (kata[c] != word.charAt(c)) {
                    isTrue = false;
                    break;
                }
            }

            if (isTrue) {
                System.out.println("\n\n\n\n<< SELAMAT ANDA MENDAPATKAN 10 JUTA >>");
                System.out.println("\n\n\n-------------------Congrulation-----------------");
                break;
            }
        }

        scanner.close();
    }
}
