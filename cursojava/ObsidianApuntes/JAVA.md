# **METODOS**

Un **método** en Java es un bloque de código que realiza una tarea específica. Se usa para **reutilizar, organizar y simplificar** el código, evitando repeticiones.
# Declaracion:
```java
[modificador de acceso] [tipo de retorno] [nombre del método](parámetros) {
  // cuerpo del método
}
```

**Modificador de acceso**:
1. public: Accesible desde **cualquier clase**, incluso en otros paquetes o proyectos
2. private: Accesible **solo dentro de la misma clase**
3. protected: Accesible desde clases del **mismo paquete** y desde **subclases**, incluso en otros paquetes
4. package (o vacío): Accesible solo desde clases del **mismo paquete**

**Palabra reservada static**
	Es opcional
	Si tiene la palabra static significa que es un metodo estático
		- **Método estático**: se invoca sin crear un objeto (`Clase.metodo()`)
		- **Método de instancia (no estatico)**: requiere un objeto para ser llamado (`objeto.metodo()`)
   

**Tipo de retorno**
1. Si no devuelve nada se le pone void (si un metodo solo pinta, se considera que no pinnta nada).
2. Si no es void, hay que poner al final del codigo del metodo:
```java
return tipoDeDato;
```
Ejemplo:
```java
public int sumar(int a, int b) {
    return a + b;
}
```


**Nombre del método**
	Debe ser camelCase

**([parámetros])**
	Dentro de los paréntesis se colocan, de forma **opcional**, los parámetros que el método necesita para funcionar. Algunos métodos reciben parámetros, mientras que otros no.
Ejemplo con parámetros
```java
public void saludar(String nombre, int edad) {
    System.out.println("Hola " + nombre + ", tienes " + edad + " años.");
}
```

Ejemplo sin parámetros:
```java
public void saludar() {
   System.out.println("Hola");
}
```

## **Sobreescritura**
## 🔁 **Sobreescritura de métodos (Override)**

La **sobreescritura** permite redefinir el comportamiento de un método heredado en una subclase.  
Se usa para adaptar o extender la funcionalidad de una clase base.
### 🧠 Tipos de sobreescritura

1. **Completa**: el método en la subclase **reemplaza totalmente** el comportamiento del método original.
2. **Parcial**: el método en la subclase **amplía o complementa** el comportamiento original, normalmente usando `super`.

## **Anotaciones**
Realizan tareas a la sombra de nosotros
Se pone una @, por ejemplo: @Override : sirve para saber si estamos sobreescribiendo un método de la clase padre.

Hay distintos tipos: En tiempo de compilacion, en tiempo de ejecucion, en pruebas


# Librerias**

## 📦 Archivos `.jar` (Java Archive)

Un archivo `.jar` es un contenedor comprimido que agrupa:

- Archivos `.class` (código compilado de Java)
- Recursos como imágenes, archivos de configuración, etc.
- Un archivo `MANIFEST.MF` con metadatos del paquete

## 🛠️ Cómo crear un `.jar` en Eclipse (sin Maven)

1. Click derecho sobre el proyecto → **Export**
2. Selecciona: **Java → JAR file**
3. Marca las clases y paquetes que deseas exportar
4. Elige la ruta de destino del archivo `.jar`
5. Click en **Next → Next → Finish**

## 📁 Añadir librerías externas (carpeta `lib`)

1. Crea una carpeta llamada `lib` dentro del proyecto
2. Copia allí los archivos `.jar` externos
3. Click derecho sobre la carpeta `lib` → **Build Path → Add to Build Path**

## 🧰 Maven: gestión automática de dependencias

- Maven descarga y gestiona librerías desde su repositorio central: Repositorio Maven
- Para crear un proyecto MAVEN en IDE Eclipse, debemos: Click derecho -> New -> Maven Project. En la siguiente pantalla Marcar solamente: Create a simple project (skip archetype selection). Rellenar y Finish.
Eclipse crea 4 carpetas:
1. src/main/java (aqui van las clases, interfacez, paquetes...)
2. src/main/resources
3. src/test/java: pruebas unitarias
4. src/test/resources

![[Pasted image 20251012231943.png]]

### Para convertir un proyecto a Maven en Eclipse:

