package gersoncfilho.udacity.com.cadastrodealunos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLData;
import java.sql.SQLException;
import java.sql.SQLInput;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

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

    //Método deletar aluno no banco de dados
    public void deletar(Aluno aluno){
        String args[] = {aluno.getId().toString()};
        getWritableDatabase().delete(TABELA, "id=?", args);
    }

    public List<Aluno> getLista(){
        List<Aluno> alunos =  new ArrayList<Aluno>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + TABELA + ";",null);

        while (cursor.moveToNext()){
            Aluno aluno = new Aluno();

            aluno.setId(cursor.getLong(cursor.getColumnIndex("id")));
            aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            aluno.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            aluno.setTelefone(cursor.getString(cursor.getColumnIndex("telefone")));
            aluno.setSite(cursor.getString(cursor.getColumnIndex("site")));
            aluno.setNota(cursor.getDouble(cursor.getColumnIndex("nota")));
            aluno.setCaminhoFoto(cursor.getString(cursor.getColumnIndex("caminhoFoto")));

            alunos.add(aluno);
        }

        cursor.close();

        return alunos;
    }



}
