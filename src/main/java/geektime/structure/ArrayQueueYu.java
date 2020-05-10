package geektime.structure;

public class ArrayQueueYu {

    private Integer[] items;
    private int length;
    private int head;
    private int tail;

    ArrayQueueYu(int n){
        this.items = new Integer[n];
        this.length = n;
        this.head = 0;
        this.tail = 0;
    }

    public boolean enqueue(Integer num){
        if(tail == length){
            if(head == 0){
                return false;
            }
            else{
                //移动数据
                for(int i = head ; i < tail ; i++){
                    items[i-head] = items[i];
                }
                tail =  tail - head;
                head = 0;
            }
        }
        items[tail++] = num;
        return true;
    }

    public Integer dequeue(){
        if(head == tail){
            return null;
        }
        return items[head++];
    }

}
