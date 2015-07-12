package gersoncfilho.udacity.com.cadastrodealunos;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Created by gersoncardosofilho on 7/12/15.
 */
public class FormularioHelper {
    private EditText nome;
    private EditText telefone;
    private EditText endereco;
    private EditText site;
    private SeekBar nota;
    private String caminhoFoto;
    private ImageView fotoAluno;


    private Aluno aluno;

    public FormularioHelper(FormularioActivity activity){
        this.nome = (EditText) activity.findViewById(R.id.txtNome);
        this.telefone = (EditText) activity.findViewById(R.id.txtTelefone);
        this.endereco = (EditText) activity.findViewById(R.id.txtEndereco);
        this.site = (EditText) activity.findViewById(R.id.txtSite);
        this.fotoAluno = (ImageView) activity.findViewById(R.id.fotoAluno);
        this.nota = (SeekBar) activity.findViewById(R.id.seekNota);


        this.aluno = new Aluno();
    }

    public Aluno pegaAlunoDoFormulario(){
        aluno.setNome(nome.getText().toString());
        aluno.setEndereco(endereco.getText().toString());
        aluno.setTelefone(telefone.getText().toString());
        aluno.setSite(site.getText().toString());
        aluno.setNota(Double.valueOf(nota.getProgress()));

        return aluno;
    }


}
