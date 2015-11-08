package myproject.parentchild;

public abstract class YModel implements XModel<YModel> {

	ParentChildModel<YModel> model;
	
	public ParentChildModel<YModel> getModel() {
		return model;
	}

	public void setModel(ParentChildModel<YModel> model) {
		this.model = model;
		model.setCurrent(this);
	}

	@Override
	public YModel getParent() {
		return model.getParent();
	}

	@Override
	public YModel getChild() {
		return model.getChild();
	}

}
