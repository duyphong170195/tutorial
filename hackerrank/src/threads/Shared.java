package threads;

class Shared {
    int counter = 0;

    void increment() {
        for(int i = 0; i < 10000; i++) {
            counter++; // Thread A writes
        }
    }

    int get() {
        return counter; // Thread B reads
    }

}