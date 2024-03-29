import java.util.Arrays;

public class crcCheck {
    public static void main(String[] args) {
        int[] gen = { 1, 0, 0, 1 ,0 ,0};
        int[] data = { 1, 1, 0, 1 };

        int[] res = toCrc(data, gen);

        System.out.println();
        System.out.println(checkCrc(res, gen));
    }

    public static String checkCrc(int[] crcData, int[] gen){
        for(int i=0; i<crcData.length-gen.length-1;i++){
            if(crcData[i]==1){
                for(int j=0;j< gen.length; j++){
                    crcData[i + j]^=gen[j];
                }
            }
        }

        // for(int i=0;i<data.length;i++){
        //     if (data2[i]==1) {
        //         for (int j = 0; j < gen.length; j++) {
        //             data2[i + j] ^= gen[j];
        //         }
        //     }
        // }

        for (int i = 0; i < crcData.length; i++) {
            System.out.print(crcData[i]);
        }
        System.out.println();

        for (int i = 0; i < gen.length-1; i++) {
            if(crcData[crcData.length-gen.length+i]!=0){
                return "Error detected...";
            }
        }
        return "Data successfully recieved...";
    }

    public static int[] toCrc(int[] data, int[] gen) {
        int[] data2 = new int[data.length + (gen.length - 1)];
        for (int i = 0; i < data.length; i++) {
            data2[i] = data[i];
        }
        for (int i = 0; i < gen.length - 1; i++) {
            data2[data.length + i] = 0;
        }

        //this will only generate 3 crc bits
        for(int i=0;i<data.length;i++){
            if (data2[i]==1) {
                for (int j = 0; j < gen.length; j++) {
                    data2[i + j] ^= gen[j];
                }
            }
        }
        for (int i = 0; i < data.length; i++) {
            data2[i] = data[i];
        }
        return data2;
    }
}
