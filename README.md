# PROYECTO RESTAURANTE

### **MY RESTAURANTE**

Este proyecto es sobre la elaboracion de un restaurante


## Ejecucion del proyecto

Levantar el proyecto en Netbeans


```
1. ir a la carpeta Scripts y descargarse el archivo Schema_Data.sql
2. Levantar Microsoft SQL Server y ejecutar esos script para crear la base de datos
3. Modificar la cadena de conexion del archivo conexionbd.java ubicado en:
    paquete util-> conexionbd.java

public class Conexionbd {
 
    //MODIFICAR LOS VALORES SEGUN SU BASE DE DATOS Y USUARIO Y PASSWORD
    public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=BDRestaurante"; -> colocar url del servidor de base de datos mas el nombre de la base de datos
    public static final String USER = "sa"; -> colocar usuario de la base datos
    public static final String CLAVE = "123456"; -> colocar password de la base de datos

    public static Connection ConBD(){

    Connection cn=null;
    
        try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return cn;
        
    } 

4. Ejecutar el formulario del paquete vista: FrmLogin.java

    USAR ESTAS CREDENCIALES:
        usuario: kccalloc - password:123456
		usuario: lchoquehuanca - password:123456
		usuario: llopez - password:123456
		usuario: oojeda - password:123456
		usuario: cocina - password:cocina
```
