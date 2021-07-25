import java.util.ArrayList;
import java.util.Random;



public class Treap {
	

	private static int size;
	private static int average;
	private static node root;
	private static int[] btarr;
	private static int index =0;
	static int checker = 0;
	
	
	public Treap( int s, int avg) {
		size=s;
		average=avg;
		root=null;
		btarr= new int[s];
		index=0;
		checker =0;
	}
	
	public node getRoot() {
		return this.root;
	}
	
	public void setRoot(node n) {
		root=n;
	}
	


	public static void BSTinsert(Treap t, node n) {
		

		node y=null;
		node x= t.getRoot();
		if(t.getRoot()==null) {
			t.setRoot(n);
		}
		while(x!=null){
		
			y=x;
		
			if( n.getKey() < x.getKey() ) {
				x=x.getLeftchild();
			}else {
				x=x.getRightchild();
			}
		
		}
	n.setParent(y);
	if(y==null) {
		t.setRoot(n);
	}else if(n.getKey() < y.getKey() ) {
		y.setLeftchild(n);
	}else {
		y.setRightchild(n);
	}

		
		
	}
	
	public void insert(Treap t, int num) {
		inArr(num);
		double prior = Math.random();
		node m= new node(num, prior);
		//int x =0;
		BSTinsert(t, m);
		if(m.getParent()==null) {//its a root
			return;
		}

		
		
		else{
		
			while(m.getParent()!=null && m.getParent().getPriority()> m.getPriority() ) {
				//System.out.println(x++);
				//printInorder(t.getRoot());
				if(m.getParent()==null) {
					return;
				}
				else {
					
				
					if( m.getParent().getLeftchild() == m && m.getParent().getPriority()> m.getPriority()) {
							RRT(t,m.getParent());
							//x++;
					}
					if(m.getParent()==null) {
						return;
					}
					if( m.getParent().getRightchild() == m && m.getParent().getPriority()> m.getPriority()){
							LRT(t,m.getParent());
							//x++;
					}
				}
			}
			//System.out.println("# of rotations" +x);
		}
	}
	
	
	public void RRT(Treap t,node y){


		node x = y.getLeftchild();
		y.setLeftchild(x.getRightchild());
		
		if(x.getRightchild() != null) {
			x.getRightchild().setParent(y);
		}
		x.setParent(y.getParent());
		if(y.getParent()==null) {
			t.setRoot(x);
		}else if(y== y.getParent().getRightchild()){
			y.getParent().setRightchild(x);
		}else {
			y.getParent().setLeftchild(x);
		}
		x.setRightchild(y);
		y.setParent(x);

	
	}
	
	public void LRT(Treap t,node x ){


		node y=x.getRightchild();
		x.setRightchild(y.getLeftchild());
		
		if(y.getLeftchild() != null) {
			y.getLeftchild().setParent(x);
		}
		y.setParent(x.getParent());
		if(x.getParent() == null) {
			t.setRoot(y);
		}else if(x ==x.getParent().getLeftchild()){
			x.getParent().setLeftchild(y);
		}else {
			x.getParent().setRightchild(y);
		}
		y.setLeftchild(x);
		x.setParent(y);
		

		
	}
	
	
	public node search(node root, int x){
		node n= root;
		if(n == null || n.getKey() == x)
			return n;
		
		if( x < n.getKey() )  {
			return search(n.getLeftchild(), x);
		}else {
			return search(n.getRightchild(), x);
		}
		
	}
	
	public node max(Treap t, node n){
		
		node x=n;
		while (x.getRightchild() != null) {
			x=x.getRightchild();
		}
		return x;
	}
	
	public node min(Treap t, node n){
		
		node x=n;
		while (x.getLeftchild() != null) {
			x=x.getLeftchild();
		}
		return x;
	}
	

	public node successor(Treap t,node n){
		node x= n;
		if(x.getRightchild()!=null) {
			return t.min(t,x.getRightchild());
		}
		node y = x.getParent();
		while(y != null && x==y.getRightchild()) {
			x=y;
			y=y.getParent();
		}
		return y;
	}
	
