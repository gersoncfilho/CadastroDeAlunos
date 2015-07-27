package gersoncfilho.udacity.com.cadastrodealunos;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
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
    private Aluno alunoSelecionado;


    public void carregaLista(){
        AlunoDAO dao = new AlunoDAO(this);
        List<Aluno> alunos = dao.getLista();
        listaAlunos = (ListView) findViewById(R.id.lista_alunos);
        ArrayAdapter<Aluno> adapter = new ArrayAdapter<Aluno>(this, android.R.layout.simple_expandable_list_item_1, alunos);
        this.listaAlunos.setAdapter(adapter);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listagem_alunos);

        AlunoDAO dao = new AlunoDAO(this);
        alunos = dao.getLista();
        dao.close();

        int layout = android.R.layout.simple_list_item_1;
        this.carregaLista();

        //cria menu de contexto para a lista de alunos
        registerForContextMenu(listaAlunos);

        listaAlunos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                alunoSelecionado = (Aluno)  adapterView.getItemAtPosition(i);


                return false;
            }
        });

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

    @Override
    protected void onResume() {
        super.onResume();
        this.carregaLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuItem ligar = menu.add("Ligar");
        ligar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                return false;
            }
        });

        MenuItem enviarSms = menu.add("Enviar SMS");
        enviarSms.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });

        MenuItem acharMapa =  menu.add("Achar no mapa");
        acharMapa.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });

        MenuItem navegar = menu.add("Navegar no site");
        navegar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });

        final MenuItem deletar = menu.add("Deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                new AlertDialog.Builder(ListaAlunosActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Deletar")
                        .setMessage("Deseja mesmo deletar?")
                        .setPositiveButton("Quero",
                                new DialogInterface.OnClickListener(){
                                    public void onClick(DialogInterface dialog, int which){
                                        AlunoDAO dao= new AlunoDAO(ListaAlunosActivity.this);
                                        dao.deletar(alunoSelecionado);
                                        dao.close();
                                        carregaLista();
                                    }

                                }).setNegativeButton("Não", null).show();
                return false;
            }
        });

        MenuItem enviarErmail = menu.add("Enviar email");
        enviarErmail.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });

    }


}
