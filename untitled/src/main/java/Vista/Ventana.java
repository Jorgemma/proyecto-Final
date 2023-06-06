package Vista;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame{
    private JLabel lblId;
    private JLabel lblnombre;
    private JLabel lblFecha;
    private JLabel lblFuncion;
    private JLabel lblBase;
    private JLabel lblUrl;
    private JTextField txtId;
    private JTextField txtnombre;
    private JTextField txtFecha;
    private JTextField txtFuncion;
    private JTextField txtBase;
    private JTextField txtUrl;
    private JButton btnagregar;
    private JButton btncargar;
    private JTable tblnasa;
    private JScrollPane scrollPane;
    private GridLayout layout;
    private JLabel imagen;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JLabel lblIdA;
    private JLabel lblNombreA;
    private JLabel lblFechaA;
    private JLabel lblFuncionA;
    private JLabel lblBaseA;
    private JLabel lblUrlA;
    private JTextField txtIdA;
    private JTextField txtnombreA;
    private JTextField txtFechaA;
    private JTextField txtFuncionA;
    private JTextField txtBaseA;
    private JTextField txtUrlA;
    private JButton btnActualizar;
    private JLabel lblEliminarId;
    private JTextField txtElminarId;
    private JButton btnEliminar;
    private JLabel ImagenNasa;
    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(800,800);
        layout= new GridLayout(2,2);
        this.getContentPane().setLayout(layout);
        // panel 1
        p1=new JPanel(new FlowLayout());
        p1.setBackground(new Color(37, 94, 250));
        lblId= new JLabel("Id: ");
        lblnombre=new JLabel("Nombre: ");
        lblFecha= new JLabel("Fecha de lanzamiento: ");
        txtId =new JTextField(3);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtnombre =new JTextField(15);
        txtFecha =new JTextField(20);
        btnagregar= new JButton("Agregar");
        lblFuncion= new JLabel("Funcion: ");
        lblBase= new JLabel("Base de lanzamiento: ");
        lblUrl= new JLabel("Url para imagen: ");
        txtFuncion=new JTextField(20);
        txtBase=new JTextField(15);
        txtUrl=new JTextField(15);

        p1.add(lblId);
        p1.add(txtId);
        p1.add(lblnombre);
        p1.add(txtnombre);
        p1.add(lblFecha);
        p1.add(txtFecha);
        p1.add(lblFuncion);
        p1.add(txtFuncion);
        p1.add(lblBase);
        p1.add(txtBase);
        p1.add(lblUrl);
        p1.add(txtUrl);

        p1.add(btnagregar);
        // panel 2
        p2=new JPanel(new FlowLayout());
        p2.setBackground(new Color(124, 151, 231));
        btncargar=new JButton("Cargar");
        p2.add(btncargar);
        tblnasa= new JTable();
        scrollPane=new JScrollPane(tblnasa);
        p2.add(scrollPane);

        // panel 3
        p3=new JPanel(new FlowLayout());
        p3.setBackground(new Color(124, 151, 231));
        ImagenNasa=new JLabel("");
        p3.add(ImagenNasa);
        // panel 4
        p4=new JPanel(new FlowLayout());
        p4.setBackground(new Color(37, 94, 250));
        lblIdA=new JLabel("Id:");
        txtIdA=new JTextField(3);
        lblNombreA=new JLabel("Nombre: ");
        txtnombreA =new JTextField(15);
        lblFechaA= new JLabel("Fecha de lanzamiento: ");
        txtFechaA =new JTextField(20);
        lblFuncionA= new JLabel("Funcion: ");
        txtFuncionA=new JTextField(20);
        lblBaseA= new JLabel("Base de lanzamiento: ");
        txtBaseA=new JTextField(15);
        lblUrlA=new JLabel("Url para la imagen: ");
        txtUrlA=new JTextField(15);
        btnActualizar=new JButton("Actualizar");
        lblEliminarId=new JLabel("Id por eliminar");
        txtElminarId=new JTextField(3);
        btnEliminar=new JButton("Eliminar");




        p4.add(lblIdA);
        p4.add(txtIdA);
        p4.add(lblNombreA);
        p4.add(txtnombreA);
        p4.add(lblFechaA);
        p4.add(txtFechaA);
        p4.add(lblFuncionA);
        p4.add(txtFuncionA);
        p4.add(lblBaseA);
        p4.add(txtBaseA);
        p4.add(lblUrlA);
        p4.add(txtUrlA);
        p4.add(btnActualizar);
        p4.add(lblEliminarId);
        p4.add(txtElminarId);
        p4.add(btnEliminar);
        // Agrgar
        this.getContentPane().add(p1,0);
        this.getContentPane().add(p2,1);
        this.getContentPane().add(p3,2);
        this.getContentPane().add(p4,3);

        this.setDefaultCloseOperation( EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblnombre() {
        return lblnombre;
    }

    public void setLblnombre(JLabel lblnombre) {
        this.lblnombre = lblnombre;
    }

    public JLabel getLblFecha() {
        return lblFecha;
    }

    public void setLblFecha(JLabel lblFecha) {
        this.lblFecha = lblFecha;
    }

    public JLabel getLblFuncion() {
        return lblFuncion;
    }

    public void setLblFuncion(JLabel lblFuncion) {
        this.lblFuncion = lblFuncion;
    }

    public JLabel getLblBase() {
        return lblBase;
    }

    public void setLblBase(JLabel lblBase) {
        this.lblBase = lblBase;
    }

    public JLabel getLblUrl() {
        return lblUrl;
    }

    public void setLblUrl(JLabel lblUrl) {
        this.lblUrl = lblUrl;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtnombre() {
        return txtnombre;
    }

    public void setTxtnombre(JTextField txtnombre) {
        this.txtnombre = txtnombre;
    }

    public JTextField getTxtFecha() {
        return txtFecha;
    }

    public void setTxtFecha(JTextField txtFecha) {
        this.txtFecha = txtFecha;
    }

    public JTextField getTxtFuncion() {
        return txtFuncion;
    }

    public void setTxtFuncion(JTextField txtFuncion) {
        this.txtFuncion = txtFuncion;
    }

    public JTextField getTxtBase() {
        return txtBase;
    }

    public void setTxtBase(JTextField txtBase) {
        this.txtBase = txtBase;
    }

    public JTextField getTxtUrl() {
        return txtUrl;
    }

    public void setTxtUrl(JTextField txtUrl) {
        this.txtUrl = txtUrl;
    }

    public JButton getBtnagregar() {
        return btnagregar;
    }

    public void setBtnagregar(JButton btnagregar) {
        this.btnagregar = btnagregar;
    }

    public JButton getBtncargar() {
        return btncargar;
    }

    public void setBtncargar(JButton btncargar) {
        this.btncargar = btncargar;
    }

    public JTable getTblnasa() {
        return tblnasa;
    }

    public void setTblnasa(JTable tblnasa) {
        this.tblnasa = tblnasa;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JLabel getImagen() {
        return imagen;
    }

    public void setImagen(JLabel imagen) {
        this.imagen = imagen;
    }

    public JPanel getP1() {
        return p1;
    }

    public void setP1(JPanel p1) {
        this.p1 = p1;
    }

    public JPanel getP2() {
        return p2;
    }

    public void setP2(JPanel p2) {
        this.p2 = p2;
    }

    public JPanel getP3() {
        return p3;
    }

    public void setP3(JPanel p3) {
        this.p3 = p3;
    }

    public JPanel getP4() {
        return p4;
    }

    public void setP4(JPanel p4) {
        this.p4 = p4;
    }

    public JLabel getLblIdA() {
        return lblIdA;
    }

    public void setLblIdA(JLabel lblIdA) {
        this.lblIdA = lblIdA;
    }

    public JLabel getLblNombreA() {
        return lblNombreA;
    }

    public void setLblNombreA(JLabel lblNombreA) {
        this.lblNombreA = lblNombreA;
    }

    public JLabel getLblFechaA() {
        return lblFechaA;
    }

    public void setLblFechaA(JLabel lblFechaA) {
        this.lblFechaA = lblFechaA;
    }

    public JLabel getLblFuncionA() {
        return lblFuncionA;
    }

    public void setLblFuncionA(JLabel lblFuncionA) {
        this.lblFuncionA = lblFuncionA;
    }

    public JLabel getLblBaseA() {
        return lblBaseA;
    }

    public void setLblBaseA(JLabel lblBaseA) {
        this.lblBaseA = lblBaseA;
    }

    public JLabel getLblUrlA() {
        return lblUrlA;
    }

    public void setLblUrlA(JLabel lblUrlA) {
        this.lblUrlA = lblUrlA;
    }

    public JTextField getTxtIdA() {
        return txtIdA;
    }

    public void setTxtIdA(JTextField txtIdA) {
        this.txtIdA = txtIdA;
    }

    public JTextField getTxtnombreA() {
        return txtnombreA;
    }

    public void setTxtnombreA(JTextField txtnombreA) {
        this.txtnombreA = txtnombreA;
    }

    public JTextField getTxtFechaA() {
        return txtFechaA;
    }

    public void setTxtFechaA(JTextField txtFechaA) {
        this.txtFechaA = txtFechaA;
    }

    public JTextField getTxtFuncionA() {
        return txtFuncionA;
    }

    public void setTxtFuncionA(JTextField txtFuncionA) {
        this.txtFuncionA = txtFuncionA;
    }

    public JTextField getTxtBaseA() {
        return txtBaseA;
    }

    public void setTxtBaseA(JTextField txtBaseA) {
        this.txtBaseA = txtBaseA;
    }

    public JTextField getTxtUrlA() {
        return txtUrlA;
    }

    public void setTxtUrlA(JTextField txtUrlA) {
        this.txtUrlA = txtUrlA;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JLabel getLblEliminarId() {
        return lblEliminarId;
    }

    public void setLblEliminarId(JLabel lblEliminarId) {
        this.lblEliminarId = lblEliminarId;
    }

    public JTextField getTxtElminarId() {
        return txtElminarId;
    }

    public void setTxtElminarId(JTextField txtElminarId) {
        this.txtElminarId = txtElminarId;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JLabel getImagenNasa() {
        return ImagenNasa;
    }

    public void setImagenNasa(JLabel imagenNasa) {
        ImagenNasa = imagenNasa;
    }
}
