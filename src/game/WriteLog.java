package game;

import java.io.*;

public class WriteLog {

    /**
     * Write current games results to log file
     *
     * @param results - player 1 and 2 game results
     */
    public static void save(Result results) {
        File logFile = new File("scoreHistory.dat");
        boolean append = logFile.exists();
        try (AppendableObjectOutputStream ao =
                new AppendableObjectOutputStream(new FileOutputStream(logFile, append), append)) {
            ao.writeObject(results);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /** make object output stream files appendable (HACKY) */
    private static class AppendableObjectOutputStream extends ObjectOutputStream {
        private final boolean append;
        private final boolean initialized;
        private final DataOutputStream dout;

        public AppendableObjectOutputStream(OutputStream out, boolean append) throws IOException {
            super(out);
            this.append = append;
            this.initialized = true;
            this.dout = new DataOutputStream(out);
            this.writeStreamHeader();
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            if (!this.initialized || this.append) return;
            if (dout != null) {
                dout.writeShort(STREAM_MAGIC);
                dout.writeShort(STREAM_VERSION);
            }
        }
    }
}
