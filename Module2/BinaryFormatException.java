package Module2;
public class BinaryFormatException extends Exception {
    public BinaryFormatException(String binaryString) {
        super("This is not a binary string: " + binaryString);
    }
}