package tests;
import DList.DList;
import DList.DListNode;
import Constants.Constants;
import java.util.Iterator;
import java.util.ListIterator;
public class DListTest{
	public static void main(String[] args){
      test_node();
    }
    public static void test_node(){
		DList<Integer> d = new DList<Integer>();
		d.push(1);
		d.push(2);
		d.push(3);
		d.push(4);
		d.push(5);
		d.push(6);
		d.push(7);
		d.push(8);
		d.push(9);
		d.push(10);
        DListNode<Integer> n = d.front();
        while (n!=null){
          if (n.item()==5){
            n.remove();
          }
          n=n.next();
        }
        n = d.front();
        while (n!=null){
          Constants.print(n.item());
          n=n.next();
        }
    }
	public static void test_iter(){
		DList<Integer> d = new DList<Integer>();
		d.push(1);
		d.push(2);
		d.push(3);
		d.push(4);
		d.push(5);
		d.push(6);
		d.push(7);
		d.push(8);
		d.push(9);
		d.push(10);
		ListIterator<Integer> i;
		for (i=(ListIterator<Integer>)d.iterator();i.hasNext();){
			int curr = i.next();
			Constants.print(curr);
		}
		for (;i.hasPrevious();){
			int curr = i.previous();
			Constants.print(curr);
		}
		for (i=(ListIterator<Integer>)d.iterator();i.hasNext();){
			int curr = i.next();
			if (curr%2==1){
				i.remove();
			}
		}
		Constants.print(d);
		for (i=(ListIterator<Integer>)d.iterator();i.hasNext();){
			Constants.print(i.nextIndex());
			i.next();
		}
		for (i=(ListIterator<Integer>)d.iterator();i.hasNext();){
			i.add(i.nextIndex()+1);
			i.next();
		}
		for (i=(ListIterator<Integer>)d.iterator();i.hasNext();){
			int curr = i.next();
			i.set(curr*curr);
		}
		Constants.print(d);
	}
}
