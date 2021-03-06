/*
*   Caio Henrique Giacomelli - 620297
*   Matheus Augusto Thomaz   - 620297
*/


 package ast;

import java.util.ArrayList;

/*
 * Krakatoa Class
 */
public class KraClass extends Type {
	
   public KraClass( String name ) {
      super(name);
      publicMethodList = new ArrayList();
      instanceVar = new ArrayList();
   }
   
   public String getCname() {
      return getName();
   }
   
   public void genKra(PW pw)
   {
      pw.print("class " + this.getCname() + " ");
      if (this.superclass != null) pw.println("extends " + this.superclass.getCname() + " {");
      else pw.println("{");
      pw.println("");
      
      pw.add();
      
      for(InstanceVariable inst : this.getInstanceVar())
      {
          inst.genKra(pw);
      }
      
      for(MethodDec method : this.getPublicMethodList())
      {
          method.genKra(pw);
      }
      
      pw.println();
      
      
      pw.sub();
      pw.println("}");
      pw.println();
   }

    public KraClass getSuperclass() {
        return superclass;
    }

    public InstanceVariableList getInstanceVariableList() {
        return instanceVariableList;
    }

    public ArrayList<MethodDec> getPublicMethodList() {
        return publicMethodList;
    }

    public ArrayList<InstanceVariable> getInstanceVar() {
        return instanceVar;
    }
   
   boolean isSubclasOf(Type other) {
        KraClass current = this;
        while( current != other)
        {
            current = current.getSuperClass();
            
            if(current == null)
            {
                return false;
            }
        }
        return true;
    }
    
   public KraClass getSuperClass() {
       return superclass;
   }
    
   public void setSuperClass(KraClass superclass) {
       this.superclass = superclass;   
   }
   
   public void addMethod(MethodDec aMethod){
       publicMethodList.add(aMethod);
   }
   
   public MethodDec searchPublicMethod(String methodName) {
        for (MethodDec m : this.publicMethodList){
            
            if (m.getName().equals(methodName)){
                return m;
            }
        }

       return null;
   }
   
   public MethodDec searchSuperMethod(String methodName){
       
        KraClass k = this.superclass;
        while (k != null){
            for (MethodDec m : k.publicMethodList){
                if (m.getName().equals(methodName)){
                     return m;
                 }
            }
 
            k = k.superclass;
        }
        return null;
   }
   
   public void addInstanceVariable(InstanceVariable instanceVariable) {
       this.instanceVar.add(instanceVariable);
   }
   
   private String name;
   private KraClass superclass;
   private InstanceVariableList instanceVariableList;
   private ArrayList<MethodDec> publicMethodList;
   private ArrayList<InstanceVariable> instanceVar;
   // private MethodList publicMethodList, privateMethodList;
   // m�todos p�blicos get e set para obter e iniciar as vari�veis acima,
   // entre outros m�todos

  






}
