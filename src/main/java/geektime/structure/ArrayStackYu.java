package geektime.structure;

public class ArrayStackYu {

    private Integer[] items;
    private int count;
    private int length;

    ArrayStackYu(int n){
        this.items = new Integer[n];
        this.count = 0;
        this.length = n;
    }

    public Integer pop(){
        if( count == 0){
            return null;
        }
        count--;
        return items[count];
    }

    public boolean push(Integer num){
        if( count == length){
            return false;
        }
        items[count++] = num;
        return true;
    }

}
