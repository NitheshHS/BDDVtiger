package practice;

import java.util.ArrayList;
import java.util.List;

public class ListRef {
	public static void main(String[] args) {
		List<List<String>> list=new ArrayList<List<String>>();
		List<String> l1=new ArrayList<String>();
		l1.add("Nithesh");
		l1.add("ATE");
		l1.add("BDD");
		list.add(l1);
		List<String> l2=new ArrayList<String>();
		l2.add("Pradeep");
		l2.add("Deveops");
		list.add(l2);
		
		System.out.println(list);
		System.out.println(list.get(1).get(0));
	}

}
