package GenericTrees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GenericTreeBasic {

    static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }




    public static void main(String[] args) {
        FastScanner in=new FastScanner();
        int n =in.nextInt();
        int[] arr = in.readArray(n);
        Node root = null;
        Stack<Node> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == -1){
                stack.pop();
            }
            Node temp = new Node();
            temp.data = arr[i];

            if(stack.size() > 0){
                stack.peek().children.add(temp);
            }else {
                root = temp;
            }

            stack.push(temp);
        }







    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + ", ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    static void sort(int[] a) {
        ArrayList<Integer> l=new ArrayList<>();
        for (int i:a) l.add(i);
        Collections.sort(l);
        for (int i=0; i<a.length; i++) a[i]=l.get(i);
    }

    static void reverse(int a[])
    {
        int n = a.length;
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        for(int i=0; i<b.length; i++){
            a[i] = b[i];
        }
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }


}