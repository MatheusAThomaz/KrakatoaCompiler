package ast;

public class InstanceVariable extends Variable {

    public InstanceVariable( String name, Type type ) {
        super(name, type);
    }
    
    public void genKra(PW pw)
    {
        pw.printIdent("private ");
        super.genKra(pw);
        pw.println(";");
    }

}