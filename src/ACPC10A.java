/**
 * @(#)whatsnext.java
 *
 *
 * @author
 * @version 1.00 2015/11/25
 */
 
import java.io.*;
import java.util.*;
 
public class ACPC10A {
 
    public static void main(String[]args)throws java.lang.Exception{
     BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
     StringTokenizer st= new StringTokenizer(bf.readLine());
     int a1 = Integer.parseInt(st.nextToken());
     int a2 = Integer.parseInt(st.nextToken());
     int a3 = Integer.parseInt(st.nextToken());
     while(a1 != 0 || a2 != 0 || a3 != 0){
     	double d1 = a2-a1;
     	double d2 = a3-a2;
     	if(d1 == d2 && d1 != 0)
     		System.out.println("AP " + (int)(a3 + d1) );
     	else
     		System.out.println("GP " + (int)(a3 *(a3/a2)));
        st= new StringTokenizer(bf.readLine());
     	a1 = Integer.parseInt(st.nextToken());
        a2 = Integer.parseInt(st.nextToken());
        a3 = Integer.parseInt(st.nextToken());
 
     }
    }
} 