1. Click derecho sobre el proyecto → **Configure → Convert to Maven Project**
2. Se genera el archivo `pom.xml`, donde defines:

	- **GroupId**: dominio invertido (ej. `com.eva`)
	- **ArtifactId**: nombre del proyecto
	- **Version**: versión del artefacto

> 📌 Si el proyecto tiene un `pom.xml`, está gestionado por Maven.

## 🔗 Dependencias y jerarquía

- Las **dependencias** son librerías externas necesarias para que el proyecto funcione.
- Algunas librerías dependen de otras librerias para poder funcionar.
- En Eclipse, puedes ver esta jerarquía en la pestaña **Dependency Hierarchy** del `pom.xml`.
![[Pasted image 20251012184239.png]]

## 📝 Logback (framework de logging)

Para usar Logback con Maven:

1. Añade la dependencia en el `pom.xml`:
```XML
<dependency>
  <groupId>ch.qos.logback</groupId>
  <artifactId>logback-classic</artifactId>
  <version>1.4.11</version>
</dependency>
```

2. Crea el archivo `logback.xml` en `src/main/resources` con la configuración deseada:
```xml
<configuration>
  <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
    <encoder>
      <pattern>%d{HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</pattern>
    </encoder>
  </appender>

  <root level="debug">
    <appender-ref ref="STDOUT" />
  </root>
</configuration>
```

## 📝 Logback y configuración de niveles de log

### 📄 Archivo `logback.xml`

Este archivo define cómo se gestionan los mensajes de log en una aplicación Java. Se ubica normalmente en `src/main/resources`.

### 🔽 Niveles de log (de más crítico a más detallado):

- **ERROR**: Fallos graves que requieren atención inmediata
- **WARN**: Advertencias que podrían causar problemas
- **INFO**: Información general del flujo de ejecución
- **DEBUG**: Detalles útiles para desarrolladores
- **TRACE**: Máximo nivel de detalle, útil para diagnóstico profundo

> 🔧 **Recomendación**: Durante el desarrollo, se usan niveles **DEBUG** o **TRACE** para obtener información detallada. En entornos de **preproducción** o **producción**, se recomienda subir el nivel a **INFO**, **WARN** o **ERROR** para evitar saturar los logs.

📌 Ejemplo básico de `logback.xml`
```XML
<configuration>
  <appender name="CONSOLE" class="ch.qos.logback.core.ConsoleAppender">
    <encoder>
      <pattern>%d{HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n</pattern>
    </encoder>
  </appender>

  <root level="DEBUG">
    <appender-ref ref="CONSOLE" />
  </root>
</configuration>
```
	✅ Puedes cambiar `level="DEBUG"` por `INFO`, `ERROR`, etc., según el entorno.

## 🚫 ¿Por qué no usar `System.out.println` en proyectos?

- No permite controlar el nivel de importancia del mensaje
- No se puede redirigir fácilmente a archivos o sistemas externos
- No se puede desactivar dinámicamente según el entorno
- No ofrece formato ni trazabilidad
- 
> ✅ En proyectos profesionales se usan frameworks de logging como **Logback**, **SLF4J**, o **Log4j** para mantener un control estructurado y flexible de los mensajes.


# **BASES DE LA PROGRAMACION ORIENTADA A OBJETOS:**
- Herencia: Permite que una clase (subclase) herede atributos y métodos de otra clase (superclase). Reutilización de código y Facilita la extensión de funcionalidades
- Polimorfismo: Significa "muchas formas". Permite que un mismo método se comporte de manera diferente según el objeto que lo invoque. Flexibilidad, y código más genérico y reutilizable.
- Encapsulación: Consiste en ocultar los detalles internos de una clase (atributos privados) y exponer solo lo necesario mediante métodos públicos. Seguridad y control sobre los datos
- Abstraccion: Permite definir la estructura esencial de un objeto sin mostrar su implementación completa.


**Herencia en JAVA:**
Las clases padre comparten todos los metodos y atributos que sean public con sus clases hijas (subclases).
Una clase hija solo puede tener una clase padre (herencia unica).
Todas las clases heredan de Object

