# 📌 Chuleta Java + JDBC + SQL + Normalización

## 🔗 Connection

- Representa la conexión con la base de datos.
```java
Connection conn = DriverManager.getConnection(
   "jdbc:oracle:thin:@localhost:1521:xe", "usuario", "contraseña");
```
Siempre cerrar (`conn.close()` o try-with-resources).

---
## 📝 Statement

- Ejecuta sentencias SQL.
- Se crea desde la conexión:
```java
Statement stmt = conn.createStatement();
```
Métodos:
- `executeQuery("SELECT ...")` → devuelve `ResultSet`.
- `executeUpdate("INSERT/UPDATE/DELETE ...")` → devuelve nº de filas afectadas.

---
## 📊 ResultSet

- Contiene los resultados de una consulta SQL.
- Se recorre con:
```java
while (rs.next()) {
   String dato = rs.getString("columna");
   int numero = rs.getInt("columna");
}

```
Métodos comunes: `getString`, `getInt`, `getDouble`.

---

## 📦 ArrayList

- Lista dinámica que crece/disminuye según elementos.
- Declaración:
```java
ArrayList<String> lista = new ArrayList<>();
```
Métodos clave:

- `add(elemento)`
- `get(indice)`
- `set(indice, nuevoValor)`
- `remove(indice/objeto)`
- `size()`

---

## 🔄 For-each

- Recorre colecciones sin índices:
```java
for (String nombre : lista) {
   System.out.println(nombre);
}
```

---

## ⚙️ Try-catch

- Maneja excepciones:
```java
try {
   int[] numeros = {1,2,3};
   System.out.println(numeros[5]);
} catch (ArrayIndexOutOfBoundsException e) {
   System.out.println("Error: índice inválido");
}
```

🔁 Relación entre `try`, `catch` y `finally` en Java

🧩 `try` y `catch`
- Un bloque `**catch**` **siempre** debe estar asociado a un bloque `**try**`.
- No puede existir un `catch` sin un `try`.
- Puedes tener múltiples `catch` para manejar diferentes tipos de excepciones.

🧹 `finally`
- El bloque `**finally**` **no necesita** obligatoriamente un `catch`, pero **sí requiere** un `try`.
- Se ejecuta **siempre**, independientemente de si:

	 Se lanzó una excepción.
	 La excepción fue capturada o no.
	 El bloque `try` terminó normalmente.

🧠 ¿Para qué sirve `finally`?

* Ideal para liberar recursos: cerrar archivos, conexiones a base de datos, sockets, etc.
- Garantiza que ciertas acciones se ejecuten sin importar lo que ocurra en el `try`.

En try catch, el catch no es obligatorio si hay un finally, pero si no hay finally el catch si es obligatorio

---

## ⚙️ Try-with-resources

- Cierra automáticamente recursos (`Connection`, `Statement`, `ResultSet`, `BufferedReader`), gracias a la interfaz Cloeasble(), AutoCloseable()
```java
try (Connection conn = DriverManager.getConnection(...);
   Statement stmt = conn.createStatement();
   ResultSet rs = stmt.executeQuery("SELECT nombre FROM clientes")) {

   while (rs.next()) {
   System.out.println(rs.getString("nombre"));
   }
} catch (SQLException e) {
   e.printStackTrace();
}
```

---

📖 Lectura y escritura de ficheros
Leer:
```java
try (BufferedReader br = new BufferedReader(new FileReader("entrada.txt"))) {
    String linea;
    while ((linea = br.readLine()) != null) {
       System.out.println(linea);
    }
}
```

Escribir:
```java
try (BufferedWriter bw = new BufferedWriter(new FileWriter("salida.txt"))) {
    bw.write("Texto");
    bw.newLine();
}
```

---
## 🗄️ Bases de datos relacionales

- Organizan datos en **tablas** con filas y columnas.
- Clave primaria (PK) → identifica registros únicos.
- Clave foránea (FK) → relaciona tablas.

- **Normalización**:
    
    - 1NF → valores atómicos. Se eliminan los grupos repetitivos, asegurando que cada campo contenga solo un valor. 
    - 2NF → dependencia completa de la clave.  Se eliminan dependencias parciales, asegurando que cada campo dependa completamente de la clave primaria.
    - 3NF → sin dependencias transitivas. Se eliminan dependencias transitivas, asegurando que los campos no dependan de otros campos que no sean clave primaria. Se necesita una **tabla intermedia**

---

Consultas SQL
Para interactuar con una base de datos relacional, se utiliza SQL (Structured Query Language).

Algunas operaciones básicas incluyen:
SELECT: Recupera datos de una tabla. SELECT Nombre, Apellido FROM Clientes WHERE ID_Cliente = 1;

