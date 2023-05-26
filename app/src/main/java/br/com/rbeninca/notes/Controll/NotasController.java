package br.com.rbeninca.notes.Controll;

import android.content.Context;

import br.com.rbeninca.notes.Model.Nota;
import br.com.rbeninca.notes.Model.NotaDao;

public class NotasController {
    NotaDao notaDao;
    public  NotasController(Context c){
        notaDao = new NotaDao(c);

    }
    public  void criaNota(Nota nota){
        notaDao.salvar(nota);
    }
    public  void atualizaNota(Nota nota){
        notaDao.alterar(nota);
    }
    public  void deletaNota(Nota nota){
        notaDao.excluir(nota);
    }
    public  Nota getNota(Integer id){
        return notaDao.getNota(id);
    }


}