Cuando se crea un objeto en Java, se llama al constructor de la clase que aparece a la derecha del new.
```java
Animal animal = new Vaca ("Nombre", 200, 50); //Se crea un objeto animal que es de tipo vaca
```

La cantidad de objetos creados se puede saber por el numero de new que hay en el codigo

POJO sgnifica Plain Old Java Objects

Cuando a un metodo se le pasa como parametro un objeto es paso por referencia.
Cuando a un metodo se le pasa como parametro un tipo primitivi es paso por valor-

- Metodo static: se le llama al metodo con el nombre de la clase antes + un punto (ej: Math.random()). Suelen ser utilizados para uso general.
- Metodo dinamico (tambien llamado no estatico, o de instancia) necesita de un objeto para poder usarse.

![[Pasted image 20251012194549.png]]

No se puede llamar a un metodo no estatico desde un metodo estatico

int num = Integer.parseInt("7");
double decimal = Double.parseDouble("7.5");

Las variable pueden estar fuera de los metodos.
Desde un metodo podemos llamar a otros metodos.

Hay metodos **sobrecargados**; tienen el mismo nombre, pero reciben distinto tipo o cantidad de argumentos.

Hay variables locales y globales.
Las variables locales para poder usarlas deben estar inicializadas.
Las variables globales estan fuera de todos los metodos, se inicializan con los valores por defecto aunque no se declare.

La clase es el molde (plantilla) para crear los objetos.
Los objetos son lo que creamos (instaciamos) a partir de las clases.

Las variables apuntan a los objetos.

Todas las clases tienen un constructor por defecto, que lo que hace es inicializar las variables de instancia con sus valores por defecto (int -> o, double -> 0.0; boolean -> false, String/objetos -> null)
Si defines **cualquier constructor personalizado**, el compilador **ya no genera** el constructor por defecto.

## **GETTERS Y SETTERS**

Son **métodos públicos** que permiten **acceder y modificar** los atributos privados de una clase. Se usan como parte de la **encapsulación**, uno de los pilares de la POO.

Si el atributo no debe cambiar, **omite el setter** (solo getter)
### 🔐 ¿Por qué usarlos?

- Protegen los datos internos de la clase
- Permiten validar o controlar el acceso a los atributos
- Facilitan el mantenimiento y evolución del código
- Evitan el uso directo de variables privadas desde fuera de la clase

Ejemplo básico:
```JAVA
public class Persona {
   private String nombre;  // atributo privado

   // Getter
   public String getNombre() {
      return nombre;
   }

   // Setter
   public void setNombre(String nombre) {
       this.nombre = nombre;
   }
}
```

Uso
```java
Persona p = new Persona();
p.setNombre("Eva");               // modifica el atributo
System.out.println(p.getNombre()); // accede al atributo
```

## **.THIS**
Es una variable de instancia- El this accede a toda la info que tenga el objeto.
Con this se pueda acceder a todo lo que tenga el objeto. Con this NO se puede acceder a todo lo que sea estatico

## **COSAS INTERESANTES**
Dos variables pueden apuntar al mismo objeto.
Una variable estática es comun a todos los objetos de una clase. Por ejemplo, si creamos un DNI estatico, todos los objetos de la clase, tendrían el mismo DNI.
JAVA siempre que pinta o intenta pintar algo llama al método ,toString()
Las clases deben estar en singular
Un objeto puede estar formado por varios objetos.
Composición: un objeto depende de otro (ejemplo: objeto boton y objeto camisa)
Todas las variables que tienen static son variables de clase

## **CONSTRUCTORES**
Cuando creamos nuestro propio constructor desaparece el constructor por defecto (el que inicializa todo con valores por defecto).
Un constructor es un metodo.
Puede haber sobrecarga de constructores, podemos tener todos los constructores que queramos.

## **TODO; FIXME EN ECLIPSE**

- `TODO`: marca tareas pendientes o cosas por hacer
- `FIXME`: indica que hay algo que **debe corregirse** o revisarse

```java
// TODO: implementar validación de usuario
// FIXME: corregir error de conexión
```

Estas etiquetas se escriben como comentarios en el código y Eclipse las detecta automáticamente.
En Eclipse se ve desde: Window -> Show View -> Other -> Tasks

## **MEMORIAS**

