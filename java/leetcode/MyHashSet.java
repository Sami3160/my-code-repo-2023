class MyHashSet {
    int[] arr;
    int top=-1;
    public MyHashSet() {
        arr= new int[]{};
    }
    
    public void add(int key) {
        top++;
        if (top >= arr.length) {
            int[] newArr = new int[arr.length + 1];
            System.arraycopy(arr, 0, newArr, 0, arr.length);
            arr = newArr;
        }
        arr[top]=key;       
    }
    
    public void remove(int key) {
        int[] temp=arr;
        for(int i=0;i<temp.length;i++){
            if(arr[i]==key){
                top--;
                continue;
            }
        }
        
        arr=temp;
        
    }
    
    public boolean contains(int key) {
        for(int i=0;i<arr.length;i++){
            if(key==arr[i])return true;
        }
        return false;
    }


    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(0);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */