package myproject.vm;

public enum BytecodeEnum {

	IADD("iadd", 0),
	ISUB("isub", 0),
	IMUL("imul", 0),
	ILT("ilt", 0),
	IEQ("ieq", 0),
	BR("br", 1),
	BRT("brt", 1),
	BRF("brf", 1),
	ICONST("iconst", 1),
	LOAD("load", 1),
	GLOAD("gload", 1),
	STORE("store", 1),
	GSTORE("gstore", 1),
	PRINT("print", 0),
	POP("pop", 0),
	HALT("halt", 0)
	;
	
	private String name;
	
	private int n;
	
	BytecodeEnum(String name, int n) {
		this.name = name;
		this.n = n;
	}
	
}
