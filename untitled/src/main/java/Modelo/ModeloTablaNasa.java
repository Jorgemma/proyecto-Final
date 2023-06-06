package Modelo;

import Persistencia.NasaDao;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaNasa implements TableModel {
    public static final int columnas = 6;
    private ArrayList<Nasa> datos;
    private NasaDao ldao;
    public ModeloTablaNasa() {
        ldao = new NasaDao();
        datos = new ArrayList<>();
    }

    public ModeloTablaNasa(ArrayList<Nasa> datos) {
        ldao = new NasaDao();
        this.datos = datos;

    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas;
    }

    @Override
    public String getColumnName(int RowIndex) {
        switch (RowIndex) {
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Fecha";
            case 3:
                return "Funcion";
            case 4:
                return "Base";
            case 5:
                return "Url";
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int RowIndex) {
        switch (RowIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Nasa tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getNombre();
            case 2:
                return tmp.getFecha();
            case 3:
                return tmp.getFuncion();
            case 4:
                return tmp.getBase();
            case 5:
                return tmp.getUrl();
    }
        return null;
    }

    @Override
    public void setValueAt(Object o, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                //datos.get(rowIndex).setId();
                break;
            case 1:
                datos.get(rowIndex).setNombre((String) o);
                break;
            case 2:
                datos.get(rowIndex).setFecha((String) o);
            case 3:
                datos.get(rowIndex).setFuncion((String) o);
            case 4:
                datos.get(rowIndex).setBase((String) o);
            case 5:
                datos.get(rowIndex).setUrl((String) o);
                break;
            default:
                System.out.printf("No se modifica");
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
    public void cargardatos() {
        try {
            ArrayList<Nasa> tirar = ldao.obtenerTodo();
            System.out.println(tirar);
            datos = ldao.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println("error" + sqle.getMessage());
        }

    }
    public Nasa getInstroindex(int idx){
        return datos.get(idx);
    }
    public boolean agregaNasa(Nasa nas) {
        boolean resultado = false;
        try {
            if (ldao.insertar(nas)) {
                datos.add(nas);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println("Error" + sqle.getMessage());
        }
        return resultado;
    }
    public boolean actualizar(Nasa nas) {
        boolean resultado = false;
        try {
            if (ldao.update(nas)) {
                datos.add(nas);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println("Error" + sqle.getMessage());
        }
        return resultado;
    }
    public boolean eliminar(Nasa nas) {
        boolean resultado = false;
        try {
            if (ldao.delete(String.valueOf(nas))) {
                datos.add(nas);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println("Error" + sqle.getMessage());
        }
        return resultado;
    }
}
