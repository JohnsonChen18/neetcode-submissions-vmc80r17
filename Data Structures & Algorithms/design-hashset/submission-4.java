class MyHashSet {
    private int[] arr;

    public MyHashSet() {
        arr = new int[31251];
    }
    
    public void add(int key) {
        arr[key / 32] = arr[key/32] | (1 << key%32);
    }
    
    public void remove(int key) {
        if(contains(key) == false) return;
        arr[key / 32] = arr[key/32] ^ (1 << key%32);
    }
    
    public boolean contains(int key) {
        if((arr[key/32] & (1 << key%32)) == 0) return false;
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */