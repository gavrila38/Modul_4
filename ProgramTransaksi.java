import java.util.Scanner;
import java.util.ArrayList;

public class ProgramTransaksi{
    public static void main(String[] args){  
        int userIndeks =-1;

        Scanner input = new Scanner(System.in);

        ArrayList<UserAccount> daftarAkun = new ArrayList<>(); 

        daftarAkun.add(new UserAccount("3815673823","Budi Santoso","324156"));
        daftarAkun.add(new UserAccount("5614578293","Joko Andito","314562", 100000));


        System.out.println("1.Login \n2.Sign Up");
        System.out.print(">> ");
        int pilihanMenu = input.nextInt();
        input.nextLine();

        switch(pilihanMenu){
            //CASE LOGIN
            case 1 :
            LoginUser log = new LoginUser(daftarAkun);
            int aktivitasLogin =0; 

                do{
                    userIndeks = log.login();
                    aktivitasLogin++;
                    if(userIndeks==-1){
                    System.out.println("PIN atau nomor pengguna salah");}
    
                if(aktivitasLogin==3){
                    System.out.println("Akun anda telah diblokir");
                    break;
                }
                }while(userIndeks==-1);

            break;


           
            //CASE SIGN UP
            case 2:
            SignUpUser sign = new SignUpUser(daftarAkun);
                do{
                userIndeks = sign.signUp();
                }while(userIndeks!=-1);        
            
            }




            if(userIndeks!=-1){
            //PROGRAM TRANSAKSI
            System.out.println("1. Beli \n2.Top up");
            System.out.print(">> ");
            int pilihanTransaksi = input.nextInt();
            input.nextLine();

            switch(pilihanTransaksi){
                case 1 :
                    System.out.print("Jumlah Pembelian >>");
                    int jumlahPembelian = input.nextInt();
                    input.nextLine();
                    daftarAkun.get(userIndeks).beli(jumlahPembelian);
                    System.out.println("Sisa saldo anda : " + daftarAkun.get(userIndeks).getSaldo());

                case 2 : 
                System.out.print("Jumlah Top Up >>");
                int jumlahTopUp = input.nextInt();
                input.nextLine();
                daftarAkun.get(userIndeks).topUp(jumlahTopUp);
                System.out.println("Sisa saldo anda : " + daftarAkun.get(userIndeks).getSaldo());
            }

        }
    }
    }

    


    

