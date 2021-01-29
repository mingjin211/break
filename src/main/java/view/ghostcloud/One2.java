package view.ghostcloud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 1. 数组合并
 * 写一个合并方法, 让ProA[]数组和ProB[]数组能够合并成一个MergedAB[]数组.
 * 数组中的元素合并的规则是: 当ProA.key1的值等于ProB.key1的值, 且ProA.key2的值等于ProB.key2值时,
 * 就把ProA和ProB两个实例合并起来, 形成一个新的MergedAB实例并放入MergedAB[]数组.
 * <p>
 * 其中:
 * <p>
 * MergedAB.key1 = ProA.key1 = ProB.key1,
 * MergedAB.key2 = ProA.key2 = ProB.key2,
 * MergedAB.v1 = ProA.v1,
 * MergedAB.v2 = ProB.v2
 * 比如 arrProA数组为:
 * <p>
 * [
 * {key1: "alice", key2: "bob", v1: "xx"},
 * {key1: "apple", key2: "box", v1: "yy"},
 * {key1: "catch", key2: "dog", v1: "zz"}
 * ]
 * arrProB数组为:
 * <p>
 * [
 * {key1: "alice", key2: "bob", v2: "oo"},
 * {key1: "apple", key2: "bee", v2: "pp"},
 * {key1: "coach", key2: "dog", v2: "qq"}
 * ]
 * 那么合并后的MergedAB数组就应该为:
 * <p>
 * [
 * {key1: "alice", key2: "bob", v1: "xx", v2: "oo"}
 * ]
 * public MergedAB[] merge(ProA[] arrProA, ProB[] arrProB){
 * //尽量采用较低的时间复杂度和空间复杂度来实现
 * }
 */
public class One2 {

    public class ProA {
        String key1;
        String key2;
        String v1;

        public ProA(String key1, String key2, String v1) {
            this.key1 = key1;
            this.key2 = key2;
            this.v1 = v1;
        }
    }

    class ProB {
        String key1;
        String key2;
        String v2;

        public ProB(String key1, String key2, String v2) {
            this.key1 = key1;
            this.key2 = key2;
            this.v2 = v2;
        }
    }

    public class MergedAB {
        String key1;
        String key2;
        String v1;
        String v2;

        public MergedAB(String key1, String key2, String v1, String v2) {
            this.key1 = key1;
            this.key2 = key2;
            this.v1 = v1;
            this.v2 = v2;
        }

        @Override
        public String toString() {
            return "{" +
                    "key1='" + key1 + '\'' +
                    ", key2='" + key2 + '\'' +
                    ", v1='" + v1 + '\'' +
                    ", v2='" + v2 + '\'' +
                    '}';
        }
    }

    public MergedAB[] merge(ProA[] arrProA, ProB[] arrProB) {
        //尽量采用较低的时间复杂度和空间复杂度来实现
        //数组A的缓存Map
        HashMap<String, Object> aMap = new HashMap<>();
        //结果数组最大可能有 arrProA.length * arrProB.length 这么长
        MergedAB[] mergedABS = new MergedAB[arrProA.length * arrProB.length];
        //结果数组的索引
        int index = 0;
        //把数组A的结构读进Map
        for (int i = 0; i < arrProA.length; i++) {
            String key = arrProA[i].key1 + "-" + arrProA[i].key2;
            Object out = aMap.get(key);
            if (out == null) {
                aMap.put(key, arrProA[i].v1);
            } else if (out instanceof String) {
                List<String> aList = new ArrayList<>();
                aList.add((String) out);
                aList.add(arrProA[i].v1);
                aMap.put(key, aList);
            } else if (out instanceof ArrayList) {
                List<String> aList = (ArrayList<String>) out;
                aList.add(arrProA[i].v1);
            }
//            aMap.putIfAbsent(key,new ArrayList<>());
//            aMap.get(key).add(arrProA[i].v1);
        }
        //遍历数组B生成结果
        for (int i = 0; i < arrProB.length; i++) {
            String key = arrProB[i].key1 + "-" + arrProB[i].key2;
//            ArrayList<String> aList = aMap.get(key);
//            if(aList!=null){
//                for(String arr : aList){
//                    mergedABS[index++] = new MergedAB(arrProB[i].key1,arrProB[i].key2,arr,arrProB[i].v2);
//                }
//            }
            Object obj = aMap.get(key);
            if (obj != null) {
                if (obj instanceof String) {
                    mergedABS[index++] = new MergedAB(arrProB[i].key1, arrProB[i].key2, (String) obj, arrProB[i].v2);
                } else if (obj instanceof ArrayList) {
                    List<String> aList = (ArrayList<String>) obj;
                    for (String arr : aList) {
                        mergedABS[index++] = new MergedAB(arrProB[i].key1, arrProB[i].key2, arr, arrProB[i].v2);
                    }
                }
            }

        }
        return mergedABS;
    }

    public MergedAB[] test() {
        ProA a1 = new ProA("alice", "bob", "xx");
        ProA a2 = new ProA("apple", "box", "yy");
        ProA a3 = new ProA("catch", "dog", "zz");
        ProA a4 = new ProA("alice", "bob", "cc");
        ProA[] arrProA = new ProA[]{a1, a2, a3, a4};
        ProB b1 = new ProB("alice", "bob", "oo");
        ProB b2 = new ProB("apple", "bee", "pp");
        ProB b3 = new ProB("coach", "dog", "qq");
        ProB b4 = new ProB("alice", "bob", "ll");
        ProB[] arrProB = new ProB[]{b1, b2, b3, b4};
        return merge(arrProA, arrProB);
    }


    public static void main(String[] args) {
        long before = System.nanoTime();
        One2 one = new One2();
        MergedAB[] mergedABS = one.test();
        for (int i = 0; i < mergedABS.length; i++) {
            if (mergedABS[i] == null) {
                long after = System.nanoTime();
                System.out.println("end:" + (after-before));
                break;
            } else {
                System.out.println(i + 1 + ":" + mergedABS[i].toString());
            }
        }

    }


}
