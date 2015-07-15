package gersoncfilho.udacity.com.cadastrodealunos;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;

/**
 * Created by Gerson on 7/13/2015.
 */
public class AlunoDAO extends SQLiteOpenHelper {

    public static final String DATABASE = "CadastroCaelum";
    public static final String TABELA = "Alunos";
    private static final int VERSAO = 1;

    public AlunoDAO(Context context){
        super(context, DATABASE, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String ddl = "CREATE TABLE " + TABELA + " (id INTEGER PRIMARY KEY, nome TEXT UNIQUE NOT NULL, telefone TEXT, endereco TEXT, site TEXT, nota REAL, caminhoFoto TEXT);";
        database.execSQL(ddl);

    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABELA;
        database.execSQL(sql);
        onCreate(database);
    }

    //Metodo insere alunos no banco de dados
    public void insere(Aluno aluno){
        ContentValues values = new ContentValues();
        values.put("nome", aluno.getNome());
        values.put("endereco", aluno.getEndereco());
        values.put("telefone", aluno.getTelefone());
        values.put("site", aluno.getSite());
        values.put("caminhoFoto", aluno.getCaminhoFoto());
        values.put("nota", aluno.getNota());

        getWritableDatabase().insert(TABELA, null, values);
    }

}
