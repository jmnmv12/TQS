import  java.util.*;
public class TqsStack {

    private ArrayList<Integer> stack;

    public TqsStack(){
        stack=new ArrayList<Integer>();
    }

    public boolean push (int x){
        stack.add(x);
        return true;
    }

    public  int pop(){
        if (stack.size()==0){
            throw new NoSuchElementException();
        }

        return stack.remove(stack.size()-1);

    }

    public int peek(){
        if (stack.size()==0){
            throw new NoSuchElementException();
        }
        return stack.get(stack.size()-1);
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        if (stack.size()==0){
            return  true;
        }
        return false;
    }
}
