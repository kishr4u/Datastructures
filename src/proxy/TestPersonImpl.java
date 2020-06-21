package proxy;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class TestPersonImpl implements TestPerson{

    @Override
    public String getPersonName(){
        System.out.println("Person in Impl Invoked");
        return " Person in Impl ";
    }

    public Boolean getPersonBool(){
        System.out.println("Person in Impl Invoked");
        return false;
    }

    public Boolean getPersonBool2(Object a){
        System.out.println("Person in Impl Invoked :"+ a.toString());
        return false;
    }
}
