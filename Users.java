public class Users {
   private String Username;
  private  String email;
  private  String password;
  private int score;

    public Users(String Username, String email,String password,int score){
        this.Username=Username;
        this.email=email;
        this.password=password;
        this.score=score;
    }
    public void setname(String username){
        this.Username=Username;
    }
    public String getname(){
        return Username;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getemail(){
        return email;
    }
    public String getpassword(){
        return password;
    }
    public void setpassword(String password){
        this.password=password;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }

}
