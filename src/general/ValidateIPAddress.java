package general;

import java.util.Arrays;

/**
 * Problem Link : https://leetcode.com/problems/validate-ip-address/
 */
public class ValidateIPAddress {

    public static void main(String[] args) {
        String validIpv4Address = "192.168.0.1";
        String validIpv6Address = "1081:db8:85a3:01:-0:8A2E:0370:7334";
        ValidateIPAddress validateIPAddress = new ValidateIPAddress();
        System.out.println(validateIPAddress.isValidIpv4Address(validIpv4Address));
        System.out.println(validateIPAddress.isValidIpv6Address(validIpv6Address));
    }

    public String validIPAddress(String IP) {
        if (isValidIpv4Address(IP))
            return "IPv4";
        else if (isValidIpv6Address(IP))
            return "IPv6";
        else return "Neither";
    }

    public boolean isValidIpv4Address(String ipAddress) {
        String[] ipGroups = ipAddress.split("\\.", -1);

        if (ipGroups.length != 4) return false;

        long groupCount = Arrays.stream(ipGroups)
                .filter(ipGroup -> !ipGroup.isEmpty())
                .filter(ipGroup -> checkHasHeadingZeroes(ipGroup))
                .filter(ipGroup -> containsNegativeNumbers(ipGroup))
                .filter(this::checkIfValidIPv4Number)
                .count();

        return groupCount == 4;
    }

    public boolean isValidIpv6Address(String ipAddress) {
        String[] ipGroups = ipAddress.split(":", -1);

        if (ipGroups.length != 8) return false;

        long groupCount = Arrays.stream(ipGroups)
                .filter(ipGroup -> containsNegativeNumbers(ipGroup))
                .filter(ipGroup -> checkSizeLessThan(ipGroup, 5))
                .filter(ipGroup -> isValidPositiveHexDecimalNumber(ipGroup))
                .count();

        return groupCount == 8;
    }

    private boolean containsNegativeNumbers(String number) {
        return !number.startsWith("-");
    }

    private boolean isValidPositiveHexDecimalNumber(String number) {
        try {
            Long parsedNumber = Long.parseLong(number, 16);
            return parsedNumber > -1;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean checkSizeLessThan(String number, int count) {
        return !number.isEmpty() && number.length() < count;
    }

    private boolean checkHasHeadingZeroes(String number) {
        return !(number.charAt(0) == '0' && number.length() > 1);
    }

    private boolean checkIfValidIPv4Number(String number){
        try{
            int parsedNumber = Integer.parseInt(number);
            return (parsedNumber > -1 && parsedNumber < 256);
        } catch (NumberFormatException ex){
            return false;
        }
    }
}
