class User{

  String username;
  String password;

  User(){
    this.username = "";
    this.password = "";
  }

  User(String name, String pass){
    this.username = name;
    this.password = pass;
  }

  public void setUsername(String name){
    this.username = name;
  }

  public void setPassword(String pass){
    this.password = pass;
  }

  public String getUsername(){
    return this.username;
  }

  public String getPassword(){
    return this.password;
  }

  public boolean checkUserName(String name){

    if (name.length() == this.username.length()){
      for (int i = 0; i < this.username.length(); i++){
        if (name.charAt(i) != this.username.charAt(i)){
          // entry does not match
          return false;
        }
      }

      // every character matches up
      // the length is the also the same
      return true;
    }
    else{
      return false;
    }
  }

  public boolean checkPassword(String pass){

    if (pass.length() == this.password.length()){
      for (int i = 0; i < this.password.length(); i++){
        if (pass.charAt(i) != this.password.charAt(i)){
          return false;
        }
      }
      return true;
    }
    else{
      return false;
    }

  }


}
