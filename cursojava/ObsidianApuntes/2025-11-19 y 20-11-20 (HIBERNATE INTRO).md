Es un framework ORM (Object Relational Mapping) de BBDD que nos facilita trabajar con Java y BBDD. 

Una clase representa una tabla
Crea clases Entity, esas clases a partir de estos entitys nos va a crear las tablas directamente en la BBDD.

🏗️ ¿Cómo funciona en Java?

- **Clase = Tabla** 
   Cada clase Java representa una tabla en la base de datos.
- **Atributo = Columna**  
   Cada atributo de la clase representa una columna de la tabla.
- **Instancia = Fila**  
   Cada objeto creado de esa clase representa una fila en la tabla

Anotación @Entity (se pone encima de la clase)
Anotación @Id (se pone encima del atributo que queramos que sea la primary key)
Constructor vacío: no es obligatorio pero si muy recomendable
### **COMO CONFIGURAR EL PROYECTO**

Se necesitan Librerías que se meten en las dependencias del pom.xml (ejemplo: Hibernate Core, JPA, Validator...)
En casi todos los proyectos hibernate, solemos encontrar un fichero llamado: hibernate.cfg.xml , donde se guarda la configuracion inicial.

==Conceptos:==
Dialecto Hibernate
Mostrar SQL por consola
```xml
<property name="hibernate.hbm2ddl.auto">update</property>
<!--(donde pone update, se puede poner otros como create (CUIDADO!!!!) que borra todas las tablas Y SUS DATOS, y las vuelve a crear)--!>
```

No solo nos vale con Crear un Entity, debemos decirle a Hibernate donde esta creado (esto se pone en el fichero hibernate.cfg.xml  , de esta manera: 
```xml
<mapping class="hibernate.Empresa" />
```
)
`` 
JPA significa JAKARTA PERSISTENCE API (antes era JAVA PERSISTENCE API)
