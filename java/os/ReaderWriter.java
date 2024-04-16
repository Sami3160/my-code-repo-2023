public class ReaderWriter  {
    boolean itemWrote, itemRead, isWriting, isReading;

    public static void main(String[] args) throws Exception {
        ReaderWriter rw=new ReaderWriter();
        rw.writer();
        rw.reader();
    }

    // create a program for simulate reader writer problem in operating system using
    // java
    public ReaderWriter() {
        this.itemWrote = false;
        this.itemRead = false;
    }

    // function for writer
    public void writer() throws Exception {
        if (this.isReading || this.isWriting) {
            System.err.println("Writer: Cant write whiole reader or writer is active.");
            return;
        }
        this.isWriting = true;
        Thread.sleep(2000);
        this.itemWrote = true;
        this.isWriting = false;
        System.out.println("Writer: Writing is done..");

    }

    // function for reader
    public void reader() throws Exception {
        if (this.isWriting) {
            System.err.println("Reader: Cant read while writer is active.");
            return;
        }
        if (!this.itemWrote) {
            System.err.println("Reader: Nothing to read");
            return;
        }
        this.isReading = false;
        Thread.sleep(2000);
        this.itemRead = true;
        System.err.println("Reader: Reading is done.");
        this.isReading = false;
    }

}
