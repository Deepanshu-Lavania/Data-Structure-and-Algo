package Java3;
class Account{
    public String name;
    protected String email;
    private String Password;
    private String whatsupp;
    
    public void setPassword(String pass,String whatsUpp){
        this.Password=pass;
        this.whatsupp=whatsUpp;
    }
    public String getPassword(){
        String comb = this.Password +" "+ this.whatsupp;
        return comb;
    }
}
public class AccessModif {
    public static void main(String[] args) {
        Account acc1= new Account();
        acc1.name = "Apna School";
        acc1.email="dedeoanshu@gmail.com";
        acc1.setPassword("hello","how are you");
        System.out.println(acc1.getPassword());
    }
}
