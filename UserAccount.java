public class UserAccount{

    //data field
    private int saldo;
    private String nomorPelanggan;
    private String nama;
    private String PIN;
    private String jenisPelanggan;


    private int cashback1;
     private int cashback2;



    //Contructor (default)
    public UserAccount(){
        this.saldo = 0;
        this.nomorPelanggan = "Tidak diketahui";
        this.nama = "Tidak diketahui";
        this.PIN = "Tidak diketahui";
        this.jenisPelanggan = "Tidak diketahui";
    }

    //Constructor (dengan parameter tanpa saldo)
    public UserAccount(String nomorPelanggan, String nama, String PIN){
        this.nomorPelanggan = nomorPelanggan;
        this.nama = nama;
        this.PIN = PIN;
        this.saldo = 0;
    }

    //Constructor (dengan parameter dengan saldo)
    public UserAccount(String nomorPelanggan, String nama, String PIN,int saldo){
        this.nomorPelanggan = nomorPelanggan;
        this.nama = nama;
        this.PIN = PIN;
        this.saldo = saldo;
    }


    //Accesor (getter)
    public int getSaldo(){
        return saldo;
    }
    public String getNomorPelanggan(){
        return nomorPelanggan;
    }
    public String getNama(){
        return nama;
    }
    public String getPin(){
        return PIN;
    }

    public String getJenisPelanggan(){
    if(this.nomorPelanggan.substring(0,2).equals("38")){
        jenisPelanggan ="silver";
        cashback1 = 5;
        cashback2 = 5;
    }
    else if(this.nomorPelanggan.substring(0,2).equals("56")){
        jenisPelanggan ="gold";
        cashback1 =7;
        cashback2 =2;
    }
    else if(this.nomorPelanggan.substring(0,2).equals("74")){
        jenisPelanggan ="platinum";
        cashback1 = 10;
        cashback2 = 5;
    }
    return jenisPelanggan;
}


    //Mutator (Setter)
    public void setSaldo (int saldo){
        this.saldo = saldo;
    }
    public void setNomorPelanggan(String nomorPelanggan){
        this.nomorPelanggan = nomorPelanggan;
    }
    public void setNama(String nama){
        this.nama = nama;
    }



    //METHOD UNTUK MEMBELI
    public void beli(int hargaBeli){
        if(this.saldo>=10000 && this.saldo>hargaBeli){
            getJenisPelanggan();
            if(hargaBeli > 1000000){
                this.saldo -= hargaBeli;
                this.saldo +=(int)(hargaBeli*(cashback1/100.0));
                System.out.println("Berhasil membeli");
            }
            else{
                this.saldo -= hargaBeli;
                this.saldo += (int)(hargaBeli*((cashback2)/100.0));
                System.out.println("Berhasil membeli");
            }
        }
        else{
            System.out.println("Saldo anda belum mencukupi");
        }

    }
    //METHOD UNTUK TOP UP
    public void topUp(int jumlahTopUp){
        this.saldo += jumlahTopUp;
        System.out.println("Top up berhasil");
    }

}
