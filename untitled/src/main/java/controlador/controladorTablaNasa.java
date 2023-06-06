package controlador;

import Modelo.ModeloTablaNasa;
import Modelo.Nasa;
import Persistencia.ConexionSingleton;
import Vista.Ventana;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class controladorTablaNasa extends MouseAdapter {
    private Ventana view;
    private ModeloTablaNasa modelo;
    public controladorTablaNasa(Ventana view) {
        this.view = view;
        modelo= new ModeloTablaNasa();
        this.view.getTblnasa().setModel(modelo);
        this.view.getBtncargar().addMouseListener(this);
        this.view.getBtnagregar().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);
        this.view.getTblnasa().addMouseListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.view.getBtncargar()) {
            modelo.cargardatos();
            this.view.getTblnasa().setModel(modelo);
            this.view.getTblnasa().updateUI();
        }
        if (e.getSource() == this.view.getBtnagregar()) {

                Nasa nasa = new Nasa();
                nasa.setId(0);
                nasa.setNombre(this.view.getTxtnombre().getText());
                nasa.setFecha(this.view.getTxtFecha().getText());
                nasa.setFuncion(this.view.getTxtFuncion().getText());
                nasa.setBase(this.view.getTxtBase().getText());
                nasa.setUrl(this.view.getTxtUrl().getText());
                this.view.getTblnasa().updateUI();
                if (modelo.agregaNasa(nasa)) {
                    JOptionPane.showMessageDialog(view, "Se agrego correctamente", "aviso", JOptionPane.INFORMATION_MESSAGE);
                    this.view.getTblnasa().updateUI();
                } else {
                    JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos. por favor revise su conexion", "Erro", JOptionPane.ERROR_MESSAGE);

                }
        }
        if (e.getSource() == this.view.getBtnActualizar()) {
                Nasa nasa = new Nasa();
                nasa.setId(Integer.parseInt((String) this.view.getTxtIdA().getText()));
                nasa.setNombre(this.view.getTxtnombreA().getText());
                nasa.setFecha(this.view.getTxtFechaA().getText());
                nasa.setFuncion(this.view.getTxtFuncionA().getText());
                nasa.setBase(this.view.getTxtBaseA().getText());
                nasa.setUrl(this.view.getTxtUrlA().getText());

                if (modelo.actualizar(nasa)) {
                    JOptionPane.showMessageDialog(view, "Se actualizo correctamente", "aviso", JOptionPane.INFORMATION_MESSAGE);
                    this.view.getTblnasa().updateUI();
                } else {
                    JOptionPane.showMessageDialog(view, "No se pudo actualizo en la base de datos. por favor revise su conexion", "Erro", JOptionPane.ERROR_MESSAGE);

                }

        }
            if (e.getSource() == this.view.getBtnEliminar()) {
                String sqlDelete = "DELETE FROM Nasa WHERE id=?;";
                PreparedStatement pstm = null;
                try {
                    pstm = ConexionSingleton.getInstance("nasa.db").getConnection().prepareStatement(sqlDelete);
                } catch (SQLException ex) {
                    System.out.println("no hubo conexion");;
                }
                try {
                    pstm.setInt(1, Integer.parseInt(this.view.getTxtElminarId().getText()));
                    this.view.getTblnasa().updateUI();
                    JOptionPane.showMessageDialog(view, "Se elimino correctamente", "aviso", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException a) {
                    JOptionPane.showMessageDialog(view, "No se elimino correctamente", "aviso", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    System.out.println("no se pudo conectar"+ex.getMessage());
                }
                try {
                    pstm.executeUpdate();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(view, "Error en Id", "aviso", JOptionPane.INFORMATION_MESSAGE);
                    throw new RuntimeException(ex);
                }
            }
        if (e.getSource()==view.getTblnasa()) {
            int index=this.view.getTblnasa().getSelectedRow();
            Nasa tmp= modelo.getInstroindex(index);
            try {
                this.view.getImagenNasa().setIcon(tmp.getImagen());
            }catch (MalformedURLException mfue){
                System.out.println(e.toString());
            }
        }
    }
}
