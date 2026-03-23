import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class SignUpUser{
    Scanner input = new Scanner(System.in);

    //data field
    ArrayList<UserAccount> daftarAkun = new ArrayList<>();

    //Constructor
    public SignUpUser(ArrayList<UserAccount> daftarAkun){
        this.daftarAkun = daftarAkun;
    }

    //METHOD UNTUK SIGN UP
    public int signUp(){

  
                System.out.println("-BUAT AKUN-");
                System.out.print("Nama >>");
                String nama = input.nextLine();
                System.out.print("Buat PIN >>");
                String PIN_baru = input.nextLine();

                if(cekPIN(PIN_baru)==false){
                    System.out.println("PIN harus 6 digit");
                    return -1;
                };

            
                if(cekPIN(PIN_baru)==true){
                System.out.print("Jenis pelanggan \n1. Silver \n2. Gold \n3. Platinum \n>>");
                int jenisPelanggan = input.nextInt();

                String n_pelanggan = buatNomorPelanggan(jenisPelanggan);
                UserAccount newAccount = new UserAccount(n_pelanggan,nama, PIN_baru);
                daftarAkun.add(newAccount);

                System.out.println("Berhasil buat akun");
                System.out.println("Nomor pelanggan anda : " + buatNomorPelanggan(jenisPelanggan));
                }

                return  daftarAkun.size()-1;
    }



    //METHOD UNTUK MENGECEK INPUT PIN
     public boolean cekPIN(String PIN_baru){
        boolean pinDigit = true;
                for(char c : PIN_baru.toCharArray()){
                    if(!Character.isDigit(c)){
                        pinDigit = false;
                    }
                }
                if(PIN_baru.length()!=6 || pinDigit==false){
                    pinDigit =false;
                }
        return pinDigit;
    }

    //METHOD UNTUK MEMUAT NOMOR PELANGGAN BARU
    public String buatNomorPelanggan(int jenisPelanggan){
        Random math = new Random();

        int angkaAcak = 10000000 + math.nextInt(9999999);
        String nomorJenis="";
        switch(jenisPelanggan){
            case 1 : nomorJenis = "38";
            case 2 : nomorJenis = "56";
            case 3 : nomorJenis = "74";
        }

        String nomorPelanggan = nomorJenis + "" + angkaAcak;
        return nomorPelanggan;
    }
}
