import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test{

    private static int i = 0;

    /***
     * 获取当前系统时间戳 并截取
     * @return
     */
    private synchronized static String getUnixTime(){
        try {
            Thread.sleep(10);//线程同步执行，休眠10毫秒 防止卡号重复
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        i++;i=i>100?i%10:i;
        return ((System.currentTimeMillis()/100)+"").substring(1)+(i%10);
    }

    /**
     * 校验银行卡卡号
     * @param cardId
     * @return
     */
    public static boolean checkBankCard(String cardId) {
        char bit = getBankCardCheckCode(cardId.substring(0, cardId.length() - 1));
        if(bit == 'N'){
            return false;
        }
        return cardId.charAt(cardId.length() - 1) == bit;
    }

    /**
     * 从不含校验位的银行卡卡号采用 Luhm 校验算法获得校验位
     * @param nonCheckCodeCardId
     * @return
     */
    public static char getBankCardCheckCode(String nonCheckCodeCardId){
        if(nonCheckCodeCardId == null || nonCheckCodeCardId.trim().length() == 0
                || !nonCheckCodeCardId.matches("\\d+")) {
            //如果传的不是数据返回N
            return 'N';
        }
        char[] chs = nonCheckCodeCardId.trim().toCharArray();
        int luhmSum = 0;
        for(int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
            int k = chs[i] - '0';
            if(j % 2 == 0) {
                k *= 2;
                k = k / 10 + k % 10;
            }
            luhmSum += k;
        }
        return (luhmSum % 10 == 0) ? '0' : (char)((10 - luhmSum % 10) + '0');
    }

    public static void main(String[] args) {
        File file = new File("/Users/liuyang/Desktop/cardNum.txt");
        try(FileOutputStream out = new FileOutputStream(file)){
            String firstCard = "623281045000006";
            for (int i = 602; i < 651; i++) {
                String fCard = firstCard + String.valueOf(i);
                char bankCardCheckCode = getBankCardCheckCode(fCard);
                String s = fCard + bankCardCheckCode;
//                System.out.println(s);
                out.write(s.getBytes());
                byte[] bytes = System.getProperty("line.separator").getBytes();
                out.write(bytes);
                out.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}