Hay 2 memorias:
1. Estática: está creada en memoria desde el principio y está siempre
2.  Dinámica: es todo lo que se va a crear y destruir (los objetos). Los métodos de los objetos tambien son dinámicos.

## ✨ **CASTING (Conversión de tipos)**

El _casting_ permite convertir un tipo de dato en otro, especialmente útil en Java cuando trabajas con herencia o interfaces.

### 🔹 Tipos de Casting

|Tipo|Descripción|Ejemplo|
|---|---|---|
|**Upcasting**|De subclase a superclase. Implícito.|`Animal a = new Perro();`|
|**Downcasting**|De superclase a subclase. Requiere conversión explícita.|`Perro p = (Perro) a;`|

### ⚠️ Consideraciones

- El _downcasting_ puede lanzar `ClassCastException` si el objeto no es realmente del tipo al que se quiere convertir.
- Se recomienda usar `instanceof` antes de hacer _downcasting_.

## **INSTANCEOF**
`instanceof` es un operador que verifica si un objeto es instancia de una clase específica o de una subclase.
Sintaxis:
```java
objeto instanceof Clase
```

Ejemplo:
```java
if (a instanceof Perro) {
    Perro p = (Perro) a;
}
```

## **METODO TOSTRING**

`toString()` es un método que devuelve una representación en texto del objeto. Ideal para depuración y visualización.

Sintaxis:
```java
@Override
public String toString() {
    return "Perro [nombre=" + nombre + ", edad=" + edad + "]";
}
```

### 🛠️ Recomendación

- Siempre sobreescribe `toString()` en tus clases para facilitar la lectura y depuración.
- Evita mostrar información sensible.
## **METODOS ABSTRACTOS**

Un método abstracto es un método que no tiene código.

Cuando una clase tiene un método abstracto, la clase pasa a ser una clase abstracta.
Puede haber una clase abstracta que contenga métodos no abstractos.

En una clase abstracta no podemos crear objetos
```java
public abstract void comer();
```

Si una clase hereda de una clase abstracta -> esa clase hija debe sobreescribir todos los metodos abstractos de la clase padre.

# **INTERFACES**

Para crearlas:
File -> New -> Interface

Se usan para que las clases tengan funcionalidad

Si hay herencia e interfaces, 1º se pone la herencia (extends) y luego la interfaz o interfaces (implements)

Las interfaces tambien sirven para generar tipos de variables

La clase que implementa una interfaz está obligada a sobreescribir los metodos abstractos de la interfaz.

## 📌 Características de una interfaz

- Solo contiene **métodos abstractos** (aunque no se indique `abstract`)  
- Puede tener **variables estáticas y/o finales**  
- No puede tener constructores  
- No puede contener atributos modificables

## Imagen Colecciones:
![[Pasted image 20251006162942.png]]

## Algunos métodos de ArrayList y cosas importantes: 
.add(objeto); añade un objeto a la lista
.addLast(objeto); añade un objeto en la ultima posicion de la lista, es lo mismo que .add(objecto)
.addFirst(objeto); añade un objeto en la primera posicion de la lista
.add(3, objeto); añade un objeto en posicion 3 de la lista y los siguientes se recolocan
.size(): dice el tamaño de la lista
.remove(); elimina un elemento de la lista, se puede eliminar por posicion o por objeto
.contains(objeto); devuelve true o false, según si el objeto esta dentro de la lista.

Una lista es como si fuera un saco en el que se guardan los objetos. Para saber los objetos que hay dentro debemos recorrer la lista.

En una lista no se pueden guardar datos primitivos
En Colecciones hay genéricos. 

El mismo objeto lo puedo meter todas las veces que quiera en una lista.

Si queremos que una clase no pueda ser heredable se añade la palabra **final** a la clase. X ej:
public final class Lobezno extends Lobo {}
Una clase no  puede ser final y abstracta a la vez.

En Eclipse con CONTROL + SHIFT + T : se busca una clase

## Colecciones Set (conjunto)

### HashSet
Un Set no puede tener objetos duplicados dentro
No se puede añadir ni extraer por posicion determinada
Lo ordena él por su Hascode,  no lo elegimos nosotros el orden
Cuando se trabaja con Set hay que recorrer toda la coleccion para sacar un dato

