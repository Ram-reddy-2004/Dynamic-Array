import java.util.Scanner;
class Sum{
private int a ;
private int b;
Sum(int a,int b){
this.a=a;
this.b=b;
}
void sum(){
int sum=a+b;
System.out.println("a : "+a+" b : "+b+"Sum is : "+sum);
}
}
public class Test{
public static void main(String[] args){
Scanner scaner=new Scanner(System.in);
int a = scaner.nextInt();
int b=scaner.nextInt();
Sum s = new Sum(a,b);
s.sum();
}
}
