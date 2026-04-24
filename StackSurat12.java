public class StackSurat12 {
    Surat12[] stack;
    int size;
    int top;

    StackSurat12(int size) {
        this.size = size;
        stack = new Surat12[size];
        top = -1;
    }

    boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    void push(Surat12 surat) {
        if (!isFull()) {
            top++;
            stack[top] = surat;
        } else {
            System.out.println("Stack penuh! Tidak bisa menambahkan surat.");
        }
    }

    public Surat12 pop() {
        if (!isEmpty()) {
            Surat12 s = stack[top];
            top--;
            return s;
        } else {
            System.out.println("Stack kosong! Tidak ada surat untuk diproses.");
            return null;
        }
    }

    public Surat12 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong! Tidak ada surat yang tersimpan.");
            return null;
        }
    }

    void search(String nama) {
        boolean ditemukan = false;
        for (int i = 0; i < top; i++) {
            if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                System.out.printf("%-10s %-15s %-10s %-8s %-10s\n", 
                                "ID", "Nama", "Kelas", "Jenis", "Durasi");
                System.out.println("-------------------------------------------------------------");

                System.out.printf("%-10s %-15s %-10s %-8s %-1d hari\n",
                    stack[i].idSurat,
                    stack[i].namaMahasiswa,
                    stack[i].kelas,
                    stack[i].jenisIzin,
                    stack[i].durasi
                );
                ditemukan = true;
            }

            if(!ditemukan) {
                System.out.println("Surat tidak ditemukan.");
            }
        }
    }
}