Se usa para cuando se quiere almacenar y no hace falta tener un orden

## ITERATOR
Metodos:
.next() --> Se posiciona en el siguiente elemento
.hasNext() --> Dice si tiene elemento siguiente

# BBDD

## Map<K,V>

Un Map<K,V> una estructura de datos que permite almacenar pares clave-valor. Es decir, cada valor que se guarda en un Map<K,V> está asociado a una clave única, y puedes acceder al valor proporcionando esa clave.

La interfaz Map no tiene herencia.

La primera clase Map que vamos a ver es HashMap y posteriormente veremos LinkedHashMap

Métodos de mapas:

## put()
Agrega un par clave-valor. Si la clave ya existe, reemplaza su valor anterior
Map<String,Persona> madrid = new HashMap<>();

Persona p = new Persona("123A", "Jose");

madrid.put(p.getDni, p); 

- put devuelve null si la clave no existía.
    
- Si la clave ya existía, devuelve el valor anterior asociado a esa clave.

Aquí tienes la nota para el método get en el mismo formato:


## get()  
Obtiene el valor asociado a una clave. Si la clave no existe, devuelve null.
Map<String, Persona> madrid = new HashMap<>();

Persona p = new Persona("123A", "Jose");

madrid.put(p.getDni(), p);

Persona resultado = madrid.get("123A");

- get devuelve el valor asociado a la clave si existe.
    
- Si la clave no está presente en el mapa, devuelve null.

## keySet()   
Devuelve un conjunto (`Set<K>`) con todas las claves contenidas en el mapa.
Set<String> keys = madrid.keySet();

for (String key : keys) {
   System.out.println("Clave: " + key);
}

- keySet permite iterar solo sobre las claves del mapa.
- El conjunto resultante está vinculado al mapa: cambios en uno afectan al otro.

## values()
Devuelve una colección (`Collection<V>`) con todos los valores contenidos en el mapa.
Collection<Persona> valores = madrid.values();

for (Persona persona : valores) {
   System.out.println("Persona: " + persona.getNombre());
}

- values permite iterar solo sobre los valores del mapa.
- La colección resultante está vinculada al mapa: cambios en uno afectan al otro.

## **entrySet()**
Devuelve un conjunto (`Set<Entry<K, V>>`) con todas las entradas (pares clave-valor) contenidas en el mapa.
Set<Entry<String, Persona>> entries = madrid.entrySet();

for (Entry<String, Persona> entry : entries) {
    System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue().getNombre());
}

- entrySet permite iterar sobre pares clave-valor completos.
- El conjunto resultante está vinculado al mapa: cambios en uno afectan al otro.

## **remove()**
Elimina un par clave-valor del mapa según la clave.
Persona p = new Persona("123A", "Jose");
madrid.put(p.getDni(), p);

madrid.remove("123A");

- remove(Object key) elimina la entrada con la clave especificada.
    
- Devuelve el valor asociado a la clave eliminada, o null si no existía.

## Entry
Representa un par clave-valor dentro de un mapa.
mapa.put("A", 1);
mapa.put("B", 2);

for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
    System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
}

- Entry permite acceder simultáneamente a la clave y su valor asociado.
    
- Es útil para recorrer mapas y modificar valores directamente con setValue().

## isEmpty
Indica si el mapa está vacío (sin pares clave-valor).boolean vacio = madrid.isEmpty();
System.out.println("¿Mapa vacío? " + vacio);
- Devuelve true si no hay elementos en el mapa.
    - [ ] 
- Devuelve false si contiene al menos un par clave-valor.

## **containsKey**
Verifica si una clave existe en el mapa.madrid.put("123A", new Persona("123A", "Jose"));

boolean existe = madrid.containsKey("123A");
System.out.println("¿Existe clave 123A? " + existe);
- Devuelve true si la clave está presente.
 
- Devuelve false si la clave no existe.

## containsValue
Verifica si un valor existe en el mapa.Persona p = new Persona("123A", "Jose");
madrid.put(p.getDni(), p);

boolean existe = madrid.containsValue(p);
System.out.println("¿Existe valor? " + existe);
- Devuelve true si el valor está presente (según `equals()`).
- Devuelve false si el valor no existe en el mapa.

