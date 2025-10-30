import java.util.*;
class DynamicArray{
    Object[] arr ;
    int count;
    DynamicArray(int size){ // Allocate size of array
        arr = new Object[size];
        count=0;
    }
    void add(int data){ // add elements at end
        if(count == arr.length){
            Object[] newArr = new Object[arr.length * 2];
            for(int i=0;i<arr.length;i++){
                newArr[i] =  arr[i];
            }
            arr =newArr;
        }
        arr[count++]=data;
    }
    void add(int index, int data){ // add element at given index
        if(index > count && index < 0) throw new ArrayIndexOutOfBoundsException("Index "+index+" is out of bounds" );
        else{
            if(count == arr.length){
                Object[] newArr = new Object[arr.length*2];
                for(int i=0;i<arr.length;i++){
                    newArr[i] = arr[i];
                }
                arr=newArr;
            }
            for(int i = count ; i > index ; i--){
                arr[i]=arr[i-1];
            }
            arr[index]=data;
            count++;
        }
    }
    void set(int index,int data){ // update value at provided index 
        if(index >= count || index < 0){
            throw new ArrayIndexOutOfBoundsException("Index "+index +" is out of bounds");
        }
        else{
            arr[index]=data;
        }
    }
    Object get(int index){ // get element by index
        if(index > count || index <0){
            throw new ArrayIndexOutOfBoundsException ("Index " + index + " is out of bounds");
        }else{
            return arr[index];
        }
    }
    int size(){
        return count;
    }
    void remove(int index){ // remove by index
        if(index >= count || index < 0){
            throw new ArrayIndexOutOfBoundsException("Index "+index+" is out of bounds");
        }else{
            for(int i = index ; i < count-1 ; i++){
                arr[i]=arr[i+1];
            }
            count--;
        }
    }
    void remove(Object data){ // remove by value
        for(int i=0;i<count;i++){
            if(arr[i].equals(data)){
                remove(i);
                break;
            }
        }
    }
    void clear(){ // clear the array by crating new array and resetting count
        arr = new Object[arr.length];
        count=0;    
    }
    boolean isEmpty(){ // check if array is empty
        return count == 0;
    }
    boolean contains(Object data){ // check if array contains given value
        for(int i=0;i<count;i++){
            if(arr[i].equals(data)){
                return true;
            }
        }
        return false;
    }
    void print(){ // print the array
        System.out.println("[");
        for(int i=0;i<count;i++){
            System.out.println(arr[i]+",");
        }
        System.out.println("]");
    }
    
}
public class Main{
    public static void main(String[] args){
        Scanner s  = new Scanner(System.in);
        System.out.print("Enter initial size of Dynamic Array: ");
        int size = s.nextInt();
        System.out.println("Dynamic Array of size " + size + " created");
        DynamicArray da = new DynamicArray(size);
        da.add(10);
        da.add(20);

        da.add(1,15);
        da.print(); // [10,15,20]   

        da.set(1,17);
        da.print(); // [10,17,20]

        System.out.println(da.get(2)); // 20
        System.out.println(da.size()); // 3 

        da.remove(1);
        da.print(); // [10,20]

        da.add(30);
        da.add(40);

        da.print(); // [10,20,30,40]
        da.remove((Object)20);

        da.print(); // [10,30,40]
        
        System.out.println(da.isEmpty()); // false
        System.out.println(da.contains(30)); // true

        da.clear();
        da.print(); // []
    }
}