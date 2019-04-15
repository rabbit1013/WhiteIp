package work.imp;

import work.Utils.BitMap;
import work.WhiteIpAddress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WhiteIpAddressImp implements WhiteIpAddress {

  private BitMap bitMap;

    public WhiteIpAddressImp() {
        this.bitMap = new BitMap(4294967296L);
    }
    private static long longIp(String Ip){
        String[] ipArray = Ip.split("\\.");
        StringBuffer ipString = new StringBuffer();
        for (int i = 0; i < ipArray.length; i++) {
             ipString.append(Integer.toBinaryString(Integer.valueOf(ipArray[i])));
        }
        return  Long.parseLong(ipString.toString(),2);
    }

    private static void isIp(String ipAddress) throws Exception {
        String ip = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
                +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
                +"(00?\\d|1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";

        Pattern pattern = Pattern.compile(ip);
        Matcher matcher = pattern.matcher(ipAddress);
        if(!matcher.matches()){
            throw new Exception("Ip地址错误。");
        }
    }
    @Override
    public boolean addWhiteIpAddress(String Ip) throws Exception {
        isIp(Ip);
        bitMap.setBit(longIp(Ip));
        return true;
    }
    @Override
    public boolean isWhiteIpAddress(String Ip) throws Exception {
        isIp(Ip);
        if (bitMap.getBit(longIp(Ip)) == 1){
            return true;
        }
        return false;
    }
}
