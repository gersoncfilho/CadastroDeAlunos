package gersoncfilho.udacity.com.cadastrodealunos;

/**
 * Created by gersoncardosofilho on 7/12/15.
 */
public class Aluno {
    private Long id;
    private String nome;
    private String telefone;
    private String endereco;
    private String site;
    private String caminhoFoto;
    private Double nota;


    //Getters
    public String getNome(){
        return nome;
    }

    public String getEndereco(){
        return endereco;
    }

    public String getTelefone(){
        return telefone;
    }

    public String getSite(){
        return site;
    }

    public String getCaminhoFoto(){
        return caminhoFoto;
    }

    public Double getNota(){
        return nota;
    }


    //Setters
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public void setSite(String site){
        this.site = site;
    }

    public void setNota(Double nota){
        this.nota = nota;
    }

    public void setCaminhoFoto(String caminhoFoto){
        this.caminhoFoto = caminhoFoto;
    }



}
