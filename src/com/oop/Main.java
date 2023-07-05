import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String word = "sistem informasi";
        char[] kata = new char[word.length()];
        String kunci = "kita jurusan?";
        int hitung = 0;
        int salah = 0;
        boolean isTrue = false;

        Scanner scanner = new Scanner(System.in);

        System.out.println("+--------------------------------------------------------------+");
        System.out.println("|                       GAME TEBAK KATA                         |");
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("| Kesalahan hanya diberikan 3 kali. Jika melebihi, dinyatakan   |");
        System.out.println("| kalah.                                                        |");
        System.out.println("|                                                               |");
        System.out.println("| Kata Kunci          : " + kunci );
        System.out.println("| Tampilan Awal       : " + getFormattedWord(word, kata));
        System.out.println("+--------------------------------------------------------------+");

        for (int y = 0; y < word.length(); y++) {
            System.out.print("\nTebak huruf ke " + (y + 1) + ": ");
            char tebak = scanner.nextLine().charAt(0);

            hitung = 0;
            for (int c = 0; c < word.length(); c++) {
                if (tebak == word.charAt(c)) {
                    kata[c] = tebak;
                    hitung++;
                }
            }

            System.out.println("+--------------------------------------------------------------+");
            if (hitung < 1) {
                salah++;
                System.out.println("|  >>> Elo Salah! <<<   |   Jumlah kesalahan = " + salah + "  |");
            } else {
                System.out.println("|  >>> Good Job! <<<    |   Jumlah kesalahan = " + salah + "  |");
            }
            System.out.println("|  Tampilan: " + getFormattedWord(word, kata));
            System.out.println("+--------------------------------------------------------------+");

            if (salah > 2) {
                System.out.println("\n\n<< MAAF KESEMPATAN ANDA SUDAH HABIS >>");
                System.out.println("\n\n====================kalah yaa kasihan.....!!!====================");
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
                System.out.println("\n\n-------------------Congrulation-----------------");
                break;
            }
        }

        scanner.close();
    }

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
