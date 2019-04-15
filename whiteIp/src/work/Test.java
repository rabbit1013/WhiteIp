package work;

import work.imp.WhiteIpAddressImp;


public class Test {
    public static void main(String[] args) throws InterruptedException {
        WhiteIpAddress whiteIpAddress = new WhiteIpAddressImp();
        for (int i = 1;i<150;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int x = (int)(Math.random()*255);
                    System.out.println(x);
                    try {
                        whiteIpAddress.addWhiteIpAddress("255.255.255."+x);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        Thread.sleep(1000);
        try {
            System.out.println( whiteIpAddress.isWhiteIpAddress("255.255.255.55"));
            System.out.println( whiteIpAddress.isWhiteIpAddress("255.255.255.56"));
            System.out.println( whiteIpAddress.isWhiteIpAddress("255.255.255.53"));
            System.out.println( whiteIpAddress.isWhiteIpAddress("255.255.255.163"));
            System.out.println( whiteIpAddress.isWhiteIpAddress("255.255.255.74"));
            System.out.println( whiteIpAddress.isWhiteIpAddress("255.255.255.12"));
            System.out.println( whiteIpAddress.isWhiteIpAddress("255.255.255.89"));
            System.out.println( whiteIpAddress.isWhiteIpAddress("255.255.255.47"));
            System.out.println( whiteIpAddress.isWhiteIpAddress("255.255.255.32"));
            System.out.println( whiteIpAddress.isWhiteIpAddress("255.255.255.149"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
