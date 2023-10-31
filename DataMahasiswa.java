import java.util.Scanner;
import java.util.regex.Pattern;
        public class DataMahasiswa {



            private String nama;
        private String nim;
        private String email;
        private static final String NIM_PATTERN   = "^202210370311\\d{3}$";
        private static final String EMAIL_PATTERN = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$";

        public void setNama(String nama) throws NamaException  {
            if (!isValidNama(nama)) {
                throw new NamaException("Nama mengandung selain alfabet");
            }
            this.nama = nama;
        }

            /**
             * @param nama
             * @return
             */
        private boolean isValidNama(String nama) {
            return Pattern.matches("[a-zA-Z ]+", nama);
        }

            /**
             * @param nim
             * @throws NimException
             */
        public void setNim(String nim) throws NimException     {
            if (!isValidNim(nim)) {
                throw new NimException("NIM tidak sesuai format");
            }
            this.nim = nim;
        }

        private boolean isValidNim(String nim)                 {
            return Pattern.matches(NIM_PATTERN, nim);
        }

            /**
             * @param email
             * @throws EmailException
             */
        public void setEmail(String email)throws EmailException{
            if (!isValidEmail(email)) {
                throw new EmailException("Email tidak valid");
            }
            this.email = email;
        }

            /**
             * @param email
             * @return
             */
        private boolean isValidEmail(String email) {
            return Pattern.matches(EMAIL_PATTERN, email);
        }

    //Start


            /**
             * @param Mahasiswa
             */
    public static void main(String[] Mahasiswa) {
        Scanner scanner = new Scanner(System.in);
        DataMahasiswa mahasiswa = new DataMahasiswa();


        try {
            System.out.print("Masukkan Nama  : " );
            mahasiswa.setNama(scanner.nextLine() );

            System.out.print("Masukkan NIM   : " );
            mahasiswa.setNim(scanner.nextLine()  );

            System.out.print("Masukkan Email : " );
            mahasiswa.setEmail(scanner.nextLine());

            System.out.println("\nData mahasiswa telah diinputkan\n" );
            System.out.println("Nama  : "         + mahasiswa.nama   );
            System.out.println("NIM   : "         + mahasiswa.nim    );
            System.out.println("Email : "         + mahasiswa.email  );
        } catch     (NamaException | NimException | EmailException e){
            System.out.println("Error : "         + e.getMessage()   );
        } finally {
            System.out.println("     \nBerikut Data Mahasiswa"       );
        }
    }
}

    class NamaException extends Exception {
    public NamaException(String message)  {
        super(message);
    }
    }

    class NimException extends Exception {
    public NimException(String message)  {
        super(message);
    }
    }

    class EmailException extends Exception {
    public EmailException(String message)  {
        super(message);
    }
    }