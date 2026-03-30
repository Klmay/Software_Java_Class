package Module2;
public class TestBinary {
    public static void main(String[] args) {
        try {
            System.out.println(bin2Dec("1101"));
            System.out.println(bin2Dec("1102"));
        } catch (BinaryFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        int decimalValue = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            char binaryChar = binaryString.charAt(i);
            
            if (binaryChar != '0' && binaryChar != '1') {
                throw new BinaryFormatException(binaryString);
            }
            
            decimalValue = decimalValue * 2 + (binaryChar - '0');
        }
        return decimalValue;
    }
}
