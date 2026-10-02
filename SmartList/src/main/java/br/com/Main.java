package br.com;

import br.com.controller.ListaDeComprasController;
import br.com.model.ListaDeCompras;
import br.com.view.ListaDeComprasView;


public class Main {
    public static void main(String[] args) {
        ListaDeCompras model = ListaDeCompras.getInstancia();
        ListaDeComprasView view = new ListaDeComprasView();
        ListaDeComprasController controller = new ListaDeComprasController(model, view);

        controller.iniciar();
    }
}

