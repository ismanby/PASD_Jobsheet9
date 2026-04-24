import java.util.Scanner;

public class SuratDemo12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StackSurat12 stack = new StackSurat12(5);

        int pilih;
        do {
            System.out.println("\n== MENU =="); 
            System.out.println("1. Terima Surat Izin"); 
            System.out.println("2. Proses Surat Izin"); 
            System.out.println("3. Lihat Surat Izin Terakhir"); 
            System.out.println("4. Cari Surat"); 
            System.out.print("Pilih menu: ");

            pilih = sc.nextInt();
            sc.nextLine();

            switch(pilih) {
                case 1:
                    System.out.print("ID Surat: ");
                    String id = sc.nextLine();
                    System.out.print("Nama Mahasiswa: ");
                    String nama = sc.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = sc.nextLine();
                    System.out.print("Jenis Surat: ");
                    char jenis = sc.next().charAt(0);
                    System.out.print("Durasi Izin: ");
                    int durasi = sc.nextInt();
                    
                    Surat12 surat = new Surat12(id, nama, kelas, jenis, durasi);
                    stack.push(surat);
                    System.out.println("Surat berhasil diterima.");
                    break;

                case 2:
                    Surat12 proses = stack.pop();
                    if (proses != null) {
                        System.out.println("Memproses surat dari " + proses.namaMahasiswa);
                    }
                    break;

                case 3: 
                    Surat12 lihat = stack.peek();
                    if (lihat != null) {
                        System.out.printf("%-10s %-15s %-10s %-8s %-10s\n", 
                                        "ID", "Nama", "Kelas", "Jenis", "Durasi");
                        System.out.println("-------------------------------------------------------------");

                        System.out.printf("%-10s %-15s %-10s %-8s %-1d hari\n",
                                        lihat.idSurat,
                                        lihat.namaMahasiswa,
                                        lihat.kelas,
                                        lihat.jenisIzin,
                                        lihat.durasi);
                    }
                    break;
                
                case 4: 
                    System.out.print("Masukkan nama dari pemilik surat: ");
                    String input = sc.nextLine();

                    stack.search(input);
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
                    
            }
        } while (pilih >= 1 && pilih <= 4);

        sc.close();
    }
}
