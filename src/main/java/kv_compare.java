/**
 * Created by yuanzhuo on 2017/1/16.
 */
public class kv_compare implements Comparable<kv_compare>{
    public Double weight;
    public String tag;

    public kv_compare(String tag, Double weight){
        this.tag = tag;
        this.weight = weight;
    }

    public kv_compare(){
        this.tag = "";
        this.weight = 0.0;
    }

    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public Double getWeight() {
        return weight;
    }

    public int compareTo(kv_compare o) {
        return weight > o.weight ? 1 : 0;
    }
}
