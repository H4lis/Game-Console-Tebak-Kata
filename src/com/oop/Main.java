import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String word = "sistem informasi"; // Kata yang akan ditebak
        char[] kata = new char[word.length()]; // Array untuk menyimpan huruf-huruf yang ditebak
        String kunci = "kita jurusan?"; // Frase kunci yang ditampilkan dalam permainan
        int hitung = 0; // Penghitung tebakan yang benar
        int salah = 0; // Penghitung tebakan yang salah
        boolean isTrue = false; // Flag untuk memeriksa apakah kata sudah terbaca seluruhnya

        Scanner scanner = new Scanner(System.in);

        // Menampilkan pengenalan permainan
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                       GAME TEBAK KATA                         |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("| Kesalahan hanya diberikan 3 kali. Jika melebihi, dinyatakan   |");
        System.out.println("| kalah.                                                        |");
        System.out.println("|                                                               |");
        System.out.println("| Kata Kunci          : " + kunci);
        System.out.println("| Tampilan Awal       : " + getFormattedWord(word, kata));
        System.out.println("+--------------------------------------------------------------+");

        // Melakukan iterasi untuk setiap huruf dalam kata
        for (int y = 0; y < word.length(); y++) {
            System.out.print("\nTebak huruf ke " + (y + 1) + ": "); // Minta pemain untuk menebak huruf
            char tebak = scanner.nextLine().charAt(0);

            hitung = 0;
            for (int c = 0; c < word.length(); c++) {
                if (tebak == word.charAt(c)) { // Memeriksa apakah huruf yang ditebak cocok dengan huruf dalam kata
                    kata[c] = tebak; // Memperbarui huruf yang ditebak dalam array 'kata'
                    hitung++; // Menambahkan penghitung untuk tebakan yang benar
                }
            }

            System.out.println("+--------------------------------------------------------------+");
            if (hitung < 1) {
                salah++;
                System.out.println("|  >>> Salah! <<<   |   Jumlah kesalahan = " + salah + "  |"); // Tebakan salah
            } else {
                System.out.println("|  >>> Bagus! <<<    |   Jumlah kesalahan = " + salah + "  |"); // Tebakan benar
            }
            System.out.println("|  Tampilan: " + getFormattedWord(word, kata)); // Menampilkan keadaan terkini kata
            System.out.println("+--------------------------------------------------------------+");

            if (salah > 2) {
                System.out.println("\n\n<< MAAF KESEMPATAN ANDA SUDAH HABIS >>");
                System.out.println("\n\n====================Kalah yaa kasihan.....!!!===================="); // Pemain kalah dalam permainan
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
                System.out.println("\n\n<< SELAMAT ANDA MENDAPATKAN 10 JUTA >>");
                System.out.println("\n\n-------------------Selamat-----------------"); // Pemain menang dalam permainan
                break;
            }
        }

        scanner.close();
    }

    // Mengembalikan kata yang telah diformat dengan huruf-huruf yang ditebak ditampilkan dan asterisk (*) untuk huruf-huruf yang belum terbaca
    private static String getFormattedWord(String word, char[] guessedLetters) {
        StringBuilder formattedWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            if (letter == ' ') {
                formattedWord.append("  ");
            } else if (guessedLetters[i] == 0) {
                formattedWord.append("* ");
            } else {
                formattedWord.append(guessedLetters[i]).append(" ");
            }
        }
        return formattedWord.toString();
    }
}
