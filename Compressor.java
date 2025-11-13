import java.util.Base64;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Utility class for compressing and decompressing strings using GZIP and Base64 encoding.
 * All I/O exceptions are wrapped in RuntimeException for convenience.
 */
public class Compressor {

    /**
     * Compresses a string using GZIP and encodes the result as Base64.
     *
     * @param str the input string to compress
     * @return compressed and Base64-encoded string
     */
    public static String stringToGzip(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        try {
            ByteArrayOutputStream zippedString = new ByteArrayOutputStream();
            try (GZIPOutputStream gzip = new GZIPOutputStream(zippedString)) {
                gzip.write(str.getBytes(StandardCharsets.UTF_8));
            }
            return Base64.getEncoder().encodeToString(zippedString.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Compression failed", e);
        }
    }

    /**
     * Decompresses a Base64-encoded GZIP string back to its original form.
     *
     * @param gzippedString the compressed Base64 string
     * @return original uncompressed string
     */
    public static String gzipToString(String gzippedString) {
        if (gzippedString == null || gzippedString.isEmpty()) {
            return gzippedString;
        }

        try {
            byte[] compressedBytes = Base64.getDecoder().decode(gzippedString);
            ByteArrayInputStream byteStream = new ByteArrayInputStream(compressedBytes);
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            try (GZIPInputStream gzip = new GZIPInputStream(byteStream)) {
                byte[] buffer = new byte[256];
                int len;
                while ((len = gzip.read(buffer)) != -1) {
                    out.write(buffer, 0, len);
                }
            }

            return out.toString(StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Decompression failed", e);
        }
    }
}