INSERT: Agrega un nuevo registro. INSERT INTO Clientes (ID_Cliente, Nombre, Apellido, Email) VALUES (1, 'Ana', 'García', 'ana@email.com');

UPDATE: Modifica registros existentes. UPDATE Clientes SET Email = 'nuevo@email.com' WHERE ID_Cliente = 1;

DELETE: Elimina registros. DELETE FROM Clientes WHERE ID_Cliente = 1;

**Integridad referencial y restricciones**
Las bases de datos relacionales aseguran la integridad de los datos mediante restricciones como:
	NOT NULL: Evita que un campo tenga valores nulos.
	UNIQUE: Garantiza que no haya valores duplicados en una columna.
	CHECK: Establece condiciones que deben cumplir los valores de un campo.
	FOREIGN KEY: Define claves foráneas para asegurar la relación correcta entre tablas.

---
## 📦 Maven

- Herramienta de gestión de proyectos en Java.
- Usa archivo `pom.xml` para:
	- Dependencias (ej. JDBC, Hibernate).
	- Plugins.
	- Ciclo de vida: `compile`, `test`, `package`, `install`.

Ejemplo dependencia en `pom.xml`:
```.xml
<dependency>
   <groupId>mysql</groupId>
   <artifactId>mysql-connector-java</artifactId>
   <version>8.0.33</version>
</dependency>
```

---

## 🐳 Docker

- Plataforma para ejecutar aplicaciones en **contenedores**.
- Conceptos clave:
       - **Dockerfile** → instrucciones para construir imagen.
       - **Imagen** → plantilla de contenedor.
       - **Contenedor** → instancia en ejecución.

---

## 🌐 Hibernate

- Framework ORM (Object-Relational Mapping).
- Permite mapear clases Java ↔ tablas BD.
- Configuración típica en `hibernate.cfg.xml`.

---

🎯 Esquema mental general
```txt
Java -> JDBC/Hibernate -> BBDD Relacional
Maven -> gestiona dependencias
Docker -> levanta entornos (ej. BD)
Ficheros -> leer/escribir datos locales
```

---

**INTERFAZ AUTOCLOSEABLE**

- Se introdujo en **Java 7**.
- Está en el paquete `java.lang`.
- Define un único método:
```java
public interface AutoCloseable {
   void close() throws Exception;
}
```

Cualquier clase que implemente esta interfaz puede usarse dentro de un **try-with-resources**, porque garantiza que tendrá un método `close()` para liberar recursos.

## 🔎 Ejemplos de clases que implementan `AutoCloseable`

- `Connection` (JDBC)
- `Statement`
- `ResultSet`
- `BufferedReader`
- `BufferedWriter`
- `Scanner`
---

📌 Chuleta SQL JOINS (1:1, 1:N, N:M)

🔹 JOIN básico
```SQL
SELECT *
FROM tablaA a
JOIN tablaB b ON a.id = b.id;
```

Une filas de dos tablas según una condición (`ON`).

## 🔹 Relación 1 a muchos (1:N)

- Una fila de la tabla A se relaciona con **varias filas** en la tabla B.
- Ejemplo: `Cliente` ↔ `Pedidos`.
```SQL
SELECT c.nombre, p.producto
FROM Cliente c
JOIN Pedido p ON c.id = p.cliente_id;
```
👉 Un cliente puede tener muchos pedidos.

## 🔹 Relación muchos a muchos (N:M)

- Una fila de A se relaciona con **varias filas de B**, y viceversa.
- Se necesita una **tabla intermedia**.
- Ejemplo: `Alumno` ↔ `Curso` con tabla `AlumnoCurso`.

## 🔄 Tipos de JOIN

- **INNER JOIN** → solo coincidencias.
- **LEFT JOIN** → todas las filas de la izquierda + coincidencias.
- **RIGHT JOIN** → todas las filas de la derecha + coincidencias.
- **FULL JOIN** → todas las filas de ambas tablas (si el motor lo soporta).

Ejemplo con LEFT JOIN:
```SQL
SELECT c.nombre, p.producto
FROM Cliente c
LEFT JOIN Pedido p ON c.id = p.cliente_id;
```
(👉 Muestra todos los clientes, incluso los que no tienen pedidos).

---
## 🎯 Idea clave para examen

- **1:1** → relación directa, clave primaria ↔ clave foránea única.
- **1:N** → clave primaria ↔ clave foránea repetida.
- **N:M** → tabla intermedia con dos claves foráneas.
- **INNER/LEFT/RIGHT JOIN** → controlan qué filas aparecen.