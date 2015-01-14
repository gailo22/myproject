package myproject.parentchild;


public class ParentChildAssociation {

	public static void main(String[] args) {

		ParentChildModel<YModel> model1 = new ParentChildModelImpl<>();
		ParentChildModel<YModel> model2 = new ParentChildModelImpl<>();
		ParentChildModel<YModel> model3 = new ParentChildModelImpl<>();
		
		A a = new A();
		B b = new B();
		C c = new C();
		
		model1.add(a);
		model1.add(b);
		model1.add(c);
		
		model2.add(a);
		model2.add(b);
		model2.add(c);
		
		model3.add(a);
		model3.add(b);
		model3.add(c);
		
	    a.setModel(model1);
	    b.setModel(model2);
	    c.setModel(model3);
	    
	    
		System.out.println("a parent: " + a.getParent());
		System.out.println("a child: " + a.getChild());
		
		System.out.println("b parent: " + b.getParent());
		System.out.println("b child: " + b.getChild());
		
		System.out.println("c parent: " + c.getParent());
		System.out.println("c child: " + c.getChild());
		System.out.println("c parent parent: " + c.getParent().getParent());

	}

}
