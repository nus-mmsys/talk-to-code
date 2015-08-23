package ast;
import java.util.*;

public class ASTExpressionUnitValueArray extends ASTExpressionUnitValue{
	private static final String NODE_TYPE = "Array";
	private ArrayList<ASTExpressionUnitValue> entries;
	private int size;
	
	
	public ASTExpressionUnitValueArray(){
		super();
		initialize();
	}
	public ASTExpressionUnitValueArray(ASTNode a) {
		super(a);
		initialize();
	}
	public ASTExpressionUnitValueArray(String value){
		super();
		initialize();
		this.entries.add(new ASTExpressionUnitValue(value));
		size = this.entries.size(); 
	}
	public ASTExpressionUnitValueArray(ArrayList<String> value){
		super();
		initialize();
		for(int index = 0;index<value.size();index++){
			this.entries.add(new ASTExpressionUnitValue(value.get(index)));
		}
		size = this.entries.size(); 
	}
	public ASTExpressionUnitValueArray(String[] value){
		super();
		initialize();
		for(int index = 0;index<value.length;index++){
			this.entries.add(new ASTExpressionUnitValue(value[index]));
		}
		size = this.entries.size(); 
	}
	private void initialize() {
		this.entries = new ArrayList<ASTExpressionUnitValue>();
		this.size = entries.size();
	}
	public String typeof(){
		return super.typeof()+"->"+NODE_TYPE;
	}
	
	public String print() {
		result = "";
		result += "{";
		int index = 0;
		for(;index<size-1;index++){
			result+= this.entries.get(index).print();
			result+= ", ";
		}
		result+= this.entries.get(index).print();
		result += "}";
		if(this.isQuoted) {
			this.result = quote(this.result);
		}
		if(this.isEnd){
			this.result = end(this.result);
		}
		return this.result;
	}
}
