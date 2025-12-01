Una **base de datos relacional** es un sistema organizado de almacenamiento de datos que utiliza **tablas** para representar la información y las relaciones entre diferentes conjuntos de datos.
Se basa en el modelo relacional propuesto por **Edgar F. Codd en 1970**.
# **Tablas y registros**

La información en una base de datos relacional se organiza en **tablas** (también llamadas relaciones). Cada tabla está compuesta por **filas** y **columnas**.
	-   Una **fila** representa un **registro o tupla**, una instancia concreta de la entidad.
	-   Una **columna** representa un **atributo o campo**, una propiedad de  la entidad.
## **Claves primarias y claves foráneas**

-   **Clave primaria (PRIMARY KEY):** es un campo (o combinación de campos) que identifica de manera única cada fila dentro de una tabla. No puede contener valores nulos ni repetidos.
-   **Clave foránea (FOREIGN KEY):** es un campo en una tabla que hace referencia a la clave primaria de otra tabla. Se utiliza para establecer relaciones entre tablas.

------------------------------------------------------------------------
## **Relaciones entre tablas**

Las bases de datos relacionales permiten establecer conexiones entre diferentes tablas. Existen tres tipos principales de relaciones:
	* Uno a uno (1:1): Un registro de la tabla A se asocia con un solo registro de la tabla B.
	* Uno a muchos (1:M): Un registro de la tabla A se asocia con varios registros de la tabla B, pero cada registro de B solo está vinculado a un registro de A.
	* Muchos a muchos (M:N): Varios registros de la tabla A pueden estar relacionados con varios registros de la tabla B. **Para gestionar esta relación, se usa una tabla intermedia.**

Ejemplo: Un cliente puede hacer muchos pedidos, pero cada pedido pertenece a un único cliente (relación 1:M)
## **Normalización**

Es el proceso de estructurar una base de datos para **minimizar la redundancia y mejorar la integridad de los datos**. Se logra a través de las **formas normales**, que son reglas que guían el diseño de las tablas.
Las tres primeras formas normales más comunes son:
	1. Primera Forma Normal (1NF): **Se eliminan los grupos repetitivos**, asegurando que cada campo contenga solo un valor.
	2. Segunda Forma Normal (2NF): **Se eliminan dependencias parciales**, asegurando que cada campo dependa completamente de la clave primaria.
	3. Tercera Forma Normal (3NF): **Se eliminan dependencias transitivas**, asegurando que los campos no dependan de otros campos que no sean clave primaria.
## **Consultas SQL**

Operaciones básicas en **SQL (Structured Query Language):**
**SELECT**: Recupera datos de una tabla
``` SQL
SELECT Nombre, Apellido FROM Clientes WHERE ID_Cliente = 1;
```

**INSERT**: Agrega un nuevo registro
```SQL
INSERT INTO Clientes (ID_Cliente, Nombre, Apellido, Email) VALUES (1, 'Ana', 'García', 'ana@email.com');
```

**UPDATE**: Modifica registros existentes
```SQL
UPDATE Clientes SET Email = 'ej@email.com' WHERE ID_Cliente = 1;
```

**DELETE**: Elimina registro/registros
```SQL
DELETE FROM Clientes WHERE ID_Cliente = 1;
```
## **Integridad referencial y restricciones**
Las bases de datos relacionales aseguran la integridad de los datos mediante restricciones como:
	-   **NOT NULL:** evita valores nulos.
	-   **UNIQUE:** impide duplicados.
	-   **CHECK:** Establece condiciones que deben cumplir los valores de un campo
	-   **FOREIGN KEY:** Define claves foráneas para asegurar la relación correcta entre tablas.
## **Índices y optimización**
Un índice **mejora la velocidad de búsqueda** en una base de datos, permitiendo acceso más rápido a los registros. 
``` sql
CREATE INDEX idx_nombre ON Clientes (Nombre);
```
# **SQL y sus subconjuntos**

