public class PageReplacement {
    public static void main(String[] args) {
        int[] pages = {1,2,3,4,1,2,5,1,2,3,4,5};
        int[] frames = new int[3];
        int pageFaults = 0;
        int n = pages.length;
        for(int i=0; i<n; i++){
            boolean pageFound = false;
            for(int j=0; j<frames.length; j++){
                if(frames[j] == pages[i]){
                    pageFound = true;
                    break;
                }
            }
            if(!pageFound){
                int minIndex = 0;
                int minCount = Integer.MAX_VALUE;
                for(int j=0; j<frames.length; j++){
                    int count = 0;
                    for(int k=i-1; k>=0; k--){
                        if(frames[j] == pages[k]){
                            break;
                        }
                        count++;
                    }
                    if(count < minCount){
                        minIndex = j;
                        minCount = count;
                    }
                }
                frames[minIndex] = pages[i];
                pageFaults++;
            }
        }
        System.out.println("Page Faults: " + pageFaults);
    }
}
