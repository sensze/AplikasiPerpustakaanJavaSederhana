import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    static InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    static BufferedReader input = new BufferedReader(inputStreamReader);
    private int idBuku;
    private String namaBuku;
    private String pengarangBuku;
    private int idAnggota;
    private String namaAnggota;
    private String noAnggota;
    Buku buku = new Buku();
    Anggota anggota = new Anggota();

    public void showMenu() throws IOException {
        System.out.println("Manajemen Buku");
        System.out.println("[1] Show all buku");
        System.out.println("[2] Show buku by id");
        System.out.println("[3] Insert buku");
        System.out.println("[4] Edit buku");
        System.out.println("[5] Delete buku");
        System.out.println("Manajemen Anggota");
        System.out.println("[6] Show all anggota");
        System.out.println("[7] Show anggota by id");
        System.out.println("[8] Insert anggota");
        System.out.println("[9] Edit anggota");
        System.out.println("[10] Delete anggota");
        System.out.println("Manajemen Peminjaman");
        System.out.println("[11] Peminjaman buku");
        System.out.println("[12] Get all peminjaman buku");
        System.out.println("[13] Pengembalian buku");

        System.out.println("Silahkan masukkan menu: ");
        int selectedMenu = Integer.parseInt(input.readLine().trim());

        switch (selectedMenu) {
            case 1:
                buku.getAllBuku();
                break;
            case 2:
                System.out.print("Masukkan id buku: ");
                idBuku = Integer.parseInt(input.readLine().trim());
                buku.getBukuById(idBuku);
                break;
            case 3:
                System.out.println("Masukkan judul buku: ");
                namaBuku = input.readLine();
                System.out.println("Masukkan pengarang buku: ");
                pengarangBuku = input.readLine();
                buku.createBuku(namaBuku, pengarangBuku);
                break;
            case 4:
                System.out.println("Masukkan id buku yang ingin di edit: ");
                idBuku = Integer.parseInt(input.readLine().trim());
                System.out.println("Masukkan judul buku baru: ");
                namaBuku = input.readLine();
                System.out.println("Masukkan pengarang buku baru: ");
                pengarangBuku = input.readLine();
                buku.updateBuku(idBuku, namaBuku, pengarangBuku);
                break;
            case 5:
                System.out.println("Masukkan id buku yang ingin di hapus: ");
                idBuku = Integer.parseInt(input.readLine().trim());
                buku.deleteBuku(idBuku);
                break;
            case 6:
                anggota.getAllAnggota();
                break;
            case 7:
                System.out.println("Masukkan id anggota: ");
                idAnggota = Integer.parseInt(input.readLine().trim());
                anggota.getAnggotaById(idAnggota);
                break;
            case 8:
                System.out.println("Masukkan nama anggota: ");
                namaAnggota = input.readLine();
                System.out.println("Masukkan nomor anggota: ");
                noAnggota = input.readLine();
                anggota.createAnggota(namaAnggota, noAnggota);
                break;
            case 9:
                System.out.println("Masukkan id anggota yang ingin di edit: ");
                idAnggota = Integer.parseInt(input.readLine().trim());
                System.out.println("Masukkan nama anggota baru: ");
                namaAnggota = input.readLine();
                System.out.println("Masukkan no anggota baru: ");
                noAnggota = input.readLine();
                anggota.updateAnggota(idAnggota, namaAnggota, noAnggota);
                break;
            case 10:
                System.out.println("Masukkan id anggota yang ingin di hapus: ");
                idAnggota = Integer.parseInt(input.readLine().trim());
                anggota.deleteAnggota(idAnggota);
                break;
            default:
                System.out.println("Menu tidak tersedia!");
                break;
        }
    }
}