- **DML** (Data **Manipulation** Language). Manipula datos. **INSERT, UPDATE, DELETE, SELECT**
- **DDL**  (Data **Definition Language**. Definir estructura. **CREATE, ALTER, DROP, TRUNCATE**
- **DCL**  (Data **Control** Language). Controla accesos. **GRANT, REVOKE**

------------------------------------------------------------------------

## **Ejemplos DML (4)**

**INSERT**: Inserta nuevos registros en una tabla
``` sql
INSERT INTO Clientes (ID_Cliente, Nombre, Apellido, Email) VALUES (1, 'Ana', 'García', 'ana@email.com');
```

**UPDATE**: Modifica registros existentes en una tabla
``` sql
UPDATE Clientes
SET Email = 'nuevo@email.com'
WHERE ID_Cliente = 1;
```

**DELETE**: Elimina registros una tabla
``` sql
DELETE FROM Clientes WHERE ID_Cliente = 1;
```

**SELECT**: Consulta datos almacenados en una tabla. Es DQL (Data Query Language)
``` sql
SELECT * FROM Clientes;
```
## **Ejemplos DDL (4)**

Definen la estructura de la base de datos: la creación y modificación de tablas, índices y restricciones

- **CREATE**: Crea objetos como bbdd, tablas e indices
```sql
CREATE TABLE empleados (
   id NUMBER(5) PRIMARY KEY,
   nombre VARCHAR2(50) NOT NULL,
   fecha_nacimiento DATE,
   salario NUMBER(10,2) CHECK (salario > 0),
   departamento_id NUMBER(3) REFERENCES departamentos(id)
);
```
Explicación:
- id es la clave primaria.
- nombre es un campo obligatorio (NOT NULL).
- fecha_nacimiento es de tipo DATE.
- salario tiene una restricción (CHECK) que impide valores negativos.
- departamento_id es una clave foránea (REFERENCES), que enlaza con la tabla departamentos.


- ** ALTER**: Modifica la estructura de una tabla (agregar, modificar o eliminar columnas).
**Añadir una nueva columna (ADD)**. Esto agrega un nuevo campo email a la tabla empleados.
```sql
ALTER TABLE empleados ADD email VARCHAR2(100);
```

**Modificar el tipo de campo (MODIFY)**. 
```sql
ALTER TABLE empleados MODIFY salario NUMBER(12,2);
```

**Eliminar una columna (DROP)**. 
```sql
ALTER TABLE empleados DROP COLUMN email;
```


- **DROP**: Elimina completamente una tabla o cualquier otro objeto de la bbdd.
```sql
DROP TABLE empleados;
```
Explicación:
- Elimina completamente la tabla y su estructura.
- Se pierden los datos y la tabla deja de existir en la bbdd.

- **TRUNCATE**: Elimina todos los registros de una tabla sin afectar su estructura y sin posibilidad de reversión.
```sql
TRUNCATE TABLE empleados;
```

Explicación:
- **Elimina todos los registros** de la tabla, pero **mantiene la estructura.**
- **No se puede revertir (no genera registros en el log de transacciones).**

## **Ejemplos DCL (2)**

Gestionan los permisos y el control de acceso a los datos. Aumenta seguridad

**GRANT**: Otorga permisos a un usuario para realizar acciones específicas
``` sql
GRANT SELECT, INSERT ON Clientes TO usuario1;
```

**REVOKE**: Revoca los permisos previamente concedidos a un usuario
```sql
REVOKE INSERT ON Clientes FROM usuario1;
```

# **TIPOS DE DATOS**
## **Numericos**

- **NUMBER(p, s)**: Número de precisión variable.
	p: Número total de dígitos (máximo 38).
	s: Número de dígitos a la derecha del punto decimal.
	Ejemplo: NUMBER(10,2) almacena hasta 10 dígitos, con 2 después del decimal.
- **INTEGER**: Equivalente a NUMBER(38,0). Almacena enteros sin decimales.
	Ejemplo: INTEGER almacena valores como 100, -50, 2500.
- **FLOAT (p)**: Número de punto flotante.
	p define la precisión en bits.
	Ejemplo: FLOAT(10) almacena números con precisión de 10 dígitos.
- **BINARY_FLOAT y BINARY_DOUBLE**: Números de punto flotante en precisión simple y doble.
	BINARY_FLOAT: Más rápido pero menos preciso.
	BINARY_DOUBLE: Mayor precisión para cálculos científicos.

## **Caracteres**

Se usan para almacenat texto
- **CHAR(n)**: Cadena de longitud fija de n caracteres (máximo 2000 bytes).
	Ejemplo: CHAR(10) almacena exactamente 10 caracteres.
- **VARCHAR2(n)**: Cadena de longitud variable, con un máximo de n caracteres (hasta 4000 bytes).
	Ejemplo: VARCHAR2(100) almacena hasta 100 caracteres sin desperdiciar espacio.
- **NCHAR(n) y NVARCHAR2(n)**: Versiones Unicode de CHAR y VARCHAR2 para almacenar caracteres multibyte.

## **Fecha y Hora**

- **DATE**: Almacena fecha y hora con precisión de segundos.
	Ejemplo: DATE almacena valores como 2025-02-17 14:30:00.
- **TIMESTAMP [(n)]**: Similar a DATE, pero permite mayor precisión en los segundos (n define la cantidad de dígitos en la fracción de segundo, hasta 9).
	Ejemplo: TIMESTAMP(3) almacena 2025-02-17 14:30:15.123.
- **TIMESTAMP WITH TIME ZONE**: Almacena fecha, hora y zona horaria.
	Ejemplo: TIMESTAMP '2025-02-17 14:30:00 -05:00'.
- **TIMESTAMP WITH LOCAL TIME ZONE**: Similar al anterior, pero ajusta automáticamente la zona horaria según el usuario.
- **INTERVAL YEAR TO MONTH**: Almacena diferencias de tiempo en años y meses.
	Ejemplo: INTERVAL '3-6' YEAR TO MONTH (3 años y 6 meses).
- **INTERVAL DAY TO SECOND**: Almacena diferencias de tiempo en días, horas, minutos y segundos.
	Ejemplo: INTERVAL '5 12:30:45' DAY TO SECOND (5 días, 12 horas, 30 minutos y 45 segundos).

## **LOB (Large Objects)**

Se usan para almacenar grandes volúmenes de datos como documentos, imágenes o vídeos.
- **CLOB (Character Large Object)**: Almacena hasta 128 TB de texto.
	Ejemplo: CLOB se usa para almacenar **documentos XML o JSON largos.**
- **BLOB (Binary Large Object)**: Almacena **datos binarios (imágenes, vídeos, audio).**
	Ejemplo: BLOB se usa para guardar archivos multimedia.
- **NCLOB**: Similar a CLOB, pero **para caracteres Unicode.**
- **BFILE**: Referencia un **archivo binario almacenado fuera de la base de datos.**

## **Datos Especiales

Se usan en aplicaciones específicas.
- **RAW(n)**: Almacena datos binarios de longitud fija (máximo 2000 bytes).
	Ejemplo: RAW(16) se usa para almacenar valores hash o claves encriptadas.
- **ROWID**: Representa la ubicación física de una fila en la base de datos.
	Ejemplo: ROWID se usa en consultas internas para identificar registros de manera única.
- **UROWID**: Similar a ROWID, pero para tablas organizadas con índices.

# **Constraints (Restricciones)**

Las limitaciones (constraints) permiten definir reglas sobre los datos almacenados en las tablas para garantizar su integridad.
- **PRIMARY KEY (CLAVE PRIMARIA)**
Garantiza que cada fila en la tabla tiene un valor único y no nulo en la columna o columnas definidas.
```SQL
CREATE TABLE empleados (
   id NUMBER(5) PRIMARY KEY,
   nombre VARCHAR2(50) NOT NULL 
);
```

La columna id no puede contener valores duplicados ni nulos.
Se puede definir sobre una única columna o múltiples columnas      (clave primaria compuesta).

- **CLAVE PRIMARIA COMPUESTA**:
```SQL
CREATE TABLE asistencia (
   empleado_id NUMBER(5),
   fecha DATE,
   PRIMARY KEY (empleado_id, fecha) 
);
```
Los dos campos de PRIMARY KEY COMPUESTA deben ser únicos

- **FOREIGN KEY (Clave foránea)**
Asegura la integridad referencial entre dos tablas, impidiendo que se inserten valores en una tabla si no existen en la tabla referenciada.
```sql
CREATE TABLE departamentos (
   id NUMBER(3) PRIMARY KEY,
   nombre VARCHAR2(50) NOT NULL
);
```

```sql
CREATE TABLE empleados (
   id NUMBER(5) PRIMARY KEY,
   nombre VARCHAR2(50) NOT NULL,
   departamento_id NUMBER(3),
   CONSTRAINT fk_departamento FOREIGN KEY (departamento_id)            REFERENCES departamentos(id) ON DELETE CASCADE
);
```

* departamento_id en empleados debe existir en departamentos.
* **ON DELETE CASCADE**: Si un departamento es eliminado, sus            empleados también se eliminan.

## **NOT NULL**

Impide que una columna almacene valores NULL.
```sql
CREATE TABLE clientes (
   id NUMBER(5) PRIMARY KEY,
   nombre VARCHAR2(100) NOT NULL
);
```
* La columna nombre siempre debe tener un valor al insertar un nuevo registro.

## **UNIQUE**

Asegura que todos los valores en una columna sean únicos, pero permite valores NULL.
```sql
CREATE TABLE clientes (
   id NUMBER(5) PRIMARY KEY,
   codigo VARCHAR2(20) UNIQUE,
   nombre VARCHAR2(50) NOT NULL
);
```
* No se pueden repetir valores de código, pero si puede estar vacio (NULL)


## **DIFERENCIA ENTRE PRIMARY KEY Y UNIQUE

- Una tabla solo puede tener una PRIMARY KEY.
- Puede tener múltiples UNIQUE en diferentes columnas.

## **CHECK**

Permite definir una condición lógica que los valores de una columna deben cumplir.
```SQL
CREATE TABLE empleados (
   id NUMBER(5) PRIMARY KEY,
   salario NUMBER(10,2) CHECK (salario > 0),
   edad NUMBER(2) CHECK (edad BETWEEN 18 AND 65)
);
```

## **DEFAULT**

Define un valor por defecto si no se especifica otro al insertar datos.
```SQL
CREATE TABLE pedidos (
   id NUMBER(5) PRIMARY KEY,
   estado VARCHAR2(20) DEFAULT 'Pendiente',
   fecha_pedido DATE DEFAULT SYSDATE
);
```

- Si no se proporciona estado, se asigna 'Pendiente'.
- fecha_pedido usa la fecha actual del sistema.

## **IDENTITY (Autoincremento)**

Genera valores secuenciales automáticamente (en Oracle 12c+).
```SQL
CREATE TABLE clientes (
   id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   nombre VARCHAR2(100) NOT NULL
);
```

- id se genera automáticamente sin necesidad de usar SEQUENCES.
- NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY: Autoincrementa

Alternativa en versiones antiguas Oracle:

```sql
CREATE SEQUENCE clientes_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE clientes (
   id NUMBER(5) PRIMARY KEY,
   nombre VARCHAR2(100) NOT NULL
);
```

```sql
INSERT INTO clientes (id, nombre) VALUES (clientes_seq.NEXTVAL, 'Juan Pérez');
```
### **Ejemplo completo de restricciones**

```sql
CREATE TABLE empleados (
   id NUMBER(5) GENERATED ALWAYS AS IDENTITY PRIMARY KEY, -- Autoincremental y clave primaria
   nombre VARCHAR2(50) NOT NULL, -- No puede ser NULL
   email VARCHAR2(100) UNIQUE, -- No se puede repetir
   salario NUMBER(10,2) CHECK (salario > 0), -- No permite valores negativos
   fecha_contratacion DATE DEFAULT SYSDATE, -- Por defecto, la fecha actual
   departamento_id NUMBER(3),
   CONSTRAINT fk_departamento FOREIGN KEY (departamento_id) REFERENCES departamentos(id) ON DELETE CASCADE
);
   ```

## **Resumen de restricciones**:

- **PRIMARY KEY**: Garantiza valores únicos y no nulos en una columna o conjunto de columnas.
- **FOREIGN KEY**: Vincula una columna con otra tabla, asegurando integridad referencial.
- **NOT NULL**: Impide que una columna tenga valores nulos.
- **UNIQUE**: Garantiza que los valores de la columna sean únicos (permite NULL).
- **CHECK**: Define condiciones lógicas para los valores de una columna.
- **DEFAULT**: Especifica un valor predeterminado si no se proporciona otro.
- **IDENTITY**: Genera valores secuenciales automáticamente (versión 12c+)

## **Iniciar maquina virtual**
```bash
ssh -p 2222 ubuntu@localhost
```

## **DOCKER**
Docker es una **plataforma de código abierto** que permite **empaquetar, distribuir y ejecutar aplicaciones dentro de contenedores**. Su objetivo principal es garantizar que una aplicación se ejecute de forma **consistente** en cualquier entorno.
Los paquetes pequeños se llaman imágenes (que son las plantillas) y a partir de las imagenes se crean los contenedores.
Las imagenes están subidas a repositorios (ejemplo de repositorio publico: https://hub.docker.com)
Una imagen es inmutable

## 🧱 ¿Qué es un contenedor?

Un **contenedor** es una unidad ligera y aislada que incluye:

- El código de la aplicación
- Sus dependencias (librerías, herramientas del sistema, configuraciones)
- Todo lo necesario para ejecutarla correctamente

> 🔁 A diferencia de una máquina virtual, un contenedor **no necesita un sistema operativo completo**, lo que lo hace más rápido y eficiente

**Descargar imagenes**
```bash
docker pull nombreImagen
```

**Ver si se ha descargado la imagen**
```bash
docker image ls
```

**Como crear contenedores?**
```Shell
docker run --name nombreContenedor -d nombreImagen
```
- `--name`: asigna un nombre al contenedor
- `-d`: ejecuta en segundo plano (modo "detached")

**¿Como ver si se han creado correctamente los contenedores?**
```bash
docker container ls -a ##Muestra todos: los activos y los detenidos ó
docker container ls ##Muestra solo los activos
```

**¿Como arrancar un contenedor?**
```bash
docker container start nombreContenedor
```

**¿Como entrar dentro de un contenedor?**
```bash
docker exec -it nombreContenedor
```

**¿Como parar un contenedor?**
```bash
docker container stop nombreContenedor
```

**¿Como eliminar un contenedor?**
```bash
docker container rm nombreContenedor
```

Una de las BBDD más usadas en empresas es ORACLE. Hay una version de pago y otra gratuita (Oracle XE - Express Edition).

Para salir de un contenedor se hace con exit en Shell

## **BBDD Relacionales**

Son las más utilizadas (en https://db-engines.com se pueden ver todas las bbdd).
Las BBDD Relacionales tienen en comun el lenguaje SQL (Structured Query Language).

(Las BBDD NO Relacionales son mas rapidas porque no tienen restricciones)

Todas las BBDD Relacionales tienen que cumplir el **principio ACID**:
- A -> Atomicidad: o todo va bien o nada se ejecuta.
- C -> Consistencia: datos consistentes, no redundantes, restricciones, etc)
- I -> Isolation (Aislamiento): cada transaccion se realiza de forma separada
- D -> Durabilidad: no se tiene que perder la info de las tablas

Hibernate es un framework de acceso a BBDD
Impedancia: no coinciden los nombres en el lenguake de programacion con la BBDD

## **Trabajar en Eclipse con BBDD**

1. Window -> Show view -> Other -> (Escribir Data)
2. Doble click en Data Source Explorer
3. En la parte de abajo: click derecho en Database Connections -> New -> (Buscar Oracle) -> Poner nombre a la conexion
4. Drivers (es la librería que permite conectar Eclipse con Oracle) -> Con MAVEN se descarga poniendolo en el pom.xml y se guarda automaticamente en ruta ~/.m2/repository


### BBDD 

Para que en la bbdd, solo muestre un numero de decimales. ejemplo:

Muestra 2 decimales:
UPDATE TB_PRODUCTOS_PROFE
   SET precio = ROUND(precio * 1.05, 2)
 WHERE categoria = 'TECNOLOGIA';

Muestra 1 decimal:
UPDATE TB_PRODUCTOS_PROFE
   SET precio = ROUND(precio * 1.05, 1)
 WHERE categoria = 'TECNOLOGIA';

Muestra 3 decimales:
UPDATE TB_PRODUCTOS_PROFE
   SET precio = ROUND(precio * 1.05, 3)
 WHERE categoria = 'TECNOLOGIA';

NVL
UPPER
INITCAP
TO_CHAR : para convertir una fecha a otro formato

Software DEBEZIUM : lee los logs de las bbdd


AS significa ALIAS, y es para cambiar el nombre en los resultados de un SELECT. Ejemplo:
nombre AS "nombre_comercial"

Para un rango: ejemplo: WHER salario BETWEEN 1000 AND 2000; (Tb incluye 1000 y 2000)

Operaciones de agregacion: SE USAN MUCHISIMO PORQUE DAN ESTADISTICA DE LA INFORMACION QUE TENEMOS EN UNA TABLA

distinct

Orden de las consultas:
	SELECT
	FROM
	WHERE
	GROUP BY
	[HAVING]
	ORDER BY

HAVING es para aplicar un filtro sobre los resultados obtenidos

SQL: DROP elimina la tabla y TRUNCATE elimina los registros que existen  en la  tabla.

Esta consulta devuelve el **número de categorías únicas** que existen en la tabla productos:
```sql
SELECT COUNT(DISTINCT categoria) FROM productos;
```
El SELECT y el FROM son siempre obligatorios
Se puede ordenar con varios criterios, por ejemplo:
```sql
ORDER BY categoria, precio;
```

Para usar un HAVING hay que usar un AS en el select, no puede utilizarse un HAVING sin un GROUP BY.
## Agrupacion SQL
La **agrupación** se hace con la cláusula `GROUP BY` y sirve para **organizar los datos en grupos** según una o más columnas. Luego puedes aplicar funciones como:

- `COUNT()` → contar elementos
- `SUM()` → sumar valores 
- `AVG()` → calcular promedio
- `MAX()` / `MIN()` → obtener el valor máximo o mínimo

Ejemplo:
```sql
SELECT categoria, AVG(precio) AS precio_medio
FROM productos
GROUP BY categoria ASC, nombre DESC
```

Cuando usamos GROUP BY en SQL, todas las columnas del SELECT deben estar incluidas en el GROUP BY o ser parte de una función de agregación. No se pueden incluir columnas sueltas que no estén agrupadas ni agregadas.

### ** Ampliacion de apuntes
# BBDD
## Modos típicos de incluir datos auditables en tablas SQL Oracle

> [!CAUTION]  El profesor solo nombro que había métodos típicos para ello, pero no lo explicó.

En entornos donde es importante mantener trazabilidad (por ejemplo, saber quién creó o modificó un dato, y cuándo), se suele implementar auditoría directamente en las tablas o mediante estructuras adicionales. A continuación, se detallan las opciones más comunes.

---

### 1. Campos de auditoría en cada tabla

Consiste en agregar columnas de control directamente en las tablas principales de datos.

Campos comunes:

| Campo        | Descripción                                       |
| ------------ | ------------------------------------------------- |
| CREATED_AT | Fecha y hora de creación del registro             |
| CREATED_BY | Usuario que creó el registro                      |
| UPDATED_AT | Fecha y hora de la última modificación            |
| UPDATED_BY | Usuario que hizo la última modificación           |
| DELETED_AT | Fecha de eliminación lógica (opcional)            |
| DELETED_BY | Usuario que eliminó lógicamente (opcional)        |
| IS_DELETED | Bandera para marcar eliminación lógica (opcional) |

Ventajas:

- Fácil de implementar
    
- Accesible directamente desde las consultas normales
    
- Compatible con frameworks ORM
    

Desventajas:

- Solo registra la última acción
    
- No guarda historial detallado de cambios
    

---

### 2. Tablas de auditoría o histórico (Change Log)

Se crean tablas separadas, normalmente con el mismo diseño que la tabla original, más campos adicionales para el seguimiento de acciones.

Campos adicionales comunes:

- AUDIT_ACTION (INSERT, UPDATE, DELETE)
    
- AUDIT_TIMESTAMP
    
- AUDIT_USER
    
- AUDIT_SESSION_ID
    
- Otros metadatos relevantes
    

Implementación típica:

- Triggers en la tabla principal que insertan en la tabla de auditoría ante cada cambio
    
- También puede hacerse desde la lógica de negocio en la aplicación
    

Ventajas:

- Permite guardar todo el historial de cambios
    
- Útil para auditorías y trazabilidad detallada
    

Desventajas:

- Requiere más espacio en disco
    
- Mayor complejidad en mantenimiento y consultas
    

---

### 3. Uso de Triggers

Los triggers permiten automatizar la actualización de campos de auditoría o la inserción en tablas de auditoría.

Ejemplo 1: Actualizar campos de auditoría en la tabla original
CREATE OR REPLACE TRIGGER trg_before_update_cliente
BEFORE UPDATE ON clientes
FOR EACH ROW
BEGIN
  :NEW.updated_at := SYSDATE;
  :NEW.updated_by := SYS_CONTEXT('USERENV', 'SESSION_USER');
END;

Ejemplo 2: Insertar en tabla de auditoría
CREATE OR REPLACE TRIGGER trg_audit_cliente
AFTER INSERT OR UPDATE OR DELETE ON clientes
FOR EACH ROW
BEGIN
  INSERT INTO clientes_aud (
    id, nombre, email, audit_action, audit_timestamp, audit_user
  ) VALUES (
    COALESCE(:OLD.id, :NEW.id),
    COALESCE(:OLD.nombre, :NEW.nombre),
    COALESCE(:OLD.email, :NEW.email),
    CASE
      WHEN INSERTING THEN 'INSERT'
      WHEN UPDATING THEN 'UPDATE'
      WHEN DELETING THEN 'DELETE'
    END,
    SYSDATE,
    SYS_CONTEXT('USERENV', 'SESSION_USER')
  );
END;

---

### 4. Uso de ORA_ROWSCN y Flashback

Oracle permite utilizar funciones internas para ver versiones anteriores de registros o identificar cuándo fue la última modificación.

- ORA_ROWSCN: Pseudocolumna que indica el SCN (System Change Number) de la última modificación
    
- Flashback Query: Permite consultar cómo estaba una tabla en un momento pasado, si el UNDO lo permite
    

Ventajas:

- No requiere cambiar las tablas
    
- Útil para recuperación y análisis temporal
    

Desventajas:

- Requiere configuración avanzada
    
- Limitado por la retención de UNDO
    

---

### 5. Auditoría nativa de Oracle (DB-level)

Oracle ofrece mecanismos de auditoría avanzados a nivel de base de datos:

- Standard Auditing
    
- Fine-Grained Auditing (FGA)
    
- Oracle Audit Vault
    

Ventajas:

- No requiere modificar tablas de negocio

Contar todas las filas (incluye nulos)
SELECT COUNT(*) FROM empleados;

- Cuenta todas las filas de la tabla, incluyendo aquellas con valores nulos.
    
- Útil para saber el total de registros.
    

---

### 2. Contar valores no nulos de una columna
SELECT COUNT(salario) FROM empleados;

- Cuenta solo las filas donde salario no es nulo.
    
- Útil cuando quieres contar solo datos válidos.
    

---

### 3. Contar valores distintos (únicos)
SELECT COUNT(DISTINCT departamento_id) FROM empleados;

- Devuelve el número de departamentos únicos entre los empleados.
    

---

### 4. Usar COUNT con GROUP BY
SELECT departamento_id, COUNT(*) AS total_empleados
FROM empleados
GROUP BY departamento_id;

- Cuenta empleados por departamento.
    
- Agrupa los resultados según departamento_id.
    

---

### 5. Combinar con condiciones (`WHERE`)
SELECT COUNT(*) FROM empleados
WHERE salario > 3000;

- Cuenta solo los empleados con salario mayor a 3000.
    

---

### 6. Ejemplo completo
SELECT
  COUNT(*) AS total,
  COUNT(salario) AS con_salario,
  COUNT(DISTINCT departamento_id) AS departamentos_unicos
FROM empleados;


---

## Alias en Oracle SQL

### 1. Alias para columnas
SELECT nombre AS empleado_nombre
FROM empleados;

- empleado_nombre es un alias para la columna nombre.
    
- El uso de AS es opcional en Oracle:
    
SELECT nombre empleado_nombre FROM empleados;

Ambos funcionan igual.

---

### 2. Alias con espacios o caracteres especiales

Si el alias contiene espacios, se deben usar comillas dobles:
SELECT nombre empleado_nombre FROM empleados;

---

### 3. Alias para expresiones o funciones
SELECT salario * 12 AS salario_anual
FROM empleados;

- Asigna un nombre al resultado de una expresión.
    

---

### 4. Alias para funciones de agregación
SELECT COUNT(*) AS total_empleados
FROM empleados;

- Facilita la lectura de resultados agregados.
    

---

### 5. Alias para tablas
SELECT e.nombre, d.nombre AS departamento
FROM empleados e
JOIN departamentos d ON e.departamento_id = d.id;

- e y d son alias para las tablas empleados y departamentos.
    
- Esto permite escribir consultas más concisas.
    

---

### 6. Alias dentro de subconsultas
SELECT *
FROM (
  SELECT nombre, salario * 12 AS salario_anual
  FROM empleados
) emp_con_sueldo;

- Se da un alias (`emp_con_sueldo`) a la subconsulta para poder referenciarla.
    

---

### Notas importantes

- El alias no cambia el nombre real en la base de datos.
    
- Es útil en reportes, vistas, y para mejorar la claridad del código SQL.
    
- Aunque AS es opcional, se recomienda usarlo para mayor claridad.
    

---

## Uso de BETWEEN en Oracle SQL

BETWEEN se utiliza para comparar si un valor está dentro de un rango, incluyendo los valores extremos.

---
### Sintaxis
valor BETWEEN mínimo AND máximo

- Equivale a:
    
       valor >= mínimo AND valor <= máximo
        

---
### 1. Ejemplo con números
SELECT * FROM empleados
WHERE salario BETWEEN 3000 AND 5000;

- Devuelve los empleados cuyo salario está entre 3000 y 5000, inclusive.

---
### 2. Ejemplo con fechas
SELECT * FROM pedidos
WHERE fecha_pedido BETWEEN TO_DATE('01-01-2023', 'DD-MM-YYYY')
                      AND TO_DATE('31-12-2023', 'DD-MM-YYYY');

- Devuelve pedidos realizados en el año 2023.
- Las fechas límites sí se incluyen.

---

### 3. Ejemplo con texto (valores alfabéticos)
SELECT * FROM productos
WHERE nombre BETWEEN 'A' AND 'M';

- Devuelve productos cuyos nombres comienzan entre la letra A y la M.
- Oracle hace la comparación alfabética (según collation).

---
### 4. Uso con NOT BETWEEN
SELECT * FROM empleados
WHERE salario NOT BETWEEN 3000 AND 5000;

- Devuelve empleados cuyo salario no esté dentro del rango especificado.

---
### 5. Equivalencia lógica

Este ejemplo:
SELECT * FROM empleados
WHERE salario BETWEEN 3000 AND 5000;

Es equivalente a:
SELECT * FROM empleados
WHERE salario >= 3000 AND salario <= 5000;

---
### Notas

- BETWEEN incluye los valores límite (es decir, es **inclusivo**).
- Se puede usar con números, fechas y texto.

- Evita usar BETWEEN si los valores mínimo y máximo están invertidos, ya que puede no devolver resultados.

---
## Uso de LIKE en Oracle SQL

El operador LIKE se utiliza para realizar búsquedas por patrones en columnas de texto. Es útil cuando no se conoce el valor exacto, pero sí parte de él.

---

### Sintaxis básica
SELECT * FROM empleados
WHERE nombre LIKE 'J%';

- Devuelve todos los empleados cuyo nombre comienza por la letra J.

---
### Comodines disponibles

|Comodín|Significado|Ejemplo|
|---|---|---|
|`%`|Cualquier cantidad de caracteres (incluyendo 0)|`'A%'` → comienza con A|
|`_`|Exactamente un solo carácter|`'A_'` → A seguido de un carácter|

---
### 1. Usar % (cualquier número de caracteres)
SELECT * FROM empleados
WHERE nombre LIKE '%ez';

- Encuentra nombres que terminan en ez, como “Pérez”, “Gómez”.

---

### 2. Usar _ (un solo carácter)
SELECT * FROM empleados
WHERE nombre LIKE '_ara';

- Devuelve registros como “Sara”, “Lara”, “Kara”, etc.
- La primera letra puede ser cualquiera, seguido de “ara”.

---
### 3. Combinación de % y _
SELECT * FROM empleados
WHERE nombre LIKE '_a%';

- Encuentra nombres donde la segunda letra es a, como “Sara”, “Maria”, “David”.

---
### 4. Escape de caracteres especiales

Cuando quieres buscar los comodines % o _ como caracteres literales, debes usar la cláusula ESCAPE:
SELECT * FROM productos
WHERE descripcion LIKE '10\%%' ESCAPE '\';

- Busca descripciones que contienen el símbolo % como texto, no como comodín.

---
### 5. Comparaciones con mayúsculas y minúsculas

En Oracle, LIKE es sensible a mayúsculas por defecto:
SELECT * FROM empleados
WHERE nombre LIKE 'juan'; -- No encontrará 'Juan'

Para hacer una búsqueda insensible al caso, puedes usar UPPER o LOWER:
SELECT * FROM empleados
WHERE UPPER(nombre) LIKE 'JUAN';

---

### 6. Alternativa más avanzada: REGEXP_LIKE

Cuando necesitas patrones más complejos (como expresiones regulares), puedes usar REGEXP_LIKE:
SELECT * FROM empleados
WHERE REGEXP_LIKE(nombre, '^J.*z$');

- Encuentra nombres que comienzan con J y terminan con z.

---
### Ejemplos de patrones comunes

|Búsqueda deseada|Ejemplo con `LIKE`|
|---|---|
|Empieza por “A”|`'A%'`|
|Termina en “z”|`'%z'`|
|Contiene “mar”|`'%mar%'`|
|Segunda letra es “a”|`'_a%'`|
|Cuatro letras exactas|`'____'`|

---
## Función NVL en Oracle SQL

NVL se utiliza para reemplazar valores NULL por un valor predeterminado que tú especifiques.

---
### Sintaxis
NVL(expresión, valor_reemplazo)

- Si expresión es NULL, devuelve valor_reemplazo.
- Si expresión no es NULL, devuelve el valor de expresión.

---

### 1. Ejemplo básico
SELECT nombre, NVL(comision, 0) AS comision_final
FROM empleados;

- Si comision es NULL, muestra 0 en su lugar.

---

### 2. Uso con cadenas
SELECT nombre, NVL(direccion, 'No especificada') AS direccion_final
FROM empleados;

- Si direccion es NULL, muestra 'No especificada'.

---
### 3. En cálculos
SELECT nombre, salario + NVL(bono, 0) AS ingreso_total
FROM empleados;

- Suma el salario más el bono (considerando el bono como 0 si es NULL).

---

### Notas

- NVL solo permite dos parámetros.
- El tipo de dato de valor_reemplazo debe ser compatible con el de expresión.
- Alternativas modernas: COALESCE (acepta múltiples valores) y CASE.
 