	public node predecessor(Treap t, node n){
		node x= n;
		if(x.getLeftchild()!=null) {
			return t.max(t, x.getLeftchild());
		}
		node y=t.getRoot();
		node pred = null;
		while(y != null){
			if(y.getKey()==x.getKey()) {
				break;
			}
			if(y.getKey()<x.getKey()) {
				pred =y;
				y = y.getRightchild();
			}
			else {
				y=y.getLeftchild();
			}
		}
			return pred;
		}
	
	public void delete(Treap t, int x) {
		node n = search( t.getRoot(), x);
		
		
		if(n==null) {
			return;
		}
		if(n==t.getRoot()) {
			if(n.getLeftchild()==null && n.getRightchild()!=null) {
				t.LRT(t, n);
			}else if(n.getLeftchild()!=null && n.getRightchild()==null) {
				t.RRT(t, n);
			}
//			else {
//				t.LRT(t, n);
//			}
		}
		
		

		while(n.getRightchild() != null || n.getLeftchild( )!= null) {//while not leaf rotate leaf node till leaf then remove
			if(n.getLeftchild()!=null) {
				t.RRT(t, n);
			}else if(n.getRightchild()!=null) {
				t.LRT(t, n);
			}
	
		}
		//node np = n.getParent();
		if(n.getLeftchild()==null && n.getRightchild()==null){ //if leaf
		
			if(n.getParent().getLeftchild() ==n) {
				n.getParent().setLeftchild(null);
			}else if(n.getParent().getRightchild() ==n){
				n.getParent().setRightchild(null);
			}
		}

	}

	public static void bstToArr(node n) {
		   if(root == null){  
	              
	            return;  
	        }else {
	        	 if(n.getLeftchild() != null) {
	                 bstToArr(n.getLeftchild());  
	        	 }
	        	 btarr[index]=n.getKey();
	        	 index++;
	        	 if(n.getRightchild() !=null) {
	        		 bstToArr(n.getRightchild());  
	        	 }
	        }
	}
	
	public static void inArr(int x) {
		btarr[index]=x;
		index++;

	}
	
	public static void printArray() {
		System.out.print("[");
		for(int i=0; i<btarr.length-1; i++) {
			System.out.print(btarr[i] + ", "); 
		}
		System.out.print(btarr[btarr.length-1] + "]");
		System.out.println("");
	}
	
	public void printInorder(node n){
		if(n ==null) {
			return;
		}
		
//		printInorder(n.getLeftchild());
//    	System.out.println("key:" +n.getKey() + " priority:" + n.getPriority());
//		
//	    printInorder(n.getRightchild());

 
        /* first print data of node */
        //System.out.print(n.getKey() + " ");
 
		
        /* then recur on left sutree */
        printInorder(n.getLeftchild());
 
        /* now recur on right subtree */
        printInorder(n.getRightchild());
        System.out.print(n.getKey() + " ");

	}

	
	public static void subarrays(int n, int k) {
		
		double sum=0;
		int avg =k;
//		if(btarr[0]>=avg) {
//			System.out.println(btarr[0]+" , ");
//		}
		for(int i=0; i<btarr.length;i++) {
			
			for(int j=i; j<=btarr.length;j++) {
				
				for(int m=i; m<j;m++) {
					sum+=btarr[m];
						
					
					
					//System.out.print(btarr[m]+ " ");
						
				}
				printsubarray(j,i,sum, avg);
				

				sum=0;
			}
			
		}
		if(checker==0) {
			System.out.println("There are no valid subarrays for input " + size+ ", " + average);
		}else {
			System.out.print("Are the valid subarrays for input "+ size+ ", " + average);
		}
	}

	private static void printsubarray(int j, int i, double sum, int avg) {
		if((sum/(j-i)) >= avg) {
			checker++;
			
			System.out.print("[");
			for(int x=i; x<=j-2; x++) {
				System.out.print(btarr[x]+ ", ");
			}
			System.out.print(btarr[j-1]+ "]");
			System.out.println();	
		}
		
		
		
	}


	
	

	



	
//	public void printPreorder(node node)
//	{
//	    if (node == null){
//	       // node.printNode();
//	        return;
//	    }
//	    //node.printNode();
//	    printPreorder(node.getLeftchild());
//	    printPreorder(node.getRightchild());
//		
//	}
	

	
	
}
