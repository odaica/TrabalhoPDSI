    package conexão;

 
import funcionarios.funcionarios;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.util.ArrayList;
    import java.util.logging.Level;
    import java.util.logging.Logger;
    import javax.swing.JOptionPane;
import javax.swing.JProgressBar;


    public class Users {

        funcionarios Fun = new funcionarios();
        ArrayList<funcionarios> Func = new ArrayList<>();
        ConexaoBD connection = new ConexaoBD();
         JProgressBar bar = new JProgressBar();

        public void listarLogin(String nome, String senha, String Funcao) {
            try {
                connection.Conexao();
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "aqui Conexão errada !");

            }

            Login obj = new Login();

            switch (Funcao) {
                case " ":
                    JOptionPane.showMessageDialog(null, " Há campos não preenchidos !");
                    new TeladeLogin();
                    break;
                case "Administrador": {
                    try {
                        connection.Conexao();
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Conexão errada !");
                    }
                    String cmd = "select f.Funcao, f.Login, f.Senha from  funcionarios f where Funcao='" + Funcao + "'and Login='" + nome + "' and Senha='"+senha+"'";
                    Statement stmt;
                    ResultSet dados = null;
                    try {
                        stmt = connection.con.prepareStatement(cmd);

                        dados = stmt.executeQuery(cmd);

                        while (dados.next()) {
                  
                            obj.setLogin(dados.getString("Login"));
                            obj.setSenha(dados.getString("Senha"));
                            obj.setFuncao(dados.getString("Funcao"));

                        }

                        if (nome.equals(obj.getLogin()) && senha.equals(obj.getSenha()) && Funcao.equals(obj.getFuncao())) {
           
                           // new PrincipalADM().setVisible(true);

                        } else if (!nome.equals(obj.getLogin()) && !senha.equals(obj.getSenha())) {
                            JOptionPane.showMessageDialog(null, "Login/Senha/Funcao Incorretos !" +obj.getLogin());

                            new TeladeLogin().setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Login/Senha/Funcao Incorretos !");
                            new TeladeLogin().setVisible(true);
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    connection.Desconecta();
                    break;
                }
                case "Atendente": {
                    try {
                        connection.Conexao();
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Conexão errada !");
                    }
                    String cmd = "f.Funcao, f.Login, f.Senha from  funcionarios f where Funcao='" + Funcao + "'and Login='" + nome + "' and Senha='"+senha+"'";

                    Statement stmt;
                    ResultSet dados = null;
                    try {
                        stmt = connection.con.prepareStatement(cmd);

                        dados = stmt.executeQuery(cmd);

                        while (dados.next()) {
           
                            obj.setLogin(dados.getString("Login"));
                            obj.setSenha(dados.getString("Senha"));
                            obj.setFuncao(dados.getString("Funcao"));

                        }

                        if (nome.equals(obj.getLogin()) && senha.equals(obj.getSenha())&& Funcao.equals(obj.getFuncao())) {
                            /*new PrincipalAtendente().setVisible(true);*/
                           

                        } else if (!nome.equals(obj.getLogin()) && !senha.equals(obj.getSenha())) {
                            JOptionPane.showMessageDialog(null, "Login/Senha/Funcao Incorretos !");

                            new TeladeLogin().setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Login/Senha/Funcao Incorretos !");
                            new TeladeLogin().setVisible(true);
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    connection.Desconecta();
                    break;
                    
                }case "Master": {
                    try {
                        connection.Conexao();
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, "Conexão errada !");
                    }
                    String cmd = "select f.Funcao, f.Login, f.Senha from  funcionarios f where Funcao='" + Funcao + "'and Login='" + nome + "' and Senha='"+senha+"'";

                    Statement stmt;
                    ResultSet dados = null;
                    try {
                        stmt = connection.con.prepareStatement(cmd);

                        dados = stmt.executeQuery(cmd);

                        while (dados.next()) {
           
                            obj.setLogin(dados.getString("Login"));
                            obj.setSenha(dados.getString("Senha"));
                            obj.setFuncao(dados.getString("Funcao"));

                        }

                        if (nome.equals(obj.getLogin()) && senha.equals(obj.getSenha())&& Funcao.equals(obj.getFuncao())) {
                            //new CadastrarADM().setVisible(true);

                        } else if (!nome.equals(obj.getLogin()) && !senha.equals(obj.getSenha())) {
                            JOptionPane.showMessageDialog(null, "Login/Senha/Funcao Incorretos !");

                            new TeladeLogin().setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Login/Senha/Funcao Incorretos !");
                            new TeladeLogin().setVisible(true);
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    connection.Desconecta();
                    break;
                }
            }
            }
        
    }
