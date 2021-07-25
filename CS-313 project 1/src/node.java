
public class node {
	
	private int key;
	private double priority;
	private node leftchild;
	private node rightchild;
	private node parent;
	
	
	
	 node(int key, double priority){
		this.key=key;
		this.priority = priority;
		this.leftchild = null;
		this.rightchild = null;
		this.parent = null;
	 }
	 
	public node(int key, int priority, node leftchild, node rightchild, node parent) {
		super();
		this.key = key;
		this.priority = priority;
		this.leftchild = leftchild;
		this.rightchild = rightchild;
		this.parent = parent;
	}
	

	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	
	
	
	
	public double getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
		
	}
	
	
	public node getLeftchild() {
		return leftchild;
	}
	public void setLeftchild(node leftchild) {
		this.leftchild = leftchild;
	}
	
	
	public node getRightchild() {
		return rightchild;
	}
	public void setRightchild(node rightchild) {
		this.rightchild = rightchild;
	}
	
	
	public node getParent() {
		return parent;
	}
	public void setParent(node parent) {
		this.parent = parent;
	}
	
	
	public String toString() {
		return "key: " + key + " priority:" + Math.random();
	}
	
	//for node class
//	public void printNode() {
//
//	    if(this.getRightchild() == null && this.getLeftchild()==null){
//	        System.out.println("("+this.getKey()+","+this.getPriority()+",NULL,-1,NULL,-1)");
//	    }
//	    if(this.getLeftchild()==null){
//	        System.out.println("("+this.getKey()+","+this.getPriority()+","+",NULL,-1,"+this.getRightchild().getKey()+","+this.getRightchild().getPriority()+")");
//	    }
//	    if(this.getRightchild()==null){
//	        System.out.println("("+this.getKey()+","+this.getPriority()+",NULL,-1,"+this.getLeftchild().getKey()+","+this.getLeftchild()+",NULL,-1");
//	    }
//	}
	
	
	
}
