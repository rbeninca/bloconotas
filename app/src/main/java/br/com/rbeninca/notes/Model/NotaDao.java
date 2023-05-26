package br.com.rbeninca.notes.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotaDao {
    SQLiteDatabase db;

    public  NotaDao(Context context){
        db=context.openOrCreateDatabase("db",Context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, texto VARCHAR)");
    }
    public void salvar(Nota nota){
        db.execSQL("INSERT INTO notas (titulo,texto) VALUES ('"+nota.getTitulo()+"','"+nota.getTexto()+"')");
    }
    public void alterar(Nota nota){
        db.execSQL("UPDATE notas SET titulo='"+nota.getTitulo()+"', texto='"+nota.getTexto()+"' WHERE id="+nota.getId());
    }
    public void excluir(Nota nota){
        db.execSQL("DELETE FROM notas WHERE id="+nota.getId());
    }
    public Nota consultar(Integer id){
        return null;
    }
    public ArrayList<Nota> notas(){
        ArrayList<Nota> notas=new ArrayList<>();
        Cursor cursor=db.rawQuery("SELECT * FROM notas",null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Nota nota=new Nota(cursor.getInt(0),cursor.getString(1),cursor.getString(2));
            notas.add(nota);
            cursor.moveToNext();
        }
        return notas;
    }

    public Nota getNota(Integer id){
        Cursor cursor=db.rawQuery("SELECT * FROM notas WHERE id="+id,null);
        cursor.moveToFirst();
        Nota nota=new Nota(cursor.getInt(0),cursor.getString(1),cursor.getString(2));
        return nota;
    }
}
