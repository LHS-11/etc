package chapter1.check1;

public class Person {

//    private Phone[] phones;
//
//    public Person(){
//        phones = new Phone[2];
//    }
//
//    public Phone getPhone(int i){
//        if(i==0 || i==1) {
//            return phones[i];
//        }
//        return null;
//    }


    private Phone homePhone;
    private Phone officePhone;

    public void setHomePhone(Phone phone){
        this.homePhone = phone;
    }

    public void setOfficePhone(Phone phone){
        this.officePhone = phone;
    }

    public Phone getHomePhone(){
        return this.homePhone;
    }

    public Phone getOfficePhone(){
        return this.officePhone;
    }
}
