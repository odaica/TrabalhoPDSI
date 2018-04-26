
package conexão;

/**
 *
 * @author Tiago
 */

public class Login {
    

    private String Login;
    private String Senha;
    private String Funcao;
    private int ID_Login;

    public Login(String Login, String Senha, String Funcao, int ID_Login) {
        this.Login = Login;
        this.Senha = Senha;
        this.Funcao = Funcao;
        this.ID_Login = ID_Login;
    }
    
    public Login(){
         
    }
    
    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
     public String getFuncao() {
        return Funcao;
    }

    public void setFuncao(String funcao) {
        this.Funcao = funcao;
    }
      public int getID_Login() {
        return ID_Login;
    }

    public void setID_Login(int ID_Login) {
        this.ID_Login = ID_Login;
    }
    
}


