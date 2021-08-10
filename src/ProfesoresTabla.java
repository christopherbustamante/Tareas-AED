import javax.swing.*;

public class ProfesoresTabla {
    public static void main(String[] args)
    {
       int n=-1, Tam =Integer.parseInt(JOptionPane.showInputDialog("De el numero de las Celdas"));
       String nomb[] = new String[Tam];
       int edad[] = new int [Tam], opc;
       char sexo[]= new char[Tam];


       do
       {
           opc=Integer.parseInt(JOptionPane.showInputDialog("1.Dar de Alta a un profesor \n 2. Dar de Baja a un profesor \n 3. Modificar la edad de un profesor \n 4. Imprimir los datos de un profesor \n 5. Imprimir los datos de todos los profesores \n 6. Salir"));

           switch(opc)
           {
               case 1:n= InsDesd (nomb,edad,sexo,n,Tam);
               break;
               case 2:n= ElimDesd (nomb,edad,sexo,n);
               break;
               case 3:n= ModDesd (nomb,edad,n);
               break;
               case 4:n= ImpPag (nomb,edad,sexo,n);
               break;
          
               default:JOptionPane.showMessageDialog(null, "Opcion Incorrecta");
           }


       }while(opc!=6);
       System.exit(0);

    }//fin de main



    public static int ElimDesd(String nomb[],int edad[],char sexo[],int n)
    {
        String nom=JOptionPane.showInputDialog("De el nombre del profesor a buscar");
        int i,k;
        i=BuscaDesd(nomb,n,nom);
        
        if(i>n)
        JOptionPane.showMessageDialog(null, "El profesor"+nom+"No se encuentra en el registro");
        else
        {
            for(k=i ; k<=(n-1) ; k++)
            {
                nomb[k]=nomb[k+1];
                edad[k]=edad[k+1];
                sexo[k]=sexo[k+1];
            }
            n--;

        }//fin del else
    
      return n;   
    }//fin de la arreglo eliminar
    
    public static int BuscaDesd(String nomb[],int n, String nom)
    {
        int i=0;
        while ((i<=n) && (nom.compareTo(nomb[i]) !=0))
        i++;
        return i;

    }//fin del arreglo de busqueda para eliminar

    public static int InsDesd(String nomb[],int edad[],char sexo[], int n, int Tam)
    {
        if(n<(Tam-1))
        {
            n++;
            nomb[n]=JOptionPane.showInputDialog("De el nombre del Profesor");
            edad[n]=Integer.parseInt(JOptionPane.showInputDialog("De el nombre del Profesor"));
            sexo[n]=JOptionPane.showInputDialog("De el sexo del Profesor").charAt(0);
        }
        else
        JOptionPane.showMessageDialog(null, "No hay espacio disponible");
        return n;
    }//fin del arreglo de Insertar profesor


    public static int ModDesd(String nomb[],int edad[],int n)
    {
        String nom=JOptionPane.showInputDialog("De el Nombre del Profesor a buscar");
        int i;
        i=BuscaDesd(nomb,n,nom);
        if(i>n)
        JOptionPane.showMessageDialog(null,"El profesor"+nom+"No se encuentra en el registro");
        else
        edad[i]=Integer.parseInt(JOptionPane.showInputDialog("Introdusca la nueva edad")); 
        
        return n;
    }

    public static int ImpPag(String nomb[],int edad[],char sexo[],int n)
    {
        JTextArea imp=new JTextArea();
        String sal="Nombre \t Edad \t Sexo \n";
        for (int i=0;i<n;i++)
        sal +=nomb[i]+ "\t" +edad[i]+ "\t" +sexo[i]+ "\n";
        imp.setText(sal);
        imp.enable(false);

        JOptionPane.showMessageDialog(null, imp);
        return n;
    }

    public static void ImpProf(String nomb[],int edad[],char sexo[], int n)
    {
        String nom=JOptionPane.showInputDialog("De el nombre del profesor a buscar");
        int i;
        i=BuscaDesd(nomb,n,nom);
        if(1>n)
        JOptionPane.showMessageDialog(null, "El profesor"+nom+"No se encuentra en el registro");
        else
        JOptionPane.showMessageDialog(null, "Nombre del Profesor"+nom+"\n Edad="+edad[i]+"\n Sexo="+sexo[i]);
    }

}// fin de la clase

//resuelto
