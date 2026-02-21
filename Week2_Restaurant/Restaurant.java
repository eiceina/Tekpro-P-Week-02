// Restaurant.java

// Mendefinisikan kelas Restaurant
public class Restaurant {
    // Mendeklarasi atribut untuk menyimpan nama, harga, dan stok makanan beserta id
    // dengan access modifier private untuk menerapkan encapsulation
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    // id berperan sebagai index menu untuk setiap objek Restaurant
    private byte id;
    // jumlah elemen maksimal yang dapat ditampung array
    private static final byte MAX_MENU = 10;

    // Konstruktor untuk menginisialisasi atribut
    public Restaurant() {
        // menginisialisasi atribut nama_makanan bertipe array string dengan jumlah elemen 10
        nama_makanan = new String[MAX_MENU];
        // menginisialisasi atribut harga_makanan bertipe array double dengan jumlah elemen 10
        harga_makanan = new double[MAX_MENU];
        // menginisialisasi atribut stok bertipe array int dengan jumlah elemen 10
        stok = new int[MAX_MENU];
        // menginisialisasi index dimulai dari 0
        id = 0;
    }

    // method set untuk mengisi data ke dalam atribut
    // access modifier public agar dapat diakses dari kelas lain
    public void setNamaMakanan(int id, String nama) {
        this.nama_makanan[id] = nama;
    }

    public void setHargaMakanan(int id, double harga) {
        this.harga_makanan[id] = harga;
    }

    public void setStok(int id, int stok) {
        if (validasiStok(stok)) {
            this.stok[id] = stok;
        }
    }

    // setId dan getId tidak diperlukan karena id dikelola di dalam class

    // method getter untuk mengambil/membaca nilai pada atribut
    // access modifier public agar dapat diakses dari kelas lain
    public String getNamaMakanan(int id) {
        return nama_makanan[id];
    }

    public double getHargaMakanan(int id) {
        return harga_makanan[id];
    }

    public int getStok(int id) {
        return stok[id];
    }

    // private method untuk validasi stok karena hanya digunakan di dalam class
    private boolean validasiStok(int stok) {
        // mengembalikan nilai true jika stok > 0
        if (stok > 0) {
            return true;
        } else {
            return false;
        }
    }


    // method untuk menambahkan item ke menu
    public void tambahMenuMakanan(String nama, double harga, int stok) {
        // validasi penampung index menu
        if (id < MAX_MENU){
            // jika stok positif, maka data menu akan ditambahkan
            if (validasiStok(stok)) {
                setNamaMakanan(id, nama);
                setHargaMakanan(id, harga);
                setStok(id, stok);
                // nextId() digunakan di dalam tambahMenuMakanan() agar data tersimpan rapi dan aman
                nextId();
                System.out.println("Status berhasil: " + nama);
            } else {
                System.out.println("Status gagal   : " + nama + " (stok harus positif)");
            }
        } else {
            System.out.println("Status gagal   : " + nama + " (batas menu maksimal " + MAX_MENU + ")");
        }

    }

    // method untuk menampilkan menu
    public void tampilMenuMakanan() {
        // seharusnya i < id, karena i dimulai dari 0
        for (int i = 0; i < id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(
                        getNamaMakanan(i) + "[" + getStok(i) + "]" + "\tRp. " + getHargaMakanan(i)
                );
            }
        }
    }

    // private method mengecek ketersediaan stok karena di dalam class
    private boolean isOutOfStock(int id) {
        if (stok[id] == 0) {
            return true;
        } else {
            return false;
        }
    }

    // private method untuk menambah index ketika sudah menambahkan menu baru
    private void nextId() {
        id++;
    }

    // private method untuk mengecek stok mencukupi, jika terjadi pemesanan pada item menu
    private boolean stokTersedia(int id, int itemStok) {
        if (stok[id] >= itemStok) {
            return true;
        } else {
            return false;
        }
    }

    // private method untuk mengurangi stok apabila dilakukan pemesanan
    private void penguranganStok(int i, int itemStok) {
        stok[i] = stok[i] - itemStok;
    }


    // method untuk melakukan pemesanan menu
    public void pemesananMenu(String itemNama, int itemStok) {
        boolean tersedia = false;
        for (int i = 0; i < id; i++) {
            // jika nama input sesuai dengan nama pada menu, maka dilakukan perhitungan stok
            if (itemNama.equalsIgnoreCase(getNamaMakanan(i))) {
                tersedia = true;
                if (stokTersedia(i, itemStok)) {
                    penguranganStok(i, itemStok);
                    System.out.println(itemNama + " berhasil dipesan!");
                } else {
                    System.out.println(itemNama + " ditolak, stok tidak mencukupi!");
                }
                break;
            }
        }

        if (!tersedia) {
            System.out.println(itemNama + " tidak tersedia!");
        }
    }

}
