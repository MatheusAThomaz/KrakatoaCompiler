package ast;

public class TypeNull extends Type {
    
    public TypeNull() {
        super("null");
    }
    
   public String getCname() {
      return "null";
   }

}