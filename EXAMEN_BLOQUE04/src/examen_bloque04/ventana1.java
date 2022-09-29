
package examen_bloque04;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ventana1 extends JFrame {
    datos datSistema[] = new datos[5];
    JPanel paneldatos;
    int control = 0;
    
     
    public ventana1(){
        objetos();
        crearalumno();
    }
 
    public void crearalumno(){
        datSistema[0] = new datos();
        datSistema[0].clave = 1;
        datSistema[0].nombre = "Nataly Alvarez";
        datSistema[0].grado = "5to.bachillerato en computacion";
    
    
    }
    
    public void objetos(){    
      paneldatos = new JPanel();
      this.getContentPane().add(paneldatos);
      paneldatos.setLayout(null);
      
      JLabel lblLOGIN = new JLabel("Login");
      lblLOGIN.setFont(new Font("Century Gothic", Font.BOLD, 12));       
      lblLOGIN.setBounds(20,7,100,15);
      paneldatos.add(lblLOGIN);
      
      JLabel lblCLAVE = new JLabel("Clave:");
      lblCLAVE.setFont(new Font("Century Gothic", Font.BOLD, 12));
      lblCLAVE.setBounds(60,40,100,15);
      paneldatos.add(lblCLAVE);
      
      JLabel lblNOMBRE = new JLabel("Nombre:");
      lblNOMBRE.setFont(new Font("Century Gothic", Font.BOLD, 12));      
      lblNOMBRE.setBounds(60,100,100,15);
      paneldatos.add(lblNOMBRE);
           
      JLabel lblGRADO = new JLabel("Grado:");
      lblGRADO.setFont(new Font("Century Gothic", Font.BOLD, 12));      
      lblGRADO.setBounds(60,160,100,15);
      paneldatos.add(lblGRADO);
          
      JTextField txtClave = new JTextField();
      txtClave.setBounds(150, 40, 200, 25);
      paneldatos.add(txtClave);

      JTextField txtNombre = new JTextField();
      txtNombre.setBounds(150, 100, 200, 25);
      paneldatos.add(txtNombre);
      
      JTextField txtGrado = new JTextField();
      txtGrado.setBounds(150, 160, 200, 25);
      paneldatos.add(txtGrado);
         
        
      JButton btnRegistrar = new JButton("Registrar");
      btnRegistrar.setBackground(new Color(212, 223, 186));
      btnRegistrar.setFont(new Font("Century Gothic", Font.BOLD, 12));
      btnRegistrar.setBounds(30, 220, 180, 35);
      paneldatos.add(btnRegistrar);
        ActionListener registro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (txtClave.getText().equals("") || txtNombre.getText().equals("") || txtGrado.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe de llenar todos los campos");
                } else {
                   guardardatos(Integer.parseInt(txtClave.getText()), txtNombre.getText(), txtGrado.getText());
                   txtClave.setText("");
                   txtNombre.setText("");
                   txtGrado.setText("");
                }

            }
      };
      btnRegistrar.addActionListener(registro);
      
        JButton btnhtml = new JButton("Registrar HTML");
        btnhtml.setBackground(new Color(218, 234, 196));
        btnhtml.setFont(new Font("Century Gothic", Font.BOLD, 12));
        btnhtml.setBounds(230, 220, 180, 35);
        paneldatos.add(btnhtml);
        ActionListener crearHTML = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                crearhtml();

            }
        };
        btnhtml.addActionListener(crearHTML);
     
    } 
   
    public void guardardatos(int clave, String nombre, String grado){
          int posicion = 0;
          if (control < 5) {
          for(int i = 0; i < 4; i++){
                if (datSistema[i] == null) {
                    posicion = i;
                    break;
                }
            }
            //System.out.println("La posición libre es " + posicion);
            datSistema[posicion] = new datos();
            datSistema[posicion].clave = clave;
            datSistema[posicion].nombre = nombre;
            datSistema[posicion].grado = grado;
            control++;
            JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente, total de alumnos " + control);

        }else {
            JOptionPane.showMessageDialog(null, "no se puede registrar más usuarios");
        }
          }
    public void ordenar(){
        datos auxiliar;
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(datSistema[j+1] == null){
                    break;
                }else{
                    if(datSistema[j].clave < datSistema[j+1].clave){
                        auxiliar = datSistema[j+1];
                        datSistema[j+1] = datSistema[j]; 
                        datSistema[j] = auxiliar;
                    }
                }
            }
    
        }
    }
    
    public void crearhtml(){
  
        try{
            //CSS
            ordenar();
            PrintWriter escribirCSS = new PrintWriter("reporte/estilo.css","UTF-8");
            escribirCSS.print("html {   font-size: 20px; font-family: 'Gill Sans MT'; }");
            escribirCSS.print("h1 { font-size: 60px; text-align: center; }");
            escribirCSS.print("h1 { margin: 0; padding: 20px 0; color: #9DBEA0; text-shadow: 3px 3px 1px black; }");
            escribirCSS.print("table { table-layout: fixed;   width:250px;} td{border: 1px solid black; width: 190px;  word-wrap: break-word}");
            escribirCSS.print("table { padding: 50px 0;}");
            escribirCSS.print("html { background-color:  #BBD1B4; }");
            escribirCSS.print("body { width: 970px; margin: 0 auto; background-color: #C9E1B5 ; padding: 0 20px 20px 20px; border: 5px solid black; }");
            escribirCSS.close();


            
            //HTML
            PrintWriter escribir = new PrintWriter("reporte/index.html", "UTF-8");
            escribir.println("<!DOCTYPE html>");
            escribir.println("<html>");
            escribir.println("<head>");
            escribir.println("<title>Reporte del sistema</title>");
            escribir.println("<link rel=\"stylesheet\" href=\"estilo.css\">");
            escribir.println("</head>");
            escribir.println("<body>");
            escribir.println("<h1>Listado de alumnos en el sistema</h1>");
            
            //Creación de la tabla
            escribir.println("<center><table border = 1></center>");
            escribir.println("<tr>");
            escribir.println("<td>Clave</td> <td>Nombre</td> <td>Grado</td>");
            escribir.println("</tr>");
            for(int i = 0; i<4; i++){
                if(datSistema[i] != null){
                    escribir.println("<tr>");
                    escribir.println("<td>" + datSistema[i].clave + "</td><td>" + datSistema[i].nombre + "</td><td>" + datSistema[i].grado + "</td>");
                    escribir.println("</tr>");
                }
                    
            }           
            escribir.println("</table>");
            
 
            escribir.println("</body>");
            escribir.println("</html>");
            escribir.close();
            JOptionPane.showMessageDialog(null, "Reporte creado con éxito, este se encuentra en la carpeta Reportes");
        }catch(IOException error){
            JOptionPane.showMessageDialog(null, "No se pudo crear el reporte");
        }
    }


    }






