package mycollections.generics;
import java.util.Iterator;


// T is generic i.e it can be of any form, it's similar to T class in C++
// the compiler will automatically replace T with the datatype when create object of OurGenericList in other classess
public class OurGenericList<T> implements Iterable<T>{
    private  T[] items;
    private int size;

    OurGenericList(){
        size = 0;
        items = (T[]) new Object[100]; // this create an array of T type of size 100
    }

    void add(T element){
        items[size] = element;
        size++;
    }

    T get(int index){
        return items[index];
    }

    @Override
    public Iterator<T> iterator(){
        return  new OurGenericListIterator(this);
    }

    int size(){
        return size;
    }


    private class OurGenericListIterator implements Iterator<T>{
        
        private OurGenericList<T> list;
        private  int index = 0;
        OurGenericListIterator(OurGenericList<T> list){
            this.list = list;
        }

        @Override
        public boolean hasNext(){
            if(index < list.size()){
                return true;
            }
            return false;
        }


        @Override
        public T next(){
            // T item = list.get(index); 
            T item = list.items[index];  // this will also work since is OurGenericListIterator private class of OurGenericList
            index++;
            return  item;
        }
    }
}