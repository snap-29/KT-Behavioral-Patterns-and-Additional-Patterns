package org.example;

interface CompressionStrategy {

    void compress(String file);
}

class ZipCompression implements CompressionStrategy {

    @Override
    public void compress(String file) {
        System.out.println(
                "Файл " + file +
                        " сжат в ZIP"
        );
    }
}

class RarCompression implements CompressionStrategy {

    @Override
    public void compress(String file) {
        System.out.println(
                "Файл " + file +
                        " сжат в RAR"
        );
    }
}

class GzipCompression implements CompressionStrategy {

    @Override
    public void compress(String file) {
        System.out.println(
                "Файл " + file +
                        " сжат в GZIP"
        );
    }
}

class FileCompressor {

    private CompressionStrategy strategy;

    public FileCompressor(
            CompressionStrategy strategy
    ) {
        this.strategy = strategy;
    }

    public void setStrategy(
            CompressionStrategy strategy
    ) {
        this.strategy = strategy;
    }

    public void compress(String file) {
        strategy.compress(file);
    }
}

public class StrategyExample {

    public static void main(String[] args) {

        FileCompressor compressor =
                new FileCompressor(
                        new ZipCompression()
                );

        compressor.compress("photo.jpg");

        compressor.setStrategy(
                new RarCompression()
        );

        compressor.compress("photo.jpg");

        compressor.setStrategy(
                new GzipCompression()
        );

        compressor.compress("photo.jpg");
    }
}