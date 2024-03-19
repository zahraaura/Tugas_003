public class Kereta {

    private String namaKereta;//Variabel untuk menyimpan nama kereta,
    // baik itu "Komuter" untuk kereta komuter atau nama khusus untuk kereta KAJJ

    private int jumlahTiketTersedia;//Variabel untuk menyimpan jumlah tiket yang tersedia untuk kereta tersebut

    private Ticket[] daftarTiket;//Array yang menyimpan daftar tiket yang telah dipesan

    // Constructor default untuk membuat objek kereta komuter
    public Kereta() { //Ketika objek dibuat dengan constructor ini, nama kereta diatur sebagai "Komuter"
        // dan jumlah tiket tersedia diatur sebagai 1000.
        this.namaKereta = "Komuter";
        this.jumlahTiketTersedia = 1000;
        this.daftarTiket = new Ticket[this.jumlahTiketTersedia];
    }

    // Constructor overload untuk membuat objek KAJJ
    public Kereta(String namaKereta, int jumlahTiket) { //digunakan untuk menentukan
        // nama khusus kereta dan jumlah tiket yang tersedia
        this.namaKereta = namaKereta;
        this.jumlahTiketTersedia = jumlahTiket;
        this.daftarTiket = new Ticket[this.jumlahTiketTersedia];
    }

    // Method untuk menambahkan tiket
    public void tambahTiket(String namaPenumpang) {
        if (this.namaKereta.equals("Komuter")) {
            // Tambahkan tiket tanpa asal dan tujuan untuk kereta komuter
            //Jika tiket berhasil ditambahkan, jumlah tiket tersedia dikurangi satu
            if (this.jumlahTiketTersedia > 0) {
                int index = daftarTiket.length - jumlahTiketTersedia;
                daftarTiket[index] = new Ticket();
                daftarTiket[index].setNamaPenumpang(new String[]{namaPenumpang});
                this.jumlahTiketTersedia--;
                System.out.println("==================================================");
                System.out.println("Tiket berhasil dipesan");
            }
        } else {
            // Tambahkan tiket dengan asal dan tujuan untuk KAJJ
            System.out.println("Mohon masukkan asal dan tujuan penumpang untuk KAJJ!");
        }
    }

    // Method overload untuk menambahkan tiket KAJJ dengan asal dan tujuan
    public void tambahTiket(String namaPenumpang, String asal, String tujuan) {
        boolean isKAJJ = !namaKereta.equals("Komuter");
        if (isKAJJ && (asal == null || tujuan == null)) {
            // Pesan jika penumpang KAJJ tidak memiliki asal atau tujuan
            //Jika jumlah tiket tersedia cukup, tiket ditambahkan dengan asal dan tujuan sesuai dengan argumen yang diberikan
            //Jika tiket berhasil ditambahkan, jumlah tiket tersedia dikurangi satu
            System.out.println("==================================================");
            System.out.println("Penumpang KAJJ wajib memiliki asal dan tujuan tiket");
            return;
        }
        if (!this.namaKereta.equals("Komuter")) {
            if (jumlahTiketTersedia > 0) {
                int index = daftarTiket.length - jumlahTiketTersedia;
                daftarTiket[index] = new Ticket();
                daftarTiket[index].setNamaPenumpang(new String[]{namaPenumpang});
                if (isKAJJ) {
                    daftarTiket[index].setAsal(new String[]{asal});
                    daftarTiket[index].setTujuan(new String[]{tujuan});
                }
                this.jumlahTiketTersedia--;
                System.out.println("==================================================");
                System.out.println("Tiket berhasil dipesan Sisa tiket tersedia: " + jumlahTiketTersedia);
            } else {
                System.out.println("==================================================");
                System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
            }
        } else {
            System.out.println("Kereta komuter tidak menerima pemesanan dengan asal dan tujuan");
        }
    }

    // Method untuk menampilkan tiket
    public void tampilkanTiket() {
        System.out.println("==================================================");
        if (this.namaKereta.equals("Komuter")) {
            // Jika kereta adalah kereta komuter, method ini akan mencetak "Daftar penumpang kereta api komuter:"
            System.out.println("Daftar penumpang kereta api komuter:");
        } else {
            // Jika kereta bukan kereta komuter, method ini akan mencetak "Daftar penumpang kereta api "
            // diikuti dengan nama kereta
            System.out.println("Daftar penumpang kereta api " + this.namaKereta);
        }
        System.out.println("----------------------------");
        for (int i = 0; i < this.daftarTiket.length; i++) {
            if (this.daftarTiket[i] != null) {
                System.out.println("Nama: " + this.daftarTiket[i].getNamaPenumpang()[0]);
                if (!this.namaKereta.equals("Komuter")) {
                    // Jika bukan kereta komuter, tampilkan asal dan tujuan
                    System.out.println("Asal: " + this.daftarTiket[i].getAsal()[0]);
                    System.out.println("Tujuan: " + this.daftarTiket[i].getTujuan()[0]);
                    System.out.println("----------------------------");
                }
            }
        }
        // Jika tidak ada penumpang, method ini akan mencetak pesan bahwa
        // belum ada penumpang atau kereta telah habis dipesan
        if (this.daftarTiket[0] == null) {
            if (this.namaKereta.equals("Komuter")) {
                System.out.println("Kereta telah habis dipesan, silahkan cari jadwal keberangkatan lainnya");
            } else {
                System.out.println("Belum ada penumpang.");
            }
        }
    }
}