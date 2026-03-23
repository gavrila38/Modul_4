import java.util.ArrayList;
import java.util.Scanner;

public class LoginUser{
    Scanner input = new Scanner(System.in);

    //data field
    private ArrayList<UserAccount> daftarAkun;

    //Constructor
    public LoginUser(ArrayList<UserAccount> daftarAkun){
        this.daftarAkun = daftarAkun;
    }


    //METHOD UNTUK LOGIN
    public int login(){

        System.out.print("Masukan nomor pelanggan >>");
            String nomorPelanggan = input.nextLine();
            System.out.print("Masukkan PIN >>");
            String PIN = input.nextLine();

            
            for(UserAccount user : daftarAkun){
                if(user.getNomorPelanggan().equals(nomorPelanggan) && user.getPin().equals(PIN)){
                    System.out.println("Login Berhasil (Atas nama : " + user.getNama() + ")");
                    return daftarAkun.indexOf(user);
                }
            }
            return -1;
}
}