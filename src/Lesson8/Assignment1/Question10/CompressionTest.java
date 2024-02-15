package Lesson8.Assignment1.Question10;

public class CompressionTest {
    public static void main(String[] args) {
        // Test the functionalities of each compression algorithm
        CompressionAlgorithm zipAlgorithm = new ZipAlgorithm();
        zipAlgorithm.compress("input.txt", "output_zip.zip");

        CompressionAlgorithm gzipAlgorithm = new GZipAlgorithm();
        gzipAlgorithm.compress("input.txt", "output_gzip.gz");

        CompressionAlgorithm lzmaAlgorithm = new LZMAAlgorithm();
        lzmaAlgorithm.compress("input.txt", "output_lzma.lzma");
    }
}
