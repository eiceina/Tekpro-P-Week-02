// RestaurantMain.java

class RestaurantMain {
    public static void main(String[] args) {
        // instansiasi objek restoran
        Restaurant menu = new Restaurant();

        // melakukan penambahan menu makanan
        System.out.println("============== Penambahan Menu Makanan =============");
        menu.tambahMenuMakanan("Pizza", 250000, 20);
        menu.tambahMenuMakanan("Spaghetti", 80000, 20);
        menu.tambahMenuMakanan("Tenderloin Steak", 60000, 30);
        menu.tambahMenuMakanan("Chicken Steak", 45000, 30);
        // makanan tidak ditambahkan karena stok negatif
        menu.tambahMenuMakanan("Salmon Steak", 50000, 0);
        menu.tambahMenuMakanan("Bagel", 50000, 2);
        menu.tambahMenuMakanan("Macaroon", 50000, 3);
        menu.tambahMenuMakanan("Pudding", 50000, 1);
        menu.tambahMenuMakanan("Carrot Cake", 50000, 7);
        menu.tambahMenuMakanan("Eclair", 50000, 8);
        menu.tambahMenuMakanan("Bread", 50000, 8);
        // makanan tidak ditambahkan karena melebihi kapasitas array
        menu.tambahMenuMakanan("Croissant", 50000, 4);

        System.out.println("============ Menu Makanan yang tersedia ============");
        // menampilkan menu makanan yang tersedia
        menu.tampilMenuMakanan();

        System.out.println("============== Pemesanan Menu Makanan ==============");
        // melakukan pemesanan menu makanan
        menu.pemesananMenu("Pizza", 10);
        // makanan tidak dilakukan pemesanan karena stok terbatas
        menu.pemesananMenu("Chicken Steak", 31);
        // makanan tidak dilakukan pemesanan karena tidak tersedia di menu
        menu.pemesananMenu("Ayam Bakar", 31);

        System.out.println("========== Menu Makanan Setelah Pemesanan ==========");
        // menampilkan menu makanan yang tersedia
        menu.tampilMenuMakanan();
    }
}