package classloader;

public class TestStaticCode {  
	 static TestStaticCode tsc = new TestStaticCode(); 
    static{  
        System.out.println("4");  
    }  
     
    InstanceVariable iv = new InstanceVariable();  
      
    public  TestStaticCode(){  
        System.out.println("3");  
    }  
    public static void main(String[] args){      
    
    }  
}  
  
  
  
 class InstanceVariable {  
    static{  
        System.out.println("1");  
    }  
    public InstanceVariable(){  
        System.out.println("2");  
    }  
}  
