package gersoncfilho.udacity.com.cadastrodealunos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ListaAlunosActivity extends Activity {

    private ListView listaAlunos;
    private List<Aluno> alunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem_alunos);

        AlunoDAO dao = new AlunoDAO(this);
        alunos = dao.getLista();
        dao.close();

        int layout = android.R.layout.simple_list_item_1;
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, layout, alunos);
        listaAlunos = (ListView) findViewById(R.id.lista_alunos);
        listaAlunos.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lista_alunos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.``
        switch (item.getItemId()) {
            case R.id.menu_novo:
                Intent intent = new Intent(this,FormularioActivity.class);
                startActivity(intent);
                return false;

            default:
                return super.onOptionsItemSelected(item);


        }
    }
}
