package defaultMethod;

import java.lang.Iterable;

interface Parser{   
    default void parse(){
        System.out.println("default Parsing logic");
    }
    
    void test();
}

class TextParser implements Parser{ 
    // No compile time error, because parse is default method
    //inherit default implementation of parse
	
	public void test(){}
}

public class XMLParser implements Parser{
   
    @Override
    public void parse(){
        System.out.println("Parsing XML files");
    }
   
    public void test(){}
    
    public static void main(String args[]){
        Parser p = new TextParser();
        p.parse();
       
        p = new XMLParser();
        p.parse();
    }
}